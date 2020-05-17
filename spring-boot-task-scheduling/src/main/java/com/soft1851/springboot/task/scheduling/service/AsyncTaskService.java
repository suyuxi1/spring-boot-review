package com.soft1851.springboot.task.scheduling.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author su
 * @className AsyncTaskService
 * @Description TODO
 * @Date 2020/5/16
 * @Version 1.0
 **/
@Service
@Slf4j
public class AsyncTaskService {

    @Resource
    private MailService mailService;

    @Async
    public void asyncTask(){
        log.info(String.valueOf(LocalDateTime.now()));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("处理数据中");
        String to = "2317478333@qq.com";
        String subject = "SpringBoot 邮件推送";
        String content = "<h3>test邮件推送</h3>";
        mailService.sendSimpleTestMail(to, subject, content);
    }
}
