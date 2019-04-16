package com.ruoyi.project.system.biTemplateIndexProperty.service;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biTemplateIndexProperty.mapper.BiTemplateIndexPropertyMapper;
import com.ruoyi.project.system.biTemplateIndexProperty.domain.BiTemplateIndexProperty;
import com.ruoyi.project.system.biTemplateIndexProperty.service.IBiTemplateIndexPropertyService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 模板指标属性明细 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-16
 */
@Service
public class BiTemplateIndexPropertyServiceImpl implements IBiTemplateIndexPropertyService {
    @Autowired
    private BiTemplateIndexPropertyMapper biTemplateIndexPropertyMapper;

    /**
     * 查询模板指标属性明细信息
     *
     * @param tipId 模板指标属性明细ID
     * @return 模板指标属性明细信息
     */
    @Override
    public BiTemplateIndexProperty selectBiTemplateIndexPropertyById(Integer tipId) {
        return biTemplateIndexPropertyMapper.selectBiTemplateIndexPropertyById(tipId);
    }

    /**
     * 查询模板指标属性明细列表
     *
     * @param biTemplateIndexProperty 模板指标属性明细信息
     * @return 模板指标属性明细集合
     */
    @Override
    public List<BiTemplateIndexProperty> selectBiTemplateIndexPropertyList(BiTemplateIndexProperty biTemplateIndexProperty) {
        return biTemplateIndexPropertyMapper.selectBiTemplateIndexPropertyList(biTemplateIndexProperty);
    }

    /**
     * 新增模板指标属性明细
     *
     * @param biTemplateIndexProperty 模板指标属性明细信息
     * @return 结果
     */
    @Override
    public int insertBiTemplateIndexProperty(BiTemplateIndexProperty biTemplateIndexProperty) {
        return biTemplateIndexPropertyMapper.insertBiTemplateIndexProperty(biTemplateIndexProperty);
    }

    /**
     * 修改模板指标属性明细
     *
     * @param biTemplateIndexProperty 模板指标属性明细信息
     * @return 结果
     */
    @Override
    public int updateBiTemplateIndexProperty(BiTemplateIndexProperty biTemplateIndexProperty) {
        return biTemplateIndexPropertyMapper.updateBiTemplateIndexProperty(biTemplateIndexProperty);
    }

    /**
     * 删除模板指标属性明细对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiTemplateIndexPropertyByIds(String ids) {
        return biTemplateIndexPropertyMapper.deleteBiTemplateIndexPropertyByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入模板指标属性明细对象
     * @param biTemplateIndexPropertyList
     * @return
     */

    @Override
    public String importBiTemplateIndexProperty(List<BiTemplateIndexProperty> biTemplateIndexPropertyList) {
        if (StringUtils.isNull(biTemplateIndexPropertyList) || biTemplateIndexPropertyList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiTemplateIndexProperty biTemplateIndexProperty : biTemplateIndexPropertyList) {
            this.insertBiTemplateIndexProperty(biTemplateIndexProperty);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

}
