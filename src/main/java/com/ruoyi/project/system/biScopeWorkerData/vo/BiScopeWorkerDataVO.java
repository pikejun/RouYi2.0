package com.ruoyi.project.system.biScopeWorkerData.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/7 0007 14:41
 * @Description:
 */
@Data
public class BiScopeWorkerDataVO
{
   private int  tid;
   private String id;
   private String userId;
   private String username;
   private String number;
   private String mobile;
   private String ownerId;
   private String projectSectionId;
   private String levelCode;
   private String ownerType;
   private String realStatus;
   private Date realDate;
   private String workStatus;
   private String  workTypeId;
   private String workTypeName;
   private Date workCreateDate;
   private String enterTrain;
   private Date lastSafetyDate;
   private int safetyCount;
   private int safetyScore;
   private int techniqueTrain;
   private String entranceCardId;
   private String projectGroupId;
   private String opStatus;
   private String opType;
   private Date createdTime;
   private String createdBy;
   private Date updatedTime;
   private String updatedBy;
}
