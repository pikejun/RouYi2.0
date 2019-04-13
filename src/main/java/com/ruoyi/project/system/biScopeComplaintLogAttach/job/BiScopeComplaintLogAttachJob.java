package com.ruoyi.project.system.biScopeComplaintLogAttach.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeComplaintLogAttach.service.IBiScopeComplaintLogAttachService;
import com.ruoyi.project.system.biScopeComplaintLogAttach.vo.BiScopeComplaintLogAttachVO;
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
public class BiScopeComplaintLogAttachJob extends  BaseDataJob {

    public static final String logName="BiScopeComplaintLogJob";

    @Autowired
    private IBiScopeComplaintLogAttachService biScopeComplaintLogAttachService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeComplaintLogAttachService.updateBiScopeComplaintLogAttachReadyToDeal(param);

        List<BiScopeComplaintLogAttachVO> list=biScopeComplaintLogAttachService.selectBiScopeComplaintLogAttachReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeComplaintLogAttachVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {
                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeComplaintLogVOToModify(vo));

                        neo4jService.executCypher(addRelationshipToComplaintLog(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeComplaintLogVOToDelete(vo));

                        neo4jService.executCypher(deleteRelationshipToComplaintLog(vo));

                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeComplaintLogVOToModify(vo));

                        neo4jService.executCypher(addRelationshipToComplaintLog(vo));
                    }

                    biScopeComplaintLogAttachService.updateBiScopeComplaintLogAttachToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeComplaintLogAttachService.updateBiScopeComplaintLogAttachToFailed(param);
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
    public String deleteRelationshipToComplaintLog(BiScopeComplaintLogAttachVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:ComplaintLog {id:\"").append(vo.getComplaintLogId()).append("\"}),(w:ComplaintLogAttach{id:\"").append(vo.getId()).append("\"}) ");
        sb.append("delete (w)-[:complaintLogAttach]->(p)");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToComplaintLog(BiScopeComplaintLogAttachVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:ComplaintLog {id:\"").append(vo.getComplaintLogId()).append("\"}),(w:ComplaintLogAttach{id:\"").append(vo.getId()).append("\"}) ");
        sb.append("MERGE (w)-[:complaintLogAttach]->(p)");

        return sb.toString();
    }

    /**
     *
     id, complaint_log_id complaintLogId, attachment_ids attachmentIds
     * @param vo
     * @return
     */
    public String buildBiScopeComplaintLogVOToModify(BiScopeComplaintLogAttachVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:ComplaintLogAttach {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",complaintLogId:\"").append(vo.getComplaintLogId()).append("\"");
        sb.append(",attachmentIds:\"").append(vo.getAttachmentIds()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeComplaintLogVOToDelete(BiScopeComplaintLogAttachVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:ComplaintLogAttach) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }



    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
