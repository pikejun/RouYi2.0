package com.ruoyi.project.system.biScopeSafeEvent.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/4 0004 16:49
 * @Description:
 */

@Data
public class BiScopeSafeEventVO {

  private int  tid;
  private String id;
  private String   eventName;
  private Date eventCreatedDate;
  private String  content;
  private String  checkerId;
  private String  userId;
  private String  itemId;
  private String  levelCode;
  private String  projectUnitId;
  private String  type;
  private int  critical;
  private String   opStatus;
  private String   opType;
  private Date createdTime;
  private String  createdBy;
  private Date updatedTime;
  private String  updatedBy;
}
