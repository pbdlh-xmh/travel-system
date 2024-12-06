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
import com.ruoyi.lytj.domain.Carousel;
import com.ruoyi.lytj.service.ICarouselService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 轮播图管理Controller
 * 
 * @author xmh
 * @date 2024-11-24
 */
@RestController
@RequestMapping("/lytj/carousel")
public class CarouselController extends BaseController
{
    @Autowired
    private ICarouselService carouselService;

    /**
     * 查询轮播图管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:carousel:list')")
    @GetMapping("/list")
    public TableDataInfo list(Carousel carousel)
    {
        startPage();
        List<Carousel> list = carouselService.selectCarouselList(carousel);
        return getDataTable(list);
    }

    /**
     * 导出轮播图管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:carousel:export')")
    @Log(title = "轮播图管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Carousel carousel)
    {
        List<Carousel> list = carouselService.selectCarouselList(carousel);
        ExcelUtil<Carousel> util = new ExcelUtil<Carousel>(Carousel.class);
        util.exportExcel(response, list, "轮播图管理数据");
    }

    /**
     * 获取轮播图管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lytj:carousel:query')")
    @GetMapping(value = "/{carouselId}")
    public AjaxResult getInfo(@PathVariable("carouselId") String carouselId)
    {
        return success(carouselService.selectCarouselByCarouselId(carouselId));
    }

    /**
     * 新增轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:carousel:add')")
    @Log(title = "轮播图管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Carousel carousel)
    {
        return toAjax(carouselService.insertCarousel(carousel));
    }

    /**
     * 修改轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:carousel:edit')")
    @Log(title = "轮播图管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Carousel carousel)
    {
        return toAjax(carouselService.updateCarousel(carousel));
    }

    /**
     * 删除轮播图管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:carousel:remove')")
    @Log(title = "轮播图管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{carouselIds}")
    public AjaxResult remove(@PathVariable String[] carouselIds)
    {
        return toAjax(carouselService.deleteCarouselByCarouselIds(carouselIds));
    }
}
