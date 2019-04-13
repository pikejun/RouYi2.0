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
    private String  id;
    private Date    createDate;
    private String  name;
    private String  levelCode;
    private String  parentId;
    private String  projectId;
    private String  rootProjectId;
    private String  remark;
    private String  updateDate;
    private String  workStatus;
}
