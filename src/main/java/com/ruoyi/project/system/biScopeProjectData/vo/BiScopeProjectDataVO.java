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
   private String  abbrName;//简称
   private String  aliasName;//别名
   private Date createDate;//创建日期
   private String  enterpriseId;//关联企业ID
   private String name; //项目名称
   private String  rootProjectId;//总工程ID
   private String  remark;//备注
   private Date updateDate;//更新日期
   private String workStatus;//工作状态
   private String address;//地址
   private String  areaId;//区域ID
   private String buildNatureId;//项目性质ID
   private String contractNo;//施工合同编号
   private String costMoney;//项目造价
   private Date endDate;//竣工日期
   private String floorArea;//项目面积
   private String length;//项目长度
   private String parentEnterpriseId;//上级单位
   private String permitNo;//施工许可证号
   private String recordNo;//备案号
   private String  serialNo;//项目编号
   private String signType;//单位标签
   private String startDate;//开工日期
   private String status;//项目状态
}
