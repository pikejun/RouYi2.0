package com.ruoyi.project.system.biScopeEnterpriseData.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeEnterpriseData.service.IBiScopeEnterpriseDataService;
import com.ruoyi.project.system.biScopeEnterpriseData.vo.BiScopeEnterpriseDataVO;
import com.ruoyi.project.system.biScopeEnterpriseData.service.IBiScopeEnterpriseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: lilijun
 * @Date: 2019/4/7 0002 11:28
 * @Description:
 */
@Component
public class BiScopeEnterpriseDataJob extends  BaseDataJob {

    public static final String logName="BiScopeEnterpriseDataJob";

    @Autowired
    private IBiScopeEnterpriseDataService biScopeEnterpriseDataService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeEnterpriseDataService.updateBiScopeEnterpriseDataReadyToDeal(param);

        List<BiScopeEnterpriseDataVO> list=biScopeEnterpriseDataService.selectBiScopeEnterpriseDataReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeEnterpriseDataVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeEnterpriseDataVOToModify(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeEnterpriseDataVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeEnterpriseDataVOToModify(vo));
                    }

                    biScopeEnterpriseDataService.updateBiScopeEnterpriseDataToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeEnterpriseDataService.updateBiScopeEnterpriseDataToFailed(param);
                }
            }
        }
    }

    /**
     *
     MERGE (n:Node {name: 'John'})
     SET n = {name: 'John', age: 34, coat: 'Yellow', hair: 'Brown'}
     RETURN n
     * @param vo
     * @return
     */
    public String buildBiScopeEnterpriseDataVOToModify(BiScopeEnterpriseDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Enterprise {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",abbrName:\"").append(vo.getAbbrName()).append("\"");
        sb.append(",areaCode:\"").append(vo.getAreaCode()).append("\"");
        sb.append(",businessScope:\"").append(vo.getBusinessScope()).append("\"");
        sb.append(",capitalCurrencyId:\"").append(vo.getCapitalCurrencyId()).append("\"");
        sb.append(",contactPeopleCellPhone:\"").append(vo.getContactPeopleCellPhone()).append("\"");
        sb.append(",contactPeopleName:\"").append(vo.getContactPeopleName()).append("\"");
        sb.append(",contactPeoplePhone:\"").append(vo.getContactPeoplePhone()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }
        sb.append(",email:\"").append(vo.getEmail()).append("\"");

        if(vo.getEstablishDate()!=null)
        {
            sb.append(",establishDate:\"").append(sdf.format(vo.getEstablishDate())).append("\"");
        }


        sb.append(",faxNumber:\"").append(vo.getFaxNumber()).append("\"");
        sb.append(",homeWebsiteUrl:\"").append(vo.getHomeWebsiteUrl()).append("\"");

        if(vo.getIssuingDate()!=null)
        {
            sb.append(",issuingDate:\"").append(sdf.format(vo.getIssuingDate())).append("\"");
        }

        sb.append(",issuingOffice:\"").append(vo.getIssuingOffice()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");

        sb.append(",phoneNumber:\"").append(vo.getPhoneNumber()).append("\"");

        sb.append(",registrationCapital:\"").append(vo.getRegistrationCapital()).append("\"");
        sb.append(",remark:\"").append(vo.getRemark()).append("\"");

        sb.append(",representIdCardNumber:\"").append(vo.getRepresentIdCardNumber()).append("\"");
        sb.append(",representIdCardTypeId:\"").append(vo.getRepresentIdCardTypeId()).append("\"");

        sb.append(",representName:\"").append(vo.getRepresentName()).append("\"");
        sb.append(",representPost:\"").append(vo.getRepresentPost()).append("\"");
        sb.append(",representTitle:\"").append(vo.getRepresentTitle()).append("\"");
        sb.append(",socialCreditNumber:\"").append(vo.getSocialCreditNumber()).append("\"");
        sb.append(",status:\"").append(vo.getStatus()).append("\"");
        sb.append(",statusId:\"").append(vo.getStatusId()).append("\"");
        sb.append(",statusTime:\"").append(vo.getStatusTime()).append("\"");
        sb.append(",typeId:\"").append(vo.getTypeId()).append("\"");
        sb.append(",zipCode:\"").append(vo.getZipCode()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeEnterpriseDataVOToDelete(BiScopeEnterpriseDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:Enterprise) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
       tid, id, abbr_name abbrName, address, area_code areaCode, business_scope businessScope, capital_currency_id capitalCurrencyId, contact_people_cell_phone contactPeopleCellPhone,
         contact_people_name contactPeopleName, contact_people_phone contactPeoplePhone, create_date createDate, email, establish_date establishDate, fax_number faxNumber,
         home_website_url homeWebsiteUrl, issuing_date issuingDate, issuing_office issuingOffice, name, phone_number phoneNumber, registration_capital registrationCapital, remark,
         represent_id_card_number representIdCardNumber, represent_id_card_type_id representIdCardTypeId, represent_name representName, represent_post representPost, represent_title representTitle,
          social_credit_number socialCreditNumber, status, status_id statusId, status_time statusTime, type_id typeId, zip_code zipCode, op_status opStatus, op_type opType, created_time createdTime, created_by createdBy, updated_time updatedTime, updated_by updatedBy

        */
    public String buildBiScopeEnterpriseDataVOToCreate(BiScopeEnterpriseDataVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:Enterprise{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",abbrName:\"").append(vo.getAbbrName()).append("\"");
        sb.append(",areaCode:\"").append(vo.getAreaCode()).append("\"");
        sb.append(",businessScope:\"").append(vo.getBusinessScope()).append("\"");
        sb.append(",capitalCurrencyId:\"").append(vo.getCapitalCurrencyId()).append("\"");
        sb.append(",contactPeopleCellPhone:\"").append(vo.getContactPeopleCellPhone()).append("\"");
        sb.append(",contactPeopleName:\"").append(vo.getContactPeopleName()).append("\"");
        sb.append(",contactPeoplePhone:\"").append(vo.getContactPeoplePhone()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }
        sb.append(",email:\"").append(vo.getEmail()).append("\"");

        if(vo.getEstablishDate()!=null)
        {
            sb.append(",establishDate:\"").append(sdf.format(vo.getEstablishDate())).append("\"");
        }


        sb.append(",faxNumber:\"").append(vo.getFaxNumber()).append("\"");
        sb.append(",homeWebsiteUrl:\"").append(vo.getHomeWebsiteUrl()).append("\"");

        if(vo.getIssuingDate()!=null)
        {
            sb.append(",issuingDate:\"").append(sdf.format(vo.getIssuingDate())).append("\"");
        }

        sb.append(",issuingOffice:\"").append(vo.getIssuingOffice()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");

        sb.append(",phoneNumber:\"").append(vo.getPhoneNumber()).append("\"");

        sb.append(",registrationCapital:\"").append(vo.getRegistrationCapital()).append("\"");
        sb.append(",remark:\"").append(vo.getRemark()).append("\"");

        sb.append(",representIdCardNumber:\"").append(vo.getRepresentIdCardNumber()).append("\"");
        sb.append(",representIdCardTypeId:\"").append(vo.getRepresentIdCardTypeId()).append("\"");

        sb.append(",representName:\"").append(vo.getRepresentName()).append("\"");
        sb.append(",representPost:\"").append(vo.getRepresentPost()).append("\"");
        sb.append(",representTitle:\"").append(vo.getRepresentTitle()).append("\"");
        sb.append(",socialCreditNumber:\"").append(vo.getSocialCreditNumber()).append("\"");
        sb.append(",status:\"").append(vo.getStatus()).append("\"");
        sb.append(",statusId:\"").append(vo.getStatusId()).append("\"");
        sb.append(",statusTime:\"").append(vo.getStatusTime()).append("\"");
        sb.append(",typeId:\"").append(vo.getTypeId()).append("\"");
        sb.append(",zipCode:\"").append(vo.getZipCode()).append("\"");



        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
