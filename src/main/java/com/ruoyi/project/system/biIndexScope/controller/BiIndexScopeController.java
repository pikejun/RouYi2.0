package com.ruoyi.project.system.biIndexScope.controller;

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
import com.ruoyi.project.system.biIndexScope.domain.BiIndexScope;
import com.ruoyi.project.system.biIndexScope.service.IBiIndexScopeService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 指标范围 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/biIndexScope")
public class BiIndexScopeController extends BaseController
{
    private String prefix = "system/biIndexScope";
	
	@Autowired
	private IBiIndexScopeService biIndexScopeService;
	
	@RequiresPermissions("system:biIndexScope:view")
	@GetMapping()
	public String biIndexScope()
	{
	    return prefix + "/biIndexScope";
	}
	
	/**
	 * 查询指标范围列表
	 */
	@RequiresPermissions("system:biIndexScope:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiIndexScope biIndexScope)
	{
		startPage();
        List<BiIndexScope> list = biIndexScopeService.selectBiIndexScopeList(biIndexScope);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出指标范围列表
	 */
	@RequiresPermissions("system:biIndexScope:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiIndexScope biIndexScope)
    {
    	List<BiIndexScope> list = biIndexScopeService.selectBiIndexScopeList(biIndexScope);
        ExcelUtil<BiIndexScope> util = new ExcelUtil<BiIndexScope>(BiIndexScope.class);
        return util.exportExcel(list, "biIndexScope");
    }
    /**
     * 导入指标范围列表
     */
    @RequiresPermissions("system:biIndexScope:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiIndexScope> util = new ExcelUtil<BiIndexScope>(BiIndexScope.class);
        List<BiIndexScope> userList = util.importExcel(file.getInputStream());
        String message = biIndexScopeService.importBiIndexScope(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 指标范围表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biIndexScope:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiIndexScope> util = new ExcelUtil<BiIndexScope>(BiIndexScope.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增指标范围
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存指标范围
	 */
	@RequiresPermissions("system:biIndexScope:add")
	@Log(title = "指标范围", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiIndexScope biIndexScope)
	{		
		return toAjax(biIndexScopeService.insertBiIndexScope(biIndexScope));
	}

	/**
	 * 修改指标范围
	 */
	@GetMapping("/edit/{isId}")
	public String edit(@PathVariable("isId") Integer isId, ModelMap mmap)
	{
		BiIndexScope biIndexScope = biIndexScopeService.selectBiIndexScopeById(isId);
		mmap.put("biIndexScope", biIndexScope);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存指标范围
	 */
	@RequiresPermissions("system:biIndexScope:edit")
	@Log(title = "指标范围", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiIndexScope biIndexScope)
	{		
		return toAjax(biIndexScopeService.updateBiIndexScope(biIndexScope));
	}
	
	/**
	 * 删除指标范围
	 */
	@RequiresPermissions("system:biIndexScope:remove")
	@Log(title = "指标范围", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biIndexScopeService.deleteBiIndexScopeByIds(ids));
	}



	
}
