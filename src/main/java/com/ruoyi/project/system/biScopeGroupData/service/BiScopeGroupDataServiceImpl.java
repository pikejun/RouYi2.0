package com.ruoyi.project.system.biScopeGroupData.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeGroupData.vo.BiScopeGroupDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeGroupData.mapper.BiScopeGroupDataMapper;
import com.ruoyi.project.system.biScopeGroupData.domain.BiScopeGroupData;
import com.ruoyi.project.system.biScopeGroupData.service.IBiScopeGroupDataService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 项目班组数据 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-13
 */
@Service
public class BiScopeGroupDataServiceImpl implements IBiScopeGroupDataService {
    @Autowired
    private BiScopeGroupDataMapper biScopeGroupDataMapper;

    /**
     * 查询项目班组数据信息
     *
     * @param tid 项目班组数据ID
     * @return 项目班组数据信息
     */
    @Override
    public BiScopeGroupData selectBiScopeGroupDataById(Integer tid) {
        return biScopeGroupDataMapper.selectBiScopeGroupDataById(tid);
    }

    /**
     * 查询项目班组数据列表
     *
     * @param biScopeGroupData 项目班组数据信息
     * @return 项目班组数据集合
     */
    @Override
    public List<BiScopeGroupData> selectBiScopeGroupDataList(BiScopeGroupData biScopeGroupData) {
        return biScopeGroupDataMapper.selectBiScopeGroupDataList(biScopeGroupData);
    }

    /**
     * 新增项目班组数据
     *
     * @param biScopeGroupData 项目班组数据信息
     * @return 结果
     */
    @Override
    public int insertBiScopeGroupData(BiScopeGroupData biScopeGroupData) {
        return biScopeGroupDataMapper.insertBiScopeGroupData(biScopeGroupData);
    }

    /**
     * 修改项目班组数据
     *
     * @param biScopeGroupData 项目班组数据信息
     * @return 结果
     */
    @Override
    public int updateBiScopeGroupData(BiScopeGroupData biScopeGroupData) {
        return biScopeGroupDataMapper.updateBiScopeGroupData(biScopeGroupData);
    }

    /**
     * 删除项目班组数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeGroupDataByIds(String ids) {
        return biScopeGroupDataMapper.deleteBiScopeGroupDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入项目班组数据对象
     * @param biScopeGroupDataList
     * @return
     */

    @Override
    public String importBiScopeGroupData(List<BiScopeGroupData> biScopeGroupDataList) {
        if (StringUtils.isNull(biScopeGroupDataList) || biScopeGroupDataList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeGroupData biScopeGroupData : biScopeGroupDataList) {
            this.insertBiScopeGroupData(biScopeGroupData);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeGroupDataReadyToDeal(Map param)
    {
        return biScopeGroupDataMapper.updateBiScopeGroupDataReadyToDeal(param);
    }

    public int  updateBiScopeGroupDataToComplate(Map param)
    {
        return biScopeGroupDataMapper.updateBiScopeGroupDataToComplate(param);
    }

    public int  updateBiScopeGroupDataToFailed(Map param)
    {
        return biScopeGroupDataMapper.updateBiScopeGroupDataToFailed(param);
    }

    public List<BiScopeGroupDataVO> selectBiScopeGroupDataReadToDeal(Map param)
    {
        return biScopeGroupDataMapper.selectBiScopeGroupDataReadToDeal(param);
    }

}
