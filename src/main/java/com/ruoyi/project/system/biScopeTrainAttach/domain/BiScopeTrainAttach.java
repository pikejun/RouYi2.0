package com.ruoyi.project.system.biScopeTrainAttach.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                    import java.util.Date;
        
/**
 * 培训附件表 bi_scope_train_attach
 *
 * @author ruoyi
 * @date 2019-04-12
 */
public class BiScopeTrainAttach extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 培训附件ID */
@Excel(name = "培训附件ID", prompt = "培训附件ID")
private String id;
/** 附件ID */
@Excel(name = "附件ID", prompt = "附件ID")
private String attachmentId;
/** 上传日期 */
@Excel(name = "上传日期", prompt = "上传日期")
private Date createDate;
/** 培训ID */
@Excel(name = "培训ID", prompt = "培训ID")
private String trainId;
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
public void setAttachmentId(String attachmentId)
        {
        this.attachmentId = attachmentId;
        }

public String getAttachmentId()
        {
        return attachmentId;
        }
public void setCreateDate(Date createDate)
        {
        this.createDate = createDate;
        }

public Date getCreateDate()
        {
        return createDate;
        }
public void setTrainId(String trainId)
        {
        this.trainId = trainId;
        }

public String getTrainId()
        {
        return trainId;
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
                .append("attachmentId",getAttachmentId())
                .append("createDate",getCreateDate())
                .append("trainId",getTrainId())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
