package com.example.springbootdemo6.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务端推送SSE
 * 最好的方式还是用WebSocket
 */
@RestController
@RequestMapping("/sse")
public class SSEController {
    // http://localhost:8080/index.html 会看到消息变化
    @RequestMapping(value = "/getdata",produces = "text/event-stream;charset=UTF-8")
    public String pushMessage(){
        try {
            Thread.sleep(1000);
            System.out.println("sleep end");
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("send data");
        return "data:server push data-" + Math.random() + "\n\n";
    }
}
