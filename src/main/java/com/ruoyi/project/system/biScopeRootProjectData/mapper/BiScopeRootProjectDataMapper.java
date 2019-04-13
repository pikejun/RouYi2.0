package com.ruoyi.project.system.biScopeRootProjectData.mapper;

import com.ruoyi.project.system.biScopeRootProjectData.domain.BiScopeRootProjectData;
import com.ruoyi.project.system.biScopeRootProjectData.vo.BiScopeRootProjectDataVO;

import java.util.List;
import java.util.Map;

/**
 * 总工程 数据层
 *
 * @author ruoyi
 * @date 2019-04-09
 */
public interface BiScopeRootProjectDataMapper
{
	/**
     * 查询总工程信息
     *
     * @param tid 总工程ID
     * @return 总工程信息
     */
	public BiScopeRootProjectData selectBiScopeRootProjectDataById(Integer tid);

	/**
     * 查询总工程列表
     *
     * @param biScopeRootProjectData 总工程信息
     * @return 总工程集合
     */
	public List<BiScopeRootProjectData> selectBiScopeRootProjectDataList(BiScopeRootProjectData biScopeRootProjectData);

	/**
     * 新增总工程
     *
     * @param biScopeRootProjectData 总工程信息
     * @return 结果
     */
	public int insertBiScopeRootProjectData(BiScopeRootProjectData biScopeRootProjectData);

	/**
     * 修改总工程
     *
     * @param biScopeRootProjectData 总工程信息
     * @return 结果
     */
	public int updateBiScopeRootProjectData(BiScopeRootProjectData biScopeRootProjectData);

	/**
     * 删除总工程
     *
     * @param tid 总工程ID
     * @return 结果
     */
	public int deleteBiScopeRootProjectDataById(Integer tid);

	/**
     * 批量删除总工程
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeRootProjectDataByIds(String[] tids);


	public int updateBiScopeRootProjectDataReadyToDeal(Map param);

	public int  updateBiScopeRootProjectDataToComplate(Map param);

	public int  updateBiScopeRootProjectDataToFailed(Map param);

	public List<BiScopeRootProjectDataVO> selectBiScopeRootProjectDataReadToDeal(Map param);

}