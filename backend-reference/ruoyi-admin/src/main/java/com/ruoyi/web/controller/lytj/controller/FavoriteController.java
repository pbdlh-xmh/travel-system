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
import com.ruoyi.lytj.domain.Favorite;
import com.ruoyi.lytj.service.IFavoriteService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 收藏管理Controller
 * 
 * @author xmh
 * @date 2024-11-24
 */
@RestController
@RequestMapping("/lytj/favorite")
public class FavoriteController extends BaseController
{
    @Autowired
    private IFavoriteService favoriteService;

    /**
     * 查询收藏管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:favorite:list')")
    @GetMapping("/list")
    public TableDataInfo list(Favorite favorite)
    {
        startPage();
        List<Favorite> list = favoriteService.selectFavoriteList(favorite);
        return getDataTable(list);
    }

    /**
     * 导出收藏管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:favorite:export')")
    @Log(title = "收藏管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Favorite favorite)
    {
        List<Favorite> list = favoriteService.selectFavoriteList(favorite);
        ExcelUtil<Favorite> util = new ExcelUtil<Favorite>(Favorite.class);
        util.exportExcel(response, list, "收藏管理数据");
    }

    /**
     * 获取收藏管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lytj:favorite:query')")
    @GetMapping(value = "/{favoriteId}")
    public AjaxResult getInfo(@PathVariable("favoriteId") String favoriteId)
    {
        return success(favoriteService.selectFavoriteByFavoriteId(favoriteId));
    }

    /**
     * 新增收藏管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:favorite:add')")
    @Log(title = "收藏管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Favorite favorite)
    {
        return toAjax(favoriteService.insertFavorite(favorite));
    }

    /**
     * 修改收藏管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:favorite:edit')")
    @Log(title = "收藏管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Favorite favorite)
    {
        return toAjax(favoriteService.updateFavorite(favorite));
    }

    /**
     * 删除收藏管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:favorite:remove')")
    @Log(title = "收藏管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{favoriteIds}")
    public AjaxResult remove(@PathVariable String[] favoriteIds)
    {
        return toAjax(favoriteService.deleteFavoriteByFavoriteIds(favoriteIds));
    }
}
