package com.ruoyi.project.system.biScopeAttendInfo.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/2 0002 16:50
 * @Description:
 */

@Data
public class BiScopeAttendInfoVO  extends BaseNodeVO {

    private String id;//考勤ID
    private String workerId;//工人ID
    private String day;//日期
    private String month;//月份
    private String attendSpotId;//考勤点ID

    private Date onWorkTime;//上班考勤
    private Date unWorkTime;//下班考勤
    private String attendMode;//考勤模式

    private String imageId;//图片
    private String deviceNumber;//设备编号
}
