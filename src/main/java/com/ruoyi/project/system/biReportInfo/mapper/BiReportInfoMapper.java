package com.ruoyi.project.system.biReportInfo.mapper;

import com.ruoyi.project.system.biReportInfo.domain.BiReportInfo;
import java.util.List;

/**
 * 汇报数据 数据层
 *
 * @author ruoyi
 * @date 2019-04-15
 */
public interface BiReportInfoMapper
{
	/**
     * 查询汇报数据信息
     *
     * @param reportId 汇报数据ID
     * @return 汇报数据信息
     */
	public BiReportInfo selectBiReportInfoById(Integer reportId);

	/**
     * 查询汇报数据列表
     *
     * @param biReportInfo 汇报数据信息
     * @return 汇报数据集合
     */
	public List<BiReportInfo> selectBiReportInfoList(BiReportInfo biReportInfo);

	/**
     * 新增汇报数据
     *
     * @param biReportInfo 汇报数据信息
     * @return 结果
     */
	public int insertBiReportInfo(BiReportInfo biReportInfo);

	/**
     * 修改汇报数据
     *
     * @param biReportInfo 汇报数据信息
     * @return 结果
     */
	public int updateBiReportInfo(BiReportInfo biReportInfo);

	/**
     * 删除汇报数据
     *
     * @param reportId 汇报数据ID
     * @return 结果
     */
	public int deleteBiReportInfoById(Integer reportId);

	/**
     * 批量删除汇报数据
     *
     * @param reportIds 需要删除的数据ID
     * @return 结果
     */
	public int deleteBiReportInfoByIds(String[] reportIds);

}