package com.ruoyi.project.system.biScopeProjectData.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                        import java.util.Date;
        
/**
 * 项目数据表 bi_scope_project_data
 *
 * @author ruoyi
 * @date 2019-04-09
 */
public class BiScopeProjectData extends BaseEntity
        {
private static final long serialVersionUID=1L;

/**  */
@Excel(name = "", prompt = "")
private Integer tid;
/** 项目ID */
@Excel(name = "项目ID", prompt = "项目ID")
private String id;
/** 项目简称 */
@Excel(name = "项目简称", prompt = "项目简称")
private String abbrName;
/** 项目别名 */
@Excel(name = "项目别名", prompt = "项目别名")
private String aliasName;
/** 项目日期 */
@Excel(name = "项目日期", prompt = "项目日期")
private Date createDate;
/** 关联企业ID */
@Excel(name = "关联企业ID", prompt = "关联企业ID")
private String enterpriseId;
/** 项目名称 */
@Excel(name = "项目名称", prompt = "项目名称")
private String name;
/** 总工程ID */
@Excel(name = "总工程ID", prompt = "总工程ID")
private String rootProjectId;
/** 备注 */
@Excel(name = "备注", prompt = "备注")
private String remark;
/** 项目更新日期 */
@Excel(name = "项目更新日期", prompt = "项目更新日期")
private Date updateDate;
/** 项目状态 */
@Excel(name = "项目状态", prompt = "项目状态")
private String workStatus;
/** 项目地址 */
@Excel(name = "项目地址", prompt = "项目地址")
private String address;
/** 区域ID */
@Excel(name = "区域ID", prompt = "区域ID")
private String areaId;
/** 项目性质ID */
@Excel(name = "项目性质ID", prompt = "项目性质ID")
private String buildNatureId;
/** 施工合同编号 */
@Excel(name = "施工合同编号", prompt = "施工合同编号")
private String contractNo;
/** 项目造价 */
@Excel(name = "项目造价", prompt = "项目造价")
private String costMoney;
/** 竣工日期 */
@Excel(name = "竣工日期", prompt = "竣工日期")
private Date endDate;
/** 项目面积 */
@Excel(name = "项目面积", prompt = "项目面积")
private String floorArea;
/** 项目长度 */
@Excel(name = "项目长度", prompt = "项目长度")
private String length;
/** 上级单位 */
@Excel(name = "上级单位", prompt = "上级单位")
private String parentEnterpriseId;
/** 施工许可证号 */
@Excel(name = "施工许可证号", prompt = "施工许可证号")
private String permitNo;
/** 备案号 */
@Excel(name = "备案号", prompt = "备案号")
private String recordNo;
/** 项目编号 */
@Excel(name = "项目编号", prompt = "项目编号")
private String serialNo;
/** 单位标签 */
@Excel(name = "单位标签", prompt = "单位标签")
private String signType;
/** 开工日期 */
@Excel(name = "开工日期", prompt = "开工日期")
private Date startDate;
/** 项目状态 */
@Excel(name = "项目状态", prompt = "项目状态")
private String status;
/** 操作状态 */
@Excel(name = "操作状态", prompt = "操作状态")
private String opStatus;
/** 操作类型 */
@Excel(name = "操作类型", prompt = "操作类型")
private String opType;
/** 创建人 */
@Excel(name = "创建人", prompt = "创建人")
private String createdBy;
/** 创建时间 */
@Excel(name = "创建时间", prompt = "创建时间")
private Date createdTime;
/** 更新人 */
@Excel(name = "更新人", prompt = "更新人")
private String updatedBy;
/** 更新时间 */
@Excel(name = "更新时间", prompt = "更新时间")
private Date updatedTime;

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
public void setBuildNatureId(String buildNatureId)
        {
        this.buildNatureId = buildNatureId;
        }

public String getBuildNatureId()
        {
        return buildNatureId;
        }
public void setContractNo(String contractNo)
        {
        this.contractNo = contractNo;
        }

public String getContractNo()
        {
        return contractNo;
        }
public void setCostMoney(String costMoney)
        {
        this.costMoney = costMoney;
        }

public String getCostMoney()
        {
        return costMoney;
        }
public void setEndDate(Date endDate)
        {
        this.endDate = endDate;
        }

public Date getEndDate()
        {
        return endDate;
        }
public void setFloorArea(String floorArea)
        {
        this.floorArea = floorArea;
        }

public String getFloorArea()
        {
        return floorArea;
        }
public void setLength(String length)
        {
        this.length = length;
        }

public String getLength()
        {
        return length;
        }
public void setParentEnterpriseId(String parentEnterpriseId)
        {
        this.parentEnterpriseId = parentEnterpriseId;
        }

public String getParentEnterpriseId()
        {
        return parentEnterpriseId;
        }
public void setPermitNo(String permitNo)
        {
        this.permitNo = permitNo;
        }

public String getPermitNo()
        {
        return permitNo;
        }
public void setRecordNo(String recordNo)
        {
        this.recordNo = recordNo;
        }

public String getRecordNo()
        {
        return recordNo;
        }
public void setSerialNo(String serialNo)
        {
        this.serialNo = serialNo;
        }

public String getSerialNo()
        {
        return serialNo;
        }
public void setSignType(String signType)
        {
        this.signType = signType;
        }

public String getSignType()
        {
        return signType;
        }
public void setStartDate(Date startDate)
        {
        this.startDate = startDate;
        }

public Date getStartDate()
        {
        return startDate;
        }
public void setStatus(String status)
        {
        this.status = status;
        }

public String getStatus()
        {
        return status;
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
public void setCreatedTime(Date createdTime)
        {
        this.createdTime = createdTime;
        }

public Date getCreatedTime()
        {
        return createdTime;
        }
public void setUpdatedBy(String updatedBy)
        {
        this.updatedBy = updatedBy;
        }

public String getUpdatedBy()
        {
        return updatedBy;
        }
public void setUpdatedTime(Date updatedTime)
        {
        this.updatedTime = updatedTime;
        }

public Date getUpdatedTime()
        {
        return updatedTime;
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
                .append("buildNatureId",getBuildNatureId())
                .append("contractNo",getContractNo())
                .append("costMoney",getCostMoney())
                .append("endDate",getEndDate())
                .append("floorArea",getFloorArea())
                .append("length",getLength())
                .append("parentEnterpriseId",getParentEnterpriseId())
                .append("permitNo",getPermitNo())
                .append("recordNo",getRecordNo())
                .append("serialNo",getSerialNo())
                .append("signType",getSignType())
                .append("startDate",getStartDate())
                .append("status",getStatus())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdBy",getCreatedBy())
                .append("createdTime",getCreatedTime())
                .append("updatedBy",getUpdatedBy())
                .append("updatedTime",getUpdatedTime())
            .toString();
        }
        }
