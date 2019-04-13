package com.ruoyi.project.system.biScopeComplaintInfo.mapper;

import com.ruoyi.project.system.biScopeComplaintInfo.domain.BiScopeComplaintInfo;
import com.ruoyi.project.system.biScopeComplaintInfo.vo.BiScopeComplaintInfoVO;

import java.util.List;
import java.util.Map;

/**
 * 工人维权 数据层
 *
 * @author ruoyi
 * @date 2019-04-11
 */
public interface BiScopeComplaintInfoMapper
{
	/**
     * 查询工人维权信息
     *
     * @param tid 工人维权ID
     * @return 工人维权信息
     */
	public BiScopeComplaintInfo selectBiScopeComplaintInfoById(Integer tid);

	/**
     * 查询工人维权列表
     *
     * @param biScopeComplaintInfo 工人维权信息
     * @return 工人维权集合
     */
	public List<BiScopeComplaintInfo> selectBiScopeComplaintInfoList(BiScopeComplaintInfo biScopeComplaintInfo);

	/**
     * 新增工人维权
     *
     * @param biScopeComplaintInfo 工人维权信息
     * @return 结果
     */
	public int insertBiScopeComplaintInfo(BiScopeComplaintInfo biScopeComplaintInfo);

	/**
     * 修改工人维权
     *
     * @param biScopeComplaintInfo 工人维权信息
     * @return 结果
     */
	public int updateBiScopeComplaintInfo(BiScopeComplaintInfo biScopeComplaintInfo);

	/**
     * 删除工人维权
     *
     * @param tid 工人维权ID
     * @return 结果
     */
	public int deleteBiScopeComplaintInfoById(Integer tid);

	/**
     * 批量删除工人维权
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeComplaintInfoByIds(String[] tids);

	public int updateBiScopeComplaintInfoReadyToDeal(Map param);

	public int  updateBiScopeComplaintInfoToComplate(Map param);

	public int  updateBiScopeComplaintInfoToFailed(Map param);

	public List<BiScopeComplaintInfoVO> selectBiScopeComplaintInfoReadToDeal(Map param);

}