package com.ruoyi.project.system.biScopeTrainAttach.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: lilijun
 * @Date: 2019/4/10 0004 14:14
 * @Description:
 */
@Data
public class BiScopeTrainAttachVO extends BaseNodeVO
{
   private String id;
   private String attachmentId;
   private Date   createDate;
   private String trainId;
}
