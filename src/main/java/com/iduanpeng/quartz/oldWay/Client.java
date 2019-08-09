package com.iduanpeng.quartz.oldWay;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * quartz 和springboot 集成的没写 网上会查到例子，目前转向xxl-job的研究，扩展了其他的一下东西，更好用
 */
public class Client {
    public static void main(String[] args) throws Exception{
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1","group1")
                .usingJobData("ceshi","test")
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("job1","group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 10 * * ? "))
                .build();

        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);

        scheduler.start();



    }
}
