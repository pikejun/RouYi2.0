package com.ruoyi.project.system.biScopeWorkerData.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeTrainInfoLog.vo.BiScopeTrainInfoLogVO;
import com.ruoyi.project.system.biScopeWorkerData.service.IBiScopeWorkerDataService;
import com.ruoyi.project.system.biScopeWorkerData.vo.BiScopeWorkerDataVO;
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
public class BiScopeWorkerDataJob extends  BaseDataJob {

    public static final String logName="BiScopeWorkerDataJob";

    @Autowired
    private IBiScopeWorkerDataService biScopeWorkerDataService;

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     * delete (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String deleteRelationshipToWorkerGroup(BiScopeWorkerDataVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:WorkerGroup {id:\"").append(vo.getGroupId()).append("\"})-[r:combination]-(w:Worker{id:\"").append(vo.getId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToWorkerGroup(BiScopeWorkerDataVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:WorkerGroup {id:\"").append(vo.getGroupId()).append("\"}),(w:Worker{id:\"").append(vo.getId()).append("\"}) ");
        sb.append("MERGE (w)-[:combination]->(p)");

        return sb.toString();
    }

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeWorkerDataService.updateBiScopeWorkerDataReadyToDeal(param);

        List<BiScopeWorkerDataVO> list=biScopeWorkerDataService.selectBiScopeWorkerDataReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeWorkerDataVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {
                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeWorkerDataVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorkerGroup(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeWorkerDataVOToDelete(vo));
                        neo4jService.executCypher(deleteRelationshipToWorkerGroup(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeWorkerDataVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorkerGroup(vo));
                    }

                    biScopeWorkerDataService.updateBiScopeWorkerDataToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeWorkerDataService.updateBiScopeWorkerDataToFailed(param);
                }
            }
        }
    }

    /**
     *
      id,worker_name workerName, group_id groupId, work_type_id workTypeId, work_type_name workTypeName, real_name_id realNameId,
     real_status realStatus, real_date realDate, work_status workStatus, enter_train enterTrain, technique_train techniqueTrain,
     entrance_card_id entranceCardId, last_safety_date lastSafetyDate, safety_count safetyCount, safety_score safetyScore,
     * @param vo
     * @return
     */
    public String buildBiScopeWorkerDataVOToModify(BiScopeWorkerDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Worker {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",workerName:\"").append(vo.getWorkerName()).append("\"");
        sb.append(",groupId:\"").append(vo.getGroupId()).append("\"");
        sb.append(",workTypeId:\"").append(vo.getWorkTypeId()).append("\"");
        sb.append(",workTypeName:\"").append(vo.getWorkTypeName()).append("\"");


        sb.append(",realNameId:\"").append(vo.getRealNameId()).append("\"");
        sb.append(",realStatus:\"").append(vo.getRealStatus()).append("\"");

        if(vo.getRealDate()!=null)
        {
            sb.append(",realDate:\"").append(sdf.format(vo.getRealDate())).append("\"");
        }

        sb.append(",workStatus:\"").append(vo.getWorkStatus()).append("\"");

        sb.append(",enterTrain:").append(vo.getEnterTrain());
        sb.append(",techniqueTrain:").append(vo.getTechniqueTrain());
        sb.append(",entranceCardId:\"").append(vo.getEntranceCardId()).append("\"");

        if(vo.getLastSafetyDate()!=null)
        {
            sb.append(",lastSafetyDate:\"").append(sdf.format(vo.getLastSafetyDate())).append("\"");
        }

        sb.append(",safetyCount:").append(vo.getSafetyCount());
        sb.append(",safetyScore:").append(vo.getSafetyScore());



        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeWorkerDataVOToDelete(BiScopeWorkerDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:Worker) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
