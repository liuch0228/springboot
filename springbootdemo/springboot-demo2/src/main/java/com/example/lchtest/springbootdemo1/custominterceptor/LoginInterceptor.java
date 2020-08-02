package com.example.lchtest.springbootdemo1.custominterceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 自定义拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 进入controller方法之前
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("自定义拦截器 preHandle");
        // 拦截器业务处理逻辑
        String username = request.getParameter("username");
        if("test2".equals(username)){
            return true;
        } else {
            PrintWriter writer = response.getWriter();
            String result = "{\"errMsg\":\"user unAuthorized\", \"retCode\":\"401\"}";
            writer.print(result);
            writer.flush();
            writer.close();
            return false;
        }

    }

    /**
     * 调用完controller执行,视图渲染之前，如果controller中出现异常，postHandle不会被执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("自定义拦截器 postHandle");
    }

    /**
     * 整个controller完成之后；不管有没有异常，afterCompletion都会被调用，通常用于资源清理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("自定义拦截器 afterCompletion");
    }
}
