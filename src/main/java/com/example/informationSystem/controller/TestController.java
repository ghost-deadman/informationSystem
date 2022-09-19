package com.example.informationSystem.controller;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    @PreAuthorize("hasAuthority('sys:book:delete')")
    public String test() {
        return "test";
    }
}
