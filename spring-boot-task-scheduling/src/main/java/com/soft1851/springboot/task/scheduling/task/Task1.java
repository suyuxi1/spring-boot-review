package com.soft1851.springboot.task.scheduling.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author su
 * @className Task1
 * @Description TODO
 * @Date 2020/5/14
 * @Version 1.0
 **/
//@Component
public class Task1 {
    private int count = 0;

    /**
     * 设置 process() 每隔5秒执行一次，并统计执行的次数
     */
//    @Scheduled(cron = "*/5 * * * * ?")
    @Scheduled(cron = "0 33 1 * * ?")
    private void process() {
        System.out.println("this is scheduler task running  " + (count++));
    }
}
