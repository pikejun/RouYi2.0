package com.ruoyi.project.system.biScopeAttendInfo.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeAttendInfo.service.IBiScopeAttendInfoService;
import com.ruoyi.project.system.biScopeAttendInfo.vo.BiScopeAttendInfoVO;
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
public class BiScopeAttendInfoJob extends  BaseDataJob {

    public static final String logName="BiScopeAttendInfoJob";

    @Autowired
    private IBiScopeAttendInfoService biScopeAttendInfoService;


    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     * delete (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String deleteRelationshipToWorker(BiScopeAttendInfoVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Attend {workerId:\"").append(vo.getWorkerId()).append("\"}),(w:Worker{id:\"").append(vo.getId()).append("\"}) ");
        sb.append("delete (p)-[:attend]->(w)");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToWorker(BiScopeAttendInfoVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Attend {workerId:\"").append(vo.getWorkerId()).append("\"}),(w:Worker{id:\"").append(vo.getWorkerId()).append("\"}) ");
        sb.append("MERGE (p)-[:attend]->(w)");

        return sb.toString();
    }


    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     * delete (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String deleteRelationshipToAttendSpot(BiScopeAttendInfoVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Attend {attendSpotId:\"").append(vo.getAttendSpotId()).append("\"}),(w:AttendSpot{id:\"").append(vo.getAttendSpotId()).append("\"}) ");
        sb.append("delete (p)-[:in]->(w)");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToAttendSpot(BiScopeAttendInfoVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Attend {attendSpotId:\"").append(vo.getAttendSpotId()).append("\"}),(w:AttendSpot{id:\"").append(vo.getAttendSpotId()).append("\"}) ");
        sb.append("MERGE (p)-[:in]->(w)");

        return sb.toString();
    }

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeAttendInfoService.updateBiScopeAttendInfoReadyToDeal(param);

        List<BiScopeAttendInfoVO> list=biScopeAttendInfoService.selectBiScopeAttendInfoReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeAttendInfoVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {
                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeAttendInfoVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorker(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeAttendInfoVOToDelete(vo));
                        neo4jService.executCypher(deleteRelationshipToWorker(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeAttendInfoVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorker(vo));
                    }

                    biScopeAttendInfoService.updateBiScopeAttendInfoToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeAttendInfoService.updateBiScopeAttendInfoToFailed(param);
                }
            }
        }
    }

    /**
     *
     id, worker_id workerId, `day`, `month`, attend_spot_id attendSpotId, on_work_time onWorkTime, un_work_time unWorkTime,
     attend_mode attendMode, image_id imageId, device_number deviceNumber
     * @param vo
     * @return
     */
    public String buildBiScopeAttendInfoVOToModify(BiScopeAttendInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Attend {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",workerId:\"").append(vo.getWorkerId()).append("\"");
        sb.append(",day:\"").append(vo.getDay()).append("\"");
        sb.append(",month:\"").append(vo.getMonth()).append("\"");
        sb.append(",attendSpotId:\"").append(vo.getAttendSpotId()).append("\"");

        if(vo.getOnWorkTime()!=null)
        {
            sb.append(",onWorkTime:\"").append(sdf.format(vo.getOnWorkTime())).append("\"");
        }

        if(vo.getUnWorkTime()!=null)
        {
            sb.append(",unWorkTime:\"").append(sdf.format(vo.getUnWorkTime())).append("\"");
        }

        sb.append(",attendMode:\"").append(vo.getAttendMode()).append("\"");
        sb.append(",imageId:\"").append(vo.getImageId()).append("\"");
        sb.append(",deviceNumber:\"").append(vo.getDeviceNumber()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeAttendInfoVOToDelete(BiScopeAttendInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:Attend) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }



    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
