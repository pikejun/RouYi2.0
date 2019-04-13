package com.ruoyi.project.system.biScopeWorkerSafeEvent.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeWorkerSafeEvent.vo.BiScopeWorkerSafeEventVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeWorkerSafeEvent.mapper.BiScopeWorkerSafeEventMapper;
import com.ruoyi.project.system.biScopeWorkerSafeEvent.domain.BiScopeWorkerSafeEvent;
import com.ruoyi.project.system.biScopeWorkerSafeEvent.service.IBiScopeWorkerSafeEventService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工人安全事件 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class BiScopeWorkerSafeEventServiceImpl implements IBiScopeWorkerSafeEventService {
    @Autowired
    private BiScopeWorkerSafeEventMapper biScopeWorkerSafeEventMapper;

    /**
     * 查询工人安全事件信息
     *
     * @param tid 工人安全事件ID
     * @return 工人安全事件信息
     */
    @Override
    public BiScopeWorkerSafeEvent selectBiScopeWorkerSafeEventById(Integer tid) {
        return biScopeWorkerSafeEventMapper.selectBiScopeWorkerSafeEventById(tid);
    }

    /**
     * 查询工人安全事件列表
     *
     * @param biScopeWorkerSafeEvent 工人安全事件信息
     * @return 工人安全事件集合
     */
    @Override
    public List<BiScopeWorkerSafeEvent> selectBiScopeWorkerSafeEventList(BiScopeWorkerSafeEvent biScopeWorkerSafeEvent) {
        return biScopeWorkerSafeEventMapper.selectBiScopeWorkerSafeEventList(biScopeWorkerSafeEvent);
    }

    /**
     * 新增工人安全事件
     *
     * @param biScopeWorkerSafeEvent 工人安全事件信息
     * @return 结果
     */
    @Override
    public int insertBiScopeWorkerSafeEvent(BiScopeWorkerSafeEvent biScopeWorkerSafeEvent) {
        return biScopeWorkerSafeEventMapper.insertBiScopeWorkerSafeEvent(biScopeWorkerSafeEvent);
    }

    /**
     * 修改工人安全事件
     *
     * @param biScopeWorkerSafeEvent 工人安全事件信息
     * @return 结果
     */
    @Override
    public int updateBiScopeWorkerSafeEvent(BiScopeWorkerSafeEvent biScopeWorkerSafeEvent) {
        return biScopeWorkerSafeEventMapper.updateBiScopeWorkerSafeEvent(biScopeWorkerSafeEvent);
    }

    /**
     * 删除工人安全事件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeWorkerSafeEventByIds(String ids) {
        return biScopeWorkerSafeEventMapper.deleteBiScopeWorkerSafeEventByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入工人安全事件对象
     * @param biScopeWorkerSafeEventList
     * @return
     */

    @Override
    public String importBiScopeWorkerSafeEvent(List<BiScopeWorkerSafeEvent> biScopeWorkerSafeEventList) {
        if (StringUtils.isNull(biScopeWorkerSafeEventList) || biScopeWorkerSafeEventList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeWorkerSafeEvent biScopeWorkerSafeEvent : biScopeWorkerSafeEventList) {
            this.insertBiScopeWorkerSafeEvent(biScopeWorkerSafeEvent);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeWorkerSafeEventReadyToDeal(Map param)
    {
        return biScopeWorkerSafeEventMapper.updateBiScopeWorkerSafeEventReadyToDeal(param);
    }

    public int  updateBiScopeWorkerSafeEventToComplate(Map param)
    {
        return biScopeWorkerSafeEventMapper.updateBiScopeWorkerSafeEventToComplate(param);
    }

    public int  updateBiScopeWorkerSafeEventToFailed(Map param)
    {
        return biScopeWorkerSafeEventMapper.updateBiScopeWorkerSafeEventToFailed(param);
    }

    public List<BiScopeWorkerSafeEventVO> selectBiScopeWorkerSafeEventReadToDeal(Map param)
    {
        return biScopeWorkerSafeEventMapper.selectBiScopeWorkerSafeEventReadToDeal(param);
    }
}
