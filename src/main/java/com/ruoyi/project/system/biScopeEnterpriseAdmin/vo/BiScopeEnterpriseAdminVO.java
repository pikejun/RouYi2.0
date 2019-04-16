package com.ruoyi.project.system.biScopeEnterpriseAdmin.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilijun
 * @Date: 2019/4/7 0003 17:45
 * @Description:
 */

@Data
public class BiScopeEnterpriseAdminVO extends BaseNodeVO {

    private String id;
    private String name;
    private String realNameId;
    private String workStatus;
    private String enterpriseId;
}
