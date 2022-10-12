package com.example.informationSystem.mapper;

import com.example.informationSystem.entity.DTO.RoleDTO;
import com.example.informationSystem.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper {
    /**
     * 通过用户id查询角色
     * @param id 用户id
     * @return 用户角色
     */
    List<Role> getRoles(String id);

    /**
     * 通过部门查询角色
     * @param unitId 部门id
     * @return 角色表
     */
    @Select("SELECT r.id, r.name FROM sys_role r WHERE unit_id = #{unitId} AND enabled = TRUE")
    List<RoleDTO> getRoleByUnitId(String unitId);

    /**
     * 查询所有角色
     * @return 角色表
     */
    @Select("SELECT r.id, r.name FROM sys_role r WHERE enabled = TRUE")
    List<RoleDTO> getAllRoles();
}
