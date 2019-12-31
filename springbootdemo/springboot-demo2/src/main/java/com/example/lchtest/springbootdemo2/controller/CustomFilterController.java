package com.example.lchtest.springbootdemo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomFilterController {

    @GetMapping("/api/testFilter")
    public String testFilter(@RequestParam("username") String username){
        System.out.println("username=" + username);
        return "testFilter Success";
    }
}
