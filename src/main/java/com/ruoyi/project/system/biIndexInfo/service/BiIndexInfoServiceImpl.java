package com.ruoyi.project.system.biIndexInfo.service;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biIndexInfo.mapper.BiIndexInfoMapper;
import com.ruoyi.project.system.biIndexInfo.domain.BiIndexInfo;
import com.ruoyi.project.system.biIndexInfo.service.IBiIndexInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 指标 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-16
 */
@Service
public class BiIndexInfoServiceImpl implements IBiIndexInfoService {
    @Autowired
    private BiIndexInfoMapper biIndexInfoMapper;

    /**
     * 查询指标信息
     *
     * @param indexId 指标ID
     * @return 指标信息
     */
    @Override
    public BiIndexInfo selectBiIndexInfoById(Integer indexId) {
        return biIndexInfoMapper.selectBiIndexInfoById(indexId);
    }

    /**
     * 查询指标列表
     *
     * @param biIndexInfo 指标信息
     * @return 指标集合
     */
    @Override
    public List<BiIndexInfo> selectBiIndexInfoList(BiIndexInfo biIndexInfo) {
        return biIndexInfoMapper.selectBiIndexInfoList(biIndexInfo);
    }

    /**
     * 新增指标
     *
     * @param biIndexInfo 指标信息
     * @return 结果
     */
    @Override
    public int insertBiIndexInfo(BiIndexInfo biIndexInfo) {
        return biIndexInfoMapper.insertBiIndexInfo(biIndexInfo);
    }

    /**
     * 修改指标
     *
     * @param biIndexInfo 指标信息
     * @return 结果
     */
    @Override
    public int updateBiIndexInfo(BiIndexInfo biIndexInfo) {
        return biIndexInfoMapper.updateBiIndexInfo(biIndexInfo);
    }

    /**
     * 删除指标对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiIndexInfoByIds(String ids) {
        return biIndexInfoMapper.deleteBiIndexInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入指标对象
     * @param biIndexInfoList
     * @return
     */

    @Override
    public String importBiIndexInfo(List<BiIndexInfo> biIndexInfoList) {
        if (StringUtils.isNull(biIndexInfoList) || biIndexInfoList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiIndexInfo biIndexInfo : biIndexInfoList) {
            this.insertBiIndexInfo(biIndexInfo);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

}
