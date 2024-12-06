package com.ruoyi.lytj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lytj.mapper.DashboardPlaceholderMapper;
import com.ruoyi.lytj.domain.DashboardPlaceholder;
import com.ruoyi.lytj.service.IDashboardPlaceholderService;

/**
 * 可视化大屏占位Service业务层处理
 * 
 * @author xmh
 * @date 2024-11-24
 */
@Service
public class DashboardPlaceholderServiceImpl implements IDashboardPlaceholderService 
{
    @Autowired
    private DashboardPlaceholderMapper dashboardPlaceholderMapper;

    /**
     * 查询可视化大屏占位
     * 
     * @param id 可视化大屏占位主键
     * @return 可视化大屏占位
     */
    @Override
    public DashboardPlaceholder selectDashboardPlaceholderById(String id)
    {
        return dashboardPlaceholderMapper.selectDashboardPlaceholderById(id);
    }

    /**
     * 查询可视化大屏占位列表
     * 
     * @param dashboardPlaceholder 可视化大屏占位
     * @return 可视化大屏占位
     */
    @Override
    public List<DashboardPlaceholder> selectDashboardPlaceholderList(DashboardPlaceholder dashboardPlaceholder)
    {
        return dashboardPlaceholderMapper.selectDashboardPlaceholderList(dashboardPlaceholder);
    }

    /**
     * 新增可视化大屏占位
     * 
     * @param dashboardPlaceholder 可视化大屏占位
     * @return 结果
     */
    @Override
    public int insertDashboardPlaceholder(DashboardPlaceholder dashboardPlaceholder)
    {
        return dashboardPlaceholderMapper.insertDashboardPlaceholder(dashboardPlaceholder);
    }

    /**
     * 修改可视化大屏占位
     * 
     * @param dashboardPlaceholder 可视化大屏占位
     * @return 结果
     */
    @Override
    public int updateDashboardPlaceholder(DashboardPlaceholder dashboardPlaceholder)
    {
        return dashboardPlaceholderMapper.updateDashboardPlaceholder(dashboardPlaceholder);
    }

    /**
     * 批量删除可视化大屏占位
     * 
     * @param ids 需要删除的可视化大屏占位主键
     * @return 结果
     */
    @Override
    public int deleteDashboardPlaceholderByIds(String[] ids)
    {
        return dashboardPlaceholderMapper.deleteDashboardPlaceholderByIds(ids);
    }

    /**
     * 删除可视化大屏占位信息
     * 
     * @param id 可视化大屏占位主键
     * @return 结果
     */
    @Override
    public int deleteDashboardPlaceholderById(String id)
    {
        return dashboardPlaceholderMapper.deleteDashboardPlaceholderById(id);
    }
}
