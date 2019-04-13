package com.ruoyi.project.system.biScopeSectionData.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilijun
 * @Date: 2019/4/10 0004 14:14
 * @Description:
 */
@Data
public class BiScopeSectionDataVO  extends BaseNodeVO
{
   private String id;
   private String abbrName;
   private String aliasName;
   private Date createDate;
   private String enterpriseId;
   private String name;
   private String rootProjectId;
   private String remark;
   private Date updateDate;
   private String workStatus;
   private String address;
   private String areaId;
   private String levelCode;
   private String projectId;
   private String parentId;

}
