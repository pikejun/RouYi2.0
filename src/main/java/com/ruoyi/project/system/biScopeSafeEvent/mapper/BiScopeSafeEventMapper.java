package com.ruoyi.project.system.biScopeSafeEvent.mapper;

import com.ruoyi.project.system.biScopeSafeEvent.domain.BiScopeSafeEvent;
import com.ruoyi.project.system.biScopeSafeEvent.vo.BiScopeSafeEventVO;

import java.util.List;
import java.util.Map;

/**
 * 安全事件 数据层
 *
 * @author ruoyi
 * @date 2019-04-04
 */
public interface BiScopeSafeEventMapper
{
	/**
     * 查询安全事件信息
     *
     * @param tid 安全事件ID
     * @return 安全事件信息
     */
	public BiScopeSafeEvent selectBiScopeSafeEventById(Integer tid);

	/**
     * 查询安全事件列表
     *
     * @param biScopeSafeEvent 安全事件信息
     * @return 安全事件集合
     */
	public List<BiScopeSafeEvent> selectBiScopeSafeEventList(BiScopeSafeEvent biScopeSafeEvent);

	/**
     * 新增安全事件
     *
     * @param biScopeSafeEvent 安全事件信息
     * @return 结果
     */
	public int insertBiScopeSafeEvent(BiScopeSafeEvent biScopeSafeEvent);

	/**
     * 修改安全事件
     *
     * @param biScopeSafeEvent 安全事件信息
     * @return 结果
     */
	public int updateBiScopeSafeEvent(BiScopeSafeEvent biScopeSafeEvent);

	/**
     * 删除安全事件
     *
     * @param tid 安全事件ID
     * @return 结果
     */
	public int deleteBiScopeSafeEventById(Integer tid);

	/**
     * 批量删除安全事件
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeSafeEventByIds(String[] tids);


	public int updateBiScopeSafeEventReadyToDeal(Map param);

	public int  updateBiScopeSafeEventToComplate(Map param);

	public int  updateBiScopeSafeEventToFailed(Map param);

	public List<BiScopeSafeEventVO> selectBiScopeSafeEventReadToDeal(Map param);

}