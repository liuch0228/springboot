package com.example.springbootdemo4.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务
 * @Component ：被spring容器扫描
 */
@Component
public class ScheduleTask {

    /**
     *  定时任务要执行的具体逻辑
     */
//    @Scheduled(fixedRate = 2000) // 2s执行一次
    @Scheduled(fixedDelay = 3000) // 距离上次结束时间点过3s再执行
    @Scheduled(cron = "*/3 * * * * *") // cron表达式 3s执行一次
    public void test(){
        System.out.println("当前时间" + new Date());
    }
}
