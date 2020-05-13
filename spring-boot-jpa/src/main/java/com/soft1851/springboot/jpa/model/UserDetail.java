package com.soft1851.springboot.jpa.model;

import javax.persistence.*;

/**
 * @author su
 * @className UserDetail
 * @Description TODO
 * @Date 2020/5/13
 * @Version 1.0
 **/
@Entity
public class UserDetail {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, unique = true)
    private Long userId;
    private Integer age;
    private String realName;
    private String status;
    private String hobby;
    private String introduction;
    private String lastLoginIp;
}
