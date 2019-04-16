package com.ruoyi.project.system.biIndexInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                            import java.util.Date;
        
/**
 * 指标表 bi_index_info
 *
 * @author ruoyi
 * @date 2019-04-16
 */
public class BiIndexInfo extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 指标ID */
@Excel(name = "指标ID", prompt = "指标ID")
private Integer indexId;
/** 指标编号 */
@Excel(name = "指标编号", prompt = "指标编号")
private String indexNo;
/** 指标名称 */
@Excel(name = "指标名称", prompt = "指标名称")
private String indexName;
/** 显示类型 */
@Excel(name = "显示类型", prompt = "显示类型")
private String displayType;
/** 指标状态 */
@Excel(name = "指标状态", prompt = "指标状态")
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

public void setIndexId(Integer indexId)
        {
        this.indexId = indexId;
        }

public Integer getIndexId()
        {
        return indexId;
        }
public void setIndexNo(String indexNo)
        {
        this.indexNo = indexNo;
        }

public String getIndexNo()
        {
        return indexNo;
        }
public void setIndexName(String indexName)
        {
        this.indexName = indexName;
        }

public String getIndexName()
        {
        return indexName;
        }
public void setDisplayType(String displayType)
        {
        this.displayType = displayType;
        }

public String getDisplayType()
        {
        return displayType;
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
                .append("indexId",getIndexId())
                .append("indexNo",getIndexNo())
                .append("indexName",getIndexName())
                .append("displayType",getDisplayType())
                .append("status",getStatus())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
