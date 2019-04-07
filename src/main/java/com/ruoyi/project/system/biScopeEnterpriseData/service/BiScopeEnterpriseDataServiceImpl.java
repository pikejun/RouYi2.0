package com.ruoyi.project.system.biScopeEnterpriseData.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeEnterpriseData.vo.BiScopeEnterpriseDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeEnterpriseData.mapper.BiScopeEnterpriseDataMapper;
import com.ruoyi.project.system.biScopeEnterpriseData.domain.BiScopeEnterpriseData;
import com.ruoyi.project.system.biScopeEnterpriseData.service.IBiScopeEnterpriseDataService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 企业数据 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-07
 */
@Service
public class BiScopeEnterpriseDataServiceImpl implements IBiScopeEnterpriseDataService {
    @Autowired
    private BiScopeEnterpriseDataMapper biScopeEnterpriseDataMapper;

    /**
     * 查询企业数据信息
     *
     * @param tid 企业数据ID
     * @return 企业数据信息
     */
    @Override
    public BiScopeEnterpriseData selectBiScopeEnterpriseDataById(Integer tid) {
        return biScopeEnterpriseDataMapper.selectBiScopeEnterpriseDataById(tid);
    }

    /**
     * 查询企业数据列表
     *
     * @param biScopeEnterpriseData 企业数据信息
     * @return 企业数据集合
     */
    @Override
    public List<BiScopeEnterpriseData> selectBiScopeEnterpriseDataList(BiScopeEnterpriseData biScopeEnterpriseData) {
        return biScopeEnterpriseDataMapper.selectBiScopeEnterpriseDataList(biScopeEnterpriseData);
    }

    /**
     * 新增企业数据
     *
     * @param biScopeEnterpriseData 企业数据信息
     * @return 结果
     */
    @Override
    public int insertBiScopeEnterpriseData(BiScopeEnterpriseData biScopeEnterpriseData) {
        return biScopeEnterpriseDataMapper.insertBiScopeEnterpriseData(biScopeEnterpriseData);
    }

    /**
     * 修改企业数据
     *
     * @param biScopeEnterpriseData 企业数据信息
     * @return 结果
     */
    @Override
    public int updateBiScopeEnterpriseData(BiScopeEnterpriseData biScopeEnterpriseData) {
        return biScopeEnterpriseDataMapper.updateBiScopeEnterpriseData(biScopeEnterpriseData);
    }

    /**
     * 删除企业数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeEnterpriseDataByIds(String ids) {
        return biScopeEnterpriseDataMapper.deleteBiScopeEnterpriseDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入企业数据对象
     * @param biScopeEnterpriseDataList
     * @return
     */

    @Override
    public String importBiScopeEnterpriseData(List<BiScopeEnterpriseData> biScopeEnterpriseDataList) {
        if (StringUtils.isNull(biScopeEnterpriseDataList) || biScopeEnterpriseDataList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeEnterpriseData biScopeEnterpriseData : biScopeEnterpriseDataList) {
            this.insertBiScopeEnterpriseData(biScopeEnterpriseData);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeEnterpriseDataReadyToDeal(Map param)
    {
        return biScopeEnterpriseDataMapper.updateBiScopeEnterpriseDataReadyToDeal(param);
    }

    public int  updateBiScopeEnterpriseDataToComplate(Map param)
    {
        return biScopeEnterpriseDataMapper.updateBiScopeEnterpriseDataToComplate(param);
    }

    public int  updateBiScopeEnterpriseDataToFailed(Map param)
    {
        return biScopeEnterpriseDataMapper.updateBiScopeEnterpriseDataToFailed(param);
    }

    public List<BiScopeEnterpriseDataVO> selectBiScopeEnterpriseDataReadToDeal(Map param)
    {
        return biScopeEnterpriseDataMapper.selectBiScopeEnterpriseDataReadToDeal(param);
    }

}
