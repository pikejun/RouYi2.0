package com.ruoyi.project.system.biIndexField.service;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biIndexField.mapper.BiIndexFieldMapper;
import com.ruoyi.project.system.biIndexField.domain.BiIndexField;
import com.ruoyi.project.system.biIndexField.service.IBiIndexFieldService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 指标字段明细 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-16
 */
@Service
public class BiIndexFieldServiceImpl implements IBiIndexFieldService {
    @Autowired
    private BiIndexFieldMapper biIndexFieldMapper;

    /**
     * 查询指标字段明细信息
     *
     * @param fieldId 指标字段明细ID
     * @return 指标字段明细信息
     */
    @Override
    public BiIndexField selectBiIndexFieldById(Integer fieldId) {
        return biIndexFieldMapper.selectBiIndexFieldById(fieldId);
    }

    /**
     * 查询指标字段明细列表
     *
     * @param biIndexField 指标字段明细信息
     * @return 指标字段明细集合
     */
    @Override
    public List<BiIndexField> selectBiIndexFieldList(BiIndexField biIndexField) {
        return biIndexFieldMapper.selectBiIndexFieldList(biIndexField);
    }

    /**
     * 新增指标字段明细
     *
     * @param biIndexField 指标字段明细信息
     * @return 结果
     */
    @Override
    public int insertBiIndexField(BiIndexField biIndexField) {
        return biIndexFieldMapper.insertBiIndexField(biIndexField);
    }

    /**
     * 修改指标字段明细
     *
     * @param biIndexField 指标字段明细信息
     * @return 结果
     */
    @Override
    public int updateBiIndexField(BiIndexField biIndexField) {
        return biIndexFieldMapper.updateBiIndexField(biIndexField);
    }

    /**
     * 删除指标字段明细对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiIndexFieldByIds(String ids) {
        return biIndexFieldMapper.deleteBiIndexFieldByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入指标字段明细对象
     * @param biIndexFieldList
     * @return
     */

    @Override
    public String importBiIndexField(List<BiIndexField> biIndexFieldList) {
        if (StringUtils.isNull(biIndexFieldList) || biIndexFieldList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiIndexField biIndexField : biIndexFieldList) {
            this.insertBiIndexField(biIndexField);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

}
