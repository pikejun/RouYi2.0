package com.ruoyi.project.system.biScopeTrainAttach.mapper;

import com.ruoyi.project.system.biScopeTrainAttach.domain.BiScopeTrainAttach;
import com.ruoyi.project.system.biScopeTrainAttach.vo.BiScopeTrainAttachVO;

import java.util.List;
import java.util.Map;

/**
 * 培训附件 数据层
 *
 * @author ruoyi
 * @date 2019-04-12
 */
public interface BiScopeTrainAttachMapper
{
	/**
     * 查询培训附件信息
     *
     * @param tid 培训附件ID
     * @return 培训附件信息
     */
	public BiScopeTrainAttach selectBiScopeTrainAttachById(Integer tid);

	/**
     * 查询培训附件列表
     *
     * @param biScopeTrainAttach 培训附件信息
     * @return 培训附件集合
     */
	public List<BiScopeTrainAttach> selectBiScopeTrainAttachList(BiScopeTrainAttach biScopeTrainAttach);

	/**
     * 新增培训附件
     *
     * @param biScopeTrainAttach 培训附件信息
     * @return 结果
     */
	public int insertBiScopeTrainAttach(BiScopeTrainAttach biScopeTrainAttach);

	/**
     * 修改培训附件
     *
     * @param biScopeTrainAttach 培训附件信息
     * @return 结果
     */
	public int updateBiScopeTrainAttach(BiScopeTrainAttach biScopeTrainAttach);

	/**
     * 删除培训附件
     *
     * @param tid 培训附件ID
     * @return 结果
     */
	public int deleteBiScopeTrainAttachById(Integer tid);

	/**
     * 批量删除培训附件
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeTrainAttachByIds(String[] tids);


	public int updateBiScopeTrainAttachReadyToDeal(Map param);

	public int  updateBiScopeTrainAttachToComplate(Map param);

	public int  updateBiScopeTrainAttachToFailed(Map param);

	public List<BiScopeTrainAttachVO> selectBiScopeTrainAttachReadToDeal(Map param);

}