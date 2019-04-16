package com.ruoyi.project.system.biIndexInfo.mapper;

import com.ruoyi.project.system.biIndexInfo.domain.BiIndexInfo;
import java.util.List;

/**
 * 指标 数据层
 *
 * @author ruoyi
 * @date 2019-04-16
 */
public interface BiIndexInfoMapper
{
	/**
     * 查询指标信息
     *
     * @param indexId 指标ID
     * @return 指标信息
     */
	public BiIndexInfo selectBiIndexInfoById(Integer indexId);

	/**
     * 查询指标列表
     *
     * @param biIndexInfo 指标信息
     * @return 指标集合
     */
	public List<BiIndexInfo> selectBiIndexInfoList(BiIndexInfo biIndexInfo);

	/**
     * 新增指标
     *
     * @param biIndexInfo 指标信息
     * @return 结果
     */
	public int insertBiIndexInfo(BiIndexInfo biIndexInfo);

	/**
     * 修改指标
     *
     * @param biIndexInfo 指标信息
     * @return 结果
     */
	public int updateBiIndexInfo(BiIndexInfo biIndexInfo);

	/**
     * 删除指标
     *
     * @param indexId 指标ID
     * @return 结果
     */
	public int deleteBiIndexInfoById(Integer indexId);

	/**
     * 批量删除指标
     *
     * @param indexIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiIndexInfoByIds(String[] indexIds);

}