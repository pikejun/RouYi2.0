package com.ruoyi.project.bi.job;

import org.slf4j.LoggerFactory;

/**
 * @Auther: Administrator
 * @Date: 2019/4/2 0002 11:29
 * @Description:
 */
public abstract class BaseDataJob {

    public static final org.slf4j.Logger log = LoggerFactory.getLogger(BaseDataJob.class);
    public abstract void doJob();
}
