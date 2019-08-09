package com.iduanpeng.quartz.oldWay;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 原始方式
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("exe...");
        //通过jobBuilder 传参
        JobDataMap data = jobExecutionContext.getMergedJobDataMap();
        String ceshi = data.getString("ceshi");
        System.out.println(ceshi);


    }
}
