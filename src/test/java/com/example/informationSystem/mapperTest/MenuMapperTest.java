package com.example.informationSystem.mapperTest;

import com.example.informationSystem.entity.Menu;
import com.example.informationSystem.entity.Role;
import com.example.informationSystem.mapper.MenuMapper;
import com.example.informationSystem.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MenuMapperTest {
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;

    /**
     *  测试通过用户id获取用户权限菜单的方法
     *  测试输入： long类型  用户id
     *  测试输出： List<String>类型 用户的权限菜单或null
     *  测试结果： pass
     *
     */
    @Test
    public void testGetMenu() {
        List<Menu> strings = menuMapper.getMenusByUserId("1");
        if (strings != null)
            for (Menu string : strings) {
                System.out.println(string.getEnabled());
            }
        System.out.println("123");
    }

    @Test
    public void testGetMenuRole() {
        menuMapper.getMenusByRole();
    }


    @Test
    public void testRole() {
        List<Role> roles = roleMapper.getRoles("1");
        for (Role role : roles) {
            System.out.println(role.getEnabled());
        }
    }
}
