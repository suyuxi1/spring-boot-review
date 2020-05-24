package com.soft1851.springboot.shiro.dao;

import com.soft1851.springboot.shiro.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

/**
 * @ClassName UserInfoDao
 * @Description TODO
 * @Author xiaobinggan
 * @Date 2020/5/23 7:04 下午
 * @Version 1.0
 **/
public interface UserInfoDao extends CrudRepository<UserInfo, Long> {
    /**
     * 通过username查找用户信息;
     */
    public UserInfo findByUsername(String username);
}
