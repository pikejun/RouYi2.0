package com.ruoyi.project.system.biTemplateInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                                import java.util.Date;
        
/**
 * 模板数据表 bi_template_info
 *
 * @author ruoyi
 * @date 2019-04-16
 */
public class BiTemplateInfo extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 模板ID */
@Excel(name = "模板ID", prompt = "模板ID")
private Integer templateId;
/** 模板编号 */
@Excel(name = "模板编号", prompt = "模板编号")
private String templateNo;
/** 发送对象指标编号 */
@Excel(name = "发送对象指标编号", prompt = "发送对象指标编号")
private String senderIndexNo;
/** 模板名称 */
@Excel(name = "模板名称", prompt = "模板名称")
private String templateName;
/** 模板内容 */
@Excel(name = "模板内容", prompt = "模板内容")
private String templateContent;
/** 模板状态 */
@Excel(name = "模板状态", prompt = "模板状态")
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

public void setTemplateId(Integer templateId)
        {
        this.templateId = templateId;
        }

public Integer getTemplateId()
        {
        return templateId;
        }
public void setTemplateNo(String templateNo)
        {
        this.templateNo = templateNo;
        }

public String getTemplateNo()
        {
        return templateNo;
        }
public void setSenderIndexNo(String senderIndexNo)
        {
        this.senderIndexNo = senderIndexNo;
        }

public String getSenderIndexNo()
        {
        return senderIndexNo;
        }
public void setTemplateName(String templateName)
        {
        this.templateName = templateName;
        }

public String getTemplateName()
        {
        return templateName;
        }
public void setTemplateContent(String templateContent)
        {
        this.templateContent = templateContent;
        }

public String getTemplateContent()
        {
        return templateContent;
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
                .append("templateId",getTemplateId())
                .append("templateNo",getTemplateNo())
                .append("senderIndexNo",getSenderIndexNo())
                .append("templateName",getTemplateName())
                .append("templateContent",getTemplateContent())
                .append("status",getStatus())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
