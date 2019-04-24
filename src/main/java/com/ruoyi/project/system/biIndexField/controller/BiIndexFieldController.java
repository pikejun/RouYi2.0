package com.ruoyi.project.system.biIndexField.controller;

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
import com.ruoyi.project.system.biIndexField.domain.BiIndexField;
import com.ruoyi.project.system.biIndexField.service.IBiIndexFieldService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 指标字段明细 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-19
 */
@Controller
@RequestMapping("/system/biIndexField")
public class BiIndexFieldController extends BaseController
{
    private String prefix = "system/biIndexField";
	
	@Autowired
	private IBiIndexFieldService biIndexFieldService;
	
	@RequiresPermissions("bi:biIndexField:view")
	@GetMapping()
	public String biIndexField()
	{
	    return prefix + "/biIndexField";
	}

	@RequiresPermissions("bi:biIndexField:view")
	@GetMapping("{indexNo}")
	public String biIndexField(@PathVariable String indexNo,ModelMap modelMap)
	{
		modelMap.put("indexNo",indexNo);
		return prefix + "/biIndexFieldAtIndexNo";
	}

	/**
	 * 查询指标字段明细列表
	 */
	@RequiresPermissions("bi:biIndexField:list")
	@PostMapping("/list/{indexNo}")
	@ResponseBody
	public TableDataInfo list(@PathVariable String indexNo, BiIndexField biIndexField)
	{
		biIndexField.setIndexNo(indexNo);
		List<BiIndexField> list = biIndexFieldService.selectBiIndexFieldList(biIndexField);
		return getDataTable(list);
	}



	/**
	 * 查询指标字段明细列表
	 */
	@RequiresPermissions("bi:biIndexField:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiIndexField biIndexField)
	{
		startPage();
        List<BiIndexField> list = biIndexFieldService.selectBiIndexFieldList(biIndexField);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出指标字段明细列表
	 */
	@RequiresPermissions("bi:biIndexField:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiIndexField biIndexField)
    {
    	List<BiIndexField> list = biIndexFieldService.selectBiIndexFieldList(biIndexField);
        ExcelUtil<BiIndexField> util = new ExcelUtil<BiIndexField>(BiIndexField.class);
        return util.exportExcel(list, "biIndexField");
    }
    /**
     * 导入指标字段明细列表
     */
    @RequiresPermissions("bi:biIndexField:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiIndexField> util = new ExcelUtil<BiIndexField>(BiIndexField.class);
        List<BiIndexField> userList = util.importExcel(file.getInputStream());
        String message = biIndexFieldService.importBiIndexField(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 指标字段明细表格模板下载
	 * @return
	 */
    @RequiresPermissions("bi:biIndexField:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiIndexField> util = new ExcelUtil<BiIndexField>(BiIndexField.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增指标字段明细
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}


	/**
	 * 新增指标字段明细
	 */
	@GetMapping("/add/{indexNo}")
	public String add(@PathVariable String indexNo,ModelMap modelMap)
	{
		modelMap.put("indexNo",indexNo);

		//别名列表


		//属性列表

		return prefix + "/addAtIndexNo";
	}


	/**
	 * 新增保存指标字段明细
	 */
	@RequiresPermissions("bi:biIndexField:add")
	@Log(title = "指标字段明细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiIndexField biIndexField)
	{		
		return toAjax(biIndexFieldService.insertBiIndexField(biIndexField));
	}

	/**
	 * 修改指标字段明细
	 */
	@GetMapping("/edit/{fieldId}")
	public String edit(@PathVariable("fieldId") Integer fieldId, ModelMap mmap)
	{
		BiIndexField biIndexField = biIndexFieldService.selectBiIndexFieldById(fieldId);
		mmap.put("biIndexField", biIndexField);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存指标字段明细
	 */
	@RequiresPermissions("bi:biIndexField:edit")
	@Log(title = "指标字段明细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiIndexField biIndexField)
	{		
		return toAjax(biIndexFieldService.updateBiIndexField(biIndexField));
	}
	
	/**
	 * 删除指标字段明细
	 */
	@RequiresPermissions("bi:biIndexField:remove")
	@Log(title = "指标字段明细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biIndexFieldService.deleteBiIndexFieldByIds(ids));
	}



	
}
