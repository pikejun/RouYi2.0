package com.ruoyi.project.system.biScopeProjectData.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeProjectData.service.IBiScopeProjectDataService;
import com.ruoyi.project.system.biScopeProjectData.vo.BiScopeProjectDataVO;
import com.ruoyi.project.system.biScopeProjectData.service.IBiScopeProjectDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: lilijun
 * @Date: 2019/4/2 0002 11:28
 * @Description:
 */
@Component
public class BiScopeProjectDataJob extends  BaseDataJob {

    public static final String logName="BiScopeProjectDataJob";

    @Autowired
    private IBiScopeProjectDataService biScopeProjectDataService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeProjectDataService.updateBiScopeProjectDataReadyToDeal(param);

        List<BiScopeProjectDataVO> list=biScopeProjectDataService.selectBiScopeProjectDataReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeProjectDataVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeProjectDataVOToCreate(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeProjectDataVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeProjectDataVOToModify(vo));
                    }

                    biScopeProjectDataService.updateBiScopeProjectDataToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeProjectDataService.updateBiScopeProjectDataToFailed(param);
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
    public String buildBiScopeProjectDataVOToModify(BiScopeProjectDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Project {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",abbrName:\"").append(vo.getAbbrName()).append("\"");
        sb.append(",aliasName:\"").append(vo.getAliasName()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }
        sb.append(",enterpriseId:\"").append(vo.getEnterpriseId()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",rootProjectId:\"").append(vo.getRootProjectId()).append("\"");
        sb.append(",remark:\"").append(vo.getRemark()).append("\"");
        sb.append(",updateDate:\"").append(vo.getUpdateDate()).append("\"");
        sb.append(",workStatus:\"").append(vo.getWorkStatus()).append("\"");
        sb.append(",address:\"").append(vo.getAddress()).append("\"");
        sb.append(",areaId:\"").append(vo.getAreaId()).append("\"");
        sb.append(",buildNatureId:\"").append(vo.getBuildNatureId()).append("\"");
        sb.append(",contractNo:\"").append(vo.getContractNo()).append("\"");
        sb.append(",costMoney:\"").append(vo.getCostMoney()).append("\"");
        sb.append(",endDate:\"").append(vo.getEndDate()).append("\"");
        sb.append(",floorArea:\"").append(vo.getFloorArea()).append("\"");
        sb.append(",length:\"").append(vo.getLength()).append("\"");
        sb.append(",parentEnterpriseId:\"").append(vo.getParentEnterpriseId()).append("\"");
        sb.append(",permitNo:\"").append(vo.getPermitNo()).append("\"");
        sb.append(",recordNo:\"").append(vo.getRecordNo()).append("\"");
        sb.append(",serialNo:\"").append(vo.getSerialNo()).append("\"");
        sb.append(",signType:\"").append(vo.getSignType()).append("\"");

        if(vo.getStartDate()!=null)
        {
            sb.append(",startDate:\"").append(sdf.format(vo.getStartDate())).append("\"");
        }

        sb.append(",status:\"").append(vo.getStatus()).append("\"");
        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeProjectDataVOToDelete(BiScopeProjectDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:Project) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
    tid, id, abbr_name abbrName, alias_name aliasName, create_date createDate, enterprise_id enterpriseId, name, root_project_id rootProjectId,  remark,
        update_date updateDate, work_status workStatus, address,
 area_id areaId, build_nature_id buildNatureId, contract_no contractNo, cost_money costMoney, end_date endDate,
  floor_area floorArea, length, parent_enterprise_id parentEnterpriseId, permit_no permitNo, record_no recordNo,
  serial_no serialNo, sign_type signType, start_date startDate, status, op_status opStatus, op_type opType, created_by createdBy, created_time createdTime, updated_by updatedBy, updated_time updatedTime
         */
    public String buildBiScopeProjectDataVOToCreate(BiScopeProjectDataVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:Project{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",abbrName:\"").append(vo.getAbbrName()).append("\"");
        sb.append(",aliasName:\"").append(vo.getAliasName()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }
        sb.append(",enterpriseId:\"").append(vo.getEnterpriseId()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",rootProjectId:\"").append(vo.getRootProjectId()).append("\"");
        sb.append(",remark:\"").append(vo.getRemark()).append("\"");
        sb.append(",updateDate:\"").append(vo.getUpdateDate()).append("\"");
        sb.append(",workStatus:\"").append(vo.getWorkStatus()).append("\"");
        sb.append(",address:\"").append(vo.getAddress()).append("\"");
        sb.append(",areaId:\"").append(vo.getAreaId()).append("\"");
        sb.append(",buildNatureId:\"").append(vo.getBuildNatureId()).append("\"");
        sb.append(",contractNo:\"").append(vo.getContractNo()).append("\"");
        sb.append(",costMoney:\"").append(vo.getCostMoney()).append("\"");
        sb.append(",endDate:\"").append(vo.getEndDate()).append("\"");
        sb.append(",floorArea:\"").append(vo.getFloorArea()).append("\"");
        sb.append(",length:\"").append(vo.getLength()).append("\"");
        sb.append(",parentEnterpriseId:\"").append(vo.getParentEnterpriseId()).append("\"");
        sb.append(",permitNo:\"").append(vo.getPermitNo()).append("\"");
        sb.append(",recordNo:\"").append(vo.getRecordNo()).append("\"");
        sb.append(",serialNo:\"").append(vo.getSerialNo()).append("\"");
        sb.append(",signType:\"").append(vo.getSignType()).append("\"");

        if(vo.getStartDate()!=null)
        {
            sb.append(",startDate:\"").append(sdf.format(vo.getStartDate())).append("\"");
        }

        sb.append(",status:\"").append(vo.getStatus()).append("\"");
        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
