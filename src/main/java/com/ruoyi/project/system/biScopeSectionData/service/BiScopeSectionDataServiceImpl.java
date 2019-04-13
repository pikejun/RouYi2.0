package com.ruoyi.project.system.biScopeSectionData.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeSectionData.vo.BiScopeSectionDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeSectionData.mapper.BiScopeSectionDataMapper;
import com.ruoyi.project.system.biScopeSectionData.domain.BiScopeSectionData;
import com.ruoyi.project.system.biScopeSectionData.service.IBiScopeSectionDataService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 标段数据 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-10
 */
@Service
public class BiScopeSectionDataServiceImpl implements IBiScopeSectionDataService {
    @Autowired
    private BiScopeSectionDataMapper biScopeSectionDataMapper;

    /**
     * 查询标段数据信息
     *
     * @param tid 标段数据ID
     * @return 标段数据信息
     */
    @Override
    public BiScopeSectionData selectBiScopeSectionDataById(Integer tid) {
        return biScopeSectionDataMapper.selectBiScopeSectionDataById(tid);
    }

    /**
     * 查询标段数据列表
     *
     * @param biScopeSectionData 标段数据信息
     * @return 标段数据集合
     */
    @Override
    public List<BiScopeSectionData> selectBiScopeSectionDataList(BiScopeSectionData biScopeSectionData) {
        return biScopeSectionDataMapper.selectBiScopeSectionDataList(biScopeSectionData);
    }

    /**
     * 新增标段数据
     *
     * @param biScopeSectionData 标段数据信息
     * @return 结果
     */
    @Override
    public int insertBiScopeSectionData(BiScopeSectionData biScopeSectionData) {
        return biScopeSectionDataMapper.insertBiScopeSectionData(biScopeSectionData);
    }

    /**
     * 修改标段数据
     *
     * @param biScopeSectionData 标段数据信息
     * @return 结果
     */
    @Override
    public int updateBiScopeSectionData(BiScopeSectionData biScopeSectionData) {
        return biScopeSectionDataMapper.updateBiScopeSectionData(biScopeSectionData);
    }

    /**
     * 删除标段数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeSectionDataByIds(String ids) {
        return biScopeSectionDataMapper.deleteBiScopeSectionDataByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入标段数据对象
     * @param biScopeSectionDataList
     * @return
     */

    @Override
    public String importBiScopeSectionData(List<BiScopeSectionData> biScopeSectionDataList) {
        if (StringUtils.isNull(biScopeSectionDataList) || biScopeSectionDataList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeSectionData biScopeSectionData : biScopeSectionDataList) {
            this.insertBiScopeSectionData(biScopeSectionData);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeSectionDataReadyToDeal(Map param)
    {
        return biScopeSectionDataMapper.updateBiScopeSectionDataReadyToDeal(param);
    }

    public int  updateBiScopeSectionDataToComplate(Map param)
    {
        return biScopeSectionDataMapper.updateBiScopeSectionDataToComplate(param);
    }

    public int  updateBiScopeSectionDataToFailed(Map param)
    {
        return biScopeSectionDataMapper.updateBiScopeSectionDataToFailed(param);
    }

    public List<BiScopeSectionDataVO> selectBiScopeSectionDataReadToDeal(Map param)
    {
        return biScopeSectionDataMapper.selectBiScopeSectionDataReadToDeal(param);
    }

}
