package com.ruoyi.project.system.biIndexField.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                                import java.util.Date;
        
/**
 * 指标字段明细表 bi_index_field
 *
 * @author ruoyi
 * @date 2019-04-16
 */
public class BiIndexField extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 字段ID */
@Excel(name = "字段ID", prompt = "字段ID")
private Integer fieldId;
/** 字段编号 */
@Excel(name = "字段编号", prompt = "字段编号")
private String fieldNo;
/** 指标编号 */
@Excel(name = "指标编号", prompt = "指标编号")
private String indexNo;
/** 字段名称 */
@Excel(name = "字段名称", prompt = "字段名称")
private String fieldName;
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

public void setFieldId(Integer fieldId)
        {
        this.fieldId = fieldId;
        }

public Integer getFieldId()
        {
        return fieldId;
        }
public void setFieldNo(String fieldNo)
        {
        this.fieldNo = fieldNo;
        }

public String getFieldNo()
        {
        return fieldNo;
        }
public void setIndexNo(String indexNo)
        {
        this.indexNo = indexNo;
        }

public String getIndexNo()
        {
        return indexNo;
        }
public void setFieldName(String fieldName)
        {
        this.fieldName = fieldName;
        }

public String getFieldName()
        {
        return fieldName;
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
                .append("fieldId",getFieldId())
                .append("fieldNo",getFieldNo())
                .append("indexNo",getIndexNo())
                .append("fieldName",getFieldName())
                .append("defaultValue",getDefaultValue())
                .append("orderNum",getOrderNum())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
