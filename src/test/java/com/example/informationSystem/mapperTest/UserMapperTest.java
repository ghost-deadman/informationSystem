package com.example.informationSystem.mapperTest;

import com.example.informationSystem.entity.Role;
import com.example.informationSystem.entity.User;
import com.example.informationSystem.mapper.RoleMapper;
import com.example.informationSystem.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

/**
 */
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    @Test
    public void testBCryptPasswordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
        String encode1 = passwordEncoder.encode("1234");
        System.out.println(encode1);

    }

    @Test
    public void TestRole() {
        List<Role> roles = roleMapper.getRoles("123456");
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void testUnit() {
//        List<UserDTO> usersByUnitId = userMapper.getUsersByUnitId("1");
//        for (UserDTO userDTO : usersByUnitId) {
//            System.out.println(userDTO);
//        }
    }
}


