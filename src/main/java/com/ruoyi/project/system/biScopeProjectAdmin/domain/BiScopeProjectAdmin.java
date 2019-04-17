package com.ruoyi.project.system.biScopeProjectAdmin.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                                                import java.util.Date;
        
/**
 * 项目管理员表 bi_scope_project_admin
 *
 * @author ruoyi
 * @date 2019-04-17
 */
public class BiScopeProjectAdmin extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 项目管理员ID */
@Excel(name = "项目管理员ID", prompt = "项目管理员ID")
private String id;
/** 项目管理员姓名 */
@Excel(name = "项目管理员姓名", prompt = "项目管理员姓名")
private String name;
/** 实名ID */
@Excel(name = "实名ID", prompt = "实名ID")
private String realNameId;
/** 工作状态 */
@Excel(name = "工作状态", prompt = "工作状态")
private String workStatus;
/** 项目ID */
@Excel(name = "项目ID", prompt = "项目ID")
private String projectId;
/** 层级编码 */
@Excel(name = "层级编码", prompt = "层级编码")
private String levelCode;
/** 总工程ID */
@Excel(name = "总工程ID", prompt = "总工程ID")
private String rootProjectId;
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
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
        }
public void setRealNameId(String realNameId)
        {
        this.realNameId = realNameId;
        }

public String getRealNameId()
        {
        return realNameId;
        }
public void setWorkStatus(String workStatus)
        {
        this.workStatus = workStatus;
        }

public String getWorkStatus()
        {
        return workStatus;
        }
public void setProjectId(String projectId)
        {
        this.projectId = projectId;
        }

public String getProjectId()
        {
        return projectId;
        }
public void setLevelCode(String levelCode)
        {
        this.levelCode = levelCode;
        }

public String getLevelCode()
        {
        return levelCode;
        }
public void setRootProjectId(String rootProjectId)
        {
        this.rootProjectId = rootProjectId;
        }

public String getRootProjectId()
        {
        return rootProjectId;
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
                .append("name",getName())
                .append("realNameId",getRealNameId())
                .append("workStatus",getWorkStatus())
                .append("projectId",getProjectId())
                .append("levelCode",getLevelCode())
                .append("rootProjectId",getRootProjectId())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
