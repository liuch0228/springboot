package com.example.springbootdemo5.activemq.service;


import javax.jms.Destination;

/**
 * 消息生产者，实际项目中，消息生产者是独立的项目
 */
public interface ProducerService {
    /**
     * 指定消息队列和消息
     * @param destination 发送到的消息队列
     * @param message 待发送的消息
     */
    void sendMessage(Destination destination, final String message);

    /**
     * 使用默认消息队列发送消息
     * @param message 待发送的消息
     */
    void sendMessage(final String message);

    /**
     *  发布订阅模式-发布消息
     * @param message
     */
    void publish(final String message);
}
