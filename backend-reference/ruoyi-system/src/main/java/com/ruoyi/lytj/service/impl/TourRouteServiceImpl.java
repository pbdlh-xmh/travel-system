package com.ruoyi.lytj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lytj.mapper.TourRouteMapper;
import com.ruoyi.lytj.domain.TourRoute;
import com.ruoyi.lytj.service.ITourRouteService;

/**
 * 旅游线路管理Service业务层处理
 * 
 * @author xmh
 * @date 2024-11-24
 */
@Service
public class TourRouteServiceImpl implements ITourRouteService 
{
    @Autowired
    private TourRouteMapper tourRouteMapper;

    /**
     * 查询旅游线路管理
     * 
     * @param routeId 旅游线路管理主键
     * @return 旅游线路管理
     */
    @Override
    public TourRoute selectTourRouteByRouteId(String routeId)
    {
        return tourRouteMapper.selectTourRouteByRouteId(routeId);
    }

    /**
     * 查询旅游线路管理列表
     * 
     * @param tourRoute 旅游线路管理
     * @return 旅游线路管理
     */
    @Override
    public List<TourRoute> selectTourRouteList(TourRoute tourRoute)
    {
        return tourRouteMapper.selectTourRouteList(tourRoute);
    }

    /**
     * 新增旅游线路管理
     * 
     * @param tourRoute 旅游线路管理
     * @return 结果
     */
    @Override
    public int insertTourRoute(TourRoute tourRoute)
    {
        tourRoute.setCreateTime(DateUtils.getNowDate());
        return tourRouteMapper.insertTourRoute(tourRoute);
    }

    /**
     * 修改旅游线路管理
     * 
     * @param tourRoute 旅游线路管理
     * @return 结果
     */
    @Override
    public int updateTourRoute(TourRoute tourRoute)
    {
        tourRoute.setUpdateTime(DateUtils.getNowDate());
        return tourRouteMapper.updateTourRoute(tourRoute);
    }

    /**
     * 批量删除旅游线路管理
     * 
     * @param routeIds 需要删除的旅游线路管理主键
     * @return 结果
     */
    @Override
    public int deleteTourRouteByRouteIds(String[] routeIds)
    {
        return tourRouteMapper.deleteTourRouteByRouteIds(routeIds);
    }

    /**
     * 删除旅游线路管理信息
     * 
     * @param routeId 旅游线路管理主键
     * @return 结果
     */
    @Override
    public int deleteTourRouteByRouteId(String routeId)
    {
        return tourRouteMapper.deleteTourRouteByRouteId(routeId);
    }
}
