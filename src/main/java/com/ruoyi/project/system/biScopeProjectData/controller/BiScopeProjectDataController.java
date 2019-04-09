package com.ruoyi.project.system.biScopeProjectData.controller;

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
import com.ruoyi.project.system.biScopeProjectData.domain.BiScopeProjectData;
import com.ruoyi.project.system.biScopeProjectData.service.IBiScopeProjectDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目数据 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-09
 */
@Controller
@RequestMapping("/system/biScopeProjectData")
public class BiScopeProjectDataController extends BaseController
{
    private String prefix = "system/biScopeProjectData";
	
	@Autowired
	private IBiScopeProjectDataService biScopeProjectDataService;
	
	@RequiresPermissions("system:biScopeProjectData:view")
	@GetMapping()
	public String biScopeProjectData()
	{
	    return prefix + "/biScopeProjectData";
	}
	
	/**
	 * 查询项目数据列表
	 */
	@RequiresPermissions("system:biScopeProjectData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeProjectData biScopeProjectData)
	{
		startPage();
        List<BiScopeProjectData> list = biScopeProjectDataService.selectBiScopeProjectDataList(biScopeProjectData);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出项目数据列表
	 */
	@RequiresPermissions("system:biScopeProjectData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeProjectData biScopeProjectData)
    {
    	List<BiScopeProjectData> list = biScopeProjectDataService.selectBiScopeProjectDataList(biScopeProjectData);
        ExcelUtil<BiScopeProjectData> util = new ExcelUtil<BiScopeProjectData>(BiScopeProjectData.class);
        return util.exportExcel(list, "biScopeProjectData");
    }
    /**
     * 导入项目数据列表
     */
    @RequiresPermissions("system:biScopeProjectData:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeProjectData> util = new ExcelUtil<BiScopeProjectData>(BiScopeProjectData.class);
        List<BiScopeProjectData> userList = util.importExcel(file.getInputStream());
        String message = biScopeProjectDataService.importBiScopeProjectData(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 项目数据表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeProjectData:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeProjectData> util = new ExcelUtil<BiScopeProjectData>(BiScopeProjectData.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增项目数据
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存项目数据
	 */
	@RequiresPermissions("system:biScopeProjectData:add")
	@Log(title = "项目数据", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeProjectData biScopeProjectData)
	{		
		return toAjax(biScopeProjectDataService.insertBiScopeProjectData(biScopeProjectData));
	}

	/**
	 * 修改项目数据
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeProjectData biScopeProjectData = biScopeProjectDataService.selectBiScopeProjectDataById(tid);
		mmap.put("biScopeProjectData", biScopeProjectData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存项目数据
	 */
	@RequiresPermissions("system:biScopeProjectData:edit")
	@Log(title = "项目数据", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeProjectData biScopeProjectData)
	{		
		return toAjax(biScopeProjectDataService.updateBiScopeProjectData(biScopeProjectData));
	}
	
	/**
	 * 删除项目数据
	 */
	@RequiresPermissions("system:biScopeProjectData:remove")
	@Log(title = "项目数据", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeProjectDataService.deleteBiScopeProjectDataByIds(ids));
	}



	
}
