package com.ruoyi.project.bi.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/11 0011 11:42
 * @Description:
 */
@Data
public class BaseNodeVO {

    private int tid;//表ID

    private String opStatus;
    private String opType;
    private Date createdTime;
    private String createdBy;
    private Date updatedTime;
    private String updatedBy;
}
