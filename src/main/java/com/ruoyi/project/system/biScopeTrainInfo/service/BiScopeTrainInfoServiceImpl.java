package com.ruoyi.project.system.biScopeTrainInfo.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeTrainInfo.vo.BiScopeTrainInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeTrainInfo.mapper.BiScopeTrainInfoMapper;
import com.ruoyi.project.system.biScopeTrainInfo.domain.BiScopeTrainInfo;
import com.ruoyi.project.system.biScopeTrainInfo.service.IBiScopeTrainInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 培训 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-03
 */
@Service
public class BiScopeTrainInfoServiceImpl implements IBiScopeTrainInfoService {
    @Autowired
    private BiScopeTrainInfoMapper biScopeTrainInfoMapper;

    /**
     * 查询培训信息
     *
     * @param tid 培训ID
     * @return 培训信息
     */
    @Override
    public BiScopeTrainInfo selectBiScopeTrainInfoById(Integer tid) {
        return biScopeTrainInfoMapper.selectBiScopeTrainInfoById(tid);
    }

    /**
     * 查询培训列表
     *
     * @param biScopeTrainInfo 培训信息
     * @return 培训集合
     */
    @Override
    public List<BiScopeTrainInfo> selectBiScopeTrainInfoList(BiScopeTrainInfo biScopeTrainInfo) {
        return biScopeTrainInfoMapper.selectBiScopeTrainInfoList(biScopeTrainInfo);
    }

    /**
     * 新增培训
     *
     * @param biScopeTrainInfo 培训信息
     * @return 结果
     */
    @Override
    public int insertBiScopeTrainInfo(BiScopeTrainInfo biScopeTrainInfo) {
        return biScopeTrainInfoMapper.insertBiScopeTrainInfo(biScopeTrainInfo);
    }

    /**
     * 修改培训
     *
     * @param biScopeTrainInfo 培训信息
     * @return 结果
     */
    @Override
    public int updateBiScopeTrainInfo(BiScopeTrainInfo biScopeTrainInfo) {
        return biScopeTrainInfoMapper.updateBiScopeTrainInfo(biScopeTrainInfo);
    }

    /**
     * 删除培训对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeTrainInfoByIds(String ids) {
        return biScopeTrainInfoMapper.deleteBiScopeTrainInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入培训对象
     * @param biScopeTrainInfoList
     * @return
     */

    @Override
    public String importBiScopeTrainInfo(List<BiScopeTrainInfo> biScopeTrainInfoList) {
        if (StringUtils.isNull(biScopeTrainInfoList) || biScopeTrainInfoList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeTrainInfo biScopeTrainInfo : biScopeTrainInfoList) {
            this.insertBiScopeTrainInfo(biScopeTrainInfo);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeTrainInfoReadyToDeal(Map param)
    {
        return biScopeTrainInfoMapper.updateBiScopeTrainInfoReadyToDeal(param);
    }

    public int  updateBiScopeTrainInfoToComplate(Map param)
    {
        return biScopeTrainInfoMapper.updateBiScopeTrainInfoToComplate(param);
    }

    public int  updateBiScopeTrainInfoToFailed(Map param)
    {
        return biScopeTrainInfoMapper.updateBiScopeTrainInfoToFailed(param);
    }

    public List<BiScopeTrainInfoVO> selectBiScopeTrainInfoReadToDeal(Map param)
    {
        return biScopeTrainInfoMapper.selectBiScopeTrainInfoReadToDeal(param);
    }

}
