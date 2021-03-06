package com.ruoyi.project.system.biScopeAttendInfo.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeAttendInfo.service.IBiScopeAttendInfoService;
import com.ruoyi.project.system.biScopeAttendInfo.vo.BiScopeAttendInfoVO;
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
public class BiScopeAttendInfoJob extends  BaseDataJob {

    public static final String logName="BiScopeAttendInfoJob";

    @Autowired
    private IBiScopeAttendInfoService biScopeAttendInfoService;

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

        biScopeAttendInfoService.updateBiScopeAttendInfoReadyToDeal(param);

        List<BiScopeAttendInfoVO> list=biScopeAttendInfoService.selectBiScopeAttendInfoReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeAttendInfoVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeAttendInfoVOToCreate(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeAttendInfoVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeAttendInfoVOToModify(vo));
                    }

                    biScopeAttendInfoService.updateBiScopeAttendInfoToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeAttendInfoService.updateBiScopeAttendInfoToFailed(param);
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
    public String buildBiScopeAttendInfoVOToModify(BiScopeAttendInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Attend {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        if(vo.getOnWorkTime()!=null)
        {
            sb.append(",onWorkTime:\"").append(sdf.format(vo.getOnWorkTime())).append("\"");
        }

        sb.append(",personId:\"").append(vo.getPersonId()).append("\"");

        if(vo.getUnWorkTime()!=null)
        {
            sb.append(",unWorkTime:\"").append(sdf.format(vo.getUnWorkTime())).append("\"");
        }

        sb.append(",attendMode:\"").append(vo.getAttendMode()).append("\"");
        sb.append(",day:\"").append(vo.getDay()).append("\"");
        sb.append(",month:\"").append(vo.getMonth()).append("\"");
        sb.append(",attendSpotId:\"").append(vo.getAttendSpotId()).append("\"");
        sb.append(",imageId:\"").append(vo.getImageId()).append("\"");
        sb.append(",userId:\"").append(vo.getUserId()).append("\"");
        sb.append(",deviceNumber:\"").append(vo.getDeviceNumber()).append("\"");
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",projectUnitId:\"").append(vo.getProjectUnitId()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeAttendInfoVOToDelete(BiScopeAttendInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:Attend) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
     tid, id, on_work_time onWorkTime, person_id personId, un_work_time unWorkTime, attend_mode attendMode, `day`, `month`, attend_spot_id attendSpotId,
         image_id imageId, user_id userId, device_number deviceNumber, level_code levelCode, project_unit_id projectUnitId, op_status opStatus, op_type opType, created_time createdTime,
         created_by createdBy, updated_time updatedTime, updated_by updatedBy  */
    public String buildBiScopeAttendInfoVOToCreate(BiScopeAttendInfoVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:Attend{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        if(vo.getOnWorkTime()!=null)
        {
            sb.append(",onWorkTime:\"").append(sdf.format(vo.getOnWorkTime())).append("\"");
        }

        sb.append(",personId:\"").append(vo.getPersonId()).append("\"");

        if(vo.getUnWorkTime()!=null)
        {
            sb.append(",unWorkTime:\"").append(sdf.format(vo.getUnWorkTime())).append("\"");
        }

        sb.append(",attendMode:\"").append(vo.getAttendMode()).append("\"");
        sb.append(",day:\"").append(vo.getDay()).append("\"");
        sb.append(",month:\"").append(vo.getMonth()).append("\"");
        sb.append(",attendSpotId:\"").append(vo.getAttendSpotId()).append("\"");
        sb.append(",imageId:\"").append(vo.getImageId()).append("\"");
        sb.append(",userId:\"").append(vo.getUserId()).append("\"");
        sb.append(",deviceNumber:\"").append(vo.getDeviceNumber()).append("\"");
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",projectUnitId:\"").append(vo.getProjectUnitId()).append("\"");

        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
