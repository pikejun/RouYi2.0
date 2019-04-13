package com.ruoyi.project.system.biScopeRealName.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                                                                            import java.util.Date;
        
/**
 * 人员表 bi_scope_real_name
 *
 * @author ruoyi
 * @date 2019-04-11
 */
public class BiScopeRealName extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 实名ID */
@Excel(name = "实名ID", prompt = "实名ID")
private String id;
/** 姓名 */
@Excel(name = "姓名", prompt = "姓名")
private String name;
/** 性别 */
@Excel(name = "性别", prompt = "性别")
private String sex;
/** 生日 */
@Excel(name = "生日", prompt = "生日")
private String birthDay;
/** 省份 */
@Excel(name = "省份", prompt = "省份")
private String province;
/** 民族 */
@Excel(name = "民族", prompt = "民族")
private String nation;
/** 住址 */
@Excel(name = "住址", prompt = "住址")
private String address;
/** 身份证编号 */
@Excel(name = "身份证编号", prompt = "身份证编号")
private String idNo;
/** 有效期 */
@Excel(name = "有效期", prompt = "有效期")
private String validPeriod;
/** 发证日期 */
@Excel(name = "发证日期", prompt = "发证日期")
private String signDate;
/** 发证机关 */
@Excel(name = "发证机关", prompt = "发证机关")
private String organization;
/** 省份证背面 */
@Excel(name = "省份证背面", prompt = "省份证背面")
private String backId;
/** 身份证正面 */
@Excel(name = "身份证正面", prompt = "身份证正面")
private String frontId;
/** 照片ID */
@Excel(name = "照片ID", prompt = "照片ID")
private String photoId;
/** 手机号 */
@Excel(name = "手机号", prompt = "手机号")
private String mobile;
/** 头像ID */
@Excel(name = "头像ID", prompt = "头像ID")
private String imageId;
/** 实名日期 */
@Excel(name = "实名日期", prompt = "实名日期")
private Date realDate;
/** 实名类型 */
@Excel(name = "实名类型", prompt = "实名类型")
private String realType;
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
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
        }
public void setSex(String sex)
        {
        this.sex = sex;
        }

public String getSex()
        {
        return sex;
        }
public void setBirthDay(String birthDay)
        {
        this.birthDay = birthDay;
        }

public String getBirthDay()
        {
        return birthDay;
        }
public void setProvince(String province)
        {
        this.province = province;
        }

public String getProvince()
        {
        return province;
        }
public void setNation(String nation)
        {
        this.nation = nation;
        }

public String getNation()
        {
        return nation;
        }
public void setAddress(String address)
        {
        this.address = address;
        }

public String getAddress()
        {
        return address;
        }
public void setIdNo(String idNo)
        {
        this.idNo = idNo;
        }

public String getIdNo()
        {
        return idNo;
        }
public void setValidPeriod(String validPeriod)
        {
        this.validPeriod = validPeriod;
        }

public String getValidPeriod()
        {
        return validPeriod;
        }
public void setSignDate(String signDate)
        {
        this.signDate = signDate;
        }

public String getSignDate()
        {
        return signDate;
        }
public void setOrganization(String organization)
        {
        this.organization = organization;
        }

public String getOrganization()
        {
        return organization;
        }
public void setBackId(String backId)
        {
        this.backId = backId;
        }

public String getBackId()
        {
        return backId;
        }
public void setFrontId(String frontId)
        {
        this.frontId = frontId;
        }

public String getFrontId()
        {
        return frontId;
        }
public void setPhotoId(String photoId)
        {
        this.photoId = photoId;
        }

public String getPhotoId()
        {
        return photoId;
        }
public void setMobile(String mobile)
        {
        this.mobile = mobile;
        }

public String getMobile()
        {
        return mobile;
        }
public void setImageId(String imageId)
        {
        this.imageId = imageId;
        }

public String getImageId()
        {
        return imageId;
        }
public void setRealDate(Date realDate)
        {
        this.realDate = realDate;
        }

public Date getRealDate()
        {
        return realDate;
        }
public void setRealType(String realType)
        {
        this.realType = realType;
        }

public String getRealType()
        {
        return realType;
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
                .append("name",getName())
                .append("sex",getSex())
                .append("birthDay",getBirthDay())
                .append("province",getProvince())
                .append("nation",getNation())
                .append("address",getAddress())
                .append("idNo",getIdNo())
                .append("validPeriod",getValidPeriod())
                .append("signDate",getSignDate())
                .append("organization",getOrganization())
                .append("backId",getBackId())
                .append("frontId",getFrontId())
                .append("photoId",getPhotoId())
                .append("mobile",getMobile())
                .append("imageId",getImageId())
                .append("realDate",getRealDate())
                .append("realType",getRealType())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
