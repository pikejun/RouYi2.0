package com.ruoyi.project.system.biScopeDeviceData.controller;

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
import com.ruoyi.project.system.biScopeDeviceData.domain.BiScopeDeviceData;
import com.ruoyi.project.system.biScopeDeviceData.service.IBiScopeDeviceDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 设备数据 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-07
 */
@Controller
@RequestMapping("/system/biScopeDeviceData")
public class BiScopeDeviceDataController extends BaseController
{
    private String prefix = "system/biScopeDeviceData";
	
	@Autowired
	private IBiScopeDeviceDataService biScopeDeviceDataService;
	
	@RequiresPermissions("system:biScopeDeviceData:view")
	@GetMapping()
	public String biScopeDeviceData()
	{
	    return prefix + "/biScopeDeviceData";
	}
	
	/**
	 * 查询设备数据列表
	 */
	@RequiresPermissions("system:biScopeDeviceData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeDeviceData biScopeDeviceData)
	{
		startPage();
        List<BiScopeDeviceData> list = biScopeDeviceDataService.selectBiScopeDeviceDataList(biScopeDeviceData);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出设备数据列表
	 */
	@RequiresPermissions("system:biScopeDeviceData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeDeviceData biScopeDeviceData)
    {
    	List<BiScopeDeviceData> list = biScopeDeviceDataService.selectBiScopeDeviceDataList(biScopeDeviceData);
        ExcelUtil<BiScopeDeviceData> util = new ExcelUtil<BiScopeDeviceData>(BiScopeDeviceData.class);
        return util.exportExcel(list, "biScopeDeviceData");
    }
    /**
     * 导入设备数据列表
     */
    @RequiresPermissions("system:biScopeDeviceData:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeDeviceData> util = new ExcelUtil<BiScopeDeviceData>(BiScopeDeviceData.class);
        List<BiScopeDeviceData> userList = util.importExcel(file.getInputStream());
        String message = biScopeDeviceDataService.importBiScopeDeviceData(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 设备数据表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeDeviceData:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeDeviceData> util = new ExcelUtil<BiScopeDeviceData>(BiScopeDeviceData.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增设备数据
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存设备数据
	 */
	@RequiresPermissions("system:biScopeDeviceData:add")
	@Log(title = "设备数据", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeDeviceData biScopeDeviceData)
	{		
		return toAjax(biScopeDeviceDataService.insertBiScopeDeviceData(biScopeDeviceData));
	}

	/**
	 * 修改设备数据
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeDeviceData biScopeDeviceData = biScopeDeviceDataService.selectBiScopeDeviceDataById(tid);
		mmap.put("biScopeDeviceData", biScopeDeviceData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存设备数据
	 */
	@RequiresPermissions("system:biScopeDeviceData:edit")
	@Log(title = "设备数据", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeDeviceData biScopeDeviceData)
	{		
		return toAjax(biScopeDeviceDataService.updateBiScopeDeviceData(biScopeDeviceData));
	}
	
	/**
	 * 删除设备数据
	 */
	@RequiresPermissions("system:biScopeDeviceData:remove")
	@Log(title = "设备数据", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeDeviceDataService.deleteBiScopeDeviceDataByIds(ids));
	}



	
}
