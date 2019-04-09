package com.ruoyi.project.system.biScopeEnterpriseDepartment.mapper;

import com.ruoyi.project.system.biScopeEnterpriseDepartment.domain.BiScopeEnterpriseDepartment;
import com.ruoyi.project.system.biScopeEnterpriseDepartment.vo.BiScopeEnterpriseDepartmentVO;

import java.util.List;
import java.util.Map;

/**
 * 企业部门 数据层
 *
 * @author ruoyi
 * @date 2019-04-08
 */
public interface BiScopeEnterpriseDepartmentMapper
{
	/**
     * 查询企业部门信息
     *
     * @param tid 企业部门ID
     * @return 企业部门信息
     */
	public BiScopeEnterpriseDepartment selectBiScopeEnterpriseDepartmentById(Integer tid);

	/**
     * 查询企业部门列表
     *
     * @param biScopeEnterpriseDepartment 企业部门信息
     * @return 企业部门集合
     */
	public List<BiScopeEnterpriseDepartment> selectBiScopeEnterpriseDepartmentList(BiScopeEnterpriseDepartment biScopeEnterpriseDepartment);

	/**
     * 新增企业部门
     *
     * @param biScopeEnterpriseDepartment 企业部门信息
     * @return 结果
     */
	public int insertBiScopeEnterpriseDepartment(BiScopeEnterpriseDepartment biScopeEnterpriseDepartment);

	/**
     * 修改企业部门
     *
     * @param biScopeEnterpriseDepartment 企业部门信息
     * @return 结果
     */
	public int updateBiScopeEnterpriseDepartment(BiScopeEnterpriseDepartment biScopeEnterpriseDepartment);

	/**
     * 删除企业部门
     *
     * @param tid 企业部门ID
     * @return 结果
     */
	public int deleteBiScopeEnterpriseDepartmentById(Integer tid);

	/**
     * 批量删除企业部门
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeEnterpriseDepartmentByIds(String[] tids);

	public int updateBiScopeEnterpriseDepartmentReadyToDeal(Map param);

	public int  updateBiScopeEnterpriseDepartmentToComplate(Map param);

	public int  updateBiScopeEnterpriseDepartmentToFailed(Map param);

	public List<BiScopeEnterpriseDepartmentVO> selectBiScopeEnterpriseDepartmentReadToDeal(Map param);

}