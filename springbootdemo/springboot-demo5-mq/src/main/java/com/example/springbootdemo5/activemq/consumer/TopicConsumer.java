package com.example.springbootdemo5.activemq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 发布订阅模式消费者
 * 同一个消息，可以被不同的系统进行多次消费，处理不同的业务逻辑
 */
@Component
public class TopicConsumer {
    @JmsListener(destination = "video.topic",containerFactory = "jmsListenerContainerTopic")
    public void recive1(String text){
        System.out.println("consumer1-video.topic-message=" + text);
    }

    @JmsListener(destination = "video.topic", containerFactory = "jmsListenerContainerTopic")
    public void recive2(String text){
        System.out.println("consumer2-video.topic-message=" + text);
    }

    @JmsListener(destination = "video.topic")
    public void recive3(String text){
        System.out.println("consumer3-video.topic-message=" + text);
    }

}
