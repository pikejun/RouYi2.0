package com.ruoyi.project.system.biScopeAttendSpotData.controller;

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
import com.ruoyi.project.system.biScopeAttendSpotData.domain.BiScopeAttendSpotData;
import com.ruoyi.project.system.biScopeAttendSpotData.service.IBiScopeAttendSpotDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 考勤点 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Controller
@RequestMapping("/system/biScopeAttendSpotData")
public class BiScopeAttendSpotDataController extends BaseController
{
    private String prefix = "system/biScopeAttendSpotData";
	
	@Autowired
	private IBiScopeAttendSpotDataService biScopeAttendSpotDataService;
	
	@RequiresPermissions("system:biScopeAttendSpotData:view")
	@GetMapping()
	public String biScopeAttendSpotData()
	{
	    return prefix + "/biScopeAttendSpotData";
	}
	
	/**
	 * 查询考勤点列表
	 */
	@RequiresPermissions("system:biScopeAttendSpotData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeAttendSpotData biScopeAttendSpotData)
	{
		startPage();
        List<BiScopeAttendSpotData> list = biScopeAttendSpotDataService.selectBiScopeAttendSpotDataList(biScopeAttendSpotData);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出考勤点列表
	 */
	@RequiresPermissions("system:biScopeAttendSpotData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeAttendSpotData biScopeAttendSpotData)
    {
    	List<BiScopeAttendSpotData> list = biScopeAttendSpotDataService.selectBiScopeAttendSpotDataList(biScopeAttendSpotData);
        ExcelUtil<BiScopeAttendSpotData> util = new ExcelUtil<BiScopeAttendSpotData>(BiScopeAttendSpotData.class);
        return util.exportExcel(list, "biScopeAttendSpotData");
    }
    /**
     * 导入考勤点列表
     */
    @RequiresPermissions("system:biScopeAttendSpotData:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeAttendSpotData> util = new ExcelUtil<BiScopeAttendSpotData>(BiScopeAttendSpotData.class);
        List<BiScopeAttendSpotData> userList = util.importExcel(file.getInputStream());
        String message = biScopeAttendSpotDataService.importBiScopeAttendSpotData(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 考勤点表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeAttendSpotData:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeAttendSpotData> util = new ExcelUtil<BiScopeAttendSpotData>(BiScopeAttendSpotData.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增考勤点
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存考勤点
	 */
	@RequiresPermissions("system:biScopeAttendSpotData:add")
	@Log(title = "考勤点", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeAttendSpotData biScopeAttendSpotData)
	{		
		return toAjax(biScopeAttendSpotDataService.insertBiScopeAttendSpotData(biScopeAttendSpotData));
	}

	/**
	 * 修改考勤点
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeAttendSpotData biScopeAttendSpotData = biScopeAttendSpotDataService.selectBiScopeAttendSpotDataById(tid);
		mmap.put("biScopeAttendSpotData", biScopeAttendSpotData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存考勤点
	 */
	@RequiresPermissions("system:biScopeAttendSpotData:edit")
	@Log(title = "考勤点", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeAttendSpotData biScopeAttendSpotData)
	{		
		return toAjax(biScopeAttendSpotDataService.updateBiScopeAttendSpotData(biScopeAttendSpotData));
	}
	
	/**
	 * 删除考勤点
	 */
	@RequiresPermissions("system:biScopeAttendSpotData:remove")
	@Log(title = "考勤点", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeAttendSpotDataService.deleteBiScopeAttendSpotDataByIds(ids));
	}



	
}
