package com.example.lchtest.springbootdemo2.controller;

import com.example.lchtest.springbootdemo2.domain.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    /**
     * 测试捕获到异常：CustomExceptionHandler对捕获到的Exception.class异常，
     * 返回封装了异常信息的json数据
     * @return
     */
    @RequestMapping("/testExceptoin")
    @ResponseBody
    public Object index(){
        int i=1/0;
        return "testExceptoin";
    }

    /**
     * 测试捕获到自定义异常，跳转到error500.html 页面（thymeleaf模板引擎）
     * http://localhost:8080/testCustomExceptoin
     * @return
     */
    @RequestMapping("/testCustomExceptoin")
    @ResponseBody
    public Object customException(){
        try {
            int i = 1/0;
        } catch (Exception e){
            // 手动抛出自定义异常
            throw new MyException(500, "Devide by zero");
        }
        return "testExceptoin";
    }


}
