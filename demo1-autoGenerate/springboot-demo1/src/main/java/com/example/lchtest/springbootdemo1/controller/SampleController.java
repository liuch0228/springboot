package com.example.lchtest.springbootdemo1.controller;

import com.example.lchtest.springbootdemo1.domain.Person;
import com.example.lchtest.springbootdemo1.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Controller
public class SampleController {


    @Autowired
    private Person person;

    @Value("${person.hobby}")
    private String hobby;

    /**
     * 测试自定义配置文件读取
     * @return
     */
    @RequestMapping("/testproperties")
    @ResponseBody
    public Object test(){
        System.out.println("read properties person.hobby from application.properties:" + hobby);
        return person;
    }

    /**
     * 测试返回json数据时 jackson的各种注解的作用
     * @return
     */
    @RequestMapping("/testJson")
    public @ResponseBody Object testJson(){
        return new User(11,"abc","1111111",new Date());
    }

    /**
     * 视图解析器测试
     * @return
     */
    @RequestMapping("/index")
    public Object idnex(){
        return "index";
    }



}
