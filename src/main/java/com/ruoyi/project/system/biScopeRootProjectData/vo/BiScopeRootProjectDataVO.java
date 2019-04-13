package com.ruoyi.project.system.biScopeRootProjectData.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilijun
 * @Date: 2019/4/9 0009 10:33
 * @Description:
 */
@Data
public class BiScopeRootProjectDataVO  extends BaseNodeVO
{
    private String id;
    private String abbrName;
    private Date createDate;
    private String createUser;
    private String name;
}
