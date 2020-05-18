package com.soft1851.springboot.task.scheduling.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

/**
 * @author su
 * @className PropertyServiceForJasyptStarter
 * @Description 加载配置文件中的配置信息
 * @Date 2020/5/17
 * @Version 1.0
 **/
//@Service
public class PropertyServiceForJasyptStarter {

    @Value("${encrypted.property}")
    private String property;

    public String getProperty() {
        return property;
    }

    public String getPasswordUsingEnvironment(Environment environment) {
        return environment.getProperty("encrypted.property");
    }
}
