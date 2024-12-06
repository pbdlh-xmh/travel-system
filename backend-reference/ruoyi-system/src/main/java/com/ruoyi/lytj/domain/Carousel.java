package com.ruoyi.lytj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 轮播图管理对象 carousel
 * 
 * @author xmh
 * @date 2024-11-24
 */
public class Carousel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 轮播图ID */
    private String carouselId;

    /** 轮播图图片URL */
    @Excel(name = "轮播图图片URL")
    private String imageUrl;

    /** 轮播图跳转链接 */
    @Excel(name = "轮播图跳转链接")
    private String linkUrl;

    /** 状态（1有效，0无效） */
    @Excel(name = "状态", readConverterExp = "1=有效，0无效")
    private Long status;

    public void setCarouselId(String carouselId) 
    {
        this.carouselId = carouselId;
    }

    public String getCarouselId() 
    {
        return carouselId;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }
    public void setLinkUrl(String linkUrl) 
    {
        this.linkUrl = linkUrl;
    }

    public String getLinkUrl() 
    {
        return linkUrl;
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
            .append("carouselId", getCarouselId())
            .append("imageUrl", getImageUrl())
            .append("linkUrl", getLinkUrl())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
