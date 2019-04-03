package com.ruoyi.project.system.biScopeAttendSpotData.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/2 0002 17:37
 * @Description:
 */
@Data
public class BiScopeAttendSpotDataVO
{
    private int tid;
    private String id;
    private String attendSpotType;
    private Date spotCreatedDate;
    private String name;
    private String projectId;
    private double latitude;
    private double longitude;
    private String address;
    private String createdUserId;
    private int attendRadius;
    private String attendRemark;
    private String opStatus;
    private String opType;
    private String createdBy;
    private Date createdTime;
    private String updatedBy;
    private Date updatedTime;
}
