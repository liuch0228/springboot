package com.lch.springboot04.domain;

import javax.persistence.*;

/**
 * 实体类映射数据库表
 */
@Entity
@Table(name="user_test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //hibernate选择主键策略
    private Long id;

    @Column(nullable = false)
    private String password;
    //name="username" 设置userName属性映射到数据库的username字段，而不是默认的user_name
    @Column(name = "username", nullable = false)
    private String userName;

    @Column(nullable = false)
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public User() {
    }

    public User(String password, String userName, int age) {
        this.password = password;
        this.userName = userName;
        this.age = age;
    }
}
