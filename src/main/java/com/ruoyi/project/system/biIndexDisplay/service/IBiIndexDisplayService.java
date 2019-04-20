package com.ruoyi.project.system.biIndexDisplay.service;

import com.ruoyi.project.system.biIndexDisplay.domain.BiIndexDisplay;
import java.util.List;

/**
 * 指标展示 服务层
 * 
 * @author ruoyi
 * @date 2019-04-18
 */
public interface IBiIndexDisplayService 
{
	public String getDisplayHtml(Integer displayId);

	public String getDisplayHtml(String scopeName, String id,String displayNo,String indexNo);

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
     * 删除指标展示信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiIndexDisplayByIds(String ids);


    /**
     * 导入指标展示数据
     * @param biIndexDisplayList
     * @return
     */
    public String importBiIndexDisplay(List<BiIndexDisplay> biIndexDisplayList);
}
