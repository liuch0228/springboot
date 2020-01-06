package com.example.springbootdemo3.service;

import com.example.springbootdemo3.domain.User;

public interface UserService {
    Integer  addUser(User user);

    void updateUser(User user);
}
