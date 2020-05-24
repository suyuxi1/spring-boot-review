package com.soft1851.springboot.thread.自定义线程池;


/**
 * @author su
 * @className MyTask
 * @Description 任务类
 * @Date 2020/5/21
 * @Version 1.0
 **/
public class MyTask implements Runnable {

    private int id;

    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println("线程：" + name + "即将执行任务：" + id);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程：" + name + "完成了任务：" + id);
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "id=" + id +
                '}';
    }
}
