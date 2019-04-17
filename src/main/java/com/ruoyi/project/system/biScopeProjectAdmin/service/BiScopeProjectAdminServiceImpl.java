package com.ruoyi.project.system.biScopeProjectAdmin.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeProjectAdmin.vo.BiScopeProjectAdminVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeProjectAdmin.mapper.BiScopeProjectAdminMapper;
import com.ruoyi.project.system.biScopeProjectAdmin.domain.BiScopeProjectAdmin;
import com.ruoyi.project.system.biScopeProjectAdmin.service.IBiScopeProjectAdminService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 项目管理员 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-17
 */
@Service
public class BiScopeProjectAdminServiceImpl implements IBiScopeProjectAdminService {
    @Autowired
    private BiScopeProjectAdminMapper biScopeProjectAdminMapper;

    /**
     * 查询项目管理员信息
     *
     * @param tid 项目管理员ID
     * @return 项目管理员信息
     */
    @Override
    public BiScopeProjectAdmin selectBiScopeProjectAdminById(Integer tid) {
        return biScopeProjectAdminMapper.selectBiScopeProjectAdminById(tid);
    }

    /**
     * 查询项目管理员列表
     *
     * @param biScopeProjectAdmin 项目管理员信息
     * @return 项目管理员集合
     */
    @Override
    public List<BiScopeProjectAdmin> selectBiScopeProjectAdminList(BiScopeProjectAdmin biScopeProjectAdmin) {
        return biScopeProjectAdminMapper.selectBiScopeProjectAdminList(biScopeProjectAdmin);
    }

    /**
     * 新增项目管理员
     *
     * @param biScopeProjectAdmin 项目管理员信息
     * @return 结果
     */
    @Override
    public int insertBiScopeProjectAdmin(BiScopeProjectAdmin biScopeProjectAdmin) {
        return biScopeProjectAdminMapper.insertBiScopeProjectAdmin(biScopeProjectAdmin);
    }

    /**
     * 修改项目管理员
     *
     * @param biScopeProjectAdmin 项目管理员信息
     * @return 结果
     */
    @Override
    public int updateBiScopeProjectAdmin(BiScopeProjectAdmin biScopeProjectAdmin) {
        return biScopeProjectAdminMapper.updateBiScopeProjectAdmin(biScopeProjectAdmin);
    }

    /**
     * 删除项目管理员对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeProjectAdminByIds(String ids) {
        return biScopeProjectAdminMapper.deleteBiScopeProjectAdminByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入项目管理员对象
     * @param biScopeProjectAdminList
     * @return
     */

    @Override
    public String importBiScopeProjectAdmin(List<BiScopeProjectAdmin> biScopeProjectAdminList) {
        if (StringUtils.isNull(biScopeProjectAdminList) || biScopeProjectAdminList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeProjectAdmin biScopeProjectAdmin : biScopeProjectAdminList) {
            this.insertBiScopeProjectAdmin(biScopeProjectAdmin);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeProjectAdminReadyToDeal(Map param)
    {
        return biScopeProjectAdminMapper.updateBiScopeProjectAdminReadyToDeal(param);
    }

    public int  updateBiScopeProjectAdminToComplate(Map param)
    {
        return biScopeProjectAdminMapper.updateBiScopeProjectAdminToComplate(param);
    }

    public int  updateBiScopeProjectAdminToFailed(Map param)
    {
        return biScopeProjectAdminMapper.updateBiScopeProjectAdminToFailed(param);
    }

    public List<BiScopeProjectAdminVO> selectBiScopeProjectAdminReadToDeal(Map param)
    {
        return biScopeProjectAdminMapper.selectBiScopeProjectAdminReadToDeal(param);
    }

}
