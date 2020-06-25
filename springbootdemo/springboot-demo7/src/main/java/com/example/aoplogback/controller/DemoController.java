package com.example.aoplogback.controller;

import com.example.aoplogback.apspect.AppLog;
import com.example.aoplogback.exception.CustomException;
import com.example.aoplogback.pojo.User;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class DemoController {

    /**
     * 模拟新增用户请求；使用bindingResult,必须在切面中处理完参数校验结果之后调用ProceedingJoinPoint.proceed()方法执行真正的业务逻辑
     * @param user 请求参数,json格式
     * @param bindingResult 参数校验结果，bindingResult必须紧跟在被校验的参数后面,否则无法获得该参数的校验结果
     * @return
     */
    @AppLog(value = "新增用户")  //自定义注解，通过切面记录操作类型
    @PostMapping("/test/saveuser")
    public Object saveuser(@RequestBody @Validated User user, BindingResult bindingResult){
        System.out.println("模拟新增用户");
        return user;
    }

    @AppLog(value = "测试全局异常处理")  //自定义注解，通过切面记录操作类型
    @GetMapping("/test/globalexception")
    public Object testGloablException(){
        int i = 1/0;
        return "testGloablException.";
    }

    @AppLog(value = "测试自定义异常处理")  //自定义注解，通过切面记录操作类型
    @GetMapping("/test/customerexception")
    public Object testCustomException(){
        try{
            int i = 1/0;
        } catch (Exception e){
            throw new CustomException(500, "divide by zero");
        }
        return "testCustomException.";
    }

}
