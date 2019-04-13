package com.ruoyi.project.system.biScopeTrainImage.controller;

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
import com.ruoyi.project.system.biScopeTrainImage.domain.BiScopeTrainImage;
import com.ruoyi.project.system.biScopeTrainImage.service.IBiScopeTrainImageService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 培训图片 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-12
 */
@Controller
@RequestMapping("/system/biScopeTrainImage")
public class BiScopeTrainImageController extends BaseController
{
    private String prefix = "system/biScopeTrainImage";
	
	@Autowired
	private IBiScopeTrainImageService biScopeTrainImageService;
	
	@RequiresPermissions("system:biScopeTrainImage:view")
	@GetMapping()
	public String biScopeTrainImage()
	{
	    return prefix + "/biScopeTrainImage";
	}
	
	/**
	 * 查询培训图片列表
	 */
	@RequiresPermissions("system:biScopeTrainImage:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiScopeTrainImage biScopeTrainImage)
	{
		startPage();
        List<BiScopeTrainImage> list = biScopeTrainImageService.selectBiScopeTrainImageList(biScopeTrainImage);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出培训图片列表
	 */
	@RequiresPermissions("system:biScopeTrainImage:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiScopeTrainImage biScopeTrainImage)
    {
    	List<BiScopeTrainImage> list = biScopeTrainImageService.selectBiScopeTrainImageList(biScopeTrainImage);
        ExcelUtil<BiScopeTrainImage> util = new ExcelUtil<BiScopeTrainImage>(BiScopeTrainImage.class);
        return util.exportExcel(list, "biScopeTrainImage");
    }
    /**
     * 导入培训图片列表
     */
    @RequiresPermissions("system:biScopeTrainImage:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiScopeTrainImage> util = new ExcelUtil<BiScopeTrainImage>(BiScopeTrainImage.class);
        List<BiScopeTrainImage> userList = util.importExcel(file.getInputStream());
        String message = biScopeTrainImageService.importBiScopeTrainImage(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 培训图片表格模板下载
	 * @return
	 */
    @RequiresPermissions("system:biScopeTrainImage:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiScopeTrainImage> util = new ExcelUtil<BiScopeTrainImage>(BiScopeTrainImage.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增培训图片
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存培训图片
	 */
	@RequiresPermissions("system:biScopeTrainImage:add")
	@Log(title = "培训图片", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiScopeTrainImage biScopeTrainImage)
	{		
		return toAjax(biScopeTrainImageService.insertBiScopeTrainImage(biScopeTrainImage));
	}

	/**
	 * 修改培训图片
	 */
	@GetMapping("/edit/{tid}")
	public String edit(@PathVariable("tid") Integer tid, ModelMap mmap)
	{
		BiScopeTrainImage biScopeTrainImage = biScopeTrainImageService.selectBiScopeTrainImageById(tid);
		mmap.put("biScopeTrainImage", biScopeTrainImage);
	    return prefix + "/edit";
	}
	
	/**
	 * 修改保存培训图片
	 */
	@RequiresPermissions("system:biScopeTrainImage:edit")
	@Log(title = "培训图片", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiScopeTrainImage biScopeTrainImage)
	{		
		return toAjax(biScopeTrainImageService.updateBiScopeTrainImage(biScopeTrainImage));
	}
	
	/**
	 * 删除培训图片
	 */
	@RequiresPermissions("system:biScopeTrainImage:remove")
	@Log(title = "培训图片", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biScopeTrainImageService.deleteBiScopeTrainImageByIds(ids));
	}



	
}
