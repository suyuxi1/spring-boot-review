package com.soft1851.springboot.thread.内置线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/**
 * @author su
 * @className ScheduleExecutorService
 * @Description TODO
 * @Date 2020/5/23
 * @Version 1.0
 **/
public class ScheduleExecutorService {

    public static void main(String[] args) {

        newScheduledThreadPoolTest3();
    }

    private static void newScheduledThreadPoolTest(){
        //1:获取一个具备延迟执行任务的线程池对象
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
        //2:创建多个任务对象,提交任务,每个任务延迟2秒执行
        for (int i=1;i<=10;i++){
            es.schedule(new MyRunnable(i),2, TimeUnit.SECONDS);
        }
        System.out.println("over");
    }

    private static void newScheduledThreadPoolTest1(){
        //1:获取一个具备延迟执行任务的线程池对象
        ScheduledExecutorService es = Executors.newScheduledThreadPool(3, new ThreadFactory() {
            int n = 1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义线程名:"+ n++);
            }
        });
        //2:创建多个任务对象,提交任务,(初始等待1秒，后面间隔2秒)
        es.scheduleAtFixedRate(new MyRunnable(1),1,2,TimeUnit.SECONDS);
        System.out.println("over");
    }

    private static void newScheduledThreadPoolTest3(){
        //1:获取一个具备延迟执行任务的线程池对象
        ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor( new ThreadFactory() {
            int n = 1;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"自定义线程名:"+n++);
            }
        });
        //2:创建多个任务对象,提交任务,(初始等待1秒，后面间隔2秒)
        es.scheduleWithFixedDelay(new MyRunnable(1),1,2,TimeUnit.SECONDS);
        System.out.println("over");
    }




}
