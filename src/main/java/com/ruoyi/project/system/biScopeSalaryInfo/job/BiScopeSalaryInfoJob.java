package com.ruoyi.project.system.biScopeSalaryInfo.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeSalaryInfo.service.IBiScopeSalaryInfoService;
import com.ruoyi.project.system.biScopeSalaryInfo.vo.BiScopeSalaryInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
public class BiScopeSalaryInfoJob extends  BaseDataJob {

    public static final String logName="BiScopeSalaryInfoJob";

    @Autowired
    private IBiScopeSalaryInfoService biScopeSalaryInfoService;

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

        biScopeSalaryInfoService.updateBiScopeSalaryInfoReadyToDeal(param);

        List<BiScopeSalaryInfoVO> list=biScopeSalaryInfoService.selectBiScopeSalaryInfoReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeSalaryInfoVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeSalaryInfoVOToCreate(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeSalaryInfoVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeSalaryInfoVOToModify(vo));
                    }

                    biScopeSalaryInfoService.updateBiScopeSalaryInfoToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeSalaryInfoService.updateBiScopeSalaryInfoToFailed(param);
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
    public String buildBiScopeSalaryInfoVOToModify(BiScopeSalaryInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Salary {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",allMoney:").append(vo.getAllMoney());
        sb.append(",realMoney:").append(vo.getRealMoney());
        sb.append(",percent:").append(vo.getPercent());

        if(vo.getFireDate()!=null)
        {
            sb.append(",fireDate:\"").append(sdf.format(vo.getFireDate())).append("\"");
        }

        sb.append(",fired:").append(vo.getFired());
        sb.append(",attendCount:").append(vo.getAttendCount());
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",month:\"").append(vo.getMonth()).append("\"");
        sb.append(",personId:\"").append(vo.getPersonId()).append("\"");
        sb.append(",userId:\"").append(vo.getUserId()).append("\"");
        sb.append(",projectGroupId:\"").append(vo.getProjectGroupId()).append("\"");
        sb.append(",projectUnitId:\"").append(vo.getProjectUnitId()).append("\"");
        sb.append(",satisfaction:\"").append(vo.getSatisfaction()).append("\"");
        if(vo.getFeedbackDate()!=null)
        {
            sb.append(",feedbackDate:\"").append(sdf.format(vo.getFeedbackDate())).append("\"");
        }
        sb.append(",status:\"").append(vo.getStatus()).append("\"");
        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeSalaryInfoVOToDelete(BiScopeSalaryInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:Salary) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
    tid, id, all_money allMoney, real_money realMoney, percent, fire_date fireDate, fired, attend_count attendCount, level_code levelCode, month,
     person_id personId, user_id userId, project_group_id projectGroupId, project_unit_id projectUnitId, satisfaction, feedback_date feedbackDate, status, op_status opStatus, op_type opType, created_time createdTime, created_by createdBy, updated_time updatedTime, updated_by updatedBy
        */
    public String buildBiScopeSalaryInfoVOToCreate(BiScopeSalaryInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:Salary{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",allMoney:").append(vo.getAllMoney());
        sb.append(",realMoney:").append(vo.getRealMoney());
        sb.append(",percent:").append(vo.getPercent());

        if(vo.getFireDate()!=null)
        {
            sb.append(",fireDate:\"").append(sdf.format(vo.getFireDate())).append("\"");
        }

        sb.append(",fired:").append(vo.getFired());
        sb.append(",attendCount:").append(vo.getAttendCount());
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",month:\"").append(vo.getMonth()).append("\"");
        sb.append(",personId:\"").append(vo.getPersonId()).append("\"");
        sb.append(",userId:\"").append(vo.getUserId()).append("\"");
        sb.append(",projectGroupId:\"").append(vo.getProjectGroupId()).append("\"");
        sb.append(",projectUnitId:\"").append(vo.getProjectUnitId()).append("\"");
        sb.append(",satisfaction:\"").append(vo.getSatisfaction()).append("\"");
        if(vo.getFeedbackDate()!=null)
        {
            sb.append(",feedbackDate:\"").append(sdf.format(vo.getFeedbackDate())).append("\"");
        }
        sb.append(",status:\"").append(vo.getStatus()).append("\"");
        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
