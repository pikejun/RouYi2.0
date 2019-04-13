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
   private String id;//标段ID
   private String abbrName;
   private String aliasName;
   private Date createDate;
   private String enterpriseId;
   private String name;//标段名单
   private String rootProjectId;//总工程ID
   private String remark;
   private Date updateDate;
   private String workStatus;
   private String address;
   private String areaId;//
   private String levelCode;//层级编码
   private String projectId;//项目ID
   private String parentId;//上级标段ID

}
