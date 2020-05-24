package com.soft1851.springboot.thread.threadSingleton;

/**
 * @author su
 * @className SingletonTest
 * @Description 懒汉式单例
 * @Date 2020/5/20
 * @Version 1.0
 **/
public class SingletonTest {

    public static void main(String[] args) {

        Runnable runnable = () ->{
            Boss.getBoss();
        };

        for (int i = 0; i<100; i++){
            new Thread(runnable).start();
        }
    }
}


