package com.ruoyi.project.system.biScopeEnterpriseData.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                                                import java.util.Date;
        
/**
 * 企业数据表 bi_scope_enterprise_data
 *
 * @author ruoyi
 * @date 2019-04-07
 */
public class BiScopeEnterpriseData extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 表ID */
@Excel(name = "表ID", prompt = "表ID")
private Integer tid;
/** 企业ID */
@Excel(name = "企业ID", prompt = "企业ID")
private String id;
/** 企业简称 */
@Excel(name = "企业简称", prompt = "企业简称")
private String abbrName;
/** 营业地址 */
@Excel(name = "营业地址", prompt = "营业地址")
private String address;
/** 属地编码 */
@Excel(name = "属地编码", prompt = "属地编码")
private String areaCode;
/** 经验范围 */
@Excel(name = "经验范围", prompt = "经验范围")
private String businessScope;
/** 注册资本币种 */
@Excel(name = "注册资本币种", prompt = "注册资本币种")
private String capitalCurrencyId;
/** 联系人电话 */
@Excel(name = "联系人电话", prompt = "联系人电话")
private String contactPeopleCellPhone;
/** 联系人姓名 */
@Excel(name = "联系人姓名", prompt = "联系人姓名")
private String contactPeopleName;
/** 联系人电话 */
@Excel(name = "联系人电话", prompt = "联系人电话")
private String contactPeoplePhone;
/** 创建日期 */
@Excel(name = "创建日期", prompt = "创建日期")
private Date createDate;
/** 企业联系人邮箱 */
@Excel(name = "企业联系人邮箱", prompt = "企业联系人邮箱")
private String email;
/** 成立日期 */
@Excel(name = "成立日期", prompt = "成立日期")
private Date establishDate;
/** 传真 */
@Excel(name = "传真", prompt = "传真")
private String faxNumber;
/** 企业网址 */
@Excel(name = "企业网址", prompt = "企业网址")
private String homeWebsiteUrl;
/** 发证日期 */
@Excel(name = "发证日期", prompt = "发证日期")
private Date issuingDate;
/** 发证机关 */
@Excel(name = "发证机关", prompt = "发证机关")
private String issuingOffice;
/** 企业名称 */
@Excel(name = "企业名称", prompt = "企业名称")
private String name;
/** 办公电话 */
@Excel(name = "办公电话", prompt = "办公电话")
private String phoneNumber;
/** 注册资本 */
@Excel(name = "注册资本", prompt = "注册资本")
private String registrationCapital;
/** 备注 */
@Excel(name = "备注", prompt = "备注")
private String remark;
/** 法人身份证 */
@Excel(name = "法人身份证", prompt = "法人身份证")
private String representIdCardNumber;
/** 法人证件类型 */
@Excel(name = "法人证件类型", prompt = "法人证件类型")
private String representIdCardTypeId;
/** 法人名称 */
@Excel(name = "法人名称", prompt = "法人名称")
private String representName;
/** 法人职务 */
@Excel(name = "法人职务", prompt = "法人职务")
private String representPost;
/** 法人称号 */
@Excel(name = "法人称号", prompt = "法人称号")
private String representTitle;
/** 社会统一信用代码 */
@Excel(name = "社会统一信用代码", prompt = "社会统一信用代码")
private String socialCreditNumber;
/** 经营状态 */
@Excel(name = "经营状态", prompt = "经营状态")
private String status;
/** 经营状态类别 */
@Excel(name = "经营状态类别", prompt = "经营状态类别")
private String statusId;
/** 经营状态变更日期 */
@Excel(name = "经营状态变更日期", prompt = "经营状态变更日期")
private Date statusTime;
/** 企业类型 */
@Excel(name = "企业类型", prompt = "企业类型")
private String typeId;
/** 邮政编码 */
@Excel(name = "邮政编码", prompt = "邮政编码")
private String zipCode;
/**  */
@Excel(name = "", prompt = "")
private String opStatus;
/**  */
@Excel(name = "", prompt = "")
private String opType;
/**  */
@Excel(name = "", prompt = "")
private Date createdTime;
/**  */
@Excel(name = "", prompt = "")
private String createdBy;
/**  */
@Excel(name = "", prompt = "")
private Date updatedTime;
/**  */
@Excel(name = "", prompt = "")
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
public void setAbbrName(String abbrName)
        {
        this.abbrName = abbrName;
        }

public String getAbbrName()
        {
        return abbrName;
        }
public void setAddress(String address)
        {
        this.address = address;
        }

public String getAddress()
        {
        return address;
        }
public void setAreaCode(String areaCode)
        {
        this.areaCode = areaCode;
        }

public String getAreaCode()
        {
        return areaCode;
        }
public void setBusinessScope(String businessScope)
        {
        this.businessScope = businessScope;
        }

public String getBusinessScope()
        {
        return businessScope;
        }
public void setCapitalCurrencyId(String capitalCurrencyId)
        {
        this.capitalCurrencyId = capitalCurrencyId;
        }

public String getCapitalCurrencyId()
        {
        return capitalCurrencyId;
        }
public void setContactPeopleCellPhone(String contactPeopleCellPhone)
        {
        this.contactPeopleCellPhone = contactPeopleCellPhone;
        }

public String getContactPeopleCellPhone()
        {
        return contactPeopleCellPhone;
        }
public void setContactPeopleName(String contactPeopleName)
        {
        this.contactPeopleName = contactPeopleName;
        }

public String getContactPeopleName()
        {
        return contactPeopleName;
        }
public void setContactPeoplePhone(String contactPeoplePhone)
        {
        this.contactPeoplePhone = contactPeoplePhone;
        }

public String getContactPeoplePhone()
        {
        return contactPeoplePhone;
        }
public void setCreateDate(Date createDate)
        {
        this.createDate = createDate;
        }

public Date getCreateDate()
        {
        return createDate;
        }
public void setEmail(String email)
        {
        this.email = email;
        }

public String getEmail()
        {
        return email;
        }
public void setEstablishDate(Date establishDate)
        {
        this.establishDate = establishDate;
        }

public Date getEstablishDate()
        {
        return establishDate;
        }
public void setFaxNumber(String faxNumber)
        {
        this.faxNumber = faxNumber;
        }

public String getFaxNumber()
        {
        return faxNumber;
        }
public void setHomeWebsiteUrl(String homeWebsiteUrl)
        {
        this.homeWebsiteUrl = homeWebsiteUrl;
        }

public String getHomeWebsiteUrl()
        {
        return homeWebsiteUrl;
        }
public void setIssuingDate(Date issuingDate)
        {
        this.issuingDate = issuingDate;
        }

public Date getIssuingDate()
        {
        return issuingDate;
        }
public void setIssuingOffice(String issuingOffice)
        {
        this.issuingOffice = issuingOffice;
        }

public String getIssuingOffice()
        {
        return issuingOffice;
        }
public void setName(String name)
        {
        this.name = name;
        }

public String getName()
        {
        return name;
        }
public void setPhoneNumber(String phoneNumber)
        {
        this.phoneNumber = phoneNumber;
        }

public String getPhoneNumber()
        {
        return phoneNumber;
        }
public void setRegistrationCapital(String registrationCapital)
        {
        this.registrationCapital = registrationCapital;
        }

public String getRegistrationCapital()
        {
        return registrationCapital;
        }
public void setRemark(String remark)
        {
        this.remark = remark;
        }

public String getRemark()
        {
        return remark;
        }
public void setRepresentIdCardNumber(String representIdCardNumber)
        {
        this.representIdCardNumber = representIdCardNumber;
        }

public String getRepresentIdCardNumber()
        {
        return representIdCardNumber;
        }
public void setRepresentIdCardTypeId(String representIdCardTypeId)
        {
        this.representIdCardTypeId = representIdCardTypeId;
        }

public String getRepresentIdCardTypeId()
        {
        return representIdCardTypeId;
        }
public void setRepresentName(String representName)
        {
        this.representName = representName;
        }

public String getRepresentName()
        {
        return representName;
        }
public void setRepresentPost(String representPost)
        {
        this.representPost = representPost;
        }

public String getRepresentPost()
        {
        return representPost;
        }
public void setRepresentTitle(String representTitle)
        {
        this.representTitle = representTitle;
        }

public String getRepresentTitle()
        {
        return representTitle;
        }
public void setSocialCreditNumber(String socialCreditNumber)
        {
        this.socialCreditNumber = socialCreditNumber;
        }

public String getSocialCreditNumber()
        {
        return socialCreditNumber;
        }
public void setStatus(String status)
        {
        this.status = status;
        }

public String getStatus()
        {
        return status;
        }
public void setStatusId(String statusId)
        {
        this.statusId = statusId;
        }

public String getStatusId()
        {
        return statusId;
        }
public void setStatusTime(Date statusTime)
        {
        this.statusTime = statusTime;
        }

public Date getStatusTime()
        {
        return statusTime;
        }
public void setTypeId(String typeId)
        {
        this.typeId = typeId;
        }

public String getTypeId()
        {
        return typeId;
        }
public void setZipCode(String zipCode)
        {
        this.zipCode = zipCode;
        }

public String getZipCode()
        {
        return zipCode;
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
                .append("abbrName",getAbbrName())
                .append("address",getAddress())
                .append("areaCode",getAreaCode())
                .append("businessScope",getBusinessScope())
                .append("capitalCurrencyId",getCapitalCurrencyId())
                .append("contactPeopleCellPhone",getContactPeopleCellPhone())
                .append("contactPeopleName",getContactPeopleName())
                .append("contactPeoplePhone",getContactPeoplePhone())
                .append("createDate",getCreateDate())
                .append("email",getEmail())
                .append("establishDate",getEstablishDate())
                .append("faxNumber",getFaxNumber())
                .append("homeWebsiteUrl",getHomeWebsiteUrl())
                .append("issuingDate",getIssuingDate())
                .append("issuingOffice",getIssuingOffice())
                .append("name",getName())
                .append("phoneNumber",getPhoneNumber())
                .append("registrationCapital",getRegistrationCapital())
                .append("remark",getRemark())
                .append("representIdCardNumber",getRepresentIdCardNumber())
                .append("representIdCardTypeId",getRepresentIdCardTypeId())
                .append("representName",getRepresentName())
                .append("representPost",getRepresentPost())
                .append("representTitle",getRepresentTitle())
                .append("socialCreditNumber",getSocialCreditNumber())
                .append("status",getStatus())
                .append("statusId",getStatusId())
                .append("statusTime",getStatusTime())
                .append("typeId",getTypeId())
                .append("zipCode",getZipCode())
                .append("opStatus",getOpStatus())
                .append("opType",getOpType())
                .append("createdTime",getCreatedTime())
                .append("createdBy",getCreatedBy())
                .append("updatedTime",getUpdatedTime())
                .append("updatedBy",getUpdatedBy())
            .toString();
        }
        }
