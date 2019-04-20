package com.ruoyi.project.system.biTemplateInfo.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.system.biIndexDisplay.service.IBiIndexDisplayService;
import com.ruoyi.project.system.biIndexInfo.service.IBiIndexInfoService;
import com.ruoyi.project.system.biIndexScope.domain.BiIndexScope;
import com.ruoyi.project.system.biIndexScope.service.IBiIndexScopeService;
import com.ruoyi.project.system.biReportInfo.domain.BiReportInfo;
import com.ruoyi.project.system.biReportInfo.service.IBiReportInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biTemplateInfo.mapper.BiTemplateInfoMapper;
import com.ruoyi.project.system.biTemplateInfo.domain.BiTemplateInfo;
import com.ruoyi.common.utils.text.Convert;

/**
 * 模板数据 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-16
 */
@Service
public class BiTemplateInfoServiceImpl implements IBiTemplateInfoService
{
    @Autowired
    private BiTemplateInfoMapper biTemplateInfoMapper;

    @Autowired
    private IBiIndexInfoService biIndexInfoService;

    @Autowired
    private IBiIndexScopeService biIndexScopeService;

    @Autowired
    private IBiIndexDisplayService biIndexDisplayService;

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
        String name= ShiroUtils.getLoginName();
        biTemplateInfo.setCreatedBy(name);
        biTemplateInfo.setUpdatedBy(name);
        Date d = new Date();
        biTemplateInfo.setCreatedTime(d);
        biTemplateInfo.setUpdatedTime(d);
        biTemplateInfo.setStatus(1);

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

        String name= ShiroUtils.getLoginName();
        biTemplateInfo.setUpdatedBy(name);
        Date d = new Date();
        biTemplateInfo.setUpdatedTime(d);

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

    @Autowired
    private IBiReportInfoService biReportInfoService;

    public void reportTemplateByTemplateNo(String templateNo)
    {
        BiTemplateInfo biTemplateInfo =new BiTemplateInfo();
        biTemplateInfo.setTemplateNo(templateNo);

        List<BiTemplateInfo> list = biTemplateInfoMapper.selectBiTemplateInfoList(biTemplateInfo);

        if(list!=null&&list.size()>0)
        {
            biTemplateInfo = list.get(0);

            List<Map> senderIndexListMap =  biIndexInfoService.getDetailDataByIndex(biTemplateInfo.getSenderIndexNo());

            BiIndexScope query=new BiIndexScope();
            query.setIndexNo(biTemplateInfo.getSenderIndexNo());
            List<BiIndexScope> indexScopeList = biIndexScopeService.selectBiIndexScopeList(query);

            BiIndexScope  biIndexScope =null;

            if(indexScopeList!=null && indexScopeList.size()>0)
            {
                biIndexScope = indexScopeList.get(0);
            }
            else
            {
                System.out.println("汇报对象的范围为空.汇报对象indexNo="+biTemplateInfo.getSenderIndexNo());
                return;
            }

            if(senderIndexListMap!=null&&senderIndexListMap.size()>0)
            {
                for(Map senderMap:senderIndexListMap)
                {
                    BiReportInfo biReportInfo=new BiReportInfo();

                    biReportInfo.setCreatedBy("999");
                    biReportInfo.setUpdatedBy("999");
                    Date d=new Date();
                    biReportInfo.setCreatedTime(d);
                    biReportInfo.setUpdatedTime(d);
                    biReportInfo.setTemplateNo(templateNo);


                    String tmpContent = biTemplateInfo.getTemplateContent();

                    String id=null;
                    String name=null;
                    StringBuilder content=new StringBuilder();

                    for(Object key:senderMap.keySet())
                    {
                        String rpKey="${"+key+"@"+biTemplateInfo.getSenderIndexNo()+"}";

                        tmpContent= tmpContent.replace(rpKey,""+senderMap.get(key));

                        if(key.toString().endsWith(".id"))
                        {
                            id=""+senderMap.get(key);
                        }

                        if(key.toString().endsWith(".name"))
                        {
                            name=""+senderMap.get(key);
                        }
                    }

                    translate(biIndexScope.getScopeName(),id, content,tmpContent);

                    biReportInfo.setReportContent(content.toString());
                    biReportInfo.setReceiverId(id);
                    biReportInfo.setReceiverName(name);
                    biReportInfo.setSendStatus("1");

                    biReportInfoService.insertBiReportInfo(biReportInfo);
                }

            }
        }
        else
        {
            System.out.println("根据模板编号："+templateNo+"找不到对应的模板！");
        }
    }

    public String getTestContentByBiTemplateInfo(BiTemplateInfo biTemplateInfo)
    {
        List<Map> senderIndexListMap =  biIndexInfoService.getDetailDataByIndex(biTemplateInfo.getSenderIndexNo());

        BiIndexScope query=new BiIndexScope();
        query.setIndexNo(biTemplateInfo.getSenderIndexNo());
        List<BiIndexScope> indexScopeList = biIndexScopeService.selectBiIndexScopeList(query);
        StringBuilder content=new StringBuilder();

        if(senderIndexListMap!=null&&senderIndexListMap.size()>0)
        {
            Map senderMap = senderIndexListMap.get(0);

            String tmpContent = biTemplateInfo.getTemplateContent();

            String id=null;
            String name=null;

            for(Object key:senderMap.keySet())
            {
                String rpKey="${"+key+"@"+biTemplateInfo.getSenderIndexNo()+"}";

                tmpContent= tmpContent.replace(rpKey,""+senderMap.get(key));

                if(key.toString().endsWith(".id"))
                {
                    id=""+senderMap.get(key);
                }

                if(key.toString().endsWith(".name"))
                {
                    name=""+senderMap.get(key);
                }
            }

            BiIndexScope biIndexScope = indexScopeList.get(0);

            translate(biIndexScope.getScopeName(),id, content,tmpContent);

            return content.toString();
        }
        else
        {
            content.append("模板: ").append(biTemplateInfo.getTemplateName()).append(" 没有匹配到发送目标对象!");
            content.append("\n").append("发送目标对象指标编号:").append(biTemplateInfo.getSenderIndexNo());
            return content.toString();
        }
    }

    public void translate(String scopeName, String id,StringBuilder content,String tempContent)
    {
        int i=0;
        int j=0;

        while((i=tempContent.indexOf("$"))!=-1)
        {
            j=tempContent.indexOf("}");

            String paramStr=tempContent.substring(i+2,j);

            String[] na=paramStr.split("@");

            String index_no=null;

            String display_no=null;

            if(na.length==1)
            {
                index_no=na[0];
            }
            else
            {
                display_no=na[0];
                index_no=na[1];
            }

            content.append(tempContent.substring(0,i));

            if(display_no == null)
            {
                Map totalMap=biIndexInfoService.getTotalCntDataByIndex(scopeName,id,index_no);

                content.append(totalMap.get("totalNumber"));
            }
            else
            {
                content.append(biIndexDisplayService.getDisplayHtml(scopeName,id,display_no,index_no));
            }

            tempContent=tempContent.substring(j+1);
        }

        content.append(tempContent);
    }

}
