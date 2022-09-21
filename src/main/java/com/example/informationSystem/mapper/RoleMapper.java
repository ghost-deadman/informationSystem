package com.example.informationSystem.mapper;

import com.example.informationSystem.entity.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
    /**
     * 通过用户id查询角色
     * @param id 用户id
     * @return 用户角色
     */
    List<Role> getRoles(Long id);
}
