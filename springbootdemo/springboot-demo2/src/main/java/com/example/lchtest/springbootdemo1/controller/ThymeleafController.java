package com.example.lchtest.springbootdemo1.controller;

import com.example.lchtest.springbootdemo1.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    /**
     * 单独测试thymeleaf模板引擎，将配置文件thymeleaf相关配置项打开
     * http://localhost:8080/thymeleaf/hello
     */
    @Autowired
    private Person person;
    @GetMapping("/hello")
    public String index (ModelMap modelMap){
        System.out.println("跳转到templates/tl/info.html页面,person = " + person);
        modelMap.addAttribute("person", person);
        return "tl/info";
    }
}
