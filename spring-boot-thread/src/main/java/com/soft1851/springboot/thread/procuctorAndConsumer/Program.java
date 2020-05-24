package com.soft1851.springboot.thread.procuctorAndConsumer;

/**
 * @author su
 * @className Program
 * @Description TODO
 * @Date 2020/5/20
 * @Version 1.0
 **/
public class Program {

    public static void main(String[] args) {

        //实例化一个产品池
        ProductPool pool = new ProductPool(15);

        //实例化一个生产者
        new Producer(pool).start();

        //实例化一个消费者
        new Consumer(pool).start();
    }
}
