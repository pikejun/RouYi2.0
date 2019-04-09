package com.ruoyi.project.system.biScopeEnterpriseData.controller;

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
import com.ruoyi.project.system.biScopeEnterpriseData.domain.BiScopeEnterpriseData;
import com.ruoyi.project.system.biScopeEnterpriseData.service.IBiScopeEnterpriseDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 企业数据 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-08
 */
@Controller
@RequestMapping("/system/biScopeEnterpriseData")
public class BiScopeEnterpriseDataController extends BaseController
{
    private String prefix = "system/biScopeEnterpriseData";
	
	@Autowired
	private IBiScopeEnterpriseDataService biScopeEnterpriseDataService;
	
	@RequiresPermissions("system:biScopeEnterpriseData:view")
	@GetMapping()
	public String biScopeEnterpriseData()
	{
	    return prefix + "/biScopeEnterpriseData";
	}
	
	/**
	 * 查询企业数据列表
	 */
	@RequiresPermissions("system:biScopeEnterpriseData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeEnterpriseData biScopeEnterpriseData)
	{
		startPage();
        List<BiScopeEnterpriseData> list = biScopeEnterpriseDataService.selectBiScopeEnterpriseDataList(biScopeEnterpriseData);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出企业数据列表
	 */
	@RequiresPermissions("system:biScopeEnterpriseData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeEnterpriseData biScopeEnterpriseData)
    {
    	List<BiScopeEnterpriseData> list = biScopeEnterpriseDataService.selectBiScopeEnterpriseDataList(biScopeEnterpriseData);
        ExcelUtil<BiScopeEnterpriseData> util = new ExcelUtil<BiScopeEnterpriseData>(BiScopeEnterpriseData.class);
        return util.exportExcel(list, "biScopeEnterpriseData");
    }
    /**
     * 导入企业数据列表
     */
    @RequiresPermissions("system:biScopeEnterpriseData:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeEnterpriseData> util = new ExcelUtil<BiScopeEnterpriseData>(BiScopeEnterpriseData.class);
        List<BiScopeEnterpriseData> userList = util.importExcel(file.getInputStream());
        String message = biScopeEnterpriseDataService.importBiScopeEnterpriseData(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 企业数据表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeEnterpriseData:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeEnterpriseData> util = new ExcelUtil<BiScopeEnterpriseData>(BiScopeEnterpriseData.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增企业数据
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存企业数据
	 */
	@RequiresPermissions("system:biScopeEnterpriseData:add")
	@Log(title = "企业数据", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeEnterpriseData biScopeEnterpriseData)
	{		
		return toAjax(biScopeEnterpriseDataService.insertBiScopeEnterpriseData(biScopeEnterpriseData));
	}

	/**
	 * 修改企业数据
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeEnterpriseData biScopeEnterpriseData = biScopeEnterpriseDataService.selectBiScopeEnterpriseDataById(tid);
		mmap.put("biScopeEnterpriseData", biScopeEnterpriseData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存企业数据
	 */
	@RequiresPermissions("system:biScopeEnterpriseData:edit")
	@Log(title = "企业数据", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeEnterpriseData biScopeEnterpriseData)
	{		
		return toAjax(biScopeEnterpriseDataService.updateBiScopeEnterpriseData(biScopeEnterpriseData));
	}
	
	/**
	 * 删除企业数据
	 */
	@RequiresPermissions("system:biScopeEnterpriseData:remove")
	@Log(title = "企业数据", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeEnterpriseDataService.deleteBiScopeEnterpriseDataByIds(ids));
	}



	
}
