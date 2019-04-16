package com.ruoyi.project.system.biTemplateIndex.controller;

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
import com.ruoyi.project.system.biTemplateIndex.domain.BiTemplateIndex;
import com.ruoyi.project.system.biTemplateIndex.service.IBiTemplateIndexService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 模板指标明细 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/biTemplateIndex")
public class BiTemplateIndexController extends BaseController
{
    private String prefix = "system/biTemplateIndex";
	
	@Autowired
	private IBiTemplateIndexService biTemplateIndexService;
	
	@RequiresPermissions("system:biTemplateIndex:view")
	@GetMapping()
	public String biTemplateIndex()
	{
	    return prefix + "/biTemplateIndex";
	}
	
	/**
	 * 查询模板指标明细列表
	 */
	@RequiresPermissions("system:biTemplateIndex:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiTemplateIndex biTemplateIndex)
	{
		startPage();
        List<BiTemplateIndex> list = biTemplateIndexService.selectBiTemplateIndexList(biTemplateIndex);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出模板指标明细列表
	 */
	@RequiresPermissions("system:biTemplateIndex:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiTemplateIndex biTemplateIndex)
    {
    	List<BiTemplateIndex> list = biTemplateIndexService.selectBiTemplateIndexList(biTemplateIndex);
        ExcelUtil<BiTemplateIndex> util = new ExcelUtil<BiTemplateIndex>(BiTemplateIndex.class);
        return util.exportExcel(list, "biTemplateIndex");
    }
    /**
     * 导入模板指标明细列表
     */
    @RequiresPermissions("system:biTemplateIndex:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiTemplateIndex> util = new ExcelUtil<BiTemplateIndex>(BiTemplateIndex.class);
        List<BiTemplateIndex> userList = util.importExcel(file.getInputStream());
        String message = biTemplateIndexService.importBiTemplateIndex(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 模板指标明细表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biTemplateIndex:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiTemplateIndex> util = new ExcelUtil<BiTemplateIndex>(BiTemplateIndex.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增模板指标明细
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存模板指标明细
	 */
	@RequiresPermissions("system:biTemplateIndex:add")
	@Log(title = "模板指标明细", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiTemplateIndex biTemplateIndex)
	{		
		return toAjax(biTemplateIndexService.insertBiTemplateIndex(biTemplateIndex));
	}

	/**
	 * 修改模板指标明细
	 */
	@GetMapping("/edit/{tiid}")
	public String edit(@PathVariable("tiid") Integer tiid, ModelMap mmap)
	{
		BiTemplateIndex biTemplateIndex = biTemplateIndexService.selectBiTemplateIndexById(tiid);
		mmap.put("biTemplateIndex", biTemplateIndex);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存模板指标明细
	 */
	@RequiresPermissions("system:biTemplateIndex:edit")
	@Log(title = "模板指标明细", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiTemplateIndex biTemplateIndex)
	{		
		return toAjax(biTemplateIndexService.updateBiTemplateIndex(biTemplateIndex));
	}
	
	/**
	 * 删除模板指标明细
	 */
	@RequiresPermissions("system:biTemplateIndex:remove")
	@Log(title = "模板指标明细", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biTemplateIndexService.deleteBiTemplateIndexByIds(ids));
	}



	
}
