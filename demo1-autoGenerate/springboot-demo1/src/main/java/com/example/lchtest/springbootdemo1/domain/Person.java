package com.example.lchtest.springbootdemo1.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 配置读取类
 * 要求：1. 属性名要和配置项中的名称一致 2.要有getter setter
 * 这里实现序列化接口是因为controller中要返回json数据给浏览器
 */
// 声明这是spring的一个组件
@Component
// 要读取的配置文件的位置
@PropertySource("classpath:properties/person.properties")
// 配置项的前缀
@ConfigurationProperties(prefix = "person")
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
