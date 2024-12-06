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
import com.ruoyi.lytj.domain.TourRoute;
import com.ruoyi.lytj.service.ITourRouteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 旅游线路管理Controller
 * 
 * @author xmh
 * @date 2024-11-24
 */
@RestController
@RequestMapping("/lytj/route")
public class TourRouteController extends BaseController
{
    @Autowired
    private ITourRouteService tourRouteService;

    /**
     * 查询旅游线路管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:route:list')")
    @GetMapping("/list")
    public TableDataInfo list(TourRoute tourRoute)
    {
        startPage();
        List<TourRoute> list = tourRouteService.selectTourRouteList(tourRoute);
        return getDataTable(list);
    }

    /**
     * 导出旅游线路管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:route:export')")
    @Log(title = "旅游线路管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TourRoute tourRoute)
    {
        List<TourRoute> list = tourRouteService.selectTourRouteList(tourRoute);
        ExcelUtil<TourRoute> util = new ExcelUtil<TourRoute>(TourRoute.class);
        util.exportExcel(response, list, "旅游线路管理数据");
    }

    /**
     * 获取旅游线路管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lytj:route:query')")
    @GetMapping(value = "/{routeId}")
    public AjaxResult getInfo(@PathVariable("routeId") String routeId)
    {
        return success(tourRouteService.selectTourRouteByRouteId(routeId));
    }

    /**
     * 新增旅游线路管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:route:add')")
    @Log(title = "旅游线路管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TourRoute tourRoute)
    {
        return toAjax(tourRouteService.insertTourRoute(tourRoute));
    }

    /**
     * 修改旅游线路管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:route:edit')")
    @Log(title = "旅游线路管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TourRoute tourRoute)
    {
        return toAjax(tourRouteService.updateTourRoute(tourRoute));
    }

    /**
     * 删除旅游线路管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:route:remove')")
    @Log(title = "旅游线路管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{routeIds}")
    public AjaxResult remove(@PathVariable String[] routeIds)
    {
        return toAjax(tourRouteService.deleteTourRouteByRouteIds(routeIds));
    }
}
