package com.ruoyi.project.bi.job;

import org.springframework.stereotype.Component;

/**
 * @Auther: Administrator
 * @Date: 2019/4/16 0016 08:23
 * @Description:
 */
@Component("biScheduleJob")
public class BiScheduleJob
{
    public  void execute(String templateId)
    {
        System.out.println(Thread.currentThread().getId()+":"+templateId);
    }
}
