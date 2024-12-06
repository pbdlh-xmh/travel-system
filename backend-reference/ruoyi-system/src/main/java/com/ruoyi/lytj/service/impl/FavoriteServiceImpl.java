package com.ruoyi.lytj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lytj.mapper.FavoriteMapper;
import com.ruoyi.lytj.domain.Favorite;
import com.ruoyi.lytj.service.IFavoriteService;

/**
 * 收藏管理Service业务层处理
 * 
 * @author xmh
 * @date 2024-11-24
 */
@Service
public class FavoriteServiceImpl implements IFavoriteService 
{
    @Autowired
    private FavoriteMapper favoriteMapper;

    /**
     * 查询收藏管理
     * 
     * @param favoriteId 收藏管理主键
     * @return 收藏管理
     */
    @Override
    public Favorite selectFavoriteByFavoriteId(String favoriteId)
    {
        return favoriteMapper.selectFavoriteByFavoriteId(favoriteId);
    }

    /**
     * 查询收藏管理列表
     * 
     * @param favorite 收藏管理
     * @return 收藏管理
     */
    @Override
    public List<Favorite> selectFavoriteList(Favorite favorite)
    {
        return favoriteMapper.selectFavoriteList(favorite);
    }

    /**
     * 新增收藏管理
     * 
     * @param favorite 收藏管理
     * @return 结果
     */
    @Override
    public int insertFavorite(Favorite favorite)
    {
        return favoriteMapper.insertFavorite(favorite);
    }

    /**
     * 修改收藏管理
     * 
     * @param favorite 收藏管理
     * @return 结果
     */
    @Override
    public int updateFavorite(Favorite favorite)
    {
        return favoriteMapper.updateFavorite(favorite);
    }

    /**
     * 批量删除收藏管理
     * 
     * @param favoriteIds 需要删除的收藏管理主键
     * @return 结果
     */
    @Override
    public int deleteFavoriteByFavoriteIds(String[] favoriteIds)
    {
        return favoriteMapper.deleteFavoriteByFavoriteIds(favoriteIds);
    }

    /**
     * 删除收藏管理信息
     * 
     * @param favoriteId 收藏管理主键
     * @return 结果
     */
    @Override
    public int deleteFavoriteByFavoriteId(String favoriteId)
    {
        return favoriteMapper.deleteFavoriteByFavoriteId(favoriteId);
    }
}
