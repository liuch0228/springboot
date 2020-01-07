package com.example.springbootdemo3.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类
 */
public class User implements Serializable {
    private int id;
    private String name;
    private  String phone;
    private  int age;
    // 指定序列化时的格式和时区，如果不指定时区，反列化之后的时间会比设置的时间慢8小时
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public User(){
        super();
    }

    public User(int id, String name, String phone, int age, Date createTime) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
