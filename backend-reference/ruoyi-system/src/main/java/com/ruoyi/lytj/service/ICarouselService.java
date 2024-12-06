package com.ruoyi.lytj.service;

import java.util.List;
import com.ruoyi.lytj.domain.Carousel;

/**
 * 轮播图管理Service接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface ICarouselService 
{
    /**
     * 查询轮播图管理
     * 
     * @param carouselId 轮播图管理主键
     * @return 轮播图管理
     */
    public Carousel selectCarouselByCarouselId(String carouselId);

    /**
     * 查询轮播图管理列表
     * 
     * @param carousel 轮播图管理
     * @return 轮播图管理集合
     */
    public List<Carousel> selectCarouselList(Carousel carousel);

    /**
     * 新增轮播图管理
     * 
     * @param carousel 轮播图管理
     * @return 结果
     */
    public int insertCarousel(Carousel carousel);

    /**
     * 修改轮播图管理
     * 
     * @param carousel 轮播图管理
     * @return 结果
     */
    public int updateCarousel(Carousel carousel);

    /**
     * 批量删除轮播图管理
     * 
     * @param carouselIds 需要删除的轮播图管理主键集合
     * @return 结果
     */
    public int deleteCarouselByCarouselIds(String[] carouselIds);

    /**
     * 删除轮播图管理信息
     * 
     * @param carouselId 轮播图管理主键
     * @return 结果
     */
    public int deleteCarouselByCarouselId(String carouselId);
}
