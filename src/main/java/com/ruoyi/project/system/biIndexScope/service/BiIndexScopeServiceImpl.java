package com.ruoyi.project.system.biIndexScope.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biIndexScope.mapper.BiIndexScopeMapper;
import com.ruoyi.project.system.biIndexScope.domain.BiIndexScope;
import com.ruoyi.project.system.biIndexScope.service.IBiIndexScopeService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 指标范围 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-17
 */
@Service
public class BiIndexScopeServiceImpl implements IBiIndexScopeService {
    @Autowired
    private BiIndexScopeMapper biIndexScopeMapper;

    /**
     * 查询指标范围信息
     *
     * @param isId 指标范围ID
     * @return 指标范围信息
     */
    @Override
    public BiIndexScope selectBiIndexScopeById(Integer isId) {
        return biIndexScopeMapper.selectBiIndexScopeById(isId);
    }

    /**
     * 查询指标范围列表
     *
     * @param biIndexScope 指标范围信息
     * @return 指标范围集合
     */
    @Override
    public List<BiIndexScope> selectBiIndexScopeList(BiIndexScope biIndexScope) {
        return biIndexScopeMapper.selectBiIndexScopeList(biIndexScope);
    }

    public List<Map> getScopeAndAliasNameList(BiIndexScope biIndexScope)
    {
        return biIndexScopeMapper.getScopeAndAliasNameList(biIndexScope);
    }

    /**
     * 新增指标范围
     *
     * @param biIndexScope 指标范围信息
     * @return 结果
     */
    @Override
    public int insertBiIndexScope(BiIndexScope biIndexScope) {
        return biIndexScopeMapper.insertBiIndexScope(biIndexScope);
    }

    /**
     * 修改指标范围
     *
     * @param biIndexScope 指标范围信息
     * @return 结果
     */
    @Override
    public int updateBiIndexScope(BiIndexScope biIndexScope) {
        return biIndexScopeMapper.updateBiIndexScope(biIndexScope);
    }

    /**
     * 删除指标范围对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiIndexScopeByIds(String ids) {
        return biIndexScopeMapper.deleteBiIndexScopeByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入指标范围对象
     * @param biIndexScopeList
     * @return
     */

    @Override
    public String importBiIndexScope(List<BiIndexScope> biIndexScopeList) {
        if (StringUtils.isNull(biIndexScopeList) || biIndexScopeList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiIndexScope biIndexScope : biIndexScopeList) {
            this.insertBiIndexScope(biIndexScope);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

}
