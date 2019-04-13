package com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.vo.BiScopeWorkerSafeEventAttachmentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.mapper.BiScopeWorkerSafeEventAttachmentsMapper;
import com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.domain.BiScopeWorkerSafeEventAttachments;
import com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.service.IBiScopeWorkerSafeEventAttachmentsService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工人安全事件附件 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class BiScopeWorkerSafeEventAttachmentsServiceImpl implements IBiScopeWorkerSafeEventAttachmentsService {
    @Autowired
    private BiScopeWorkerSafeEventAttachmentsMapper biScopeWorkerSafeEventAttachmentsMapper;

    /**
     * 查询工人安全事件附件信息
     *
     * @param tid 工人安全事件附件ID
     * @return 工人安全事件附件信息
     */
    @Override
    public BiScopeWorkerSafeEventAttachments selectBiScopeWorkerSafeEventAttachmentsById(Integer tid) {
        return biScopeWorkerSafeEventAttachmentsMapper.selectBiScopeWorkerSafeEventAttachmentsById(tid);
    }

    /**
     * 查询工人安全事件附件列表
     *
     * @param biScopeWorkerSafeEventAttachments 工人安全事件附件信息
     * @return 工人安全事件附件集合
     */
    @Override
    public List<BiScopeWorkerSafeEventAttachments> selectBiScopeWorkerSafeEventAttachmentsList(BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments) {
        return biScopeWorkerSafeEventAttachmentsMapper.selectBiScopeWorkerSafeEventAttachmentsList(biScopeWorkerSafeEventAttachments);
    }

    /**
     * 新增工人安全事件附件
     *
     * @param biScopeWorkerSafeEventAttachments 工人安全事件附件信息
     * @return 结果
     */
    @Override
    public int insertBiScopeWorkerSafeEventAttachments(BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments) {
        return biScopeWorkerSafeEventAttachmentsMapper.insertBiScopeWorkerSafeEventAttachments(biScopeWorkerSafeEventAttachments);
    }

    /**
     * 修改工人安全事件附件
     *
     * @param biScopeWorkerSafeEventAttachments 工人安全事件附件信息
     * @return 结果
     */
    @Override
    public int updateBiScopeWorkerSafeEventAttachments(BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments) {
        return biScopeWorkerSafeEventAttachmentsMapper.updateBiScopeWorkerSafeEventAttachments(biScopeWorkerSafeEventAttachments);
    }

    /**
     * 删除工人安全事件附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeWorkerSafeEventAttachmentsByIds(String ids) {
        return biScopeWorkerSafeEventAttachmentsMapper.deleteBiScopeWorkerSafeEventAttachmentsByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入工人安全事件附件对象
     * @param biScopeWorkerSafeEventAttachmentsList
     * @return
     */

    @Override
    public String importBiScopeWorkerSafeEventAttachments(List<BiScopeWorkerSafeEventAttachments> biScopeWorkerSafeEventAttachmentsList) {
        if (StringUtils.isNull(biScopeWorkerSafeEventAttachmentsList) || biScopeWorkerSafeEventAttachmentsList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments : biScopeWorkerSafeEventAttachmentsList) {
            this.insertBiScopeWorkerSafeEventAttachments(biScopeWorkerSafeEventAttachments);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeWorkerSafeEventAttachmentsReadyToDeal(Map param)
    {
        return biScopeWorkerSafeEventAttachmentsMapper.updateBiScopeWorkerSafeEventAttachmentsReadyToDeal(param);
    }

    public int  updateBiScopeWorkerSafeEventAttachmentsToComplate(Map param)
    {
        return biScopeWorkerSafeEventAttachmentsMapper.updateBiScopeWorkerSafeEventAttachmentsToComplate(param);
    }

    public int  updateBiScopeWorkerSafeEventAttachmentsToFailed(Map param)
    {
        return biScopeWorkerSafeEventAttachmentsMapper.updateBiScopeWorkerSafeEventAttachmentsToFailed(param);
    }

    public List<BiScopeWorkerSafeEventAttachmentsVO> selectBiScopeWorkerSafeEventAttachmentsReadToDeal(Map param)
    {
        return biScopeWorkerSafeEventAttachmentsMapper.selectBiScopeWorkerSafeEventAttachmentsReadToDeal(param);
    }
}
