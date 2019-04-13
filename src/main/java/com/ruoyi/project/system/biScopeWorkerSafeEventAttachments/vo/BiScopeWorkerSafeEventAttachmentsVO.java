package com.ruoyi.project.system.biScopeWorkerSafeEventAttachments.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/7 0007 14:41
 * @Description:
 */
@Data
public class BiScopeWorkerSafeEventAttachmentsVO extends BaseNodeVO
{
   private String  id;
   private String workerEventId;
   private String attachments;
}
