package com.soft1851.springboot.thread.sourceconflict;

/**
 * @author su
 * @className DeadLock
 * @Description 死锁
 * @Date 2020/5/20
 * @Version 1.0
 **/
public class DeadLock {
    public static void main(String[] args) {
        //死锁：多个线程彼此持有对方所需的锁对象，而不释放自己的锁
        //wait: 等待，让当前线程让出锁标记，并且让出CPU资源。是当前线程进入等待队列中
        // notify： 通知，唤醒等待队列的一个线程，使这个线程进入锁池
        // notifyAll： 通知，唤醒等待队列的所有线程，使这些线程进入锁池
        Runnable runnable1 = () ->{
            synchronized ("A"){
                System.out.println("A线程持有了A锁，等待B锁");
                //释放已经持有的A锁标记，并且进入等待队列
                try {
                    "A".wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized ("B"){
                    System.out.println("A线程同时持有A锁和B锁");
                }
            }
        };

        Runnable runnable2 = () ->{
            synchronized ("B"){
                System.out.println("B线程持有了B锁，等待A锁");
                synchronized ("A"){
                    System.out.println("B线程同时持有A锁和B锁");
                    "A".notifyAll();
                }
            }
        };

        new Thread(runnable1).start();
        new Thread(runnable2).start();

    }

}
