package com.example.lchtest.springbootdemo2.controller;

import com.example.lchtest.springbootdemo2.domain.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @RequestMapping("/testExceptoin")
    @ResponseBody
    public Object index(){
        int i=1/0;
        return "testExceptoin";
    }

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
