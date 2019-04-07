package com.ruoyi.project.system.biScopeComplaintInfo.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService; 
import com.ruoyi.project.system.biScopeComplaintInfo.vo.BiScopeComplaintInfoVO;
import com.ruoyi.project.system.biScopeComplaintInfo.service.IBiScopeComplaintInfoService;
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
public class BiScopeComplaintInfoJob extends  BaseDataJob {

    public static final String logName="BiScopeComplaintInfoJob";

    @Autowired
    private IBiScopeComplaintInfoService biScopeComplaintInfoService;

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
                        neo4jService.executCypher(buildBiScopeComplaintInfoVOToCreate(vo));
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
     *
     MERGE (n:Node {name: 'John'})
     SET n = {name: 'John', age: 34, coat: 'Yellow', hair: 'Brown'}
     RETURN n
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
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",personId:\"").append(vo.getPersonId()).append("\"");
        sb.append(",userId:\"").append(vo.getUserId()).append("\"");
        sb.append(",projectGroupId:\"").append(vo.getProjectGroupId()).append("\"");
        sb.append(",projectUnitId:").append(vo.getProjectUnitId());
        sb.append(",typeId:\"").append(vo.getTypeId()).append("\"");

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

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
     tid, id, complaint_created_date complaintCreatedDate, done, level_code levelCode, person_id personId, user_id userId, project_group_id projectGroupId,
         project_unit_id projectUnitId, type_id typeId, op_status opStatus, op_type opType, created_time createdTime, created_by createdBy, updated_time updatedTime, updated_by updatedBy
        */
    public String buildBiScopeComplaintInfoVOToCreate(BiScopeComplaintInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:Complaint{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        if(vo.getComplaintCreatedDate()!=null)
        {
            sb.append(",complaintCreatedDate:\"").append(sdf.format(vo.getComplaintCreatedDate())).append("\"");
        }

        sb.append(",done:").append(vo.getDone());
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",personId:\"").append(vo.getPersonId()).append("\"");
        sb.append(",userId:\"").append(vo.getUserId()).append("\"");
        sb.append(",projectGroupId:\"").append(vo.getProjectGroupId()).append("\"");
        sb.append(",projectUnitId:\"").append(vo.getProjectUnitId()).append("\"");
        sb.append(",typeId:\"").append(vo.getTypeId()).append("\"");

        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
