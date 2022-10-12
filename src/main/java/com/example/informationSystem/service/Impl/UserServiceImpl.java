package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.DTO.UserDTO;
import com.example.informationSystem.entity.User;
import com.example.informationSystem.entity.UserRole;
import com.example.informationSystem.entity.VO.UserVO2;
import com.example.informationSystem.mapper.UserMapper;
import com.example.informationSystem.mapper.UserRoleMapper;
import com.example.informationSystem.service.LoginService;
import com.example.informationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author ：ghost
 * @date ：Created in 2022/10/9 14:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LoginService loginService;

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Override
    public boolean addUser(UserVO2 user) {
        User user2 = new User();
        String id = UUID.randomUUID().toString();
        //密码加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user2.setId(id);
        user2.setUserName(user.getUserName());
        user2.setCreateBy(loginService.getUserId());
        user2.setCreateTime(LocalDateTime.now());
        user2.setEmail(user2.getEmail());
        user2.setNickName(user2.getNickName());
        user2.setPhonenumber(user.getPhoneNumber());
        user2.setSex(user.getSex());
        user2.setEnabled(user.getEnable());
        List<String> roles = user.getRole();
        if (roles != null && !roles.isEmpty()) {
            for (String role : roles) {
                userRoleMapper.insert(new UserRole(id, role));
            }
        }

        return userMapper.insert(user2) > 0;
    }

    @Override
    public boolean updateUserPassword(String userId, String oldPassword,String newPassword) {

        //确认老密码是否正确
        String password = userMapper.getPasswordByUserId(userId);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        if(bCryptPasswordEncoder.matches(oldPassword,password)) {

            UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();

            String newEachPassword = bCryptPasswordEncoder.encode(newPassword);

            userUpdateWrapper.set("password", newEachPassword);

            userUpdateWrapper.eq("id", userId);

            return userMapper.update(null, userUpdateWrapper) > 0;

        }

        return false;
    }

    /**
     * 获取某个部门的所有用户
     *
     * @param current 分页
     * @param size    大小
     * @param unitId  部门id
     * @return 分页结果
     */
    @Override
    public Page<UserDTO> getUsersByUnit(Integer current, Integer size, String unitId) {
        Page<UserDTO> iPage = new Page<>(current, size);
        return userMapper.getUsersByUnitId(iPage, unitId);
    }

    @Override
    public boolean updateUserInfo(User user) {

        userMapper.updateById(user);

        return true;

    }

    @Override
    public IPage<User> selectUserPageByUnit(String unitId, String userId, long current, long size) {
        return null;
    }

    /**
     * 启用用户账号
     *
     * @param userId 用户id
     * @return 结果
     */
    @Override
    public boolean enableUser(String userId) {
        return userMapper.enableUser(userId) > 0;
    }

    /**
     * 禁用用户账号
     *
     * @param userId 用户id
     * @return 结果
     */
    @Override
    public boolean unEnableUser(String userId) {
        return userMapper.unEnableUser(userId) > 0;
    }

}
