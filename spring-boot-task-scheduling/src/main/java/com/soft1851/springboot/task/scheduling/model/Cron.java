package com.soft1851.springboot.task.scheduling.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author su
 * @className Cron
 * @Description TODO
 * @Date 2020/5/15
 * @Version 1.0
 **/

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Cron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cronId;


    @Column(name = "cron_name",nullable = false,length = 30)
    private String cronName;


    @Column(name = "cron",nullable = false,length = 50)
    private String cron;
}