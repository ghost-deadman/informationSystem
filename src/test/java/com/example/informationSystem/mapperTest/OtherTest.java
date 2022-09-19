package com.example.informationSystem.mapperTest;

import com.example.informationSystem.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class OtherTest {
    /**
     * 测试BCrypt密码加密功能
     */
    @Test
    public void testBCryptPasswordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encode = passwordEncoder.encode("123456");
        System.out.println(encode);
        String encode1 = passwordEncoder.encode("1234");
        System.out.println(encode1);
        boolean b = passwordEncoder.matches("1234", encode);
        System.out.println(b);
        boolean b1 = passwordEncoder.matches("1234", encode1);
        System.out.println(b1);
    }

    /**
     * 测试jwt加密生成token和解密获取id功能
     */
    @Test
    public void testJwtEncoder() throws Exception {
//        String jwt = JwtUtil.createJWT("1234");
//        System.out.println(jwt);
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMWY3MjJmYTMxODI0MzVkYmQwY2Y5YjVkMWU3NWRjMSIsInN1YiI6IjIiLCJpc3MiOiJzZyIsImlhdCI6MTY2MzE0MzMxNCwiZXhwIjoxNjYzMTQ2OTE0fQ.6kVqIMk75HidE67mXkAX6rW3jUiRIBz-6LnvjHCDLhI";
        Claims claims = JwtUtil.parseJWT(jwt);
        System.out.println(claims.getSubject());
    }

}
