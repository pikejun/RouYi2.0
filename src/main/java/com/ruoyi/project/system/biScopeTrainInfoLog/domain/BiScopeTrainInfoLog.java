package com.ruoyi.project.system.biScopeTrainInfoLog.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                        import java.util.Date;
        
/**
 * 工人培训日志表 bi_scope_train_info_log
 *
 * @author ruoyi
 * @date 2019-04-12
 */
public class BiScopeTrainInfoLog extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 培训日志ID */
@Excel(name = "培训日志ID", prompt = "培训日志ID")
private String id;
/** 培训ID */
@Excel(name = "培训ID", prompt = "培训ID")
private String trainId;
/** 工人ID */
@Excel(name = "工人ID", prompt = "工人ID")
private String workerId;
/** 入场时间 */
@Excel(name = "入场时间", prompt = "入场时间")
private Date enterDate;
/** 入场描述 */
@Excel(name = "入场描述", prompt = "入场描述")
private String enterDesc;
/** 入场图片 */
@Excel(name = "入场图片", prompt = "入场图片")
private String enterImageId;
/** 出场时间 */
@Excel(name = "出场时间", prompt = "出场时间")
private Date exitDate;
/** 出场描述 */
@Excel(name = "出场描述", prompt = "出场描述")
private String exitDesc;
/** 出场图片 */
@Excel(name = "出场图片", prompt = "出场图片")
private String exitImageId;
/** 是否完成 */
@Excel(name = "是否完成", prompt = "是否完成")
private Integer finish;
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
public void setTrainId(String trainId)
        {
        this.trainId = trainId;
        }

public String getTrainId()
        {
        return trainId;
        }
public void setWorkerId(String workerId)
        {
        this.workerId = workerId;
        }

public String getWorkerId()
        {
        return workerId;
        }
public void setEnterDate(Date enterDate)
        {
        this.enterDate = enterDate;
        }

public Date getEnterDate()
        {
        return enterDate;
        }
public void setEnterDesc(String enterDesc)
        {
        this.enterDesc = enterDesc;
        }

public String getEnterDesc()
        {
        return enterDesc;
        }
public void setEnterImageId(String enterImageId)
        {
        this.enterImageId = enterImageId;
        }

public String getEnterImageId()
        {
        return enterImageId;
        }
public void setExitDate(Date exitDate)
        {
        this.exitDate = exitDate;
        }

public Date getExitDate()
        {
        return exitDate;
        }
public void setExitDesc(String exitDesc)
        {
        this.exitDesc = exitDesc;
        }

public String getExitDesc()
        {
        return exitDesc;
        }
public void setExitImageId(String exitImageId)
        {
        this.exitImageId = exitImageId;
        }

public String getExitImageId()
        {
        return exitImageId;
        }
public void setFinish(Integer finish)
        {
        this.finish = finish;
        }

public Integer getFinish()
        {
        return finish;
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
                .append("trainId",getTrainId())
                .append("workerId",getWorkerId())
                .append("enterDate",getEnterDate())
                .append("enterDesc",getEnterDesc())
                .append("enterImageId",getEnterImageId())
                .append("exitDate",getExitDate())
                .append("exitDesc",getExitDesc())
                .append("exitImageId",getExitImageId())
                .append("finish",getFinish())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
