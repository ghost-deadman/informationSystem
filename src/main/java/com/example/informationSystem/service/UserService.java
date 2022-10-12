package com.example.informationSystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.DTO.UserDTO;
import com.example.informationSystem.entity.User;
import com.example.informationSystem.entity.VO.UserVO2;

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
    boolean addUser(UserVO2 user);

    /**
     * 用户修改密码
     * @param userId 用户id
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 是否成功
     */
    boolean updateUserPassword(String userId, String oldPassword,String newPassword);

    /**
     * 获取某个部门的所有用户
     * @param current 分页
     * @param size 大小
     * @param unitId 部门id
     * @return 分页结果
     */
    Page<UserDTO> getUsersByUnit(Integer current, Integer size, String unitId);
    /**
     * 更新用户信息
     * @param user 用户对象
     * @return 是否成功
     */
    boolean updateUserInfo(User user);


    IPage<User> selectUserPageByUnit(String unitId, String userId, long current, long size);

    /**
     * 启用用户账号
     * @param userId 用户id
     * @return 结果
     */
    boolean enableUser(String userId);

    /**
     * 禁用用户账号
     * @param userId 用户id
     * @return 结果
     */
    boolean unEnableUser(String userId);
}
