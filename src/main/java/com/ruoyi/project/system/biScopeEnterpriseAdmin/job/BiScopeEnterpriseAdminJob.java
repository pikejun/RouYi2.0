package com.ruoyi.project.system.biScopeEnterpriseAdmin.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeEnterpriseAdmin.service.IBiScopeEnterpriseAdminService;
import com.ruoyi.project.system.biScopeEnterpriseAdmin.vo.BiScopeEnterpriseAdminVO;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BiScopeEnterpriseAdminJob extends  BaseDataJob {

    public static final String logName="BiScopeEnterpriseAdminJob";

    @Autowired
    private IBiScopeEnterpriseAdminService biScopeEnterpriseAdminService;


    /**
     * @param vo
     * @return
     */
    public String deleteRelationshipToEnterprise(BiScopeEnterpriseAdminVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:EnterpriseAdmin {id:\"").append(vo.getId()).append("\"})-[r:admin]-(w:Enterprise{id:\"").append(vo.getEnterpriseId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * @param vo
     * @return
     */
    public String addRelationshipToEnterprise(BiScopeEnterpriseAdminVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:EnterpriseAdmin {id:\"").append(vo.getId()).append("\"}),(w:Enterprise{id:\"").append(vo.getEnterpriseId()).append("\"}) ");
        sb.append("MERGE (p)-[:admin]->(w)");

        return sb.toString();
    }


    /**
     * @param vo
     * @return
     */
    public String deleteRelationshipToRealName(BiScopeEnterpriseAdminVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:EnterpriseAdmin {id:\"").append(vo.getId()).append("\"})-[r:realName]-(w:RealName{id:\"").append(vo.getRealNameId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * @param vo
     * @return
     */
    public String addRelationshipToRealName(BiScopeEnterpriseAdminVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:EnterpriseAdmin {id:\"").append(vo.getId()).append("\"}),(w:RealName{id:\"").append(vo.getRealNameId()).append("\"}) ");
        sb.append("MERGE (p)-[:realName]->(w)");

        return sb.toString();
    }

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeEnterpriseAdminService.updateBiScopeEnterpriseAdminReadyToDeal(param);

        List<BiScopeEnterpriseAdminVO> list=biScopeEnterpriseAdminService.selectBiScopeEnterpriseAdminReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeEnterpriseAdminVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeEnterpriseAdminVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToRealName(vo));
                        neo4jService.executCypher(addRelationshipToEnterprise(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(deleteRelationshipToEnterprise(vo));
                        neo4jService.executCypher(deleteRelationshipToRealName(vo));

                        neo4jService.executCypher(buildBiScopeEnterpriseAdminVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeEnterpriseAdminVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToRealName(vo));
                        neo4jService.executCypher(addRelationshipToEnterprise(vo));
                    }

                    biScopeEnterpriseAdminService.updateBiScopeEnterpriseAdminToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeEnterpriseAdminService.updateBiScopeEnterpriseAdminToFailed(param);
                }
            }
        }
    }

    /**
     *
     * @param vo
     * @return
     */
    public String buildBiScopeEnterpriseAdminVOToModify(BiScopeEnterpriseAdminVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:EnterpriseAdmin {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",realNameId:\"").append(vo.getRealNameId()).append("\"");
        sb.append(",workStatus:\"").append(vo.getWorkStatus()).append("\"");
        sb.append(",enterpriseId:\"").append(vo.getEnterpriseId()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeEnterpriseAdminVOToDelete(BiScopeEnterpriseAdminVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:EnterpriseAdmin) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }



    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
