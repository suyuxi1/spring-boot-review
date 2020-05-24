package com.soft1851.springboot.thread.procuctorAndConsumer;

/**
 * @author su
 * @className Product
 * @Description 商品类
 * @Date 2020/5/20
 * @Version 1.0
 **/
public class Product {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String name) {
        this.name = name;
    }




}
