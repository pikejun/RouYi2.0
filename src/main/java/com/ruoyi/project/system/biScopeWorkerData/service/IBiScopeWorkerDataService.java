package com.ruoyi.project.system.biScopeWorkerData.service;

import com.ruoyi.project.system.biScopeWorkerData.domain.BiScopeWorkerData;
import com.ruoyi.project.system.biScopeWorkerData.vo.BiScopeWorkerDataVO;

import java.util.List;
import java.util.Map;

/**
 * 工人数据 服务层
 * 
 * @author ruoyi
 * @date 2019-04-11
 */
public interface IBiScopeWorkerDataService 
{
	/**
     * 查询工人数据信息
     * 
     * @param tid 工人数据ID
     * @return 工人数据信息
     */
	public BiScopeWorkerData selectBiScopeWorkerDataById(Integer tid);
	
	/**
     * 查询工人数据列表
     * 
     * @param biScopeWorkerData 工人数据信息
     * @return 工人数据集合
     */
	public List<BiScopeWorkerData> selectBiScopeWorkerDataList(BiScopeWorkerData biScopeWorkerData);
	
	/**
     * 新增工人数据
     * 
     * @param biScopeWorkerData 工人数据信息
     * @return 结果
     */
	public int insertBiScopeWorkerData(BiScopeWorkerData biScopeWorkerData);
	
	/**
     * 修改工人数据
     * 
     * @param biScopeWorkerData 工人数据信息
     * @return 结果
     */
	public int updateBiScopeWorkerData(BiScopeWorkerData biScopeWorkerData);
		
	/**
     * 删除工人数据信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeWorkerDataByIds(String ids);


    /**
     * 导入工人数据数据
     * @param biScopeWorkerDataList
     * @return
     */
    public String importBiScopeWorkerData(List<BiScopeWorkerData> biScopeWorkerDataList);

	public int updateBiScopeWorkerDataReadyToDeal(Map param);

	public int  updateBiScopeWorkerDataToComplate(Map param);

	public int  updateBiScopeWorkerDataToFailed(Map param);

	public List<BiScopeWorkerDataVO> selectBiScopeWorkerDataReadToDeal(Map param);
}
