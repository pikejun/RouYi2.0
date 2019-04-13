package com.ruoyi.project.system.biScopeEnterpriseDepartment.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilijun
 * @Date: 2019/4/8 0008 10:28
 * @Description:
 */
@Data
public class BiScopeEnterpriseDepartmentVO  extends BaseNodeVO
{
    private String id;
    private String abbrName;
    private Date createDate;
    private String enterpriseId;
    private String levelCode;
    private String name;
    private String parentId;
    private String remark;
    private String rootId;
}
