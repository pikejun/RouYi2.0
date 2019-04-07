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
 * @date 2019-04-07
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
/** 用户ID */
@Excel(name = "用户ID", prompt = "用户ID")
private String userId;
/** 用户姓名 */
@Excel(name = "用户姓名", prompt = "用户姓名")
private String username;
/** 身份证号 */
@Excel(name = "身份证号", prompt = "身份证号")
private String number;
/** 手机号 */
@Excel(name = "手机号", prompt = "手机号")
private String mobile;
/** 项目ID */
@Excel(name = "项目ID", prompt = "项目ID")
private String ownerId;
/** 标段ID */
@Excel(name = "标段ID", prompt = "标段ID")
private String projectSectionId;
/** 层级编码 */
@Excel(name = "层级编码", prompt = "层级编码")
private String levelCode;
/** 属主类型 */
@Excel(name = "属主类型", prompt = "属主类型")
private String ownerType;
/** 实名类型 */
@Excel(name = "实名类型", prompt = "实名类型")
private String realStatus;
/** 实名日期 */
@Excel(name = "实名日期", prompt = "实名日期")
private Date realDate;
/** 工作状态 */
@Excel(name = "工作状态", prompt = "工作状态")
private String workStatus;
/** 工种ID */
@Excel(name = "工种ID", prompt = "工种ID")
private String workTypeId;
/** 工种名称 */
@Excel(name = "工种名称", prompt = "工种名称")
private String workTypeName;
/** 工人创建日期 */
@Excel(name = "工人创建日期", prompt = "工人创建日期")
private Date workCreateDate;
/** 是否入场培训 */
@Excel(name = "是否入场培训", prompt = "是否入场培训")
private String enterTrain;
/** 最后安全扣分日期 */
@Excel(name = "最后安全扣分日期", prompt = "最后安全扣分日期")
private Date lastSafetyDate;
/** 安全扣分次数 */
@Excel(name = "安全扣分次数", prompt = "安全扣分次数")
private Integer safetyCount;
/** 安全扣分总分 */
@Excel(name = "安全扣分总分", prompt = "安全扣分总分")
private Integer safetyScore;
/** 是否技术培训 */
@Excel(name = "是否技术培训", prompt = "是否技术培训")
private String techniqueTrain;
/** IC卡号 */
@Excel(name = "IC卡号", prompt = "IC卡号")
private String entranceCardId;
/** 班组ID */
@Excel(name = "班组ID", prompt = "班组ID")
private String projectGroupId;
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
public void setUserId(String userId)
        {
        this.userId = userId;
        }

public String getUserId()
        {
        return userId;
        }
public void setUsername(String username)
        {
        this.username = username;
        }

public String getUsername()
        {
        return username;
        }
public void setNumber(String number)
        {
        this.number = number;
        }

public String getNumber()
        {
        return number;
        }
public void setMobile(String mobile)
        {
        this.mobile = mobile;
        }

public String getMobile()
        {
        return mobile;
        }
public void setOwnerId(String ownerId)
        {
        this.ownerId = ownerId;
        }

public String getOwnerId()
        {
        return ownerId;
        }
public void setProjectSectionId(String projectSectionId)
        {
        this.projectSectionId = projectSectionId;
        }

public String getProjectSectionId()
        {
        return projectSectionId;
        }
public void setLevelCode(String levelCode)
        {
        this.levelCode = levelCode;
        }

public String getLevelCode()
        {
        return levelCode;
        }
public void setOwnerType(String ownerType)
        {
        this.ownerType = ownerType;
        }

public String getOwnerType()
        {
        return ownerType;
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
public void setWorkCreateDate(Date workCreateDate)
        {
        this.workCreateDate = workCreateDate;
        }

public Date getWorkCreateDate()
        {
        return workCreateDate;
        }
public void setEnterTrain(String enterTrain)
        {
        this.enterTrain = enterTrain;
        }

public String getEnterTrain()
        {
        return enterTrain;
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
public void setTechniqueTrain(String techniqueTrain)
        {
        this.techniqueTrain = techniqueTrain;
        }

public String getTechniqueTrain()
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
public void setProjectGroupId(String projectGroupId)
        {
        this.projectGroupId = projectGroupId;
        }

public String getProjectGroupId()
        {
        return projectGroupId;
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
                .append("userId",getUserId())
                .append("username",getUsername())
                .append("number",getNumber())
                .append("mobile",getMobile())
                .append("ownerId",getOwnerId())
                .append("projectSectionId",getProjectSectionId())
                .append("levelCode",getLevelCode())
                .append("ownerType",getOwnerType())
                .append("realStatus",getRealStatus())
                .append("realDate",getRealDate())
                .append("workStatus",getWorkStatus())
                .append("workTypeId",getWorkTypeId())
                .append("workTypeName",getWorkTypeName())
                .append("workCreateDate",getWorkCreateDate())
                .append("enterTrain",getEnterTrain())
                .append("lastSafetyDate",getLastSafetyDate())
                .append("safetyCount",getSafetyCount())
                .append("safetyScore",getSafetyScore())
                .append("techniqueTrain",getTechniqueTrain())
                .append("entranceCardId",getEntranceCardId())
                .append("projectGroupId",getProjectGroupId())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
