package com.ruoyi.project.system.biScopeAttendInfo.controller;

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
import com.ruoyi.project.system.biScopeAttendInfo.domain.BiScopeAttendInfo;
import com.ruoyi.project.system.biScopeAttendInfo.service.IBiScopeAttendInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 考勤 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-11
 */
@Controller
@RequestMapping("/system/biScopeAttendInfo")
public class BiScopeAttendInfoController extends BaseController
{
    private String prefix = "system/biScopeAttendInfo";
	
	@Autowired
	private IBiScopeAttendInfoService biScopeAttendInfoService;
	
	@RequiresPermissions("bi:biScopeAttendInfo:view")
	@GetMapping()
	public String biScopeAttendInfo()
	{
	    return prefix + "/biScopeAttendInfo";
	}
	
	/**
	 * 查询考勤列表
	 */
	@RequiresPermissions("bi:biScopeAttendInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeAttendInfo biScopeAttendInfo)
	{
		startPage();
        List<BiScopeAttendInfo> list = biScopeAttendInfoService.selectBiScopeAttendInfoList(biScopeAttendInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出考勤列表
	 */
	@RequiresPermissions("bi:biScopeAttendInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeAttendInfo biScopeAttendInfo)
    {
    	List<BiScopeAttendInfo> list = biScopeAttendInfoService.selectBiScopeAttendInfoList(biScopeAttendInfo);
        ExcelUtil<BiScopeAttendInfo> util = new ExcelUtil<BiScopeAttendInfo>(BiScopeAttendInfo.class);
        return util.exportExcel(list, "biScopeAttendInfo");
    }
    /**
     * 导入考勤列表
     */
    @RequiresPermissions("bi:biScopeAttendInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeAttendInfo> util = new ExcelUtil<BiScopeAttendInfo>(BiScopeAttendInfo.class);
        List<BiScopeAttendInfo> userList = util.importExcel(file.getInputStream());
        String message = biScopeAttendInfoService.importBiScopeAttendInfo(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 考勤表格模板下载
	 * @return
	 */
    @RequiresPermissions("bi:biScopeAttendInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeAttendInfo> util = new ExcelUtil<BiScopeAttendInfo>(BiScopeAttendInfo.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增考勤
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存考勤
	 */
	@RequiresPermissions("bi:biScopeAttendInfo:add")
	@Log(title = "考勤", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeAttendInfo biScopeAttendInfo)
	{		
		return toAjax(biScopeAttendInfoService.insertBiScopeAttendInfo(biScopeAttendInfo));
	}

	/**
	 * 修改考勤
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeAttendInfo biScopeAttendInfo = biScopeAttendInfoService.selectBiScopeAttendInfoById(tid);
		mmap.put("biScopeAttendInfo", biScopeAttendInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存考勤
	 */
	@RequiresPermissions("bi:biScopeAttendInfo:edit")
	@Log(title = "考勤", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeAttendInfo biScopeAttendInfo)
	{		
		return toAjax(biScopeAttendInfoService.updateBiScopeAttendInfo(biScopeAttendInfo));
	}
	
	/**
	 * 删除考勤
	 */
	@RequiresPermissions("bi:biScopeAttendInfo:remove")
	@Log(title = "考勤", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeAttendInfoService.deleteBiScopeAttendInfoByIds(ids));
	}



	
}
