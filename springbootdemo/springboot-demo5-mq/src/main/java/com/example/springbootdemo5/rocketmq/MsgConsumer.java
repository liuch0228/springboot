package com.example.springbootdemo5.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.UnsupportedEncodingException;

@Component
public class MsgConsumer {

    @Value("${apache.rocketmq.consumer.PushConsumer}")
    private String comsumerGroup;

    @Value("${apache.rocketmq.namesrvAddr}")
    private String namesrvAddr;

    /**
     * 初始化消费者
     */
    @PostConstruct
    public void inintConsumer() {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(comsumerGroup);

        consumer.setNamesrvAddr(namesrvAddr);
        try {
            // 设置consumer所订阅的topic和tag, *表示订阅所有tag
            consumer.subscribe("testTopic", "*");
            // 默认策略，从该队列最尾开始消费，跳过历史消息
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
            consumer.registerMessageListener((MessageListenerConcurrently) (list, context) -> {
                for (MessageExt messageExt : list) {
                    try {
                        // 输出消息内容
                        System.out.println("messageExt:" + messageExt);
                        String messageBody = new String(messageExt.getBody(), RemotingHelper.DEFAULT_CHARSET);
                        System.out.println("消费响应：" + messageExt.getMsgId() + ",messageBody:" + messageBody);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                        // 消费消息失败，稍后重试
                        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                    }
                }
                // 告诉topic消息消费成功，topic会将消息移除
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            });
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

}
