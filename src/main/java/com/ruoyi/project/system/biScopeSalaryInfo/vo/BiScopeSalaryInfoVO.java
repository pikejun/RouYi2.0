package com.ruoyi.project.system.biScopeSalaryInfo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilijun
 * @Date: 2019/4/4 0004 14:14
 * @Description:
 */
@Data
public class BiScopeSalaryInfoVO
{
   private int tid;
   private String id;
   private double  allMoney;
   private double realMoney;
   private int percent;
   private Date fireDate;
   private int fired;
   private int attendCount;
   private String levelCode;
   private String  month;
   private String personId;
   private String  userId;
   private String  projectGroupId;
   private String  projectUnitId;
   private String  satisfaction;
   private Date  feedbackDate;
   private String  status;
   private String  opStatus;
   private String opType;
   private Date createdTime;
   private String createdBy;
   private Date updatedTime;
   private String updatedBy;

}
