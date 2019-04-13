package com.ruoyi.project.system.biScopeComplaintLog.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeComplaintLog.vo.BiScopeComplaintLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeComplaintLog.mapper.BiScopeComplaintLogMapper;
import com.ruoyi.project.system.biScopeComplaintLog.domain.BiScopeComplaintLog;
import com.ruoyi.project.system.biScopeComplaintLog.service.IBiScopeComplaintLogService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 维权日志 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class BiScopeComplaintLogServiceImpl implements IBiScopeComplaintLogService {
    @Autowired
    private BiScopeComplaintLogMapper biScopeComplaintLogMapper;

    /**
     * 查询维权日志信息
     *
     * @param tid 维权日志ID
     * @return 维权日志信息
     */
    @Override
    public BiScopeComplaintLog selectBiScopeComplaintLogById(Integer tid) {
        return biScopeComplaintLogMapper.selectBiScopeComplaintLogById(tid);
    }

    /**
     * 查询维权日志列表
     *
     * @param biScopeComplaintLog 维权日志信息
     * @return 维权日志集合
     */
    @Override
    public List<BiScopeComplaintLog> selectBiScopeComplaintLogList(BiScopeComplaintLog biScopeComplaintLog) {
        return biScopeComplaintLogMapper.selectBiScopeComplaintLogList(biScopeComplaintLog);
    }

    /**
     * 新增维权日志
     *
     * @param biScopeComplaintLog 维权日志信息
     * @return 结果
     */
    @Override
    public int insertBiScopeComplaintLog(BiScopeComplaintLog biScopeComplaintLog) {
        return biScopeComplaintLogMapper.insertBiScopeComplaintLog(biScopeComplaintLog);
    }

    /**
     * 修改维权日志
     *
     * @param biScopeComplaintLog 维权日志信息
     * @return 结果
     */
    @Override
    public int updateBiScopeComplaintLog(BiScopeComplaintLog biScopeComplaintLog) {
        return biScopeComplaintLogMapper.updateBiScopeComplaintLog(biScopeComplaintLog);
    }

    /**
     * 删除维权日志对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeComplaintLogByIds(String ids) {
        return biScopeComplaintLogMapper.deleteBiScopeComplaintLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入维权日志对象
     * @param biScopeComplaintLogList
     * @return
     */

    @Override
    public String importBiScopeComplaintLog(List<BiScopeComplaintLog> biScopeComplaintLogList) {
        if (StringUtils.isNull(biScopeComplaintLogList) || biScopeComplaintLogList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeComplaintLog biScopeComplaintLog : biScopeComplaintLogList) {
            this.insertBiScopeComplaintLog(biScopeComplaintLog);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }


    public int updateBiScopeComplaintLogReadyToDeal(Map param)
    {
        return biScopeComplaintLogMapper.updateBiScopeComplaintLogReadyToDeal(param);
    }

    public int  updateBiScopeComplaintLogToComplate(Map param)
    {
        return biScopeComplaintLogMapper.updateBiScopeComplaintLogToComplate(param);
    }

    public int  updateBiScopeComplaintLogToFailed(Map param)
    {
        return biScopeComplaintLogMapper.updateBiScopeComplaintLogToFailed(param);
    }

    public List<BiScopeComplaintLogVO> selectBiScopeComplaintLogReadToDeal(Map param)
    {
        return biScopeComplaintLogMapper.selectBiScopeComplaintLogReadToDeal(param);
    }

}
