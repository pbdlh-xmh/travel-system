package com.ruoyi.lytj.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 评论管理对象 comment
 * 
 * @author xmh
 * @date 2024-11-24
 */
public class Comment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评论ID */
    private String commentId;

    /** 父评论ID，一级评论为NULL */
    private String parentId;

    /** 评论目标类型（1线路，2景点） */
    @Excel(name = "评论目标类型", readConverterExp = "1=线路，2景点")
    private Long itemType;

    /** 目标ID（线路ID或景点ID） */
    @Excel(name = "目标ID", readConverterExp = "线=路ID或景点ID")
    private String itemId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 评分（1-5，仅一级评论需要） */
    @Excel(name = "评分", readConverterExp = "1=-5，仅一级评论需要")
    private Long rating;

    /** 状态（1正常，0删除） */
    @Excel(name = "状态", readConverterExp = "1=正常，0删除")
    private Long status;

    public void setCommentId(String commentId) 
    {
        this.commentId = commentId;
    }

    public String getCommentId() 
    {
        return commentId;
    }
    public void setParentId(String parentId) 
    {
        this.parentId = parentId;
    }

    public String getParentId() 
    {
        return parentId;
    }
    public void setItemType(Long itemType) 
    {
        this.itemType = itemType;
    }

    public Long getItemType() 
    {
        return itemType;
    }
    public void setItemId(String itemId) 
    {
        this.itemId = itemId;
    }

    public String getItemId() 
    {
        return itemId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setRating(Long rating) 
    {
        this.rating = rating;
    }

    public Long getRating() 
    {
        return rating;
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
            .append("commentId", getCommentId())
            .append("parentId", getParentId())
            .append("itemType", getItemType())
            .append("itemId", getItemId())
            .append("userId", getUserId())
            .append("content", getContent())
            .append("rating", getRating())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
