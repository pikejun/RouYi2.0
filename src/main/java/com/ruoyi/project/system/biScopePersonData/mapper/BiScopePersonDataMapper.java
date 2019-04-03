package com.ruoyi.project.system.biScopePersonData.mapper;

import com.ruoyi.project.system.biScopePersonData.domain.BiScopePersonData;
import com.ruoyi.project.system.biScopePersonData.vo.BiScopePersonDataVO;

import java.util.List;
import java.util.Map;

/**
 * 人员 数据层
 *
 * @author ruoyi
 * @date 2019-04-02
 */
public interface BiScopePersonDataMapper
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
     * 删除人员
     *
     * @param tid 人员ID
     * @return 结果
     */
	public int deleteBiScopePersonDataById(Integer tid);

	/**
     * 批量删除人员
     *
     * @param tids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopePersonDataByIds(String[] tids);
	
	public int updateBiScopePersonDataReadyToDeal(Map param);

	public int  updateBiScopePersonDataToComplate(Map param);

	public int  updateBiScopePersonDataToFailed(Map param);

	public List<BiScopePersonDataVO> selectBiScopePersonDataReadToDeal(Map param);

}