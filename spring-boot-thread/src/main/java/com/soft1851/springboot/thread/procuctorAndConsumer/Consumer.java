package com.soft1851.springboot.thread.procuctorAndConsumer;

/**
 * @author su
 * @className Consumer
 * @Description 消费者
 * @Date 2020/5/20
 * @Version 1.0
 **/
public class Consumer extends Thread {

    private ProductPool pool;

    public Consumer(ProductPool pool){
        this.pool = pool ;
    }

    @Override
    public void run() {
        while (true){
           Product product = this.pool.pop();
            System.out.println("消费者消费一件产品" + product.getName());
        }
    }
}
