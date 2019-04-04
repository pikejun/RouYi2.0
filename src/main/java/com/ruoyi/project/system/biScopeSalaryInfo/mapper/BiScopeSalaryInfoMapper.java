package com.ruoyi.project.system.biScopeSalaryInfo.mapper;

import com.ruoyi.project.system.biScopeSalaryInfo.domain.BiScopeSalaryInfo;
import com.ruoyi.project.system.biScopeSalaryInfo.vo.BiScopeSalaryInfoVO;

import java.util.List;
import java.util.Map;

/**
 * 工资 数据层
 *
 * @author ruoyi
 * @date 2019-04-04
 */
public interface BiScopeSalaryInfoMapper
{
	/**
     * 查询工资信息
     *
     * @param tid 工资ID
     * @return 工资信息
     */
	public BiScopeSalaryInfo selectBiScopeSalaryInfoById(Integer tid);

	/**
     * 查询工资列表
     *
     * @param biScopeSalaryInfo 工资信息
     * @return 工资集合
     */
	public List<BiScopeSalaryInfo> selectBiScopeSalaryInfoList(BiScopeSalaryInfo biScopeSalaryInfo);

	/**
     * 新增工资
     *
     * @param biScopeSalaryInfo 工资信息
     * @return 结果
     */
	public int insertBiScopeSalaryInfo(BiScopeSalaryInfo biScopeSalaryInfo);

	/**
     * 修改工资
     *
     * @param biScopeSalaryInfo 工资信息
     * @return 结果
     */
	public int updateBiScopeSalaryInfo(BiScopeSalaryInfo biScopeSalaryInfo);

	/**
     * 删除工资
     *
     * @param tid 工资ID
     * @return 结果
     */
	public int deleteBiScopeSalaryInfoById(Integer tid);

	/**
     * 批量删除工资
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