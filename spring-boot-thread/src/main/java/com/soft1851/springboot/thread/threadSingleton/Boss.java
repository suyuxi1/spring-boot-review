package com.soft1851.springboot.thread.threadSingleton;

/**
 * @author su
 * @className Boss
 * @Description 多线程下的懒汉单例
 * @Date 2020/5/20
 * @Version 1.0
 **/
public class Boss {

    //构造方法私有化
    private Boss() {
        System.out.println("一个Boss对象被实例化了");
    }


    private static Boss Instance = null;

    public static Boss getBoss() {
        synchronized ("") {
            if (Instance == null) {
                Instance = new Boss();
            }
            return Instance;
        }
    }

}
