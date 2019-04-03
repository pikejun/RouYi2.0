package com.ruoyi.project.system.biScopeAttendInfo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/2 0002 16:50
 * @Description:
 */

@Data
public class BiScopeAttendInfoVO {

    private int tid;
    private String id;
    private Date onWorkTime;
    private String personId;
    private Date unWorkTime;
    private String attendMode;
    private String day;
    private String month;
    private String attendSpotId;
    private String imageId;
    private String userId;
    private String deviceNumber;
    private String levelCode;
    private String projectUnitId;
    private String opStatus;
    private String opType;
    private Date createdTime;
    private String createdBy;
    private Date updatedTime;
    private String updatedBy;
}
