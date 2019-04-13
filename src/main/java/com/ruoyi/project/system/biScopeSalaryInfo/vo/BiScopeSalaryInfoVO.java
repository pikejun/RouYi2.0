package com.ruoyi.project.system.biScopeSalaryInfo.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilijun
 * @Date: 2019/4/4 0004 14:14
 * @Description:
 */
@Data
public class BiScopeSalaryInfoVO  extends BaseNodeVO
{
   private String id;
   private double  allMoney;
   private double realMoney;
   private int percent;
   private Date fireDate;
   private int fired;
   private int attendCount;
   private String  month;
   private String workerId;
   private String  satisfaction;
   private Date  feedbackDate;
   private String  status;

}
