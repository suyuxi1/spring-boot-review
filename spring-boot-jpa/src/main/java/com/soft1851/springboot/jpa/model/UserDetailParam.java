package com.soft1851.springboot.jpa.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author su
 * @className UserDetailParam
 * @Description TODO
 * @Date 2020/5/13
 * @Version 1.0
 **/
@Data
@Builder
public class UserDetailParam {
    private  String introduction;
    private  String realName;
    private Integer minAge;
    private Integer maxAge;
}

