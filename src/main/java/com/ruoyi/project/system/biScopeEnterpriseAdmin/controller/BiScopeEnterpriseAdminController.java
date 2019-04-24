package com.ruoyi.project.system.biScopeEnterpriseAdmin.controller;

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
import com.ruoyi.project.system.biScopeEnterpriseAdmin.domain.BiScopeEnterpriseAdmin;
import com.ruoyi.project.system.biScopeEnterpriseAdmin.service.IBiScopeEnterpriseAdminService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 企业管理员 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-17
 */
@Controller
@RequestMapping("/system/biScopeEnterpriseAdmin")
public class BiScopeEnterpriseAdminController extends BaseController
{
    private String prefix = "system/biScopeEnterpriseAdmin";
	
	@Autowired
	private IBiScopeEnterpriseAdminService biScopeEnterpriseAdminService;
	
	@RequiresPermissions("bi:biScopeEnterpriseAdmin:view")
	@GetMapping()
	public String biScopeEnterpriseAdmin()
	{
	    return prefix + "/biScopeEnterpriseAdmin";
	}
	
	/**
	 * 查询企业管理员列表
	 */
	@RequiresPermissions("bi:biScopeEnterpriseAdmin:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeEnterpriseAdmin biScopeEnterpriseAdmin)
	{
		startPage();
        List<BiScopeEnterpriseAdmin> list = biScopeEnterpriseAdminService.selectBiScopeEnterpriseAdminList(biScopeEnterpriseAdmin);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业管理员列表
	 */
	@RequiresPermissions("bi:biScopeEnterpriseAdmin:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeEnterpriseAdmin biScopeEnterpriseAdmin)
    {
    	List<BiScopeEnterpriseAdmin> list = biScopeEnterpriseAdminService.selectBiScopeEnterpriseAdminList(biScopeEnterpriseAdmin);
        ExcelUtil<BiScopeEnterpriseAdmin> util = new ExcelUtil<BiScopeEnterpriseAdmin>(BiScopeEnterpriseAdmin.class);
        return util.exportExcel(list, "biScopeEnterpriseAdmin");
    }
    /**
     * 导入企业管理员列表
     */
    @RequiresPermissions("bi:biScopeEnterpriseAdmin:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeEnterpriseAdmin> util = new ExcelUtil<BiScopeEnterpriseAdmin>(BiScopeEnterpriseAdmin.class);
        List<BiScopeEnterpriseAdmin> userList = util.importExcel(file.getInputStream());
        String message = biScopeEnterpriseAdminService.importBiScopeEnterpriseAdmin(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 企业管理员表格模板下载
	 * @return
	 */
    @RequiresPermissions("bi:biScopeEnterpriseAdmin:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeEnterpriseAdmin> util = new ExcelUtil<BiScopeEnterpriseAdmin>(BiScopeEnterpriseAdmin.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增企业管理员
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存企业管理员
	 */
	@RequiresPermissions("bi:biScopeEnterpriseAdmin:add")
	@Log(title = "企业管理员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeEnterpriseAdmin biScopeEnterpriseAdmin)
	{		
		return toAjax(biScopeEnterpriseAdminService.insertBiScopeEnterpriseAdmin(biScopeEnterpriseAdmin));
	}

	/**
	 * 修改企业管理员
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeEnterpriseAdmin biScopeEnterpriseAdmin = biScopeEnterpriseAdminService.selectBiScopeEnterpriseAdminById(tid);
		mmap.put("biScopeEnterpriseAdmin", biScopeEnterpriseAdmin);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存企业管理员
	 */
	@RequiresPermissions("bi:biScopeEnterpriseAdmin:edit")
	@Log(title = "企业管理员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeEnterpriseAdmin biScopeEnterpriseAdmin)
	{		
		return toAjax(biScopeEnterpriseAdminService.updateBiScopeEnterpriseAdmin(biScopeEnterpriseAdmin));
	}
	
	/**
	 * 删除企业管理员
	 */
	@RequiresPermissions("bi:biScopeEnterpriseAdmin:remove")
	@Log(title = "企业管理员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeEnterpriseAdminService.deleteBiScopeEnterpriseAdminByIds(ids));
	}



	
}
