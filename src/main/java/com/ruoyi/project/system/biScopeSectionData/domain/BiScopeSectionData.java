package com.ruoyi.project.system.biScopeSectionData.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                        import java.util.Date;
        
/**
 * 标段数据表 bi_scope_section_data
 *
 * @author ruoyi
 * @date 2019-04-10
 */
public class BiScopeSectionData extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 标段ID */
@Excel(name = "标段ID", prompt = "标段ID")
private String id;
/** 标段简称 */
@Excel(name = "标段简称", prompt = "标段简称")
private String abbrName;
/** 标段别名 */
@Excel(name = "标段别名", prompt = "标段别名")
private String aliasName;
/** 标段创建时间 */
@Excel(name = "标段创建时间", prompt = "标段创建时间")
private Date createDate;
/** 所属企业ID */
@Excel(name = "所属企业ID", prompt = "所属企业ID")
private String enterpriseId;
/** 标段名称 */
@Excel(name = "标段名称", prompt = "标段名称")
private String name;
/** 总项目ID */
@Excel(name = "总项目ID", prompt = "总项目ID")
private String rootProjectId;
/** 备注 */
@Excel(name = "备注", prompt = "备注")
private String remark;
/** 标段更新时间 */
@Excel(name = "标段更新时间", prompt = "标段更新时间")
private Date updateDate;
/** 标段工作状态 */
@Excel(name = "标段工作状态", prompt = "标段工作状态")
private String workStatus;
/** 标段地址 */
@Excel(name = "标段地址", prompt = "标段地址")
private String address;
/** 标段地址编码 */
@Excel(name = "标段地址编码", prompt = "标段地址编码")
private String areaId;
/** 标段层级编码 */
@Excel(name = "标段层级编码", prompt = "标段层级编码")
private String levelCode;
/** 所属项目ID */
@Excel(name = "所属项目ID", prompt = "所属项目ID")
private String projectId;
/** 上级标段ID */
@Excel(name = "上级标段ID", prompt = "上级标段ID")
private String parentId;
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
public void setAliasName(String aliasName)
        {
        this.aliasName = aliasName;
        }

public String getAliasName()
        {
        return aliasName;
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
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
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
public void setAddress(String address)
        {
        this.address = address;
        }

public String getAddress()
        {
        return address;
        }
public void setAreaId(String areaId)
        {
        this.areaId = areaId;
        }

public String getAreaId()
        {
        return areaId;
        }
public void setLevelCode(String levelCode)
        {
        this.levelCode = levelCode;
        }

public String getLevelCode()
        {
        return levelCode;
        }
public void setProjectId(String projectId)
        {
        this.projectId = projectId;
        }

public String getProjectId()
        {
        return projectId;
        }
public void setParentId(String parentId)
        {
        this.parentId = parentId;
        }

public String getParentId()
        {
        return parentId;
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
                .append("aliasName",getAliasName())
                .append("createDate",getCreateDate())
                .append("enterpriseId",getEnterpriseId())
                .append("name",getName())
                .append("rootProjectId",getRootProjectId())
                .append("remark",getRemark())
                .append("updateDate",getUpdateDate())
                .append("workStatus",getWorkStatus())
                .append("address",getAddress())
                .append("areaId",getAreaId())
                .append("levelCode",getLevelCode())
                .append("projectId",getProjectId())
                .append("parentId",getParentId())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
