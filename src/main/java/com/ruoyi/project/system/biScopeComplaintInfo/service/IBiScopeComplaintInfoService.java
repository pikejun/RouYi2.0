package com.ruoyi.project.system.biScopeComplaintInfo.service;

import com.ruoyi.project.system.biScopeComplaintInfo.domain.BiScopeComplaintInfo;
import com.ruoyi.project.system.biScopeComplaintInfo.vo.BiScopeComplaintInfoVO;

import java.util.List;
import java.util.Map;

/**
 * 工人维权 服务层
 * 
 * @author ruoyi
 * @date 2019-04-11
 */
public interface IBiScopeComplaintInfoService 
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
     * 删除工人维权信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeComplaintInfoByIds(String ids);


    /**
     * 导入工人维权数据
     * @param biScopeComplaintInfoList
     * @return
     */
    public String importBiScopeComplaintInfo(List<BiScopeComplaintInfo> biScopeComplaintInfoList);

	public int updateBiScopeComplaintInfoReadyToDeal(Map param);

	public int  updateBiScopeComplaintInfoToComplate(Map param);

	public int  updateBiScopeComplaintInfoToFailed(Map param);

	public List<BiScopeComplaintInfoVO> selectBiScopeComplaintInfoReadToDeal(Map param);
}
