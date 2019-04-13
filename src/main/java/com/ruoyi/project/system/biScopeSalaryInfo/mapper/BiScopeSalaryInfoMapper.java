package com.ruoyi.project.system.biScopeSalaryInfo.mapper;

import com.ruoyi.project.system.biScopeSalaryInfo.domain.BiScopeSalaryInfo;
import com.ruoyi.project.system.biScopeSalaryInfo.vo.BiScopeSalaryInfoVO;

import java.util.List;
import java.util.Map;

/**
 * 工人工资 数据层
 *
 * @author ruoyi
 * @date 2019-04-12
 */
public interface BiScopeSalaryInfoMapper
{
	/**
     * 查询工人工资信息
     *
     * @param tid 工人工资ID
     * @return 工人工资信息
     */
	public BiScopeSalaryInfo selectBiScopeSalaryInfoById(Integer tid);

	/**
     * 查询工人工资列表
     *
     * @param biScopeSalaryInfo 工人工资信息
     * @return 工人工资集合
     */
	public List<BiScopeSalaryInfo> selectBiScopeSalaryInfoList(BiScopeSalaryInfo biScopeSalaryInfo);

	/**
     * 新增工人工资
     *
     * @param biScopeSalaryInfo 工人工资信息
     * @return 结果
     */
	public int insertBiScopeSalaryInfo(BiScopeSalaryInfo biScopeSalaryInfo);

	/**
     * 修改工人工资
     *
     * @param biScopeSalaryInfo 工人工资信息
     * @return 结果
     */
	public int updateBiScopeSalaryInfo(BiScopeSalaryInfo biScopeSalaryInfo);

	/**
     * 删除工人工资
     *
     * @param tid 工人工资ID
     * @return 结果
     */
	public int deleteBiScopeSalaryInfoById(Integer tid);

	/**
     * 批量删除工人工资
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeSalaryInfoByIds(String[] tids);

	public int updateBiScopeSalaryInfoReadyToDeal(Map param);

	public int  updateBiScopeSalaryInfoToComplate(Map param);

	public int  updateBiScopeSalaryInfoToFailed(Map param);

	public List<BiScopeSalaryInfoVO> selectBiScopeSalaryInfoReadToDeal(Map param);

}