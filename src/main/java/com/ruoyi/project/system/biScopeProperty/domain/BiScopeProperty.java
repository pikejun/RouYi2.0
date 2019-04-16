package com.ruoyi.project.system.biScopeProperty.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                    
/**
 * 范围属性表 bi_scope_property
 *
 * @author ruoyi
 * @date 2019-04-16
 */
public class BiScopeProperty extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 属性ID */
@Excel(name = "属性ID", prompt = "属性ID")
private Integer propertyId;
/** 所属范围名称 */
@Excel(name = "所属范围名称", prompt = "所属范围名称")
private String scopeName;
/** 属性名称 */
@Excel(name = "属性名称", prompt = "属性名称")
private String propertyName;
/** 属性名称描述 */
@Excel(name = "属性名称描述", prompt = "属性名称描述")
private String propertyNameDesc;
/** 属性类型 */
@Excel(name = "属性类型", prompt = "属性类型")
private String propertyType;

public void setPropertyId(Integer propertyId)
        {
        this.propertyId = propertyId;
        }

public Integer getPropertyId()
        {
        return propertyId;
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
public void setPropertyNameDesc(String propertyNameDesc)
        {
        this.propertyNameDesc = propertyNameDesc;
        }

public String getPropertyNameDesc()
        {
        return propertyNameDesc;
        }
public void setPropertyType(String propertyType)
        {
        this.propertyType = propertyType;
        }

public String getPropertyType()
        {
        return propertyType;
        }
@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("propertyId",getPropertyId())
                .append("scopeName",getScopeName())
                .append("propertyName",getPropertyName())
                .append("propertyNameDesc",getPropertyNameDesc())
                .append("propertyType",getPropertyType())
            .toString();
        }
        }
