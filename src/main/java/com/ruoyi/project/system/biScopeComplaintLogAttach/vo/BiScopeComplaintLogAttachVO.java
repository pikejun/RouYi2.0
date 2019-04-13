package com.ruoyi.project.system.biScopeComplaintLogAttach.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

/**
 * @Auther: Administrator
 * @Date: 2019/4/3 0003 17:45
 * @Description:
 */

@Data
public class BiScopeComplaintLogAttachVO extends BaseNodeVO {
    private String id;
    private String complaintLogId;
    private String attachmentIds;
}
