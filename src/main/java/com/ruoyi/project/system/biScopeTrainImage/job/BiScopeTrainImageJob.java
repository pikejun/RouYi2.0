package com.ruoyi.project.system.biScopeTrainImage.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeTrainImage.service.IBiScopeTrainImageService;
import com.ruoyi.project.system.biScopeTrainImage.vo.BiScopeTrainImageVO;
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
public class BiScopeTrainImageJob extends  BaseDataJob {

    public static final String logName="BiScopeTrainImageJob";

    @Autowired
    private IBiScopeTrainImageService biScopeTrainImageService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeTrainImageService.updateBiScopeTrainImageReadyToDeal(param);

        List<BiScopeTrainImageVO> list=biScopeTrainImageService.selectBiScopeTrainImageReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeTrainImageVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainImageVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToTrainInfo(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainImageVOToDelete(vo));
                        neo4jService.executCypher(deleteRelationshipToTrainInfo(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainImageVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToTrainInfo(vo));
                    }

                    biScopeTrainImageService.updateBiScopeTrainImageToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeTrainImageService.updateBiScopeTrainImageToFailed(param);
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
    public String deleteRelationshipToTrainInfo(BiScopeTrainImageVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:TrainImage {id:\"").append(vo.getId()).append("\"}),(w:TrainInfo{id:\"").append(vo.getTrainId()).append("\"}) ");
        sb.append("delete (p)-[:trainImage]->(w)");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToTrainInfo(BiScopeTrainImageVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:TrainImage {id:\"").append(vo.getId()).append("\"}),(w:TrainInfo{id:\"").append(vo.getTrainId()).append("\"}) ");
        sb.append("MERGE (p)-[:trainImage]->(w)");

        return sb.toString();
    }

    /**
     *
     id, attachment_id attachmentId, create_date createDate, train_id trainId,
     * @param vo
     * @return
     */
    public String buildBiScopeTrainImageVOToModify(BiScopeTrainImageVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:TrainImage {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",picId:\"").append(vo.getPicId()).append("\"");
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
    public String buildBiScopeTrainImageVOToDelete(BiScopeTrainImageVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:TrainImage) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
