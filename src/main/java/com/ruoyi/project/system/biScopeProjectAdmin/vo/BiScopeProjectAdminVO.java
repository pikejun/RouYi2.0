package com.ruoyi.project.system.biScopeProjectAdmin.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

/**
 * @Auther: lilijun
 * @Date: 2019/4/7 0003 17:45
 * @Description:
 */

@Data
public class BiScopeProjectAdminVO extends BaseNodeVO
{
    private String id;
    private String name;
    private String realNameId;
    private String workStatus;
    private String projectId;
    private String levelCode;
    private String rootProjectId;
}
