package com.ruoyi.project.system.biScopeSafeEvent.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeSafeEvent.service.IBiScopeSafeEventService;
import com.ruoyi.project.system.biScopeSafeEvent.vo.BiScopeSafeEventVO;
import com.ruoyi.project.system.biScopeSafeEvent.service.IBiScopeSafeEventService;
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
public class BiScopeSafeEventJob extends  BaseDataJob {

    public static final String logName="BiScopeSafeEventJob";

    @Autowired
    private IBiScopeSafeEventService biScopeSafeEventService;

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

        biScopeSafeEventService.updateBiScopeSafeEventReadyToDeal(param);

        List<BiScopeSafeEventVO> list=biScopeSafeEventService.selectBiScopeSafeEventReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeSafeEventVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeSafeEventVOToCreate(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeSafeEventVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeSafeEventVOToModify(vo));
                    }

                    biScopeSafeEventService.updateBiScopeSafeEventToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeSafeEventService.updateBiScopeSafeEventToFailed(param);
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
    public String buildBiScopeSafeEventVOToModify(BiScopeSafeEventVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:SafeEvent {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",eventName:\"").append(vo.getEventName()).append("\"");
        if(vo.getEventCreatedDate()!=null)
        {
            sb.append(",eventCreatedDate:\"").append(sdf.format(vo.getEventCreatedDate())).append("\"");
        }
        sb.append(",content:\"").append(vo.getContent()).append("\"");

        sb.append(",checkerId:\"").append(vo.getCheckerId()).append("\"");
        sb.append(",userId:\"").append(vo.getUserId()).append("\"");
        sb.append(",itemId:\"").append(vo.getItemId()).append("\"");
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",projectUnitId:\"").append(vo.getProjectUnitId()).append("\"");
        sb.append(",type:\"").append(vo.getType()).append("\"");
        sb.append(",critical:").append(vo.getCritical());
        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeSafeEventVOToDelete(BiScopeSafeEventVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:SafeEvent) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
   tid, id, event_name, event_created_date eventCreatedDate, content, checker_id checkerId, user_id userId, item_id itemId, level_code levelCode,
   project_unit_id projectUnitId, `type`, critical, op_status opStatus, op_type opType,
         created_time createdTime, created_by createdBy, updated_time updatedTime, updated_by updatedBy

      */
    public String buildBiScopeSafeEventVOToCreate(BiScopeSafeEventVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:SafeEvent{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",eventName:\"").append(vo.getEventName()).append("\"");
        if(vo.getEventCreatedDate()!=null)
        {
            sb.append(",eventCreatedDate:\"").append(sdf.format(vo.getEventCreatedDate())).append("\"");
        }
        sb.append(",content:\"").append(vo.getContent()).append("\"");

        sb.append(",checkerId:\"").append(vo.getCheckerId()).append("\"");
        sb.append(",userId:\"").append(vo.getUserId()).append("\"");
        sb.append(",itemId:\"").append(vo.getItemId()).append("\"");
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",projectUnitId:\"").append(vo.getProjectUnitId()).append("\"");
        sb.append(",type:\"").append(vo.getType()).append("\"");
        sb.append(",critical:").append(vo.getCritical());


        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
