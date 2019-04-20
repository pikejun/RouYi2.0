package com.ruoyi.project.system.biIndexDisplay.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.framework.web.domain.BaseEntity;
import com.ruoyi.framework.aspectj.lang.annotation.Excel;
                
/**
 * 指标展示表 bi_index_display
 *
 * @author ruoyi
 * @date 2019-04-18
 */
public class BiIndexDisplay extends BaseEntity
        {
private static final long serialVersionUID=1L;

/** 展示ID */
@Excel(name = "展示ID", prompt = "展示ID")
private Integer displayId;
/** 展示编号 */
@Excel(name = "展示编号", prompt = "展示编号")
private String displayNo;
/** 指标编号 */
@Excel(name = "指标编号", prompt = "指标编号")
private String indexNo;
/** 展示格式 */
@Excel(name = "展示格式", prompt = "展示格式")
private String displayContent;

public void setDisplayId(Integer displayId)
        {
        this.displayId = displayId;
        }

public Integer getDisplayId()
        {
        return displayId;
        }
public void setDisplayNo(String displayNo)
        {
        this.displayNo = displayNo;
        }

public String getDisplayNo()
        {
        return displayNo;
        }
public void setIndexNo(String indexNo)
        {
        this.indexNo = indexNo;
        }

public String getIndexNo()
        {
        return indexNo;
        }
public void setDisplayContent(String displayContent)
        {
        this.displayContent = displayContent;
        }

public String getDisplayContent()
        {
        return displayContent;
        }
@Override
public String toString(){
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("displayId",getDisplayId())
                .append("displayNo",getDisplayNo())
                .append("indexNo",getIndexNo())
                .append("displayContent",getDisplayContent())
            .toString();
        }
        }
