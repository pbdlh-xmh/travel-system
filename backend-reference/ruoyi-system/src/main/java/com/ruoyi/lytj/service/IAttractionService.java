package com.ruoyi.lytj.service;

import java.util.List;
import com.ruoyi.lytj.domain.Attraction;

/**
 * 景点管理Service接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface IAttractionService 
{
    /**
     * 查询景点管理
     * 
     * @param attractionId 景点管理主键
     * @return 景点管理
     */
    public Attraction selectAttractionByAttractionId(String attractionId);

    /**
     * 查询景点管理列表
     * 
     * @param attraction 景点管理
     * @return 景点管理集合
     */
    public List<Attraction> selectAttractionList(Attraction attraction);

    /**
     * 新增景点管理
     * 
     * @param attraction 景点管理
     * @return 结果
     */
    public int insertAttraction(Attraction attraction);

    /**
     * 修改景点管理
     * 
     * @param attraction 景点管理
     * @return 结果
     */
    public int updateAttraction(Attraction attraction);

    /**
     * 批量删除景点管理
     * 
     * @param attractionIds 需要删除的景点管理主键集合
     * @return 结果
     */
    public int deleteAttractionByAttractionIds(String[] attractionIds);

    /**
     * 删除景点管理信息
     * 
     * @param attractionId 景点管理主键
     * @return 结果
     */
    public int deleteAttractionByAttractionId(String attractionId);
}
