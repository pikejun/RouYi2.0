package com.ruoyi.project.system.biScopeAttendSpotData.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/2 0002 17:37
 * @Description:
 */
@Data
public class BiScopeAttendSpotDataVO  extends BaseNodeVO
{
    private String id;
    private String attendSpotType;
    private Date spotCreatedDate;
    private String name;
    private String projectId;
    private double latitude;
    private double longitude;
    private String address;
    private String createdUserId;
    private int attendRadius;
    private String attendRemark;
}
