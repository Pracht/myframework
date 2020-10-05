package com.example.myframework;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.example.myframework.dao"})
public class MyframeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyframeworkApplication.class, args);
    }

}
