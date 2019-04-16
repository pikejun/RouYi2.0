package com.ruoyi.project.system.biScopeProjectAdmin.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeProjectAdmin.service.IBiScopeProjectAdminService;
import com.ruoyi.project.system.biScopeProjectAdmin.vo.BiScopeProjectAdminVO;
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
public class BiScopeProjectAdminJob extends  BaseDataJob {

    public static final String logName="BiScopeProjectAdminJob";

    @Autowired
    private IBiScopeProjectAdminService biScopeProjectAdminService;


    /**
     * @param vo
     * @return
     */
    public String deleteRelationshipToProject(BiScopeProjectAdminVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:ProjectAdmin {id:\"").append(vo.getId()).append("\"})-[r:admin]-(w:Project{id:\"").append(vo.getProjectId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * @param vo
     * @return
     */
    public String addRelationshipToProject(BiScopeProjectAdminVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:ProjectAdmin {id:\"").append(vo.getId()).append("\"}),(w:Project{id:\"").append(vo.getProjectId()).append("\"}) ");
        sb.append("MERGE (p)-[:admin]->(w)");

        return sb.toString();
    }


    /**
     * @param vo
     * @return
     */
    public String deleteRelationshipToRealName(BiScopeProjectAdminVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:ProjectAdmin {id:\"").append(vo.getId()).append("\"})-[r:realName]-(w:RealName{id:\"").append(vo.getRealNameId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * @param vo
     * @return
     */
    public String addRelationshipToRealName(BiScopeProjectAdminVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:ProjectAdmin {id:\"").append(vo.getId()).append("\"}),(w:RealName{id:\"").append(vo.getRealNameId()).append("\"}) ");
        sb.append("MERGE (p)-[:realName]->(w)");

        return sb.toString();
    }

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeProjectAdminService.updateBiScopeProjectAdminReadyToDeal(param);

        List<BiScopeProjectAdminVO> list=biScopeProjectAdminService.selectBiScopeProjectAdminReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeProjectAdminVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeProjectAdminVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToRealName(vo));
                        neo4jService.executCypher(addRelationshipToProject(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(deleteRelationshipToProject(vo));
                        neo4jService.executCypher(deleteRelationshipToRealName(vo));

                        neo4jService.executCypher(buildBiScopeProjectAdminVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeProjectAdminVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToRealName(vo));
                        neo4jService.executCypher(addRelationshipToProject(vo));
                    }

                    biScopeProjectAdminService.updateBiScopeProjectAdminToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeProjectAdminService.updateBiScopeProjectAdminToFailed(param);
                }
            }
        }
    }

    /**
     *
     * @param vo
     * @return
     */
    public String buildBiScopeProjectAdminVOToModify(BiScopeProjectAdminVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:ProjectAdmin {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",realNameId:\"").append(vo.getRealNameId()).append("\"");
        sb.append(",workStatus:\"").append(vo.getWorkStatus()).append("\"");
        sb.append(",projectId:\"").append(vo.getProjectId()).append("\"");
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",rootProjectId:\"").append(vo.getRootProjectId()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeProjectAdminVOToDelete(BiScopeProjectAdminVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:ProjectAdmin) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }



    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
