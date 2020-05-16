package com.soft1851.springboot.task.scheduling.repository;

import com.soft1851.springboot.task.scheduling.model.Cron;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CronRepositoryTest {

    @Resource
    private CronRepository cronRepository;
    @Test
    void save() {
        Cron cron = Cron.builder()
                .cronId(1)
                .cron("0/3 * * * * ?")
                .cronName("任务一")
                .build();
        cronRepository.save(cron);
    }
}