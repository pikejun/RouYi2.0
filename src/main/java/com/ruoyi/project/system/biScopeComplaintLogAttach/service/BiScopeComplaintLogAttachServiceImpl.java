package com.ruoyi.project.system.biScopeComplaintLogAttach.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeComplaintLogAttach.vo.BiScopeComplaintLogAttachVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeComplaintLogAttach.mapper.BiScopeComplaintLogAttachMapper;
import com.ruoyi.project.system.biScopeComplaintLogAttach.domain.BiScopeComplaintLogAttach;
import com.ruoyi.project.system.biScopeComplaintLogAttach.service.IBiScopeComplaintLogAttachService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 维权日志附件 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class BiScopeComplaintLogAttachServiceImpl implements IBiScopeComplaintLogAttachService {
    @Autowired
    private BiScopeComplaintLogAttachMapper biScopeComplaintLogAttachMapper;

    /**
     * 查询维权日志附件信息
     *
     * @param tid 维权日志附件ID
     * @return 维权日志附件信息
     */
    @Override
    public BiScopeComplaintLogAttach selectBiScopeComplaintLogAttachById(Integer tid) {
        return biScopeComplaintLogAttachMapper.selectBiScopeComplaintLogAttachById(tid);
    }

    /**
     * 查询维权日志附件列表
     *
     * @param biScopeComplaintLogAttach 维权日志附件信息
     * @return 维权日志附件集合
     */
    @Override
    public List<BiScopeComplaintLogAttach> selectBiScopeComplaintLogAttachList(BiScopeComplaintLogAttach biScopeComplaintLogAttach) {
        return biScopeComplaintLogAttachMapper.selectBiScopeComplaintLogAttachList(biScopeComplaintLogAttach);
    }

    /**
     * 新增维权日志附件
     *
     * @param biScopeComplaintLogAttach 维权日志附件信息
     * @return 结果
     */
    @Override
    public int insertBiScopeComplaintLogAttach(BiScopeComplaintLogAttach biScopeComplaintLogAttach) {
        return biScopeComplaintLogAttachMapper.insertBiScopeComplaintLogAttach(biScopeComplaintLogAttach);
    }

    /**
     * 修改维权日志附件
     *
     * @param biScopeComplaintLogAttach 维权日志附件信息
     * @return 结果
     */
    @Override
    public int updateBiScopeComplaintLogAttach(BiScopeComplaintLogAttach biScopeComplaintLogAttach) {
        return biScopeComplaintLogAttachMapper.updateBiScopeComplaintLogAttach(biScopeComplaintLogAttach);
    }

    /**
     * 删除维权日志附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeComplaintLogAttachByIds(String ids) {
        return biScopeComplaintLogAttachMapper.deleteBiScopeComplaintLogAttachByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入维权日志附件对象
     * @param biScopeComplaintLogAttachList
     * @return
     */

    @Override
    public String importBiScopeComplaintLogAttach(List<BiScopeComplaintLogAttach> biScopeComplaintLogAttachList) {
        if (StringUtils.isNull(biScopeComplaintLogAttachList) || biScopeComplaintLogAttachList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeComplaintLogAttach biScopeComplaintLogAttach : biScopeComplaintLogAttachList) {
            this.insertBiScopeComplaintLogAttach(biScopeComplaintLogAttach);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeComplaintLogAttachReadyToDeal(Map param)
    {
        return biScopeComplaintLogAttachMapper.updateBiScopeComplaintLogAttachReadyToDeal(param);
    }

    public int  updateBiScopeComplaintLogAttachToComplate(Map param)
    {
        return biScopeComplaintLogAttachMapper.updateBiScopeComplaintLogAttachToComplate(param);
    }

    public int  updateBiScopeComplaintLogAttachToFailed(Map param)
    {
        return biScopeComplaintLogAttachMapper.updateBiScopeComplaintLogAttachToFailed(param);
    }

    public List<BiScopeComplaintLogAttachVO> selectBiScopeComplaintLogAttachReadToDeal(Map param)
    {
        return biScopeComplaintLogAttachMapper.selectBiScopeComplaintLogAttachReadToDeal(param);
    }

}
