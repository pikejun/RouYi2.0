package com.ruoyi.project.system.biScopeWorkerData.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeWorkerData.service.IBiScopeWorkerDataService;
import com.ruoyi.project.system.biScopeWorkerData.vo.BiScopeWorkerDataVO;
import com.ruoyi.project.system.biScopeWorkerData.service.IBiScopeWorkerDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @Autowired
    private Neo4jService neo4jService;

    @Value("${host}")
    private String host="666";

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
                        neo4jService.executCypher(buildBiScopeWorkerDataVOToCreate(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeWorkerDataVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeWorkerDataVOToModify(vo));
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
     MERGE (n:Node {name: 'John'})
     SET n = {name: 'John', age: 34, coat: 'Yellow', hair: 'Brown'}
     RETURN n
     * @param vo
     * @return
     */
    public String buildBiScopeWorkerDataVOToModify(BiScopeWorkerDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Worker {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",userId:\"").append(vo.getUserId()).append("\"");
        sb.append(",username:\"").append(vo.getUsername()).append("\"");
        sb.append(",number:\"").append(vo.getNumber()).append("\"");
        sb.append(",mobile:\"").append(vo.getMobile()).append("\"");
        sb.append(",ownerId:\"").append(vo.getOwnerId()).append("\"");
        sb.append(",projectSectionId:\"").append(vo.getProjectSectionId()).append("\"");
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",ownerType:\"").append(vo.getOwnerType()).append("\"");
        sb.append(",realStatus:\"").append(vo.getRealStatus()).append("\"");

        if(vo.getRealDate()!=null)
        {
            sb.append(",realDate:\"").append(sdf.format(vo.getRealDate())).append("\"");
        }

        sb.append(",workStatus:\"").append(vo.getWorkStatus()).append("\"");

        sb.append(",workTypeId:\"").append(vo.getWorkTypeId()).append("\"");
        sb.append(",workTypeName:\"").append(vo.getWorkTypeName()).append("\"");


        if(vo.getWorkCreateDate()!=null)
        {
            sb.append(",workCreateDate:\"").append(sdf.format(vo.getWorkCreateDate())).append("\"");
        }

        sb.append(",enterTrain:\"").append(vo.getEnterTrain()).append("\"");

        if(vo.getLastSafetyDate()!=null)
        {
            sb.append(",lastSafetyDate:\"").append(sdf.format(vo.getLastSafetyDate())).append("\"");
        }


        sb.append(",safetyCount:").append(vo.getSafetyCount());
        sb.append(",safetyScore:").append(vo.getSafetyScore());

        sb.append(",techniqueTrain:\"").append(vo.getTechniqueTrain()).append("\"");
        sb.append(",entranceCardId:\"").append(vo.getEntranceCardId()).append("\"");
        sb.append(",projectGroupId:\"").append(vo.getProjectGroupId()).append("\"");
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

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
   tid, id, user_id userId, username, number, mobile, owner_id ownerId, project_section_id projectSectionId, level_code levelCode, owner_type ownerType,
        real_status realStatus, real_date realDate, work_status workStatus, work_type_id workTypeId, work_type_name workTypeName, work_create_date workCreateDate,
         enter_train enterTrain, last_safety_date lastSafetyDate, safety_count safetyCount, safety_score safetyScore, technique_train techniqueTrain,
          entrance_card_id entranceCardId, project_group_id projectGroupId, op_status opStatus, op_type opType, created_time createdTime, created_by createdBy,
          updated_time updatedTime, updated_by updatedBy */
    public String buildBiScopeWorkerDataVOToCreate(BiScopeWorkerDataVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:Worker{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",userId:\"").append(vo.getUserId()).append("\"");
        sb.append(",username:\"").append(vo.getUsername()).append("\"");
        sb.append(",number:\"").append(vo.getNumber()).append("\"");
        sb.append(",mobile:\"").append(vo.getMobile()).append("\"");
        sb.append(",ownerId:\"").append(vo.getOwnerId()).append("\"");
        sb.append(",projectSectionId:\"").append(vo.getProjectSectionId()).append("\"");
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",ownerType:\"").append(vo.getOwnerType()).append("\"");
        sb.append(",realStatus:\"").append(vo.getRealStatus()).append("\"");

        if(vo.getRealDate()!=null)
        {
            sb.append(",realDate:\"").append(sdf.format(vo.getRealDate())).append("\"");
        }

        sb.append(",workStatus:\"").append(vo.getWorkStatus()).append("\"");

        sb.append(",workTypeId:\"").append(vo.getWorkTypeId()).append("\"");
        sb.append(",workTypeName:\"").append(vo.getWorkTypeName()).append("\"");


        if(vo.getWorkCreateDate()!=null)
        {
            sb.append(",workCreateDate:\"").append(sdf.format(vo.getWorkCreateDate())).append("\"");
        }

        sb.append(",enterTrain:\"").append(vo.getEnterTrain()).append("\"");

        if(vo.getLastSafetyDate()!=null)
        {
            sb.append(",lastSafetyDate:\"").append(sdf.format(vo.getLastSafetyDate())).append("\"");
        }


        sb.append(",safetyCount:").append(vo.getSafetyCount());
        sb.append(",safetyScore:").append(vo.getSafetyScore());

        sb.append(",techniqueTrain:\"").append(vo.getTechniqueTrain()).append("\"");
        sb.append(",entranceCardId:\"").append(vo.getEntranceCardId()).append("\"");
        sb.append(",projectGroupId:\"").append(vo.getProjectGroupId()).append("\"");

        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
