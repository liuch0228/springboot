package com.example.springbootdemo5;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;
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

    /**
     * @JmsListener如果不指定独立的containerFactory的话只能消费queue消息,
     * 要同时支持点对点和发布订阅模式，需要给topic定义独立的JmsListenerContainer
     */
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ConnectionFactory activeMQConnectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }


    public static void main(String[] args) {
        SpringApplication.run(MQApplication.class, args);
    }
}

