package com.soft1851.springboot.task.scheduling.service;

import javax.mail.MessagingException;
import java.util.Map;

/**
 * @author Su
 * @className MailService
 * @Description TODO
 * @Date 2020/5/15 19:23
 * @Version 1.0
 **/
public interface MailService {

    /**
     *
     * @param to
     * @param subject
     * @param content
     */
    void sendSimpleTestMail(String to, String subject, String content);

    /**
     * Html邮件
     * @param to
     * @param subject
     * @param content
     */
    void sendHtmlMail(String to, String subject, String content) throws MessagingException;


    /**
     * 附件推送
     * @param to
     * @param subject
     * @param content
     * @param fileArr
     * @throws MessagingException
     */
    void sendAttachmentMail(String to, String subject, String content, String... fileArr) throws MessagingException;


    void sendImgMail(String to, String subject, String content, Map<String, String> imgMap) throws MessagingException;

}
