package com.soft1851.springboot.task.scheduling.task;

import com.soft1851.springboot.task.scheduling.repository.CronRepository;
import com.soft1851.springboot.task.scheduling.service.MailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @author su
 * @className AutoTask
 * @Description TODO
 * @Date 2020/5/15
 * @Version 1.0
 **/
@Slf4j
//@Component
public class AutoTask implements SchedulingConfigurer {
    @Resource
    protected CronRepository cronRepository;

    @Resource
    private MailService mailService;

    private String newCron;
    private Integer cronId = 1;

    @Scheduled(cron = "35 50 1 * * ?")
    public void send() throws MessagingException {
        String to = "2317478333@qq.com";
        String subject = "生日卡片邮件推送";
        String content = "<h3>生日快乐</h3><br/><img src=\"cid:img01\" />";
        String imgPath = "E:\\图片\\壁纸\\1.jpg";
        Map<String, String> imgMap = new HashMap<>();
        imgMap.put("img01", imgPath);
        mailService.sendImgMail(to, subject, content, imgMap);
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addTriggerTask(
                //1.添加任务内容(Runnable)
                () -> {
                    log.info("执行定时任务: " + LocalDateTime.now().toLocalTime());
                },
                //2.设置执行周期(Trigger)
                triggerContext -> {
                    //2.1 从数据库获取执行周期
                    String cron = cronRepository.findCronByCronIdEquals(cronId).getCron();
                    //2.2 合法性校验.
                    if (StringUtils.isEmpty(cron)) {
                        log.info("cron不能为空");
                    }
                    //2.3 返回执行周期
                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
                }
        );
//        scheduledTaskRegistrar.addTriggerTask(this::process,
//                triggerContext -> {
//                    //先查询了id为1的cron
//                    String cron = cronRepository.findCronByCronIdEquals(1).getCron();
//                    log.info(cron);
//                    if (cron.isEmpty()){
//                        log.info("cron为空");
//                    }
//                    return new CronTrigger(cron).nextExecutionTime(triggerContext);
//                });
    }


//    private void process(){
//        log.info("从数据读取cron...");
//    }
}
