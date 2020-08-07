package com.example.springbootdemo4.service;

        import org.springframework.scheduling.annotation.Async;
        import org.springframework.scheduling.annotation.AsyncResult;
        import org.springframework.stereotype.Component;

        import java.util.concurrent.Future;
        import java.util.concurrent.FutureTask;

/**
 * 1.异步任务类 ，不能直接写到Controller里
 * 2.
 */
@Component
@Async
public class AsyncTask2 {

    /**
     * 异步任务1，     @Async把该方法标记为一个异步方法，或者把方法上的注解挪到类上面也可以！
     * @throws InterruptedException
     */
//    @Async
    public Future<String> task4() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时：" + (end-begin)) ;
        return new AsyncResult<>("任务4");
    }
    //    @Async
    public Future<String> task5() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("任务5耗时：" + (end-begin)) ;
        return new AsyncResult<>("任务5");
    }
    //    @Async
    public Future<String> task6() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务6耗时：" + (end-begin)) ;
        return new AsyncResult<>("任务6");
    }
}
