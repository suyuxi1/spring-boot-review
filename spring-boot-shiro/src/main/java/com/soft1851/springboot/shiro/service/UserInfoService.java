package com.soft1851.springboot.shiro.service;

import com.soft1851.springboot.shiro.entity.UserInfo;

/**
 * @ClassName UserInfoService
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/5/23 7:03 下午
 * @Version 1.0
 **/
public interface UserInfoService {
    /**
     * 通过username查找用户信息;
     */
    public UserInfo findByUsername(String username);
}
