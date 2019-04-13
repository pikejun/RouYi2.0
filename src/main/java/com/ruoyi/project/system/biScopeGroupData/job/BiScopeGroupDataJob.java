package com.ruoyi.project.system.biScopeGroupData.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeGroupData.service.IBiScopeGroupDataService;
import com.ruoyi.project.system.biScopeGroupData.vo.BiScopeGroupDataVO;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BiScopeGroupDataJob extends  BaseDataJob {

    public static final String logName="BiScopeGroupDataJob";

    @Autowired
    private IBiScopeGroupDataService biScopeGroupDataService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeGroupDataService.updateBiScopeGroupDataReadyToDeal(param);

        List<BiScopeGroupDataVO> list=biScopeGroupDataService.selectBiScopeGroupDataReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeGroupDataVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeGroupDataVOToModify(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeGroupDataVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeGroupDataVOToModify(vo));
                    }

                    biScopeGroupDataService.updateBiScopeGroupDataToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeGroupDataService.updateBiScopeGroupDataToFailed(param);
                }
            }
        }
    }

    /**
     *
     id, create_date createDate, name, level_code levelCode, parent_id parentId, project_id projectId, root_project_id rootProjectId,
     remark, update_date updateDate, work_status workStatus,
     * @param vo
     * @return
     */
    public String buildBiScopeGroupDataVOToModify(BiScopeGroupDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:WorkerGroup {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",parentId:\"").append(vo.getParentId()).append("\"");
        sb.append(",projectId:\"").append(vo.getProjectId()).append("\"");
        sb.append(",rootProjectId:\"").append(vo.getRootProjectId()).append("\"");
        sb.append(",remark:\"").append(vo.getRemark()).append("\"");
        if(vo.getUpdateDate()!=null)
        {
            sb.append(",updateDate:\"").append(sdf.format(vo.getUpdateDate())).append("\"");
        }

        sb.append(",workStatus:\"").append(vo.getWorkStatus()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeGroupDataVOToDelete(BiScopeGroupDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:WorkerGroup) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }



    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
