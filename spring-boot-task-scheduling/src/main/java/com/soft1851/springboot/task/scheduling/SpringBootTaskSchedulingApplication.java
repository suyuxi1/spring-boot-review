package com.soft1851.springboot.task.scheduling;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableEncryptableProperties
public class SpringBootTaskSchedulingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTaskSchedulingApplication.class, args);
    }

}
