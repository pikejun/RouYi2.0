package com.ruoyi.project.system.biScopeEnterpriseDepartment.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeEnterpriseDepartment.service.IBiScopeEnterpriseDepartmentService;
import com.ruoyi.project.system.biScopeEnterpriseDepartment.vo.BiScopeEnterpriseDepartmentVO;
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
public class BiScopeEnterpriseDepartmentJob extends  BaseDataJob {

    public static final String logName="BiScopeEnterpriseDepartmentJob";

    @Autowired
    private IBiScopeEnterpriseDepartmentService biScopeEnterpriseDepartmentService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeEnterpriseDepartmentService.updateBiScopeEnterpriseDepartmentReadyToDeal(param);

        List<BiScopeEnterpriseDepartmentVO> list=biScopeEnterpriseDepartmentService.selectBiScopeEnterpriseDepartmentReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeEnterpriseDepartmentVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeEnterpriseDepartmentVOToCreate(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeEnterpriseDepartmentVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeEnterpriseDepartmentVOToModify(vo));
                    }

                    biScopeEnterpriseDepartmentService.updateBiScopeEnterpriseDepartmentToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeEnterpriseDepartmentService.updateBiScopeEnterpriseDepartmentToFailed(param);
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
    public String buildBiScopeEnterpriseDepartmentVOToModify(BiScopeEnterpriseDepartmentVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:EnterpriseDepartment {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",abbrName:\"").append(vo.getAbbrName()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }
        sb.append(",enterpriseId:\"").append(vo.getEnterpriseId()).append("\"");


        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");

        sb.append(",parentId:\"").append(vo.getParentId()).append("\"");

        sb.append(",remark:\"").append(vo.getRemark()).append("\"");
        sb.append(",rootId:\"").append(vo.getRootId()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeEnterpriseDepartmentVOToDelete(BiScopeEnterpriseDepartmentVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:EnterpriseDepartment) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
     tid, id, abbr_name abbrName, create_date createDate, enterprise_id enterpriseId, level_code levelCode, name, parent_id parentId, remark, root_id rootId,
         op_status opStatus, op_type opType, created_time createdTime, created_by createdBy, updated_time updatedTime, updated_by updatedBy
        */
    public String buildBiScopeEnterpriseDepartmentVOToCreate(BiScopeEnterpriseDepartmentVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:EnterpriseDepartment{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",abbrName:\"").append(vo.getAbbrName()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }
        sb.append(",enterpriseId:\"").append(vo.getEnterpriseId()).append("\"");


        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");

        sb.append(",parentId:\"").append(vo.getParentId()).append("\"");

        sb.append(",remark:\"").append(vo.getRemark()).append("\"");
        sb.append(",rootId:\"").append(vo.getRootId()).append("\"");

        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
