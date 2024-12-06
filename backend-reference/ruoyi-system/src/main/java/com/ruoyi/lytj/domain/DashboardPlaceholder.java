package com.ruoyi.lytj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 可视化大屏占位对象 dashboard_placeholder
 * 
 * @author xmh
 * @date 2024-11-24
 */
public class DashboardPlaceholder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private String id;

    /** 占位字段 */
    private String placeholderField;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setPlaceholderField(String placeholderField) 
    {
        this.placeholderField = placeholderField;
    }

    public String getPlaceholderField() 
    {
        return placeholderField;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("placeholderField", getPlaceholderField())
            .toString();
    }
}
