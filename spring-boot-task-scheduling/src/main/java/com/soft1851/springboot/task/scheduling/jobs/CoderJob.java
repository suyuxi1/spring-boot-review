package com.soft1851.springboot.task.scheduling.jobs;

import com.soft1851.springboot.task.scheduling.repository.CoderRepository;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.annotation.Resource;

/**
 * @author su
 * @className CoderJob
 * @Description TODO
 * @Date 2020/5/18
 * @Version 1.0
 **/
public class CoderJob implements Job {
    @Resource
    private CoderRepository coderRepository;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        Job job = jobExecutionContext.getJobInstance();
//        coderRepository.updateAvatar()
    }
}
