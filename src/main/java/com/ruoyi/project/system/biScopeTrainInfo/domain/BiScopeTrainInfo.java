package com.ruoyi.project.system.biScopeTrainInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                    import java.util.Date;
        
/**
 * 培训表 bi_scope_train_info
 *
 * @author ruoyi
 * @date 2019-04-03
 */
public class BiScopeTrainInfo extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 培训ID */
@Excel(name = "培训ID", prompt = "培训ID")
private String id;
/** 出勤人ID */
@Excel(name = "出勤人ID", prompt = "出勤人ID")
private String attendUserId;
/** 培训创建日期 */
@Excel(name = "培训创建日期", prompt = "培训创建日期")
private Date trainCreateDate;
/** 培训创建人 */
@Excel(name = "培训创建人", prompt = "培训创建人")
private String createUserId;
/** 开始日期 */
@Excel(name = "开始日期", prompt = "开始日期")
private Date startDate;
/** 结束日期 */
@Excel(name = "结束日期", prompt = "结束日期")
private Date endDate;
/** 层级编码 */
@Excel(name = "层级编码", prompt = "层级编码")
private String levelCode;
/** 地点ID */
@Excel(name = "地点ID", prompt = "地点ID")
private String locationId;
/** 培训名称 */
@Excel(name = "培训名称", prompt = "培训名称")
private String name;
/** 班组ID */
@Excel(name = "班组ID", prompt = "班组ID")
private String projectGroupId;
/** 标段ID */
@Excel(name = "标段ID", prompt = "标段ID")
private String projectUnitId;
/** 场景ID */
@Excel(name = "场景ID", prompt = "场景ID")
private String sceneId;
/** 培训人ID */
@Excel(name = "培训人ID", prompt = "培训人ID")
private String trainUserId;
/** 培训类型 */
@Excel(name = "培训类型", prompt = "培训类型")
private String type;
/** 操作状态 */
@Excel(name = "操作状态", prompt = "操作状态")
private String opStatus;
/** 操作类型 */
@Excel(name = "操作类型", prompt = "操作类型")
private String opType;
/** 创建日期 */
@Excel(name = "创建日期", prompt = "创建日期")
private Date createdTime;
/** 创建人 */
@Excel(name = "创建人", prompt = "创建人")
private String createdBy;
/** 更新日期 */
@Excel(name = "更新日期", prompt = "更新日期")
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
public void setAttendUserId(String attendUserId)
        {
        this.attendUserId = attendUserId;
        }

public String getAttendUserId()
        {
        return attendUserId;
        }
public void setTrainCreateDate(Date trainCreateDate)
        {
        this.trainCreateDate = trainCreateDate;
        }

public Date getTrainCreateDate()
        {
        return trainCreateDate;
        }
public void setCreateUserId(String createUserId)
        {
        this.createUserId = createUserId;
        }

public String getCreateUserId()
        {
        return createUserId;
        }
public void setStartDate(Date startDate)
        {
        this.startDate = startDate;
        }

public Date getStartDate()
        {
        return startDate;
        }
public void setEndDate(Date endDate)
        {
        this.endDate = endDate;
        }

public Date getEndDate()
        {
        return endDate;
        }
public void setLevelCode(String levelCode)
        {
        this.levelCode = levelCode;
        }

public String getLevelCode()
        {
        return levelCode;
        }
public void setLocationId(String locationId)
        {
        this.locationId = locationId;
        }

public String getLocationId()
        {
        return locationId;
        }
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
        }
public void setProjectGroupId(String projectGroupId)
        {
        this.projectGroupId = projectGroupId;
        }

public String getProjectGroupId()
        {
        return projectGroupId;
        }
public void setProjectUnitId(String projectUnitId)
        {
        this.projectUnitId = projectUnitId;
        }

public String getProjectUnitId()
        {
        return projectUnitId;
        }
public void setSceneId(String sceneId)
        {
        this.sceneId = sceneId;
        }

public String getSceneId()
        {
        return sceneId;
        }
public void setTrainUserId(String trainUserId)
        {
        this.trainUserId = trainUserId;
        }

public String getTrainUserId()
        {
        return trainUserId;
        }
public void setType(String type)
        {
        this.type = type;
        }

public String getType()
        {
        return type;
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
                .append("attendUserId",getAttendUserId())
                .append("trainCreateDate",getTrainCreateDate())
                .append("createUserId",getCreateUserId())
                .append("startDate",getStartDate())
                .append("endDate",getEndDate())
                .append("levelCode",getLevelCode())
                .append("locationId",getLocationId())
                .append("name",getName())
                .append("projectGroupId",getProjectGroupId())
                .append("projectUnitId",getProjectUnitId())
                .append("sceneId",getSceneId())
                .append("trainUserId",getTrainUserId())
                .append("type",getType())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }

                public Date getUpdatedTime() {
                        return updatedTime;
                }

                public Date getCreatedTime() {
                        return createdTime;
                }

                public void setCreatedTime(Date createdTime) {
                        this.createdTime = createdTime;
                }

                public void setUpdatedTime(Date updatedTime) {
                        this.updatedTime = updatedTime;
                }
        }
