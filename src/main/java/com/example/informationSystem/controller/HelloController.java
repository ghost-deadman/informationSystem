package com.example.informationSystem.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zzx
 * @version 1.0
 * @project informationSystem
 * @ClassName: HelloController
 * @date 2022/9/13 21:28
 * @Description: Spring Security 测试接口
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    @PreAuthorize("hasAuthority('sys:book:list')")
    public String hello(){
        return "hello";
    }
}
