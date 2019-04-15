package com.ruoyi.project.system.biScopeDeviceData.job;

import com.ruoyi.project.bi.job.BaseDataJob;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biScopeDeviceData.service.IBiScopeDeviceDataService;
import com.ruoyi.project.system.biScopeDeviceData.vo.BiScopeDeviceDataVO;
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
public class BiScopeDeviceDataJob extends  BaseDataJob {

    public static final String logName="BiScopeDeviceDataJob";

    @Autowired
    private IBiScopeDeviceDataService biScopeDeviceDataService;

    @Override
    public void doJob()
    {
        log.info(logName,"host:"+host);

        Map param = new HashMap();

        param.put("host",host);

        biScopeDeviceDataService.updateBiScopeDeviceDataReadyToDeal(param);

        List<BiScopeDeviceDataVO> list=biScopeDeviceDataService.selectBiScopeDeviceDataReadToDeal(param);

        if(list!=null && list.size()>0)
        {
            for(BiScopeDeviceDataVO vo:list)
            {
                param.put("tid",vo.getTid());

                try
                {

                    if("A".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeDeviceDataVOToModify(vo));
                    }
                    else if("D".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeDeviceDataVOToDelete(vo));
                    }
                    else if("M".equals(vo.getOpType()))
                    {
                        neo4jService.executCypher(buildBiScopeDeviceDataVOToModify(vo));
                    }

                    biScopeDeviceDataService.updateBiScopeDeviceDataToComplate(param);
                }
                catch (Exception e)
                {
                    biScopeDeviceDataService.updateBiScopeDeviceDataToFailed(param);
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
    public String buildBiScopeDeviceDataVOToModify(BiScopeDeviceDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("MERGE (n:Device {id: '").append(vo.getId()).append("'})");
        sb.append("SET n = {");
        sb.append("id:\"").append(vo.getId()).append("\"");
        sb.append(",addrName:\"").append(vo.getAddrName()).append("\"");
        sb.append(",addrNo:\"").append(vo.getAddrNo()).append("\"");
        sb.append(",deviceName:\"").append(vo.getDeviceName()).append("\"");
        sb.append(",deviceModel:\"").append(vo.getDeviceModel()).append("\"");
        sb.append(",deviceType:\"").append(vo.getDeviceType()).append("\"");
        sb.append(",deviceManufactor:\"").append(vo.getDeviceManufactor()).append("\"");
        sb.append(",deviceVersion:\"").append(vo.getDeviceVersion()).append("\"");

        if(vo.getBuyDate()!=null)
        {
            sb.append(",buyDate:\"").append(sdf.format(vo.getBuyDate())).append("\"");
        }

        if(vo.getPutDate()!=null)
        {
            sb.append(",putDate:\"").append(sdf.format(vo.getPutDate())).append("\"");
        }

        sb.append(",remark:\"").append(vo.getRemark()).append("\"");

        sb.append(",useStatus:\"").append(vo.getUseStatus()).append("\"");
        sb.append(",projectId:\"").append(vo.getProjectId()).append("\"");
        sb.append(",projectUnitId:\"").append(vo.getProjectUnitId()).append("\"");
        sb.append(",levelCode:\"").append(vo.getLevelCode()).append("\"");
        sb.append(",sceneId:\"").append(vo.getSceneId()).append("\"");
        sb.append(",deviceStatus:\"").append(vo.getDeviceStatus()).append("\"");

        sb.append("} RETURN n");
        return sb.toString();
    }

    /**
     * match (n:Label)where n.id='123' delete n;
     * @param vo
     * @return
     */
    public String buildBiScopeDeviceDataVOToDelete(BiScopeDeviceDataVO vo)
    {
        StringBuilder sb=new StringBuilder();
        sb.append("match (n:Device) where n.id='").append(vo.getId()).append("' delete n");

        return sb.toString();
    }


    public static SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
}
