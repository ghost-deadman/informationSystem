package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.informationSystem.entity.Role;
import com.example.informationSystem.entity.User;
import com.example.informationSystem.entity.VO.UserVO;
import com.example.informationSystem.mapper.RoleMapper;
import com.example.informationSystem.mapper.UserMapper;
import com.example.informationSystem.service.LoginService;
import com.example.informationSystem.utils.JwtUtil;
import com.example.informationSystem.utils.RedisCache;
import com.example.informationSystem.utils.TestVo;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public Result login(UserVO user, HttpServletRequest request) {

        TestVo<UserVO> vo = new TestVo<>();
        boolean b = vo.voIsFull(user);
        if (!b) {
            return Result.error("信息缺失！，请填完再提交！");
        }
        String username = user.getUserName();
        String password = user.getPassword();
        String code = user.getCode();
        String imgUUID = request.getRemoteAddr();
        StringBuffer url = request.getRequestURL();
        System.out.println("url" + url);

        if (imgUUID == null) {
            return Result.error("验证码已过期，刷新试试！");
        }
        System.out.println("uuid: " + imgUUID);
//        String captcha = (String) request.getSession().getAttribute("captcha");
        String captcha = redisCache.getCacheObject(imgUUID);
        System.out.println("code: " + code + "-----" + captcha);
        // 验证验证码
        if (StringUtils.isEmpty(captcha)) {
            return Result.error("验证码已过期，刷新试试！");
        }
        if (!captcha.equalsIgnoreCase(code)) {
            return Result.error("验证码输入错误，请重新输入！");
        }
        User userDetails = (User) userDetailsService.loadUserByUsername(username);
        boolean flag = false;
        Role role_ = null;
        if (null == userDetails) {
            return Result.error("用户名或密码不正确");
        } else {
            // 验证用户角色
            List<Role> roles = userDetails.getRoles();
            if (roles == null || roles.isEmpty()) {
                return Result.error("账号异常无法登录，请联系管理员");
            } else {
                for (Role role : roles) {
                    if (role.getId().equals(user.getType())) {
                        flag = true;
                        role_ = role;
                        break;
                    }
                }
                if (flag) {
                    // 验证用户角色状态
                        // 验证用户密码
                        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
                            return Result.error("用户名或密码不正确");
                        }
                        // 验证账号状态
                        if (!userDetails.isEnabled()) {
                            return Result.error("账号被禁用，请联系管理员");
                        }

                } else {
                    return Result.error("您的角色有误！");
                }
            }
        }
        //删除验证码
        redisCache.deleteObject(imgUUID);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);

        User loginUser = (User) authenticate.getPrincipal();
        String userId = loginUser.getId();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
        redisCache.setCacheObject("login:" + userId, loginUser, 2, TimeUnit.HOURS);
        //用户当前角色存入redis
        redisCache.setCacheObject("role:" + userId, role_, 2, TimeUnit.HOURS);
        System.out.println(role_);
        //把token响应给前端
        HashMap<String, String> map = new HashMap<>();
        map.put("token", jwt);
        return Result.success("登陆成功", map);
    }

    @Override
    public Result logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loginUser = (User) authentication.getPrincipal();
        String userId = loginUser.getId();
        redisCache.deleteObject("login:" + userId);
        redisCache.deleteObject("menu:" + userId);
        redisCache.deleteObject("role:" + userId);
        return Result.success("退出成功");
    }

    /**
     * 获取当前用户id
     *
     * @return 用户id
     */
    @Override
    public String getUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loginUser = (User) authentication.getPrincipal();
        return loginUser.getId();
    }

    /**
     * 获取用户角色部门id
     *
     * @return 部门id
     */
    @Override
    public String getUserUnitId() {
        String userId = getUserId();
        Role role = redisCache.getCacheObject("role:" + userId);
        System.out.println("role: "+role);
        return role.getUnit_id();
    }

    @Override
    public User getUserInfo(String userName) {
        //根据用户名查询用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, userName);
        User user = userMapper.selectOne(wrapper);
        user.setPassword(null);
        return user;
    }

    @Override
    public List<Role> getRoles(String id) {
        return roleMapper.getRoles(id);
    }


}

