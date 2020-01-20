package com.example.springbootdemo5.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * rocketmq 消息生产者
 */
@Component
public class MsgProducer {

    /**
     * 生产者组名
     */
    @Value("${apache.rocketmq.producer.producerGroup}")
    private String producerGroup;

    /**
     * nameserver地址
     */
    @Value("${apache.rocketmq.namesrvAddr}")
    private  String namesrvAddr;

    /**
     * 发送消息使用
     */
    private DefaultMQProducer producer;

    public DefaultMQProducer getProducer(){
        return this.producer;
    }

    /**
     * 使用@PostConstruct注解进行初始化，当一个类加载进service容器之前，会调用标记了@PostConstruct注解的方法进行一些资源的初始化操作
     * 一般应该放在servletContext容器初始化时调用该方法，可以放在自定义监听器里面实现
     * The PostConstruct annotation is used on a method that needs to be executed
     *  * after dependency injection is done to perform any initialization. This
     *  * method MUST be invoked before the class is put into service. This
     *  * annotation MUST be supported on all classes that support dependency
     *  * injection. The method annotated with PostConstruct MUST be invoked even
     *  * if the class does not request any resources to be injected. Only one
     *  * method can be annotated with this annotation.
     */
    @PostConstruct
    public void init(){
        producer=new DefaultMQProducer(producerGroup);
        // 指定nameserve，多个地址以分号隔开
        producer.setNamesrvAddr(namesrvAddr);
        //
        producer.setVipChannelEnabled(false);

        try {
            //Producer使用前必须初始化，且只能初始化一次
            producer.start();
        } catch (Exception e){
            e.printStackTrace();
        }
//        producer.shutdown();
    }




}
