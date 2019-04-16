package com.ruoyi.project.system.biScopeProperty.service;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeProperty.mapper.BiScopePropertyMapper;
import com.ruoyi.project.system.biScopeProperty.domain.BiScopeProperty;
import com.ruoyi.project.system.biScopeProperty.service.IBiScopePropertyService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 范围属性 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-16
 */
@Service
public class BiScopePropertyServiceImpl implements IBiScopePropertyService {
    @Autowired
    private BiScopePropertyMapper biScopePropertyMapper;

    /**
     * 查询范围属性信息
     *
     * @param propertyId 范围属性ID
     * @return 范围属性信息
     */
    @Override
    public BiScopeProperty selectBiScopePropertyById(Integer propertyId) {
        return biScopePropertyMapper.selectBiScopePropertyById(propertyId);
    }

    /**
     * 查询范围属性列表
     *
     * @param biScopeProperty 范围属性信息
     * @return 范围属性集合
     */
    @Override
    public List<BiScopeProperty> selectBiScopePropertyList(BiScopeProperty biScopeProperty) {
        return biScopePropertyMapper.selectBiScopePropertyList(biScopeProperty);
    }

    /**
     * 新增范围属性
     *
     * @param biScopeProperty 范围属性信息
     * @return 结果
     */
    @Override
    public int insertBiScopeProperty(BiScopeProperty biScopeProperty) {
        return biScopePropertyMapper.insertBiScopeProperty(biScopeProperty);
    }

    /**
     * 修改范围属性
     *
     * @param biScopeProperty 范围属性信息
     * @return 结果
     */
    @Override
    public int updateBiScopeProperty(BiScopeProperty biScopeProperty) {
        return biScopePropertyMapper.updateBiScopeProperty(biScopeProperty);
    }

    /**
     * 删除范围属性对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopePropertyByIds(String ids) {
        return biScopePropertyMapper.deleteBiScopePropertyByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入范围属性对象
     * @param biScopePropertyList
     * @return
     */

    @Override
    public String importBiScopeProperty(List<BiScopeProperty> biScopePropertyList) {
        if (StringUtils.isNull(biScopePropertyList) || biScopePropertyList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeProperty biScopeProperty : biScopePropertyList) {
            this.insertBiScopeProperty(biScopeProperty);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

}
