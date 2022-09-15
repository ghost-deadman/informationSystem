package com.example.informationSystem.mapperTest;

import com.example.informationSystem.mapper.MenuMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MenuMapperTest {
    @Autowired
    private MenuMapper menuMapper;

    /**
     *  测试通过用户id获取用户权限菜单的方法
     *  测试输入： long类型  用户id
     *  测试输出： List<String>类型 用户的权限菜单或null
     *  测试结果： pass
     *
     */
    @Test
    public void testGetMenu() {
        List<String> strings = menuMapper.selectPermsByUserId(1L);
        if (strings != null)
            for (String string : strings) {
                System.out.println(string);
            }
        System.out.println("123");
    }

}
