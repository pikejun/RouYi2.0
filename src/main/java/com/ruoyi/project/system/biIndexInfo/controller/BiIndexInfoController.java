package com.ruoyi.project.system.biIndexInfo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biIndexDisplay.domain.BiIndexDisplay;
import com.ruoyi.project.system.biIndexDisplay.service.IBiIndexDisplayService;
import com.ruoyi.project.system.biIndexField.domain.BiIndexField;
import com.ruoyi.project.system.biIndexField.service.IBiIndexFieldService;
import com.ruoyi.project.system.biIndexScope.domain.BiIndexScope;
import com.ruoyi.project.system.biIndexScope.service.IBiIndexScopeService;
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
import com.ruoyi.project.system.biIndexInfo.domain.BiIndexInfo;
import com.ruoyi.project.system.biIndexInfo.service.IBiIndexInfoService;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.web.multipart.MultipartFile;

/**
 * 指标 信息操作处理
 * 
 * @author ruoyi
 * @date 2019-04-16
 */
@Controller
@RequestMapping("/system/biIndexInfo")
public class BiIndexInfoController extends BaseController
{
    private String prefix = "system/biIndexInfo";
	
	@Autowired
	private IBiIndexInfoService biIndexInfoService;

	@Autowired
	private IBiIndexDisplayService biIndexDisplayService;

	@Autowired
	private IBiIndexFieldService biIndexFieldService;
	
	@RequiresPermissions("bi:biIndexInfo:view")
	@GetMapping()
	public String biIndexInfo()
	{
	    return prefix + "/biIndexInfo";
	}


	@GetMapping("/selectIndexDetailList")
	@ResponseBody
	public String selectIndexDetailList()
	{
		BiIndexInfo biIndexInfo = new BiIndexInfo();
		biIndexInfo.setDisplayType("2");
		List<BiIndexInfo> list = biIndexInfoService.selectBiIndexInfoList(biIndexInfo);

		return JSON.toJSONString(list);
	}

	@GetMapping("/selectAllIndexList")
	@ResponseBody
	public String selectAllIndexList()
	{
		BiIndexInfo biIndexInfo = new BiIndexInfo();
		List<BiIndexInfo> list = biIndexInfoService.selectBiIndexInfoList(biIndexInfo);

		return JSON.toJSONString(list);
	}

	@PostMapping("/getIndexNoParamByIndexNo")
	@ResponseBody
	public String getIndexNoParamByIndexNo(BiIndexDisplay biIndexDisplay)
	{
		List<BiIndexDisplay> list = biIndexDisplayService.selectBiIndexDisplayList(biIndexDisplay);

		StringBuilder sb=new StringBuilder();
		if(list!=null && list.size()>0)
		{
			for(BiIndexDisplay display:list)
			{
				if(sb.length()!=0)
				{
					sb.append(" , ");
				}

				sb.append("${").append(display.getDisplayNo()).append("@").append(display.getIndexNo()).append("}");
			}
		}
		else
		{
			sb.append("${").append(biIndexDisplay.getIndexNo()).append("}");
		}

		return sb.toString();
	}




	@PostMapping("/getIndexNoParamStr")
	@ResponseBody
	public String getIndexNoParamStr(BiIndexField biIndexField)
	{
		List<BiIndexField> list = biIndexFieldService.selectBiIndexFieldList(biIndexField);

		StringBuilder sb=new StringBuilder();
		if(list!=null && list.size()>0)
		{
			for(BiIndexField field:list)
			{
				if(sb.length()!=0)
				{
					sb.append(" , ");
				}

				sb.append("${").append(field.getFieldName()).append("@").append(field.getIndexNo()).append("}");
			}
		}

		return sb.toString();
	}


	
	/**
	 * 查询指标列表
	 */
	@RequiresPermissions("bi:biIndexInfo:list")
	@PostMapping("/list")
	@ResponseBody
	public TableDataInfo list(BiIndexInfo biIndexInfo)
	{
		startPage();
        List<BiIndexInfo> list = biIndexInfoService.selectBiIndexInfoList(biIndexInfo);
		return getDataTable(list);
	}
	
	
	/**
	 * 导出指标列表
	 */
	@RequiresPermissions("bi:biIndexInfo:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BiIndexInfo biIndexInfo)
    {
    	List<BiIndexInfo> list = biIndexInfoService.selectBiIndexInfoList(biIndexInfo);
        ExcelUtil<BiIndexInfo> util = new ExcelUtil<BiIndexInfo>(BiIndexInfo.class);
        return util.exportExcel(list, "biIndexInfo");
    }
    /**
     * 导入指标列表
     */
    @RequiresPermissions("bi:biIndexInfo:import")
    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file) throws Exception
    {
        ExcelUtil<BiIndexInfo> util = new ExcelUtil<BiIndexInfo>(BiIndexInfo.class);
        List<BiIndexInfo> userList = util.importExcel(file.getInputStream());
        String message = biIndexInfoService.importBiIndexInfo(userList);
        return AjaxResult.success(message);
    }
    /**
	 * 指标表格模板下载
	 * @return
	 */
    @RequiresPermissions("bi:biIndexInfo:view")
    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<BiIndexInfo> util = new ExcelUtil<BiIndexInfo>(BiIndexInfo.class);
        return util.importTemplateExcel("测试表格");
    }
	
	/**
	 * 新增指标
	 */
	@GetMapping("/add")
	public String add()
	{
	    return prefix + "/add";
	}
	
	/**
	 * 新增保存指标
	 */
	@RequiresPermissions("bi:biIndexInfo:add")
	@Log(title = "指标", businessType = BusinessType.INSERT)
	@PostMapping("/add")
	@ResponseBody
	public AjaxResult addSave(BiIndexInfo biIndexInfo)
	{		
		return toAjax(biIndexInfoService.insertBiIndexInfo(biIndexInfo));
	}

	/**
	 * 修改指标
	 */
	@GetMapping("/edit/{indexId}")
	public String edit(@PathVariable("indexId") Integer indexId, ModelMap mmap)
	{
		BiIndexInfo biIndexInfo = biIndexInfoService.selectBiIndexInfoById(indexId);
		mmap.put("biIndexInfo", biIndexInfo);
	    return prefix + "/edit";
	}

	/**
	 * 预览指标
     * @return
     */
	@GetMapping("/display/{indexId}")
	public String display(@PathVariable("indexId") Integer indexId, ModelMap mmap)
	{
		BiIndexInfo biIndexInfo = biIndexInfoService.selectBiIndexInfoById(indexId);
		mmap.put("biIndexInfo", biIndexInfo);
		String ret= prefix + "/display";

		if("1".equals(biIndexInfo.getDisplayType()))
		{
			mmap.putAll(biIndexInfoService.getTotalCntDataByIndex(biIndexInfo.getIndexNo()));

			return ret;
		}
		else
		{
			mmap.put("retList",biIndexInfoService.getDetailDataByIndex(biIndexInfo.getIndexNo()));
		}

		return prefix + "/displayDetail";
	}
	
	/**
	 * 修改保存指标
	 */
	@RequiresPermissions("bi:biIndexInfo:edit")
	@Log(title = "指标", businessType = BusinessType.UPDATE)
	@PostMapping("/edit")
	@ResponseBody
	public AjaxResult editSave(BiIndexInfo biIndexInfo)
	{		
		return toAjax(biIndexInfoService.updateBiIndexInfo(biIndexInfo));
	}
	
	/**
	 * 删除指标
	 */
	@RequiresPermissions("bi:biIndexInfo:remove")
	@Log(title = "指标", businessType = BusinessType.DELETE)
	@PostMapping( "/remove")
	@ResponseBody
	public AjaxResult remove(String ids)
	{		
		return toAjax(biIndexInfoService.deleteBiIndexInfoByIds(ids));
	}



	
}
