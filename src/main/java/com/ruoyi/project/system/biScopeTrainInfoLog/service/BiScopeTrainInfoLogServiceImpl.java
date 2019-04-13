package com.ruoyi.project.system.biScopeTrainInfoLog.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeTrainInfoLog.vo.BiScopeTrainInfoLogVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeTrainInfoLog.mapper.BiScopeTrainInfoLogMapper;
import com.ruoyi.project.system.biScopeTrainInfoLog.domain.BiScopeTrainInfoLog;
import com.ruoyi.project.system.biScopeTrainInfoLog.service.IBiScopeTrainInfoLogService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工人培训日志 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class BiScopeTrainInfoLogServiceImpl implements IBiScopeTrainInfoLogService {
    @Autowired
    private BiScopeTrainInfoLogMapper biScopeTrainInfoLogMapper;

    /**
     * 查询工人培训日志信息
     *
     * @param tid 工人培训日志ID
     * @return 工人培训日志信息
     */
    @Override
    public BiScopeTrainInfoLog selectBiScopeTrainInfoLogById(Integer tid) {
        return biScopeTrainInfoLogMapper.selectBiScopeTrainInfoLogById(tid);
    }

    /**
     * 查询工人培训日志列表
     *
     * @param biScopeTrainInfoLog 工人培训日志信息
     * @return 工人培训日志集合
     */
    @Override
    public List<BiScopeTrainInfoLog> selectBiScopeTrainInfoLogList(BiScopeTrainInfoLog biScopeTrainInfoLog) {
        return biScopeTrainInfoLogMapper.selectBiScopeTrainInfoLogList(biScopeTrainInfoLog);
    }

    /**
     * 新增工人培训日志
     *
     * @param biScopeTrainInfoLog 工人培训日志信息
     * @return 结果
     */
    @Override
    public int insertBiScopeTrainInfoLog(BiScopeTrainInfoLog biScopeTrainInfoLog) {
        return biScopeTrainInfoLogMapper.insertBiScopeTrainInfoLog(biScopeTrainInfoLog);
    }

    /**
     * 修改工人培训日志
     *
     * @param biScopeTrainInfoLog 工人培训日志信息
     * @return 结果
     */
    @Override
    public int updateBiScopeTrainInfoLog(BiScopeTrainInfoLog biScopeTrainInfoLog) {
        return biScopeTrainInfoLogMapper.updateBiScopeTrainInfoLog(biScopeTrainInfoLog);
    }

    /**
     * 删除工人培训日志对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeTrainInfoLogByIds(String ids) {
        return biScopeTrainInfoLogMapper.deleteBiScopeTrainInfoLogByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入工人培训日志对象
     * @param biScopeTrainInfoLogList
     * @return
     */

    @Override
    public String importBiScopeTrainInfoLog(List<BiScopeTrainInfoLog> biScopeTrainInfoLogList) {
        if (StringUtils.isNull(biScopeTrainInfoLogList) || biScopeTrainInfoLogList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeTrainInfoLog biScopeTrainInfoLog : biScopeTrainInfoLogList) {
            this.insertBiScopeTrainInfoLog(biScopeTrainInfoLog);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeTrainInfoLogReadyToDeal(Map param)
    {
        return biScopeTrainInfoLogMapper.updateBiScopeTrainInfoLogReadyToDeal(param);
    }

    public int  updateBiScopeTrainInfoLogToComplate(Map param)
    {
        return biScopeTrainInfoLogMapper.updateBiScopeTrainInfoLogToComplate(param);
    }

    public int  updateBiScopeTrainInfoLogToFailed(Map param)
    {
        return biScopeTrainInfoLogMapper.updateBiScopeTrainInfoLogToFailed(param);
    }

    public List<BiScopeTrainInfoLogVO> selectBiScopeTrainInfoLogReadToDeal(Map param)
    {
        return biScopeTrainInfoLogMapper.selectBiScopeTrainInfoLogReadToDeal(param);
    }

}
