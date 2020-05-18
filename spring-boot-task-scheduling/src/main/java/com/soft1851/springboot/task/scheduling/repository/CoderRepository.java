package com.soft1851.springboot.task.scheduling.repository;

import com.soft1851.springboot.task.scheduling.model.Coder;
import com.soft1851.springboot.task.scheduling.model.Cron;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Su
 * @className CoderRepository
 * @Description TODO
 * @Date 2020/5/17 22:25
 * @Version 1.0
 **/
public interface CoderRepository extends JpaRepository<Coder, Integer> {

}
