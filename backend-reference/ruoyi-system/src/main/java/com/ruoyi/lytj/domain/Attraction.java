package com.ruoyi.lytj.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 景点管理对象 attraction
 * 
 * @author xmh
 * @date 2024-11-24
 */
public class Attraction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 景点ID */
    private String attractionId;

    /** 景点名称 */
    @Excel(name = "景点名称")
    private String name;

    /** 所在地 */
    @Excel(name = "所在地")
    private String location;

    /** 景点描述 */
    private String description;

    /** 开放时间 */
    @Excel(name = "开放时间")
    private String openTime;

    /** 门票价格 */
    @Excel(name = "门票价格")
    private BigDecimal ticketPrice;

    /** 景点主图片URL */
    private String imageUrl;

    /** 景点多图路径（以逗号分隔） */
    private String images;

    /** 景点标签 */
    @Excel(name = "景点标签")
    private String tags;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long viewCount;

    /** 状态（1正常，0关闭） */
    @Excel(name = "状态", readConverterExp = "1=正常，0关闭")
    private Long status;

    public void setAttractionId(String attractionId) 
    {
        this.attractionId = attractionId;
    }

    public String getAttractionId() 
    {
        return attractionId;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setLocation(String location) 
    {
        this.location = location;
    }

    public String getLocation() 
    {
        return location;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setOpenTime(String openTime) 
    {
        this.openTime = openTime;
    }

    public String getOpenTime() 
    {
        return openTime;
    }
    public void setTicketPrice(BigDecimal ticketPrice) 
    {
        this.ticketPrice = ticketPrice;
    }

    public BigDecimal getTicketPrice() 
    {
        return ticketPrice;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }
    public void setImages(String images) 
    {
        this.images = images;
    }

    public String getImages() 
    {
        return images;
    }
    public void setTags(String tags) 
    {
        this.tags = tags;
    }

    public String getTags() 
    {
        return tags;
    }
    public void setViewCount(Long viewCount) 
    {
        this.viewCount = viewCount;
    }

    public Long getViewCount() 
    {
        return viewCount;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("attractionId", getAttractionId())
            .append("name", getName())
            .append("location", getLocation())
            .append("description", getDescription())
            .append("openTime", getOpenTime())
            .append("ticketPrice", getTicketPrice())
            .append("imageUrl", getImageUrl())
            .append("images", getImages())
            .append("tags", getTags())
            .append("viewCount", getViewCount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .toString();
    }
}
