package com.soft1851.springboot.thread.procuctorAndConsumer;

/**
 * @author su
 * @className Producer
 * @Description 生产者
 * @Date 2020/5/20
 * @Version 1.0
 **/
public class Producer extends Thread{
    private ProductPool pool;

    public Producer(ProductPool pool){
        this.pool = pool ;
    }

    @Override
    public void run() {
        while (true){
            String name = (int)(Math.random() * 100) + "号产品";
            System.out.println("生成了一件产品" + name);
            Product product = new Product(name);
            this.pool.push(product);
        }
    }
}
