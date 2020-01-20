package com.example.springbootdemo6.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestMultiEnvironment {

    @Value("${enviromment.url}")
    private String enviromment;
    @RequestMapping("/testenv")
    public String getEnv(){
        return enviromment;
    }

}
