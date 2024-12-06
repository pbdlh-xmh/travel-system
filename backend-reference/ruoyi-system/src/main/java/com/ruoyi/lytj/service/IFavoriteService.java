package com.ruoyi.lytj.service;

import java.util.List;
import com.ruoyi.lytj.domain.Favorite;

/**
 * 收藏管理Service接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface IFavoriteService 
{
    /**
     * 查询收藏管理
     * 
     * @param favoriteId 收藏管理主键
     * @return 收藏管理
     */
    public Favorite selectFavoriteByFavoriteId(String favoriteId);

    /**
     * 查询收藏管理列表
     * 
     * @param favorite 收藏管理
     * @return 收藏管理集合
     */
    public List<Favorite> selectFavoriteList(Favorite favorite);

    /**
     * 新增收藏管理
     * 
     * @param favorite 收藏管理
     * @return 结果
     */
    public int insertFavorite(Favorite favorite);

    /**
     * 修改收藏管理
     * 
     * @param favorite 收藏管理
     * @return 结果
     */
    public int updateFavorite(Favorite favorite);

    /**
     * 批量删除收藏管理
     * 
     * @param favoriteIds 需要删除的收藏管理主键集合
     * @return 结果
     */
    public int deleteFavoriteByFavoriteIds(String[] favoriteIds);

    /**
     * 删除收藏管理信息
     * 
     * @param favoriteId 收藏管理主键
     * @return 结果
     */
    public int deleteFavoriteByFavoriteId(String favoriteId);
}
