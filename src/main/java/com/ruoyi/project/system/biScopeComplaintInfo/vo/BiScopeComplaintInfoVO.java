package com.ruoyi.project.system.biScopeComplaintInfo.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/3 0003 17:45
 * @Description:
 */

@Data
public class BiScopeComplaintInfoVO   extends BaseNodeVO {

    private String id;
    private Date complaintCreatedDate;
    private int done;
    private String workerId;
    private String typeId;
    private String typeName;
}
