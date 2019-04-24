package com.ruoyi.project.system.biScopeEnterpriseDepartment.controller;

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
import com.ruoyi.project.system.biScopeEnterpriseDepartment.domain.BiScopeEnterpriseDepartment;
import com.ruoyi.project.system.biScopeEnterpriseDepartment.service.IBiScopeEnterpriseDepartmentService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 企业部门 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-08
 */
@Controller
@RequestMapping("/system/biScopeEnterpriseDepartment")
public class BiScopeEnterpriseDepartmentController extends BaseController
{
    private String prefix = "system/biScopeEnterpriseDepartment";
	
	@Autowired
	private IBiScopeEnterpriseDepartmentService biScopeEnterpriseDepartmentService;
	
	@RequiresPermissions("bi:biScopeEnterpriseDepartment:view")
	@GetMapping()
	public String biScopeEnterpriseDepartment()
	{
	    return prefix + "/biScopeEnterpriseDepartment";
	}
	
	/**
	 * 查询企业部门列表
	 */
	@RequiresPermissions("bi:biScopeEnterpriseDepartment:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeEnterpriseDepartment biScopeEnterpriseDepartment)
	{
		startPage();
        List<BiScopeEnterpriseDepartment> list = biScopeEnterpriseDepartmentService.selectBiScopeEnterpriseDepartmentList(biScopeEnterpriseDepartment);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业部门列表
	 */
	@RequiresPermissions("bi:biScopeEnterpriseDepartment:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeEnterpriseDepartment biScopeEnterpriseDepartment)
    {
    	List<BiScopeEnterpriseDepartment> list = biScopeEnterpriseDepartmentService.selectBiScopeEnterpriseDepartmentList(biScopeEnterpriseDepartment);
        ExcelUtil<BiScopeEnterpriseDepartment> util = new ExcelUtil<BiScopeEnterpriseDepartment>(BiScopeEnterpriseDepartment.class);
        return util.exportExcel(list, "biScopeEnterpriseDepartment");
    }
    /**
     * 导入企业部门列表
     */
    @RequiresPermissions("bi:biScopeEnterpriseDepartment:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeEnterpriseDepartment> util = new ExcelUtil<BiScopeEnterpriseDepartment>(BiScopeEnterpriseDepartment.class);
        List<BiScopeEnterpriseDepartment> userList = util.importExcel(file.getInputStream());
        String message = biScopeEnterpriseDepartmentService.importBiScopeEnterpriseDepartment(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 企业部门表格模板下载
	 * @return
	 */
    @RequiresPermissions("bi:biScopeEnterpriseDepartment:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeEnterpriseDepartment> util = new ExcelUtil<BiScopeEnterpriseDepartment>(BiScopeEnterpriseDepartment.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增企业部门
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存企业部门
	 */
	@RequiresPermissions("bi:biScopeEnterpriseDepartment:add")
	@Log(title = "企业部门", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeEnterpriseDepartment biScopeEnterpriseDepartment)
	{		
		return toAjax(biScopeEnterpriseDepartmentService.insertBiScopeEnterpriseDepartment(biScopeEnterpriseDepartment));
	}

	/**
	 * 修改企业部门
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeEnterpriseDepartment biScopeEnterpriseDepartment = biScopeEnterpriseDepartmentService.selectBiScopeEnterpriseDepartmentById(tid);
		mmap.put("biScopeEnterpriseDepartment", biScopeEnterpriseDepartment);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存企业部门
	 */
	@RequiresPermissions("bi:biScopeEnterpriseDepartment:edit")
	@Log(title = "企业部门", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeEnterpriseDepartment biScopeEnterpriseDepartment)
	{		
		return toAjax(biScopeEnterpriseDepartmentService.updateBiScopeEnterpriseDepartment(biScopeEnterpriseDepartment));
	}
	
	/**
	 * 删除企业部门
	 */
	@RequiresPermissions("bi:biScopeEnterpriseDepartment:remove")
	@Log(title = "企业部门", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeEnterpriseDepartmentService.deleteBiScopeEnterpriseDepartmentByIds(ids));
	}



	
}
