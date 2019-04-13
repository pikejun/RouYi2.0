package com.ruoyi.project.system.biScopeSectionData.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeSectionData.service.IBiScopeSectionDataService;
import com.ruoyi.project.system.biScopeSectionData.vo.BiScopeSectionDataVO;
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
public class BiScopeSectionDataJob extends  BaseDataJob {

    public static final String logName="BiScopeSectionDataJob";

    @Autowired
    private IBiScopeSectionDataService biScopeSectionDataService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeSectionDataService.updateBiScopeSectionDataReadyToDeal(param);

        List<BiScopeSectionDataVO> list=biScopeSectionDataService.selectBiScopeSectionDataReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeSectionDataVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeSectionDataVOToCreate(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeSectionDataVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeSectionDataVOToModify(vo));
                    }

                    biScopeSectionDataService.updateBiScopeSectionDataToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeSectionDataService.updateBiScopeSectionDataToFailed(param);
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
    public String buildBiScopeSectionDataVOToModify(BiScopeSectionDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Section {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",abbrName:\"").append(vo.getAbbrName()).append("\"");
        sb.append(",aliasName:\"").append(vo.getAliasName()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }
        sb.append(",enterpriseId:\"").append(vo.getEnterpriseId()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",rootProjectId:\"").append(vo.getRootProjectId()).append("\"");
        sb.append(",remark:\"").append(vo.getRemark()).append("\"");
        if(vo.getUpdateDate()!=null)
        {
            sb.append(",updateDate:\"").append(sdf.format(vo.getUpdateDate())).append("\"");
        }
        sb.append(",workStatus:\"").append(vo.getWorkStatus()).append("\"");
        sb.append(",address:\"").append(vo.getAddress()).append("\"");
        sb.append(",areaId:\"").append(vo.getAreaId()).append("\"");
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",projectId:\"").append(vo.getProjectId()).append("\"");
        sb.append(",parentId:\"").append(vo.getParentId()).append("\"");
        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeSectionDataVOToDelete(BiScopeSectionDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:Section) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
    tid, id,
         abbr_name abbrName, alias_name aliasName, create_date createDate, enterprise_id enterpriseId, name, root_project_id rootProjectId, remark,
         update_date updateDate,work_status workStatus, address,area_id areaId, level_code levelCode, project_id projectId, parent_id parentId,
         op_status opStatus, op_type opType, created_time createdTime, created_by createdBy, updated_time updatedTime, updated_by updatedBy

     */
    public String buildBiScopeSectionDataVOToCreate(BiScopeSectionDataVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:Section{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",abbrName:\"").append(vo.getAbbrName()).append("\"");
        sb.append(",aliasName:\"").append(vo.getAliasName()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }
        sb.append(",enterpriseId:\"").append(vo.getEnterpriseId()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",rootProjectId:\"").append(vo.getRootProjectId()).append("\"");
        sb.append(",remark:\"").append(vo.getRemark()).append("\"");
        if(vo.getUpdateDate()!=null)
        {
            sb.append(",updateDate:\"").append(sdf.format(vo.getUpdateDate())).append("\"");
        }
        sb.append(",workStatus:\"").append(vo.getWorkStatus()).append("\"");
        sb.append(",address:\"").append(vo.getAddress()).append("\"");
        sb.append(",areaId:\"").append(vo.getAreaId()).append("\"");
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",projectId:\"").append(vo.getProjectId()).append("\"");
        sb.append(",parentId:\"").append(vo.getParentId()).append("\"");
        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
