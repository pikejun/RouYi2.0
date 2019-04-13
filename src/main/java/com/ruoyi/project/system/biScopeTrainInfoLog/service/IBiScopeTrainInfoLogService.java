package com.ruoyi.project.system.biScopeTrainInfoLog.service;

import com.ruoyi.project.system.biScopeTrainInfoLog.vo.BiScopeTrainInfoLogVO;
import com.ruoyi.project.system.biScopeTrainInfoLog.domain.BiScopeTrainInfoLog;
import java.util.List;
import java.util.Map;

/**
 * 工人培训日志 服务层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface IBiScopeTrainInfoLogService 
{
	/**
     * 查询工人培训日志信息
     * 
     * @param tid 工人培训日志ID
     * @return 工人培训日志信息
     */
	public BiScopeTrainInfoLog selectBiScopeTrainInfoLogById(Integer tid);
	
	/**
     * 查询工人培训日志列表
     * 
     * @param biScopeTrainInfoLog 工人培训日志信息
     * @return 工人培训日志集合
     */
	public List<BiScopeTrainInfoLog> selectBiScopeTrainInfoLogList(BiScopeTrainInfoLog biScopeTrainInfoLog);
	
	/**
     * 新增工人培训日志
     * 
     * @param biScopeTrainInfoLog 工人培训日志信息
     * @return 结果
     */
	public int insertBiScopeTrainInfoLog(BiScopeTrainInfoLog biScopeTrainInfoLog);
	
	/**
     * 修改工人培训日志
     * 
     * @param biScopeTrainInfoLog 工人培训日志信息
     * @return 结果
     */
	public int updateBiScopeTrainInfoLog(BiScopeTrainInfoLog biScopeTrainInfoLog);
		
	/**
     * 删除工人培训日志信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeTrainInfoLogByIds(String ids);


    /**
     * 导入工人培训日志数据
     * @param biScopeTrainInfoLogList
     * @return
     */
    public String importBiScopeTrainInfoLog(List<BiScopeTrainInfoLog> biScopeTrainInfoLogList);


	public int updateBiScopeTrainInfoLogReadyToDeal(Map param);

	public int  updateBiScopeTrainInfoLogToComplate(Map param);

	public int  updateBiScopeTrainInfoLogToFailed(Map param);

	public List<BiScopeTrainInfoLogVO> selectBiScopeTrainInfoLogReadToDeal(Map param);
}
