package com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.service.IBiScopeWorkerSafeEventAttachmentsService;
import com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.vo.BiScopeWorkerSafeEventAttachmentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: lilijun
 * @Date: 2019/4/4 0002 11:28
 * @Description:
 */
@Component
public class BiScopeWorkerSafeEventAttachmentsJob extends  BaseDataJob {

    public static final String logName="BiScopeWorkerSafeEventAttachmentsJob";

    @Autowired
    private IBiScopeWorkerSafeEventAttachmentsService biScopeWorkerSafeEventAttachmentsService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeWorkerSafeEventAttachmentsService.updateBiScopeWorkerSafeEventAttachmentsReadyToDeal(param);

        List<BiScopeWorkerSafeEventAttachmentsVO> list=biScopeWorkerSafeEventAttachmentsService.selectBiScopeWorkerSafeEventAttachmentsReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeWorkerSafeEventAttachmentsVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeWorkerSafeEventAttachmentsVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorkerSafeEvent(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeWorkerSafeEventAttachmentsVOToDelete(vo));
                        neo4jService.executCypher(deleteRelationshipToWorkerSafeEvent(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeWorkerSafeEventAttachmentsVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorkerSafeEvent(vo));
                    }

                    biScopeWorkerSafeEventAttachmentsService.updateBiScopeWorkerSafeEventAttachmentsToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeWorkerSafeEventAttachmentsService.updateBiScopeWorkerSafeEventAttachmentsToFailed(param);
                }
            }
        }
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     * delete (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String deleteRelationshipToWorkerSafeEvent(BiScopeWorkerSafeEventAttachmentsVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:WorkerSafeEventAttachments {id:\"").append(vo.getId()).append("\"})-[r:workerSafeEventAttachments]->(w:WorkerSafeEvent{id:\"").append(vo.getWorkerEventId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToWorkerSafeEvent(BiScopeWorkerSafeEventAttachmentsVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:WorkerSafeEventAttachments {id:\"").append(vo.getId()).append("\"}),(w:WorkerSafeEvent{id:\"").append(vo.getWorkerEventId()).append("\"}) ");
        sb.append("MERGE (p)-[:workerSafeEventAttachments]->(w)");

        return sb.toString();
    }

    /**
     *
     id, workerEventId, attachments
     * @param vo
     * @return
     */
    public String buildBiScopeWorkerSafeEventAttachmentsVOToModify(BiScopeWorkerSafeEventAttachmentsVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:WorkerSafeEventAttachments {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",workerEventId:\"").append(vo.getWorkerEventId()).append("\"");

        sb.append(",attachments:\"").append(vo.getAttachments()).append("\"");
        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeWorkerSafeEventAttachmentsVOToDelete(BiScopeWorkerSafeEventAttachmentsVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:WorkerSafeEventAttachments) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
