package com.ruoyi.project.system.biScopeTrainAttach.controller;

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
import com.ruoyi.project.system.biScopeTrainAttach.domain.BiScopeTrainAttach;
import com.ruoyi.project.system.biScopeTrainAttach.service.IBiScopeTrainAttachService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 培训附件 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Controller
@RequestMapping("/system/biScopeTrainAttach")
public class BiScopeTrainAttachController extends BaseController
{
    private String prefix = "system/biScopeTrainAttach";
	
	@Autowired
	private IBiScopeTrainAttachService biScopeTrainAttachService;
	
	@RequiresPermissions("system:biScopeTrainAttach:view")
	@GetMapping()
	public String biScopeTrainAttach()
	{
	    return prefix + "/biScopeTrainAttach";
	}
	
	/**
	 * 查询培训附件列表
	 */
	@RequiresPermissions("system:biScopeTrainAttach:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeTrainAttach biScopeTrainAttach)
	{
		startPage();
        List<BiScopeTrainAttach> list = biScopeTrainAttachService.selectBiScopeTrainAttachList(biScopeTrainAttach);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出培训附件列表
	 */
	@RequiresPermissions("system:biScopeTrainAttach:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeTrainAttach biScopeTrainAttach)
    {
    	List<BiScopeTrainAttach> list = biScopeTrainAttachService.selectBiScopeTrainAttachList(biScopeTrainAttach);
        ExcelUtil<BiScopeTrainAttach> util = new ExcelUtil<BiScopeTrainAttach>(BiScopeTrainAttach.class);
        return util.exportExcel(list, "biScopeTrainAttach");
    }
    /**
     * 导入培训附件列表
     */
    @RequiresPermissions("system:biScopeTrainAttach:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeTrainAttach> util = new ExcelUtil<BiScopeTrainAttach>(BiScopeTrainAttach.class);
        List<BiScopeTrainAttach> userList = util.importExcel(file.getInputStream());
        String message = biScopeTrainAttachService.importBiScopeTrainAttach(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 培训附件表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeTrainAttach:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeTrainAttach> util = new ExcelUtil<BiScopeTrainAttach>(BiScopeTrainAttach.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增培训附件
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存培训附件
	 */
	@RequiresPermissions("system:biScopeTrainAttach:add")
	@Log(title = "培训附件", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeTrainAttach biScopeTrainAttach)
	{		
		return toAjax(biScopeTrainAttachService.insertBiScopeTrainAttach(biScopeTrainAttach));
	}

	/**
	 * 修改培训附件
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeTrainAttach biScopeTrainAttach = biScopeTrainAttachService.selectBiScopeTrainAttachById(tid);
		mmap.put("biScopeTrainAttach", biScopeTrainAttach);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存培训附件
	 */
	@RequiresPermissions("system:biScopeTrainAttach:edit")
	@Log(title = "培训附件", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeTrainAttach biScopeTrainAttach)
	{		
		return toAjax(biScopeTrainAttachService.updateBiScopeTrainAttach(biScopeTrainAttach));
	}
	
	/**
	 * 删除培训附件
	 */
	@RequiresPermissions("system:biScopeTrainAttach:remove")
	@Log(title = "培训附件", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeTrainAttachService.deleteBiScopeTrainAttachByIds(ids));
	}



	
}
