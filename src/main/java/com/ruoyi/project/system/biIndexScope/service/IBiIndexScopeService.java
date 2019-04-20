package com.ruoyi.project.system.biIndexScope.service;

import com.ruoyi.project.system.biIndexScope.domain.BiIndexScope;
import java.util.List;
import java.util.Map;

/**
 * 指标范围 服务层
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
public interface IBiIndexScopeService 
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
     * 删除指标范围信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiIndexScopeByIds(String ids);


    /**
     * 导入指标范围数据
     * @param biIndexScopeList
     * @return
     */
    public String importBiIndexScope(List<BiIndexScope> biIndexScopeList);
}
