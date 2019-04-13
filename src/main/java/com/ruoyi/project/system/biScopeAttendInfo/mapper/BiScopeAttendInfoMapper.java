package com.ruoyi.project.system.biScopeAttendInfo.mapper;

import com.ruoyi.project.system.biScopeAttendInfo.domain.BiScopeAttendInfo;
import com.ruoyi.project.system.biScopeAttendInfo.vo.BiScopeAttendInfoVO;

import java.util.List;
import java.util.Map;

/**
 * 考勤 数据层
 *
 * @author ruoyi
 * @date 2019-04-11
 */
public interface BiScopeAttendInfoMapper
{
	/**
     * 查询考勤信息
     *
     * @param tid 考勤ID
     * @return 考勤信息
     */
	public BiScopeAttendInfo selectBiScopeAttendInfoById(Integer tid);

	/**
     * 查询考勤列表
     *
     * @param biScopeAttendInfo 考勤信息
     * @return 考勤集合
     */
	public List<BiScopeAttendInfo> selectBiScopeAttendInfoList(BiScopeAttendInfo biScopeAttendInfo);

	/**
     * 新增考勤
     *
     * @param biScopeAttendInfo 考勤信息
     * @return 结果
     */
	public int insertBiScopeAttendInfo(BiScopeAttendInfo biScopeAttendInfo);

	/**
     * 修改考勤
     *
     * @param biScopeAttendInfo 考勤信息
     * @return 结果
     */
	public int updateBiScopeAttendInfo(BiScopeAttendInfo biScopeAttendInfo);

	/**
     * 删除考勤
     *
     * @param tid 考勤ID
     * @return 结果
     */
	public int deleteBiScopeAttendInfoById(Integer tid);

	/**
     * 批量删除考勤
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeAttendInfoByIds(String[] tids);


	public int updateBiScopeAttendInfoReadyToDeal(Map param);

	public int  updateBiScopeAttendInfoToComplate(Map param);

	public int  updateBiScopeAttendInfoToFailed(Map param);

	public List<BiScopeAttendInfoVO> selectBiScopeAttendInfoReadToDeal(Map param);

}