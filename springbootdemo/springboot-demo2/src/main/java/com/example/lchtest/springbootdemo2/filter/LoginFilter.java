package com.example.lchtest.springbootdemo2.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义过滤器
 * (1)@WebFilter注解标记一个类为filter,并被spring进行扫描
 * (2)主启动类上面加一个@ServletComponentScan注解，进行扫描
 * (3) 非前后端分离项目适用，前后端分离项目，可以使用拦截器
 * (4) 拦截器和过滤器区别：最明显的区别：过滤器可以过滤所有资源，拦截器只能拦截请求！
 */
//@WebFilter(urlPatterns = "/*",filterName = "loginFilter")  // urlPatterns如果是配置成/*则是拦截所有请求
@WebFilter(urlPatterns = "/api/*",filterName = "loginFilter")
public class LoginFilter implements Filter {
    /**
     *
     * @param filterConfig 过滤器配置
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("自定义过滤器执行doFilter逻辑.");
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String username = req.getParameter("username");
        if(username.equals("test")){
            filterChain.doFilter(req, resp);
        } else {
            // 使用response.sendRedirect,login.html放在resources/static下面才可以，放到templates目录下不行，使用modelAnaView返回逻辑视图名可以跳到templates目录下，why??
            resp.sendRedirect("/login.html");
        }

    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter destroy");
    }

}
