package com.example.springbootdemo3.service.impl;

import com.example.springbootdemo3.domain.User;
import com.example.springbootdemo3.mapper.UserMapper;
import com.example.springbootdemo3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserServiceImpl implements UserService {
//    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer addUser(User user) {
//        return userMapper.insert(user);
        return 1;
    }

    @Override
    public void updateUser(User user) {
//        userMapper.update(user);
    }
}
