package com.ruoyi.lytj.mapper;

import java.util.List;
import com.ruoyi.lytj.domain.Favorite;

/**
 * 收藏管理Mapper接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface FavoriteMapper 
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
     * 删除收藏管理
     * 
     * @param favoriteId 收藏管理主键
     * @return 结果
     */
    public int deleteFavoriteByFavoriteId(String favoriteId);

    /**
     * 批量删除收藏管理
     * 
     * @param favoriteIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFavoriteByFavoriteIds(String[] favoriteIds);
}
