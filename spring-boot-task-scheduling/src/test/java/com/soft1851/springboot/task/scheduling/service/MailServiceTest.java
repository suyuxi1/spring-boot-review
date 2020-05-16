package com.soft1851.springboot.task.scheduling.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import javax.mail.MessagingException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MailServiceTest {

    @Resource
    private MailService mailService;

    @Resource
    private TemplateEngine templateEngine;

    @Test
    void sendSimpleTestMail() {
        String to = "2317478333@qq.com";
        String subject = "SpringBoot 邮件推送";
        String content = "<h3>test邮件推送</h3>";
        mailService.sendSimpleTestMail(to, subject, content);
    }

    @Test
    void sendHtmlMail() throws MessagingException {
        String to = "2317478333@qq.com";
        String subject = "SpringBoot 邮件推送";
//        String content = "<h3>HTML邮件推送</h3>";
        Context context = new Context();
        context.setVariable("username", "su");
        String emailContent = templateEngine.process("task", context);
        mailService.sendHtmlMail(to, subject, emailContent);
    }

    @Test
    void sendAttachmentMail() throws MessagingException {
        String to = "2317478333@qq.com";
        String subject = "SpringBoot 邮件推送";
        String content = "<h3>附件推送</h3>";
        String filePath = "pom.xml";
        mailService.sendAttachmentMail(to, subject, content, filePath);
    }

    @Test
    void sendImgMail() throws Exception{
        String to = "2317478333@qq.com";
        String subject = "SpringBoot 图片邮件推送";
        String content = "<h3>图片邮件</h3><br/><img src=\"cid:img01\" />";
        String imgPath = "E:\\图片\\壁纸\\1.jpg";
        Map<String, String> imgMap = new HashMap<>();
        imgMap.put("img01", imgPath);
        mailService.sendImgMail(to, subject, content, imgMap);
    }

}