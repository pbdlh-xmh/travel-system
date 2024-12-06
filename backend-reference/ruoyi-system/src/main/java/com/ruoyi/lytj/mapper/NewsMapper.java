package com.ruoyi.lytj.mapper;

import java.util.List;
import com.ruoyi.lytj.domain.News;

/**
 * 旅游新闻Mapper接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface NewsMapper 
{
    /**
     * 查询旅游新闻
     * 
     * @param newsId 旅游新闻主键
     * @return 旅游新闻
     */
    public News selectNewsByNewsId(String newsId);

    /**
     * 查询旅游新闻列表
     * 
     * @param news 旅游新闻
     * @return 旅游新闻集合
     */
    public List<News> selectNewsList(News news);

    /**
     * 新增旅游新闻
     * 
     * @param news 旅游新闻
     * @return 结果
     */
    public int insertNews(News news);

    /**
     * 修改旅游新闻
     * 
     * @param news 旅游新闻
     * @return 结果
     */
    public int updateNews(News news);

    /**
     * 删除旅游新闻
     * 
     * @param newsId 旅游新闻主键
     * @return 结果
     */
    public int deleteNewsByNewsId(String newsId);

    /**
     * 批量删除旅游新闻
     * 
     * @param newsIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteNewsByNewsIds(String[] newsIds);
}
