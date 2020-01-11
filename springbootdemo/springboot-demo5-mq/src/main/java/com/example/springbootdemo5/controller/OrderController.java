package com.example.springbootdemo5.controller;

import com.example.springbootdemo5.service.ProducerService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;


@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private ProducerService producerService;

    /**
     * 订单消息队列
     * http://localhost:8080//api/v1/order?msg=orderqueue%20test
     * @param msg
     * @return
     */
    @GetMapping("/order")
    public Object order(String msg){
        Destination destination = new ActiveMQQueue("order.queue");
        producerService.sendMessage(destination, msg);
        return "success";
    }

    /**
     * http://localhost:8080//api/v1/common?msg=common01
     * 发送消息到默认消息队列
     * @param msg
     * @return
     */
    @GetMapping("/common")
    public Object common(String msg){
        producerService.sendMessage(msg);
        return "success";
    }

}
