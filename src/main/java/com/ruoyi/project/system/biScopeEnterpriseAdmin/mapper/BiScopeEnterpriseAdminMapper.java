package com.ruoyi.project.system.biScopeEnterpriseAdmin.mapper;

import com.ruoyi.project.system.biScopeEnterpriseAdmin.domain.BiScopeEnterpriseAdmin;
import com.ruoyi.project.system.biScopeEnterpriseAdmin.vo.BiScopeEnterpriseAdminVO;

import java.util.List;
import java.util.Map;

/**
 * 企业管理员 数据层
 *
 * @author ruoyi
 * @date 2019-04-17
 */
public interface BiScopeEnterpriseAdminMapper
{
	/**
     * 查询企业管理员信息
     *
     * @param tid 企业管理员ID
     * @return 企业管理员信息
     */
	public BiScopeEnterpriseAdmin selectBiScopeEnterpriseAdminById(Integer tid);

	/**
     * 查询企业管理员列表
     *
     * @param biScopeEnterpriseAdmin 企业管理员信息
     * @return 企业管理员集合
     */
	public List<BiScopeEnterpriseAdmin> selectBiScopeEnterpriseAdminList(BiScopeEnterpriseAdmin biScopeEnterpriseAdmin);

	/**
     * 新增企业管理员
     *
     * @param biScopeEnterpriseAdmin 企业管理员信息
     * @return 结果
     */
	public int insertBiScopeEnterpriseAdmin(BiScopeEnterpriseAdmin biScopeEnterpriseAdmin);

	/**
     * 修改企业管理员
     *
     * @param biScopeEnterpriseAdmin 企业管理员信息
     * @return 结果
     */
	public int updateBiScopeEnterpriseAdmin(BiScopeEnterpriseAdmin biScopeEnterpriseAdmin);

	/**
     * 删除企业管理员
     *
     * @param tid 企业管理员ID
     * @return 结果
     */
	public int deleteBiScopeEnterpriseAdminById(Integer tid);

	/**
     * 批量删除企业管理员
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeEnterpriseAdminByIds(String[] tids);

	public int updateBiScopeEnterpriseAdminReadyToDeal(Map param);

	public int  updateBiScopeEnterpriseAdminToComplate(Map param);

	public int  updateBiScopeEnterpriseAdminToFailed(Map param);

	public List<BiScopeEnterpriseAdminVO> selectBiScopeEnterpriseAdminReadToDeal(Map param);

}