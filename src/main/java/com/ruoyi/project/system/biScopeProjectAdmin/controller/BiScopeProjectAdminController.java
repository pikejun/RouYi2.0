package com.ruoyi.project.system.biScopeProjectAdmin.controller;

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
import com.ruoyi.project.system.biScopeProjectAdmin.domain.BiScopeProjectAdmin;
import com.ruoyi.project.system.biScopeProjectAdmin.service.IBiScopeProjectAdminService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目管理员 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/biScopeProjectAdmin")
public class BiScopeProjectAdminController extends BaseController
{
    private String prefix = "system/biScopeProjectAdmin";
	
	@Autowired
	private IBiScopeProjectAdminService biScopeProjectAdminService;
	
	@RequiresPermissions("system:biScopeProjectAdmin:view")
	@GetMapping()
	public String biScopeProjectAdmin()
	{
	    return prefix + "/biScopeProjectAdmin";
	}
	
	/**
	 * 查询项目管理员列表
	 */
	@RequiresPermissions("system:biScopeProjectAdmin:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeProjectAdmin biScopeProjectAdmin)
	{
		startPage();
        List<BiScopeProjectAdmin> list = biScopeProjectAdminService.selectBiScopeProjectAdminList(biScopeProjectAdmin);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出项目管理员列表
	 */
	@RequiresPermissions("system:biScopeProjectAdmin:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeProjectAdmin biScopeProjectAdmin)
    {
    	List<BiScopeProjectAdmin> list = biScopeProjectAdminService.selectBiScopeProjectAdminList(biScopeProjectAdmin);
        ExcelUtil<BiScopeProjectAdmin> util = new ExcelUtil<BiScopeProjectAdmin>(BiScopeProjectAdmin.class);
        return util.exportExcel(list, "biScopeProjectAdmin");
    }
    /**
     * 导入项目管理员列表
     */
    @RequiresPermissions("system:biScopeProjectAdmin:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeProjectAdmin> util = new ExcelUtil<BiScopeProjectAdmin>(BiScopeProjectAdmin.class);
        List<BiScopeProjectAdmin> userList = util.importExcel(file.getInputStream());
        String message = biScopeProjectAdminService.importBiScopeProjectAdmin(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 项目管理员表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeProjectAdmin:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeProjectAdmin> util = new ExcelUtil<BiScopeProjectAdmin>(BiScopeProjectAdmin.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增项目管理员
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存项目管理员
	 */
	@RequiresPermissions("system:biScopeProjectAdmin:add")
	@Log(title = "项目管理员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeProjectAdmin biScopeProjectAdmin)
	{		
		return toAjax(biScopeProjectAdminService.insertBiScopeProjectAdmin(biScopeProjectAdmin));
	}

	/**
	 * 修改项目管理员
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeProjectAdmin biScopeProjectAdmin = biScopeProjectAdminService.selectBiScopeProjectAdminById(tid);
		mmap.put("biScopeProjectAdmin", biScopeProjectAdmin);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存项目管理员
	 */
	@RequiresPermissions("system:biScopeProjectAdmin:edit")
	@Log(title = "项目管理员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeProjectAdmin biScopeProjectAdmin)
	{		
		return toAjax(biScopeProjectAdminService.updateBiScopeProjectAdmin(biScopeProjectAdmin));
	}
	
	/**
	 * 删除项目管理员
	 */
	@RequiresPermissions("system:biScopeProjectAdmin:remove")
	@Log(title = "项目管理员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeProjectAdminService.deleteBiScopeProjectAdminByIds(ids));
	}



	
}
