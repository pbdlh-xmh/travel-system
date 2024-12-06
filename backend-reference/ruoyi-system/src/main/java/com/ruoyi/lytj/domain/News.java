package com.ruoyi.lytj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 旅游新闻对象 news
 * 
 * @author xmh
 * @date 2024-11-24
 */
public class News extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 新闻ID */
    private String newsId;

    /** 新闻标题 */
    @Excel(name = "新闻标题")
    private String title;

    /** 新闻摘要 */
    private String summary;

    /** 新闻内容 */
    private String content;

    /** 新闻配图 */
    private String imageUrl;

    public void setNewsId(String newsId) 
    {
        this.newsId = newsId;
    }

    public String getNewsId() 
    {
        return newsId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setSummary(String summary) 
    {
        this.summary = summary;
    }

    public String getSummary() 
    {
        return summary;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("newsId", getNewsId())
            .append("title", getTitle())
            .append("summary", getSummary())
            .append("content", getContent())
            .append("imageUrl", getImageUrl())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
