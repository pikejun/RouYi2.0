package com.ruoyi.project.system.biScopeComplaintInfo.controller;

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
import com.ruoyi.project.system.biScopeComplaintInfo.domain.BiScopeComplaintInfo;
import com.ruoyi.project.system.biScopeComplaintInfo.service.IBiScopeComplaintInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工人维权 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-11
 */
@Controller
@RequestMapping("/system/biScopeComplaintInfo")
public class BiScopeComplaintInfoController extends BaseController
{
    private String prefix = "system/biScopeComplaintInfo";
	
	@Autowired
	private IBiScopeComplaintInfoService biScopeComplaintInfoService;
	
	@RequiresPermissions("system:biScopeComplaintInfo:view")
	@GetMapping()
	public String biScopeComplaintInfo()
	{
	    return prefix + "/biScopeComplaintInfo";
	}
	
	/**
	 * 查询工人维权列表
	 */
	@RequiresPermissions("system:biScopeComplaintInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeComplaintInfo biScopeComplaintInfo)
	{
		startPage();
        List<BiScopeComplaintInfo> list = biScopeComplaintInfoService.selectBiScopeComplaintInfoList(biScopeComplaintInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出工人维权列表
	 */
	@RequiresPermissions("system:biScopeComplaintInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeComplaintInfo biScopeComplaintInfo)
    {
    	List<BiScopeComplaintInfo> list = biScopeComplaintInfoService.selectBiScopeComplaintInfoList(biScopeComplaintInfo);
        ExcelUtil<BiScopeComplaintInfo> util = new ExcelUtil<BiScopeComplaintInfo>(BiScopeComplaintInfo.class);
        return util.exportExcel(list, "biScopeComplaintInfo");
    }
    /**
     * 导入工人维权列表
     */
    @RequiresPermissions("system:biScopeComplaintInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeComplaintInfo> util = new ExcelUtil<BiScopeComplaintInfo>(BiScopeComplaintInfo.class);
        List<BiScopeComplaintInfo> userList = util.importExcel(file.getInputStream());
        String message = biScopeComplaintInfoService.importBiScopeComplaintInfo(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 工人维权表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeComplaintInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeComplaintInfo> util = new ExcelUtil<BiScopeComplaintInfo>(BiScopeComplaintInfo.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增工人维权
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存工人维权
	 */
	@RequiresPermissions("system:biScopeComplaintInfo:add")
	@Log(title = "工人维权", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeComplaintInfo biScopeComplaintInfo)
	{		
		return toAjax(biScopeComplaintInfoService.insertBiScopeComplaintInfo(biScopeComplaintInfo));
	}

	/**
	 * 修改工人维权
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeComplaintInfo biScopeComplaintInfo = biScopeComplaintInfoService.selectBiScopeComplaintInfoById(tid);
		mmap.put("biScopeComplaintInfo", biScopeComplaintInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工人维权
	 */
	@RequiresPermissions("system:biScopeComplaintInfo:edit")
	@Log(title = "工人维权", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeComplaintInfo biScopeComplaintInfo)
	{		
		return toAjax(biScopeComplaintInfoService.updateBiScopeComplaintInfo(biScopeComplaintInfo));
	}
	
	/**
	 * 删除工人维权
	 */
	@RequiresPermissions("system:biScopeComplaintInfo:remove")
	@Log(title = "工人维权", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeComplaintInfoService.deleteBiScopeComplaintInfoByIds(ids));
	}



	
}
