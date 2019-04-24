package com.ruoyi.project.system.biReportInfo.controller;

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
import com.ruoyi.project.system.biReportInfo.domain.BiReportInfo;
import com.ruoyi.project.system.biReportInfo.service.IBiReportInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 汇报数据 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-20
 */
@Controller
@RequestMapping("/system/biReportInfo")
public class BiReportInfoController extends BaseController
{
    private String prefix = "system/biReportInfo";
	
	@Autowired
	private IBiReportInfoService biReportInfoService;
	
	@RequiresPermissions("bi:biReportInfo:view")
	@GetMapping()
	public String biReportInfo()
	{
	    return prefix + "/biReportInfo";
	}
	
	/**
	 * 查询汇报数据列表
	 */
	@RequiresPermissions("bi:biReportInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiReportInfo biReportInfo)
	{
		startPage();
        List<BiReportInfo> list = biReportInfoService.selectBiReportInfoList(biReportInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出汇报数据列表
	 */
	@RequiresPermissions("bi:biReportInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiReportInfo biReportInfo)
    {
    	List<BiReportInfo> list = biReportInfoService.selectBiReportInfoList(biReportInfo);
        ExcelUtil<BiReportInfo> util = new ExcelUtil<BiReportInfo>(BiReportInfo.class);
        return util.exportExcel(list, "biReportInfo");
    }
    /**
     * 导入汇报数据列表
     */
    @RequiresPermissions("bi:biReportInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiReportInfo> util = new ExcelUtil<BiReportInfo>(BiReportInfo.class);
        List<BiReportInfo> userList = util.importExcel(file.getInputStream());
        String message = biReportInfoService.importBiReportInfo(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 汇报数据表格模板下载
	 * @return
	 */
    @RequiresPermissions("bi:biReportInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiReportInfo> util = new ExcelUtil<BiReportInfo>(BiReportInfo.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增汇报数据
	 */
	@RequiresPermissions("bi:biReportInfo:add")
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存汇报数据
	 */
	@RequiresPermissions("bi:biReportInfo:add")
	@Log(title = "汇报数据", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiReportInfo biReportInfo)
	{		
		return toAjax(biReportInfoService.insertBiReportInfo(biReportInfo));
	}

	/**
	 * 修改汇报数据
	 */
	@RequiresPermissions("bi:biReportInfo:edit")
	@GetMapping("/edit/{reportId}")
	public String edit(@PathVariable("reportId") Integer reportId, ModelMap mmap)
	{
		BiReportInfo biReportInfo = biReportInfoService.selectBiReportInfoById(reportId);
		mmap.put("biReportInfo", biReportInfo);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存汇报数据
	 */
	@RequiresPermissions("bi:biReportInfo:edit")
	@Log(title = "汇报数据", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiReportInfo biReportInfo)
	{		
		return toAjax(biReportInfoService.updateBiReportInfo(biReportInfo));
	}
	
	/**
	 * 删除汇报数据
	 */
	@RequiresPermissions("bi:biReportInfo:remove")
	@Log(title = "汇报数据", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biReportInfoService.deleteBiReportInfoByIds(ids));
	}



	
}
