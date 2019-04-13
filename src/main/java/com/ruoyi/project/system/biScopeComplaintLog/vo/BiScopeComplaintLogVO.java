package com.ruoyi.project.system.biScopeComplaintLog.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/3 0003 17:45
 * @Description:
 */

@Data
public class BiScopeComplaintLogVO extends BaseNodeVO {

    private String id;
    private String complaintId;
    private String content;
    private String createDate;
    private int sender;
    private String replayId;
    private String replayName;


}
