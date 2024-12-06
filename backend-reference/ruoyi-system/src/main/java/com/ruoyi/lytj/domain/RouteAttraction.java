package com.ruoyi.lytj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 线路-景点关联管理对象 route_attraction
 * 
 * @author xmh
 * @date 2024-11-24
 */
public class RouteAttraction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录ID */
    private String id;

    /** 线路ID */
    @Excel(name = "线路ID")
    private String routeId;

    /** 景点ID */
    @Excel(name = "景点ID")
    private String attractionId;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setRouteId(String routeId) 
    {
        this.routeId = routeId;
    }

    public String getRouteId() 
    {
        return routeId;
    }
    public void setAttractionId(String attractionId) 
    {
        this.attractionId = attractionId;
    }

    public String getAttractionId() 
    {
        return attractionId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("routeId", getRouteId())
            .append("attractionId", getAttractionId())
            .toString();
    }
}
