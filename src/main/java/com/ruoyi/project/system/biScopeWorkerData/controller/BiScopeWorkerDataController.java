package com.ruoyi.project.system.biScopeWorkerData.controller;

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
import com.ruoyi.project.system.biScopeWorkerData.domain.BiScopeWorkerData;
import com.ruoyi.project.system.biScopeWorkerData.service.IBiScopeWorkerDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工人数据 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-07
 */
@Controller
@RequestMapping("/system/biScopeWorkerData")
public class BiScopeWorkerDataController extends BaseController
{
    private String prefix = "system/biScopeWorkerData";
	
	@Autowired
	private IBiScopeWorkerDataService biScopeWorkerDataService;
	
	@RequiresPermissions("system:biScopeWorkerData:view")
	@GetMapping()
	public String biScopeWorkerData()
	{
	    return prefix + "/biScopeWorkerData";
	}
	
	/**
	 * 查询工人数据列表
	 */
	@RequiresPermissions("system:biScopeWorkerData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeWorkerData biScopeWorkerData)
	{
		startPage();
        List<BiScopeWorkerData> list = biScopeWorkerDataService.selectBiScopeWorkerDataList(biScopeWorkerData);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出工人数据列表
	 */
	@RequiresPermissions("system:biScopeWorkerData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeWorkerData biScopeWorkerData)
    {
    	List<BiScopeWorkerData> list = biScopeWorkerDataService.selectBiScopeWorkerDataList(biScopeWorkerData);
        ExcelUtil<BiScopeWorkerData> util = new ExcelUtil<BiScopeWorkerData>(BiScopeWorkerData.class);
        return util.exportExcel(list, "biScopeWorkerData");
    }
    /**
     * 导入工人数据列表
     */
    @RequiresPermissions("system:biScopeWorkerData:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeWorkerData> util = new ExcelUtil<BiScopeWorkerData>(BiScopeWorkerData.class);
        List<BiScopeWorkerData> userList = util.importExcel(file.getInputStream());
        String message = biScopeWorkerDataService.importBiScopeWorkerData(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 工人数据表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeWorkerData:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeWorkerData> util = new ExcelUtil<BiScopeWorkerData>(BiScopeWorkerData.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增工人数据
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存工人数据
	 */
	@RequiresPermissions("system:biScopeWorkerData:add")
	@Log(title = "工人数据", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeWorkerData biScopeWorkerData)
	{		
		return toAjax(biScopeWorkerDataService.insertBiScopeWorkerData(biScopeWorkerData));
	}

	/**
	 * 修改工人数据
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeWorkerData biScopeWorkerData = biScopeWorkerDataService.selectBiScopeWorkerDataById(tid);
		mmap.put("biScopeWorkerData", biScopeWorkerData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存工人数据
	 */
	@RequiresPermissions("system:biScopeWorkerData:edit")
	@Log(title = "工人数据", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeWorkerData biScopeWorkerData)
	{		
		return toAjax(biScopeWorkerDataService.updateBiScopeWorkerData(biScopeWorkerData));
	}
	
	/**
	 * 删除工人数据
	 */
	@RequiresPermissions("system:biScopeWorkerData:remove")
	@Log(title = "工人数据", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeWorkerDataService.deleteBiScopeWorkerDataByIds(ids));
	}



	
}
