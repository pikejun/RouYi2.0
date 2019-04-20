package com.ruoyi.project.system.biReportInfo.service;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biReportInfo.mapper.BiReportInfoMapper;
import com.ruoyi.project.system.biReportInfo.domain.BiReportInfo;
import com.ruoyi.project.system.biReportInfo.service.IBiReportInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 汇报数据 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-20
 */
@Service
public class BiReportInfoServiceImpl implements IBiReportInfoService {
    @Autowired
    private BiReportInfoMapper biReportInfoMapper;

    /**
     * 查询汇报数据信息
     *
     * @param reportId 汇报数据ID
     * @return 汇报数据信息
     */
    @Override
    public BiReportInfo selectBiReportInfoById(Integer reportId) {
        return biReportInfoMapper.selectBiReportInfoById(reportId);
    }

    /**
     * 查询汇报数据列表
     *
     * @param biReportInfo 汇报数据信息
     * @return 汇报数据集合
     */
    @Override
    public List<BiReportInfo> selectBiReportInfoList(BiReportInfo biReportInfo) {
        return biReportInfoMapper.selectBiReportInfoList(biReportInfo);
    }

    /**
     * 新增汇报数据
     *
     * @param biReportInfo 汇报数据信息
     * @return 结果
     */
    @Override
    public int insertBiReportInfo(BiReportInfo biReportInfo) {
        return biReportInfoMapper.insertBiReportInfo(biReportInfo);
    }

    /**
     * 修改汇报数据
     *
     * @param biReportInfo 汇报数据信息
     * @return 结果
     */
    @Override
    public int updateBiReportInfo(BiReportInfo biReportInfo) {
        return biReportInfoMapper.updateBiReportInfo(biReportInfo);
    }

    /**
     * 删除汇报数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiReportInfoByIds(String ids) {
        return biReportInfoMapper.deleteBiReportInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入汇报数据对象
     * @param biReportInfoList
     * @return
     */

    @Override
    public String importBiReportInfo(List<BiReportInfo> biReportInfoList) {
        if (StringUtils.isNull(biReportInfoList) || biReportInfoList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiReportInfo biReportInfo : biReportInfoList) {
            this.insertBiReportInfo(biReportInfo);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

}
