package com.soft1851.springboot.thread.自定义线程池;

import java.util.List;

/**
 * @author su
 * @className MyWorker
 * @Description 编写一个线程类，继承Thread类，设计一个属性用于保存线程的名字
 *              设计一个集合用于保存所有任务
 * @Date 2020/5/21
 * @Version 1.0
 **/
public class MyWorker extends Thread {
    //线程名字
    private String name;
    //任务集合
    private List<Runnable> tasks;
    public MyWorker(String name, List<Runnable> tasks){
        super(name);
        this.tasks = tasks;
    }
    @Override
    public void run() {
        //判断集合中是否有任务，只要有就一直执行
        while (tasks.size()>0){
            Runnable r = tasks.remove(0);
            r.run();
        }
    }
}
