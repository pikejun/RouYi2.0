package com.ruoyi.project.system.biScopeRootProjectData.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeRootProjectData.vo.BiScopeRootProjectDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeRootProjectData.mapper.BiScopeRootProjectDataMapper;
import com.ruoyi.project.system.biScopeRootProjectData.domain.BiScopeRootProjectData;
import com.ruoyi.common.utils.text.Convert;

/**
 * 总工程 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-09
 */
@Service
public class BiScopeRootProjectDataServiceImpl implements IBiScopeRootProjectDataService {
    @Autowired
    private BiScopeRootProjectDataMapper biScopeRootProjectDataMapper;

    /**
     * 查询总工程信息
     *
     * @param tid 总工程ID
     * @return 总工程信息
     */
    @Override
    public BiScopeRootProjectData selectBiScopeRootProjectDataById(Integer tid) {
        return biScopeRootProjectDataMapper.selectBiScopeRootProjectDataById(tid);
    }

    /**
     * 查询总工程列表
     *
     * @param biScopeRootProjectData 总工程信息
     * @return 总工程集合
     */
    @Override
    public List<BiScopeRootProjectData> selectBiScopeRootProjectDataList(BiScopeRootProjectData biScopeRootProjectData) {
        return biScopeRootProjectDataMapper.selectBiScopeRootProjectDataList(biScopeRootProjectData);
    }

    /**
     * 新增总工程
     *
     * @param biScopeRootProjectData 总工程信息
     * @return 结果
     */
    @Override
    public int insertBiScopeRootProjectData(BiScopeRootProjectData biScopeRootProjectData) {
        return biScopeRootProjectDataMapper.insertBiScopeRootProjectData(biScopeRootProjectData);
    }

    /**
     * 修改总工程
     *
     * @param biScopeRootProjectData 总工程信息
     * @return 结果
     */
    @Override
    public int updateBiScopeRootProjectData(BiScopeRootProjectData biScopeRootProjectData) {
        return biScopeRootProjectDataMapper.updateBiScopeRootProjectData(biScopeRootProjectData);
    }

    /**
     * 删除总工程对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeRootProjectDataByIds(String ids) {
        return biScopeRootProjectDataMapper.deleteBiScopeRootProjectDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入总工程对象
     * @param biScopeRootProjectDataList
     * @return
     */

    @Override
    public String importBiScopeRootProjectData(List<BiScopeRootProjectData> biScopeRootProjectDataList) {
        if (StringUtils.isNull(biScopeRootProjectDataList) || biScopeRootProjectDataList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeRootProjectData biScopeRootProjectData : biScopeRootProjectDataList) {
            this.insertBiScopeRootProjectData(biScopeRootProjectData);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeRootProjectDataReadyToDeal(Map param)
    {
        return biScopeRootProjectDataMapper.updateBiScopeRootProjectDataReadyToDeal(param);
    }

    public int  updateBiScopeRootProjectDataToComplate(Map param)
    {
        return biScopeRootProjectDataMapper.updateBiScopeRootProjectDataToComplate(param);
    }

    public int  updateBiScopeRootProjectDataToFailed(Map param)
    {
        return biScopeRootProjectDataMapper.updateBiScopeRootProjectDataToFailed(param);
    }

    public List<BiScopeRootProjectDataVO> selectBiScopeRootProjectDataReadToDeal(Map param)
    {
        return biScopeRootProjectDataMapper.selectBiScopeRootProjectDataReadToDeal(param);
    }

}
