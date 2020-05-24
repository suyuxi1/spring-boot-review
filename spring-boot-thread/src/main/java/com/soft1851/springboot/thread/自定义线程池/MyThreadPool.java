package com.soft1851.springboot.thread.自定义线程池;

import java.security.PublicKey;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author su
 * @className MyThreadPool
 * @Description 自定义线程池类
 * @Date 2020/5/21
 * @Version 1.0
 **/
public class MyThreadPool {

    //任务队列 --需要控制线程安全问题
    private List<Runnable> tasks = Collections.synchronizedList(new LinkedList<>());

    //当前线程数量
    private int num;

    //核心线程数
    private int corePoolSize;

    //最大线程数
    private int maxSize;

    //任务队列长度
    private int workSize;

    public MyThreadPool(int corePoolSize, int maxSize, int workSize) {
        this.corePoolSize = corePoolSize;
        this.maxSize = maxSize;
        this.workSize = workSize;
    }

    //提交任务，将任务添加到集合中，判断是否超出任务总长度
    public void submit(Runnable r){
        if (tasks.size() >= workSize){
            System.out.println("线程"+r + "丢弃了");
        }else {
            tasks.add(r);
            //执行任务
            execTask(r);
        }
    }

    //执行任务：判断当前线程的数量，决定创建核心线程还是非核心线程
    public void execTask(Runnable r){
        if (num < corePoolSize){
            new MyWorker("核心线程" + num, tasks).start();
            num++;
        }else if (num < maxSize){
            new MyWorker("非核心线程" + num, tasks).start();
            num++;
        }else {
            System.out.println("任务:" + r +"在缓存.....");
        }
    }
}
