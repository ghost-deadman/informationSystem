package com.example.informationSystem.service.Impl;

import com.example.informationSystem.entity.DTO.RoleDTO;
import com.example.informationSystem.mapper.RoleMapper;
import com.example.informationSystem.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleDTO> getRolesByUnitId(String unitId) {
        List<RoleDTO> roleByUnitId = roleMapper.getRoleByUnitId(unitId);
        if (roleByUnitId != null && roleByUnitId.size() > 1) {
            roleByUnitId.remove(0);
        }
        return roleByUnitId;
    }

    @Override
    public List<RoleDTO> getAllRoles() {
        return roleMapper.getAllRoles();
    }
}
