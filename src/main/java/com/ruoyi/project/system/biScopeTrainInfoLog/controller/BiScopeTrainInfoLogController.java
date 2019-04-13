package com.ruoyi.project.system.biScopeTrainInfoLog.controller;

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
import com.ruoyi.project.system.biScopeTrainInfoLog.domain.BiScopeTrainInfoLog;
import com.ruoyi.project.system.biScopeTrainInfoLog.service.IBiScopeTrainInfoLogService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工人培训日志 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Controller
@RequestMapping("/system/biScopeTrainInfoLog")
public class BiScopeTrainInfoLogController extends BaseController
{
    private String prefix = "system/biScopeTrainInfoLog";
	
	@Autowired
	private IBiScopeTrainInfoLogService biScopeTrainInfoLogService;
	
	@RequiresPermissions("system:biScopeTrainInfoLog:view")
	@GetMapping()
	public String biScopeTrainInfoLog()
	{
	    return prefix + "/biScopeTrainInfoLog";
	}
	
	/**
	 * 查询工人培训日志列表
	 */
	@RequiresPermissions("system:biScopeTrainInfoLog:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeTrainInfoLog biScopeTrainInfoLog)
	{
		startPage();
        List<BiScopeTrainInfoLog> list = biScopeTrainInfoLogService.selectBiScopeTrainInfoLogList(biScopeTrainInfoLog);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出工人培训日志列表
	 */
	@RequiresPermissions("system:biScopeTrainInfoLog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeTrainInfoLog biScopeTrainInfoLog)
    {
    	List<BiScopeTrainInfoLog> list = biScopeTrainInfoLogService.selectBiScopeTrainInfoLogList(biScopeTrainInfoLog);
        ExcelUtil<BiScopeTrainInfoLog> util = new ExcelUtil<BiScopeTrainInfoLog>(BiScopeTrainInfoLog.class);
        return util.exportExcel(list, "biScopeTrainInfoLog");
    }
    /**
     * 导入工人培训日志列表
     */
    @RequiresPermissions("system:biScopeTrainInfoLog:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeTrainInfoLog> util = new ExcelUtil<BiScopeTrainInfoLog>(BiScopeTrainInfoLog.class);
        List<BiScopeTrainInfoLog> userList = util.importExcel(file.getInputStream());
        String message = biScopeTrainInfoLogService.importBiScopeTrainInfoLog(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 工人培训日志表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeTrainInfoLog:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeTrainInfoLog> util = new ExcelUtil<BiScopeTrainInfoLog>(BiScopeTrainInfoLog.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增工人培训日志
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存工人培训日志
	 */
	@RequiresPermissions("system:biScopeTrainInfoLog:add")
	@Log(title = "工人培训日志", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeTrainInfoLog biScopeTrainInfoLog)
	{		
		return toAjax(biScopeTrainInfoLogService.insertBiScopeTrainInfoLog(biScopeTrainInfoLog));
	}

	/**
	 * 修改工人培训日志
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeTrainInfoLog biScopeTrainInfoLog = biScopeTrainInfoLogService.selectBiScopeTrainInfoLogById(tid);
		mmap.put("biScopeTrainInfoLog", biScopeTrainInfoLog);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工人培训日志
	 */
	@RequiresPermissions("system:biScopeTrainInfoLog:edit")
	@Log(title = "工人培训日志", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeTrainInfoLog biScopeTrainInfoLog)
	{		
		return toAjax(biScopeTrainInfoLogService.updateBiScopeTrainInfoLog(biScopeTrainInfoLog));
	}
	
	/**
	 * 删除工人培训日志
	 */
	@RequiresPermissions("system:biScopeTrainInfoLog:remove")
	@Log(title = "工人培训日志", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeTrainInfoLogService.deleteBiScopeTrainInfoLogByIds(ids));
	}



	
}
