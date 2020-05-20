package com.soft1851.springboot.thread.test;


/**
 * @author su
 * @className SourceConflict
 * @Description 临界资源问题
 * @Date 2020/5/19
 * @Version 1.0
 **/
public class SourceConflict {

    public static void main(String[] args) {
        Runnable r = () ->{
            while (TicketCenter.restCount>0){
                //加锁
                synchronized(""){
                    if (TicketCenter.restCount <= 0){
                        return;
                    }
                    System.out.println(Thread.currentThread().getName() + "卖出一张票，剩余" + --TicketCenter.restCount + "张");
                }
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


class TicketCenter{
    //描述剩余的票数
    public static int restCount = 100;
}
