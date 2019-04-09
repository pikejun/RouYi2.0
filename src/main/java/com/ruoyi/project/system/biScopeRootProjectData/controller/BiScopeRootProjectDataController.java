package com.ruoyi.project.system.biScopeRootProjectData.controller;

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
import com.ruoyi.project.system.biScopeRootProjectData.domain.BiScopeRootProjectData;
import com.ruoyi.project.system.biScopeRootProjectData.service.IBiScopeRootProjectDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 总工程 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-09
 */
@Controller
@RequestMapping("/system/biScopeRootProjectData")
public class BiScopeRootProjectDataController extends BaseController
{
    private String prefix = "system/biScopeRootProjectData";
	
	@Autowired
	private IBiScopeRootProjectDataService biScopeRootProjectDataService;
	
	@RequiresPermissions("system:biScopeRootProjectData:view")
	@GetMapping()
	public String biScopeRootProjectData()
	{
	    return prefix + "/biScopeRootProjectData";
	}
	
	/**
	 * 查询总工程列表
	 */
	@RequiresPermissions("system:biScopeRootProjectData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeRootProjectData biScopeRootProjectData)
	{
		startPage();
        List<BiScopeRootProjectData> list = biScopeRootProjectDataService.selectBiScopeRootProjectDataList(biScopeRootProjectData);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出总工程列表
	 */
	@RequiresPermissions("system:biScopeRootProjectData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeRootProjectData biScopeRootProjectData)
    {
    	List<BiScopeRootProjectData> list = biScopeRootProjectDataService.selectBiScopeRootProjectDataList(biScopeRootProjectData);
        ExcelUtil<BiScopeRootProjectData> util = new ExcelUtil<BiScopeRootProjectData>(BiScopeRootProjectData.class);
        return util.exportExcel(list, "biScopeRootProjectData");
    }
    /**
     * 导入总工程列表
     */
    @RequiresPermissions("system:biScopeRootProjectData:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeRootProjectData> util = new ExcelUtil<BiScopeRootProjectData>(BiScopeRootProjectData.class);
        List<BiScopeRootProjectData> userList = util.importExcel(file.getInputStream());
        String message = biScopeRootProjectDataService.importBiScopeRootProjectData(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 总工程表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeRootProjectData:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeRootProjectData> util = new ExcelUtil<BiScopeRootProjectData>(BiScopeRootProjectData.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增总工程
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存总工程
	 */
	@RequiresPermissions("system:biScopeRootProjectData:add")
	@Log(title = "总工程", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeRootProjectData biScopeRootProjectData)
	{		
		return toAjax(biScopeRootProjectDataService.insertBiScopeRootProjectData(biScopeRootProjectData));
	}

	/**
	 * 修改总工程
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeRootProjectData biScopeRootProjectData = biScopeRootProjectDataService.selectBiScopeRootProjectDataById(tid);
		mmap.put("biScopeRootProjectData", biScopeRootProjectData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存总工程
	 */
	@RequiresPermissions("system:biScopeRootProjectData:edit")
	@Log(title = "总工程", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeRootProjectData biScopeRootProjectData)
	{		
		return toAjax(biScopeRootProjectDataService.updateBiScopeRootProjectData(biScopeRootProjectData));
	}
	
	/**
	 * 删除总工程
	 */
	@RequiresPermissions("system:biScopeRootProjectData:remove")
	@Log(title = "总工程", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeRootProjectDataService.deleteBiScopeRootProjectDataByIds(ids));
	}



	
}
