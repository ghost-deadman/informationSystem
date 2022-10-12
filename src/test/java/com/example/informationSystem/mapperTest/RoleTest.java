package com.example.informationSystem.mapperTest;

import com.example.informationSystem.entity.DTO.RoleDTO;
import com.example.informationSystem.service.RoleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class RoleTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void testGetByUnit(){
        List<RoleDTO> rolesByUnitId = roleService.getRolesByUnitId("1");
        for (RoleDTO roleDTO : rolesByUnitId) {
            System.out.println(roleDTO);
        }
    }

}
