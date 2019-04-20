package com.ruoyi.project.system.biIndexDisplay.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biIndexInfo.service.IBiIndexInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biIndexDisplay.mapper.BiIndexDisplayMapper;
import com.ruoyi.project.system.biIndexDisplay.domain.BiIndexDisplay;
import com.ruoyi.common.utils.text.Convert;

/**
 * 指标展示 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-18
 */
@Service
public class BiIndexDisplayServiceImpl implements IBiIndexDisplayService {
    @Autowired
    private BiIndexDisplayMapper biIndexDisplayMapper;

    @Autowired
    private IBiIndexInfoService biIndexInfoService;

    public String getDisplayHtml(String scopeName, String id,String displayNo,String indexNo)
    {
        BiIndexDisplay query=new BiIndexDisplay();
        query.setIndexNo(indexNo);
        query.setDisplayNo(displayNo);
        List<BiIndexDisplay> list = biIndexDisplayMapper.selectBiIndexDisplayList(query);

        if(list!=null && list.size()>0)
        {
            BiIndexDisplay biIndexDisplay = list.get(0);

            String displayContent= biIndexDisplay.getDisplayContent();

            StringBuilder ret=new StringBuilder();

            List<Map> indexValue = biIndexInfoService.getDetailDataByIndex(scopeName,id,biIndexDisplay.getIndexNo());

            if(indexValue!=null && indexValue.size()>0)
            {
                for(Map param:indexValue)
                {
                    String tmp=displayContent;
                    for(Object key:param.keySet())
                    {
                        tmp = tmp.replaceAll("@"+key+"@",""+param.get(key));
                    }

                    ret.append(tmp);
                }
            }
            else
            {
                return "指标值为空";
            }

            return ret.toString();
        }
        else
        {
            return "该指标的显示配置不存在，indexNo="+indexNo+";displayNo="+displayNo;
        }
    }

    public String getDisplayHtml(Integer displayId)
    {
        BiIndexDisplay biIndexDisplay = biIndexDisplayMapper.selectBiIndexDisplayById(displayId);
        String displayContent= biIndexDisplay.getDisplayContent();

        StringBuilder ret=new StringBuilder();

        List<Map> indexValue = biIndexInfoService.getDetailDataByIndex(biIndexDisplay.getIndexNo());

        if(indexValue!=null && indexValue.size()>0)
        {
            for(Map param:indexValue)
            {
                String tmp=displayContent;
                for(Object key:param.keySet())
                {
                    tmp = tmp.replaceAll("@"+key+"@",""+param.get(key));
                }

                ret.append(tmp);
            }
        }
        else
        {
            return "指标值为空";
        }

        return ret.toString();
    }

    /**
     * 查询指标展示信息
     *
     * @param displayId 指标展示ID
     * @return 指标展示信息
     */
    @Override
    public BiIndexDisplay selectBiIndexDisplayById(Integer displayId) {
        return biIndexDisplayMapper.selectBiIndexDisplayById(displayId);
    }

    /**
     * 查询指标展示列表
     *
     * @param biIndexDisplay 指标展示信息
     * @return 指标展示集合
     */
    @Override
    public List<BiIndexDisplay> selectBiIndexDisplayList(BiIndexDisplay biIndexDisplay) {
        return biIndexDisplayMapper.selectBiIndexDisplayList(biIndexDisplay);
    }

    /**
     * 新增指标展示
     *
     * @param biIndexDisplay 指标展示信息
     * @return 结果
     */
    @Override
    public int insertBiIndexDisplay(BiIndexDisplay biIndexDisplay) {
        return biIndexDisplayMapper.insertBiIndexDisplay(biIndexDisplay);
    }

    /**
     * 修改指标展示
     *
     * @param biIndexDisplay 指标展示信息
     * @return 结果
     */
    @Override
    public int updateBiIndexDisplay(BiIndexDisplay biIndexDisplay) {
        return biIndexDisplayMapper.updateBiIndexDisplay(biIndexDisplay);
    }

    /**
     * 删除指标展示对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiIndexDisplayByIds(String ids) {
        return biIndexDisplayMapper.deleteBiIndexDisplayByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入指标展示对象
     * @param biIndexDisplayList
     * @return
     */

    @Override
    public String importBiIndexDisplay(List<BiIndexDisplay> biIndexDisplayList) {
        if (StringUtils.isNull(biIndexDisplayList) || biIndexDisplayList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiIndexDisplay biIndexDisplay : biIndexDisplayList) {
            this.insertBiIndexDisplay(biIndexDisplay);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

}
