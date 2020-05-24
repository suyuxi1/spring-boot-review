package com.soft1851.springboot.shiro.service.impl;

import com.soft1851.springboot.shiro.dao.UserInfoDao;
import com.soft1851.springboot.shiro.entity.UserInfo;
import com.soft1851.springboot.shiro.service.UserInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName UserInfoServiceImpl
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/5/23 7:04 下午
 * @Version 1.0
 **/
@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}