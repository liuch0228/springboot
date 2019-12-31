package com.example.lchtest.springbootdemo2.customservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *  Servlet3.20注解实现原生servelt
 *  主类上面需要加上@ServletComponentScan注解
 *
 */
@WebServlet(name="userServlet",urlPatterns = "/test/servlet")
public class UserServlet extends HttpServlet {


    // http://localhost:8080/test/servlet浏览器输入该请求，将会被doget方法处理
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.print("custom servlet");
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
