package com.ruoyi.project.system.biScopePersonData.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopePersonData.service.IBiScopePersonDataService;
import com.ruoyi.project.system.biScopePersonData.vo.BiScopePersonDataVO;
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
public class BiScopePersonDataJob extends  BaseDataJob {

    public static final String logName="BiScopePersonDataJob";

    @Autowired
    private IBiScopePersonDataService biScopePersonDataService;

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

        biScopePersonDataService.updateBiScopePersonDataReadyToDeal(param);

        List<BiScopePersonDataVO> list=biScopePersonDataService.selectBiScopePersonDataReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopePersonDataVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopePersonDataVOToCreate(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopePersonDataVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopePersonDataVOToModify(vo));
                    }

                    biScopePersonDataService.updateBiScopePersonDataToComplate(param);
                }
                catch (Exception e)
                {
                    biScopePersonDataService.updateBiScopePersonDataToFailed(param);
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
    public String buildBiScopePersonDataVOToModify(BiScopePersonDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Person {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",birthDay:\"").append(vo.getBirthDay()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",nation:\"").append(vo.getNation()).append("\"");
        sb.append(",address:\"").append(vo.getAddress()).append("\"");
        sb.append(",idNo:\"").append(vo.getIdNo()).append("\"");
        sb.append(",province:\"").append(vo.getProvince()).append("\"");
        sb.append(",sex:\"").append(vo.getSex()).append("\"");
        sb.append(",validPeriod:\"").append(vo.getValidPeriod()).append("\"");
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
        sb.append(",status:\"").append(vo.getStatus()).append("\"");
        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopePersonDataVOToDelete(BiScopePersonDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:Person) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }

    /*
    CREATE (n:Label {name:"L1", type:"T1"})
     tid, id, birth_day as birthDay, name, nation, address, id_no idNo, province, sex, valid_period validPeriod, back_id backId, front_id frontId,
     photo_id photoId, mobile, image_id imageId, real_date realDate, real_type realType, status, op_status opStatus, op_type opType, created_time createdTime, created_by createdBy, updated_time updatedTime, updated_by updatedBy
     */
    public String buildBiScopePersonDataVOToCreate(BiScopePersonDataVO vo)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("CREATE (n:Person{");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",birthDay:\"").append(vo.getBirthDay()).append("\"");
        sb.append(",name:\"").append(vo.getName()).append("\"");
        sb.append(",nation:\"").append(vo.getNation()).append("\"");
        sb.append(",address:\"").append(vo.getAddress()).append("\"");
        sb.append(",idNo:\"").append(vo.getIdNo()).append("\"");
        sb.append(",province:\"").append(vo.getProvince()).append("\"");
        sb.append(",sex:\"").append(vo.getSex()).append("\"");
        sb.append(",validPeriod:\"").append(vo.getValidPeriod()).append("\"");
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

        sb.append(",status:\"").append(vo.getStatus()).append("\"");
        sb.append("})");

        return sb.toString();
    }

    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
