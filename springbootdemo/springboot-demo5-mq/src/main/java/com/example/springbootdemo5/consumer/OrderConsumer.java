package com.example.springbootdemo5.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * order.queue队列的消费者实时监听该消息队列，一有消息就直接进行消费
 */
@Component
public class OrderConsumer {

    @JmsListener(destination = "order.queue")
    public void consumeMessage(String text){
        System.out.println("orderConsumer收到报文是：" + text);
    }

}
