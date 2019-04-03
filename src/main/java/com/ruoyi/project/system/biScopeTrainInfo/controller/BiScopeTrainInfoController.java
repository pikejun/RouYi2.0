package com.ruoyi.project.system.biScopeTrainInfo.controller;

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
import com.ruoyi.project.system.biScopeTrainInfo.domain.BiScopeTrainInfo;
import com.ruoyi.project.system.biScopeTrainInfo.service.IBiScopeTrainInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 培训 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-03
 */
@Controller
@RequestMapping("/system/biScopeTrainInfo")
public class BiScopeTrainInfoController extends BaseController
{
    private String prefix = "system/biScopeTrainInfo";
	
	@Autowired
	private IBiScopeTrainInfoService biScopeTrainInfoService;
	
	@RequiresPermissions("system:biScopeTrainInfo:view")
	@GetMapping()
	public String biScopeTrainInfo()
	{
	    return prefix + "/biScopeTrainInfo";
	}
	
	/**
	 * 查询培训列表
	 */
	@RequiresPermissions("system:biScopeTrainInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeTrainInfo biScopeTrainInfo)
	{
		startPage();
        List<BiScopeTrainInfo> list = biScopeTrainInfoService.selectBiScopeTrainInfoList(biScopeTrainInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出培训列表
	 */
	@RequiresPermissions("system:biScopeTrainInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeTrainInfo biScopeTrainInfo)
    {
    	List<BiScopeTrainInfo> list = biScopeTrainInfoService.selectBiScopeTrainInfoList(biScopeTrainInfo);
        ExcelUtil<BiScopeTrainInfo> util = new ExcelUtil<BiScopeTrainInfo>(BiScopeTrainInfo.class);
        return util.exportExcel(list, "biScopeTrainInfo");
    }
    /**
     * 导入培训列表
     */
    @RequiresPermissions("system:biScopeTrainInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeTrainInfo> util = new ExcelUtil<BiScopeTrainInfo>(BiScopeTrainInfo.class);
        List<BiScopeTrainInfo> userList = util.importExcel(file.getInputStream());
        String message = biScopeTrainInfoService.importBiScopeTrainInfo(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 培训表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeTrainInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeTrainInfo> util = new ExcelUtil<BiScopeTrainInfo>(BiScopeTrainInfo.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增培训
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存培训
	 */
	@RequiresPermissions("system:biScopeTrainInfo:add")
	@Log(title = "培训", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeTrainInfo biScopeTrainInfo)
	{		
		return toAjax(biScopeTrainInfoService.insertBiScopeTrainInfo(biScopeTrainInfo));
	}

	/**
	 * 修改培训
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeTrainInfo biScopeTrainInfo = biScopeTrainInfoService.selectBiScopeTrainInfoById(tid);
		mmap.put("biScopeTrainInfo", biScopeTrainInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存培训
	 */
	@RequiresPermissions("system:biScopeTrainInfo:edit")
	@Log(title = "培训", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeTrainInfo biScopeTrainInfo)
	{		
		return toAjax(biScopeTrainInfoService.updateBiScopeTrainInfo(biScopeTrainInfo));
	}
	
	/**
	 * 删除培训
	 */
	@RequiresPermissions("system:biScopeTrainInfo:remove")
	@Log(title = "培训", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeTrainInfoService.deleteBiScopeTrainInfoByIds(ids));
	}



	
}
