package com.example.springbootdemo5;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

import javax.jms.Queue;
import javax.jms.Topic;


/**
 * 主类
 */
@SpringBootApplication
@EnableJms // 开启jms支持
public class MQApplication {
    /**
     * 创建一个activemq消息队列，交给springboot管理
     *  common.queue 是队列的名字
     * @return
     */
    @Bean
    public Queue queue(){
        return new ActiveMQQueue("common.queue");
    }

    /**
     * activemq发布订阅模式，需要指定topic!
     * @return
     */
    @Bean
    public Topic topic(){
        return new ActiveMQTopic("video.topic");
    }

    public static void main(String[] args) {
        SpringApplication.run(MQApplication.class, args);
    }
}
