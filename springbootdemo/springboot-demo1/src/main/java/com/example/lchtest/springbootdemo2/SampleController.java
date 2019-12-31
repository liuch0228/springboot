package com.example.lchtest.springbootdemo2;

import com.example.lchtest.springbootdemo2.domain.Person;
import com.example.lchtest.springbootdemo2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
// 不是application.properties中的配置项，要使用@Value注解读取配置值的时候，需要指出配置项的类路径
@PropertySource("classpath:properties/test.properties")
public class SampleController {


    @Autowired
    private Person person;

    /**
     * 写在application.properties中的配置项，直接使用@value注解获取值
     */
    @Value("${person.hobby}")
    private String hobby;

    @Value("${test.person.name}")
    private String name;

    /**
     * 测试自定义配置文件读取
     * @return
     */
    @RequestMapping("/testproperties")
    @ResponseBody
    public Object test(){
        System.out.println("resources/application.properties 配置项值：" + hobby);
        System.out.println("resources/properties/test.properties 配置项值：" + name);
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
