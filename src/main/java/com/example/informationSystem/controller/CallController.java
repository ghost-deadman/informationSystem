package com.example.informationSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallController {

    @GetMapping("/call")
    public String hello(){
        return "call";
    }
}
