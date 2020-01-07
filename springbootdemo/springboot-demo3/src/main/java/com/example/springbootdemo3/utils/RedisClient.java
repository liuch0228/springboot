package com.example.springbootdemo3.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis工具类：封装redisTemplate
 */
@Component
public class RedisClient {

    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean set(String key,String value){
        try {
            redisTemplate.opsForValue().set(key,value);
            return true;
        } catch (Exception e){
            return false;
        }
    }


    public String get(String key){
        try {
            String value = redisTemplate.opsForValue().get(key);
            return value;
        } catch (Exception e){
            return "";
        }
    }

}
