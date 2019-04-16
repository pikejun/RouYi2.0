package com.ruoyi.project.system.biScopeProperty.service;

import com.ruoyi.project.system.biScopeProperty.domain.BiScopeProperty;
import java.util.List;

/**
 * 范围属性 服务层
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public interface IBiScopePropertyService 
{
	/**
     * 查询范围属性信息
     * 
     * @param propertyId 范围属性ID
     * @return 范围属性信息
     */
	public BiScopeProperty selectBiScopePropertyById(Integer propertyId);
	
	/**
     * 查询范围属性列表
     * 
     * @param biScopeProperty 范围属性信息
     * @return 范围属性集合
     */
	public List<BiScopeProperty> selectBiScopePropertyList(BiScopeProperty biScopeProperty);
	
	/**
     * 新增范围属性
     * 
     * @param biScopeProperty 范围属性信息
     * @return 结果
     */
	public int insertBiScopeProperty(BiScopeProperty biScopeProperty);
	
	/**
     * 修改范围属性
     * 
     * @param biScopeProperty 范围属性信息
     * @return 结果
     */
	public int updateBiScopeProperty(BiScopeProperty biScopeProperty);
		
	/**
     * 删除范围属性信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopePropertyByIds(String ids);


    /**
     * 导入范围属性数据
     * @param biScopePropertyList
     * @return
     */
    public String importBiScopeProperty(List<BiScopeProperty> biScopePropertyList);
}
