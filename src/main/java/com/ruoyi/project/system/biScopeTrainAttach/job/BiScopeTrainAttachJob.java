package com.ruoyi.project.system.biScopeTrainAttach.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeRealName.vo.BiScopeRealNameVO;
import com.ruoyi.project.system.biScopeTrainAttach.service.IBiScopeTrainAttachService;
import com.ruoyi.project.system.biScopeTrainAttach.vo.BiScopeTrainAttachVO;
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
public class BiScopeTrainAttachJob extends  BaseDataJob {

    public static final String logName="BiScopeTrainAttachJob";

    @Autowired
    private IBiScopeTrainAttachService biScopeTrainAttachService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeTrainAttachService.updateBiScopeTrainAttachReadyToDeal(param);

        List<BiScopeTrainAttachVO> list=biScopeTrainAttachService.selectBiScopeTrainAttachReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeTrainAttachVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainAttachVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToTrainInfo(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainAttachVOToDelete(vo));
                        neo4jService.executCypher(deleteRelationshipToTrainInfo(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainAttachVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToTrainInfo(vo));
                    }

                    biScopeTrainAttachService.updateBiScopeTrainAttachToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeTrainAttachService.updateBiScopeTrainAttachToFailed(param);
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
    public String deleteRelationshipToTrainInfo(BiScopeTrainAttachVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:TrainAttach {id:\"").append(vo.getId()).append("\"}),(w:TrainInfo{id:\"").append(vo.getTrainId()).append("\"}) ");
        sb.append("delete (p)-[:trainAttach]->(w)");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToTrainInfo(BiScopeTrainAttachVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:TrainAttach {id:\"").append(vo.getId()).append("\"}),(w:TrainInfo{id:\"").append(vo.getTrainId()).append("\"}) ");
        sb.append("MERGE (p)-[:trainAttach]->(w)");

        return sb.toString();
    }

    /**
     *
     id, attachment_id attachmentId, create_date createDate, train_id trainId,
     * @param vo
     * @return
     */
    public String buildBiScopeTrainAttachVOToModify(BiScopeTrainAttachVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:TrainAttach {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",attachmentId:\"").append(vo.getAttachmentId()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }
        sb.append(",trainId:\"").append(vo.getTrainId()).append("\"");
        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeTrainAttachVOToDelete(BiScopeTrainAttachVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:TrainAttach) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
