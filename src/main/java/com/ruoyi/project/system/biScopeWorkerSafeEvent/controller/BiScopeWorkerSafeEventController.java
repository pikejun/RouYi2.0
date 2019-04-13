package com.ruoyi.project.system.biScopeWorkerSafeEvent.controller;

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
import com.ruoyi.project.system.biScopeWorkerSafeEvent.domain.BiScopeWorkerSafeEvent;
import com.ruoyi.project.system.biScopeWorkerSafeEvent.service.IBiScopeWorkerSafeEventService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工人安全事件 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Controller
@RequestMapping("/system/biScopeWorkerSafeEvent")
public class BiScopeWorkerSafeEventController extends BaseController
{
    private String prefix = "system/biScopeWorkerSafeEvent";
	
	@Autowired
	private IBiScopeWorkerSafeEventService biScopeWorkerSafeEventService;
	
	@RequiresPermissions("system:biScopeWorkerSafeEvent:view")
	@GetMapping()
	public String biScopeWorkerSafeEvent()
	{
	    return prefix + "/biScopeWorkerSafeEvent";
	}
	
	/**
	 * 查询工人安全事件列表
	 */
	@RequiresPermissions("system:biScopeWorkerSafeEvent:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeWorkerSafeEvent biScopeWorkerSafeEvent)
	{
		startPage();
        List<BiScopeWorkerSafeEvent> list = biScopeWorkerSafeEventService.selectBiScopeWorkerSafeEventList(biScopeWorkerSafeEvent);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出工人安全事件列表
	 */
	@RequiresPermissions("system:biScopeWorkerSafeEvent:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeWorkerSafeEvent biScopeWorkerSafeEvent)
    {
    	List<BiScopeWorkerSafeEvent> list = biScopeWorkerSafeEventService.selectBiScopeWorkerSafeEventList(biScopeWorkerSafeEvent);
        ExcelUtil<BiScopeWorkerSafeEvent> util = new ExcelUtil<BiScopeWorkerSafeEvent>(BiScopeWorkerSafeEvent.class);
        return util.exportExcel(list, "biScopeWorkerSafeEvent");
    }
    /**
     * 导入工人安全事件列表
     */
    @RequiresPermissions("system:biScopeWorkerSafeEvent:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeWorkerSafeEvent> util = new ExcelUtil<BiScopeWorkerSafeEvent>(BiScopeWorkerSafeEvent.class);
        List<BiScopeWorkerSafeEvent> userList = util.importExcel(file.getInputStream());
        String message = biScopeWorkerSafeEventService.importBiScopeWorkerSafeEvent(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 工人安全事件表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeWorkerSafeEvent:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeWorkerSafeEvent> util = new ExcelUtil<BiScopeWorkerSafeEvent>(BiScopeWorkerSafeEvent.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增工人安全事件
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存工人安全事件
	 */
	@RequiresPermissions("system:biScopeWorkerSafeEvent:add")
	@Log(title = "工人安全事件", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeWorkerSafeEvent biScopeWorkerSafeEvent)
	{		
		return toAjax(biScopeWorkerSafeEventService.insertBiScopeWorkerSafeEvent(biScopeWorkerSafeEvent));
	}

	/**
	 * 修改工人安全事件
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeWorkerSafeEvent biScopeWorkerSafeEvent = biScopeWorkerSafeEventService.selectBiScopeWorkerSafeEventById(tid);
		mmap.put("biScopeWorkerSafeEvent", biScopeWorkerSafeEvent);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工人安全事件
	 */
	@RequiresPermissions("system:biScopeWorkerSafeEvent:edit")
	@Log(title = "工人安全事件", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeWorkerSafeEvent biScopeWorkerSafeEvent)
	{		
		return toAjax(biScopeWorkerSafeEventService.updateBiScopeWorkerSafeEvent(biScopeWorkerSafeEvent));
	}
	
	/**
	 * 删除工人安全事件
	 */
	@RequiresPermissions("system:biScopeWorkerSafeEvent:remove")
	@Log(title = "工人安全事件", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeWorkerSafeEventService.deleteBiScopeWorkerSafeEventByIds(ids));
	}



	
}
