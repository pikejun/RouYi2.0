package com.ruoyi.project.system.biScopeRealName.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.system.biScopeRealName.service.IBiScopeRealNameService;
import com.ruoyi.project.system.biScopeRealName.vo.BiScopeRealNameVO;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BiScopeRealNameJob extends  BaseDataJob {

    public static final String logName="BiScopeRealNameJob";

    @Autowired
    private IBiScopeRealNameService biScopeRealNameService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeRealNameService.updateBiScopeRealNameReadyToDeal(param);

        List<BiScopeRealNameVO> list=biScopeRealNameService.selectBiScopeRealNameReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeRealNameVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeRealNameVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorker(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeRealNameVOToDelete(vo));
                        neo4jService.executCypher(deleteRelationshipToWorker(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeRealNameVOToModify(vo));
                        neo4jService.executCypher(addRelationshipToWorker(vo));
                    }

                    biScopeRealNameService.updateBiScopeRealNameToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeRealNameService.updateBiScopeRealNameToFailed(param);
                }
            }
        }
    }


    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     * delete (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String deleteRelationshipToWorker(BiScopeRealNameVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:RealName {id:\"").append(vo.getId()).append("\"})-[r:realName]->(w:Worker{realNameId:\"").append(vo.getId()).append("\"}) ");
        sb.append("delete r");
        return sb.toString();
    }

    /**
     * MATCH (u:User {username:'admin'}), (r:Role {name:'ROLE_WEB_USER'})
     CREATE (u)-[:HAS_ROLE]->(r)
     * @param vo
     * @return
     */
    public String addRelationshipToWorker(BiScopeRealNameVO vo)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("MATCH (p:RealName {id:\"").append(vo.getId()).append("\"}),(w:Worker{realNameId:\"").append(vo.getId()).append("\"}) ");
        sb.append("MERGE (w)-[:realName]->(p)");

        return sb.toString();
    }

    /**
     *
     id, name, sex, birth_day, province, nation, address, id_no, valid_period, sign_date, organization, back_id, front_id, photo_id, mobile, image_id, real_date, real_type
     * @param vo
     * @return
     */
    public String buildBiScopeRealNameVOToModify(BiScopeRealNameVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:RealName {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",sex:\"").append(vo.getSex()).append("\"");
        sb.append(",birthDay:\"").append(vo.getBirthDay()).append("\"");
        sb.append(",province:\"").append(vo.getProvince()).append("\"");
        sb.append(",nation:\"").append(vo.getNation()).append("\"");
        sb.append(",address:\"").append(vo.getAddress()).append("\"");
        sb.append(",idNo:\"").append(vo.getIdNo()).append("\"");
        sb.append(",validPeriod:\"").append(vo.getValidPeriod()).append("\"");
        sb.append(",signDate:\"").append(vo.getSignDate()).append("\"");
        sb.append(",organization:\"").append(vo.getOrganization()).append("\"");
        sb.append(",backId:\"").append(vo.getBackId()).append("\"");
        sb.append(",frontId:\"").append(vo.getFrontId()).append("\"");
        sb.append(",photoId:\"").append(vo.getPhotoId()).append("\"");
        sb.append(",mobile:\"").append(vo.getMobile()).append("\"");
        sb.append(",imageId:\"").append(vo.getImageId()).append("\"");
        if(vo.getRealDate()!=null)
        {
            sb.append(",realDate:\"").append(sdf.format(vo.getRealDate())).append("\"");
            sb.append(",realType:\"").append(vo.getRealType()).append("\"");
        }
        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeRealNameVOToDelete(BiScopeRealNameVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:RealName) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
