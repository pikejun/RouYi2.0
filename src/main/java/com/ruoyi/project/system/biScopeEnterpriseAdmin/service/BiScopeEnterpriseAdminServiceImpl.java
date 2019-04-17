package com.ruoyi.project.system.biScopeEnterpriseAdmin.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeEnterpriseAdmin.vo.BiScopeEnterpriseAdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeEnterpriseAdmin.mapper.BiScopeEnterpriseAdminMapper;
import com.ruoyi.project.system.biScopeEnterpriseAdmin.domain.BiScopeEnterpriseAdmin;
import com.ruoyi.project.system.biScopeEnterpriseAdmin.service.IBiScopeEnterpriseAdminService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 企业管理员 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-17
 */
@Service
public class BiScopeEnterpriseAdminServiceImpl implements IBiScopeEnterpriseAdminService {
    @Autowired
    private BiScopeEnterpriseAdminMapper biScopeEnterpriseAdminMapper;

    /**
     * 查询企业管理员信息
     *
     * @param tid 企业管理员ID
     * @return 企业管理员信息
     */
    @Override
    public BiScopeEnterpriseAdmin selectBiScopeEnterpriseAdminById(Integer tid) {
        return biScopeEnterpriseAdminMapper.selectBiScopeEnterpriseAdminById(tid);
    }

    /**
     * 查询企业管理员列表
     *
     * @param biScopeEnterpriseAdmin 企业管理员信息
     * @return 企业管理员集合
     */
    @Override
    public List<BiScopeEnterpriseAdmin> selectBiScopeEnterpriseAdminList(BiScopeEnterpriseAdmin biScopeEnterpriseAdmin) {
        return biScopeEnterpriseAdminMapper.selectBiScopeEnterpriseAdminList(biScopeEnterpriseAdmin);
    }

    /**
     * 新增企业管理员
     *
     * @param biScopeEnterpriseAdmin 企业管理员信息
     * @return 结果
     */
    @Override
    public int insertBiScopeEnterpriseAdmin(BiScopeEnterpriseAdmin biScopeEnterpriseAdmin) {
        return biScopeEnterpriseAdminMapper.insertBiScopeEnterpriseAdmin(biScopeEnterpriseAdmin);
    }

    /**
     * 修改企业管理员
     *
     * @param biScopeEnterpriseAdmin 企业管理员信息
     * @return 结果
     */
    @Override
    public int updateBiScopeEnterpriseAdmin(BiScopeEnterpriseAdmin biScopeEnterpriseAdmin) {
        return biScopeEnterpriseAdminMapper.updateBiScopeEnterpriseAdmin(biScopeEnterpriseAdmin);
    }

    /**
     * 删除企业管理员对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeEnterpriseAdminByIds(String ids) {
        return biScopeEnterpriseAdminMapper.deleteBiScopeEnterpriseAdminByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入企业管理员对象
     * @param biScopeEnterpriseAdminList
     * @return
     */

    @Override
    public String importBiScopeEnterpriseAdmin(List<BiScopeEnterpriseAdmin> biScopeEnterpriseAdminList) {
        if (StringUtils.isNull(biScopeEnterpriseAdminList) || biScopeEnterpriseAdminList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeEnterpriseAdmin biScopeEnterpriseAdmin : biScopeEnterpriseAdminList) {
            this.insertBiScopeEnterpriseAdmin(biScopeEnterpriseAdmin);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeEnterpriseAdminReadyToDeal(Map param)
    {
        return biScopeEnterpriseAdminMapper.updateBiScopeEnterpriseAdminReadyToDeal(param);
    }

    public int  updateBiScopeEnterpriseAdminToComplate(Map param)
    {
        return biScopeEnterpriseAdminMapper.updateBiScopeEnterpriseAdminToComplate(param);
    }

    public int  updateBiScopeEnterpriseAdminToFailed(Map param)
    {
        return biScopeEnterpriseAdminMapper.updateBiScopeEnterpriseAdminToFailed(param);
    }

    public List<BiScopeEnterpriseAdminVO> selectBiScopeEnterpriseAdminReadToDeal(Map param)
    {
        return biScopeEnterpriseAdminMapper.selectBiScopeEnterpriseAdminReadToDeal(param);
    }

}
