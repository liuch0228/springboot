package com.example.springbootdemo4.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class LogBackTestController {
    private  static Logger LOG = LoggerFactory.getLogger(LogBackTestController.class);
    @RequestMapping("/log")
    public String testLog(){
        LOG.error("this is error");
        LOG.debug("this is debug");
        LOG.warn("this is warn");
        LOG.info("this is info");
        return "success";
    }
}
