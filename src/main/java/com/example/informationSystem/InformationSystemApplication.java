package com.example.informationSystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author pcdn
 */
@MapperScan("com.example.informationSystem.mapper")
@SpringBootApplication
public class InformationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(InformationSystemApplication.class, args);
    }

}
