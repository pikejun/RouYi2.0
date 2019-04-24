package com.ruoyi.project.system.biScopeGroupOwner.service;

import com.ruoyi.project.system.biScopeGroupOwner.domain.BiScopeGroupOwner;
import com.ruoyi.project.system.biScopeGroupOwner.vo.BiScopeGroupOwnerVO;

import java.util.List;
import java.util.Map;

/**
 * 班组长 服务层
 * 
 * @author ruoyi
 * @date 2019-04-23
 */
public interface IBiScopeGroupOwnerService 
{
	/**
     * 查询班组长信息
     * 
     * @param tid 班组长ID
     * @return 班组长信息
     */
	public BiScopeGroupOwner selectBiScopeGroupOwnerById(Integer tid);
	
	/**
     * 查询班组长列表
     * 
     * @param biScopeGroupOwner 班组长信息
     * @return 班组长集合
     */
	public List<BiScopeGroupOwner> selectBiScopeGroupOwnerList(BiScopeGroupOwner biScopeGroupOwner);
	
	/**
     * 新增班组长
     * 
     * @param biScopeGroupOwner 班组长信息
     * @return 结果
     */
	public int insertBiScopeGroupOwner(BiScopeGroupOwner biScopeGroupOwner);
	
	/**
     * 修改班组长
     * 
     * @param biScopeGroupOwner 班组长信息
     * @return 结果
     */
	public int updateBiScopeGroupOwner(BiScopeGroupOwner biScopeGroupOwner);
		
	/**
     * 删除班组长信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeGroupOwnerByIds(String ids);


    /**
     * 导入班组长数据
     * @param biScopeGroupOwnerList
     * @return
     */
    public String importBiScopeGroupOwner(List<BiScopeGroupOwner> biScopeGroupOwnerList);

	public int updateBiScopeGroupOwnerReadyToDeal(Map param);

	public int  updateBiScopeGroupOwnerToComplate(Map param);

	public int  updateBiScopeGroupOwnerToFailed(Map param);

	public List<BiScopeGroupOwnerVO> selectBiScopeGroupOwnerReadToDeal(Map param);
}
