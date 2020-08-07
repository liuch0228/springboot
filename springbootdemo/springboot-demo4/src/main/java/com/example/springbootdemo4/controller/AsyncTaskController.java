package com.example.springbootdemo4.controller;

import com.example.springbootdemo4.service.AsyncTask;
import com.example.springbootdemo4.service.AsyncTask2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 异步任务测试
 * 异步任务的意义在于把串行化执行的方法变成了异步执行，当所有异步方法执行完成后，
 * 后面的方法才继续执行
 */
@RestController
@RequestMapping("/api/v1")
public class AsyncTaskController {
    @Autowired
    private AsyncTask task;

    @Autowired
    private AsyncTask2 asyncTask;


    /**
     * 测试异步任务 http://localhost:8080/api/v1/async
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/async")
    public String execTask() throws InterruptedException {
        long start = System.currentTimeMillis();
        task.asyncTask1();
        task.asyncTask2();
        task.asyncTask3();
        long end = System.currentTimeMillis();
        System.out.println("总耗时：" + (end -start));
        return "success,suspend " +  (end -start) + "ms";
    }

    /**
     * 带有返回值的异步任务测试
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/async2")
    public String execTask2() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        Future<String> task6 = asyncTask.task6();
        for(;;){
            if(task4.isDone() && task5.isDone() && task6.isDone()){
                // 等待异步任务分别执行结束
                break;
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("总耗时：" + (end -start));
        return "success,suspend " +  (end -start) + "ms" + "; task4 result = " + task4.get();
    }


}
