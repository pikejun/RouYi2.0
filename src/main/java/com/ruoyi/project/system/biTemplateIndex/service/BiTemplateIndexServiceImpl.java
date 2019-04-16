package com.ruoyi.project.system.biTemplateIndex.service;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biTemplateIndex.mapper.BiTemplateIndexMapper;
import com.ruoyi.project.system.biTemplateIndex.domain.BiTemplateIndex;
import com.ruoyi.project.system.biTemplateIndex.service.IBiTemplateIndexService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 模板指标明细 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-16
 */
@Service
public class BiTemplateIndexServiceImpl implements IBiTemplateIndexService {
    @Autowired
    private BiTemplateIndexMapper biTemplateIndexMapper;

    /**
     * 查询模板指标明细信息
     *
     * @param tiid 模板指标明细ID
     * @return 模板指标明细信息
     */
    @Override
    public BiTemplateIndex selectBiTemplateIndexById(Integer tiid) {
        return biTemplateIndexMapper.selectBiTemplateIndexById(tiid);
    }

    /**
     * 查询模板指标明细列表
     *
     * @param biTemplateIndex 模板指标明细信息
     * @return 模板指标明细集合
     */
    @Override
    public List<BiTemplateIndex> selectBiTemplateIndexList(BiTemplateIndex biTemplateIndex) {
        return biTemplateIndexMapper.selectBiTemplateIndexList(biTemplateIndex);
    }

    /**
     * 新增模板指标明细
     *
     * @param biTemplateIndex 模板指标明细信息
     * @return 结果
     */
    @Override
    public int insertBiTemplateIndex(BiTemplateIndex biTemplateIndex) {
        return biTemplateIndexMapper.insertBiTemplateIndex(biTemplateIndex);
    }

    /**
     * 修改模板指标明细
     *
     * @param biTemplateIndex 模板指标明细信息
     * @return 结果
     */
    @Override
    public int updateBiTemplateIndex(BiTemplateIndex biTemplateIndex) {
        return biTemplateIndexMapper.updateBiTemplateIndex(biTemplateIndex);
    }

    /**
     * 删除模板指标明细对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiTemplateIndexByIds(String ids) {
        return biTemplateIndexMapper.deleteBiTemplateIndexByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入模板指标明细对象
     * @param biTemplateIndexList
     * @return
     */

    @Override
    public String importBiTemplateIndex(List<BiTemplateIndex> biTemplateIndexList) {
        if (StringUtils.isNull(biTemplateIndexList) || biTemplateIndexList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiTemplateIndex biTemplateIndex : biTemplateIndexList) {
            this.insertBiTemplateIndex(biTemplateIndex);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

}
