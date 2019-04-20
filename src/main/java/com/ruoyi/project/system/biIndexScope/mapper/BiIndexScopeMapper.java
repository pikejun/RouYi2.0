package com.ruoyi.project.system.biIndexScope.mapper;

import com.ruoyi.project.system.biIndexScope.domain.BiIndexScope;
import java.util.List;
import java.util.Map;

/**
 * 指标范围 数据层
 *
 * @author ruoyi
 * @date 2019-04-17
 */
public interface BiIndexScopeMapper
{
	/**
     * 查询指标范围信息
     *
     * @param isId 指标范围ID
     * @return 指标范围信息
     */
	public BiIndexScope selectBiIndexScopeById(Integer isId);

	/**
     * 查询指标范围列表
     *
     * @param biIndexScope 指标范围信息
     * @return 指标范围集合
     */
	public List<BiIndexScope> selectBiIndexScopeList(BiIndexScope biIndexScope);

	public List<Map> getScopeAndAliasNameList(BiIndexScope biIndexScope);

	/**
     * 新增指标范围
     *
     * @param biIndexScope 指标范围信息
     * @return 结果
     */
	public int insertBiIndexScope(BiIndexScope biIndexScope);

	/**
     * 修改指标范围
     *
     * @param biIndexScope 指标范围信息
     * @return 结果
     */
	public int updateBiIndexScope(BiIndexScope biIndexScope);

	/**
     * 删除指标范围
     *
     * @param isId 指标范围ID
     * @return 结果
     */
	public int deleteBiIndexScopeById(Integer isId);

	/**
     * 批量删除指标范围
     *
     * @param isIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiIndexScopeByIds(String[] isIds);

}