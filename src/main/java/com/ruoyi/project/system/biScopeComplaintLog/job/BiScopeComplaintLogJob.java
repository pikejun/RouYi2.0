package com.ruoyi.project.system.biScopeComplaintLog.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeComplaintLog.service.IBiScopeComplaintLogService;
import com.ruoyi.project.system.biScopeComplaintLog.vo.BiScopeComplaintLogVO;
import com.ruoyi.project.system.biScopeComplaintLog.service.IBiScopeComplaintLogService;
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
public class BiScopeComplaintLogJob extends  BaseDataJob {

    public static final String logName="BiScopeComplaintLogJob";

    @Autowired
    private IBiScopeComplaintLogService biScopeComplaintLogService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeComplaintLogService.updateBiScopeComplaintLogReadyToDeal(param);

        List<BiScopeComplaintLogVO> list=biScopeComplaintLogService.selectBiScopeComplaintLogReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeComplaintLogVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {
                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeComplaintLogVOToModify(vo));

                        neo4jService.executCypher(addRelationshipToComplaint(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeComplaintLogVOToDelete(vo));

                        neo4jService.executCypher(deleteRelationshipToComplaint(vo));

                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeComplaintLogVOToModify(vo));

                        neo4jService.executCypher(addRelationshipToComplaint(vo));
                    }

                    biScopeComplaintLogService.updateBiScopeComplaintLogToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeComplaintLogService.updateBiScopeComplaintLogToFailed(param);
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
    public String deleteRelationshipToComplaint(BiScopeComplaintLogVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:ComplaintLog {id:\"").append(vo.getId()).append("\"}),(w:Complaint{id:\"").append(vo.getComplaintId()).append("\"}) ");
        sb.append("delete (p)-[:complaintLog]->(w)");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToComplaint(BiScopeComplaintLogVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:ComplaintLog {id:\"").append(vo.getId()).append("\"}),(w:Complaint{id:\"").append(vo.getComplaintId()).append("\"}) ");
        sb.append("MERGE (p)-[:complaintLog]->(w)");

        return sb.toString();
    }

    /**
     *
     id, complaint_id complaintId, content, create_date createDate, sender, replay_id replayId, replay_name replayName,
     * @param vo
     * @return
     */
    public String buildBiScopeComplaintLogVOToModify(BiScopeComplaintLogVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:ComplaintLog {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",complaintId:\"").append(vo.getComplaintId()).append("\"");
        sb.append(",content:\"").append(vo.getContent()).append("\"");

        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }

        sb.append(",sender:").append(vo.getSender());
        sb.append(",replayId:\"").append(vo.getReplayId()).append("\"");
        sb.append(",replayName:\"").append(vo.getReplayName()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeComplaintLogVOToDelete(BiScopeComplaintLogVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:ComplaintLog) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }



    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
