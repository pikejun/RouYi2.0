package com.ruoyi.project.system.biScopeSectionData.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeProjectData.vo.BiScopeProjectDataVO;
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

    /**
     * @param vo
     * @return
     */
    public String deleteRelationshipToParentSection(BiScopeSectionDataVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Section {id:\"").append(vo.getId()).append("\"})-[r:combination]-(w:Section{id:\"").append(vo.getParentId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * @param vo
     * @return
     */
    public String addRelationshipToParentSection(BiScopeSectionDataVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Section {id:\"").append(vo.getId()).append("\"}),(w:Section{id:\"").append(vo.getParentId()).append("\"}) ");
        sb.append("MERGE (p)-[:combination]->(w)");

        return sb.toString();
    }



    /**
     * @param vo
     * @return
     */
    public String deleteRelationshipToEnterprise(BiScopeSectionDataVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Section {id:\"").append(vo.getId()).append("\"})-[r:combination]-(w:Enterprise{id:\"").append(vo.getEnterpriseId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * @param vo
     * @return
     */
    public String addRelationshipToEnterprise(BiScopeSectionDataVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Section {id:\"").append(vo.getId()).append("\"}),(w:Enterprise{id:\"").append(vo.getEnterpriseId()).append("\"}) ");
        sb.append("MERGE (p)-[:combination]->(w)");

        return sb.toString();
    }

    /**
     * @param vo
     * @return
     */
    public String deleteRelationshipToProject(BiScopeSectionDataVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Section {id:\"").append(vo.getId()).append("\"})-[r:combination]-(w:Project{id:\"").append(vo.getProjectId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * @param vo
     * @return
     */
    public String addRelationshipToProject(BiScopeSectionDataVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:Section {id:\"").append(vo.getId()).append("\"}),(w:Project{id:\"").append(vo.getProjectId()).append("\"}) ");
        sb.append("MERGE (p)-[:combination]->(w)");

        return sb.toString();
    }

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
                        neo4jService.executCypher(buildBiScopeSectionDataVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToParentSection(vo));
                        neo4jService.executCypher(addRelationshipToEnterprise(vo));
                        neo4jService.executCypher(addRelationshipToProject(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(deleteRelationshipToParentSection(vo));
                        neo4jService.executCypher(deleteRelationshipToEnterprise(vo));
                        neo4jService.executCypher(deleteRelationshipToProject(vo));

                        neo4jService.executCypher(buildBiScopeSectionDataVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeSectionDataVOToModify(vo));

                        neo4jService.executCypher(addRelationshipToParentSection(vo));
                        neo4jService.executCypher(addRelationshipToEnterprise(vo));
                        neo4jService.executCypher(addRelationshipToProject(vo));
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

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
