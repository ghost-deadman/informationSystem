package com.example.informationSystem.controller;

import com.example.informationSystem.entity.DTO.RoleDTO;
import com.example.informationSystem.service.LoginService;
import com.example.informationSystem.service.RoleService;
import com.example.informationSystem.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private LoginService loginService;

    @GetMapping("/role/unit")
    public Result getRolesOfUnit() {
        String unitId = loginService.getUserUnitId();
        List<RoleDTO> roles = roleService.getRolesByUnitId(unitId);
        return Result.success("查询成功", roles);
    }

    @GetMapping("/role/all")
    public Result getAllRoles() {
        List<RoleDTO> roles = roleService.getAllRoles();
        return Result.success("查询成功", roles);
    }

}
