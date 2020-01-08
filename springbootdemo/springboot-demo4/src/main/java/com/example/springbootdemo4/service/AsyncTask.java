package com.example.springbootdemo4.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 异步任务类，注意点：不能直接写到Controller里
 */
@Component
public class AsyncTask {

    /**
     * 异步任务1，     @Async把该方法标记为一个异步方法，或者把方法上的注解挪到类上面也可以！
     * @throws InterruptedException
     */
    @Async
    public void asyncTask1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时：" + (end-begin)) ;
    }
    @Async
    public void asyncTask2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时：" + (end-begin)) ;
    }
    @Async
    public void asyncTask3() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(4000);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时：" + (end-begin)) ;
    }
}
