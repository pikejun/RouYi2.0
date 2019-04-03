package com.ruoyi.project.system.biScopeInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                        import java.util.Date;
        
/**
 * 范围表 bi_scope_info
 *
 * @author ruoyi
 * @date 2019-03-18
 */
public class BiScopeInfo extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 范围ID */
@Excel(name = "范围ID", prompt = "范围ID")
private Integer scopeId;
/** 范围名称 */
@Excel(name = "范围名称", prompt = "范围名称")
private String scopeName;
/** 范围名称描述 */
@Excel(name = "范围名称描述", prompt = "范围名称描述")
private String scopeNameDesc;
/** 范围状态 */
@Excel(name = "范围状态", prompt = "范围状态")
private Integer status;
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

public void setScopeId(Integer scopeId)
        {
        this.scopeId = scopeId;
        }

public Integer getScopeId()
        {
        return scopeId;
        }
public void setScopeName(String scopeName)
        {
        this.scopeName = scopeName;
        }

public String getScopeName()
        {
        return scopeName;
        }
public void setScopeNameDesc(String scopeNameDesc)
        {
        this.scopeNameDesc = scopeNameDesc;
        }

public String getScopeNameDesc()
        {
        return scopeNameDesc;
        }
public void setStatus(Integer status)
        {
        this.status = status;
        }

public Integer getStatus()
        {
        return status;
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
                .append("scopeId",getScopeId())
                .append("scopeName",getScopeName())
                .append("scopeNameDesc",getScopeNameDesc())
                .append("status",getStatus())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
