package com.ruoyi.project.system.biScopeTrainImage.service;

import com.ruoyi.project.system.biScopeTrainImage.vo.BiScopeTrainImageVO;
import com.ruoyi.project.system.biScopeTrainImage.domain.BiScopeTrainImage;
import java.util.List;
import java.util.Map;

/**
 * 培训图片 服务层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface IBiScopeTrainImageService 
{
	/**
     * 查询培训图片信息
     * 
     * @param tid 培训图片ID
     * @return 培训图片信息
     */
	public BiScopeTrainImage selectBiScopeTrainImageById(Integer tid);
	
	/**
     * 查询培训图片列表
     * 
     * @param biScopeTrainImage 培训图片信息
     * @return 培训图片集合
     */
	public List<BiScopeTrainImage> selectBiScopeTrainImageList(BiScopeTrainImage biScopeTrainImage);
	
	/**
     * 新增培训图片
     * 
     * @param biScopeTrainImage 培训图片信息
     * @return 结果
     */
	public int insertBiScopeTrainImage(BiScopeTrainImage biScopeTrainImage);
	
	/**
     * 修改培训图片
     * 
     * @param biScopeTrainImage 培训图片信息
     * @return 结果
     */
	public int updateBiScopeTrainImage(BiScopeTrainImage biScopeTrainImage);
		
	/**
     * 删除培训图片信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeTrainImageByIds(String ids);


    /**
     * 导入培训图片数据
     * @param biScopeTrainImageList
     * @return
     */
    public String importBiScopeTrainImage(List<BiScopeTrainImage> biScopeTrainImageList); 


	public int updateBiScopeTrainImageReadyToDeal(Map param);

	public int  updateBiScopeTrainImageToComplate(Map param);

	public int  updateBiScopeTrainImageToFailed(Map param);

	public List<BiScopeTrainImageVO> selectBiScopeTrainImageReadToDeal(Map param);
}
