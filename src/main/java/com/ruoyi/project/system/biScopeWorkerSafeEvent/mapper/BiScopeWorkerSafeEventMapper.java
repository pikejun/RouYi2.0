package com.ruoyi.project.system.biScopeWorkerSafeEvent.mapper;

import com.ruoyi.project.system.biScopeWorkerSafeEvent.domain.BiScopeWorkerSafeEvent;
import com.ruoyi.project.system.biScopeWorkerSafeEvent.vo.BiScopeWorkerSafeEventVO;

import java.util.List;
import java.util.Map;

/**
 * 工人安全事件 数据层
 *
 * @author ruoyi
 * @date 2019-04-12
 */
public interface BiScopeWorkerSafeEventMapper
{
	/**
     * 查询工人安全事件信息
     *
     * @param tid 工人安全事件ID
     * @return 工人安全事件信息
     */
	public BiScopeWorkerSafeEvent selectBiScopeWorkerSafeEventById(Integer tid);

	/**
     * 查询工人安全事件列表
     *
     * @param biScopeWorkerSafeEvent 工人安全事件信息
     * @return 工人安全事件集合
     */
	public List<BiScopeWorkerSafeEvent> selectBiScopeWorkerSafeEventList(BiScopeWorkerSafeEvent biScopeWorkerSafeEvent);

	/**
     * 新增工人安全事件
     *
     * @param biScopeWorkerSafeEvent 工人安全事件信息
     * @return 结果
     */
	public int insertBiScopeWorkerSafeEvent(BiScopeWorkerSafeEvent biScopeWorkerSafeEvent);

	/**
     * 修改工人安全事件
     *
     * @param biScopeWorkerSafeEvent 工人安全事件信息
     * @return 结果
     */
	public int updateBiScopeWorkerSafeEvent(BiScopeWorkerSafeEvent biScopeWorkerSafeEvent);

	/**
     * 删除工人安全事件
     *
     * @param tid 工人安全事件ID
     * @return 结果
     */
	public int deleteBiScopeWorkerSafeEventById(Integer tid);

	/**
     * 批量删除工人安全事件
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeWorkerSafeEventByIds(String[] tids);


	public int updateBiScopeWorkerSafeEventReadyToDeal(Map param);

	public int  updateBiScopeWorkerSafeEventToComplate(Map param);

	public int  updateBiScopeWorkerSafeEventToFailed(Map param);

	public List<BiScopeWorkerSafeEventVO> selectBiScopeWorkerSafeEventReadToDeal(Map param);

}