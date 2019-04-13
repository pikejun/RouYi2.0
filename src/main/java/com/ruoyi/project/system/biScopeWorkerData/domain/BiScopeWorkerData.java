package com.ruoyi.project.system.biScopeWorkerData.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                                        import java.util.Date;
        
/**
 * 工人数据表 bi_scope_worker_data
 *
 * @author ruoyi
 * @date 2019-04-11
 */
public class BiScopeWorkerData extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 工人ID */
@Excel(name = "工人ID", prompt = "工人ID")
private String id;
/** 工人姓名 */
@Excel(name = "工人姓名", prompt = "工人姓名")
private String workerName;
/** 班组ID */
@Excel(name = "班组ID", prompt = "班组ID")
private String groupId;
/** 工种ID */
@Excel(name = "工种ID", prompt = "工种ID")
private String workTypeId;
/** 工种名称 */
@Excel(name = "工种名称", prompt = "工种名称")
private String workTypeName;
/** 实名ID */
@Excel(name = "实名ID", prompt = "实名ID")
private String realNameId;
/** 实名状态 */
@Excel(name = "实名状态", prompt = "实名状态")
private String realStatus;
/** 实名日期 */
@Excel(name = "实名日期", prompt = "实名日期")
private Date realDate;
/** 工作状态 */
@Excel(name = "工作状态", prompt = "工作状态")
private String workStatus;
/** 入场三级 */
@Excel(name = "入场三级", prompt = "入场三级")
private Integer enterTrain;
/** 技术交底 */
@Excel(name = "技术交底", prompt = "技术交底")
private Integer techniqueTrain;
/** 工卡编号 */
@Excel(name = "工卡编号", prompt = "工卡编号")
private String entranceCardId;
/** 最后安全扣分日期 */
@Excel(name = "最后安全扣分日期", prompt = "最后安全扣分日期")
private Date lastSafetyDate;
/** 安全扣分次数 */
@Excel(name = "安全扣分次数", prompt = "安全扣分次数")
private Integer safetyCount;
/** 安全扣分总分 */
@Excel(name = "安全扣分总分", prompt = "安全扣分总分")
private Integer safetyScore;
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
public void setWorkerName(String workerName)
        {
        this.workerName = workerName;
        }

public String getWorkerName()
        {
        return workerName;
        }
public void setGroupId(String groupId)
        {
        this.groupId = groupId;
        }

public String getGroupId()
        {
        return groupId;
        }
public void setWorkTypeId(String workTypeId)
        {
        this.workTypeId = workTypeId;
        }

public String getWorkTypeId()
        {
        return workTypeId;
        }
public void setWorkTypeName(String workTypeName)
        {
        this.workTypeName = workTypeName;
        }

public String getWorkTypeName()
        {
        return workTypeName;
        }
public void setRealNameId(String realNameId)
        {
        this.realNameId = realNameId;
        }

public String getRealNameId()
        {
        return realNameId;
        }
public void setRealStatus(String realStatus)
        {
        this.realStatus = realStatus;
        }

public String getRealStatus()
        {
        return realStatus;
        }
public void setRealDate(Date realDate)
        {
        this.realDate = realDate;
        }

public Date getRealDate()
        {
        return realDate;
        }
public void setWorkStatus(String workStatus)
        {
        this.workStatus = workStatus;
        }

public String getWorkStatus()
        {
        return workStatus;
        }
public void setEnterTrain(Integer enterTrain)
        {
        this.enterTrain = enterTrain;
        }

public Integer getEnterTrain()
        {
        return enterTrain;
        }
public void setTechniqueTrain(Integer techniqueTrain)
        {
        this.techniqueTrain = techniqueTrain;
        }

public Integer getTechniqueTrain()
        {
        return techniqueTrain;
        }
public void setEntranceCardId(String entranceCardId)
        {
        this.entranceCardId = entranceCardId;
        }

public String getEntranceCardId()
        {
        return entranceCardId;
        }
public void setLastSafetyDate(Date lastSafetyDate)
        {
        this.lastSafetyDate = lastSafetyDate;
        }

public Date getLastSafetyDate()
        {
        return lastSafetyDate;
        }
public void setSafetyCount(Integer safetyCount)
        {
        this.safetyCount = safetyCount;
        }

public Integer getSafetyCount()
        {
        return safetyCount;
        }
public void setSafetyScore(Integer safetyScore)
        {
        this.safetyScore = safetyScore;
        }

public Integer getSafetyScore()
        {
        return safetyScore;
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
                .append("workerName",getWorkerName())
                .append("groupId",getGroupId())
                .append("workTypeId",getWorkTypeId())
                .append("workTypeName",getWorkTypeName())
                .append("realNameId",getRealNameId())
                .append("realStatus",getRealStatus())
                .append("realDate",getRealDate())
                .append("workStatus",getWorkStatus())
                .append("enterTrain",getEnterTrain())
                .append("techniqueTrain",getTechniqueTrain())
                .append("entranceCardId",getEntranceCardId())
                .append("lastSafetyDate",getLastSafetyDate())
                .append("safetyCount",getSafetyCount())
                .append("safetyScore",getSafetyScore())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
