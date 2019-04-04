package com.ruoyi.project.system.biScopeSafeEvent.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeSafeEvent.vo.BiScopeSafeEventVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeSafeEvent.mapper.BiScopeSafeEventMapper;
import com.ruoyi.project.system.biScopeSafeEvent.domain.BiScopeSafeEvent;
import com.ruoyi.project.system.biScopeSafeEvent.service.IBiScopeSafeEventService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 安全事件 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-04
 */
@Service
public class BiScopeSafeEventServiceImpl implements IBiScopeSafeEventService {
    @Autowired
    private BiScopeSafeEventMapper biScopeSafeEventMapper;

    /**
     * 查询安全事件信息
     *
     * @param tid 安全事件ID
     * @return 安全事件信息
     */
    @Override
    public BiScopeSafeEvent selectBiScopeSafeEventById(Integer tid) {
        return biScopeSafeEventMapper.selectBiScopeSafeEventById(tid);
    }

    /**
     * 查询安全事件列表
     *
     * @param biScopeSafeEvent 安全事件信息
     * @return 安全事件集合
     */
    @Override
    public List<BiScopeSafeEvent> selectBiScopeSafeEventList(BiScopeSafeEvent biScopeSafeEvent) {
        return biScopeSafeEventMapper.selectBiScopeSafeEventList(biScopeSafeEvent);
    }

    /**
     * 新增安全事件
     *
     * @param biScopeSafeEvent 安全事件信息
     * @return 结果
     */
    @Override
    public int insertBiScopeSafeEvent(BiScopeSafeEvent biScopeSafeEvent) {
        return biScopeSafeEventMapper.insertBiScopeSafeEvent(biScopeSafeEvent);
    }

    /**
     * 修改安全事件
     *
     * @param biScopeSafeEvent 安全事件信息
     * @return 结果
     */
    @Override
    public int updateBiScopeSafeEvent(BiScopeSafeEvent biScopeSafeEvent) {
        return biScopeSafeEventMapper.updateBiScopeSafeEvent(biScopeSafeEvent);
    }

    /**
     * 删除安全事件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeSafeEventByIds(String ids) {
        return biScopeSafeEventMapper.deleteBiScopeSafeEventByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入安全事件对象
     * @param biScopeSafeEventList
     * @return
     */

    @Override
    public String importBiScopeSafeEvent(List<BiScopeSafeEvent> biScopeSafeEventList) {
        if (StringUtils.isNull(biScopeSafeEventList) || biScopeSafeEventList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeSafeEvent biScopeSafeEvent : biScopeSafeEventList) {
            this.insertBiScopeSafeEvent(biScopeSafeEvent);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeSafeEventReadyToDeal(Map param)
    {
        return biScopeSafeEventMapper.updateBiScopeSafeEventReadyToDeal(param);
    }

    public int  updateBiScopeSafeEventToComplate(Map param)
    {
        return biScopeSafeEventMapper.updateBiScopeSafeEventToComplate(param);
    }

    public int  updateBiScopeSafeEventToFailed(Map param)
    {
        return biScopeSafeEventMapper.updateBiScopeSafeEventToFailed(param);
    }

    public List<BiScopeSafeEventVO> selectBiScopeSafeEventReadToDeal(Map param)
    {
        return biScopeSafeEventMapper.selectBiScopeSafeEventReadToDeal(param);
    }

}
