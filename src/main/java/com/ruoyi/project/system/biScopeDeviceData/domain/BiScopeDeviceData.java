package com.ruoyi.project.system.biScopeDeviceData.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                                            import java.util.Date;
        
/**
 * 设备数据表 bi_scope_device_data
 *
 * @author ruoyi
 * @date 2019-04-07
 */
public class BiScopeDeviceData extends BaseEntity
        {
private static final long serialVersionUID=1L;

/**  */
@Excel(name = "", prompt = "")
private Integer tid;
/** 设备ID */
@Excel(name = "设备ID", prompt = "设备ID")
private String id;
/** 点位名称 */
@Excel(name = "点位名称", prompt = "点位名称")
private String addrName;
/** 点位编号 */
@Excel(name = "点位编号", prompt = "点位编号")
private String addrNo;
/** 设备名称 */
@Excel(name = "设备名称", prompt = "设备名称")
private String deviceName;
/** 设备型号 */
@Excel(name = "设备型号", prompt = "设备型号")
private String deviceModel;
/** 设备类型 */
@Excel(name = "设备类型", prompt = "设备类型")
private String deviceType;
/** 设备厂家 */
@Excel(name = "设备厂家", prompt = "设备厂家")
private String deviceManufactor;
/** 设备版本号 */
@Excel(name = "设备版本号", prompt = "设备版本号")
private String deviceVersion;
/** 购买日期 */
@Excel(name = "购买日期", prompt = "购买日期")
private Date buyDate;
/** 入库日期 */
@Excel(name = "入库日期", prompt = "入库日期")
private Date putDate;
/** 备注 */
@Excel(name = "备注", prompt = "备注")
private String remark;
/** 使用状态 */
@Excel(name = "使用状态", prompt = "使用状态")
private Integer useStatus;
/** 项目ID */
@Excel(name = "项目ID", prompt = "项目ID")
private String projectId;
/** 标段ID */
@Excel(name = "标段ID", prompt = "标段ID")
private String projectUnitId;
/** 层级编码 */
@Excel(name = "层级编码", prompt = "层级编码")
private String levelCode;
/** 场景ID */
@Excel(name = "场景ID", prompt = "场景ID")
private String sceneId;
/** 设备状态 */
@Excel(name = "设备状态", prompt = "设备状态")
private String deviceStatus;
/** 操作状态 */
@Excel(name = "操作状态", prompt = "操作状态")
private String opStatus;
/** 操作类型 */
@Excel(name = "操作类型", prompt = "操作类型")
private String opType;
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
public void setAddrName(String addrName)
        {
        this.addrName = addrName;
        }

public String getAddrName()
        {
        return addrName;
        }
public void setAddrNo(String addrNo)
        {
        this.addrNo = addrNo;
        }

public String getAddrNo()
        {
        return addrNo;
        }
public void setDeviceName(String deviceName)
        {
        this.deviceName = deviceName;
        }

public String getDeviceName()
        {
        return deviceName;
        }
public void setDeviceModel(String deviceModel)
        {
        this.deviceModel = deviceModel;
        }

public String getDeviceModel()
        {
        return deviceModel;
        }
public void setDeviceType(String deviceType)
        {
        this.deviceType = deviceType;
        }

public String getDeviceType()
        {
        return deviceType;
        }
public void setDeviceManufactor(String deviceManufactor)
        {
        this.deviceManufactor = deviceManufactor;
        }

public String getDeviceManufactor()
        {
        return deviceManufactor;
        }
public void setDeviceVersion(String deviceVersion)
        {
        this.deviceVersion = deviceVersion;
        }

public String getDeviceVersion()
        {
        return deviceVersion;
        }
public void setBuyDate(Date buyDate)
        {
        this.buyDate = buyDate;
        }

public Date getBuyDate()
        {
        return buyDate;
        }
public void setPutDate(Date putDate)
        {
        this.putDate = putDate;
        }

public Date getPutDate()
        {
        return putDate;
        }
public void setRemark(String remark)
        {
        this.remark = remark;
        }

public String getRemark()
        {
        return remark;
        }
public void setUseStatus(Integer useStatus)
        {
        this.useStatus = useStatus;
        }

public Integer getUseStatus()
        {
        return useStatus;
        }
public void setProjectId(String projectId)
        {
        this.projectId = projectId;
        }

public String getProjectId()
        {
        return projectId;
        }
public void setProjectUnitId(String projectUnitId)
        {
        this.projectUnitId = projectUnitId;
        }

public String getProjectUnitId()
        {
        return projectUnitId;
        }
public void setLevelCode(String levelCode)
        {
        this.levelCode = levelCode;
        }

public String getLevelCode()
        {
        return levelCode;
        }
public void setSceneId(String sceneId)
        {
        this.sceneId = sceneId;
        }

public String getSceneId()
        {
        return sceneId;
        }
public void setDeviceStatus(String deviceStatus)
        {
        this.deviceStatus = deviceStatus;
        }

public String getDeviceStatus()
        {
        return deviceStatus;
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
                .append("addrName",getAddrName())
                .append("addrNo",getAddrNo())
                .append("deviceName",getDeviceName())
                .append("deviceModel",getDeviceModel())
                .append("deviceType",getDeviceType())
                .append("deviceManufactor",getDeviceManufactor())
                .append("deviceVersion",getDeviceVersion())
                .append("buyDate",getBuyDate())
                .append("putDate",getPutDate())
                .append("remark",getRemark())
                .append("useStatus",getUseStatus())
                .append("projectId",getProjectId())
                .append("projectUnitId",getProjectUnitId())
                .append("levelCode",getLevelCode())
                .append("sceneId",getSceneId())
                .append("deviceStatus",getDeviceStatus())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
