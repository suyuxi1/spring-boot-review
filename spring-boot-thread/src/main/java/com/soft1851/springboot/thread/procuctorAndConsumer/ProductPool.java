package com.soft1851.springboot.thread.procuctorAndConsumer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author su
 * @className ProductPool
 * @Description 产品池
 * @Date 2020/5/20
 * @Version 1.0
 **/
public class ProductPool {

    //存储所有的产品，生成者生成产品
    private List<Product> products;

    //产品池中产品的最大数量
    private int maxSize = 0;

    public ProductPool(int maxSize) {
        //对产品池进行实例化
        this.products = new LinkedList<Product>();
        //限定产品的最大数量
        this.maxSize = maxSize;
    }

    /**
     * 生产者将生产好的商品放入商品池
     *
     * @param product
     */
    public synchronized void push(Product product) {

        //判断是否还需要再生成产品
        if (this.products.size() == maxSize) {
            try {
                //等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //将产品添加到集合中
        this.products.add(product);
        //通知其他人，有产品可以消费了
        this.notifyAll();

    }

    /**
     * 消费者从商品池取出一件商品消费
     */
    public synchronized Product pop() {
        //判断是否还有产品
        if (this.products.size() == 0) {
            try {
                //等待
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //从商品池中取出一件商品
        Product product = this.products.remove(0);
        //通知其他人，我取出了一件商品
        this.notifyAll();
        return product;
    }
}
