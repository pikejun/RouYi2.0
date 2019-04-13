package com.ruoyi.project.system.biScopeSalaryInfo.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeSalaryInfo.vo.BiScopeSalaryInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeSalaryInfo.mapper.BiScopeSalaryInfoMapper;
import com.ruoyi.project.system.biScopeSalaryInfo.domain.BiScopeSalaryInfo;
import com.ruoyi.project.system.biScopeSalaryInfo.service.IBiScopeSalaryInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 工人工资 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class BiScopeSalaryInfoServiceImpl implements IBiScopeSalaryInfoService {
    @Autowired
    private BiScopeSalaryInfoMapper biScopeSalaryInfoMapper;

    /**
     * 查询工人工资信息
     *
     * @param tid 工人工资ID
     * @return 工人工资信息
     */
    @Override
    public BiScopeSalaryInfo selectBiScopeSalaryInfoById(Integer tid) {
        return biScopeSalaryInfoMapper.selectBiScopeSalaryInfoById(tid);
    }

    /**
     * 查询工人工资列表
     *
     * @param biScopeSalaryInfo 工人工资信息
     * @return 工人工资集合
     */
    @Override
    public List<BiScopeSalaryInfo> selectBiScopeSalaryInfoList(BiScopeSalaryInfo biScopeSalaryInfo) {
        return biScopeSalaryInfoMapper.selectBiScopeSalaryInfoList(biScopeSalaryInfo);
    }

    /**
     * 新增工人工资
     *
     * @param biScopeSalaryInfo 工人工资信息
     * @return 结果
     */
    @Override
    public int insertBiScopeSalaryInfo(BiScopeSalaryInfo biScopeSalaryInfo) {
        return biScopeSalaryInfoMapper.insertBiScopeSalaryInfo(biScopeSalaryInfo);
    }

    /**
     * 修改工人工资
     *
     * @param biScopeSalaryInfo 工人工资信息
     * @return 结果
     */
    @Override
    public int updateBiScopeSalaryInfo(BiScopeSalaryInfo biScopeSalaryInfo) {
        return biScopeSalaryInfoMapper.updateBiScopeSalaryInfo(biScopeSalaryInfo);
    }

    /**
     * 删除工人工资对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeSalaryInfoByIds(String ids) {
        return biScopeSalaryInfoMapper.deleteBiScopeSalaryInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入工人工资对象
     * @param biScopeSalaryInfoList
     * @return
     */

    @Override
    public String importBiScopeSalaryInfo(List<BiScopeSalaryInfo> biScopeSalaryInfoList) {
        if (StringUtils.isNull(biScopeSalaryInfoList) || biScopeSalaryInfoList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeSalaryInfo biScopeSalaryInfo : biScopeSalaryInfoList) {
            this.insertBiScopeSalaryInfo(biScopeSalaryInfo);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeSalaryInfoReadyToDeal(Map param)
    {
        return biScopeSalaryInfoMapper.updateBiScopeSalaryInfoReadyToDeal(param);
    }

    public int  updateBiScopeSalaryInfoToComplate(Map param)
    {
        return biScopeSalaryInfoMapper.updateBiScopeSalaryInfoToComplate(param);
    }

    public int  updateBiScopeSalaryInfoToFailed(Map param)
    {
        return biScopeSalaryInfoMapper.updateBiScopeSalaryInfoToFailed(param);
    }

    public List<BiScopeSalaryInfoVO> selectBiScopeSalaryInfoReadToDeal(Map param)
    {
        return biScopeSalaryInfoMapper.selectBiScopeSalaryInfoReadToDeal(param);
    }

}
