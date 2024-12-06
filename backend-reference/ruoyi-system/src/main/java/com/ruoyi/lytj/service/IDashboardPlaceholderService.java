package com.ruoyi.lytj.service;

import java.util.List;
import com.ruoyi.lytj.domain.DashboardPlaceholder;

/**
 * 可视化大屏占位Service接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface IDashboardPlaceholderService 
{
    /**
     * 查询可视化大屏占位
     * 
     * @param id 可视化大屏占位主键
     * @return 可视化大屏占位
     */
    public DashboardPlaceholder selectDashboardPlaceholderById(String id);

    /**
     * 查询可视化大屏占位列表
     * 
     * @param dashboardPlaceholder 可视化大屏占位
     * @return 可视化大屏占位集合
     */
    public List<DashboardPlaceholder> selectDashboardPlaceholderList(DashboardPlaceholder dashboardPlaceholder);

    /**
     * 新增可视化大屏占位
     * 
     * @param dashboardPlaceholder 可视化大屏占位
     * @return 结果
     */
    public int insertDashboardPlaceholder(DashboardPlaceholder dashboardPlaceholder);

    /**
     * 修改可视化大屏占位
     * 
     * @param dashboardPlaceholder 可视化大屏占位
     * @return 结果
     */
    public int updateDashboardPlaceholder(DashboardPlaceholder dashboardPlaceholder);

    /**
     * 批量删除可视化大屏占位
     * 
     * @param ids 需要删除的可视化大屏占位主键集合
     * @return 结果
     */
    public int deleteDashboardPlaceholderByIds(String[] ids);

    /**
     * 删除可视化大屏占位信息
     * 
     * @param id 可视化大屏占位主键
     * @return 结果
     */
    public int deleteDashboardPlaceholderById(String id);
}
