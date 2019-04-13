package com.ruoyi.project.system.biScopeRealName.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/2 0002 13:40
 * @Description:
 */
@Data
public class BiScopeRealNameVO extends BaseNodeVO
{
   private String id;
   private String birthDay;
   private String name;
   private String nation;
   private String address;
   private String idNo;
   private String province;
   private String sex;
   private String validPeriod;
   private String signDate;
   private String organization;
   private String backId;
   private String frontId;
   private String photoId;
   private String mobile;
   private String imageId;
   private Date realDate;
   private String realType;
}
