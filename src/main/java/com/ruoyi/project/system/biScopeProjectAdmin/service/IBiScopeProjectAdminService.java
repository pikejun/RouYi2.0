package com.ruoyi.project.system.biScopeProjectAdmin.service;

import com.ruoyi.project.system.biScopeProjectAdmin.domain.BiScopeProjectAdmin;
import com.ruoyi.project.system.biScopeProjectAdmin.vo.BiScopeProjectAdminVO;

import java.util.List;
import java.util.Map;

/**
 * 项目管理员 服务层
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
public interface IBiScopeProjectAdminService 
{
	/**
     * 查询项目管理员信息
     * 
     * @param tid 项目管理员ID
     * @return 项目管理员信息
     */
	public BiScopeProjectAdmin selectBiScopeProjectAdminById(Integer tid);
	
	/**
     * 查询项目管理员列表
     * 
     * @param biScopeProjectAdmin 项目管理员信息
     * @return 项目管理员集合
     */
	public List<BiScopeProjectAdmin> selectBiScopeProjectAdminList(BiScopeProjectAdmin biScopeProjectAdmin);
	
	/**
     * 新增项目管理员
     * 
     * @param biScopeProjectAdmin 项目管理员信息
     * @return 结果
     */
	public int insertBiScopeProjectAdmin(BiScopeProjectAdmin biScopeProjectAdmin);
	
	/**
     * 修改项目管理员
     * 
     * @param biScopeProjectAdmin 项目管理员信息
     * @return 结果
     */
	public int updateBiScopeProjectAdmin(BiScopeProjectAdmin biScopeProjectAdmin);
		
	/**
     * 删除项目管理员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeProjectAdminByIds(String ids);


    /**
     * 导入项目管理员数据
     * @param biScopeProjectAdminList
     * @return
     */
    public String importBiScopeProjectAdmin(List<BiScopeProjectAdmin> biScopeProjectAdminList);


	public int updateBiScopeProjectAdminReadyToDeal(Map param);

	public int  updateBiScopeProjectAdminToComplate(Map param);

	public int  updateBiScopeProjectAdminToFailed(Map param);

	public List<BiScopeProjectAdminVO> selectBiScopeProjectAdminReadToDeal(Map param);
}
