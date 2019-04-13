package com.ruoyi.project.system.biScopeTrainInfoLog.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilijun
 * @Date: 2019/4/10 0004 14:14
 * @Description:
 */
@Data
public class BiScopeTrainInfoLogVO extends BaseNodeVO
{
   private String id;
   private String trainId;
   private String  workerId;
   private Date enterDate;
   private String enterDesc;
   private String enterImageId;
   private String exitDate;
   private String exitDesc;
   private String exitImageId;
   private int finish;
}
