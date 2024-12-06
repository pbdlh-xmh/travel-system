package com.ruoyi.lytj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lytj.mapper.AttractionMapper;
import com.ruoyi.lytj.domain.Attraction;
import com.ruoyi.lytj.service.IAttractionService;

/**
 * 景点管理Service业务层处理
 * 
 * @author xmh
 * @date 2024-11-24
 */
@Service
public class AttractionServiceImpl implements IAttractionService 
{
    @Autowired
    private AttractionMapper attractionMapper;

    /**
     * 查询景点管理
     * 
     * @param attractionId 景点管理主键
     * @return 景点管理
     */
    @Override
    public Attraction selectAttractionByAttractionId(String attractionId)
    {
        return attractionMapper.selectAttractionByAttractionId(attractionId);
    }

    /**
     * 查询景点管理列表
     * 
     * @param attraction 景点管理
     * @return 景点管理
     */
    @Override
    public List<Attraction> selectAttractionList(Attraction attraction)
    {
        return attractionMapper.selectAttractionList(attraction);
    }

    /**
     * 新增景点管理
     * 
     * @param attraction 景点管理
     * @return 结果
     */
    @Override
    public int insertAttraction(Attraction attraction)
    {
        attraction.setCreateTime(DateUtils.getNowDate());
        return attractionMapper.insertAttraction(attraction);
    }

    /**
     * 修改景点管理
     * 
     * @param attraction 景点管理
     * @return 结果
     */
    @Override
    public int updateAttraction(Attraction attraction)
    {
        attraction.setUpdateTime(DateUtils.getNowDate());
        return attractionMapper.updateAttraction(attraction);
    }

    /**
     * 批量删除景点管理
     * 
     * @param attractionIds 需要删除的景点管理主键
     * @return 结果
     */
    @Override
    public int deleteAttractionByAttractionIds(String[] attractionIds)
    {
        return attractionMapper.deleteAttractionByAttractionIds(attractionIds);
    }

    /**
     * 删除景点管理信息
     * 
     * @param attractionId 景点管理主键
     * @return 结果
     */
    @Override
    public int deleteAttractionByAttractionId(String attractionId)
    {
        return attractionMapper.deleteAttractionByAttractionId(attractionId);
    }
}
