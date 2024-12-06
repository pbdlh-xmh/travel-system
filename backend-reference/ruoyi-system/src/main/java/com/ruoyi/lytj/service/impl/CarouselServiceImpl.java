package com.ruoyi.lytj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lytj.mapper.CarouselMapper;
import com.ruoyi.lytj.domain.Carousel;
import com.ruoyi.lytj.service.ICarouselService;

/**
 * 轮播图管理Service业务层处理
 * 
 * @author xmh
 * @date 2024-11-24
 */
@Service
public class CarouselServiceImpl implements ICarouselService 
{
    @Autowired
    private CarouselMapper carouselMapper;

    /**
     * 查询轮播图管理
     * 
     * @param carouselId 轮播图管理主键
     * @return 轮播图管理
     */
    @Override
    public Carousel selectCarouselByCarouselId(String carouselId)
    {
        return carouselMapper.selectCarouselByCarouselId(carouselId);
    }

    /**
     * 查询轮播图管理列表
     * 
     * @param carousel 轮播图管理
     * @return 轮播图管理
     */
    @Override
    public List<Carousel> selectCarouselList(Carousel carousel)
    {
        return carouselMapper.selectCarouselList(carousel);
    }

    /**
     * 新增轮播图管理
     * 
     * @param carousel 轮播图管理
     * @return 结果
     */
    @Override
    public int insertCarousel(Carousel carousel)
    {
        carousel.setCreateTime(DateUtils.getNowDate());
        return carouselMapper.insertCarousel(carousel);
    }

    /**
     * 修改轮播图管理
     * 
     * @param carousel 轮播图管理
     * @return 结果
     */
    @Override
    public int updateCarousel(Carousel carousel)
    {
        return carouselMapper.updateCarousel(carousel);
    }

    /**
     * 批量删除轮播图管理
     * 
     * @param carouselIds 需要删除的轮播图管理主键
     * @return 结果
     */
    @Override
    public int deleteCarouselByCarouselIds(String[] carouselIds)
    {
        return carouselMapper.deleteCarouselByCarouselIds(carouselIds);
    }

    /**
     * 删除轮播图管理信息
     * 
     * @param carouselId 轮播图管理主键
     * @return 结果
     */
    @Override
    public int deleteCarouselByCarouselId(String carouselId)
    {
        return carouselMapper.deleteCarouselByCarouselId(carouselId);
    }
}
