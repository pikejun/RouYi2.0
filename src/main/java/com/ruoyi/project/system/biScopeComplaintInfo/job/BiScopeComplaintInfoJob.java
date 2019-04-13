package com.ruoyi.project.system.biScopeComplaintInfo.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeComplaintInfo.vo.BiScopeComplaintInfoVO;
import com.ruoyi.project.system.biScopeComplaintInfo.service.IBiScopeComplaintInfoService;
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
public class BiScopeComplaintInfoJob extends  BaseDataJob {

    public static final String logName="BiScopeComplaintInfoJob";

    @Autowired
    private IBiScopeComplaintInfoService biScopeComplaintInfoService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeComplaintInfoService.updateBiScopeComplaintInfoReadyToDeal(param);

        List<BiScopeComplaintInfoVO> list=biScopeComplaintInfoService.selectBiScopeComplaintInfoReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeComplaintInfoVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {
                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeComplaintInfoVOToModify(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeComplaintInfoVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeComplaintInfoVOToModify(vo));
                    }

                    biScopeComplaintInfoService.updateBiScopeComplaintInfoToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeComplaintInfoService.updateBiScopeComplaintInfoToFailed(param);
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
    public String deleteRelationshipToWorker(BiScopeComplaintInfoVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Complaint {id:\"").append(vo.getId()).append("\"}),(w:Worker{id:\"").append(vo.getWorkerId()).append("\"}) ");
        sb.append("delete (p)-[:complaint]->(w)");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToWorker(BiScopeComplaintInfoVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Complaint {id:\"").append(vo.getId()).append("\"}),(w:Worker{id:\"").append(vo.getWorkerId()).append("\"}) ");
        sb.append("MERGE (p)-[:complaint]->(w)");

        return sb.toString();
    }

    /**
     *
      id, complaint_created_date complaintCreatedDate, done,  worker_id workerId,type_id typeId,type_name typeName,
     * @param vo
     * @return
     */
    public String buildBiScopeComplaintInfoVOToModify(BiScopeComplaintInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Complaint {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        if(vo.getComplaintCreatedDate()!=null)
        {
            sb.append(",complaintCreatedDate:\"").append(sdf.format(vo.getComplaintCreatedDate())).append("\"");
        }

        sb.append(",done:").append(vo.getDone());
        sb.append(",workerId:\"").append(vo.getWorkerId()).append("\"");
        sb.append(",typeId:\"").append(vo.getTypeId()).append("\"");
        sb.append(",typeName:\"").append(vo.getTypeName()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeComplaintInfoVOToDelete(BiScopeComplaintInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:Complaint) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }



    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
