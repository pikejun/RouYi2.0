package com.ruoyi.project.system.biScopeWorkerSafeEvent.vo;

import com.ruoyi.project.bi.vo.BaseNodeVO;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: Administrator
 * @Date: 2019/4/12 0012 16:09
 * @Description:
 */
@Data
public class BiScopeWorkerSafeEventVO extends BaseNodeVO {

  private String id;
  private Date eventDate;
  private String  remark;
  private String  checkerId;
  private String  workerId;
  private String  itemId;
  private String  itemName;
  private String  typeId;
  private String  typeName;
  private int  eventPoints;
}
