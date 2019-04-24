package com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.domain.BiScopeWorkerSafeEventAttachments;
import com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.service.IBiScopeWorkerSafeEventAttachmentsService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工人安全事件附件 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Controller
@RequestMapping("/system/biScopeWorkerSafeEventAttachments")
public class BiScopeWorkerSafeEventAttachmentsController extends BaseController
{
    private String prefix = "system/biScopeWorkerSafeEventAttachments";
	
	@Autowired
	private IBiScopeWorkerSafeEventAttachmentsService biScopeWorkerSafeEventAttachmentsService;
	
	@RequiresPermissions("bi:biScopeWorkerSafeEventAttachments:view")
	@GetMapping()
	public String biScopeWorkerSafeEventAttachments()
	{
	    return prefix + "/biScopeWorkerSafeEventAttachments";
	}
	
	/**
	 * 查询工人安全事件附件列表
	 */
	@RequiresPermissions("bi:biScopeWorkerSafeEventAttachments:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments)
	{
		startPage();
        List<BiScopeWorkerSafeEventAttachments> list = biScopeWorkerSafeEventAttachmentsService.selectBiScopeWorkerSafeEventAttachmentsList(biScopeWorkerSafeEventAttachments);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出工人安全事件附件列表
	 */
	@RequiresPermissions("bi:biScopeWorkerSafeEventAttachments:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments)
    {
    	List<BiScopeWorkerSafeEventAttachments> list = biScopeWorkerSafeEventAttachmentsService.selectBiScopeWorkerSafeEventAttachmentsList(biScopeWorkerSafeEventAttachments);
        ExcelUtil<BiScopeWorkerSafeEventAttachments> util = new ExcelUtil<BiScopeWorkerSafeEventAttachments>(BiScopeWorkerSafeEventAttachments.class);
        return util.exportExcel(list, "biScopeWorkerSafeEventAttachments");
    }
    /**
     * 导入工人安全事件附件列表
     */
    @RequiresPermissions("bi:biScopeWorkerSafeEventAttachments:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeWorkerSafeEventAttachments> util = new ExcelUtil<BiScopeWorkerSafeEventAttachments>(BiScopeWorkerSafeEventAttachments.class);
        List<BiScopeWorkerSafeEventAttachments> userList = util.importExcel(file.getInputStream());
        String message = biScopeWorkerSafeEventAttachmentsService.importBiScopeWorkerSafeEventAttachments(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 工人安全事件附件表格模板下载
	 * @return
	 */
    @RequiresPermissions("bi:biScopeWorkerSafeEventAttachments:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeWorkerSafeEventAttachments> util = new ExcelUtil<BiScopeWorkerSafeEventAttachments>(BiScopeWorkerSafeEventAttachments.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增工人安全事件附件
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存工人安全事件附件
	 */
	@RequiresPermissions("bi:biScopeWorkerSafeEventAttachments:add")
	@Log(title = "工人安全事件附件", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments)
	{		
		return toAjax(biScopeWorkerSafeEventAttachmentsService.insertBiScopeWorkerSafeEventAttachments(biScopeWorkerSafeEventAttachments));
	}

	/**
	 * 修改工人安全事件附件
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments = biScopeWorkerSafeEventAttachmentsService.selectBiScopeWorkerSafeEventAttachmentsById(tid);
		mmap.put("biScopeWorkerSafeEventAttachments", biScopeWorkerSafeEventAttachments);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工人安全事件附件
	 */
	@RequiresPermissions("bi:biScopeWorkerSafeEventAttachments:edit")
	@Log(title = "工人安全事件附件", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeWorkerSafeEventAttachments biScopeWorkerSafeEventAttachments)
	{		
		return toAjax(biScopeWorkerSafeEventAttachmentsService.updateBiScopeWorkerSafeEventAttachments(biScopeWorkerSafeEventAttachments));
	}
	
	/**
	 * 删除工人安全事件附件
	 */
	@RequiresPermissions("bi:biScopeWorkerSafeEventAttachments:remove")
	@Log(title = "工人安全事件附件", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeWorkerSafeEventAttachmentsService.deleteBiScopeWorkerSafeEventAttachmentsByIds(ids));
	}



	
}
