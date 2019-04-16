package com.ruoyi.project.system.biTemplateIndex.service;

import com.ruoyi.project.system.biTemplateIndex.domain.BiTemplateIndex;
import java.util.List;

/**
 * 模板指标明细 服务层
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public interface IBiTemplateIndexService 
{
	/**
     * 查询模板指标明细信息
     * 
     * @param tiid 模板指标明细ID
     * @return 模板指标明细信息
     */
	public BiTemplateIndex selectBiTemplateIndexById(Integer tiid);
	
	/**
     * 查询模板指标明细列表
     * 
     * @param biTemplateIndex 模板指标明细信息
     * @return 模板指标明细集合
     */
	public List<BiTemplateIndex> selectBiTemplateIndexList(BiTemplateIndex biTemplateIndex);
	
	/**
     * 新增模板指标明细
     * 
     * @param biTemplateIndex 模板指标明细信息
     * @return 结果
     */
	public int insertBiTemplateIndex(BiTemplateIndex biTemplateIndex);
	
	/**
     * 修改模板指标明细
     * 
     * @param biTemplateIndex 模板指标明细信息
     * @return 结果
     */
	public int updateBiTemplateIndex(BiTemplateIndex biTemplateIndex);
		
	/**
     * 删除模板指标明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiTemplateIndexByIds(String ids);


    /**
     * 导入模板指标明细数据
     * @param biTemplateIndexList
     * @return
     */
    public String importBiTemplateIndex(List<BiTemplateIndex> biTemplateIndexList);
}
