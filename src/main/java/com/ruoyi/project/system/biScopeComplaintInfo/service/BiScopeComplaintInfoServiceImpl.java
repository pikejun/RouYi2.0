package com.ruoyi.project.system.biScopeComplaintInfo.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeComplaintInfo.vo.BiScopeComplaintInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeComplaintInfo.mapper.BiScopeComplaintInfoMapper;
import com.ruoyi.project.system.biScopeComplaintInfo.domain.BiScopeComplaintInfo;
import com.ruoyi.project.system.biScopeComplaintInfo.service.IBiScopeComplaintInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工人维权 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-11
 */
@Service
public class BiScopeComplaintInfoServiceImpl implements IBiScopeComplaintInfoService {
    @Autowired
    private BiScopeComplaintInfoMapper biScopeComplaintInfoMapper;

    /**
     * 查询工人维权信息
     *
     * @param tid 工人维权ID
     * @return 工人维权信息
     */
    @Override
    public BiScopeComplaintInfo selectBiScopeComplaintInfoById(Integer tid) {
        return biScopeComplaintInfoMapper.selectBiScopeComplaintInfoById(tid);
    }

    /**
     * 查询工人维权列表
     *
     * @param biScopeComplaintInfo 工人维权信息
     * @return 工人维权集合
     */
    @Override
    public List<BiScopeComplaintInfo> selectBiScopeComplaintInfoList(BiScopeComplaintInfo biScopeComplaintInfo) {
        return biScopeComplaintInfoMapper.selectBiScopeComplaintInfoList(biScopeComplaintInfo);
    }

    /**
     * 新增工人维权
     *
     * @param biScopeComplaintInfo 工人维权信息
     * @return 结果
     */
    @Override
    public int insertBiScopeComplaintInfo(BiScopeComplaintInfo biScopeComplaintInfo) {
        return biScopeComplaintInfoMapper.insertBiScopeComplaintInfo(biScopeComplaintInfo);
    }

    /**
     * 修改工人维权
     *
     * @param biScopeComplaintInfo 工人维权信息
     * @return 结果
     */
    @Override
    public int updateBiScopeComplaintInfo(BiScopeComplaintInfo biScopeComplaintInfo) {
        return biScopeComplaintInfoMapper.updateBiScopeComplaintInfo(biScopeComplaintInfo);
    }

    /**
     * 删除工人维权对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeComplaintInfoByIds(String ids) {
        return biScopeComplaintInfoMapper.deleteBiScopeComplaintInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入工人维权对象
     * @param biScopeComplaintInfoList
     * @return
     */

    @Override
    public String importBiScopeComplaintInfo(List<BiScopeComplaintInfo> biScopeComplaintInfoList) {
        if (StringUtils.isNull(biScopeComplaintInfoList) || biScopeComplaintInfoList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeComplaintInfo biScopeComplaintInfo : biScopeComplaintInfoList) {
            this.insertBiScopeComplaintInfo(biScopeComplaintInfo);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeComplaintInfoReadyToDeal(Map param)
    {
        return biScopeComplaintInfoMapper.updateBiScopeComplaintInfoReadyToDeal(param);
    }

    public int  updateBiScopeComplaintInfoToComplate(Map param)
    {
        return biScopeComplaintInfoMapper.updateBiScopeComplaintInfoToComplate(param);
    }

    public int  updateBiScopeComplaintInfoToFailed(Map param)
    {
        return biScopeComplaintInfoMapper.updateBiScopeComplaintInfoToFailed(param);
    }

    public List<BiScopeComplaintInfoVO> selectBiScopeComplaintInfoReadToDeal(Map param)
    {
        return biScopeComplaintInfoMapper.selectBiScopeComplaintInfoReadToDeal(param);
    }

}
