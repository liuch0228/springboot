package com.example.aoplogback.pojo;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class User {
    @NotBlank(message = "用户名不能为空")
    private String name;
    @Length(min = 10, max = 300, message = "地址长度必须在10-300之间")
    private String address;
    @Max(value = 70, message = "年龄必须小于70")
    @Min(value = 18, message = "年龄必须大于18")
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
