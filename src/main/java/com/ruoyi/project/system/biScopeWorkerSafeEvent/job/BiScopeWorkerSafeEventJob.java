package com.ruoyi.project.system.biScopeWorkerSafeEvent.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeWorkerSafeEvent.service.IBiScopeWorkerSafeEventService;
import com.ruoyi.project.system.biScopeWorkerSafeEvent.vo.BiScopeWorkerSafeEventVO;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BiScopeWorkerSafeEventJob extends  BaseDataJob {

    public static final String logName="BiScopeWorkerSafeEventJob";

    @Autowired
    private IBiScopeWorkerSafeEventService biScopeWorkerSafeEventService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeWorkerSafeEventService.updateBiScopeWorkerSafeEventReadyToDeal(param);

        List<BiScopeWorkerSafeEventVO> list=biScopeWorkerSafeEventService.selectBiScopeWorkerSafeEventReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeWorkerSafeEventVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeWorkerSafeEventVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorker(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeWorkerSafeEventVOToDelete(vo));
                        neo4jService.executCypher(deleteRelationshipToWorker(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeWorkerSafeEventVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorker(vo));
                    }

                    biScopeWorkerSafeEventService.updateBiScopeWorkerSafeEventToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeWorkerSafeEventService.updateBiScopeWorkerSafeEventToFailed(param);
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
    public String deleteRelationshipToWorker(BiScopeWorkerSafeEventVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:WorkerSafeEvent {id:\"").append(vo.getId()).append("\"}),(w:Worker{id:\"").append(vo.getWorkerId()).append("\"}) ");
        sb.append("delete (p)-[:workerSafeEvent]->(w)");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToWorker(BiScopeWorkerSafeEventVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:WorkerSafeEvent {id:\"").append(vo.getId()).append("\"}),(w:Worker{id:\"").append(vo.getWorkerId()).append("\"}) ");
        sb.append("MERGE (p)-[:workerSafeEvent]->(w)");
        return sb.toString();
    }

    /**
     *

     id, event_date eventDate, remark, checker_id checkerId, worker_id workerId, item_id itemId, item_name itemName, type_id typeId, type_name typeName, event_points eventPoints,
     * @param vo
     * @return
     */
    public String buildBiScopeWorkerSafeEventVOToModify(BiScopeWorkerSafeEventVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:WorkerSafeEvent {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        if(vo.getEventDate()!=null)
        {
            sb.append(",eventDate:\"").append(sdf.format(vo.getEventDate())).append("\"");
        }
        sb.append(",remark:\"").append(vo.getRemark()).append("\"");

        sb.append(",checkerId:\"").append(vo.getCheckerId()).append("\"");
        sb.append(",workerId:\"").append(vo.getWorkerId()).append("\"");
        sb.append(",itemId:\"").append(vo.getItemId()).append("\"");
        sb.append(",itemName:\"").append(vo.getItemId()).append("\"");
        sb.append(",typeId:\"").append(vo.getTypeId()).append("\"");
        sb.append(",typeName:\"").append(vo.getTypeName()).append("\"");
        sb.append(",eventPoints:").append(vo.getEventPoints());

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeWorkerSafeEventVOToDelete(BiScopeWorkerSafeEventVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:WorkerSafeEvent) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
