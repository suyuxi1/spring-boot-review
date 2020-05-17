package com.soft1851.springboot.task.scheduling.service;

import org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author su
 * @className JasyptSimpleIntegrationTest
 * @Description TODO
 * @Date 2020/5/17
 * @Version 1.0
 **/
@SpringBootTest
public class JasyptSimpleIntegrationTest {

    @Autowired
    PropertyServiceForJasyptStarter service;

    @Autowired
    Environment environment;

    @Test
    public void whenDecryptedPasswordNeeded_GetFromService() {
        System.out.println("service.getProperty() = " + service.getProperty());

        System.out.println("service = " + service.getPasswordUsingEnvironment(environment));
    }

    /**
     * 生成加密密文
     * 每次加密后密文不一样
     */
    @Test
    public void testPBECli(){
        String[] args = {"input='Password@1",
                "password=password", "algorithm=PBEWithMD5AndDES"};
        JasyptPBEStringEncryptionCLI.main(args);
    }

    public static void main(String[] args) {
        // 创建加密对象，默认 PBEWithMD5AndDES
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
        // 加密所需的密钥
        textEncryptor.setPassword("password");
        // 加密后的数据（数据库的用户名或密码）
        String encData = textEncryptor.encrypt("root");
        // 解密后的数据（原数据）
        String decData = textEncryptor.decrypt(encData);
        System.out.println("encData: " + encData);
        System.out.println("decData: " + decData);
    }

}

