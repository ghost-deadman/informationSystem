package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.informationSystem.entity.User;

import java.util.List;

/**
 * @author ：ghost
 * @date ：Created in 2022/10/9 14:41
 */
public interface UserService {

    /**
     * 添加用户
     * @param user 用户对象
     * @return 是否成功
     */
    boolean addUser(User user);

    /**
     * 用户修改密码
     * @param userId 用户id
     * @param password 密码
     * @return 是否成功
     */
    boolean updateUserPassword(String userId, String password);

    /**
     * 用户查看自己的用户信息
     * @param userId 用户id
     * @return 用户对象
     */
    User selectUserInfo(String userId);

    /**
     * 管理员批量删除账号
     * @param userIdList 账号id数组
     * @return 是否成功
     */
    boolean deleteUserBatch(List<String> userIdList);

    /**
     * 更新用户信息
     * @param user 用户对象
     * @return 是否成功
     */
    boolean updateUserInfo(User user);

    /**
     * 查询所有账号信息
     * @param size 每页大小
     * @param current 页数
     * @return 账号分页对象
     */
    IPage<User> selectUserPage(long current,long size);
}
