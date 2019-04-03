package com.ruoyi.project.system.biScopePersonData.controller;

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
import com.ruoyi.project.system.biScopePersonData.domain.BiScopePersonData;
import com.ruoyi.project.system.biScopePersonData.service.IBiScopePersonDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 人员 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-02
 */
@Controller
@RequestMapping("/system/biScopePersonData")
public class BiScopePersonDataController extends BaseController
{
    private String prefix = "system/biScopePersonData";
	
	@Autowired
	private IBiScopePersonDataService biScopePersonDataService;
	
	@RequiresPermissions("system:biScopePersonData:view")
	@GetMapping()
	public String biScopePersonData()
	{
	    return prefix + "/biScopePersonData";
	}
	
	/**
	 * 查询人员列表
	 */
	@RequiresPermissions("system:biScopePersonData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopePersonData biScopePersonData)
	{
		startPage();
        List<BiScopePersonData> list = biScopePersonDataService.selectBiScopePersonDataList(biScopePersonData);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出人员列表
	 */
	@RequiresPermissions("system:biScopePersonData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopePersonData biScopePersonData)
    {
    	List<BiScopePersonData> list = biScopePersonDataService.selectBiScopePersonDataList(biScopePersonData);
        ExcelUtil<BiScopePersonData> util = new ExcelUtil<BiScopePersonData>(BiScopePersonData.class);
        return util.exportExcel(list, "biScopePersonData");
    }
    /**
     * 导入人员列表
     */
    @RequiresPermissions("system:biScopePersonData:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopePersonData> util = new ExcelUtil<BiScopePersonData>(BiScopePersonData.class);
        List<BiScopePersonData> userList = util.importExcel(file.getInputStream());
        String message = biScopePersonDataService.importBiScopePersonData(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 人员表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopePersonData:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopePersonData> util = new ExcelUtil<BiScopePersonData>(BiScopePersonData.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增人员
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存人员
	 */
	@RequiresPermissions("system:biScopePersonData:add")
	@Log(title = "人员", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopePersonData biScopePersonData)
	{		
		return toAjax(biScopePersonDataService.insertBiScopePersonData(biScopePersonData));
	}

	/**
	 * 修改人员
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopePersonData biScopePersonData = biScopePersonDataService.selectBiScopePersonDataById(tid);
		mmap.put("biScopePersonData", biScopePersonData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存人员
	 */
	@RequiresPermissions("system:biScopePersonData:edit")
	@Log(title = "人员", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopePersonData biScopePersonData)
	{		
		return toAjax(biScopePersonDataService.updateBiScopePersonData(biScopePersonData));
	}
	
	/**
	 * 删除人员
	 */
	@RequiresPermissions("system:biScopePersonData:remove")
	@Log(title = "人员", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopePersonDataService.deleteBiScopePersonDataByIds(ids));
	}



	
}
