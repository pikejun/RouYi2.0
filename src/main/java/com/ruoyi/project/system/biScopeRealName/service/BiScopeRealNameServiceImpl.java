package com.ruoyi.project.system.biScopeRealName.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeRealName.vo.BiScopeRealNameVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeRealName.mapper.BiScopeRealNameMapper;
import com.ruoyi.project.system.biScopeRealName.domain.BiScopeRealName;
import com.ruoyi.project.system.biScopeRealName.service.IBiScopeRealNameService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 人员 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-11
 */
@Service
public class BiScopeRealNameServiceImpl implements IBiScopeRealNameService {
    @Autowired
    private BiScopeRealNameMapper biScopeRealNameMapper;

    /**
     * 查询人员信息
     *
     * @param tid 人员ID
     * @return 人员信息
     */
    @Override
    public BiScopeRealName selectBiScopeRealNameById(Integer tid) {
        return biScopeRealNameMapper.selectBiScopeRealNameById(tid);
    }

    /**
     * 查询人员列表
     *
     * @param biScopeRealName 人员信息
     * @return 人员集合
     */
    @Override
    public List<BiScopeRealName> selectBiScopeRealNameList(BiScopeRealName biScopeRealName) {
        return biScopeRealNameMapper.selectBiScopeRealNameList(biScopeRealName);
    }

    /**
     * 新增人员
     *
     * @param biScopeRealName 人员信息
     * @return 结果
     */
    @Override
    public int insertBiScopeRealName(BiScopeRealName biScopeRealName) {
        return biScopeRealNameMapper.insertBiScopeRealName(biScopeRealName);
    }

    /**
     * 修改人员
     *
     * @param biScopeRealName 人员信息
     * @return 结果
     */
    @Override
    public int updateBiScopeRealName(BiScopeRealName biScopeRealName) {
        return biScopeRealNameMapper.updateBiScopeRealName(biScopeRealName);
    }

    /**
     * 删除人员对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeRealNameByIds(String ids) {
        return biScopeRealNameMapper.deleteBiScopeRealNameByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入人员对象
     * @param biScopeRealNameList
     * @return
     */

    @Override
    public String importBiScopeRealName(List<BiScopeRealName> biScopeRealNameList) {
        if (StringUtils.isNull(biScopeRealNameList) || biScopeRealNameList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeRealName biScopeRealName : biScopeRealNameList) {
            this.insertBiScopeRealName(biScopeRealName);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeRealNameReadyToDeal(Map param)
    {
        return biScopeRealNameMapper.updateBiScopeRealNameReadyToDeal(param);
    }

    public int  updateBiScopeRealNameToComplate(Map param)
    {
        return biScopeRealNameMapper.updateBiScopeRealNameToComplate(param);
    }

    public int  updateBiScopeRealNameToFailed(Map param)
    {
        return biScopeRealNameMapper.updateBiScopeRealNameToFailed(param);
    }

    public List<BiScopeRealNameVO> selectBiScopeRealNameReadToDeal(Map param)
    {
        return biScopeRealNameMapper.selectBiScopeRealNameReadToDeal(param);
    }

}
