package com.lchtest.spirngbootautoconfigprinciple.demo3;


import com.lchtest.spirngbootautoconfigprinciple.demo02.OtherClass;
import com.lchtest.spirngbootautoconfigprinciple.demo1.HelloService;
import com.lchtest.spirngbootautoconfigprinciple.demo1.SpringConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
@EnableDefineService  // 启用TestService的注入
@SpringBootApplication
public class BootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootStrap.class);
        TestService bean = context.getBean(TestService.class);
        System.out.println(bean);

    }
}
