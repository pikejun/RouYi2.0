package com.ruoyi.project.system.biScopeGroupData.mapper;

import com.ruoyi.project.system.biScopeGroupData.domain.BiScopeGroupData;
import com.ruoyi.project.system.biScopeGroupData.vo.BiScopeGroupDataVO;

import java.util.List;
import java.util.Map;

/**
 * 项目班组数据 数据层
 *
 * @author ruoyi
 * @date 2019-04-13
 */
public interface BiScopeGroupDataMapper
{
	/**
     * 查询项目班组数据信息
     *
     * @param tid 项目班组数据ID
     * @return 项目班组数据信息
     */
	public BiScopeGroupData selectBiScopeGroupDataById(Integer tid);

	/**
     * 查询项目班组数据列表
     *
     * @param biScopeGroupData 项目班组数据信息
     * @return 项目班组数据集合
     */
	public List<BiScopeGroupData> selectBiScopeGroupDataList(BiScopeGroupData biScopeGroupData);

	/**
     * 新增项目班组数据
     *
     * @param biScopeGroupData 项目班组数据信息
     * @return 结果
     */
	public int insertBiScopeGroupData(BiScopeGroupData biScopeGroupData);

	/**
     * 修改项目班组数据
     *
     * @param biScopeGroupData 项目班组数据信息
     * @return 结果
     */
	public int updateBiScopeGroupData(BiScopeGroupData biScopeGroupData);

	/**
     * 删除项目班组数据
     *
     * @param tid 项目班组数据ID
     * @return 结果
     */
	public int deleteBiScopeGroupDataById(Integer tid);

	/**
     * 批量删除项目班组数据
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeGroupDataByIds(String[] tids);


	public int updateBiScopeGroupDataReadyToDeal(Map param);

	public int  updateBiScopeGroupDataToComplate(Map param);

	public int  updateBiScopeGroupDataToFailed(Map param);

	public List<BiScopeGroupDataVO> selectBiScopeGroupDataReadToDeal(Map param);

}