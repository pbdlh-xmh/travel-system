package com.ruoyi.lytj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lytj.mapper.NewsMapper;
import com.ruoyi.lytj.domain.News;
import com.ruoyi.lytj.service.INewsService;

/**
 * 旅游新闻Service业务层处理
 * 
 * @author xmh
 * @date 2024-11-24
 */
@Service
public class NewsServiceImpl implements INewsService 
{
    @Autowired
    private NewsMapper newsMapper;

    /**
     * 查询旅游新闻
     * 
     * @param newsId 旅游新闻主键
     * @return 旅游新闻
     */
    @Override
    public News selectNewsByNewsId(String newsId)
    {
        return newsMapper.selectNewsByNewsId(newsId);
    }

    /**
     * 查询旅游新闻列表
     * 
     * @param news 旅游新闻
     * @return 旅游新闻
     */
    @Override
    public List<News> selectNewsList(News news)
    {
        return newsMapper.selectNewsList(news);
    }

    /**
     * 新增旅游新闻
     * 
     * @param news 旅游新闻
     * @return 结果
     */
    @Override
    public int insertNews(News news)
    {
        news.setCreateTime(DateUtils.getNowDate());
        return newsMapper.insertNews(news);
    }

    /**
     * 修改旅游新闻
     * 
     * @param news 旅游新闻
     * @return 结果
     */
    @Override
    public int updateNews(News news)
    {
        news.setUpdateTime(DateUtils.getNowDate());
        return newsMapper.updateNews(news);
    }

    /**
     * 批量删除旅游新闻
     * 
     * @param newsIds 需要删除的旅游新闻主键
     * @return 结果
     */
    @Override
    public int deleteNewsByNewsIds(String[] newsIds)
    {
        return newsMapper.deleteNewsByNewsIds(newsIds);
    }

    /**
     * 删除旅游新闻信息
     * 
     * @param newsId 旅游新闻主键
     * @return 结果
     */
    @Override
    public int deleteNewsByNewsId(String newsId)
    {
        return newsMapper.deleteNewsByNewsId(newsId);
    }
}
