package com.ruoyi.project.system.biTemplateInfo.service;

import com.ruoyi.project.system.biTemplateInfo.domain.BiTemplateInfo;
import java.util.List;

/**
 * 模板数据 服务层
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public interface IBiTemplateInfoService 
{
	/**
     * 查询模板数据信息
     * 
     * @param templateId 模板数据ID
     * @return 模板数据信息
     */
	public BiTemplateInfo selectBiTemplateInfoById(Integer templateId);
	
	/**
     * 查询模板数据列表
     * 
     * @param biTemplateInfo 模板数据信息
     * @return 模板数据集合
     */
	public List<BiTemplateInfo> selectBiTemplateInfoList(BiTemplateInfo biTemplateInfo);
	
	/**
     * 新增模板数据
     * 
     * @param biTemplateInfo 模板数据信息
     * @return 结果
     */
	public int insertBiTemplateInfo(BiTemplateInfo biTemplateInfo);
	
	/**
     * 修改模板数据
     * 
     * @param biTemplateInfo 模板数据信息
     * @return 结果
     */
	public int updateBiTemplateInfo(BiTemplateInfo biTemplateInfo);
		
	/**
     * 删除模板数据信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiTemplateInfoByIds(String ids);


    /**
     * 导入模板数据数据
     * @param biTemplateInfoList
     * @return
     */
    public String importBiTemplateInfo(List<BiTemplateInfo> biTemplateInfoList);


	public String getTestContentByBiTemplateInfo(BiTemplateInfo biTemplateInfo);

	public void reportTemplateByTemplateNo(String templateNo);
}
