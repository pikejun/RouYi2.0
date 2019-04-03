package com.ruoyi.project.system.biScopeAttendSpotData.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeAttendSpotData.vo.BiScopeAttendSpotDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeAttendSpotData.mapper.BiScopeAttendSpotDataMapper;
import com.ruoyi.project.system.biScopeAttendSpotData.domain.BiScopeAttendSpotData;
import com.ruoyi.common.utils.text.Convert;

/**
 * 考勤点 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-02
 */
@Service
public class BiScopeAttendSpotDataServiceImpl implements IBiScopeAttendSpotDataService {
    @Autowired
    private BiScopeAttendSpotDataMapper biScopeAttendSpotDataMapper;

    /**
     * 查询考勤点信息
     *
     * @param tid 考勤点ID
     * @return 考勤点信息
     */
    @Override
    public BiScopeAttendSpotData selectBiScopeAttendSpotDataById(Integer tid) {
        return biScopeAttendSpotDataMapper.selectBiScopeAttendSpotDataById(tid);
    }

    /**
     * 查询考勤点列表
     *
     * @param biScopeAttendSpotData 考勤点信息
     * @return 考勤点集合
     */
    @Override
    public List<BiScopeAttendSpotData> selectBiScopeAttendSpotDataList(BiScopeAttendSpotData biScopeAttendSpotData) {
        return biScopeAttendSpotDataMapper.selectBiScopeAttendSpotDataList(biScopeAttendSpotData);
    }

    /**
     * 新增考勤点
     *
     * @param biScopeAttendSpotData 考勤点信息
     * @return 结果
     */
    @Override
    public int insertBiScopeAttendSpotData(BiScopeAttendSpotData biScopeAttendSpotData) {
        return biScopeAttendSpotDataMapper.insertBiScopeAttendSpotData(biScopeAttendSpotData);
    }

    /**
     * 修改考勤点
     *
     * @param biScopeAttendSpotData 考勤点信息
     * @return 结果
     */
    @Override
    public int updateBiScopeAttendSpotData(BiScopeAttendSpotData biScopeAttendSpotData) {
        return biScopeAttendSpotDataMapper.updateBiScopeAttendSpotData(biScopeAttendSpotData);
    }

    /**
     * 删除考勤点对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeAttendSpotDataByIds(String ids) {
        return biScopeAttendSpotDataMapper.deleteBiScopeAttendSpotDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入考勤点对象
     * @param biScopeAttendSpotDataList
     * @return
     */

    @Override
    public String importBiScopeAttendSpotData(List<BiScopeAttendSpotData> biScopeAttendSpotDataList) {
        if (StringUtils.isNull(biScopeAttendSpotDataList) || biScopeAttendSpotDataList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeAttendSpotData biScopeAttendSpotData : biScopeAttendSpotDataList) {
            this.insertBiScopeAttendSpotData(biScopeAttendSpotData);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeAttendSpotDataReadyToDeal(Map param)
    {
        return biScopeAttendSpotDataMapper.updateBiScopeAttendSpotDataReadyToDeal(param);
    }

    public int  updateBiScopeAttendSpotDataToComplate(Map param)
    {
        return biScopeAttendSpotDataMapper.updateBiScopeAttendSpotDataToComplate(param);
    }

    public int  updateBiScopeAttendSpotDataToFailed(Map param)
    {
        return biScopeAttendSpotDataMapper.updateBiScopeAttendSpotDataToFailed(param);
    }

    public List<BiScopeAttendSpotDataVO> selectBiScopeAttendSpotDataReadToDeal(Map param)
    {
        return biScopeAttendSpotDataMapper.selectBiScopeAttendSpotDataReadToDeal(param);
    }
}
