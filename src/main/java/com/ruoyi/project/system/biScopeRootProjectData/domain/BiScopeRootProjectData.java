package com.ruoyi.project.system.biScopeRootProjectData.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                    import java.util.Date;
        
/**
 * 总工程表 bi_scope_root_project_data
 *
 * @author ruoyi
 * @date 2019-04-09
 */
public class BiScopeRootProjectData extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 总工程ID */
@Excel(name = "总工程ID", prompt = "总工程ID")
private String id;
/** 总工程简称 */
@Excel(name = "总工程简称", prompt = "总工程简称")
private String abbrName;
/** 总工程日期 */
@Excel(name = "总工程日期", prompt = "总工程日期")
private Date createDate;
/** 总工程创建人ID */
@Excel(name = "总工程创建人ID", prompt = "总工程创建人ID")
private String createUser;
/** 总工程名称 */
@Excel(name = "总工程名称", prompt = "总工程名称")
private String name;
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
public void setAbbrName(String abbrName)
        {
        this.abbrName = abbrName;
        }

public String getAbbrName()
        {
        return abbrName;
        }
public void setCreateDate(Date createDate)
        {
        this.createDate = createDate;
        }

public Date getCreateDate()
        {
        return createDate;
        }
public void setCreateUser(String createUser)
        {
        this.createUser = createUser;
        }

public String getCreateUser()
        {
        return createUser;
        }
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
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
                .append("abbrName",getAbbrName())
                .append("createDate",getCreateDate())
                .append("createUser",getCreateUser())
                .append("name",getName())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
