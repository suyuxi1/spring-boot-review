package com.soft1851.springboot.jpa.repository;

import com.soft1851.springboot.jpa.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author su
 * @className UserDetailRepository
 * @Description TODO
 * @Date 2020/5/13
 * @Version 1.0
 **/
public interface UserDetailRepository extends JpaSpecificationExecutor<UserDetail>, JpaRepository<UserDetail, Long> {

}
