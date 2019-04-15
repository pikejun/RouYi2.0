package com.ruoyi.project.system.biScopeGroupData.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilijun
 * @Date: 2019/4/8 0008 10:28
 * @Description:
 */
@Data
public class BiScopeGroupDataVO extends BaseNodeVO
{
    private String  id;//班组ID
    private Date    createDate;//创建日期
    private String  name;//班组名称
    private String  levelCode;//层级编码
    private String  parentId;//上级标段ID
    private String  projectId;//项目ID
    private String  rootProjectId;//总工程ID
    private String  remark;//备注
    private Date  updateDate;//离场日期
    private String  workStatus;//班组状态
}
