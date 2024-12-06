package com.ruoyi.lytj.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.lytj.domain.DashboardPlaceholder;
import com.ruoyi.lytj.service.IDashboardPlaceholderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 可视化大屏占位Controller
 * 
 * @author xmh
 * @date 2024-11-24
 */
@RestController
@RequestMapping("/lytj/dashboard")
public class DashboardPlaceholderController extends BaseController
{
    @Autowired
    private IDashboardPlaceholderService dashboardPlaceholderService;

    /**
     * 查询可视化大屏占位列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:dashboard:list')")
    @GetMapping("/list")
    public TableDataInfo list(DashboardPlaceholder dashboardPlaceholder)
    {
        startPage();
        List<DashboardPlaceholder> list = dashboardPlaceholderService.selectDashboardPlaceholderList(dashboardPlaceholder);
        return getDataTable(list);
    }

    /**
     * 导出可视化大屏占位列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:dashboard:export')")
    @Log(title = "可视化大屏占位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DashboardPlaceholder dashboardPlaceholder)
    {
        List<DashboardPlaceholder> list = dashboardPlaceholderService.selectDashboardPlaceholderList(dashboardPlaceholder);
        ExcelUtil<DashboardPlaceholder> util = new ExcelUtil<DashboardPlaceholder>(DashboardPlaceholder.class);
        util.exportExcel(response, list, "可视化大屏占位数据");
    }

    /**
     * 获取可视化大屏占位详细信息
     */
    @PreAuthorize("@ss.hasPermi('lytj:dashboard:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(dashboardPlaceholderService.selectDashboardPlaceholderById(id));
    }

    /**
     * 新增可视化大屏占位
     */
    @PreAuthorize("@ss.hasPermi('lytj:dashboard:add')")
    @Log(title = "可视化大屏占位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DashboardPlaceholder dashboardPlaceholder)
    {
        return toAjax(dashboardPlaceholderService.insertDashboardPlaceholder(dashboardPlaceholder));
    }

    /**
     * 修改可视化大屏占位
     */
    @PreAuthorize("@ss.hasPermi('lytj:dashboard:edit')")
    @Log(title = "可视化大屏占位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DashboardPlaceholder dashboardPlaceholder)
    {
        return toAjax(dashboardPlaceholderService.updateDashboardPlaceholder(dashboardPlaceholder));
    }

    /**
     * 删除可视化大屏占位
     */
    @PreAuthorize("@ss.hasPermi('lytj:dashboard:remove')")
    @Log(title = "可视化大屏占位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(dashboardPlaceholderService.deleteDashboardPlaceholderByIds(ids));
    }
}
