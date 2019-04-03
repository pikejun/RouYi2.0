package com.ruoyi.project.system.biScopeComplaintInfo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/3 0003 17:45
 * @Description:
 */

@Data
public class BiScopeComplaintInfoVO {

   private int tid;
    private String id;
    private Date complaintCreatedDate;
    private int done;
    private String levelCode;
    private String personId;
    private String userId;
    private String projectGroupId;
    private String projectUnitId;
    private String typeId;
    private String opStatus;
    private String opType;
    private Date createdTime;
    private String createdBy;
    private Date updatedTime;
    private String updatedBy;
}
