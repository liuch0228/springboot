package com.example.lchtest.springbootdemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetController {
    @RequestMapping("/test/getName")
    @ResponseBody
    public  String test(){
        System.out.println("********* 请求处理中 *********");
        return "hello";
    }
}
