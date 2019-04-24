package com.ruoyi.project.system.biScopeTrainInfoLog.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeTrainInfoLog.vo.BiScopeTrainInfoLogVO;
import com.ruoyi.project.system.biScopeTrainInfoLog.service.IBiScopeTrainInfoLogService;
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
public class BiScopeTrainInfoLogJob extends  BaseDataJob {

    public static final String logName="BiScopeTrainInfoLogJob";

    @Autowired
    private IBiScopeTrainInfoLogService biScopeTrainInfoLogService;



    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     * delete (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String deleteRelationshipToTrainInfo(BiScopeTrainInfoLogVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:TrainInfoLog {id:\"").append(vo.getId()).append("\"})-[r:trainInfoLog]->(w:Train{id:\"").append(vo.getTrainId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToTrainInfo(BiScopeTrainInfoLogVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:TrainInfoLog {id:\"").append(vo.getId()).append("\"}),(w:Train{id:\"").append(vo.getTrainId()).append("\"}) ");
        sb.append("MERGE (p)-[:trainInfoLog]->(w)");

        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     * delete (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String deleteRelationshipToWorker(BiScopeTrainInfoLogVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:TrainInfoLog {id:\"").append(vo.getId()).append("\"})-[r:workerTrain]->(w:Worker{id:\"").append(vo.getWorkerId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToWorker(BiScopeTrainInfoLogVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:TrainInfoLog {id:\"").append(vo.getId()).append("\"}),(w:Worker{id:\"").append(vo.getWorkerId()).append("\"}) ");
        sb.append("MERGE (p)-[:workerTrain]->(w)");

        return sb.toString();
    }

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeTrainInfoLogService.updateBiScopeTrainInfoLogReadyToDeal(param);

        List<BiScopeTrainInfoLogVO> list=biScopeTrainInfoLogService.selectBiScopeTrainInfoLogReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeTrainInfoLogVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainInfoLogVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorker(vo));
                        neo4jService.executCypher(addRelationshipToTrainInfo(vo));

                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainInfoLogVOToDelete(vo));
                        neo4jService.executCypher(deleteRelationshipToWorker(vo));
                        neo4jService.executCypher(deleteRelationshipToTrainInfo(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainInfoLogVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorker(vo));
                        neo4jService.executCypher(addRelationshipToTrainInfo(vo));
                    }

                    biScopeTrainInfoLogService.updateBiScopeTrainInfoLogToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeTrainInfoLogService.updateBiScopeTrainInfoLogToFailed(param);
                }
            }
        }
    }

    /**
     *
     MERGE (n:Node {name: 'John'})
     id, trainId, workerId, enterDate, enterDesc, enterImageId, exitDate, exitDesc, exitImageId, finish
     RETURN n
     * @param vo
     * @return
     */
    public String buildBiScopeTrainInfoLogVOToModify(BiScopeTrainInfoLogVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:TrainInfoLog {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",trainId:\"").append(vo.getTrainId()).append("\"");
        sb.append(",workerId:\"").append(vo.getWorkerId()).append("\"");
        if(vo.getEnterDate()!=null)
        {
            sb.append(",enterDate:\"").append(sdf.format(vo.getEnterDate())).append("\"");
        }
        sb.append(",enterDesc:\"").append(vo.getEnterDesc()).append("\"");
        sb.append(",enterImageId:\"").append(vo.getEnterImageId()).append("\"");

        if(vo.getExitDate()!=null)
        {
            sb.append(",exitDate:\"").append(sdf.format(vo.getExitDate())).append("\"");
        }

        sb.append(",exitDesc:\"").append(vo.getExitDesc()).append("\"");
        sb.append(",exitImageId:\"").append(vo.getExitImageId()).append("\"");

        sb.append(",finish:").append(vo.getFinish());
        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeTrainInfoLogVOToDelete(BiScopeTrainInfoLogVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:TrainInfoLog) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
