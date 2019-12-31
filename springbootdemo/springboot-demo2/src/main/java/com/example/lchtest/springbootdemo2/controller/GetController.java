package com.example.lchtest.springbootdemo2.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetController {
    @RequestMapping("/test/getName")
    @ResponseBody
    public  String test(){
        return "hello";
    }
}
