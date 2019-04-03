package com.ruoyi.project.system.biScopeAttendSpotData.mapper;

import com.ruoyi.project.system.biScopeAttendSpotData.domain.BiScopeAttendSpotData;
import com.ruoyi.project.system.biScopeAttendSpotData.vo.BiScopeAttendSpotDataVO;

import java.util.List;
import java.util.Map;

/**
 * 考勤点 数据层
 *
 * @author ruoyi
 * @date 2019-04-02
 */
public interface BiScopeAttendSpotDataMapper
{
	/**
     * 查询考勤点信息
     *
     * @param tid 考勤点ID
     * @return 考勤点信息
     */
	public BiScopeAttendSpotData selectBiScopeAttendSpotDataById(Integer tid);

	/**
     * 查询考勤点列表
     *
     * @param biScopeAttendSpotData 考勤点信息
     * @return 考勤点集合
     */
	public List<BiScopeAttendSpotData> selectBiScopeAttendSpotDataList(BiScopeAttendSpotData biScopeAttendSpotData);

	/**
     * 新增考勤点
     *
     * @param biScopeAttendSpotData 考勤点信息
     * @return 结果
     */
	public int insertBiScopeAttendSpotData(BiScopeAttendSpotData biScopeAttendSpotData);

	/**
     * 修改考勤点
     *
     * @param biScopeAttendSpotData 考勤点信息
     * @return 结果
     */
	public int updateBiScopeAttendSpotData(BiScopeAttendSpotData biScopeAttendSpotData);

	/**
     * 删除考勤点
     *
     * @param tid 考勤点ID
     * @return 结果
     */
	public int deleteBiScopeAttendSpotDataById(Integer tid);

	/**
     * 批量删除考勤点
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeAttendSpotDataByIds(String[] tids);

	public int updateBiScopeAttendSpotDataReadyToDeal(Map param);

	public int  updateBiScopeAttendSpotDataToComplate(Map param);

	public int  updateBiScopeAttendSpotDataToFailed(Map param);

	public List<BiScopeAttendSpotDataVO> selectBiScopeAttendSpotDataReadToDeal(Map param);

}