package com.ruoyi.project.system.biScopeTrainInfo.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeComplaintInfo.vo.BiScopeComplaintInfoVO;
import com.ruoyi.project.system.biScopeTrainInfo.vo.BiScopeTrainInfoVO;
import com.ruoyi.project.system.biScopeTrainInfo.service.IBiScopeTrainInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class BiScopeTrainInfoJob extends  BaseDataJob {

    public static final String logName="BiScopeTrainInfoJob";

    @Autowired
    private IBiScopeTrainInfoService biScopeTrainInfoService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeTrainInfoService.updateBiScopeTrainInfoReadyToDeal(param);

        List<BiScopeTrainInfoVO> list=biScopeTrainInfoService.selectBiScopeTrainInfoReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeTrainInfoVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainInfoVOToModify(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainInfoVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeTrainInfoVOToModify(vo));
                    }

                    biScopeTrainInfoService.updateBiScopeTrainInfoToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeTrainInfoService.updateBiScopeTrainInfoToFailed(param);
                }
            }
        }
    }

    /**
     *
     MERGE (n:Node {name: 'John'})
     SET n = {name: 'John', age: 34, coat: 'Yellow', hair: 'Brown'}
     RETURN n
     * @param vo
     * @return
     */
    public String buildBiScopeTrainInfoVOToModify(BiScopeTrainInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Train {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",attendUserId:\"").append(vo.getAttendUserId()).append("\"");
        if(vo.getTrainCreateDate()!=null)
        {
            sb.append(",trainCreateDate:\"").append(sdf.format(vo.getTrainCreateDate())).append("\"");
        }

        sb.append(",createUserId:\"").append(vo.getCreateUserId()).append("\"");

        if(vo.getStartDate()!=null)
        {
            sb.append(",startDate:\"").append(sdf.format(vo.getStartDate())).append("\"");
        }

        if(vo.getEndDate()!=null)
        {
            sb.append(",endDate:\"").append(sdf.format(vo.getEndDate())).append("\"");
        }

        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",locationId:\"").append(vo.getLocationId()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",projectGroupId:\"").append(vo.getProjectGroupId()).append("\"");
        sb.append(",projectUnitId:\"").append(vo.getProjectUnitId()).append("\"");
        sb.append(",sceneId:\"").append(vo.getSceneId()).append("\"");
        sb.append(",trainUserId:\"").append(vo.getTrainUserId()).append("\"");
        sb.append(",type:\"").append(vo.getType()).append("\"");
        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeTrainInfoVOToDelete(BiScopeTrainInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:Train) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }



    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
