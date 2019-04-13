package com.ruoyi.project.system.biScopeComplaintLogAttach.controller;

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
import com.ruoyi.project.system.biScopeComplaintLogAttach.domain.BiScopeComplaintLogAttach;
import com.ruoyi.project.system.biScopeComplaintLogAttach.service.IBiScopeComplaintLogAttachService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 维权日志附件 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Controller
@RequestMapping("/system/biScopeComplaintLogAttach")
public class BiScopeComplaintLogAttachController extends BaseController
{
    private String prefix = "system/biScopeComplaintLogAttach";
	
	@Autowired
	private IBiScopeComplaintLogAttachService biScopeComplaintLogAttachService;
	
	@RequiresPermissions("system:biScopeComplaintLogAttach:view")
	@GetMapping()
	public String biScopeComplaintLogAttach()
	{
	    return prefix + "/biScopeComplaintLogAttach";
	}
	
	/**
	 * 查询维权日志附件列表
	 */
	@RequiresPermissions("system:biScopeComplaintLogAttach:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeComplaintLogAttach biScopeComplaintLogAttach)
	{
		startPage();
        List<BiScopeComplaintLogAttach> list = biScopeComplaintLogAttachService.selectBiScopeComplaintLogAttachList(biScopeComplaintLogAttach);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出维权日志附件列表
	 */
	@RequiresPermissions("system:biScopeComplaintLogAttach:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeComplaintLogAttach biScopeComplaintLogAttach)
    {
    	List<BiScopeComplaintLogAttach> list = biScopeComplaintLogAttachService.selectBiScopeComplaintLogAttachList(biScopeComplaintLogAttach);
        ExcelUtil<BiScopeComplaintLogAttach> util = new ExcelUtil<BiScopeComplaintLogAttach>(BiScopeComplaintLogAttach.class);
        return util.exportExcel(list, "biScopeComplaintLogAttach");
    }
    /**
     * 导入维权日志附件列表
     */
    @RequiresPermissions("system:biScopeComplaintLogAttach:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeComplaintLogAttach> util = new ExcelUtil<BiScopeComplaintLogAttach>(BiScopeComplaintLogAttach.class);
        List<BiScopeComplaintLogAttach> userList = util.importExcel(file.getInputStream());
        String message = biScopeComplaintLogAttachService.importBiScopeComplaintLogAttach(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 维权日志附件表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeComplaintLogAttach:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeComplaintLogAttach> util = new ExcelUtil<BiScopeComplaintLogAttach>(BiScopeComplaintLogAttach.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增维权日志附件
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存维权日志附件
	 */
	@RequiresPermissions("system:biScopeComplaintLogAttach:add")
	@Log(title = "维权日志附件", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeComplaintLogAttach biScopeComplaintLogAttach)
	{		
		return toAjax(biScopeComplaintLogAttachService.insertBiScopeComplaintLogAttach(biScopeComplaintLogAttach));
	}

	/**
	 * 修改维权日志附件
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeComplaintLogAttach biScopeComplaintLogAttach = biScopeComplaintLogAttachService.selectBiScopeComplaintLogAttachById(tid);
		mmap.put("biScopeComplaintLogAttach", biScopeComplaintLogAttach);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存维权日志附件
	 */
	@RequiresPermissions("system:biScopeComplaintLogAttach:edit")
	@Log(title = "维权日志附件", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeComplaintLogAttach biScopeComplaintLogAttach)
	{		
		return toAjax(biScopeComplaintLogAttachService.updateBiScopeComplaintLogAttach(biScopeComplaintLogAttach));
	}
	
	/**
	 * 删除维权日志附件
	 */
	@RequiresPermissions("system:biScopeComplaintLogAttach:remove")
	@Log(title = "维权日志附件", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeComplaintLogAttachService.deleteBiScopeComplaintLogAttachByIds(ids));
	}



	
}
