package com.ruoyi.project.system.biTemplateIndexProperty.service;

import com.ruoyi.project.system.biTemplateIndexProperty.domain.BiTemplateIndexProperty;
import java.util.List;

/**
 * 模板指标属性明细 服务层
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public interface IBiTemplateIndexPropertyService 
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
     * 删除模板指标属性明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiTemplateIndexPropertyByIds(String ids);


    /**
     * 导入模板指标属性明细数据
     * @param biTemplateIndexPropertyList
     * @return
     */
    public String importBiTemplateIndexProperty(List<BiTemplateIndexProperty> biTemplateIndexPropertyList);
}
