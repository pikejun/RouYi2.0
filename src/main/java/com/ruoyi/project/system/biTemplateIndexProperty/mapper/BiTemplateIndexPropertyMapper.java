package com.ruoyi.project.system.biTemplateIndexProperty.mapper;

import com.ruoyi.project.system.biTemplateIndexProperty.domain.BiTemplateIndexProperty;
import java.util.List;

/**
 * 模板指标属性明细 数据层
 *
 * @author ruoyi
 * @date 2019-04-16
 */
public interface BiTemplateIndexPropertyMapper
{
	/**
     * 查询模板指标属性明细信息
     *
     * @param tipId 模板指标属性明细ID
     * @return 模板指标属性明细信息
     */
	public BiTemplateIndexProperty selectBiTemplateIndexPropertyById(Integer tipId);

	/**
     * 查询模板指标属性明细列表
     *
     * @param biTemplateIndexProperty 模板指标属性明细信息
     * @return 模板指标属性明细集合
     */
	public List<BiTemplateIndexProperty> selectBiTemplateIndexPropertyList(BiTemplateIndexProperty biTemplateIndexProperty);

	/**
     * 新增模板指标属性明细
     *
     * @param biTemplateIndexProperty 模板指标属性明细信息
     * @return 结果
     */
	public int insertBiTemplateIndexProperty(BiTemplateIndexProperty biTemplateIndexProperty);

	/**
     * 修改模板指标属性明细
     *
     * @param biTemplateIndexProperty 模板指标属性明细信息
     * @return 结果
     */
	public int updateBiTemplateIndexProperty(BiTemplateIndexProperty biTemplateIndexProperty);

	/**
     * 删除模板指标属性明细
     *
     * @param tipId 模板指标属性明细ID
     * @return 结果
     */
	public int deleteBiTemplateIndexPropertyById(Integer tipId);

	/**
     * 批量删除模板指标属性明细
     *
     * @param tipIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiTemplateIndexPropertyByIds(String[] tipIds);

}