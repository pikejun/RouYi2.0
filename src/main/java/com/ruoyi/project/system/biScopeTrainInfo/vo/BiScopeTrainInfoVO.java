package com.ruoyi.project.system.biScopeTrainInfo.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/3 0003 10:10
 * @Description:
 */

@Data
public class BiScopeTrainInfoVO  extends BaseNodeVO
{
    private String id;
    private String attendUserId;
    private Date trainCreateDate;
    private String createUserId;
    private Date startDate;
    private Date endDate;
    private String levelCode;
    private String locationId;
    private String name;
    private String projectGroupId;
    private String projectUnitId;
    private String sceneId;
    private String trainUserId;
    private String type;
}
