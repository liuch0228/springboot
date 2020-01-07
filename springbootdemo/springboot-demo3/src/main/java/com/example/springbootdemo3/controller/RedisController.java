package com.example.springbootdemo3.controller;

import com.example.springbootdemo3.domain.User;
import com.example.springbootdemo3.utils.JsonUtils;
import com.example.springbootdemo3.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {
//    @Autowired
//    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisClient redisClient;


    @GetMapping("/set")
    public Object set(){
        redisClient.set("name", "testRedis1");
        return "set ok";
    }

    @GetMapping("/get")
    public Object get(){
//       String value =  redisTemplate.opsForValue().get("name");
       String value = redisClient.get("name");
        return "get ok:" + value;
    }

    @GetMapping("/setUser")
    public Object setObject(){
        User user = new User(1, "tom", "11223336", 18, new Date());
        redisClient.set("base:user:" + user.getId(), JsonUtils.obj2String(user));
        return "set object ok" ;
    }

    @GetMapping("/getUser")
    public Object getObject(){
        String userStr = redisClient.get("base:user:1" );
        User user = JsonUtils.string2Obj(userStr, User.class);
        return  user;
    }
}
