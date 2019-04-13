package com.ruoyi.project.system.biScopeComplaintLog.service;

import com.ruoyi.project.system.biScopeComplaintLog.vo.BiScopeComplaintLogVO;
import com.ruoyi.project.system.biScopeComplaintLog.domain.BiScopeComplaintLog;
import java.util.List;
import java.util.Map;

/**
 * 维权日志 服务层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface IBiScopeComplaintLogService 
{
	/**
     * 查询维权日志信息
     * 
     * @param tid 维权日志ID
     * @return 维权日志信息
     */
	public BiScopeComplaintLog selectBiScopeComplaintLogById(Integer tid);
	
	/**
     * 查询维权日志列表
     * 
     * @param biScopeComplaintLog 维权日志信息
     * @return 维权日志集合
     */
	public List<BiScopeComplaintLog> selectBiScopeComplaintLogList(BiScopeComplaintLog biScopeComplaintLog);
	
	/**
     * 新增维权日志
     * 
     * @param biScopeComplaintLog 维权日志信息
     * @return 结果
     */
	public int insertBiScopeComplaintLog(BiScopeComplaintLog biScopeComplaintLog);
	
	/**
     * 修改维权日志
     * 
     * @param biScopeComplaintLog 维权日志信息
     * @return 结果
     */
	public int updateBiScopeComplaintLog(BiScopeComplaintLog biScopeComplaintLog);
		
	/**
     * 删除维权日志信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeComplaintLogByIds(String ids);


    /**
     * 导入维权日志数据
     * @param biScopeComplaintLogList
     * @return
     */
    public String importBiScopeComplaintLog(List<BiScopeComplaintLog> biScopeComplaintLogList);

	public int updateBiScopeComplaintLogReadyToDeal(Map param);

	public int  updateBiScopeComplaintLogToComplate(Map param);

	public int  updateBiScopeComplaintLogToFailed(Map param);

	public List<BiScopeComplaintLogVO> selectBiScopeComplaintLogReadToDeal(Map param);
	
}
