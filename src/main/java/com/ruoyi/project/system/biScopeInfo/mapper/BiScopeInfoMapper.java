package com.ruoyi.project.system.biScopeInfo.mapper;

import com.ruoyi.project.system.biScopeInfo.domain.BiScopeInfo;
import java.util.List;

/**
 * 范围 数据层
 *
 * @author ruoyi
 * @date 2019-03-18
 */
public interface BiScopeInfoMapper
{
	/**
     * 查询范围信息
     *
     * @param scopeId 范围ID
     * @return 范围信息
     */
	public BiScopeInfo selectBiScopeInfoById(Integer scopeId);

	/**
     * 查询范围列表
     *
     * @param biScopeInfo 范围信息
     * @return 范围集合
     */
	public List<BiScopeInfo> selectBiScopeInfoList(BiScopeInfo biScopeInfo);

	/**
     * 新增范围
     *
     * @param biScopeInfo 范围信息
     * @return 结果
     */
	public int insertBiScopeInfo(BiScopeInfo biScopeInfo);

	/**
     * 修改范围
     *
     * @param biScopeInfo 范围信息
     * @return 结果
     */
	public int updateBiScopeInfo(BiScopeInfo biScopeInfo);

	/**
     * 删除范围
     *
     * @param scopeId 范围ID
     * @return 结果
     */
	public int deleteBiScopeInfoById(Integer scopeId);

	/**
     * 批量删除范围
     *
     * @param scopeIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeInfoByIds(String[] scopeIds);

}