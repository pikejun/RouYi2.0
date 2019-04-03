package com.ruoyi.project.system.biScopeAttendInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                import java.util.Date;
        
/**
 * 考勤表 bi_scope_attend_info
 *
 * @author ruoyi
 * @date 2019-04-02
 */
public class BiScopeAttendInfo extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 考勤ID */
@Excel(name = "考勤ID", prompt = "考勤ID")
private String id;
/** 入场时间 */
@Excel(name = "入场时间", prompt = "入场时间")
private Date onWorkTime;
/** 人员组织ID */
@Excel(name = "人员组织ID", prompt = "人员组织ID")
private String personId;
/** 出场时间 */
@Excel(name = "出场时间", prompt = "出场时间")
private Date unWorkTime;
/** 考勤模式 */
@Excel(name = "考勤模式", prompt = "考勤模式")
private String attendMode;
/** 考勤日期 */
@Excel(name = "考勤日期", prompt = "考勤日期")
private String day;
/** 考勤月份 */
@Excel(name = "考勤月份", prompt = "考勤月份")
private String month;
/** 考勤点ID */
@Excel(name = "考勤点ID", prompt = "考勤点ID")
private String attendSpotId;
/** 考勤图片ID */
@Excel(name = "考勤图片ID", prompt = "考勤图片ID")
private String imageId;
/** 用户ID */
@Excel(name = "用户ID", prompt = "用户ID")
private String userId;
/** 设备编号 */
@Excel(name = "设备编号", prompt = "设备编号")
private String deviceNumber;
/** 层级编码 */
@Excel(name = "层级编码", prompt = "层级编码")
private String levelCode;
/** 标段ID */
@Excel(name = "标段ID", prompt = "标段ID")
private String projectUnitId;
/** 操作状态 */
@Excel(name = "操作状态", prompt = "操作状态")
private String opStatus;
/** 操作类型 */
@Excel(name = "操作类型", prompt = "操作类型")
private String opType;
/** 创建时间 */
@Excel(name = "创建时间", prompt = "创建时间")
private Date createdTime;
/** 创建人 */
@Excel(name = "创建人", prompt = "创建人")
private String createdBy;
/** 更新时间 */
@Excel(name = "更新时间", prompt = "更新时间")
private Date updatedTime;
/** 更新人 */
@Excel(name = "更新人", prompt = "更新人")
private String updatedBy;

public void setTid(Integer tid)
        {
        this.tid = tid;
        }

public Integer getTid()
        {
        return tid;
        }
public void setId(String id)
        {
        this.id = id;
        }

public String getId()
        {
        return id;
        }
public void setOnWorkTime(Date onWorkTime)
        {
        this.onWorkTime = onWorkTime;
        }

public Date getOnWorkTime()
        {
        return onWorkTime;
        }
public void setPersonId(String personId)
        {
        this.personId = personId;
        }

public String getPersonId()
        {
        return personId;
        }
public void setUnWorkTime(Date unWorkTime)
        {
        this.unWorkTime = unWorkTime;
        }

public Date getUnWorkTime()
        {
        return unWorkTime;
        }
public void setAttendMode(String attendMode)
        {
        this.attendMode = attendMode;
        }

public String getAttendMode()
        {
        return attendMode;
        }
public void setDay(String day)
        {
        this.day = day;
        }

public String getDay()
        {
        return day;
        }
public void setMonth(String month)
        {
        this.month = month;
        }

public String getMonth()
        {
        return month;
        }
public void setAttendSpotId(String attendSpotId)
        {
        this.attendSpotId = attendSpotId;
        }

public String getAttendSpotId()
        {
        return attendSpotId;
        }
public void setImageId(String imageId)
        {
        this.imageId = imageId;
        }

public String getImageId()
        {
        return imageId;
        }
public void setUserId(String userId)
        {
        this.userId = userId;
        }

public String getUserId()
        {
        return userId;
        }
public void setDeviceNumber(String deviceNumber)
        {
        this.deviceNumber = deviceNumber;
        }

public String getDeviceNumber()
        {
        return deviceNumber;
        }
public void setLevelCode(String levelCode)
        {
        this.levelCode = levelCode;
        }

public String getLevelCode()
        {
        return levelCode;
        }
public void setProjectUnitId(String projectUnitId)
        {
        this.projectUnitId = projectUnitId;
        }

public String getProjectUnitId()
        {
        return projectUnitId;
        }
public void setOpStatus(String opStatus)
        {
        this.opStatus = opStatus;
        }

public String getOpStatus()
        {
        return opStatus;
        }
public void setOpType(String opType)
        {
        this.opType = opType;
        }

public String getOpType()
        {
        return opType;
        }
public void setCreatedTime(Date createdTime)
        {
        this.createdTime = createdTime;
        }

public Date getCreatedTime()
        {
        return createdTime;
        }
public void setCreatedBy(String createdBy)
        {
        this.createdBy = createdBy;
        }

public String getCreatedBy()
        {
        return createdBy;
        }
public void setUpdatedTime(Date updatedTime)
        {
        this.updatedTime = updatedTime;
        }

public Date getUpdatedTime()
        {
        return updatedTime;
        }
public void setUpdatedBy(String updatedBy)
        {
        this.updatedBy = updatedBy;
        }

public String getUpdatedBy()
        {
        return updatedBy;
        }
@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("tid",getTid())
                .append("id",getId())
                .append("onWorkTime",getOnWorkTime())
                .append("personId",getPersonId())
                .append("unWorkTime",getUnWorkTime())
                .append("attendMode",getAttendMode())
                .append("day",getDay())
                .append("month",getMonth())
                .append("attendSpotId",getAttendSpotId())
                .append("imageId",getImageId())
                .append("userId",getUserId())
                .append("deviceNumber",getDeviceNumber())
                .append("levelCode",getLevelCode())
                .append("projectUnitId",getProjectUnitId())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
