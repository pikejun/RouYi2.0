package com.ruoyi.project.system.biScopeRootProjectData.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeRootProjectData.service.IBiScopeRootProjectDataService;
import com.ruoyi.project.system.biScopeRootProjectData.vo.BiScopeRootProjectDataVO;
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
public class BiScopeRootProjectDataJob extends  BaseDataJob {

    public static final String logName="BiScopeRootProjectDataJob";

    @Autowired
    private IBiScopeRootProjectDataService biScopeRootProjectDataService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeRootProjectDataService.updateBiScopeRootProjectDataReadyToDeal(param);

        List<BiScopeRootProjectDataVO> list=biScopeRootProjectDataService.selectBiScopeRootProjectDataReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeRootProjectDataVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeRootProjectDataVOToCreate(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeRootProjectDataVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeRootProjectDataVOToModify(vo));
                    }

                    biScopeRootProjectDataService.updateBiScopeRootProjectDataToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeRootProjectDataService.updateBiScopeRootProjectDataToFailed(param);
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
    public String buildBiScopeRootProjectDataVOToModify(BiScopeRootProjectDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:RootProject {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",abbrName:\"").append(vo.getAbbrName()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }

        sb.append(",createUser:\"").append(vo.getCreateUser()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeRootProjectDataVOToDelete(BiScopeRootProjectDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:RootProject) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
   tid, id, abbr_name abbrName, create_date createDate, createUser, name, op_status opStatus, op_type opType, created_time createdTime, created_by createdBy, updated_time updatedTime, updated_by updatedBy  */
    public String buildBiScopeRootProjectDataVOToCreate(BiScopeRootProjectDataVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:RootProject{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",abbrName:\"").append(vo.getAbbrName()).append("\"");
        if(vo.getCreateDate()!=null)
        {
            sb.append(",createDate:\"").append(sdf.format(vo.getCreateDate())).append("\"");
        }

        sb.append(",createUser:\"").append(vo.getCreateUser()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
