package com.ruoyi.project.system.biScopeDeviceData.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilijun
 * @Date: 2019/4/7 0003 17:45
 * @Description:
 */

@Data
public class BiScopeDeviceDataVO {

    private int tid;
    private String id;

    private String addrName;
    private String addrNo;
    private String deviceName;
    private String deviceModel;
    private String deviceType;
    private String deviceManufactor;
    private String deviceVersion;
    private Date buyDate;
    private Date putDate;
    private String remark;
    private String useStatus;
    private String projectId;
    private String projectUnitId;
    private String levelCode;
    private String sceneId;
    private String deviceStatus;

    private String opStatus;
    private String opType;
    private Date createdTime;
    private String createdBy;
    private Date updatedTime;
    private String updatedBy;
}
