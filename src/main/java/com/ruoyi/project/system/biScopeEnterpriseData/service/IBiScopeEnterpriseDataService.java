package com.ruoyi.project.system.biScopeEnterpriseData.service;

import com.ruoyi.project.system.biScopeEnterpriseData.vo.BiScopeEnterpriseDataVO;
import com.ruoyi.project.system.biScopeEnterpriseData.domain.BiScopeEnterpriseData;
import java.util.List;
import java.util.Map;

/**
 * 企业数据 服务层
 * 
 * @author ruoyi
 * @date 2019-04-07
 */
public interface IBiScopeEnterpriseDataService 
{
	/**
     * 查询企业数据信息
     * 
     * @param tid 企业数据ID
     * @return 企业数据信息
     */
	public BiScopeEnterpriseData selectBiScopeEnterpriseDataById(Integer tid);
	
	/**
     * 查询企业数据列表
     * 
     * @param biScopeEnterpriseData 企业数据信息
     * @return 企业数据集合
     */
	public List<BiScopeEnterpriseData> selectBiScopeEnterpriseDataList(BiScopeEnterpriseData biScopeEnterpriseData);
	
	/**
     * 新增企业数据
     * 
     * @param biScopeEnterpriseData 企业数据信息
     * @return 结果
     */
	public int insertBiScopeEnterpriseData(BiScopeEnterpriseData biScopeEnterpriseData);
	
	/**
     * 修改企业数据
     * 
     * @param biScopeEnterpriseData 企业数据信息
     * @return 结果
     */
	public int updateBiScopeEnterpriseData(BiScopeEnterpriseData biScopeEnterpriseData);
		
	/**
     * 删除企业数据信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeEnterpriseDataByIds(String ids);


    /**
     * 导入企业数据数据
     * @param biScopeEnterpriseDataList
     * @return
     */
    public String importBiScopeEnterpriseData(List<BiScopeEnterpriseData> biScopeEnterpriseDataList);


	public int updateBiScopeEnterpriseDataReadyToDeal(Map param);

	public int  updateBiScopeEnterpriseDataToComplate(Map param);

	public int  updateBiScopeEnterpriseDataToFailed(Map param);

	public List<BiScopeEnterpriseDataVO> selectBiScopeEnterpriseDataReadToDeal(Map param);
}
