package com.ruoyi.project.system.biScopeWorkerSafeEvent.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                import java.util.Date;
        
/**
 * 工人安全事件表 bi_scope_worker_safe_event
 *
 * @author ruoyi
 * @date 2019-04-12
 */
public class BiScopeWorkerSafeEvent extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 事件ID */
@Excel(name = "事件ID", prompt = "事件ID")
private String id;
/** 事件日期 */
@Excel(name = "事件日期", prompt = "事件日期")
private Date eventDate;
/** 事件备注 */
@Excel(name = "事件备注", prompt = "事件备注")
private String remark;
/** 检查人ID */
@Excel(name = "检查人ID", prompt = "检查人ID")
private String checkerId;
/** 被扣分工人ID */
@Excel(name = "被扣分工人ID", prompt = "被扣分工人ID")
private String workerId;
/** 事件子类ID */
@Excel(name = "事件子类ID", prompt = "事件子类ID")
private String itemId;
/** 事件子类名称 */
@Excel(name = "事件子类名称", prompt = "事件子类名称")
private String itemName;
/** 事件类别ID */
@Excel(name = "事件类别ID", prompt = "事件类别ID")
private String typeId;
/** 事件类别名称 */
@Excel(name = "事件类别名称", prompt = "事件类别名称")
private String typeName;
/** 事件扣分分值 */
@Excel(name = "事件扣分分值", prompt = "事件扣分分值")
private Integer eventPoints;
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
public void setEventDate(Date eventDate)
        {
        this.eventDate = eventDate;
        }

public Date getEventDate()
        {
        return eventDate;
        }
public void setRemark(String remark)
        {
        this.remark = remark;
        }

public String getRemark()
        {
        return remark;
        }
public void setCheckerId(String checkerId)
        {
        this.checkerId = checkerId;
        }

public String getCheckerId()
        {
        return checkerId;
        }
public void setWorkerId(String workerId)
        {
        this.workerId = workerId;
        }

public String getWorkerId()
        {
        return workerId;
        }
public void setItemId(String itemId)
        {
        this.itemId = itemId;
        }

public String getItemId()
        {
        return itemId;
        }
public void setItemName(String itemName)
        {
        this.itemName = itemName;
        }

public String getItemName()
        {
        return itemName;
        }
public void setTypeId(String typeId)
        {
        this.typeId = typeId;
        }

public String getTypeId()
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
public void setEventPoints(Integer eventPoints)
        {
        this.eventPoints = eventPoints;
        }

public Integer getEventPoints()
        {
        return eventPoints;
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
                .append("eventDate",getEventDate())
                .append("remark",getRemark())
                .append("checkerId",getCheckerId())
                .append("workerId",getWorkerId())
                .append("itemId",getItemId())
                .append("itemName",getItemName())
                .append("typeId",getTypeId())
                .append("typeName",getTypeName())
                .append("eventPoints",getEventPoints())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
