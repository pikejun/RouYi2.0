package com.ruoyi.project.system.biScopeRealName.service;

import com.ruoyi.project.system.biScopeRealName.vo.BiScopeRealNameVO;
import com.ruoyi.project.system.biScopeRealName.domain.BiScopeRealName;
import com.ruoyi.project.system.biScopeRealName.vo.BiScopeRealNameVO;

import java.util.List;
import java.util.Map;

/**
 * 人员 服务层
 * 
 * @author ruoyi
 * @date 2019-04-11
 */
public interface IBiScopeRealNameService 
{
	/**
     * 查询人员信息
     * 
     * @param tid 人员ID
     * @return 人员信息
     */
	public BiScopeRealName selectBiScopeRealNameById(Integer tid);
	
	/**
     * 查询人员列表
     * 
     * @param biScopeRealName 人员信息
     * @return 人员集合
     */
	public List<BiScopeRealName> selectBiScopeRealNameList(BiScopeRealName biScopeRealName);
	
	/**
     * 新增人员
     * 
     * @param biScopeRealName 人员信息
     * @return 结果
     */
	public int insertBiScopeRealName(BiScopeRealName biScopeRealName);
	
	/**
     * 修改人员
     * 
     * @param biScopeRealName 人员信息
     * @return 结果
     */
	public int updateBiScopeRealName(BiScopeRealName biScopeRealName);
		
	/**
     * 删除人员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeRealNameByIds(String ids);


    /**
     * 导入人员数据
     * @param biScopeRealNameList
     * @return
     */
    public String importBiScopeRealName(List<BiScopeRealName> biScopeRealNameList);


	public int updateBiScopeRealNameReadyToDeal(Map param);

	public int  updateBiScopeRealNameToComplate(Map param);

	public int  updateBiScopeRealNameToFailed(Map param);

	public List<BiScopeRealNameVO> selectBiScopeRealNameReadToDeal(Map param);
}
