package com.ruoyi.project.system.biScopeTrainInfo.mapper;

import com.ruoyi.project.system.biScopeTrainInfo.domain.BiScopeTrainInfo;
import com.ruoyi.project.system.biScopeTrainInfo.vo.BiScopeTrainInfoVO;

import java.util.List;
import java.util.Map;

/**
 * 培训 数据层
 *
 * @author ruoyi
 * @date 2019-04-03
 */
public interface BiScopeTrainInfoMapper
{
	/**
     * 查询培训信息
     *
     * @param tid 培训ID
     * @return 培训信息
     */
	public BiScopeTrainInfo selectBiScopeTrainInfoById(Integer tid);

	/**
     * 查询培训列表
     *
     * @param biScopeTrainInfo 培训信息
     * @return 培训集合
     */
	public List<BiScopeTrainInfo> selectBiScopeTrainInfoList(BiScopeTrainInfo biScopeTrainInfo);

	/**
     * 新增培训
     *
     * @param biScopeTrainInfo 培训信息
     * @return 结果
     */
	public int insertBiScopeTrainInfo(BiScopeTrainInfo biScopeTrainInfo);

	/**
     * 修改培训
     *
     * @param biScopeTrainInfo 培训信息
     * @return 结果
     */
	public int updateBiScopeTrainInfo(BiScopeTrainInfo biScopeTrainInfo);

	/**
     * 删除培训
     *
     * @param tid 培训ID
     * @return 结果
     */
	public int deleteBiScopeTrainInfoById(Integer tid);

	/**
     * 批量删除培训
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeTrainInfoByIds(String[] tids);

	public int updateBiScopeTrainInfoReadyToDeal(Map param);

	public int  updateBiScopeTrainInfoToComplate(Map param);

	public int  updateBiScopeTrainInfoToFailed(Map param);

	public List<BiScopeTrainInfoVO> selectBiScopeTrainInfoReadToDeal(Map param);

}