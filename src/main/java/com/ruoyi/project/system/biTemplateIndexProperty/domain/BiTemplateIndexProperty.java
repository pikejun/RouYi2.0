package com.ruoyi.project.system.biTemplateIndexProperty.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                                import java.util.Date;
        
/**
 * 模板指标属性明细表 bi_template_index_property
 *
 * @author ruoyi
 * @date 2019-04-16
 */
public class BiTemplateIndexProperty extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 模板指标属性ID */
@Excel(name = "模板指标属性ID", prompt = "模板指标属性ID")
private Integer tipId;
/** 模板编号 */
@Excel(name = "模板编号", prompt = "模板编号")
private String templateNo;
/** 指标编号 */
@Excel(name = "指标编号", prompt = "指标编号")
private String indexNo;
/** 属性名称 */
@Excel(name = "属性名称", prompt = "属性名称")
private String propertyName;
/** 默认值 */
@Excel(name = "默认值", prompt = "默认值")
private String defaultValue;
/** 排序号 */
@Excel(name = "排序号", prompt = "排序号")
private Integer orderNum;
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

public void setTipId(Integer tipId)
        {
        this.tipId = tipId;
        }

public Integer getTipId()
        {
        return tipId;
        }
public void setTemplateNo(String templateNo)
        {
        this.templateNo = templateNo;
        }

public String getTemplateNo()
        {
        return templateNo;
        }
public void setIndexNo(String indexNo)
        {
        this.indexNo = indexNo;
        }

public String getIndexNo()
        {
        return indexNo;
        }
public void setPropertyName(String propertyName)
        {
        this.propertyName = propertyName;
        }

public String getPropertyName()
        {
        return propertyName;
        }
public void setDefaultValue(String defaultValue)
        {
        this.defaultValue = defaultValue;
        }

public String getDefaultValue()
        {
        return defaultValue;
        }
public void setOrderNum(Integer orderNum)
        {
        this.orderNum = orderNum;
        }

public Integer getOrderNum()
        {
        return orderNum;
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
                .append("tipId",getTipId())
                .append("templateNo",getTemplateNo())
                .append("indexNo",getIndexNo())
                .append("propertyName",getPropertyName())
                .append("defaultValue",getDefaultValue())
                .append("orderNum",getOrderNum())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
