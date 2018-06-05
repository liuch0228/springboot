package com.lch.springboot04.controller;

import com.lch.springboot04.service.UserService;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/index")
    public String index(){
        return "success";
    }
    @RequestMapping("/getall")
    public String getAll(){
        List<Map<String, Object>> users = userService.getAll();
        return JSONArray.fromObject(users).toString();
    }

}
