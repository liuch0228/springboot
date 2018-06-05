package com.lch.springboot04.service;

import com.lch.springboot04.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<Map<String, Object>> getAll() {
        String sql = "select * from user";
        return userRepository.listMapBySql(sql);
    }

}
