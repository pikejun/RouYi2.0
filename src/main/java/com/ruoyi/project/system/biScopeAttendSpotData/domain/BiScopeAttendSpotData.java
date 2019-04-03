package com.ruoyi.project.system.biScopeAttendSpotData.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                    import java.util.Date;
        
/**
 * 考勤点表 bi_scope_attend_spot_data
 *
 * @author ruoyi
 * @date 2019-04-02
 */
public class BiScopeAttendSpotData extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 考勤点ID */
@Excel(name = "考勤点ID", prompt = "考勤点ID")
private String id;
/** 考勤点类型 */
@Excel(name = "考勤点类型", prompt = "考勤点类型")
private String attendSpotType;
/** 考勤点日期 */
@Excel(name = "考勤点日期", prompt = "考勤点日期")
private Date spotCreatedDate;
/** 名称 */
@Excel(name = "名称", prompt = "名称")
private String name;
/** 项目ID */
@Excel(name = "项目ID", prompt = "项目ID")
private String projectId;
/** 纬度 */
@Excel(name = "纬度", prompt = "纬度")
private Double latitude;
/** 经度 */
@Excel(name = "经度", prompt = "经度")
private Double longitude;
/** 地址 */
@Excel(name = "地址", prompt = "地址")
private String address;
/** 创建人ID */
@Excel(name = "创建人ID", prompt = "创建人ID")
private String createdUserId;
/** 半径 */
@Excel(name = "半径", prompt = "半径")
private Integer attendRadius;
/** 备注 */
@Excel(name = "备注", prompt = "备注")
private String attendRemark;
/** 操作状态 */
@Excel(name = "操作状态", prompt = "操作状态")
private String opStatus;
/** 操作类型 */
@Excel(name = "操作类型", prompt = "操作类型")
private String opType;
/** 创建人 */
@Excel(name = "创建人", prompt = "创建人")
private String createdBy;
/** 创建时间 */
@Excel(name = "创建时间", prompt = "创建时间")
private Date createdTime;
/** 更新人 */
@Excel(name = "更新人", prompt = "更新人")
private String updatedBy;
/** 更新时间 */
@Excel(name = "更新时间", prompt = "更新时间")
private Date updatedTime;

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
public void setAttendSpotType(String attendSpotType)
        {
        this.attendSpotType = attendSpotType;
        }

public String getAttendSpotType()
        {
        return attendSpotType;
        }
public void setSpotCreatedDate(Date spotCreatedDate)
        {
        this.spotCreatedDate = spotCreatedDate;
        }

public Date getSpotCreatedDate()
        {
        return spotCreatedDate;
        }
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
        }
public void setProjectId(String projectId)
        {
        this.projectId = projectId;
        }

public String getProjectId()
        {
        return projectId;
        }
public void setLatitude(Double latitude)
        {
        this.latitude = latitude;
        }

public Double getLatitude()
        {
        return latitude;
        }
public void setLongitude(Double longitude)
        {
        this.longitude = longitude;
        }

public Double getLongitude()
        {
        return longitude;
        }
public void setAddress(String address)
        {
        this.address = address;
        }

public String getAddress()
        {
        return address;
        }
public void setCreatedUserId(String createdUserId)
        {
        this.createdUserId = createdUserId;
        }

public String getCreatedUserId()
        {
        return createdUserId;
        }
public void setAttendRadius(Integer attendRadius)
        {
        this.attendRadius = attendRadius;
        }

public Integer getAttendRadius()
        {
        return attendRadius;
        }
public void setAttendRemark(String attendRemark)
        {
        this.attendRemark = attendRemark;
        }

public String getAttendRemark()
        {
        return attendRemark;
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
public void setCreatedBy(String createdBy)
        {
        this.createdBy = createdBy;
        }

public String getCreatedBy()
        {
        return createdBy;
        }
public void setCreatedTime(Date createdTime)
        {
        this.createdTime = createdTime;
        }

public Date getCreatedTime()
        {
        return createdTime;
        }
public void setUpdatedBy(String updatedBy)
        {
        this.updatedBy = updatedBy;
        }

public String getUpdatedBy()
        {
        return updatedBy;
        }
public void setUpdatedTime(Date updatedTime)
        {
        this.updatedTime = updatedTime;
        }

public Date getUpdatedTime()
        {
        return updatedTime;
        }
@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("tid",getTid())
                .append("id",getId())
                .append("attendSpotType",getAttendSpotType())
                .append("spotCreatedDate",getSpotCreatedDate())
                .append("name",getName())
                .append("projectId",getProjectId())
                .append("latitude",getLatitude())
                .append("longitude",getLongitude())
                .append("address",getAddress())
                .append("createdUserId",getCreatedUserId())
                .append("attendRadius",getAttendRadius())
                .append("attendRemark",getAttendRemark())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdBy",getCreatedBy())
                .append("createdTime",getCreatedTime())
                .append("updatedBy",getUpdatedBy())
                .append("updatedTime",getUpdatedTime())
            .toString();
        }
        }
