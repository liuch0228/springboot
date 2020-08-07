package com.example.springbootdemo4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// @EnableScheduling注解开启定时任务
//@EnableScheduling
// 开启异步任务：@EnableAsync会把一个类标记为异步类
@EnableAsync
public class Demo4Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo4Application.class, args);
    }
}
