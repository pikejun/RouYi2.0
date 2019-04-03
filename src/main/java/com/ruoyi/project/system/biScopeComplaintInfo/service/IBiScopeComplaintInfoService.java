package com.ruoyi.project.system.biScopeComplaintInfo.service;

import com.ruoyi.project.system.biScopeComplaintInfo.vo.BiScopeComplaintInfoVO;
import com.ruoyi.project.system.biScopeComplaintInfo.domain.BiScopeComplaintInfo;
import java.util.List;
import java.util.Map;

/**
 * 维权 服务层
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
public interface IBiScopeComplaintInfoService 
{
	/**
     * 查询维权信息
     * 
     * @param tid 维权ID
     * @return 维权信息
     */
	public BiScopeComplaintInfo selectBiScopeComplaintInfoById(Integer tid);
	
	/**
     * 查询维权列表
     * 
     * @param biScopeComplaintInfo 维权信息
     * @return 维权集合
     */
	public List<BiScopeComplaintInfo> selectBiScopeComplaintInfoList(BiScopeComplaintInfo biScopeComplaintInfo);
	
	/**
     * 新增维权
     * 
     * @param biScopeComplaintInfo 维权信息
     * @return 结果
     */
	public int insertBiScopeComplaintInfo(BiScopeComplaintInfo biScopeComplaintInfo);
	
	/**
     * 修改维权
     * 
     * @param biScopeComplaintInfo 维权信息
     * @return 结果
     */
	public int updateBiScopeComplaintInfo(BiScopeComplaintInfo biScopeComplaintInfo);
		
	/**
     * 删除维权信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeComplaintInfoByIds(String ids);


    /**
     * 导入维权数据
     * @param biScopeComplaintInfoList
     * @return
     */
    public String importBiScopeComplaintInfo(List<BiScopeComplaintInfo> biScopeComplaintInfoList);

	public int updateBiScopeComplaintInfoReadyToDeal(Map param);

	public int  updateBiScopeComplaintInfoToComplate(Map param);

	public int  updateBiScopeComplaintInfoToFailed(Map param);

	public List<BiScopeComplaintInfoVO> selectBiScopeComplaintInfoReadToDeal(Map param);
}
