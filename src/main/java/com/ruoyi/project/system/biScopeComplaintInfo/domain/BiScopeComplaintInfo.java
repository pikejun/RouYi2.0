package com.ruoyi.project.system.biScopeComplaintInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                import java.util.Date;
        
/**
 * 工人维权表 bi_scope_complaint_info
 *
 * @author ruoyi
 * @date 2019-04-11
 */
public class BiScopeComplaintInfo extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 维权ID */
@Excel(name = "维权ID", prompt = "维权ID")
private String id;
/** 维权创建日期 */
@Excel(name = "维权创建日期", prompt = "维权创建日期")
private Date complaintCreatedDate;
/** 是否结束 */
@Excel(name = "是否结束", prompt = "是否结束")
private Integer done;
/** 工人ID */
@Excel(name = "工人ID", prompt = "工人ID")
private String workerId;
/** 维权类别ID */
@Excel(name = "维权类别ID", prompt = "维权类别ID")
private Integer typeId;
/** 维权类别名称 */
@Excel(name = "维权类别名称", prompt = "维权类别名称")
private String typeName;
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
public void setComplaintCreatedDate(Date complaintCreatedDate)
        {
        this.complaintCreatedDate = complaintCreatedDate;
        }

public Date getComplaintCreatedDate()
        {
        return complaintCreatedDate;
        }
public void setDone(Integer done)
        {
        this.done = done;
        }

public Integer getDone()
        {
        return done;
        }
public void setWorkerId(String workerId)
        {
        this.workerId = workerId;
        }

public String getWorkerId()
        {
        return workerId;
        }
public void setTypeId(Integer typeId)
        {
        this.typeId = typeId;
        }

public Integer getTypeId()
        {
        return typeId;
        }
public void setTypeName(String typeName)
        {
        this.typeName = typeName;
        }

public String getTypeName()
        {
        return typeName;
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
                .append("complaintCreatedDate",getComplaintCreatedDate())
                .append("done",getDone())
                .append("workerId",getWorkerId())
                .append("typeId",getTypeId())
                .append("typeName",getTypeName())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
