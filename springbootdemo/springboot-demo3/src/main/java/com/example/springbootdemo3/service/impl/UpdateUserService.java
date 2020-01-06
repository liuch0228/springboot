package com.example.springbootdemo3.service.impl;

import com.example.springbootdemo3.domain.User;
import com.example.springbootdemo3.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 更新用户
 * Propagation.REQUIRES_NEW:
 * 新建事务，如果当前存在事务，把当前事务挂起, 两个事务之间没有关系，一个异常，一个提交，不会同时回滚
 * 如果调用当前方法的service中开启了事务，这里的事务跟调用者的事务没有关系
 *
 */
@Service
//@Transactional(propagation = Propagation.REQUIRES_NEW)
public class UpdateUserService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 测试事务嵌套—— 被调用方法开启新的事务：外层异常不影响这里
     * @param user
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUser(User user){
        userMapper.update(user);
        //如果这个被调用的方法中有异常，则调用的地方和这里都会回滚，如果是调用的地方有异常，这里执行没有异常，则仅仅是调用的方法中的事务会回滚
//        int i = 1/0;
    }
}
