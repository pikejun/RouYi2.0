package com.ruoyi.project.system.biIndexDisplay.mapper;

import com.ruoyi.project.system.biIndexDisplay.domain.BiIndexDisplay;
import java.util.List;

/**
 * 指标展示 数据层
 *
 * @author ruoyi
 * @date 2019-04-18
 */
public interface BiIndexDisplayMapper
{
	/**
     * 查询指标展示信息
     *
     * @param displayId 指标展示ID
     * @return 指标展示信息
     */
	public BiIndexDisplay selectBiIndexDisplayById(Integer displayId);

	/**
     * 查询指标展示列表
     *
     * @param biIndexDisplay 指标展示信息
     * @return 指标展示集合
     */
	public List<BiIndexDisplay> selectBiIndexDisplayList(BiIndexDisplay biIndexDisplay);

	/**
     * 新增指标展示
     *
     * @param biIndexDisplay 指标展示信息
     * @return 结果
     */
	public int insertBiIndexDisplay(BiIndexDisplay biIndexDisplay);

	/**
     * 修改指标展示
     *
     * @param biIndexDisplay 指标展示信息
     * @return 结果
     */
	public int updateBiIndexDisplay(BiIndexDisplay biIndexDisplay);

	/**
     * 删除指标展示
     *
     * @param displayId 指标展示ID
     * @return 结果
     */
	public int deleteBiIndexDisplayById(Integer displayId);

	/**
     * 批量删除指标展示
     *
     * @param displayIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiIndexDisplayByIds(String[] displayIds);

}