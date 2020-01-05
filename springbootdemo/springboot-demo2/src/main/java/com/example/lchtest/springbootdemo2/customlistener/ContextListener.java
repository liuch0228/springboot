package com.example.lchtest.springbootdemo2.customlistener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 自定义ServletContextListener监听器
 * 可以在应用初始化的时候做一些资源加载之类的操作，如单独开启一个线程连接redis等
 */
@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("*********contextInitialized *********");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("*********contextDestroyed *********");
    }
}
