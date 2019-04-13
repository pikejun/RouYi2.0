package com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.service;

import com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.domain.BiScopeWorkerSafeEventAttachments;
import com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.vo.BiScopeWorkerSafeEventAttachmentsVO;

import java.util.List;
import java.util.Map;

/**
 * 工人安全事件附件 服务层
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
public interface IBiScopeWorkerSafeEventAttachmentsService 
{
	/**
     * 查询工人安全事件附件信息
     * 
     * @param tid 工人安全事件附件ID
     * @return 工人安全事件附件信息
     */
	public BiScopeWorkerSafeEventAttachments selectBiScopeWorkerSafeEventAttachmentsById(Integer tid);
	
	/**
     * 查询工人安全事件附件列表
     * 
     * @param biScopeWorkerSafeEventAttachments 工人安全事件附件信息
     * @return 工人安全事件附件集合
     */
	public List<BiScopeWorkerSafeEventAttachments> selectBiScopeWorkerSafeEventAttachmentsList(BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments);
	
	/**
     * 新增工人安全事件附件
     * 
     * @param biScopeWorkerSafeEventAttachments 工人安全事件附件信息
     * @return 结果
     */
	public int insertBiScopeWorkerSafeEventAttachments(BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments);
	
	/**
     * 修改工人安全事件附件
     * 
     * @param biScopeWorkerSafeEventAttachments 工人安全事件附件信息
     * @return 结果
     */
	public int updateBiScopeWorkerSafeEventAttachments(BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments);
		
	/**
     * 删除工人安全事件附件信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiScopeWorkerSafeEventAttachmentsByIds(String ids);


    /**
     * 导入工人安全事件附件数据
     * @param biScopeWorkerSafeEventAttachmentsList
     * @return
     */
    public String importBiScopeWorkerSafeEventAttachments(List<BiScopeWorkerSafeEventAttachments> biScopeWorkerSafeEventAttachmentsList);

	public int updateBiScopeWorkerSafeEventAttachmentsReadyToDeal(Map param);

	public int  updateBiScopeWorkerSafeEventAttachmentsToComplate(Map param);

	public int  updateBiScopeWorkerSafeEventAttachmentsToFailed(Map param);

	public List<BiScopeWorkerSafeEventAttachmentsVO> selectBiScopeWorkerSafeEventAttachmentsReadToDeal(Map param);
}
