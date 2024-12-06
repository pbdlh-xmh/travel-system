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
import com.ruoyi.lytj.domain.RouteAttraction;
import com.ruoyi.lytj.service.IRouteAttractionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 线路-景点关联管理Controller
 * 
 * @author xmh
 * @date 2024-11-24
 */
@RestController
@RequestMapping("/lytj/routeAttraction")
public class RouteAttractionController extends BaseController
{
    @Autowired
    private IRouteAttractionService routeAttractionService;

    /**
     * 查询线路-景点关联管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:routeAttraction:list')")
    @GetMapping("/list")
    public TableDataInfo list(RouteAttraction routeAttraction)
    {
        startPage();
        List<RouteAttraction> list = routeAttractionService.selectRouteAttractionList(routeAttraction);
        return getDataTable(list);
    }

    /**
     * 导出线路-景点关联管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:routeAttraction:export')")
    @Log(title = "线路-景点关联管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RouteAttraction routeAttraction)
    {
        List<RouteAttraction> list = routeAttractionService.selectRouteAttractionList(routeAttraction);
        ExcelUtil<RouteAttraction> util = new ExcelUtil<RouteAttraction>(RouteAttraction.class);
        util.exportExcel(response, list, "线路-景点关联管理数据");
    }

    /**
     * 获取线路-景点关联管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lytj:routeAttraction:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(routeAttractionService.selectRouteAttractionById(id));
    }

    /**
     * 新增线路-景点关联管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:routeAttraction:add')")
    @Log(title = "线路-景点关联管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RouteAttraction routeAttraction)
    {
        return toAjax(routeAttractionService.insertRouteAttraction(routeAttraction));
    }

    /**
     * 修改线路-景点关联管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:routeAttraction:edit')")
    @Log(title = "线路-景点关联管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RouteAttraction routeAttraction)
    {
        return toAjax(routeAttractionService.updateRouteAttraction(routeAttraction));
    }

    /**
     * 删除线路-景点关联管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:routeAttraction:remove')")
    @Log(title = "线路-景点关联管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(routeAttractionService.deleteRouteAttractionByIds(ids));
    }
}
