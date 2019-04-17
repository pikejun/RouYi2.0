package com.ruoyi.project.system.biIndexField.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                
/**
 * 指标字段明细表 bi_index_field
 *
 * @author ruoyi
 * @date 2019-04-17
 */
public class BiIndexField extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 字段ID */
@Excel(name = "字段ID", prompt = "字段ID")
private Integer fieldId;
/** 指标编号 */
@Excel(name = "指标编号", prompt = "指标编号")
private String indexNo;
/** 字段名称 */
@Excel(name = "字段名称", prompt = "字段名称")
private String fieldName;
/** 排序号 */
@Excel(name = "排序号", prompt = "排序号")
private Integer orderNum;

public void setFieldId(Integer fieldId)
        {
        this.fieldId = fieldId;
        }

public Integer getFieldId()
        {
        return fieldId;
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
public void setOrderNum(Integer orderNum)
        {
        this.orderNum = orderNum;
        }

public Integer getOrderNum()
        {
        return orderNum;
        }
@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("fieldId",getFieldId())
                .append("indexNo",getIndexNo())
                .append("fieldName",getFieldName())
                .append("orderNum",getOrderNum())
            .toString();
        }
        }