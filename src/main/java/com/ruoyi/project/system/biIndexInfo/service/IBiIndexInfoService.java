package com.ruoyi.project.system.biIndexInfo.service;

import com.ruoyi.project.system.biIndexInfo.domain.BiIndexInfo;
import java.util.List;

/**
 * 指标 服务层
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public interface IBiIndexInfoService 
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
     * 删除指标信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiIndexInfoByIds(String ids);


    /**
     * 导入指标数据
     * @param biIndexInfoList
     * @return
     */
    public String importBiIndexInfo(List<BiIndexInfo> biIndexInfoList);
}
