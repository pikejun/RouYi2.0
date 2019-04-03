package com.ruoyi.project.system.biScopePersonData.service;

import com.ruoyi.project.system.biScopePersonData.domain.BiScopePersonData;
import com.ruoyi.project.system.biScopePersonData.vo.BiScopePersonDataVO;

import java.util.List;
import java.util.Map;

/**
 * 人员 服务层
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
public interface IBiScopePersonDataService 
{
	/**
     * 查询人员信息
     * 
     * @param tid 人员ID
     * @return 人员信息
     */
	public BiScopePersonData selectBiScopePersonDataById(Integer tid);
	
	/**
     * 查询人员列表
     * 
     * @param biScopePersonData 人员信息
     * @return 人员集合
     */
	public List<BiScopePersonData> selectBiScopePersonDataList(BiScopePersonData biScopePersonData);
	
	/**
     * 新增人员
     * 
     * @param biScopePersonData 人员信息
     * @return 结果
     */
	public int insertBiScopePersonData(BiScopePersonData biScopePersonData);
	
	/**
     * 修改人员
     * 
     * @param biScopePersonData 人员信息
     * @return 结果
     */
	public int updateBiScopePersonData(BiScopePersonData biScopePersonData);
		
	/**
     * 删除人员信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopePersonDataByIds(String ids);


    /**
     * 导入人员数据
     * @param biScopePersonDataList
     * @return
     */
    public String importBiScopePersonData(List<BiScopePersonData> biScopePersonDataList);
	
	
	public int updateBiScopePersonDataReadyToDeal(Map param);

	public int  updateBiScopePersonDataToComplate(Map param);

	public int  updateBiScopePersonDataToFailed(Map param);

	public List<BiScopePersonDataVO> selectBiScopePersonDataReadToDeal(Map param);
}
