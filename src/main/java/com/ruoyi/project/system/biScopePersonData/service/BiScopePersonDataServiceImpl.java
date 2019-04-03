package com.ruoyi.project.system.biScopePersonData.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopePersonData.vo.BiScopePersonDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopePersonData.mapper.BiScopePersonDataMapper;
import com.ruoyi.project.system.biScopePersonData.domain.BiScopePersonData;
import com.ruoyi.common.utils.text.Convert;

/**
 * 人员 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-02
 */
@Service
public class BiScopePersonDataServiceImpl implements IBiScopePersonDataService {
    @Autowired
    private BiScopePersonDataMapper biScopePersonDataMapper;

    /**
     * 查询人员信息
     *
     * @param tid 人员ID
     * @return 人员信息
     */
    @Override
    public BiScopePersonData selectBiScopePersonDataById(Integer tid) {
        return biScopePersonDataMapper.selectBiScopePersonDataById(tid);
    }

    /**
     * 查询人员列表
     *
     * @param biScopePersonData 人员信息
     * @return 人员集合
     */
    @Override
    public List<BiScopePersonData> selectBiScopePersonDataList(BiScopePersonData biScopePersonData) {
        return biScopePersonDataMapper.selectBiScopePersonDataList(biScopePersonData);
    }

    /**
     * 新增人员
     *
     * @param biScopePersonData 人员信息
     * @return 结果
     */
    @Override
    public int insertBiScopePersonData(BiScopePersonData biScopePersonData) {
        return biScopePersonDataMapper.insertBiScopePersonData(biScopePersonData);
    }

    /**
     * 修改人员
     *
     * @param biScopePersonData 人员信息
     * @return 结果
     */
    @Override
    public int updateBiScopePersonData(BiScopePersonData biScopePersonData) {
        return biScopePersonDataMapper.updateBiScopePersonData(biScopePersonData);
    }

    /**
     * 删除人员对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopePersonDataByIds(String ids) {
        return biScopePersonDataMapper.deleteBiScopePersonDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入人员对象
     * @param biScopePersonDataList
     * @return
     */

    @Override
    public String importBiScopePersonData(List<BiScopePersonData> biScopePersonDataList) {
        if (StringUtils.isNull(biScopePersonDataList) || biScopePersonDataList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopePersonData biScopePersonData : biScopePersonDataList) {
            this.insertBiScopePersonData(biScopePersonData);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }
    
    
    public int updateBiScopePersonDataReadyToDeal(Map param)
    {
        return biScopePersonDataMapper.updateBiScopePersonDataReadyToDeal(param);
    }

    public int  updateBiScopePersonDataToComplate(Map param)
    {
        return biScopePersonDataMapper.updateBiScopePersonDataToComplate(param);
    }

    public int  updateBiScopePersonDataToFailed(Map param)
    {
        return biScopePersonDataMapper.updateBiScopePersonDataToFailed(param);
    }

    public List<BiScopePersonDataVO> selectBiScopePersonDataReadToDeal(Map param)
    {
        return biScopePersonDataMapper.selectBiScopePersonDataReadToDeal(param);
    }

}
