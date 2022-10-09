package com.example.informationSystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.User;
import com.example.informationSystem.mapper.UserMapper;
import com.example.informationSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/10/9 14:42
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean addUser(User user) {

        //密码加密
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        return userMapper.insert(user) > 0;

    }

    @Override
    public boolean updateUserPassword(String userId, String password) {

        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();

        userUpdateWrapper.set("password",password);

        userUpdateWrapper.eq("id",userId);

        return userMapper.update(null,userUpdateWrapper) > 0;

    }

    @Override
    public User selectUserInfo(String userId) {

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();

        userQueryWrapper.eq("id",userId);

        return userMapper.selectOne(userQueryWrapper);

    }

    @Override
    public boolean deleteUserBatch(List<String> userIdList) {

        userMapper.deleteBatchIds(userIdList);

        return true;

    }

    @Override
    public boolean updateUserInfo(User user) {

        userMapper.updateById(user);

        return true;

    }

    @Override
    public IPage<User> selectUserPage(long current,long size) {

        IPage<User> userPage = new Page<>(current,size);

        userMapper.selectPage(userPage,null);

        return userPage;

    }
}
