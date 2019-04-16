package com.ruoyi.project.system.biIndexField.service;

import com.ruoyi.project.system.biIndexField.domain.BiIndexField;
import java.util.List;

/**
 * 指标字段明细 服务层
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public interface IBiIndexFieldService 
{
	/**
     * 查询指标字段明细信息
     * 
     * @param fieldId 指标字段明细ID
     * @return 指标字段明细信息
     */
	public BiIndexField selectBiIndexFieldById(Integer fieldId);
	
	/**
     * 查询指标字段明细列表
     * 
     * @param biIndexField 指标字段明细信息
     * @return 指标字段明细集合
     */
	public List<BiIndexField> selectBiIndexFieldList(BiIndexField biIndexField);
	
	/**
     * 新增指标字段明细
     * 
     * @param biIndexField 指标字段明细信息
     * @return 结果
     */
	public int insertBiIndexField(BiIndexField biIndexField);
	
	/**
     * 修改指标字段明细
     * 
     * @param biIndexField 指标字段明细信息
     * @return 结果
     */
	public int updateBiIndexField(BiIndexField biIndexField);
		
	/**
     * 删除指标字段明细信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiIndexFieldByIds(String ids);


    /**
     * 导入指标字段明细数据
     * @param biIndexFieldList
     * @return
     */
    public String importBiIndexField(List<BiIndexField> biIndexFieldList);
}
