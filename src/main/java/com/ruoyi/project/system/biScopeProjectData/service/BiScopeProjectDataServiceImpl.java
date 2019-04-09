package com.ruoyi.project.system.biScopeProjectData.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeProjectData.vo.BiScopeProjectDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeProjectData.mapper.BiScopeProjectDataMapper;
import com.ruoyi.project.system.biScopeProjectData.domain.BiScopeProjectData;
import com.ruoyi.project.system.biScopeProjectData.service.IBiScopeProjectDataService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 项目数据 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-09
 */
@Service
public class BiScopeProjectDataServiceImpl implements IBiScopeProjectDataService {
    @Autowired
    private BiScopeProjectDataMapper biScopeProjectDataMapper;

    /**
     * 查询项目数据信息
     *
     * @param tid 项目数据ID
     * @return 项目数据信息
     */
    @Override
    public BiScopeProjectData selectBiScopeProjectDataById(Integer tid) {
        return biScopeProjectDataMapper.selectBiScopeProjectDataById(tid);
    }

    /**
     * 查询项目数据列表
     *
     * @param biScopeProjectData 项目数据信息
     * @return 项目数据集合
     */
    @Override
    public List<BiScopeProjectData> selectBiScopeProjectDataList(BiScopeProjectData biScopeProjectData) {
        return biScopeProjectDataMapper.selectBiScopeProjectDataList(biScopeProjectData);
    }

    /**
     * 新增项目数据
     *
     * @param biScopeProjectData 项目数据信息
     * @return 结果
     */
    @Override
    public int insertBiScopeProjectData(BiScopeProjectData biScopeProjectData) {
        return biScopeProjectDataMapper.insertBiScopeProjectData(biScopeProjectData);
    }

    /**
     * 修改项目数据
     *
     * @param biScopeProjectData 项目数据信息
     * @return 结果
     */
    @Override
    public int updateBiScopeProjectData(BiScopeProjectData biScopeProjectData) {
        return biScopeProjectDataMapper.updateBiScopeProjectData(biScopeProjectData);
    }

    /**
     * 删除项目数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeProjectDataByIds(String ids) {
        return biScopeProjectDataMapper.deleteBiScopeProjectDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入项目数据对象
     * @param biScopeProjectDataList
     * @return
     */

    @Override
    public String importBiScopeProjectData(List<BiScopeProjectData> biScopeProjectDataList) {
        if (StringUtils.isNull(biScopeProjectDataList) || biScopeProjectDataList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeProjectData biScopeProjectData : biScopeProjectDataList) {
            this.insertBiScopeProjectData(biScopeProjectData);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeProjectDataReadyToDeal(Map param)
    {
        return biScopeProjectDataMapper.updateBiScopeProjectDataReadyToDeal(param);
    }

    public int  updateBiScopeProjectDataToComplate(Map param)
    {
        return biScopeProjectDataMapper.updateBiScopeProjectDataToComplate(param);
    }

    public int  updateBiScopeProjectDataToFailed(Map param)
    {
        return biScopeProjectDataMapper.updateBiScopeProjectDataToFailed(param);
    }

    public List<BiScopeProjectDataVO> selectBiScopeProjectDataReadToDeal(Map param)
    {
        return biScopeProjectDataMapper.selectBiScopeProjectDataReadToDeal(param);
    }

}
