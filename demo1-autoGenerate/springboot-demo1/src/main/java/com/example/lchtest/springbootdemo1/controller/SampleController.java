package com.example.lchtest.springbootdemo1.controller;

import com.example.lchtest.springbootdemo1.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@Controller
public class SampleController {
    @RequestMapping("/testJson")
    public @ResponseBody Object testJson(){
        return new User(11,"abc","1111111",new Date());
    }

    @RequestMapping("/index")
    public Object idnex(){
        return "index";
    }
}
