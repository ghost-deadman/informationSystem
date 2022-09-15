package com.example.informationSystem.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallController {

    @RequestMapping("/call")
    public String hello(){
        return "call";
    }
}
