package com.soft1851.springboot.start.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author su
 * @className SpringBootController
 * @Description 标准的Spring Boot RESTController
 * @Date 2020/5/11
 * @Version 1.0
 **/
@RestController
@RequestMapping("/api")
public class SpringBootController {

    @RequestMapping("/hello")
    public String hello() {
        return "Hello, Spring Boot!";
    }
}