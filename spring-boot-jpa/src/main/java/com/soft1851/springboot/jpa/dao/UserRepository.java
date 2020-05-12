package com.soft1851.springboot.jpa.dao;

import com.soft1851.springboot.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Su
 * @className SwaggerConfiguration
 * @Description TODO
 * @Date 2020/5/12 20:25
 * @Version 1.0
 **/
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUserName(String userName);

}