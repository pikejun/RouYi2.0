package com.ruoyi.project.system.biScopeTrainAttach.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeTrainAttach.vo.BiScopeTrainAttachVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeTrainAttach.mapper.BiScopeTrainAttachMapper;
import com.ruoyi.project.system.biScopeTrainAttach.domain.BiScopeTrainAttach;
import com.ruoyi.common.utils.text.Convert;

/**
 * 培训附件 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class BiScopeTrainAttachServiceImpl implements IBiScopeTrainAttachService {
    @Autowired
    private BiScopeTrainAttachMapper biScopeTrainAttachMapper;

    /**
     * 查询培训附件信息
     *
     * @param tid 培训附件ID
     * @return 培训附件信息
     */
    @Override
    public BiScopeTrainAttach selectBiScopeTrainAttachById(Integer tid) {
        return biScopeTrainAttachMapper.selectBiScopeTrainAttachById(tid);
    }

    /**
     * 查询培训附件列表
     *
     * @param biScopeTrainAttach 培训附件信息
     * @return 培训附件集合
     */
    @Override
    public List<BiScopeTrainAttach> selectBiScopeTrainAttachList(BiScopeTrainAttach biScopeTrainAttach) {
        return biScopeTrainAttachMapper.selectBiScopeTrainAttachList(biScopeTrainAttach);
    }

    /**
     * 新增培训附件
     *
     * @param biScopeTrainAttach 培训附件信息
     * @return 结果
     */
    @Override
    public int insertBiScopeTrainAttach(BiScopeTrainAttach biScopeTrainAttach) {
        return biScopeTrainAttachMapper.insertBiScopeTrainAttach(biScopeTrainAttach);
    }

    /**
     * 修改培训附件
     *
     * @param biScopeTrainAttach 培训附件信息
     * @return 结果
     */
    @Override
    public int updateBiScopeTrainAttach(BiScopeTrainAttach biScopeTrainAttach) {
        return biScopeTrainAttachMapper.updateBiScopeTrainAttach(biScopeTrainAttach);
    }

    /**
     * 删除培训附件对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeTrainAttachByIds(String ids) {
        return biScopeTrainAttachMapper.deleteBiScopeTrainAttachByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入培训附件对象
     * @param biScopeTrainAttachList
     * @return
     */

    @Override
    public String importBiScopeTrainAttach(List<BiScopeTrainAttach> biScopeTrainAttachList) {
        if (StringUtils.isNull(biScopeTrainAttachList) || biScopeTrainAttachList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeTrainAttach biScopeTrainAttach : biScopeTrainAttachList) {
            this.insertBiScopeTrainAttach(biScopeTrainAttach);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }


    public int updateBiScopeTrainAttachReadyToDeal(Map param)
    {
        return biScopeTrainAttachMapper.updateBiScopeTrainAttachReadyToDeal(param);
    }

    public int  updateBiScopeTrainAttachToComplate(Map param)
    {
        return biScopeTrainAttachMapper.updateBiScopeTrainAttachToComplate(param);
    }

    public int  updateBiScopeTrainAttachToFailed(Map param)
    {
        return biScopeTrainAttachMapper.updateBiScopeTrainAttachToFailed(param);
    }

    public List<BiScopeTrainAttachVO> selectBiScopeTrainAttachReadToDeal(Map param)
    {
        return biScopeTrainAttachMapper.selectBiScopeTrainAttachReadToDeal(param);
    }

}
