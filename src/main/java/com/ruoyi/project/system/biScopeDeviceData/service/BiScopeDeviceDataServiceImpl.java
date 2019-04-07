package com.ruoyi.project.system.biScopeDeviceData.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeDeviceData.vo.BiScopeDeviceDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeDeviceData.mapper.BiScopeDeviceDataMapper;
import com.ruoyi.project.system.biScopeDeviceData.domain.BiScopeDeviceData;
import com.ruoyi.common.utils.text.Convert;

/**
 * 设备数据 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-07
 */
@Service
public class BiScopeDeviceDataServiceImpl implements IBiScopeDeviceDataService {
    @Autowired
    private BiScopeDeviceDataMapper biScopeDeviceDataMapper;

    /**
     * 查询设备数据信息
     *
     * @param tid 设备数据ID
     * @return 设备数据信息
     */
    @Override
    public BiScopeDeviceData selectBiScopeDeviceDataById(Integer tid) {
        return biScopeDeviceDataMapper.selectBiScopeDeviceDataById(tid);
    }

    /**
     * 查询设备数据列表
     *
     * @param biScopeDeviceData 设备数据信息
     * @return 设备数据集合
     */
    @Override
    public List<BiScopeDeviceData> selectBiScopeDeviceDataList(BiScopeDeviceData biScopeDeviceData) {
        return biScopeDeviceDataMapper.selectBiScopeDeviceDataList(biScopeDeviceData);
    }

    /**
     * 新增设备数据
     *
     * @param biScopeDeviceData 设备数据信息
     * @return 结果
     */
    @Override
    public int insertBiScopeDeviceData(BiScopeDeviceData biScopeDeviceData) {
        return biScopeDeviceDataMapper.insertBiScopeDeviceData(biScopeDeviceData);
    }

    /**
     * 修改设备数据
     *
     * @param biScopeDeviceData 设备数据信息
     * @return 结果
     */
    @Override
    public int updateBiScopeDeviceData(BiScopeDeviceData biScopeDeviceData) {
        return biScopeDeviceDataMapper.updateBiScopeDeviceData(biScopeDeviceData);
    }

    /**
     * 删除设备数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeDeviceDataByIds(String ids) {
        return biScopeDeviceDataMapper.deleteBiScopeDeviceDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入设备数据对象
     * @param biScopeDeviceDataList
     * @return
     */

    @Override
    public String importBiScopeDeviceData(List<BiScopeDeviceData> biScopeDeviceDataList) {
        if (StringUtils.isNull(biScopeDeviceDataList) || biScopeDeviceDataList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeDeviceData biScopeDeviceData : biScopeDeviceDataList) {
            this.insertBiScopeDeviceData(biScopeDeviceData);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeDeviceDataReadyToDeal(Map param)
    {
        return biScopeDeviceDataMapper.updateBiScopeDeviceDataReadyToDeal(param);
    }

    public int  updateBiScopeDeviceDataToComplate(Map param)
    {
        return biScopeDeviceDataMapper.updateBiScopeDeviceDataToComplate(param);
    }

    public int  updateBiScopeDeviceDataToFailed(Map param)
    {
        return biScopeDeviceDataMapper.updateBiScopeDeviceDataToFailed(param);
    }

    public List<BiScopeDeviceDataVO> selectBiScopeDeviceDataReadToDeal(Map param)
    {
        return biScopeDeviceDataMapper.selectBiScopeDeviceDataReadToDeal(param);
    }

}
