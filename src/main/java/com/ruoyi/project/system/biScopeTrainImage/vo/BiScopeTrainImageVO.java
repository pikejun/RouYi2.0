package com.ruoyi.project.system.biScopeTrainImage.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilijun
 * @Date: 2019/4/10 0004 14:14
 * @Description:
 */
@Data
public class BiScopeTrainImageVO extends BaseNodeVO
{
   private String id;
   private String picId;
   private Date   createDate;
   private String trainId;
}
