package com.ruoyi.project.system.biIndexInfo.service;

import java.text.SimpleDateFormat;
import java.util.*;

import com.ruoyi.common.exception.BusinessException;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.security.ShiroUtils;
import com.ruoyi.project.bi.service.Neo4jService;
import com.ruoyi.project.system.biIndexField.domain.BiIndexField;
import com.ruoyi.project.system.biIndexField.service.IBiIndexFieldService;
import com.ruoyi.project.system.biIndexScope.domain.BiIndexScope;
import com.ruoyi.project.system.biIndexScope.service.IBiIndexScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.system.biIndexInfo.mapper.BiIndexInfoMapper;
import com.ruoyi.project.system.biIndexInfo.domain.BiIndexInfo;
import com.ruoyi.common.utils.text.Convert;

/**
 * 指标 服务层实现
 *
 * @author ruoyi
 * @date 2019-04-16
 */
@Service
public class BiIndexInfoServiceImpl implements IBiIndexInfoService {
    @Autowired
    private BiIndexInfoMapper biIndexInfoMapper;

    @Autowired
    private Neo4jService neo4jService;

    @Autowired
    private IBiIndexScopeService  biIndexScopeService;

    @Autowired
    private IBiIndexFieldService  biIndexFieldService;

    /**
     * 查询指标信息
     *
     * @param indexId 指标ID
     * @return 指标信息
     */
    @Override
    public BiIndexInfo selectBiIndexInfoById(Integer indexId) {
        return biIndexInfoMapper.selectBiIndexInfoById(indexId);
    }

    /**
     * 查询指标列表
     *
     * @param biIndexInfo 指标信息
     * @return 指标集合
     */
    @Override
    public List<BiIndexInfo> selectBiIndexInfoList(BiIndexInfo biIndexInfo) {
        return biIndexInfoMapper.selectBiIndexInfoList(biIndexInfo);
    }

    /**
     * 新增指标
     *
     * @param biIndexInfo 指标信息
     * @return 结果
     */
    @Override
    public int insertBiIndexInfo(BiIndexInfo biIndexInfo) {

        String name=ShiroUtils.getLoginName();
        biIndexInfo.setCreatedBy(name);
        biIndexInfo.setUpdatedBy(name);
        Date d = new Date();
        biIndexInfo.setCreatedTime(d);
        biIndexInfo.setUpdatedTime(d);

        return biIndexInfoMapper.insertBiIndexInfo(biIndexInfo);
    }

    /**
     * 修改指标
     *
     * @param biIndexInfo 指标信息
     * @return 结果
     */
    @Override
    public int updateBiIndexInfo(BiIndexInfo biIndexInfo) {

        String name=ShiroUtils.getLoginName();
        biIndexInfo.setUpdatedBy(name);
        Date d = new Date();
        biIndexInfo.setUpdatedTime(d);

        return biIndexInfoMapper.updateBiIndexInfo(biIndexInfo);
    }

    /**
     * 删除指标对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteBiIndexInfoByIds(String ids) {
        return biIndexInfoMapper.deleteBiIndexInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 导入指标对象
     * @param biIndexInfoList
     * @return
     */

    @Override
    public String importBiIndexInfo(List<BiIndexInfo> biIndexInfoList) {
        if (StringUtils.isNull(biIndexInfoList) || biIndexInfoList.size() == 0) {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        StringBuilder successMsg = new StringBuilder();
        for (BiIndexInfo biIndexInfo : biIndexInfoList) {
            this.insertBiIndexInfo(biIndexInfo);
            successNum++;
        }
        successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        return successMsg.toString();
    }

    public List<Map> getDetailDataByIndex(String scopeName, String id,String indexNo)
    {
        List<Map> retList = new ArrayList();

        String cypher =  getDetailDataCypherString(scopeName,id,indexNo);

        if(cypher!=null)
        {
            retList =	neo4jService.queryByCypher(cypher);
        }

        return retList;
    }

    public List<Map> getDetailDataByIndex(String indexNo)
    {
        List<Map> retList = new ArrayList();

        String cypher =  getDetailDataCypherString(indexNo);

        if(cypher!=null)
        {
            retList =	neo4jService.queryByCypher(cypher);
        }

        return retList;
    }

    public String buildCypherWithBiIndexScopeAndIndexFieldList(List<BiIndexScope> indexScopeList,List<BiIndexField> biIndexFieldList)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("match ");

        StringBuilder where=new StringBuilder();
        StringBuilder ret=new StringBuilder(" return ");

        int k=0;

        for(BiIndexField biIndexField:biIndexFieldList)
        {
            if(k!=0)
            {
                ret.append(",");
            }
            ret.append(" ").append(biIndexField.getFieldName());
            k++;
        }

        String currentScopeName=null;
        String lastScopeName=null;

        boolean isFirst=true;

        for(BiIndexScope scope: indexScopeList)
        {
            if(scope.getAliasName()==null||"null".equalsIgnoreCase(scope.getAliasName()))
            {
                scope.setAliasName("n_"+scope.getScopeName().toLowerCase());
            }

            if(!scope.getScopeName().equals(currentScopeName))
            {
                currentScopeName =scope.getScopeName();

                lastScopeName = ":"+currentScopeName+")";

                if(!sb.toString().contains(lastScopeName))
                {
                    if (!isFirst)
                    {
                        sb.append("--");
                    }
                    else
                    {
                        isFirst = false;
                    }

                    sb.append("(").append(scope.getAliasName()).append(":").append(scope.getScopeName()).append(")");
                }
                else
                {
                    sb.append(",");
                    sb.append("(").append(scope.getAliasName()).append(":").append(scope.getScopeName()).append(")");
                }
            }

            if(scope.getPropertyName()!=null && scope.getPropertyName().trim().length()>0)
            {
                if(where.length()==0)
                {
                    where.append(" where 1=1");
                }

                if(scope.getCompareValue()!=null&&scope.getCompareValue().trim().length()>0)
                {
                    where.append(" ").append(scope.getRelatedMethod()).append(" ");

                    where.append(scope.getAliasName()).append(".").append(scope.getPropertyName());

                    appendWhereCompareValue(scope.getCompareMethod(),where,scope.getCompareValue(),scope.getCompareValueTo());
                }
                else
                {
                    if(")".equalsIgnoreCase(scope.getRelatedMethod()))
                    {
                        where.append(")");
                    }
                }
            }

        }



        sb.append(" ").append(where.toString()).append(" ").append(ret.toString());

        return sb.toString();
    }

    /**
     * match(n:WorkerGroup),(p:Person)  where n.name='1' and p.name='aaa' return count(n) as totalNumber
     * @param indexScopeList
     * @return
     */
    public String buildCypherWithBiIndexScopeList(List<BiIndexScope> indexScopeList)
    {
        StringBuilder sb=new StringBuilder();

        sb.append("match ");

        StringBuilder where=new StringBuilder();
        StringBuilder ret=new StringBuilder(" return count(distinct ");

        String currentScopeName=null;
        String lastScopeName=null;

        boolean isFirst=true;

        for(BiIndexScope scope: indexScopeList)
        {
            if(scope.getAliasName()==null||"null".equalsIgnoreCase(scope.getAliasName()))
            {
                scope.setAliasName("n_"+scope.getScopeName().toLowerCase());
            }

            if(!scope.getScopeName().equals(currentScopeName))
            {
                currentScopeName =scope.getScopeName();

                lastScopeName = ":"+currentScopeName+")";

                if(!sb.toString().contains(lastScopeName))
                {
                    if (!isFirst) {
                        sb.append("--");
                    } else {
                        isFirst = false;
                        ret.append(scope.getAliasName()).append(") as totalNumber");
                    }

                    sb.append("(").append(scope.getAliasName()).append(":").append(scope.getScopeName()).append(")");
                }
                else
                {
                    sb.append(",");
                    sb.append("(").append(scope.getAliasName()).append(":").append(scope.getScopeName()).append(")");
                }
            }
            else
            {

            }

            if(scope.getPropertyName()!=null && scope.getPropertyName().trim().length()>0)
            {
                if(where.length()==0)
                {
                    where.append(" where 1=1 ");
                }



                if(scope.getCompareValue()!=null&&scope.getCompareValue().length()>0)
                {
                    where.append(" ").append(scope.getRelatedMethod()).append(" ");

                    where.append(scope.getAliasName()).append(".").append(scope.getPropertyName());

                    appendWhereCompareValue(scope.getCompareMethod(),where,scope.getCompareValue(),scope.getCompareValueTo());
                }
                else
                {
                    if(")".equalsIgnoreCase(scope.getRelatedMethod()))
                    {
                        where.append(")");
                    }
                }
            }
        }



        sb.append(" ").append(where.toString()).append(" ").append(ret.toString());

        return sb.toString();
    }

    private void appendWhereCompareValue(String compareMethod,StringBuilder where,String compareValue,String compareValueTo)
    {
        where.append(compareMethod);

        if("now".equalsIgnoreCase(compareValueTo))
        {
            SimpleDateFormat sdf = new SimpleDateFormat(compareValue);

            if("=~".equalsIgnoreCase(compareMethod))
            {
                where.append("'.*").append(sdf.format(new Date())).append(".*'");
            }
            else
            {
                where.append("'").append(sdf.format(new Date())).append("'");
            }
        }
        else
        {
            if(compareValue.startsWith("'")||compareValue.startsWith("\""))
            {
                where.append(compareValue);
            }
            else
            {
                if("=~".equalsIgnoreCase(compareMethod))
                {
                    where.append("'.*").append(compareValue).append(".*'");
                }
                else
                {
                    if(compareValue.matches("\\d*"))
                    {
                        where.append(compareValue);
                    }
                    else
                    {
                        where.append("'").append(compareValue).append("'");
                    }
                }

            }
        }
    }

    public Map getTotalCntDataByIndex(String scopeName, String id,String indexNo)
    {
        Map ret = new HashMap();

        String cypher = getTotalCntCypherString(scopeName,id,indexNo);



        if(cypher!=null)
        {
            List<Map> list =	neo4jService.queryByCypher(cypher);

            if(list!=null && list.size()>0)
            {
                return list.get(0);
            }
        }
        else
        {
            ret.put("totalNumber","0");
        }

        return ret;
    }


    public Map getTotalCntDataByIndex(String indexNo)
    {
        Map ret = new HashMap();

        String cypher = getTotalCntCypherString(indexNo);

        if(cypher!=null)
        {
            List<Map> list =	neo4jService.queryByCypher(cypher);

            if(list!=null && list.size()>0)
            {
                return list.get(0);
            }
        }
        else
        {
            ret.put("totalNumber","0");
        }

        return ret;
    }

    public  String getTotalCntCypherString(String scopeName,String id,String indexNo)
    {
        BiIndexScope query=new BiIndexScope();
        query.setIndexNo(indexNo);
        List<BiIndexScope> indexScopeList = biIndexScopeService.selectBiIndexScopeList(query);
        if(indexScopeList!=null&&indexScopeList.size()>0)
        {
            String cypher = buildCypherWithBiIndexScopeList(indexScopeList);

            cypher = fixCyperWithIndexScopeList(indexScopeList,cypher,scopeName,id);

            System.out.println(cypher);

            return cypher;
        }
        else
        {
            return null;
        }
    }

    public  String getTotalCntCypherString(String indexNo)
    {
        BiIndexScope query=new BiIndexScope();
        query.setIndexNo(indexNo);
        List<BiIndexScope> indexScopeList = biIndexScopeService.selectBiIndexScopeList(query);
        if(indexScopeList!=null&&indexScopeList.size()>0)
        {
            String cypher = buildCypherWithBiIndexScopeList(indexScopeList);

            System.out.println(cypher);

            return cypher;
        }
        else
        {
            return null;
        }
    }

    public String fixCyperWithIndexScopeList( List<BiIndexScope> indexScopeList ,String cypher,String scopeName,String id)
    {
        boolean isContain=false;

        String aliasProject = null;

        for(BiIndexScope scope:indexScopeList)
        {
            if(scope.getScopeName().equals(scopeName))
            {
                isContain =true;

                cypher = cypher.replace(" where "," where "+scope.getAliasName()+".id='"+id+"' and ");
            }

            if("Project".equalsIgnoreCase(scope.getScopeName()))
            {
                aliasProject = scope.getAliasName();
            }
        }


        if(!isContain)
        {
            String aliasName=scopeName.toLowerCase()+"000";

            if(scopeName.equalsIgnoreCase("GroupOwner")||scopeName.equalsIgnoreCase("ProjectAdmin")||scopeName.equalsIgnoreCase("EnterpriseAdmin"))
            {
                if(aliasProject!=null)
                {
                    cypher =  cypher.replace(" where ",",("+aliasProject+":Project)--("+aliasName+":"+scopeName+") where "+aliasName+".id='"+id+"' and ");
                }
                else
                {
                    cypher=  cypher.replace(" where ","-[*1..5]-("+aliasName+":"+scopeName+") where "+aliasName+".id='"+id+"' and ");
                }
            }
            else
            {
                cypher=  cypher.replace(" where ","-[*1..5]-("+aliasName+":"+scopeName+") where "+aliasName+".id='"+id+"' and ");
            }
        }

       return cypher;
    }

    public String getDetailDataCypherString(String scopeName,String id,String indexNo)
    {
        BiIndexScope query=new BiIndexScope();
        query.setIndexNo(indexNo);
        List<BiIndexScope> indexScopeList = biIndexScopeService.selectBiIndexScopeList(query);

        BiIndexField biIndexField=new BiIndexField();
        biIndexField.setIndexNo(indexNo);
        List<BiIndexField> biIndexFieldList =	biIndexFieldService.selectBiIndexFieldList(biIndexField);

        if(biIndexFieldList!=null&&biIndexFieldList.size()>0)
        {
            String cypher = buildCypherWithBiIndexScopeAndIndexFieldList(indexScopeList,biIndexFieldList);

            cypher = fixCyperWithIndexScopeList(indexScopeList,cypher,scopeName,id);

            System.out.println(cypher);

            return cypher;
        }
        else
        {
            return  null;
        }
    }


    public String getDetailDataCypherString(String indexNo)
    {
        BiIndexScope query=new BiIndexScope();
        query.setIndexNo(indexNo);
        List<BiIndexScope> indexScopeList = biIndexScopeService.selectBiIndexScopeList(query);

        BiIndexField biIndexField=new BiIndexField();
        biIndexField.setIndexNo(indexNo);
        List<BiIndexField> biIndexFieldList =	biIndexFieldService.selectBiIndexFieldList(biIndexField);

        if(biIndexFieldList!=null&&biIndexFieldList.size()>0)
        {
            String cypher = buildCypherWithBiIndexScopeAndIndexFieldList(indexScopeList,biIndexFieldList);

            System.out.println(cypher);

            return cypher;
        }
        else
        {
            return  null;
        }
    }

}
