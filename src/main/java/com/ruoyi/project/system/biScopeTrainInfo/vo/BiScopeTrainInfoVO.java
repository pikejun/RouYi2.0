package com.ruoyi.project.system.biScopeTrainInfo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/3 0003 10:10
 * @Description:
 */

@Data
public class BiScopeTrainInfoVO
{
    private int tid;
    private String id;
    private String attendUserId;
    private Date trainCreateDate;
    private String createUserId;
    private Date startDate;
    private Date endDate;
    private String levelCode;
    private String locationId;
    private String name;
    private String projectGroupId;
    private String projectUnitId;
    private String sceneId;
    private String trainUserId;
    private String type;
    private String opStatus;
    private String opType;
    private Date createdTime;
    private String createdBy;
    private Date updatedTime;
    private String updatedBy;
}
