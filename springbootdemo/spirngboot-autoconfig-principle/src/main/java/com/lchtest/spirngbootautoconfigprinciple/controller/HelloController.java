package com.lchtest.spirngbootautoconfigprinciple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 加入spring-boot-starter-data-redis依赖，能够自动注入的前提是，RedisTemplate一定存在与IOC容器中(DI)
    // 解决了Bean的注入问题
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/")
    public  Object index(){
        return "hello springboot.";
    }
}
