package com.soft1851.springboot.thread.内置线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author su
 * @className MyTest2
 * @Description 使用newCachedThreadPool方法创建
 * @Date 2020/5/22
 * @Version 1.0
 **/
public class MyTest2 {

    public static void main(String[] args) {
//        test1();
        test2();
    }


    //使用Executors获取ExecutorService对象
    private static void test1() {
        //使用工厂类获取线程对象
        ExecutorService es = Executors.newFixedThreadPool(3);
        //提交任务
        for (int i = 1; i<10; i++){
            es.submit(new MyRunnable(i));
        }
    }
    private static void test2() {
        //使用工厂类获取线程对象
        ExecutorService es = Executors.newFixedThreadPool(3,new ThreadFactory() {
            int n=1;
            @Override
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "自定义线程" + n++);
            }
        });
        //提交任务
        for (int i = 1; i<10; i++){
            es.submit(new MyRunnable(i));
        }
    }
}
