package com.ruoyi.project.system.biScopeTrainImage.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.project.system.biScopeTrainImage.vo.BiScopeTrainImageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biScopeTrainImage.mapper.BiScopeTrainImageMapper;
import com.ruoyi.project.system.biScopeTrainImage.domain.BiScopeTrainImage;
import com.ruoyi.project.system.biScopeTrainImage.service.IBiScopeTrainImageService;
import com.ruoyi.common.utils.text.Convert;

/**
 * 培训图片 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-12
 */
@Service
public class BiScopeTrainImageServiceImpl implements IBiScopeTrainImageService {
    @Autowired
    private BiScopeTrainImageMapper biScopeTrainImageMapper;

    /**
     * 查询培训图片信息
     *
     * @param tid 培训图片ID
     * @return 培训图片信息
     */
    @Override
    public BiScopeTrainImage selectBiScopeTrainImageById(Integer tid) {
        return biScopeTrainImageMapper.selectBiScopeTrainImageById(tid);
    }

    /**
     * 查询培训图片列表
     *
     * @param biScopeTrainImage 培训图片信息
     * @return 培训图片集合
     */
    @Override
    public List<BiScopeTrainImage> selectBiScopeTrainImageList(BiScopeTrainImage biScopeTrainImage) {
        return biScopeTrainImageMapper.selectBiScopeTrainImageList(biScopeTrainImage);
    }

    /**
     * 新增培训图片
     *
     * @param biScopeTrainImage 培训图片信息
     * @return 结果
     */
    @Override
    public int insertBiScopeTrainImage(BiScopeTrainImage biScopeTrainImage) {
        return biScopeTrainImageMapper.insertBiScopeTrainImage(biScopeTrainImage);
    }

    /**
     * 修改培训图片
     *
     * @param biScopeTrainImage 培训图片信息
     * @return 结果
     */
    @Override
    public int updateBiScopeTrainImage(BiScopeTrainImage biScopeTrainImage) {
        return biScopeTrainImageMapper.updateBiScopeTrainImage(biScopeTrainImage);
    }

    /**
     * 删除培训图片对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiScopeTrainImageByIds(String ids) {
        return biScopeTrainImageMapper.deleteBiScopeTrainImageByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入培训图片对象
     * @param biScopeTrainImageList
     * @return
     */

    @Override
    public String importBiScopeTrainImage(List<BiScopeTrainImage> biScopeTrainImageList) {
        if (StringUtils.isNull(biScopeTrainImageList) || biScopeTrainImageList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiScopeTrainImage biScopeTrainImage : biScopeTrainImageList) {
            this.insertBiScopeTrainImage(biScopeTrainImage);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public int updateBiScopeTrainImageReadyToDeal(Map param)
    {
        return biScopeTrainImageMapper.updateBiScopeTrainImageReadyToDeal(param);
    }

    public int  updateBiScopeTrainImageToComplate(Map param)
    {
        return biScopeTrainImageMapper.updateBiScopeTrainImageToComplate(param);
    }

    public int  updateBiScopeTrainImageToFailed(Map param)
    {
        return biScopeTrainImageMapper.updateBiScopeTrainImageToFailed(param);
    }

    public List<BiScopeTrainImageVO> selectBiScopeTrainImageReadToDeal(Map param)
    {
        return biScopeTrainImageMapper.selectBiScopeTrainImageReadToDeal(param);
    }
}
