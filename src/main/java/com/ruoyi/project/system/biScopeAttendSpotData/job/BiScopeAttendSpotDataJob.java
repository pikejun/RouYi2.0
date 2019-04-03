package com.ruoyi.project.system.biScopeAttendSpotData.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeAttendSpotData.service.IBiScopeAttendSpotDataService;
import com.ruoyi.project.system.biScopeAttendSpotData.vo.BiScopeAttendSpotDataVO;
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
public class BiScopeAttendSpotDataJob extends  BaseDataJob {

    public static final String logName="BiScopeAttendSpotDataJob";

    @Autowired
    private IBiScopeAttendSpotDataService biScopeAttendSpotDataService;

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

        biScopeAttendSpotDataService.updateBiScopeAttendSpotDataReadyToDeal(param);

        List<BiScopeAttendSpotDataVO> list=biScopeAttendSpotDataService.selectBiScopeAttendSpotDataReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeAttendSpotDataVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeAttendSpotDataVOToCreate(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeAttendSpotDataVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeAttendSpotDataVOToModify(vo));
                    }

                    biScopeAttendSpotDataService.updateBiScopeAttendSpotDataToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeAttendSpotDataService.updateBiScopeAttendSpotDataToFailed(param);
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
    public String buildBiScopeAttendSpotDataVOToModify(BiScopeAttendSpotDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:AttendSpot {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",attendSpotType:\"").append(vo.getAttendSpotType()).append("\"");
        if(vo.getSpotCreatedDate()!=null)
        {
            sb.append(",onWorkTime:\"").append(sdf.format(vo.getSpotCreatedDate())).append("\"");
        }
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",projectId:\"").append(vo.getProjectId()).append("\"");
        sb.append(",latitude:").append(vo.getLatitude());
        sb.append(",longitude:").append(vo.getLongitude());
        sb.append(",address:\"").append(vo.getAddress()).append("\"");
        sb.append(",createdUserId:\"").append(vo.getCreatedUserId()).append("\"");
        sb.append(",attendRadius:").append(vo.getAttendRadius());
        sb.append(",attendRemark:\"").append(vo.getAttendRemark()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeAttendSpotDataVOToDelete(BiScopeAttendSpotDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:AttendSpot) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
     tid, id, attend_spot_type attendSpotType, spot_created_date spotCreatedDate, `name`, project_id projectId, latitude, longitude, address,
     created_user_id createdUserId, attend_radius attendRadius,
        attend_remark attendRemark, op_status opStatus, op_type opType, created_by createdBy, created_time createdTime, updated_by updatedBy, updated_time updatedTime
        */
    public String buildBiScopeAttendSpotDataVOToCreate(BiScopeAttendSpotDataVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:AttendSpot{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",attendSpotType:\"").append(vo.getAttendSpotType()).append("\"");
        if(vo.getSpotCreatedDate()!=null)
        {
            sb.append(",onWorkTime:\"").append(sdf.format(vo.getSpotCreatedDate())).append("\"");
        }
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",projectId:\"").append(vo.getProjectId()).append("\"");
        sb.append(",latitude:").append(vo.getLatitude());
        sb.append(",longitude:").append(vo.getLongitude());
        sb.append(",address:\"").append(vo.getAddress()).append("\"");
        sb.append(",createdUserId:\"").append(vo.getCreatedUserId()).append("\"");
        sb.append(",attendRadius:").append(vo.getAttendRadius());
        sb.append(",attendRemark:\"").append(vo.getAttendRemark()).append("\"");

        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
