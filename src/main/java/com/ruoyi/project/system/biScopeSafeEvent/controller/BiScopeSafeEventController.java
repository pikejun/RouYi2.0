package com.ruoyi.project.system.biScopeSafeEvent.controller;

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
import com.ruoyi.project.system.biScopeSafeEvent.domain.BiScopeSafeEvent;
import com.ruoyi.project.system.biScopeSafeEvent.service.IBiScopeSafeEventService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 安全事件 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-04
 */
@Controller
@RequestMapping("/system/biScopeSafeEvent")
public class BiScopeSafeEventController extends BaseController
{
    private String prefix = "system/biScopeSafeEvent";
	
	@Autowired
	private IBiScopeSafeEventService biScopeSafeEventService;
	
	@RequiresPermissions("system:biScopeSafeEvent:view")
	@GetMapping()
	public String biScopeSafeEvent()
	{
	    return prefix + "/biScopeSafeEvent";
	}
	
	/**
	 * 查询安全事件列表
	 */
	@RequiresPermissions("system:biScopeSafeEvent:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeSafeEvent biScopeSafeEvent)
	{
		startPage();
        List<BiScopeSafeEvent> list = biScopeSafeEventService.selectBiScopeSafeEventList(biScopeSafeEvent);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出安全事件列表
	 */
	@RequiresPermissions("system:biScopeSafeEvent:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeSafeEvent biScopeSafeEvent)
    {
    	List<BiScopeSafeEvent> list = biScopeSafeEventService.selectBiScopeSafeEventList(biScopeSafeEvent);
        ExcelUtil<BiScopeSafeEvent> util = new ExcelUtil<BiScopeSafeEvent>(BiScopeSafeEvent.class);
        return util.exportExcel(list, "biScopeSafeEvent");
    }
    /**
     * 导入安全事件列表
     */
    @RequiresPermissions("system:biScopeSafeEvent:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeSafeEvent> util = new ExcelUtil<BiScopeSafeEvent>(BiScopeSafeEvent.class);
        List<BiScopeSafeEvent> userList = util.importExcel(file.getInputStream());
        String message = biScopeSafeEventService.importBiScopeSafeEvent(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 安全事件表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeSafeEvent:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeSafeEvent> util = new ExcelUtil<BiScopeSafeEvent>(BiScopeSafeEvent.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增安全事件
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存安全事件
	 */
	@RequiresPermissions("system:biScopeSafeEvent:add")
	@Log(title = "安全事件", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeSafeEvent biScopeSafeEvent)
	{		
		return toAjax(biScopeSafeEventService.insertBiScopeSafeEvent(biScopeSafeEvent));
	}

	/**
	 * 修改安全事件
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeSafeEvent biScopeSafeEvent = biScopeSafeEventService.selectBiScopeSafeEventById(tid);
		mmap.put("biScopeSafeEvent", biScopeSafeEvent);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存安全事件
	 */
	@RequiresPermissions("system:biScopeSafeEvent:edit")
	@Log(title = "安全事件", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeSafeEvent biScopeSafeEvent)
	{		
		return toAjax(biScopeSafeEventService.updateBiScopeSafeEvent(biScopeSafeEvent));
	}
	
	/**
	 * 删除安全事件
	 */
	@RequiresPermissions("system:biScopeSafeEvent:remove")
	@Log(title = "安全事件", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeSafeEventService.deleteBiScopeSafeEventByIds(ids));
	}



	
}
