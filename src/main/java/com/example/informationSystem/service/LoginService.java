package com.example.informationSystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.informationSystem.entity.Role;
import com.example.informationSystem.entity.User;
import com.example.informationSystem.entity.vo.UserVo;
import com.example.informationSystem.utils.result.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LoginService extends IService<User> {
    /**
     *  登录认证
     * @param user 用户信息
     * @return 认证结果
     */
    Result login(UserVo user, HttpServletRequest request);

    /**
     * 退出登录
     * @return 响应结果
     */
    Result logout();


    /**
     * 获取当前用户信息
     * @param userName 用户名
     * @return  用户对象
     */
    User getUserInfo(String userName);

    /**
     * 通过用户id查询角色
     * @param id 用户id
     * @return 用户角色
     */
    List<Role> getRoles(Long id);

}
