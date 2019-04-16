package com.ruoyi.project.system.biTemplateIndexProperty.controller;

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
import com.ruoyi.project.system.biTemplateIndexProperty.domain.BiTemplateIndexProperty;
import com.ruoyi.project.system.biTemplateIndexProperty.service.IBiTemplateIndexPropertyService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 模板指标属性明细 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/biTemplateIndexProperty")
public class BiTemplateIndexPropertyController extends BaseController
{
    private String prefix = "system/biTemplateIndexProperty";
	
	@Autowired
	private IBiTemplateIndexPropertyService biTemplateIndexPropertyService;
	
	@RequiresPermissions("system:biTemplateIndexProperty:view")
	@GetMapping()
	public String biTemplateIndexProperty()
	{
	    return prefix + "/biTemplateIndexProperty";
	}
	
	/**
	 * 查询模板指标属性明细列表
	 */
	@RequiresPermissions("system:biTemplateIndexProperty:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiTemplateIndexProperty biTemplateIndexProperty)
	{
		startPage();
        List<BiTemplateIndexProperty> list = biTemplateIndexPropertyService.selectBiTemplateIndexPropertyList(biTemplateIndexProperty);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出模板指标属性明细列表
	 */
	@RequiresPermissions("system:biTemplateIndexProperty:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiTemplateIndexProperty biTemplateIndexProperty)
    {
    	List<BiTemplateIndexProperty> list = biTemplateIndexPropertyService.selectBiTemplateIndexPropertyList(biTemplateIndexProperty);
        ExcelUtil<BiTemplateIndexProperty> util = new ExcelUtil<BiTemplateIndexProperty>(BiTemplateIndexProperty.class);
        return util.exportExcel(list, "biTemplateIndexProperty");
    }
    /**
     * 导入模板指标属性明细列表
     */
    @RequiresPermissions("system:biTemplateIndexProperty:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiTemplateIndexProperty> util = new ExcelUtil<BiTemplateIndexProperty>(BiTemplateIndexProperty.class);
        List<BiTemplateIndexProperty> userList = util.importExcel(file.getInputStream());
        String message = biTemplateIndexPropertyService.importBiTemplateIndexProperty(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 模板指标属性明细表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biTemplateIndexProperty:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiTemplateIndexProperty> util = new ExcelUtil<BiTemplateIndexProperty>(BiTemplateIndexProperty.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增模板指标属性明细
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存模板指标属性明细
	 */
	@RequiresPermissions("system:biTemplateIndexProperty:add")
	@Log(title = "模板指标属性明细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiTemplateIndexProperty biTemplateIndexProperty)
	{		
		return toAjax(biTemplateIndexPropertyService.insertBiTemplateIndexProperty(biTemplateIndexProperty));
	}

	/**
	 * 修改模板指标属性明细
	 */
	@GetMapping("/edit/{tipId}")
	public String edit(@PathVariable("tipId") Integer tipId, ModelMap mmap)
	{
		BiTemplateIndexProperty biTemplateIndexProperty = biTemplateIndexPropertyService.selectBiTemplateIndexPropertyById(tipId);
		mmap.put("biTemplateIndexProperty", biTemplateIndexProperty);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存模板指标属性明细
	 */
	@RequiresPermissions("system:biTemplateIndexProperty:edit")
	@Log(title = "模板指标属性明细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiTemplateIndexProperty biTemplateIndexProperty)
	{		
		return toAjax(biTemplateIndexPropertyService.updateBiTemplateIndexProperty(biTemplateIndexProperty));
	}
	
	/**
	 * 删除模板指标属性明细
	 */
	@RequiresPermissions("system:biTemplateIndexProperty:remove")
	@Log(title = "模板指标属性明细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biTemplateIndexPropertyService.deleteBiTemplateIndexPropertyByIds(ids));
	}



	
}
