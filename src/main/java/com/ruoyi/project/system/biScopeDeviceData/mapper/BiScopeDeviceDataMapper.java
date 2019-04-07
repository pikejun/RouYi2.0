package com.ruoyi.project.system.biScopeDeviceData.mapper;

import com.ruoyi.project.system.biScopeDeviceData.domain.BiScopeDeviceData;
import com.ruoyi.project.system.biScopeDeviceData.vo.BiScopeDeviceDataVO;

import java.util.List;
import java.util.Map;

/**
 * 设备数据 数据层
 *
 * @author ruoyi
 * @date 2019-04-07
 */
public interface BiScopeDeviceDataMapper
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
     * 删除设备数据
     *
     * @param tid 设备数据ID
     * @return 结果
     */
	public int deleteBiScopeDeviceDataById(Integer tid);

	/**
     * 批量删除设备数据
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeDeviceDataByIds(String[] tids);


	public int updateBiScopeDeviceDataReadyToDeal(Map param);

	public int  updateBiScopeDeviceDataToComplate(Map param);

	public int  updateBiScopeDeviceDataToFailed(Map param);

	public List<BiScopeDeviceDataVO> selectBiScopeDeviceDataReadToDeal(Map param);

}