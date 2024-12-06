package com.ruoyi.lytj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lytj.mapper.RouteAttractionMapper;
import com.ruoyi.lytj.domain.RouteAttraction;
import com.ruoyi.lytj.service.IRouteAttractionService;

/**
 * 线路-景点关联管理Service业务层处理
 * 
 * @author xmh
 * @date 2024-11-24
 */
@Service
public class RouteAttractionServiceImpl implements IRouteAttractionService 
{
    @Autowired
    private RouteAttractionMapper routeAttractionMapper;

    /**
     * 查询线路-景点关联管理
     * 
     * @param id 线路-景点关联管理主键
     * @return 线路-景点关联管理
     */
    @Override
    public RouteAttraction selectRouteAttractionById(String id)
    {
        return routeAttractionMapper.selectRouteAttractionById(id);
    }

    /**
     * 查询线路-景点关联管理列表
     * 
     * @param routeAttraction 线路-景点关联管理
     * @return 线路-景点关联管理
     */
    @Override
    public List<RouteAttraction> selectRouteAttractionList(RouteAttraction routeAttraction)
    {
        return routeAttractionMapper.selectRouteAttractionList(routeAttraction);
    }

    /**
     * 新增线路-景点关联管理
     * 
     * @param routeAttraction 线路-景点关联管理
     * @return 结果
     */
    @Override
    public int insertRouteAttraction(RouteAttraction routeAttraction)
    {
        return routeAttractionMapper.insertRouteAttraction(routeAttraction);
    }

    /**
     * 修改线路-景点关联管理
     * 
     * @param routeAttraction 线路-景点关联管理
     * @return 结果
     */
    @Override
    public int updateRouteAttraction(RouteAttraction routeAttraction)
    {
        return routeAttractionMapper.updateRouteAttraction(routeAttraction);
    }

    /**
     * 批量删除线路-景点关联管理
     * 
     * @param ids 需要删除的线路-景点关联管理主键
     * @return 结果
     */
    @Override
    public int deleteRouteAttractionByIds(String[] ids)
    {
        return routeAttractionMapper.deleteRouteAttractionByIds(ids);
    }

    /**
     * 删除线路-景点关联管理信息
     * 
     * @param id 线路-景点关联管理主键
     * @return 结果
     */
    @Override
    public int deleteRouteAttractionById(String id)
    {
        return routeAttractionMapper.deleteRouteAttractionById(id);
    }
}
