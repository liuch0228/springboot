package com.example.springbootdemo3.controller;

import com.example.springbootdemo3.domain.User;
import com.example.springbootdemo3.service.UserService;
import com.example.springbootdemo3.service.impl.UpdateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class UserController {

//    @Autowired
    private UserService userService;

//    @Autowired
    UpdateUserService updateUserService;

    @RequestMapping("/add")
    @ResponseBody
    public Object addUser() {
        User user = new User();
        user.setAge(18);
        user.setName("lucy");
        user.setPhone("18659996306");
        user.setCreateTime(new Date());
        userService.addUser(user);
        // 获取本次插入数据的自增id
        return "当前插入的数据在数据库中的自增id值为：" + user.getId();
    }


    /**
     * mysql单机事务测试 ：4种隔离级别，6种传播机制
     * MySQL事务默认隔离级别：read commit
     * mysql默认事务传播机制 ：REQUIRED
     *
     * @return
     */
    @RequestMapping("/testTransaction")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Object testTransaction() {
        User user = new User();
        user.setAge(19);
        user.setName("lucy");
        user.setPhone("18659996306");
        user.setCreateTime(new Date());
        userService.addUser(user);
        int i = 1 / 0;
        return "success";
    }

    /**
     * 事务嵌套测试：  在同一个servcie中的两个方法，不论事务的传播机制选的是什么，只要有一个方法中抛出了异常，
     * 相关调用的方法都会进行回滚！这里 testTransactions 或者updateUser方法中，有一个方法抛异常，整个方法都会进行回滚
     * 因为同一个service中，spring只会开启一个事务！！！要想测试REQUIRES_NEW，需要将被调用方法写在单独的service中
     * @return
     */
    @RequestMapping("/testTransaction1")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Object testTransactions() {
        User user = new User();
        user.setAge(19);
        user.setName("lucy");
        user.setPhone("18659996306");
        user.setCreateTime(new Date());
        userService.addUser(user);
        this.updateUser();
        int i = 1/0;
        return "success";
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateUser(){
        User user = new User();
        user.setName("testTransactional");
        user.setId(9);
        userService.updateUser(user);
//        int i = 1/0;
    }

    /**
     * 测试跨service 事务嵌套
     * testTransaction2方法传播机制为REQUIRED，updateUserService.updateUser(user1)方法的事务传播机制为REQUIRES_NEW
     * 当testTransaction2方法中抛出异常，不影响updateUser方法，updateUser正常执行
     * 内层方法updateUser抛出异常，内层方法和外层方法一起回滚！
     * 参考： https://www.bbsmax.com/A/kvJ36Dknzg/
     * @return
     */
    @RequestMapping("/testTransaction2")
    @ResponseBody
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
    public Object testTransaction2() {
        User user = new User();
        user.setAge(20);
        user.setName("jack");
        user.setPhone("18659996306");
        user.setCreateTime(new Date());
        userService.addUser(user);
        User user1 = new User();
        user1.setId(9);
        user1.setName("testTransaction2");
        updateUserService.updateUser(user1);
//        int i = 1/0;
        return "success";
    }


}
