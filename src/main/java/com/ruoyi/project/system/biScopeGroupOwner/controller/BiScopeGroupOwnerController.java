package com.ruoyi.project.system.biScopeGroupOwner.controller;

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
import com.ruoyi.project.system.biScopeGroupOwner.domain.BiScopeGroupOwner;
import com.ruoyi.project.system.biScopeGroupOwner.service.IBiScopeGroupOwnerService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 班组长 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-23
 */
@Controller
@RequestMapping("/system/biScopeGroupOwner")
public class BiScopeGroupOwnerController extends BaseController
{
    private String prefix = "system/biScopeGroupOwner";
	
	@Autowired
	private IBiScopeGroupOwnerService biScopeGroupOwnerService;
	
	@RequiresPermissions("system:biScopeGroupOwner:view")
	@GetMapping()
	public String biScopeGroupOwner()
	{
	    return prefix + "/biScopeGroupOwner";
	}
	
	/**
	 * 查询班组长列表
	 */
	@RequiresPermissions("system:biScopeGroupOwner:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeGroupOwner biScopeGroupOwner)
	{
		startPage();
        List<BiScopeGroupOwner> list = biScopeGroupOwnerService.selectBiScopeGroupOwnerList(biScopeGroupOwner);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出班组长列表
	 */
	@RequiresPermissions("system:biScopeGroupOwner:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeGroupOwner biScopeGroupOwner)
    {
    	List<BiScopeGroupOwner> list = biScopeGroupOwnerService.selectBiScopeGroupOwnerList(biScopeGroupOwner);
        ExcelUtil<BiScopeGroupOwner> util = new ExcelUtil<BiScopeGroupOwner>(BiScopeGroupOwner.class);
        return util.exportExcel(list, "biScopeGroupOwner");
    }
    /**
     * 导入班组长列表
     */
    @RequiresPermissions("system:biScopeGroupOwner:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeGroupOwner> util = new ExcelUtil<BiScopeGroupOwner>(BiScopeGroupOwner.class);
        List<BiScopeGroupOwner> userList = util.importExcel(file.getInputStream());
        String message = biScopeGroupOwnerService.importBiScopeGroupOwner(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 班组长表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeGroupOwner:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeGroupOwner> util = new ExcelUtil<BiScopeGroupOwner>(BiScopeGroupOwner.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增班组长
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存班组长
	 */
	@RequiresPermissions("system:biScopeGroupOwner:add")
	@Log(title = "班组长", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeGroupOwner biScopeGroupOwner)
	{		
		return toAjax(biScopeGroupOwnerService.insertBiScopeGroupOwner(biScopeGroupOwner));
	}

	/**
	 * 修改班组长
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeGroupOwner biScopeGroupOwner = biScopeGroupOwnerService.selectBiScopeGroupOwnerById(tid);
		mmap.put("biScopeGroupOwner", biScopeGroupOwner);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存班组长
	 */
	@RequiresPermissions("system:biScopeGroupOwner:edit")
	@Log(title = "班组长", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeGroupOwner biScopeGroupOwner)
	{		
		return toAjax(biScopeGroupOwnerService.updateBiScopeGroupOwner(biScopeGroupOwner));
	}
	
	/**
	 * 删除班组长
	 */
	@RequiresPermissions("system:biScopeGroupOwner:remove")
	@Log(title = "班组长", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeGroupOwnerService.deleteBiScopeGroupOwnerByIds(ids));
	}



	
}
