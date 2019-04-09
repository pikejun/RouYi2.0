package com.ruoyi.project.system.biScopeEnterpriseDepartment.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeEnterpriseDepartment.vo.BiScopeEnterpriseDepartmentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeEnterpriseDepartment.mapper.BiScopeEnterpriseDepartmentMapper;
import com.ruoyi.project.system.biScopeEnterpriseDepartment.domain.BiScopeEnterpriseDepartment;
import com.ruoyi.project.system.biScopeEnterpriseDepartment.service.IBiScopeEnterpriseDepartmentService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 企业部门 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-08
 */
@Service
public class BiScopeEnterpriseDepartmentServiceImpl implements IBiScopeEnterpriseDepartmentService {
    @Autowired
    private BiScopeEnterpriseDepartmentMapper biScopeEnterpriseDepartmentMapper;

    /**
     * 查询企业部门信息
     *
     * @param tid 企业部门ID
     * @return 企业部门信息
     */
    @Override
    public BiScopeEnterpriseDepartment selectBiScopeEnterpriseDepartmentById(Integer tid) {
        return biScopeEnterpriseDepartmentMapper.selectBiScopeEnterpriseDepartmentById(tid);
    }

    /**
     * 查询企业部门列表
     *
     * @param biScopeEnterpriseDepartment 企业部门信息
     * @return 企业部门集合
     */
    @Override
    public List<BiScopeEnterpriseDepartment> selectBiScopeEnterpriseDepartmentList(BiScopeEnterpriseDepartment biScopeEnterpriseDepartment) {
        return biScopeEnterpriseDepartmentMapper.selectBiScopeEnterpriseDepartmentList(biScopeEnterpriseDepartment);
    }

    /**
     * 新增企业部门
     *
     * @param biScopeEnterpriseDepartment 企业部门信息
     * @return 结果
     */
    @Override
    public int insertBiScopeEnterpriseDepartment(BiScopeEnterpriseDepartment biScopeEnterpriseDepartment) {
        return biScopeEnterpriseDepartmentMapper.insertBiScopeEnterpriseDepartment(biScopeEnterpriseDepartment);
    }

    /**
     * 修改企业部门
     *
     * @param biScopeEnterpriseDepartment 企业部门信息
     * @return 结果
     */
    @Override
    public int updateBiScopeEnterpriseDepartment(BiScopeEnterpriseDepartment biScopeEnterpriseDepartment) {
        return biScopeEnterpriseDepartmentMapper.updateBiScopeEnterpriseDepartment(biScopeEnterpriseDepartment);
    }

    /**
     * 删除企业部门对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeEnterpriseDepartmentByIds(String ids) {
        return biScopeEnterpriseDepartmentMapper.deleteBiScopeEnterpriseDepartmentByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入企业部门对象
     * @param biScopeEnterpriseDepartmentList
     * @return
     */

    @Override
    public String importBiScopeEnterpriseDepartment(List<BiScopeEnterpriseDepartment> biScopeEnterpriseDepartmentList) {
        if (StringUtils.isNull(biScopeEnterpriseDepartmentList) || biScopeEnterpriseDepartmentList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeEnterpriseDepartment biScopeEnterpriseDepartment : biScopeEnterpriseDepartmentList) {
            this.insertBiScopeEnterpriseDepartment(biScopeEnterpriseDepartment);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }


    public int updateBiScopeEnterpriseDepartmentReadyToDeal(Map param)
    {
        return biScopeEnterpriseDepartmentMapper.updateBiScopeEnterpriseDepartmentReadyToDeal(param);
    }


    public int  updateBiScopeEnterpriseDepartmentToComplate(Map param)
    {
        return biScopeEnterpriseDepartmentMapper.updateBiScopeEnterpriseDepartmentToComplate(param);
    }

    public int  updateBiScopeEnterpriseDepartmentToFailed(Map param)
    {
        return biScopeEnterpriseDepartmentMapper.updateBiScopeEnterpriseDepartmentToFailed(param);
    }

    public List<BiScopeEnterpriseDepartmentVO> selectBiScopeEnterpriseDepartmentReadToDeal(Map param)
    {
        return biScopeEnterpriseDepartmentMapper.selectBiScopeEnterpriseDepartmentReadToDeal(param);
    }

}
