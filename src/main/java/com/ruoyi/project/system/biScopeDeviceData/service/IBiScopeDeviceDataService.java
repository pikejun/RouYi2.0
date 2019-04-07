package com.ruoyi.project.system.biScopeDeviceData.service;

import com.ruoyi.project.system.biScopeDeviceData.vo.BiScopeDeviceDataVO;
import com.ruoyi.project.system.biScopeDeviceData.domain.BiScopeDeviceData;
import java.util.List;
import java.util.Map;

/**
 * 设备数据 服务层
 * 
 * @author ruoyi
 * @date 2019-04-07
 */
public interface IBiScopeDeviceDataService 
{
	/**
     * 查询设备数据信息
     * 
     * @param tid 设备数据ID
     * @return 设备数据信息
     */
	public BiScopeDeviceData selectBiScopeDeviceDataById(Integer tid);
	
	/**
     * 查询设备数据列表
     * 
     * @param biScopeDeviceData 设备数据信息
     * @return 设备数据集合
     */
	public List<BiScopeDeviceData> selectBiScopeDeviceDataList(BiScopeDeviceData biScopeDeviceData);
	
	/**
     * 新增设备数据
     * 
     * @param biScopeDeviceData 设备数据信息
     * @return 结果
     */
	public int insertBiScopeDeviceData(BiScopeDeviceData biScopeDeviceData);
	
	/**
     * 修改设备数据
     * 
     * @param biScopeDeviceData 设备数据信息
     * @return 结果
     */
	public int updateBiScopeDeviceData(BiScopeDeviceData biScopeDeviceData);
		
	/**
     * 删除设备数据信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeDeviceDataByIds(String ids);


    /**
     * 导入设备数据数据
     * @param biScopeDeviceDataList
     * @return
     */
    public String importBiScopeDeviceData(List<BiScopeDeviceData> biScopeDeviceDataList);


	public int updateBiScopeDeviceDataReadyToDeal(Map param);

	public int  updateBiScopeDeviceDataToComplate(Map param);

	public int  updateBiScopeDeviceDataToFailed(Map param);

	public List<BiScopeDeviceDataVO> selectBiScopeDeviceDataReadToDeal(Map param);
}
