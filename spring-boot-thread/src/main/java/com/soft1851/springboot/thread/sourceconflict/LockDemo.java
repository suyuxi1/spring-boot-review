package com.soft1851.springboot.thread.sourceconflict;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author su
 * @className LockDemo
 * @Description 使用ReentrantLock加锁
 * @Date 2020/5/20
 * @Version 1.0
 **/
public class LockDemo {

    public static void main(String[] args) {

        //实例化一个锁对象
        ReentrantLock lock = new ReentrantLock();

        Runnable r = () -> {
            while (TicketCenter.restCount > 0) {
                //对临界资源加锁
                lock.lock();
                if (TicketCenter.restCount <= 0) {
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余" + --TicketCenter.restCount + "张");
                //对临界资源解锁
                lock.unlock();
            }
        };
        Thread t1 = new Thread(r, "thread-1");
        Thread t2 = new Thread(r, "thread-2");
        Thread t3 = new Thread(r, "thread-3");
        Thread t4 = new Thread(r, "thread-4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
