package com.example.springbootdemo5.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * common.queue队列的消费者实时监听该消息队列，一有消息就直接进行消费
 */
@Component
public class CommonConsumer {
    /**
     * 监听并处理common.queue的队列消息
     * @param text
     */
    @JmsListener(destination = "common.queue")
    public void consumeMessage(String text){
        System.out.println("commonConsumer收到报文是：" + text);
    }
}
