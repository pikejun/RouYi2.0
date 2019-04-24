package com.ruoyi.project.system.biScopeSectionData.controller;

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
import com.ruoyi.project.system.biScopeSectionData.domain.BiScopeSectionData;
import com.ruoyi.project.system.biScopeSectionData.service.IBiScopeSectionDataService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 标段数据 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-10
 */
@Controller
@RequestMapping("/system/biScopeSectionData")
public class BiScopeSectionDataController extends BaseController
{
    private String prefix = "system/biScopeSectionData";
	
	@Autowired
	private IBiScopeSectionDataService biScopeSectionDataService;
	
	@RequiresPermissions("bi:biScopeSectionData:view")
	@GetMapping()
	public String biScopeSectionData()
	{
	    return prefix + "/biScopeSectionData";
	}
	
	/**
	 * 查询标段数据列表
	 */
	@RequiresPermissions("bi:biScopeSectionData:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeSectionData biScopeSectionData)
	{
		startPage();
        List<BiScopeSectionData> list = biScopeSectionDataService.selectBiScopeSectionDataList(biScopeSectionData);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出标段数据列表
	 */
	@RequiresPermissions("bi:biScopeSectionData:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeSectionData biScopeSectionData)
    {
    	List<BiScopeSectionData> list = biScopeSectionDataService.selectBiScopeSectionDataList(biScopeSectionData);
        ExcelUtil<BiScopeSectionData> util = new ExcelUtil<BiScopeSectionData>(BiScopeSectionData.class);
        return util.exportExcel(list, "biScopeSectionData");
    }
    /**
     * 导入标段数据列表
     */
    @RequiresPermissions("bi:biScopeSectionData:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeSectionData> util = new ExcelUtil<BiScopeSectionData>(BiScopeSectionData.class);
        List<BiScopeSectionData> userList = util.importExcel(file.getInputStream());
        String message = biScopeSectionDataService.importBiScopeSectionData(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 标段数据表格模板下载
	 * @return
	 */
    @RequiresPermissions("bi:biScopeSectionData:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeSectionData> util = new ExcelUtil<BiScopeSectionData>(BiScopeSectionData.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增标段数据
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存标段数据
	 */
	@RequiresPermissions("bi:biScopeSectionData:add")
	@Log(title = "标段数据", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeSectionData biScopeSectionData)
	{		
		return toAjax(biScopeSectionDataService.insertBiScopeSectionData(biScopeSectionData));
	}

	/**
	 * 修改标段数据
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeSectionData biScopeSectionData = biScopeSectionDataService.selectBiScopeSectionDataById(tid);
		mmap.put("biScopeSectionData", biScopeSectionData);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存标段数据
	 */
	@RequiresPermissions("bi:biScopeSectionData:edit")
	@Log(title = "标段数据", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeSectionData biScopeSectionData)
	{		
		return toAjax(biScopeSectionDataService.updateBiScopeSectionData(biScopeSectionData));
	}
	
	/**
	 * 删除标段数据
	 */
	@RequiresPermissions("bi:biScopeSectionData:remove")
	@Log(title = "标段数据", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeSectionDataService.deleteBiScopeSectionDataByIds(ids));
	}



	
}
