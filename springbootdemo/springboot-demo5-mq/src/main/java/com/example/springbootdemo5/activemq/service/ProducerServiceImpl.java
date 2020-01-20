package com.example.springbootdemo5.activemq.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

/**
 *  消息生产者实现类
 */
@Service
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;


    @Override
    public void sendMessage(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    @Override
    public void sendMessage(String message) {
        jmsMessagingTemplate.convertAndSend(this.queue,message);
    }

    // 发布订阅模式
    @Autowired
    private Topic topic;

    public void publish(String msg){
        this.jmsMessagingTemplate.convertAndSend(this.topic,msg);
    }


}
