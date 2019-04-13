package com.ruoyi.project.system.biScopeSectionData.service;

import com.ruoyi.project.system.biScopeSectionData.vo.BiScopeSectionDataVO;
import com.ruoyi.project.system.biScopeSectionData.domain.BiScopeSectionData;
import java.util.List;
import java.util.Map;

/**
 * 标段数据 服务层
 * 
 * @author ruoyi
 * @date 2019-04-10
 */
public interface IBiScopeSectionDataService 
{
	/**
     * 查询标段数据信息
     * 
     * @param tid 标段数据ID
     * @return 标段数据信息
     */
	public BiScopeSectionData selectBiScopeSectionDataById(Integer tid);
	
	/**
     * 查询标段数据列表
     * 
     * @param biScopeSectionData 标段数据信息
     * @return 标段数据集合
     */
	public List<BiScopeSectionData> selectBiScopeSectionDataList(BiScopeSectionData biScopeSectionData);
	
	/**
     * 新增标段数据
     * 
     * @param biScopeSectionData 标段数据信息
     * @return 结果
     */
	public int insertBiScopeSectionData(BiScopeSectionData biScopeSectionData);
	
	/**
     * 修改标段数据
     * 
     * @param biScopeSectionData 标段数据信息
     * @return 结果
     */
	public int updateBiScopeSectionData(BiScopeSectionData biScopeSectionData);
		
	/**
     * 删除标段数据信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeSectionDataByIds(String ids);


    /**
     * 导入标段数据数据
     * @param biScopeSectionDataList
     * @return
     */
    public String importBiScopeSectionData(List<BiScopeSectionData> biScopeSectionDataList);

	public int updateBiScopeSectionDataReadyToDeal(Map param);

	public int  updateBiScopeSectionDataToComplate(Map param);

	public int  updateBiScopeSectionDataToFailed(Map param);

	public List<BiScopeSectionDataVO> selectBiScopeSectionDataReadToDeal(Map param);
}
