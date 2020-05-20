package com.soft1851.springboot.thread.test;

/**
 * @author su
 * @className ThreadSleep
 * @Description TODO
 * @Date 2020/5/19
 * @Version 1.0
 **/
public class ThreadTest {
    public static void main(String[] args) {
        threadPriority();
    }

    /**线程礼让*/
    private static void threadYield(){
        Runnable r = () ->{
            for (int i=0; i<10; i++){
                System.out.println(Thread.currentThread().getName() + " : " + i);
                if (i == 3){
                    Thread.yield();
                }
            }
        };
        Thread thread1 = new Thread(r, "线程1");
        Thread thread2 = new Thread(r, "线程2");

        thread1.start();
        thread2.start();
    }

    /**线程休眠*/
    private static  void threadSleep(){
        //实例化一个线程对象
        new MyThread2().start();
    }


    /**线程命名*/
    private static void threadName(){
        //实例化线程对象
        //1.
        Thread t1 = new Thread("thread-1");
        System.out.println(t1.getName());
        //2.
        Thread t2 = new Thread();
        t2.setName("thread-2");
        System.out.println(t2.getName());

        //3.实例化一个线程对象的同时通过构造方法对线程进行命名
        Thread t3 = new Thread(() -> {}, "thread-3");
        System.out.println(t3.getName());


        //4.使用自定义的线程类，在实例化线程对象的同时进行名称赋值
        // 需要给线程类添加对应的构造方法
        MyThread2 t4 = new MyThread2("thread-4");
        System.out.println(t4.getName());
    }


    /**设置线程优先级*/
    private static void threadPriority(){
        Runnable r = () ->{
            for (int i=0; i<100; i++){
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        };
        Thread t1 = new Thread(r, "Thread-1");
        Thread t2 = new Thread(r, "Thread-2");

        //设置优先级
        t1.setPriority(3);
        t2.setPriority(1);

        t1.start();
        t2.start();

    }


}


class MyThread2 extends Thread{

    public MyThread2(){}
    public MyThread2(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i<10; i++){
            System.out.println(i);
            //线程休眠
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        super.run();

    }
}