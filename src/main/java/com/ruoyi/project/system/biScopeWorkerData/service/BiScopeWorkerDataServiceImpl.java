package com.ruoyi.project.system.biScopeWorkerData.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeWorkerData.vo.BiScopeWorkerDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeWorkerData.mapper.BiScopeWorkerDataMapper;
import com.ruoyi.project.system.biScopeWorkerData.domain.BiScopeWorkerData;
import com.ruoyi.project.system.biScopeWorkerData.service.IBiScopeWorkerDataService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工人数据 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-07
 */
@Service
public class BiScopeWorkerDataServiceImpl implements IBiScopeWorkerDataService {
    @Autowired
    private BiScopeWorkerDataMapper biScopeWorkerDataMapper;

    /**
     * 查询工人数据信息
     *
     * @param tid 工人数据ID
     * @return 工人数据信息
     */
    @Override
    public BiScopeWorkerData selectBiScopeWorkerDataById(Integer tid) {
        return biScopeWorkerDataMapper.selectBiScopeWorkerDataById(tid);
    }

    /**
     * 查询工人数据列表
     *
     * @param biScopeWorkerData 工人数据信息
     * @return 工人数据集合
     */
    @Override
    public List<BiScopeWorkerData> selectBiScopeWorkerDataList(BiScopeWorkerData biScopeWorkerData) {
        return biScopeWorkerDataMapper.selectBiScopeWorkerDataList(biScopeWorkerData);
    }

    /**
     * 新增工人数据
     *
     * @param biScopeWorkerData 工人数据信息
     * @return 结果
     */
    @Override
    public int insertBiScopeWorkerData(BiScopeWorkerData biScopeWorkerData) {
        return biScopeWorkerDataMapper.insertBiScopeWorkerData(biScopeWorkerData);
    }

    /**
     * 修改工人数据
     *
     * @param biScopeWorkerData 工人数据信息
     * @return 结果
     */
    @Override
    public int updateBiScopeWorkerData(BiScopeWorkerData biScopeWorkerData) {
        return biScopeWorkerDataMapper.updateBiScopeWorkerData(biScopeWorkerData);
    }

    /**
     * 删除工人数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeWorkerDataByIds(String ids) {
        return biScopeWorkerDataMapper.deleteBiScopeWorkerDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入工人数据对象
     * @param biScopeWorkerDataList
     * @return
     */

    @Override
    public String importBiScopeWorkerData(List<BiScopeWorkerData> biScopeWorkerDataList) {
        if (StringUtils.isNull(biScopeWorkerDataList) || biScopeWorkerDataList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeWorkerData biScopeWorkerData : biScopeWorkerDataList) {
            this.insertBiScopeWorkerData(biScopeWorkerData);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }


    public int updateBiScopeWorkerDataReadyToDeal(Map param)
    {
        return biScopeWorkerDataMapper.updateBiScopeWorkerDataReadyToDeal(param);
    }


    public int  updateBiScopeWorkerDataToComplate(Map param)
    {
        return biScopeWorkerDataMapper.updateBiScopeWorkerDataToComplate(param);
    }

    public int  updateBiScopeWorkerDataToFailed(Map param)
    {
        return biScopeWorkerDataMapper.updateBiScopeWorkerDataToFailed(param);
    }

    public List<BiScopeWorkerDataVO> selectBiScopeWorkerDataReadToDeal(Map param)
    {
        return biScopeWorkerDataMapper.selectBiScopeWorkerDataReadToDeal(param);
    }

}
