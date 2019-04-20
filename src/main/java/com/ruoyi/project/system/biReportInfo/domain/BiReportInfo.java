package com.ruoyi.project.system.biReportInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                                import java.util.Date;
        
/**
 * 汇报数据表 bi_report_info
 *
 * @author ruoyi
 * @date 2019-04-20
 */
public class BiReportInfo extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 报告ID */
@Excel(name = "报告ID", prompt = "报告ID")
private Integer reportId;
/** 模板编号 */
@Excel(name = "模板编号", prompt = "模板编号")
private String templateNo;
/** 接收人姓名 */
@Excel(name = "接收人姓名", prompt = "接收人姓名")
private String receiverName;
/** 接收人ID */
@Excel(name = "接收人ID", prompt = "接收人ID")
private String receiverId;
/** 报告内容 */
@Excel(name = "报告内容", prompt = "报告内容")
private String reportContent;
/** 发送状态 */
@Excel(name = "发送状态", prompt = "发送状态")
private String sendStatus;
/** 发送时间 */
@Excel(name = "发送时间", prompt = "发送时间")
private Date sendDate;
/** 创建日期 */
@Excel(name = "创建日期", prompt = "创建日期")
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

public void setReportId(Integer reportId)
        {
        this.reportId = reportId;
        }

public Integer getReportId()
        {
        return reportId;
        }
public void setTemplateNo(String templateNo)
        {
        this.templateNo = templateNo;
        }

public String getTemplateNo()
        {
        return templateNo;
        }
public void setReceiverName(String receiverName)
        {
        this.receiverName = receiverName;
        }

public String getReceiverName()
        {
        return receiverName;
        }
public void setReceiverId(String receiverId)
        {
        this.receiverId = receiverId;
        }

public String getReceiverId()
        {
        return receiverId;
        }
public void setReportContent(String reportContent)
        {
        this.reportContent = reportContent;
        }

public String getReportContent()
        {
        return reportContent;
        }
public void setSendStatus(String sendStatus)
        {
        this.sendStatus = sendStatus;
        }

public String getSendStatus()
        {
        return sendStatus;
        }
public void setSendDate(Date sendDate)
        {
        this.sendDate = sendDate;
        }

public Date getSendDate()
        {
        return sendDate;
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
                .append("reportId",getReportId())
                .append("templateNo",getTemplateNo())
                .append("receiverName",getReceiverName())
                .append("receiverId",getReceiverId())
                .append("reportContent",getReportContent())
                .append("sendStatus",getSendStatus())
                .append("sendDate",getSendDate())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
