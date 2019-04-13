package com.ruoyi.project.bi.job;
import com.ruoyi.project.bi.service.Neo4jService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @Auther: Administrator
 * @Date: 2019/4/2 0002 11:29
 * @Description:
 */
public abstract class BaseDataJob implements Runnable {

    public static final org.slf4j.Logger log = LoggerFactory.getLogger(BaseDataJob.class);

    @Value("${host}")
    public String host="666";

    @Autowired
    public Neo4jService neo4jService;

    public void run()
    {
        doJob();
    }

    public abstract void doJob();
}
