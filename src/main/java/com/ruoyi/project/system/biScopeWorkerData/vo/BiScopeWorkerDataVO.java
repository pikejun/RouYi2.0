package com.ruoyi.project.system.biScopeWorkerData.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/7 0007 14:41
 * @Description:
 */
@Data
public class BiScopeWorkerDataVO extends BaseNodeVO
{
   private String  id;//工人ID
   private String  workerName;//工人姓名
   private String  groupId;//班组ID
   private String  workTypeId;//工种ID
   private String  workTypeName;//工种名称

   private String realNameId;//实名ID
   private String realStatus;//实名状态
   private Date realDate;//实名日期

   private String workStatus;//工作状态

   private Date lastSafetyDate;//最后安全扣分日期
   private int safetyCount;//安全扣分次数
   private int safetyScore;//安全扣分总分
   private int techniqueTrain;//是否参加技术交底
   private int enterTrain;//是否参加入场培训
   private String entranceCardId;//工卡编号
}
