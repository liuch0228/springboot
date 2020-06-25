package com.example.springbootdemo3.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sse")
public class SSEController {
    @RequestMapping(value = "/getdata",produces = "text/event-stream;charset=UTF-8")
    public String pushMessage(){
      try {
          Thread.sleep(2000);
      } catch (Exception e){
          e.printStackTrace();
      }
      return "data:server push data-" + Math.random() + "\n";
    }
}
