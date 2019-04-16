package com.ruoyi.project.system.biTemplateInfo.controller;

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
import com.ruoyi.project.system.biTemplateInfo.domain.BiTemplateInfo;
import com.ruoyi.project.system.biTemplateInfo.service.IBiTemplateInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 模板数据 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/biTemplateInfo")
public class BiTemplateInfoController extends BaseController
{
    private String prefix = "system/biTemplateInfo";
	
	@Autowired
	private IBiTemplateInfoService biTemplateInfoService;
	
	@RequiresPermissions("system:biTemplateInfo:view")
	@GetMapping()
	public String biTemplateInfo()
	{
	    return prefix + "/biTemplateInfo";
	}
	
	/**
	 * 查询模板数据列表
	 */
	@RequiresPermissions("system:biTemplateInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiTemplateInfo biTemplateInfo)
	{
		startPage();
        List<BiTemplateInfo> list = biTemplateInfoService.selectBiTemplateInfoList(biTemplateInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出模板数据列表
	 */
	@RequiresPermissions("system:biTemplateInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiTemplateInfo biTemplateInfo)
    {
    	List<BiTemplateInfo> list = biTemplateInfoService.selectBiTemplateInfoList(biTemplateInfo);
        ExcelUtil<BiTemplateInfo> util = new ExcelUtil<BiTemplateInfo>(BiTemplateInfo.class);
        return util.exportExcel(list, "biTemplateInfo");
    }
    /**
     * 导入模板数据列表
     */
    @RequiresPermissions("system:biTemplateInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiTemplateInfo> util = new ExcelUtil<BiTemplateInfo>(BiTemplateInfo.class);
        List<BiTemplateInfo> userList = util.importExcel(file.getInputStream());
        String message = biTemplateInfoService.importBiTemplateInfo(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 模板数据表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biTemplateInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiTemplateInfo> util = new ExcelUtil<BiTemplateInfo>(BiTemplateInfo.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增模板数据
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存模板数据
	 */
	@RequiresPermissions("system:biTemplateInfo:add")
	@Log(title = "模板数据", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiTemplateInfo biTemplateInfo)
	{		
		return toAjax(biTemplateInfoService.insertBiTemplateInfo(biTemplateInfo));
	}

	/**
	 * 修改模板数据
	 */
	@GetMapping("/edit/{templateId}")
	public String edit(@PathVariable("templateId") Integer templateId, ModelMap mmap)
	{
		BiTemplateInfo biTemplateInfo = biTemplateInfoService.selectBiTemplateInfoById(templateId);
		mmap.put("biTemplateInfo", biTemplateInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存模板数据
	 */
	@RequiresPermissions("system:biTemplateInfo:edit")
	@Log(title = "模板数据", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiTemplateInfo biTemplateInfo)
	{		
		return toAjax(biTemplateInfoService.updateBiTemplateInfo(biTemplateInfo));
	}
	
	/**
	 * 删除模板数据
	 */
	@RequiresPermissions("system:biTemplateInfo:remove")
	@Log(title = "模板数据", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biTemplateInfoService.deleteBiTemplateInfoByIds(ids));
	}



	
}
