package com.example.informationSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.example.informationSystem.mapper")
@EnableSwagger2
public class InformationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(InformationSystemApplication.class, args);
    }

}
