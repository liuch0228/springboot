package com.example.springbootdemo5.rocketmq.controller;

import com.example.springbootdemo5.rocketmq.MsgProducer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api/v1")
public class RocketMQController {

    @Autowired
    private MsgProducer producer;

    /**
     * 模拟微信支付成功后回调/order接口，order接口将消息内容发送到rocketmq中，由消费者慢慢去消费，提高并发支付能力！
     * @param msg 要发送的消息，如支付信息
     * @param tag 消息二级分类
     * @return
     * @throws UnsupportedEncodingException
     * @throws InterruptedException
     * @throws RemotingException
     * @throws MQClientException
     * @throws MQBrokerException
     */
    @RequestMapping("/orders")
    public Object order(String msg,String tag) throws UnsupportedEncodingException, InterruptedException, RemotingException, MQClientException, MQBrokerException {

        Message message = new Message("testTopic", tag, msg.getBytes(RemotingHelper.DEFAULT_CHARSET));
        SendResult result = producer.getProducer().send(message);
        System.out.println("发送响应：MsgId:" + result.getMsgId() + ",发送状态：" + result.getSendStatus());
        return "success";
    }
}
