package com.ruoyi.project.system.biScopeEnterpriseDepartment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                    import java.util.Date;
        
/**
 * 企业部门表 bi_scope_enterprise_department
 *
 * @author ruoyi
 * @date 2019-04-08
 */
public class BiScopeEnterpriseDepartment extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 部门ID */
@Excel(name = "部门ID", prompt = "部门ID")
private String id;
/** 部门简称 */
@Excel(name = "部门简称", prompt = "部门简称")
private String abbrName;
/** 创建日期 */
@Excel(name = "创建日期", prompt = "创建日期")
private Date createDate;
/** 企业ID */
@Excel(name = "企业ID", prompt = "企业ID")
private String enterpriseId;
/** 层级编码 */
@Excel(name = "层级编码", prompt = "层级编码")
private String levelCode;
/** 部门名称 */
@Excel(name = "部门名称", prompt = "部门名称")
private String name;
/** 上级部门ID */
@Excel(name = "上级部门ID", prompt = "上级部门ID")
private String parentId;
/** 备注 */
@Excel(name = "备注", prompt = "备注")
private String remark;
/** 根部门ID */
@Excel(name = "根部门ID", prompt = "根部门ID")
private String rootId;
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
public void setEnterpriseId(String enterpriseId)
        {
        this.enterpriseId = enterpriseId;
        }

public String getEnterpriseId()
        {
        return enterpriseId;
        }
public void setLevelCode(String levelCode)
        {
        this.levelCode = levelCode;
        }

public String getLevelCode()
        {
        return levelCode;
        }
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
        }
public void setParentId(String parentId)
        {
        this.parentId = parentId;
        }

public String getParentId()
        {
        return parentId;
        }
public void setRemark(String remark)
        {
        this.remark = remark;
        }

public String getRemark()
        {
        return remark;
        }
public void setRootId(String rootId)
        {
        this.rootId = rootId;
        }

public String getRootId()
        {
        return rootId;
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
                .append("enterpriseId",getEnterpriseId())
                .append("levelCode",getLevelCode())
                .append("name",getName())
                .append("parentId",getParentId())
                .append("remark",getRemark())
                .append("rootId",getRootId())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
