package com.ruoyi.project.system.biScopeSafeEvent.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                    import java.util.Date;
        
/**
 * 安全事件表 bi_scope_safe_event
 *
 * @author ruoyi
 * @date 2019-04-04
 */
public class BiScopeSafeEvent extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 事件ID */
@Excel(name = "事件ID", prompt = "事件ID")
private String id;
/** 事件名称 */
@Excel(name = "事件名称", prompt = "事件名称")
private String eventName;
/** 事件日期 */
@Excel(name = "事件日期", prompt = "事件日期")
private Date eventCreatedDate;
/** 内容 */
@Excel(name = "内容", prompt = "内容")
private String content;
/** 人员组织ID */
@Excel(name = "人员组织ID", prompt = "人员组织ID")
private String checkerId;
/** 用户ID */
@Excel(name = "用户ID", prompt = "用户ID")
private String userId;
/** 事件子类 */
@Excel(name = "事件子类", prompt = "事件子类")
private String itemId;
/** 层级编码 */
@Excel(name = "层级编码", prompt = "层级编码")
private String levelCode;
/** 标段ID */
@Excel(name = "标段ID", prompt = "标段ID")
private String projectUnitId;
/** 事件类型 */
@Excel(name = "事件类型", prompt = "事件类型")
private String type;
/** 是否紧急 */
@Excel(name = "是否紧急", prompt = "是否紧急")
private Integer critical;
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
public void setEventName(String eventName)
        {
        this.eventName = eventName;
        }

public String getEventName()
        {
        return eventName;
        }
public void setEventCreatedDate(Date eventCreatedDate)
        {
        this.eventCreatedDate = eventCreatedDate;
        }

public Date getEventCreatedDate()
        {
        return eventCreatedDate;
        }
public void setContent(String content)
        {
        this.content = content;
        }

public String getContent()
        {
        return content;
        }
public void setCheckerId(String checkerId)
        {
        this.checkerId = checkerId;
        }

public String getCheckerId()
        {
        return checkerId;
        }
public void setUserId(String userId)
        {
        this.userId = userId;
        }

public String getUserId()
        {
        return userId;
        }
public void setItemId(String itemId)
        {
        this.itemId = itemId;
        }

public String getItemId()
        {
        return itemId;
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
public void setType(String type)
        {
        this.type = type;
        }

public String getType()
        {
        return type;
        }
public void setCritical(Integer critical)
        {
        this.critical = critical;
        }

public Integer getCritical()
        {
        return critical;
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
                .append("eventName",getEventName())
                .append("eventCreatedDate",getEventCreatedDate())
                .append("content",getContent())
                .append("checkerId",getCheckerId())
                .append("userId",getUserId())
                .append("itemId",getItemId())
                .append("levelCode",getLevelCode())
                .append("projectUnitId",getProjectUnitId())
                .append("type",getType())
                .append("critical",getCritical())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
