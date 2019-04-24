package com.ruoyi.project.system.biScopeGroupOwner.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeGroupOwner.vo.BiScopeGroupOwnerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeGroupOwner.mapper.BiScopeGroupOwnerMapper;
import com.ruoyi.project.system.biScopeGroupOwner.domain.BiScopeGroupOwner;
import com.ruoyi.project.system.biScopeGroupOwner.service.IBiScopeGroupOwnerService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 班组长 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-23
 */
@Service
public class BiScopeGroupOwnerServiceImpl implements IBiScopeGroupOwnerService {
    @Autowired
    private BiScopeGroupOwnerMapper biScopeGroupOwnerMapper;

    /**
     * 查询班组长信息
     *
     * @param tid 班组长ID
     * @return 班组长信息
     */
    @Override
    public BiScopeGroupOwner selectBiScopeGroupOwnerById(Integer tid) {
        return biScopeGroupOwnerMapper.selectBiScopeGroupOwnerById(tid);
    }

    /**
     * 查询班组长列表
     *
     * @param biScopeGroupOwner 班组长信息
     * @return 班组长集合
     */
    @Override
    public List<BiScopeGroupOwner> selectBiScopeGroupOwnerList(BiScopeGroupOwner biScopeGroupOwner) {
        return biScopeGroupOwnerMapper.selectBiScopeGroupOwnerList(biScopeGroupOwner);
    }

    /**
     * 新增班组长
     *
     * @param biScopeGroupOwner 班组长信息
     * @return 结果
     */
    @Override
    public int insertBiScopeGroupOwner(BiScopeGroupOwner biScopeGroupOwner) {
        return biScopeGroupOwnerMapper.insertBiScopeGroupOwner(biScopeGroupOwner);
    }

    /**
     * 修改班组长
     *
     * @param biScopeGroupOwner 班组长信息
     * @return 结果
     */
    @Override
    public int updateBiScopeGroupOwner(BiScopeGroupOwner biScopeGroupOwner) {
        return biScopeGroupOwnerMapper.updateBiScopeGroupOwner(biScopeGroupOwner);
    }

    /**
     * 删除班组长对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeGroupOwnerByIds(String ids) {
        return biScopeGroupOwnerMapper.deleteBiScopeGroupOwnerByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入班组长对象
     * @param biScopeGroupOwnerList
     * @return
     */

    @Override
    public String importBiScopeGroupOwner(List<BiScopeGroupOwner> biScopeGroupOwnerList) {
        if (StringUtils.isNull(biScopeGroupOwnerList) || biScopeGroupOwnerList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeGroupOwner biScopeGroupOwner : biScopeGroupOwnerList) {
            this.insertBiScopeGroupOwner(biScopeGroupOwner);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeGroupOwnerReadyToDeal(Map param)
    {
        return biScopeGroupOwnerMapper.updateBiScopeGroupOwnerReadyToDeal(param);
    }

    public int  updateBiScopeGroupOwnerToComplate(Map param)
    {
        return biScopeGroupOwnerMapper.updateBiScopeGroupOwnerToComplate(param);
    }

    public int  updateBiScopeGroupOwnerToFailed(Map param)
    {
        return biScopeGroupOwnerMapper.updateBiScopeGroupOwnerToFailed(param);
    }

    public List<BiScopeGroupOwnerVO> selectBiScopeGroupOwnerReadToDeal(Map param)
    {
        return biScopeGroupOwnerMapper.selectBiScopeGroupOwnerReadToDeal(param);
    }

}
