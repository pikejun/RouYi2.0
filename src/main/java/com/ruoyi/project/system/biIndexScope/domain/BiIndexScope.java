package com.ruoyi.project.system.biIndexScope.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                                    
/**
 * 指标范围表 bi_index_scope
 *
 * @author ruoyi
 * @date 2019-04-16
 */
public class BiIndexScope extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 指标范围ID */
@Excel(name = "指标范围ID", prompt = "指标范围ID")
private Integer isId;
/** 指标编号 */
@Excel(name = "指标编号", prompt = "指标编号")
private String indexNo;
/** 排序号 */
@Excel(name = "排序号", prompt = "排序号")
private Integer orderNum;
/** 关联方式 */
@Excel(name = "关联方式", prompt = "关联方式")
private String relatedMethod;
/** 关联范围 */
@Excel(name = "关联范围", prompt = "关联范围")
private String scopeName;
/** 关联范围属性 */
@Excel(name = "关联范围属性", prompt = "关联范围属性")
private String propertyName;
/** 属性计算方式 */
@Excel(name = "属性计算方式", prompt = "属性计算方式")
private String compareMethod;
/** 比较值1 */
@Excel(name = "比较值1", prompt = "比较值1")
private String compareValue;
/** 比较值2 */
@Excel(name = "比较值2", prompt = "比较值2")
private String compareValueTo;

public void setIsId(Integer isId)
        {
        this.isId = isId;
        }

public Integer getIsId()
        {
        return isId;
        }
public void setIndexNo(String indexNo)
        {
        this.indexNo = indexNo;
        }

public String getIndexNo()
        {
        return indexNo;
        }
public void setOrderNum(Integer orderNum)
        {
        this.orderNum = orderNum;
        }

public Integer getOrderNum()
        {
        return orderNum;
        }
public void setRelatedMethod(String relatedMethod)
        {
        this.relatedMethod = relatedMethod;
        }

public String getRelatedMethod()
        {
        return relatedMethod;
        }
public void setScopeName(String scopeName)
        {
        this.scopeName = scopeName;
        }

public String getScopeName()
        {
        return scopeName;
        }
public void setPropertyName(String propertyName)
        {
        this.propertyName = propertyName;
        }

public String getPropertyName()
        {
        return propertyName;
        }
public void setCompareMethod(String compareMethod)
        {
        this.compareMethod = compareMethod;
        }

public String getCompareMethod()
        {
        return compareMethod;
        }
public void setCompareValue(String compareValue)
        {
        this.compareValue = compareValue;
        }

public String getCompareValue()
        {
        return compareValue;
        }
public void setCompareValueTo(String compareValueTo)
        {
        this.compareValueTo = compareValueTo;
        }

public String getCompareValueTo()
        {
        return compareValueTo;
        }
@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("isId",getIsId())
                .append("indexNo",getIndexNo())
                .append("orderNum",getOrderNum())
                .append("relatedMethod",getRelatedMethod())
                .append("scopeName",getScopeName())
                .append("propertyName",getPropertyName())
                .append("compareMethod",getCompareMethod())
                .append("compareValue",getCompareValue())
                .append("compareValueTo",getCompareValueTo())
            .toString();
        }
        }
