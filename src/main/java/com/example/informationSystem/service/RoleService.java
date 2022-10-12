package com.example.informationSystem.service;

import com.example.informationSystem.entity.DTO.RoleDTO;

import java.util.List;

public interface RoleService {
    List<RoleDTO> getRolesByUnitId(String unitId);

    List<RoleDTO> getAllRoles();
}
