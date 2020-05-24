package com.soft1851.springboot.thread.自定义线程池;

/**
 * @author su
 * @className MyTest
 * @Description 测试类
 * @Date 2020/5/21
 * @Version 1.0
 **/
public class MyTest {
    public static void main(String[] args) {
        //创建线程池对象
        MyThreadPool pool = new MyThreadPool(2, 4, 20);
        //提交多个任务
        for (int i = 0; i<10; i++){
            //创建任务对象，提交给线程池
            MyTask my = new MyTask(i);
            pool.submit(my);
        }
    }

}
