package com.example.informationSystem.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/Build/Project/Insert/test")
    public String test() {
        return "test";
    }
}
