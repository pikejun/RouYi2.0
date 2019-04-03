package com.ruoyi.project.system.biScopeAttendInfo.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeAttendInfo.vo.BiScopeAttendInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeAttendInfo.mapper.BiScopeAttendInfoMapper;
import com.ruoyi.project.system.biScopeAttendInfo.domain.BiScopeAttendInfo;
import com.ruoyi.common.utils.text.Convert;

/**
 * 考勤 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-02
 */
@Service
public class BiScopeAttendInfoServiceImpl implements IBiScopeAttendInfoService {
    @Autowired
    private BiScopeAttendInfoMapper biScopeAttendInfoMapper;

    /**
     * 查询考勤信息
     *
     * @param tid 考勤ID
     * @return 考勤信息
     */
    @Override
    public BiScopeAttendInfo selectBiScopeAttendInfoById(Integer tid) {
        return biScopeAttendInfoMapper.selectBiScopeAttendInfoById(tid);
    }

    /**
     * 查询考勤列表
     *
     * @param biScopeAttendInfo 考勤信息
     * @return 考勤集合
     */
    @Override
    public List<BiScopeAttendInfo> selectBiScopeAttendInfoList(BiScopeAttendInfo biScopeAttendInfo) {
        return biScopeAttendInfoMapper.selectBiScopeAttendInfoList(biScopeAttendInfo);
    }

    /**
     * 新增考勤
     *
     * @param biScopeAttendInfo 考勤信息
     * @return 结果
     */
    @Override
    public int insertBiScopeAttendInfo(BiScopeAttendInfo biScopeAttendInfo) {
        return biScopeAttendInfoMapper.insertBiScopeAttendInfo(biScopeAttendInfo);
    }

    /**
     * 修改考勤
     *
     * @param biScopeAttendInfo 考勤信息
     * @return 结果
     */
    @Override
    public int updateBiScopeAttendInfo(BiScopeAttendInfo biScopeAttendInfo) {
        return biScopeAttendInfoMapper.updateBiScopeAttendInfo(biScopeAttendInfo);
    }

    /**
     * 删除考勤对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeAttendInfoByIds(String ids) {
        return biScopeAttendInfoMapper.deleteBiScopeAttendInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入考勤对象
     * @param biScopeAttendInfoList
     * @return
     */

    @Override
    public String importBiScopeAttendInfo(List<BiScopeAttendInfo> biScopeAttendInfoList) {
        if (StringUtils.isNull(biScopeAttendInfoList) || biScopeAttendInfoList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeAttendInfo biScopeAttendInfo : biScopeAttendInfoList) {
            this.insertBiScopeAttendInfo(biScopeAttendInfo);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeAttendInfoReadyToDeal(Map param)
    {
        return biScopeAttendInfoMapper.updateBiScopeAttendInfoReadyToDeal(param);
    }

    public int  updateBiScopeAttendInfoToComplate(Map param)
    {
        return biScopeAttendInfoMapper.updateBiScopeAttendInfoToComplate(param);
    }

    public int  updateBiScopeAttendInfoToFailed(Map param)
    {
        return biScopeAttendInfoMapper.updateBiScopeAttendInfoToFailed(param);
    }

    public List<BiScopeAttendInfoVO> selectBiScopeAttendInfoReadToDeal(Map param)
    {
        return biScopeAttendInfoMapper.selectBiScopeAttendInfoReadToDeal(param);
    }

}
