package com.example.informationSystem.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/Build/Project/Insert/test")
    public String test() {
        return "test";
    }
}
