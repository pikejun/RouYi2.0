package com.ruoyi.project.system.biScopeProjectData.service;

import com.ruoyi.project.system.biScopeProjectData.vo.BiScopeProjectDataVO;
import com.ruoyi.project.system.biScopeProjectData.domain.BiScopeProjectData;
import java.util.List;
import java.util.Map;

/**
 * 项目数据 服务层
 * 
 * @author ruoyi
 * @date 2019-04-09
 */
public interface IBiScopeProjectDataService 
{
	/**
     * 查询项目数据信息
     * 
     * @param tid 项目数据ID
     * @return 项目数据信息
     */
	public BiScopeProjectData selectBiScopeProjectDataById(Integer tid);
	
	/**
     * 查询项目数据列表
     * 
     * @param biScopeProjectData 项目数据信息
     * @return 项目数据集合
     */
	public List<BiScopeProjectData> selectBiScopeProjectDataList(BiScopeProjectData biScopeProjectData);
	
	/**
     * 新增项目数据
     * 
     * @param biScopeProjectData 项目数据信息
     * @return 结果
     */
	public int insertBiScopeProjectData(BiScopeProjectData biScopeProjectData);
	
	/**
     * 修改项目数据
     * 
     * @param biScopeProjectData 项目数据信息
     * @return 结果
     */
	public int updateBiScopeProjectData(BiScopeProjectData biScopeProjectData);
		
	/**
     * 删除项目数据信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeProjectDataByIds(String ids);


    /**
     * 导入项目数据数据
     * @param biScopeProjectDataList
     * @return
     */
    public String importBiScopeProjectData(List<BiScopeProjectData> biScopeProjectDataList);


	public int updateBiScopeProjectDataReadyToDeal(Map param);

	public int  updateBiScopeProjectDataToComplate(Map param);

	public int  updateBiScopeProjectDataToFailed(Map param);

	public List<BiScopeProjectDataVO> selectBiScopeProjectDataReadToDeal(Map param);
}