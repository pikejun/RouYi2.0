package com.ruoyi.project.system.biScopeTrainAttach.service;

import com.ruoyi.project.system.biScopeTrainAttach.vo.BiScopeTrainAttachVO;
import com.ruoyi.project.system.biScopeTrainAttach.domain.BiScopeTrainAttach;
import java.util.List;
import java.util.Map;

/**
 * 培训附件 服务层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface IBiScopeTrainAttachService 
{
	/**
     * 查询培训附件信息
     * 
     * @param tid 培训附件ID
     * @return 培训附件信息
     */
	public BiScopeTrainAttach selectBiScopeTrainAttachById(Integer tid);
	
	/**
     * 查询培训附件列表
     * 
     * @param biScopeTrainAttach 培训附件信息
     * @return 培训附件集合
     */
	public List<BiScopeTrainAttach> selectBiScopeTrainAttachList(BiScopeTrainAttach biScopeTrainAttach);
	
	/**
     * 新增培训附件
     * 
     * @param biScopeTrainAttach 培训附件信息
     * @return 结果
     */
	public int insertBiScopeTrainAttach(BiScopeTrainAttach biScopeTrainAttach);
	
	/**
     * 修改培训附件
     * 
     * @param biScopeTrainAttach 培训附件信息
     * @return 结果
     */
	public int updateBiScopeTrainAttach(BiScopeTrainAttach biScopeTrainAttach);
		
	/**
     * 删除培训附件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeTrainAttachByIds(String ids);


    /**
     * 导入培训附件数据
     * @param biScopeTrainAttachList
     * @return
     */
    public String importBiScopeTrainAttach(List<BiScopeTrainAttach> biScopeTrainAttachList);

	public int updateBiScopeTrainAttachReadyToDeal(Map param);

	public int  updateBiScopeTrainAttachToComplate(Map param);

	public int  updateBiScopeTrainAttachToFailed(Map param);

	public List<BiScopeTrainAttachVO> selectBiScopeTrainAttachReadToDeal(Map param);
}
