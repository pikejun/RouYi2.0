package com.ruoyi.project.system.biScopeGroupOwner.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

/**
 * @Auther: Administrator
 * @Date: 2019/4/23 0023 14:00
 * @Description:
 */
@Data
public class BiScopeGroupOwnerVO extends BaseNodeVO
{
    private String id;
    private String name;
    private String groupId;//班组ID
    private String realNameId;
    private String workStatus;
    private String projectId;
    private String levelCode;
    private String rootProjectId;
}
