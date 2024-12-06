package com.ruoyi.lytj.mapper;

import java.util.List;
import com.ruoyi.lytj.domain.TourRoute;

/**
 * 旅游线路管理Mapper接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface TourRouteMapper 
{
    /**
     * 查询旅游线路管理
     * 
     * @param routeId 旅游线路管理主键
     * @return 旅游线路管理
     */
    public TourRoute selectTourRouteByRouteId(String routeId);

    /**
     * 查询旅游线路管理列表
     * 
     * @param tourRoute 旅游线路管理
     * @return 旅游线路管理集合
     */
    public List<TourRoute> selectTourRouteList(TourRoute tourRoute);

    /**
     * 新增旅游线路管理
     * 
     * @param tourRoute 旅游线路管理
     * @return 结果
     */
    public int insertTourRoute(TourRoute tourRoute);

    /**
     * 修改旅游线路管理
     * 
     * @param tourRoute 旅游线路管理
     * @return 结果
     */
    public int updateTourRoute(TourRoute tourRoute);

    /**
     * 删除旅游线路管理
     * 
     * @param routeId 旅游线路管理主键
     * @return 结果
     */
    public int deleteTourRouteByRouteId(String routeId);

    /**
     * 批量删除旅游线路管理
     * 
     * @param routeIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTourRouteByRouteIds(String[] routeIds);
}