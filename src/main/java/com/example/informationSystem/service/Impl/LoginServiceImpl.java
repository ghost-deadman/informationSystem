package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.informationSystem.entity.Role;
import com.example.informationSystem.entity.User;
import com.example.informationSystem.entity.vo.UserVo;
import com.example.informationSystem.mapper.RoleMapper;
import com.example.informationSystem.mapper.UserMapper;
import com.example.informationSystem.service.LoginService;
import com.example.informationSystem.utils.JwtUtil;
import com.example.informationSystem.utils.RedisCache;
import com.example.informationSystem.utils.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class LoginServiceImpl extends ServiceImpl<UserMapper, User> implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public Result login(UserVo user, HttpServletRequest request) {

        String username = user.getUserName();
        String password = user.getPassword();
        String code = user.getCode();
//        String imgUUID = user.getImgUUID();
        String imgUUID = request.getRemoteAddr();
        if (imgUUID == null) {
            return Result.error("验证码已过期，刷新试试！");
        }
        System.out.println("uuid: "+imgUUID);
//        String captcha = (String) request.getSession().getAttribute("captcha");
        String captcha = redisCache.getCacheObject(imgUUID);
        System.out.println("code: " + code + "-----" + captcha);
        if (StringUtils.isEmpty(captcha)) {
            return Result.error("验证码已过期，刷新试试！");
        }
        if (StringUtils.isEmpty(code)  || !captcha.equalsIgnoreCase(code)){
            return Result.error("验证码输入错误，请重新输入！");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null == userDetails ||
                !passwordEncoder.matches(password,userDetails.getPassword())){
            return Result.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()){
            return Result.error("账号被禁用，请联系管理员");
        }
        //删除验证码
        redisCache.deleteObject(imgUUID);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        User loginUser = (User) authenticate.getPrincipal();
        String userId = loginUser.getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisCache.setCacheObject("login:"+userId,loginUser, 2, TimeUnit.HOURS);
        //把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return Result.success( "登陆成功", map);
    }

    @Override
    public Result logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loginUser = (User) authentication.getPrincipal();
        Long userid = loginUser.getId();
        redisCache.deleteObject("login:"+userid);
        redisCache.deleteObject("menu:"+userid);
        return Result.success("退出成功");
    }

    @Override
    public User getUserInfo(String userName) {
        //根据用户名查询用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,userName);
        User user = userMapper.selectOne(wrapper);
        user.setPassword(null);
        return user;
    }

    @Override
    public List<Role> getRoles(Long id) {
        return roleMapper.getRoles(id);
    }


}

