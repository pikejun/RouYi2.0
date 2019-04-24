package com.ruoyi.project.system.biIndexDisplay.controller;

import java.util.List;

import com.ruoyi.project.system.biIndexField.domain.BiIndexField;
import com.ruoyi.project.system.biIndexField.service.IBiIndexFieldService;
import com.ruoyi.project.system.biIndexInfo.domain.BiIndexInfo;
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
import com.ruoyi.project.system.biIndexDisplay.domain.BiIndexDisplay;
import com.ruoyi.project.system.biIndexDisplay.service.IBiIndexDisplayService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 指标展示 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-18
 */
@Controller
@RequestMapping("/system/biIndexDisplay")
public class BiIndexDisplayController extends BaseController
{
    private String prefix = "system/biIndexDisplay";
	
	@Autowired
	private IBiIndexDisplayService biIndexDisplayService;

	@Autowired
	private IBiIndexFieldService iBiIndexFieldService;
	
	@RequiresPermissions("bi:biIndexDisplay:view")
	@GetMapping()
	public String biIndexDisplay()
	{
	    return prefix + "/biIndexDisplay";
	}

	@RequiresPermissions("bi:biIndexDisplay:view")
	@GetMapping("{indexNo}")
	public String biIndexDisplay(@PathVariable String indexNo,ModelMap mmap)
	{
		mmap.put("indexNo",indexNo);

		return prefix + "/biIndexDisplayAtIndexNo";
	}
	
	/**
	 * 查询指标展示列表
	 */
	@RequiresPermissions("bi:biIndexDisplay:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiIndexDisplay biIndexDisplay)
	{
		startPage();
        List<BiIndexDisplay> list = biIndexDisplayService.selectBiIndexDisplayList(biIndexDisplay);
		return getDataTable(list);
	}


	/**
	 * 查询指标展示列表
	 */
	@RequiresPermissions("bi:biIndexDisplay:list")
	@PostMapping("/list/{indexNo}")
	@ResponseBody
	public TableDataInfo list(BiIndexDisplay biIndexDisplay,@PathVariable String indexNo)
	{
		biIndexDisplay.setIndexNo(indexNo);
		List<BiIndexDisplay> list = biIndexDisplayService.selectBiIndexDisplayList(biIndexDisplay);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出指标展示列表
	 */
	@RequiresPermissions("bi:biIndexDisplay:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiIndexDisplay biIndexDisplay)
    {
    	List<BiIndexDisplay> list = biIndexDisplayService.selectBiIndexDisplayList(biIndexDisplay);
        ExcelUtil<BiIndexDisplay> util = new ExcelUtil<BiIndexDisplay>(BiIndexDisplay.class);
        return util.exportExcel(list, "biIndexDisplay");
    }
    /**
     * 导入指标展示列表
     */
    @RequiresPermissions("bi:biIndexDisplay:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiIndexDisplay> util = new ExcelUtil<BiIndexDisplay>(BiIndexDisplay.class);
        List<BiIndexDisplay> userList = util.importExcel(file.getInputStream());
        String message = biIndexDisplayService.importBiIndexDisplay(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 指标展示表格模板下载
	 * @return
	 */
    @RequiresPermissions("bi:biIndexDisplay:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiIndexDisplay> util = new ExcelUtil<BiIndexDisplay>(BiIndexDisplay.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增指标展示
	 */
	@RequiresPermissions("bi:add:view")
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}

	/**
	 * 新增指标展示
	 */
	@RequiresPermissions("bi:add:indexNo")
	@GetMapping("/add/{indexNo}")
	public String add(@PathVariable String indexNo, ModelMap mmap)
	{
		mmap.put("indexNo",indexNo);

		//按指标编号 查询出可用的变量字段明列表
		BiIndexField biIndexField=new BiIndexField();
		biIndexField.setIndexNo(indexNo);
		List<BiIndexField> list =iBiIndexFieldService.selectBiIndexFieldList(biIndexField);
		StringBuilder sb=new StringBuilder();
		if(list!=null&&list.size()>0)
		{
			for(BiIndexField field:list)
			{
				if(sb.length()>0)
				{
					sb.append(" , ");
				}
				sb.append("@").append(field.getFieldName()).append("@");
			}
		}

		mmap.put("paramStr",sb.toString());

		return prefix + "/addAtIndexNo";
	}
	
	/**
	 * 新增保存指标展示
	 */
	@RequiresPermissions("bi:biIndexDisplay:add")
	@Log(title = "指标展示", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiIndexDisplay biIndexDisplay)
	{		
		return toAjax(biIndexDisplayService.insertBiIndexDisplay(biIndexDisplay));
	}

	/**
	 * 修改指标展示
	 */
	@RequiresPermissions("bi:edit:view")
	@GetMapping("/edit/{displayId}")
	public String edit(@PathVariable("displayId") Integer displayId, ModelMap mmap)
	{

		BiIndexDisplay biIndexDisplay = biIndexDisplayService.selectBiIndexDisplayById(displayId);
		mmap.put("biIndexDisplay", biIndexDisplay);

		//按指标编号 查询出可用的变量字段明列表
		BiIndexField biIndexField=new BiIndexField();
		biIndexField.setIndexNo(biIndexDisplay.getIndexNo());
		List<BiIndexField> list =iBiIndexFieldService.selectBiIndexFieldList(biIndexField);
		StringBuilder sb=new StringBuilder();
		if(list!=null&&list.size()>0)
		{
			for(BiIndexField field:list)
			{
				if(sb.length()>0)
				{
					sb.append(" , ");
				}
				sb.append("@").append(field.getFieldName()).append("@");
			}
		}

		mmap.put("paramStr",sb.toString());


	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存指标展示
	 */
	@RequiresPermissions("bi:biIndexDisplay:edit")
	@Log(title = "指标展示", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiIndexDisplay biIndexDisplay)
	{		
		return toAjax(biIndexDisplayService.updateBiIndexDisplay(biIndexDisplay));
	}
	
	/**
	 * 删除指标展示
	 */
	@RequiresPermissions("bi:biIndexDisplay:remove")
	@Log(title = "指标展示", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biIndexDisplayService.deleteBiIndexDisplayByIds(ids));
	}

	/**
	 * 预览指标
	 * @return
	 */
	@RequiresPermissions("bi:display:displayId")
	@GetMapping("/display/{displayId}")
	public String display(@PathVariable("displayId") Integer displayId, ModelMap mmap)
	{
		mmap.put("biIndexDisplay", biIndexDisplayService.selectBiIndexDisplayById(displayId));
		mmap.put("content", biIndexDisplayService.getDisplayHtml(displayId));
		String ret= prefix + "/display";

		return ret;
	}



	
}
