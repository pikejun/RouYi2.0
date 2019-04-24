package com.ruoyi.project.system.biScopeGroupOwner.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeGroupOwner.service.IBiScopeGroupOwnerService;
import com.ruoyi.project.system.biScopeGroupOwner.vo.BiScopeGroupOwnerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: Administrator
 * @Date: 2019/4/23 0023 14:04
 * @Description:
 */
@Component
public class BiScopeGroupOwnerJob extends BaseDataJob {
    public static final String logName="BiScopeGroupOwnerJob";

    @Autowired
    private IBiScopeGroupOwnerService biScopeGroupOwnerService;

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     * delete (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String deleteRelationshipToWorkerGroup(BiScopeGroupOwnerVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:WorkerGroup {id:\"").append(vo.getGroupId()).append("\"})-[r:admin]-(w:GroupOwner{id:\"").append(vo.getId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToWorkerGroup(BiScopeGroupOwnerVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:WorkerGroup {id:\"").append(vo.getGroupId()).append("\"}),(w:GroupOwner{id:\"").append(vo.getId()).append("\"}) ");
        sb.append("MERGE (w)-[:admin]->(p)");

        return sb.toString();
    }


    /**
     * @param vo
     * @return
     */
    public String deleteRelationshipToProject(BiScopeGroupOwnerVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:GroupOwner {id:\"").append(vo.getId()).append("\"})-[r:admin]-(w:Project{id:\"").append(vo.getProjectId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * @param vo
     * @return
     */
    public String addRelationshipToProject(BiScopeGroupOwnerVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:GroupOwner {id:\"").append(vo.getId()).append("\"}),(w:Project{id:\"").append(vo.getProjectId()).append("\"}) ");
        sb.append("MERGE (p)-[:admin]->(w)");

        return sb.toString();
    }


    /**
     * @param vo
     * @return
     */
    public String deleteRelationshipToRealName(BiScopeGroupOwnerVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:GroupOwner {id:\"").append(vo.getId()).append("\"})-[r:realName]-(w:RealName{id:\"").append(vo.getRealNameId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * @param vo
     * @return
     */
    public String addRelationshipToRealName(BiScopeGroupOwnerVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:GroupOwner {id:\"").append(vo.getId()).append("\"}),(w:RealName{id:\"").append(vo.getRealNameId()).append("\"}) ");
        sb.append("MERGE (p)-[:realName]->(w)");

        return sb.toString();
    }

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeGroupOwnerService.updateBiScopeGroupOwnerReadyToDeal(param);

        List<BiScopeGroupOwnerVO> list=biScopeGroupOwnerService.selectBiScopeGroupOwnerReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeGroupOwnerVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeGroupOwnerVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToRealName(vo));
                        neo4jService.executCypher(addRelationshipToProject(vo));
                        neo4jService.executCypher(addRelationshipToWorkerGroup(vo));

                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(deleteRelationshipToProject(vo));
                        neo4jService.executCypher(deleteRelationshipToRealName(vo));

                        neo4jService.executCypher(buildBiScopeGroupOwnerVOToDelete(vo));
                        neo4jService.executCypher(deleteRelationshipToWorkerGroup(vo));

                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeGroupOwnerVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToRealName(vo));
                        neo4jService.executCypher(addRelationshipToProject(vo));
                        neo4jService.executCypher(addRelationshipToWorkerGroup(vo));
                    }

                    biScopeGroupOwnerService.updateBiScopeGroupOwnerToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeGroupOwnerService.updateBiScopeGroupOwnerToFailed(param);
                }
            }
        }
    }

    /**
     *
     * @param vo
     * @return
     */
    public String buildBiScopeGroupOwnerVOToModify(BiScopeGroupOwnerVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:GroupOwner {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",realNameId:\"").append(vo.getRealNameId()).append("\"");
        sb.append(",groupId:\"").append(vo.getGroupId()).append("\"");
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
    public String buildBiScopeGroupOwnerVOToDelete(BiScopeGroupOwnerVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:GroupOwner) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }



    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
