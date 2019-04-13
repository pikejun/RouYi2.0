package com.ruoyi.project.system.biScopeProjectData.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/2 0002 13:40
 * @Description:
 */
@Data
public class BiScopeProjectDataVO  extends BaseNodeVO
{
   private String id; //项目ID
   private String  abbrName;
   private String  aliasName;
   private Date createDate;
   private String  enterpriseId;
   private String name; //项目名称
   private String  rootProjectId;
   private String  remark;
   private Date updateDate;
   private String workStatus;
   private String address;
   private String  areaId;
   private String buildNatureId;
   private String contractNo;
   private String costMoney;
   private Date endDate;
   private String floorArea;
   private String length;
   private String parentEnterpriseId;
   private String permitNo;
   private String recordNo;
   private String  serialNo;
   private String signType;
   private String startDate;
   private String status;
}
