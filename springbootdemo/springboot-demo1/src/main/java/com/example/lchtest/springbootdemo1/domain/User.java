package com.example.lchtest.springbootdemo1.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class User {
    // 空字段不返回
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private int age;
    //  @JsonIgnore指定的字段不返回
    @JsonIgnore
    private  String pwd;
    @JsonProperty("account")
    private  String phone;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public User(){
        super();
    }
    public User(int age, String pwd, String phone, Date createTime) {
        this.age = age;
        this.pwd = pwd;
        this.phone = phone;
        this.createTime = createTime;
    }
}
