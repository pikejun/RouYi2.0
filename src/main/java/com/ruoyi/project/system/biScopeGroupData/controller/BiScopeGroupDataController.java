package com.ruoyi.project.system.biScopeGroupData.controller;

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
import com.ruoyi.project.system.biScopeGroupData.domain.BiScopeGroupData;
import com.ruoyi.project.system.biScopeGroupData.service.IBiScopeGroupDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 项目班组数据 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-13
 */
@Controller
@RequestMapping("/system/biScopeGroupData")
public class BiScopeGroupDataController extends BaseController
{
    private String prefix = "system/biScopeGroupData";
	
	@Autowired
	private IBiScopeGroupDataService biScopeGroupDataService;
	
	@RequiresPermissions("bi:biScopeGroupData:view")
	@GetMapping()
	public String biScopeGroupData()
	{
	    return prefix + "/biScopeGroupData";
	}
	
	/**
	 * 查询项目班组数据列表
	 */
	@RequiresPermissions("bi:biScopeGroupData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeGroupData biScopeGroupData)
	{
		startPage();
        List<BiScopeGroupData> list = biScopeGroupDataService.selectBiScopeGroupDataList(biScopeGroupData);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出项目班组数据列表
	 */
	@RequiresPermissions("bi:biScopeGroupData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeGroupData biScopeGroupData)
    {
    	List<BiScopeGroupData> list = biScopeGroupDataService.selectBiScopeGroupDataList(biScopeGroupData);
        ExcelUtil<BiScopeGroupData> util = new ExcelUtil<BiScopeGroupData>(BiScopeGroupData.class);
        return util.exportExcel(list, "biScopeGroupData");
    }
    /**
     * 导入项目班组数据列表
     */
    @RequiresPermissions("bi:biScopeGroupData:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeGroupData> util = new ExcelUtil<BiScopeGroupData>(BiScopeGroupData.class);
        List<BiScopeGroupData> userList = util.importExcel(file.getInputStream());
        String message = biScopeGroupDataService.importBiScopeGroupData(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 项目班组数据表格模板下载
	 * @return
	 */
    @RequiresPermissions("bi:biScopeGroupData:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeGroupData> util = new ExcelUtil<BiScopeGroupData>(BiScopeGroupData.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增项目班组数据
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存项目班组数据
	 */
	@RequiresPermissions("bi:biScopeGroupData:add")
	@Log(title = "项目班组数据", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeGroupData biScopeGroupData)
	{		
		return toAjax(biScopeGroupDataService.insertBiScopeGroupData(biScopeGroupData));
	}

	/**
	 * 修改项目班组数据
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeGroupData biScopeGroupData = biScopeGroupDataService.selectBiScopeGroupDataById(tid);
		mmap.put("biScopeGroupData", biScopeGroupData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存项目班组数据
	 */
	@RequiresPermissions("bi:biScopeGroupData:edit")
	@Log(title = "项目班组数据", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeGroupData biScopeGroupData)
	{		
		return toAjax(biScopeGroupDataService.updateBiScopeGroupData(biScopeGroupData));
	}
	
	/**
	 * 删除项目班组数据
	 */
	@RequiresPermissions("bi:biScopeGroupData:remove")
	@Log(title = "项目班组数据", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeGroupDataService.deleteBiScopeGroupDataByIds(ids));
	}



	
}
