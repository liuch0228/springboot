package com.example.lchtest.springbootdemo2.domain;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理类
 * 注意，如果是过滤器里面发生了异常，这里是捕获不到的
 */
@ControllerAdvice
public class CustomExceptionHandler {

    /**
     * Exception异常处理类
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public  Object handleException(Exception e, HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", e.getMessage());
        map.put("url", request.getRequestURL());
        return map;
    }

    /**
     * 自定义异常处理类
     * @param e
     * @return 逻辑视图名，sringboot解析后跳转到错误处理页面error500.html
     */
    @ExceptionHandler(value = MyException.class)
    public  Object handleException(MyException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error500");
        modelAndView.addObject("msg", e.getMsg());
        return modelAndView;
    }

}
