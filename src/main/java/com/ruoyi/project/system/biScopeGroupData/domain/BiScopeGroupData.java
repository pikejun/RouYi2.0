package com.ruoyi.project.system.biScopeGroupData.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                import java.util.Date;
        
/**
 * 项目班组数据表 bi_scope_group_data
 *
 * @author ruoyi
 * @date 2019-04-13
 */
public class BiScopeGroupData extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 班组ID */
@Excel(name = "班组ID", prompt = "班组ID")
private String id;
/** 班组创建日期 */
@Excel(name = "班组创建日期", prompt = "班组创建日期")
private Date createDate;
/** 班组名称 */
@Excel(name = "班组名称", prompt = "班组名称")
private String name;
/** 层级编码 */
@Excel(name = "层级编码", prompt = "层级编码")
private String levelCode;
/** 上级标段ID */
@Excel(name = "上级标段ID", prompt = "上级标段ID")
private String parentId;
/** 项目ID */
@Excel(name = "项目ID", prompt = "项目ID")
private String projectId;
/** 总工程ID */
@Excel(name = "总工程ID", prompt = "总工程ID")
private String rootProjectId;
/** 备注 */
@Excel(name = "备注", prompt = "备注")
private String remark;
/** 离场日期 */
@Excel(name = "离场日期", prompt = "离场日期")
private Date updateDate;
/** 班组状态 */
@Excel(name = "班组状态", prompt = "班组状态")
private String workStatus;
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
public void setCreateDate(Date createDate)
        {
        this.createDate = createDate;
        }

public Date getCreateDate()
        {
        return createDate;
        }
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
        }
public void setLevelCode(String levelCode)
        {
        this.levelCode = levelCode;
        }

public String getLevelCode()
        {
        return levelCode;
        }
public void setParentId(String parentId)
        {
        this.parentId = parentId;
        }

public String getParentId()
        {
        return parentId;
        }
public void setProjectId(String projectId)
        {
        this.projectId = projectId;
        }

public String getProjectId()
        {
        return projectId;
        }
public void setRootProjectId(String rootProjectId)
        {
        this.rootProjectId = rootProjectId;
        }

public String getRootProjectId()
        {
        return rootProjectId;
        }
public void setRemark(String remark)
        {
        this.remark = remark;
        }

public String getRemark()
        {
        return remark;
        }
public void setUpdateDate(Date updateDate)
        {
        this.updateDate = updateDate;
        }

public Date getUpdateDate()
        {
        return updateDate;
        }
public void setWorkStatus(String workStatus)
        {
        this.workStatus = workStatus;
        }

public String getWorkStatus()
        {
        return workStatus;
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
                .append("createDate",getCreateDate())
                .append("name",getName())
                .append("levelCode",getLevelCode())
                .append("parentId",getParentId())
                .append("projectId",getProjectId())
                .append("rootProjectId",getRootProjectId())
                .append("remark",getRemark())
                .append("updateDate",getUpdateDate())
                .append("workStatus",getWorkStatus())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
