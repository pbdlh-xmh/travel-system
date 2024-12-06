package com.ruoyi.lytj.mapper;

import java.util.List;
import com.ruoyi.lytj.domain.Comment;

/**
 * 评论管理Mapper接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface CommentMapper 
{
    /**
     * 查询评论管理
     * 
     * @param commentId 评论管理主键
     * @return 评论管理
     */
    public Comment selectCommentByCommentId(String commentId);

    /**
     * 查询评论管理列表
     * 
     * @param comment 评论管理
     * @return 评论管理集合
     */
    public List<Comment> selectCommentList(Comment comment);

    /**
     * 新增评论管理
     * 
     * @param comment 评论管理
     * @return 结果
     */
    public int insertComment(Comment comment);

    /**
     * 修改评论管理
     * 
     * @param comment 评论管理
     * @return 结果
     */
    public int updateComment(Comment comment);

    /**
     * 删除评论管理
     * 
     * @param commentId 评论管理主键
     * @return 结果
     */
    public int deleteCommentByCommentId(String commentId);

    /**
     * 批量删除评论管理
     * 
     * @param commentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCommentByCommentIds(String[] commentIds);
}
