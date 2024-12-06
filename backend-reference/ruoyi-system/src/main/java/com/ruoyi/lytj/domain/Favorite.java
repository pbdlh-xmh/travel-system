package com.ruoyi.lytj.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 收藏管理对象 favorite
 * 
 * @author xmh
 * @date 2024-11-24
 */
public class Favorite extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 收藏记录ID */
    private String favoriteId;

    /** 用户ID */
    private String userId;

    /** 线路ID */
    @Excel(name = "线路ID")
    private String routeId;

    /** 景点ID */
    @Excel(name = "景点ID")
    private String attractionId;

    /** 收藏类型（1线路，2景点） */
    private Long type;

    /** 收藏时间 */
    private Date favoriteTime;

    public void setFavoriteId(String favoriteId) 
    {
        this.favoriteId = favoriteId;
    }

    public String getFavoriteId() 
    {
        return favoriteId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
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
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setFavoriteTime(Date favoriteTime) 
    {
        this.favoriteTime = favoriteTime;
    }

    public Date getFavoriteTime() 
    {
        return favoriteTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("favoriteId", getFavoriteId())
            .append("userId", getUserId())
            .append("routeId", getRouteId())
            .append("attractionId", getAttractionId())
            .append("type", getType())
            .append("favoriteTime", getFavoriteTime())
            .toString();
    }
}
