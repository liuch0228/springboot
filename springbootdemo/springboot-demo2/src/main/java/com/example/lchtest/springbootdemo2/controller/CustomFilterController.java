package com.example.lchtest.springbootdemo2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录控制器：用于测试自定过滤器和自定义拦截器
 * 自定义过滤器对/api/*的请求进行处理
 * 自定义拦截器对api2/*的请求进行拦截处理
 */
@RestController
public class CustomFilterController {

    /**
     * 自定义过滤器测试
     * http://localhost:8080/api/testFilter?username=test 直接返回，改变username的值，则返回login.html
     * @param username
     * @return
     */
    @GetMapping("/api/testFilter")
    public String testFilter(@RequestParam("username") String username){
        System.out.println("username=" + username);
        return "testFilter Success";
    }

    /**
     * 自定义拦截器测试
     *  http://localhost:8080/api2/testInterceptor?username=test2 username改为其他值，返回{errMsg=user unAuthorized, retCode=401}
     * @param username
     * @return
     */
    @GetMapping("/api2/testInterceptor")
    public String testInterceptor(@RequestParam("username") String username){
        System.out.println("username=" + username);
        return "testInterceptor Success";
    }

    /**
     * 自定义拦截器，不管controlelr中有无异常，拦截器中的afterCompletion方法都会执行
     * http://localhost:8080/api2/testException?username=test2 
     * @param username
     * @return
     */
    @GetMapping("/api2/testException")
    public String testInterceptor2(@RequestParam("username") String username){
        System.out.println("username=" + username);
        int i = 1/0;
        return "testInterceptor Success";
    }
    /**
     * *********requestInitialized *********
     * 2020-01-01 14:15:57.217  INFO 12208 --- [nio-8080-exec-1] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring DispatcherServlet 'dispatcherServlet'
     * 2020-01-01 14:15:57.217  INFO 12208 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Initializing Servlet 'dispatcherServlet'
     * 2020-01-01 14:15:57.219  INFO 12208 --- [nio-8080-exec-1] o.s.web.servlet.DispatcherServlet        : Completed initialization in 2 ms
     * 自定义拦截器 preHandle
     * username=test2
     * 2020-01-01 14:15:57.278  WARN 12208 --- [nio-8080-exec-1] .m.m.a.ExceptionHandlerExceptionResolver : Resolved [java.lang.ArithmeticException: / by zero]
     * 自定义拦截器 afterCompletion
     * *********requestDestroyed *********
     */
}
