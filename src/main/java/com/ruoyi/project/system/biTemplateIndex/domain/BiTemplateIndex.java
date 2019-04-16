package com.ruoyi.project.system.biTemplateIndex.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                        import java.util.Date;
        
/**
 * 模板指标明细表 bi_template_index
 *
 * @author ruoyi
 * @date 2019-04-16
 */
public class BiTemplateIndex extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 模板指标ID */
@Excel(name = "模板指标ID", prompt = "模板指标ID")
private Integer tiid;
/** 模板编号 */
@Excel(name = "模板编号", prompt = "模板编号")
private String templateNo;
/** 指标编号 */
@Excel(name = "指标编号", prompt = "指标编号")
private String indexNo;
/** 显示类型 */
@Excel(name = "显示类型", prompt = "显示类型")
private Integer displayType;
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

public void setTiid(Integer tiid)
        {
        this.tiid = tiid;
        }

public Integer getTiid()
        {
        return tiid;
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
public void setDisplayType(Integer displayType)
        {
        this.displayType = displayType;
        }

public Integer getDisplayType()
        {
        return displayType;
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
                .append("tiid",getTiid())
                .append("templateNo",getTemplateNo())
                .append("indexNo",getIndexNo())
                .append("displayType",getDisplayType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
