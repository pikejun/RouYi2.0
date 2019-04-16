package com.ruoyi.project.system.biTemplateInfo.service;

import java.util.List;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biTemplateInfo.mapper.BiTemplateInfoMapper;
import com.ruoyi.project.system.biTemplateInfo.domain.BiTemplateInfo;
import com.ruoyi.project.system.biTemplateInfo.service.IBiTemplateInfoService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 模板数据 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-16
 */
@Service
public class BiTemplateInfoServiceImpl implements IBiTemplateInfoService {
    @Autowired
    private BiTemplateInfoMapper biTemplateInfoMapper;

    /**
     * 查询模板数据信息
     *
     * @param templateId 模板数据ID
     * @return 模板数据信息
     */
    @Override
    public BiTemplateInfo selectBiTemplateInfoById(Integer templateId) {
        return biTemplateInfoMapper.selectBiTemplateInfoById(templateId);
    }

    /**
     * 查询模板数据列表
     *
     * @param biTemplateInfo 模板数据信息
     * @return 模板数据集合
     */
    @Override
    public List<BiTemplateInfo> selectBiTemplateInfoList(BiTemplateInfo biTemplateInfo) {
        return biTemplateInfoMapper.selectBiTemplateInfoList(biTemplateInfo);
    }

    /**
     * 新增模板数据
     *
     * @param biTemplateInfo 模板数据信息
     * @return 结果
     */
    @Override
    public int insertBiTemplateInfo(BiTemplateInfo biTemplateInfo) {
        return biTemplateInfoMapper.insertBiTemplateInfo(biTemplateInfo);
    }

    /**
     * 修改模板数据
     *
     * @param biTemplateInfo 模板数据信息
     * @return 结果
     */
    @Override
    public int updateBiTemplateInfo(BiTemplateInfo biTemplateInfo) {
        return biTemplateInfoMapper.updateBiTemplateInfo(biTemplateInfo);
    }

    /**
     * 删除模板数据对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiTemplateInfoByIds(String ids) {
        return biTemplateInfoMapper.deleteBiTemplateInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入模板数据对象
     * @param biTemplateInfoList
     * @return
     */

    @Override
    public String importBiTemplateInfo(List<BiTemplateInfo> biTemplateInfoList) {
        if (StringUtils.isNull(biTemplateInfoList) || biTemplateInfoList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiTemplateInfo biTemplateInfo : biTemplateInfoList) {
            this.insertBiTemplateInfo(biTemplateInfo);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

}
