package com.ruoyi.project.system.biScopeTrainInfo.service;

import com.ruoyi.project.system.biScopePersonData.vo.BiScopePersonDataVO;
import com.ruoyi.project.system.biScopeTrainInfo.domain.BiScopeTrainInfo;
import com.ruoyi.project.system.biScopeTrainInfo.vo.BiScopeTrainInfoVO;

import java.util.List;
import java.util.Map;

/**
 * 培训 服务层
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
public interface IBiScopeTrainInfoService 
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
     * 删除培训信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeTrainInfoByIds(String ids);


    /**
     * 导入培训数据
     * @param biScopeTrainInfoList
     * @return
     */
    public String importBiScopeTrainInfo(List<BiScopeTrainInfo> biScopeTrainInfoList);


	public int updateBiScopeTrainInfoReadyToDeal(Map param);

	public int  updateBiScopeTrainInfoToComplate(Map param);

	public int  updateBiScopeTrainInfoToFailed(Map param);

	public List<BiScopeTrainInfoVO> selectBiScopeTrainInfoReadToDeal(Map param);
}
