package com.soft1851.springboot.thread.内置线程池;

/**
 * 任务类
 */
public class MyRunnable implements Runnable{
    private int id;

    public MyRunnable(int id) {
        this.id = id;
    }
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "执行了任务......." + id);
    }

    @Override
    public String toString() {
        return "MyRunnable{" +
                "id=" + id +
                '}';
    }
}
