package com.ruoyi.project.system.biScopeComplaintLog.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                        import java.util.Date;
        
/**
 * 维权日志表 bi_scope_complaint_log
 *
 * @author ruoyi
 * @date 2019-04-12
 */
public class BiScopeComplaintLog extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 维权日志ID */
@Excel(name = "维权日志ID", prompt = "维权日志ID")
private String id;
/** 维权ID */
@Excel(name = "维权ID", prompt = "维权ID")
private String complaintId;
/** 日志内容 */
@Excel(name = "日志内容", prompt = "日志内容")
private String content;
/** 发表时间 */
@Excel(name = "发表时间", prompt = "发表时间")
private Date createDate;
/** 是否发起人 */
@Excel(name = "是否发起人", prompt = "是否发起人")
private Boolean sender;
/** 回复人ID */
@Excel(name = "回复人ID", prompt = "回复人ID")
private String replayId;
/** 回复人姓名 */
@Excel(name = "回复人姓名", prompt = "回复人姓名")
private String replayName;
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
public void setComplaintId(String complaintId)
        {
        this.complaintId = complaintId;
        }

public String getComplaintId()
        {
        return complaintId;
        }
public void setContent(String content)
        {
        this.content = content;
        }

public String getContent()
        {
        return content;
        }
public void setCreateDate(Date createDate)
        {
        this.createDate = createDate;
        }

public Date getCreateDate()
        {
        return createDate;
        }
public void setSender(Boolean sender)
        {
        this.sender = sender;
        }

public Boolean getSender()
        {
        return sender;
        }
public void setReplayId(String replayId)
        {
        this.replayId = replayId;
        }

public String getReplayId()
        {
        return replayId;
        }
public void setReplayName(String replayName)
        {
        this.replayName = replayName;
        }

public String getReplayName()
        {
        return replayName;
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
                .append("complaintId",getComplaintId())
                .append("content",getContent())
                .append("createDate",getCreateDate())
                .append("sender",getSender())
                .append("replayId",getReplayId())
                .append("replayName",getReplayName())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
