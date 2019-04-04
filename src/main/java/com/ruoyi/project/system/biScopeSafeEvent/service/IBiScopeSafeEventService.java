package com.ruoyi.project.system.biScopeSafeEvent.service;

import com.ruoyi.project.system.biScopeSafeEvent.vo.BiScopeSafeEventVO;
import com.ruoyi.project.system.biScopeSafeEvent.domain.BiScopeSafeEvent;
import java.util.List;
import java.util.Map;

/**
 * 安全事件 服务层
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
public interface IBiScopeSafeEventService 
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
     * 删除安全事件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeSafeEventByIds(String ids);


    /**
     * 导入安全事件数据
     * @param biScopeSafeEventList
     * @return
     */
    public String importBiScopeSafeEvent(List<BiScopeSafeEvent> biScopeSafeEventList);

	public int updateBiScopeSafeEventReadyToDeal(Map param);

	public int  updateBiScopeSafeEventToComplate(Map param);

	public int  updateBiScopeSafeEventToFailed(Map param);

	public List<BiScopeSafeEventVO> selectBiScopeSafeEventReadToDeal(Map param);
}
