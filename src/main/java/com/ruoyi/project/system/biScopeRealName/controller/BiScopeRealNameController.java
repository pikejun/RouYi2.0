package com.ruoyi.project.system.biScopeRealName.controller;

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
import com.ruoyi.project.system.biScopeRealName.domain.BiScopeRealName;
import com.ruoyi.project.system.biScopeRealName.service.IBiScopeRealNameService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 人员 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-11
 */
@Controller
@RequestMapping("/system/biScopeRealName")
public class BiScopeRealNameController extends BaseController
{
    private String prefix = "system/biScopeRealName";
	
	@Autowired
	private IBiScopeRealNameService biScopeRealNameService;
	
	@RequiresPermissions("system:biScopeRealName:view")
	@GetMapping()
	public String biScopeRealName()
	{
	    return prefix + "/biScopeRealName";
	}
	
	/**
	 * 查询人员列表
	 */
	@RequiresPermissions("system:biScopeRealName:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeRealName biScopeRealName)
	{
		startPage();
        List<BiScopeRealName> list = biScopeRealNameService.selectBiScopeRealNameList(biScopeRealName);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出人员列表
	 */
	@RequiresPermissions("system:biScopeRealName:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeRealName biScopeRealName)
    {
    	List<BiScopeRealName> list = biScopeRealNameService.selectBiScopeRealNameList(biScopeRealName);
        ExcelUtil<BiScopeRealName> util = new ExcelUtil<BiScopeRealName>(BiScopeRealName.class);
        return util.exportExcel(list, "biScopeRealName");
    }
    /**
     * 导入人员列表
     */
    @RequiresPermissions("system:biScopeRealName:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeRealName> util = new ExcelUtil<BiScopeRealName>(BiScopeRealName.class);
        List<BiScopeRealName> userList = util.importExcel(file.getInputStream());
        String message = biScopeRealNameService.importBiScopeRealName(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 人员表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeRealName:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeRealName> util = new ExcelUtil<BiScopeRealName>(BiScopeRealName.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增人员
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存人员
	 */
	@RequiresPermissions("system:biScopeRealName:add")
	@Log(title = "人员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeRealName biScopeRealName)
	{		
		return toAjax(biScopeRealNameService.insertBiScopeRealName(biScopeRealName));
	}

	/**
	 * 修改人员
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeRealName biScopeRealName = biScopeRealNameService.selectBiScopeRealNameById(tid);
		mmap.put("biScopeRealName", biScopeRealName);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存人员
	 */
	@RequiresPermissions("system:biScopeRealName:edit")
	@Log(title = "人员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeRealName biScopeRealName)
	{		
		return toAjax(biScopeRealNameService.updateBiScopeRealName(biScopeRealName));
	}
	
	/**
	 * 删除人员
	 */
	@RequiresPermissions("system:biScopeRealName:remove")
	@Log(title = "人员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeRealNameService.deleteBiScopeRealNameByIds(ids));
	}



	
}
