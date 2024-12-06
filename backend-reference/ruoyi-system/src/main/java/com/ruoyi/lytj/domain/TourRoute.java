package com.ruoyi.lytj.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 旅游线路管理对象 tour_route
 * 
 * @author xmh
 * @date 2024-11-24
 */
public class TourRoute extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 线路ID */
    private String routeId;

    /** 线路名称 */
    @Excel(name = "线路名称")
    private String routeName;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 线路描述 */
    private String description;

    /** 行程天数 */
    @Excel(name = "行程天数")
    private Long duration;

    /** 出发地 */
    @Excel(name = "出发地")
    private String departurePlace;

    /** 目的地 */
    @Excel(name = "目的地")
    private String destination;

    /** 线路主图片URL */
    private String imageUrl;

    /** 线路多图路径（以逗号分隔） */
    private String images;

    /** 线路标签 */
    @Excel(name = "线路标签")
    private String tags;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long viewCount;

    /** 收藏次数 */
    @Excel(name = "收藏次数")
    private Long favoritesCount;

    /** 评论数 */
    @Excel(name = "评论数")
    private Long commentsCount;

    /** 预定次数 */
    @Excel(name = "预定次数")
    private Long bookingsCount;

    /** 最低预算 */
    @Excel(name = "最低预算")
    private BigDecimal minBudget;

    /** 最高预算 */
    @Excel(name = "最高预算")
    private BigDecimal maxBudget;

    /** 最大团体人数 */
    @Excel(name = "最大团体人数")
    private Long maxGroupSize;

    /** 状态（1上架，0下架） */
    @Excel(name = "状态", readConverterExp = "1=上架，0下架")
    private Long status;

    public void setRouteId(String routeId) 
    {
        this.routeId = routeId;
    }

    public String getRouteId() 
    {
        return routeId;
    }
    public void setRouteName(String routeName) 
    {
        this.routeName = routeName;
    }

    public String getRouteName() 
    {
        return routeName;
    }
    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setDuration(Long duration) 
    {
        this.duration = duration;
    }

    public Long getDuration() 
    {
        return duration;
    }
    public void setDeparturePlace(String departurePlace) 
    {
        this.departurePlace = departurePlace;
    }

    public String getDeparturePlace() 
    {
        return departurePlace;
    }
    public void setDestination(String destination) 
    {
        this.destination = destination;
    }

    public String getDestination() 
    {
        return destination;
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
    public void setFavoritesCount(Long favoritesCount) 
    {
        this.favoritesCount = favoritesCount;
    }

    public Long getFavoritesCount() 
    {
        return favoritesCount;
    }
    public void setCommentsCount(Long commentsCount) 
    {
        this.commentsCount = commentsCount;
    }

    public Long getCommentsCount() 
    {
        return commentsCount;
    }
    public void setBookingsCount(Long bookingsCount) 
    {
        this.bookingsCount = bookingsCount;
    }

    public Long getBookingsCount() 
    {
        return bookingsCount;
    }
    public void setMinBudget(BigDecimal minBudget) 
    {
        this.minBudget = minBudget;
    }

    public BigDecimal getMinBudget() 
    {
        return minBudget;
    }
    public void setMaxBudget(BigDecimal maxBudget) 
    {
        this.maxBudget = maxBudget;
    }

    public BigDecimal getMaxBudget() 
    {
        return maxBudget;
    }
    public void setMaxGroupSize(Long maxGroupSize) 
    {
        this.maxGroupSize = maxGroupSize;
    }

    public Long getMaxGroupSize() 
    {
        return maxGroupSize;
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
            .append("routeId", getRouteId())
            .append("routeName", getRouteName())
            .append("price", getPrice())
            .append("description", getDescription())
            .append("duration", getDuration())
            .append("departurePlace", getDeparturePlace())
            .append("destination", getDestination())
            .append("imageUrl", getImageUrl())
            .append("images", getImages())
            .append("tags", getTags())
            .append("viewCount", getViewCount())
            .append("favoritesCount", getFavoritesCount())
            .append("commentsCount", getCommentsCount())
            .append("bookingsCount", getBookingsCount())
            .append("minBudget", getMinBudget())
            .append("maxBudget", getMaxBudget())
            .append("maxGroupSize", getMaxGroupSize())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .toString();
    }
}
