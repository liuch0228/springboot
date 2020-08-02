package com.example.lchtest.springbootdemo1.customlistener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 自定义监听器
 * 常用监听器：ServletRequestListener
 *
 */

@WebListener
public class RequestListener implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("*********requestDestroyed *********");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("*********requestInitialized *********");
    }
}
