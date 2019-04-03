package com.ruoyi.project.system.biScopeInfo.controller;

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
import com.ruoyi.project.system.biScopeInfo.domain.BiScopeInfo;
import com.ruoyi.project.system.biScopeInfo.service.IBiScopeInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 范围 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-03-18
 */
@Controller
@RequestMapping("/system/biScopeInfo")
public class BiScopeInfoController extends BaseController
{
    private String prefix = "system/biScopeInfo";
	
	@Autowired
	private IBiScopeInfoService biScopeInfoService;
	
	@RequiresPermissions("system:biScopeInfo:view")
	@GetMapping()
	public String biScopeInfo()
	{
	    return prefix + "/biScopeInfo";
	}
	
	/**
	 * 查询范围列表
	 */
	@RequiresPermissions("system:biScopeInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeInfo biScopeInfo)
	{
		startPage();
        List<BiScopeInfo> list = biScopeInfoService.selectBiScopeInfoList(biScopeInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出范围列表
	 */
	@RequiresPermissions("system:biScopeInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeInfo biScopeInfo)
    {
    	List<BiScopeInfo> list = biScopeInfoService.selectBiScopeInfoList(biScopeInfo);
        ExcelUtil<BiScopeInfo> util = new ExcelUtil<BiScopeInfo>(BiScopeInfo.class);
        return util.exportExcel(list, "biScopeInfo");
    }
    /**
     * 导入范围列表
     */
    @RequiresPermissions("system:biScopeInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeInfo> util = new ExcelUtil<BiScopeInfo>(BiScopeInfo.class);
        List<BiScopeInfo> userList = util.importExcel(file.getInputStream());
        String message = biScopeInfoService.importBiScopeInfo(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 范围表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeInfo> util = new ExcelUtil<BiScopeInfo>(BiScopeInfo.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增范围
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存范围
	 */
	@RequiresPermissions("system:biScopeInfo:add")
	@Log(title = "范围", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeInfo biScopeInfo)
	{		
		return toAjax(biScopeInfoService.insertBiScopeInfo(biScopeInfo));
	}

	/**
	 * 修改范围
	 */
	@GetMapping("/edit/{scopeId}")
	public String edit(@PathVariable("scopeId") Integer scopeId, ModelMap mmap)
	{
		BiScopeInfo biScopeInfo = biScopeInfoService.selectBiScopeInfoById(scopeId);
		mmap.put("biScopeInfo", biScopeInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存范围
	 */
	@RequiresPermissions("system:biScopeInfo:edit")
	@Log(title = "范围", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeInfo biScopeInfo)
	{		
		return toAjax(biScopeInfoService.updateBiScopeInfo(biScopeInfo));
	}
	
	/**
	 * 删除范围
	 */
	@RequiresPermissions("system:biScopeInfo:remove")
	@Log(title = "范围", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeInfoService.deleteBiScopeInfoByIds(ids));
	}



	
}
