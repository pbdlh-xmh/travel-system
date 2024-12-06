package com.ruoyi.web.controller.lytj.controller;

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
import com.ruoyi.lytj.domain.Attraction;
import com.ruoyi.lytj.service.IAttractionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 景点管理Controller
 * 
 * @author xmh
 * &#064;date  2024-11-24
 */
@RestController
@RequestMapping("/lytj/attraction")
public class AttractionController extends BaseController
{
    @Autowired
    private IAttractionService attractionService;

    /**
     * 查询景点管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:attraction:list')")
    @GetMapping("/list")
    public TableDataInfo list(Attraction attraction)
    {
        startPage();
        List<Attraction> list = attractionService.selectAttractionList(attraction);
        return getDataTable(list);
    }

    /**
     * 导出景点管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:attraction:export')")
    @Log(title = "景点管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Attraction attraction)
    {
        List<Attraction> list = attractionService.selectAttractionList(attraction);
        ExcelUtil<Attraction> util = new ExcelUtil<Attraction>(Attraction.class);
        util.exportExcel(response, list, "景点管理数据");
    }

    /**
     * 获取景点管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lytj:attraction:query')")
    @GetMapping(value = "/{attractionId}")
    public AjaxResult getInfo(@PathVariable("attractionId") String attractionId)
    {
        return success(attractionService.selectAttractionByAttractionId(attractionId));
    }

    /**
     * 新增景点管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:attraction:add')")
    @Log(title = "景点管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Attraction attraction)
    {
        return toAjax(attractionService.insertAttraction(attraction));
    }

    /**
     * 修改景点管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:attraction:edit')")
    @Log(title = "景点管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Attraction attraction)
    {
        return toAjax(attractionService.updateAttraction(attraction));
    }

    /**
     * 删除景点管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:attraction:remove')")
    @Log(title = "景点管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{attractionIds}")
    public AjaxResult remove(@PathVariable String[] attractionIds)
    {
        return toAjax(attractionService.deleteAttractionByAttractionIds(attractionIds));
    }
}
