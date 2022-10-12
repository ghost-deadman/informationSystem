package com.example.informationSystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.informationSystem.entity.DTO.UserDTO;
import com.example.informationSystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 通过 用户名获取用户
     * @return 用户信息
     */
    User getOneByUserName(String userName);

    @Select("select password from sys_user where id = #{userId}")
    String getPasswordByUserId(String userId);

    Page<UserDTO> getUsersByUnitId(Page<UserDTO> iPage, String unitId);

    @Update("UPDATE sys_user SET enabled = '1' WHERE id = #{userId}")
    Integer enableUser(String userId);

    @Update("UPDATE sys_user SET enabled = '0' WHERE id = #{userId}")
    Integer unEnableUser(String userId);
}
