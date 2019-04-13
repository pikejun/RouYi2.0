package com.ruoyi.project.system.biScopeComplaintLogAttach.mapper;

import com.ruoyi.project.system.biScopeComplaintLogAttach.domain.BiScopeComplaintLogAttach;
import com.ruoyi.project.system.biScopeComplaintLogAttach.vo.BiScopeComplaintLogAttachVO;

import java.util.List;
import java.util.Map;

/**
 * 维权日志附件 数据层
 *
 * @author ruoyi
 * @date 2019-04-12
 */
public interface BiScopeComplaintLogAttachMapper
{
	/**
     * 查询维权日志附件信息
     *
     * @param tid 维权日志附件ID
     * @return 维权日志附件信息
     */
	public BiScopeComplaintLogAttach selectBiScopeComplaintLogAttachById(Integer tid);

	/**
     * 查询维权日志附件列表
     *
     * @param biScopeComplaintLogAttach 维权日志附件信息
     * @return 维权日志附件集合
     */
	public List<BiScopeComplaintLogAttach> selectBiScopeComplaintLogAttachList(BiScopeComplaintLogAttach biScopeComplaintLogAttach);

	/**
     * 新增维权日志附件
     *
     * @param biScopeComplaintLogAttach 维权日志附件信息
     * @return 结果
     */
	public int insertBiScopeComplaintLogAttach(BiScopeComplaintLogAttach biScopeComplaintLogAttach);

	/**
     * 修改维权日志附件
     *
     * @param biScopeComplaintLogAttach 维权日志附件信息
     * @return 结果
     */
	public int updateBiScopeComplaintLogAttach(BiScopeComplaintLogAttach biScopeComplaintLogAttach);

	/**
     * 删除维权日志附件
     *
     * @param tid 维权日志附件ID
     * @return 结果
     */
	public int deleteBiScopeComplaintLogAttachById(Integer tid);

	/**
     * 批量删除维权日志附件
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeComplaintLogAttachByIds(String[] tids);

	public int updateBiScopeComplaintLogAttachReadyToDeal(Map param);

	public int  updateBiScopeComplaintLogAttachToComplate(Map param);

	public int  updateBiScopeComplaintLogAttachToFailed(Map param);

	public List<BiScopeComplaintLogAttachVO> selectBiScopeComplaintLogAttachReadToDeal(Map param);

}