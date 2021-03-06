package com.example.lchtest.springbootdemo1.controller;

import com.example.lchtest.springbootdemo1.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freemarker")
public class FreemarkerController {


    @Autowired
    private Person person;
    @GetMapping("/hello")
    public String index (ModelMap modelMap){
        System.out.println("跳转到freemarker页面,person = " + person);
        modelMap.addAttribute("person", person);
        return "fm/index";
    }
}
