package com.ruoyi.project.system.biScopeInfo.service;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeInfo.mapper.BiScopeInfoMapper;
import com.ruoyi.project.system.biScopeInfo.domain.BiScopeInfo;
import com.ruoyi.common.utils.text.Convert;

/**
 * 范围 服务层实现
 *
 * @author ruoyi
 * @date 2019-03-18
 */
@Service
public class BiScopeInfoServiceImpl implements IBiScopeInfoService {
    @Autowired
    private BiScopeInfoMapper biScopeInfoMapper;

    /**
     * 查询范围信息
     *
     * @param scopeId 范围ID
     * @return 范围信息
     */
    @Override
    public BiScopeInfo selectBiScopeInfoById(Integer scopeId) {
        return biScopeInfoMapper.selectBiScopeInfoById(scopeId);
    }

    /**
     * 查询范围列表
     *
     * @param biScopeInfo 范围信息
     * @return 范围集合
     */
    @Override
    public List<BiScopeInfo> selectBiScopeInfoList(BiScopeInfo biScopeInfo) {
        return biScopeInfoMapper.selectBiScopeInfoList(biScopeInfo);
    }

    /**
     * 新增范围
     *
     * @param biScopeInfo 范围信息
     * @return 结果
     */
    @Override
    public int insertBiScopeInfo(BiScopeInfo biScopeInfo) {
        return biScopeInfoMapper.insertBiScopeInfo(biScopeInfo);
    }

    /**
     * 修改范围
     *
     * @param biScopeInfo 范围信息
     * @return 结果
     */
    @Override
    public int updateBiScopeInfo(BiScopeInfo biScopeInfo) {
        return biScopeInfoMapper.updateBiScopeInfo(biScopeInfo);
    }

    /**
     * 删除范围对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeInfoByIds(String ids) {
        return biScopeInfoMapper.deleteBiScopeInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入范围对象
     * @param biScopeInfoList
     * @return
     */

    @Override
    public String importBiScopeInfo(List<BiScopeInfo> biScopeInfoList) {
        if (StringUtils.isNull(biScopeInfoList) || biScopeInfoList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeInfo biScopeInfo : biScopeInfoList) {
            this.insertBiScopeInfo(biScopeInfo);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

}
