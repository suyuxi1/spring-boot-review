package com.soft1851.springboot.quartz.repository;

import com.soft1851.springboot.quartz.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Su
 * @className CoderRepository
 * @Description TODO
 * @Date 2020/5/17 22:25
 * @Version 1.0
 **/
public interface JobEntityRepository extends JpaRepository<JobEntity, Integer> {

    /**
     * 根据id获取Job
     *
     * @param id
     * @return
     */
    JobEntity getById(Integer id);
}
