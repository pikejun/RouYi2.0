package com.ruoyi.project.system.biScopeSalaryInfo.controller;

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
import com.ruoyi.project.system.biScopeSalaryInfo.domain.BiScopeSalaryInfo;
import com.ruoyi.project.system.biScopeSalaryInfo.service.IBiScopeSalaryInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工人工资 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Controller
@RequestMapping("/system/biScopeSalaryInfo")
public class BiScopeSalaryInfoController extends BaseController
{
    private String prefix = "system/biScopeSalaryInfo";
	
	@Autowired
	private IBiScopeSalaryInfoService biScopeSalaryInfoService;
	
	@RequiresPermissions("system:biScopeSalaryInfo:view")
	@GetMapping()
	public String biScopeSalaryInfo()
	{
	    return prefix + "/biScopeSalaryInfo";
	}
	
	/**
	 * 查询工人工资列表
	 */
	@RequiresPermissions("system:biScopeSalaryInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeSalaryInfo biScopeSalaryInfo)
	{
		startPage();
        List<BiScopeSalaryInfo> list = biScopeSalaryInfoService.selectBiScopeSalaryInfoList(biScopeSalaryInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出工人工资列表
	 */
	@RequiresPermissions("system:biScopeSalaryInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeSalaryInfo biScopeSalaryInfo)
    {
    	List<BiScopeSalaryInfo> list = biScopeSalaryInfoService.selectBiScopeSalaryInfoList(biScopeSalaryInfo);
        ExcelUtil<BiScopeSalaryInfo> util = new ExcelUtil<BiScopeSalaryInfo>(BiScopeSalaryInfo.class);
        return util.exportExcel(list, "biScopeSalaryInfo");
    }
    /**
     * 导入工人工资列表
     */
    @RequiresPermissions("system:biScopeSalaryInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeSalaryInfo> util = new ExcelUtil<BiScopeSalaryInfo>(BiScopeSalaryInfo.class);
        List<BiScopeSalaryInfo> userList = util.importExcel(file.getInputStream());
        String message = biScopeSalaryInfoService.importBiScopeSalaryInfo(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 工人工资表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeSalaryInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeSalaryInfo> util = new ExcelUtil<BiScopeSalaryInfo>(BiScopeSalaryInfo.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增工人工资
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存工人工资
	 */
	@RequiresPermissions("system:biScopeSalaryInfo:add")
	@Log(title = "工人工资", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeSalaryInfo biScopeSalaryInfo)
	{		
		return toAjax(biScopeSalaryInfoService.insertBiScopeSalaryInfo(biScopeSalaryInfo));
	}

	/**
	 * 修改工人工资
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeSalaryInfo biScopeSalaryInfo = biScopeSalaryInfoService.selectBiScopeSalaryInfoById(tid);
		mmap.put("biScopeSalaryInfo", biScopeSalaryInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工人工资
	 */
	@RequiresPermissions("system:biScopeSalaryInfo:edit")
	@Log(title = "工人工资", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeSalaryInfo biScopeSalaryInfo)
	{		
		return toAjax(biScopeSalaryInfoService.updateBiScopeSalaryInfo(biScopeSalaryInfo));
	}
	
	/**
	 * 删除工人工资
	 */
	@RequiresPermissions("system:biScopeSalaryInfo:remove")
	@Log(title = "工人工资", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeSalaryInfoService.deleteBiScopeSalaryInfoByIds(ids));
	}



	
}
