package com.ruoyi.project.system.biScopeComplaintLog.controller;

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
import com.ruoyi.project.system.biScopeComplaintLog.domain.BiScopeComplaintLog;
import com.ruoyi.project.system.biScopeComplaintLog.service.IBiScopeComplaintLogService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 维权日志 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Controller
@RequestMapping("/system/biScopeComplaintLog")
public class BiScopeComplaintLogController extends BaseController
{
    private String prefix = "system/biScopeComplaintLog";
	
	@Autowired
	private IBiScopeComplaintLogService biScopeComplaintLogService;
	
	@RequiresPermissions("system:biScopeComplaintLog:view")
	@GetMapping()
	public String biScopeComplaintLog()
	{
	    return prefix + "/biScopeComplaintLog";
	}
	
	/**
	 * 查询维权日志列表
	 */
	@RequiresPermissions("system:biScopeComplaintLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeComplaintLog biScopeComplaintLog)
	{
		startPage();
        List<BiScopeComplaintLog> list = biScopeComplaintLogService.selectBiScopeComplaintLogList(biScopeComplaintLog);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出维权日志列表
	 */
	@RequiresPermissions("system:biScopeComplaintLog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeComplaintLog biScopeComplaintLog)
    {
    	List<BiScopeComplaintLog> list = biScopeComplaintLogService.selectBiScopeComplaintLogList(biScopeComplaintLog);
        ExcelUtil<BiScopeComplaintLog> util = new ExcelUtil<BiScopeComplaintLog>(BiScopeComplaintLog.class);
        return util.exportExcel(list, "biScopeComplaintLog");
    }
    /**
     * 导入维权日志列表
     */
    @RequiresPermissions("system:biScopeComplaintLog:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeComplaintLog> util = new ExcelUtil<BiScopeComplaintLog>(BiScopeComplaintLog.class);
        List<BiScopeComplaintLog> userList = util.importExcel(file.getInputStream());
        String message = biScopeComplaintLogService.importBiScopeComplaintLog(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 维权日志表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeComplaintLog:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeComplaintLog> util = new ExcelUtil<BiScopeComplaintLog>(BiScopeComplaintLog.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增维权日志
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存维权日志
	 */
	@RequiresPermissions("system:biScopeComplaintLog:add")
	@Log(title = "维权日志", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeComplaintLog biScopeComplaintLog)
	{		
		return toAjax(biScopeComplaintLogService.insertBiScopeComplaintLog(biScopeComplaintLog));
	}

	/**
	 * 修改维权日志
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeComplaintLog biScopeComplaintLog = biScopeComplaintLogService.selectBiScopeComplaintLogById(tid);
		mmap.put("biScopeComplaintLog", biScopeComplaintLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存维权日志
	 */
	@RequiresPermissions("system:biScopeComplaintLog:edit")
	@Log(title = "维权日志", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeComplaintLog biScopeComplaintLog)
	{		
		return toAjax(biScopeComplaintLogService.updateBiScopeComplaintLog(biScopeComplaintLog));
	}
	
	/**
	 * 删除维权日志
	 */
	@RequiresPermissions("system:biScopeComplaintLog:remove")
	@Log(title = "维权日志", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeComplaintLogService.deleteBiScopeComplaintLogByIds(ids));
	}



	
}
