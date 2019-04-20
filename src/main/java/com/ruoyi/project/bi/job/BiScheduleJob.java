package com.ruoyi.project.bi.job;

import com.ruoyi.project.system.biTemplateInfo.service.IBiTemplateInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: Administrator
 * @Date: 2019/4/16 0016 08:23
 * @Description:
 */
@Component("biScheduleJob")
public class BiScheduleJob
{
    @Autowired
    IBiTemplateInfoService biTemplateInfoService;
    public  void execute(String templateNo)
    {


        biTemplateInfoService.reportTemplateByTemplateNo(templateNo);
    }
}
