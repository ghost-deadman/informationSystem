package com.example.informationSystem.service;

import com.example.informationSystem.entity.User;
import com.example.informationSystem.result.ResponseResult;

public interface LoginService {
    /**
     *  登录认证
     * @param user 用户信息
     * @return 认证结果
     */
    ResponseResult login(User user);

    /**
     * 退出登录
     * @return 响应结果
     */
    ResponseResult logout();
}
