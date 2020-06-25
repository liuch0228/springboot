package com.example.aoplogback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * springboot+ logback + aop记录操作日志，请求参数校验结果
 * 参考：https://www.cnblogs.com/zhangjianbing/p/8992897.html
 *https://blog.csdn.net/qq_25125327/article/details/96148999?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.nonecase
 */
@SpringBootApplication
public class AopTest {

    public static void main(String[] args) {
        SpringApplication.run(AopTest.class,args);
    }
}
