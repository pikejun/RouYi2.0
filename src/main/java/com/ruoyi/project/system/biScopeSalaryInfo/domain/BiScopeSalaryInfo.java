package com.ruoyi.project.system.biScopeSalaryInfo.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                            import java.util.Date;
        
/**
 * 工人工资表 bi_scope_salary_info
 *
 * @author ruoyi
 * @date 2019-04-12
 */
public class BiScopeSalaryInfo extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 工资ID */
@Excel(name = "工资ID", prompt = "工资ID")
private String id;
/** 总工资 */
@Excel(name = "总工资", prompt = "总工资")
private Double allMoney;
/** 实发工资 */
@Excel(name = "实发工资", prompt = "实发工资")
private Double realMoney;
/** 发放比例 */
@Excel(name = "发放比例", prompt = "发放比例")
private Integer percent;
/** 发放日期 */
@Excel(name = "发放日期", prompt = "发放日期")
private Date fireDate;
/** 是否发放 */
@Excel(name = "是否发放", prompt = "是否发放")
private Integer fired;
/** 考勤人数 */
@Excel(name = "考勤人数", prompt = "考勤人数")
private Integer attendCount;
/** 月份 */
@Excel(name = "月份", prompt = "月份")
private String month;
/** 组织人员ID */
@Excel(name = "组织人员ID", prompt = "组织人员ID")
private String workerId;
/** 是否满意 */
@Excel(name = "是否满意", prompt = "是否满意")
private Integer satisfaction;
/** 反馈日期 */
@Excel(name = "反馈日期", prompt = "反馈日期")
private Date feedbackDate;
/** 反馈状态 */
@Excel(name = "反馈状态", prompt = "反馈状态")
private String status;
/** 操作状态 */
@Excel(name = "操作状态", prompt = "操作状态")
private String opStatus;
/** 操作类型 */
@Excel(name = "操作类型", prompt = "操作类型")
private String opType;
/** 创建日期 */
@Excel(name = "创建日期", prompt = "创建日期")
private Date createdTime;
/** 创建人 */
@Excel(name = "创建人", prompt = "创建人")
private String createdBy;
/** 更新日期 */
@Excel(name = "更新日期", prompt = "更新日期")
private Date updatedTime;
/** 更新人 */
@Excel(name = "更新人", prompt = "更新人")
private String updatedBy;

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
public void setAllMoney(Double allMoney)
        {
        this.allMoney = allMoney;
        }

public Double getAllMoney()
        {
        return allMoney;
        }
public void setRealMoney(Double realMoney)
        {
        this.realMoney = realMoney;
        }

public Double getRealMoney()
        {
        return realMoney;
        }
public void setPercent(Integer percent)
        {
        this.percent = percent;
        }

public Integer getPercent()
        {
        return percent;
        }
public void setFireDate(Date fireDate)
        {
        this.fireDate = fireDate;
        }

public Date getFireDate()
        {
        return fireDate;
        }
public void setFired(Integer fired)
        {
        this.fired = fired;
        }

public Integer getFired()
        {
        return fired;
        }
public void setAttendCount(Integer attendCount)
        {
        this.attendCount = attendCount;
        }

public Integer getAttendCount()
        {
        return attendCount;
        }
public void setMonth(String month)
        {
        this.month = month;
        }

public String getMonth()
        {
        return month;
        }
public void setWorkerId(String workerId)
        {
        this.workerId = workerId;
        }

public String getWorkerId()
        {
        return workerId;
        }
public void setSatisfaction(Integer satisfaction)
        {
        this.satisfaction = satisfaction;
        }

public Integer getSatisfaction()
        {
        return satisfaction;
        }
public void setFeedbackDate(Date feedbackDate)
        {
        this.feedbackDate = feedbackDate;
        }

public Date getFeedbackDate()
        {
        return feedbackDate;
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
                .append("tid",getTid())
                .append("id",getId())
                .append("allMoney",getAllMoney())
                .append("realMoney",getRealMoney())
                .append("percent",getPercent())
                .append("fireDate",getFireDate())
                .append("fired",getFired())
                .append("attendCount",getAttendCount())
                .append("month",getMonth())
                .append("workerId",getWorkerId())
                .append("satisfaction",getSatisfaction())
                .append("feedbackDate",getFeedbackDate())
                .append("status",getStatus())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
