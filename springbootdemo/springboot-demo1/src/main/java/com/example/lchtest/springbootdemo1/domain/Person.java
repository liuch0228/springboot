package com.example.lchtest.springbootdemo1.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 配置读取类
 * 要求：1. 属性名要和配置项中的名称一致 2.要有getter setter
 */

@Component  // 声明这是spring的一个组件
@PropertySource("classpath:properties/person.properties")  // 要读取的配置文件的位置
@ConfigurationProperties(prefix = "test.person")   // 配置项的前缀
public class Person {
    private String name;
    private int age;
    private  String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
