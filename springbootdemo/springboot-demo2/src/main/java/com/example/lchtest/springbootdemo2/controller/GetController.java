package com.example.lchtest.springbootdemo2.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GetController {
    @RequestMapping("/test/getName")
    @ResponseBody
    public  String test(){
        System.out.println("********* 请求处理中 *********");
        return "hello";
    }
}
