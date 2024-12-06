package com.ruoyi.lytj.service;

import java.util.List;
import com.ruoyi.lytj.domain.RouteAttraction;

/**
 * 线路-景点关联管理Service接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface IRouteAttractionService 
{
    /**
     * 查询线路-景点关联管理
     * 
     * @param id 线路-景点关联管理主键
     * @return 线路-景点关联管理
     */
    public RouteAttraction selectRouteAttractionById(String id);

    /**
     * 查询线路-景点关联管理列表
     * 
     * @param routeAttraction 线路-景点关联管理
     * @return 线路-景点关联管理集合
     */
    public List<RouteAttraction> selectRouteAttractionList(RouteAttraction routeAttraction);

    /**
     * 新增线路-景点关联管理
     * 
     * @param routeAttraction 线路-景点关联管理
     * @return 结果
     */
    public int insertRouteAttraction(RouteAttraction routeAttraction);

    /**
     * 修改线路-景点关联管理
     * 
     * @param routeAttraction 线路-景点关联管理
     * @return 结果
     */
    public int updateRouteAttraction(RouteAttraction routeAttraction);

    /**
     * 批量删除线路-景点关联管理
     * 
     * @param ids 需要删除的线路-景点关联管理主键集合
     * @return 结果
     */
    public int deleteRouteAttractionByIds(String[] ids);

    /**
     * 删除线路-景点关联管理信息
     * 
     * @param id 线路-景点关联管理主键
     * @return 结果
     */
    public int deleteRouteAttractionById(String id);
}
