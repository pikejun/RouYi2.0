package com.ruoyi.project.system.biScopeProperty.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
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
import com.ruoyi.project.system.biScopeProperty.domain.BiScopeProperty;
import com.ruoyi.project.system.biScopeProperty.service.IBiScopePropertyService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * 范围属性 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/biScopeProperty")
public class BiScopePropertyController extends BaseController
{
    private String prefix = "system/biScopeProperty";
	
	@Autowired
	private IBiScopePropertyService biScopePropertyService;
	
	@RequiresPermissions("bi:biScopeProperty:view")
	@GetMapping()
	public String biScopeProperty()
	{
	    return prefix + "/biScopeProperty";
	}
	
	/**
	 * 查询范围属性列表
	 */
	@RequiresPermissions("bi:biScopeProperty:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeProperty biScopeProperty)
	{
		startPage();
        List<BiScopeProperty> list = biScopePropertyService.selectBiScopePropertyList(biScopeProperty);
		return getDataTable(list);
	}

	@PostMapping("/getScopePropertyByScopeName")
	@ResponseBody
	public String getScopePropertyByScopeName(HttpServletRequest request) {
		BiScopeProperty biScopeProperty = new BiScopeProperty();
		biScopeProperty.setScopeName(request.getParameter("scopeName"));
		List<BiScopeProperty> list = biScopePropertyService.selectBiScopePropertyList(biScopeProperty);

		return JSON.toJSONString(list);
	}
	
	
	/**
	 * 导出范围属性列表
	 */
	@RequiresPermissions("bi:biScopeProperty:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeProperty biScopeProperty)
    {
    	List<BiScopeProperty> list = biScopePropertyService.selectBiScopePropertyList(biScopeProperty);
        ExcelUtil<BiScopeProperty> util = new ExcelUtil<BiScopeProperty>(BiScopeProperty.class);
        return util.exportExcel(list, "biScopeProperty");
    }
    /**
     * 导入范围属性列表
     */
    @RequiresPermissions("bi:biScopeProperty:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeProperty> util = new ExcelUtil<BiScopeProperty>(BiScopeProperty.class);
        List<BiScopeProperty> userList = util.importExcel(file.getInputStream());
        String message = biScopePropertyService.importBiScopeProperty(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 范围属性表格模板下载
	 * @return
	 */
    @RequiresPermissions("bi:biScopeProperty:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeProperty> util = new ExcelUtil<BiScopeProperty>(BiScopeProperty.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增范围属性
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存范围属性
	 */
	@RequiresPermissions("bi:biScopeProperty:add")
	@Log(title = "范围属性", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeProperty biScopeProperty)
	{		
		return toAjax(biScopePropertyService.insertBiScopeProperty(biScopeProperty));
	}

	/**
	 * 修改范围属性
	 */
	@GetMapping("/edit/{propertyId}")
	public String edit(@PathVariable("propertyId") Integer propertyId, ModelMap mmap)
	{
		BiScopeProperty biScopeProperty = biScopePropertyService.selectBiScopePropertyById(propertyId);
		mmap.put("biScopeProperty", biScopeProperty);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存范围属性
	 */
	@RequiresPermissions("bi:biScopeProperty:edit")
	@Log(title = "范围属性", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeProperty biScopeProperty)
	{		
		return toAjax(biScopePropertyService.updateBiScopeProperty(biScopeProperty));
	}
	
	/**
	 * 删除范围属性
	 */
	@RequiresPermissions("bi:biScopeProperty:remove")
	@Log(title = "范围属性", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopePropertyService.deleteBiScopePropertyByIds(ids));
	}



	
}
