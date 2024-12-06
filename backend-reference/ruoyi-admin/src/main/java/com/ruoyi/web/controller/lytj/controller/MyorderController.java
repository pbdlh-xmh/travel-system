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
import com.ruoyi.lytj.domain.Myorder;
import com.ruoyi.lytj.service.IMyorderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单管理Controller
 * 
 * @author xmh
 * @date 2024-11-24
 */
@RestController
@RequestMapping("/lytj/myorder")
public class MyorderController extends BaseController
{
    @Autowired
    private IMyorderService myorderService;

    /**
     * 查询订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:myorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(Myorder myorder)
    {
        startPage();
        List<Myorder> list = myorderService.selectMyorderList(myorder);
        return getDataTable(list);
    }

    /**
     * 导出订单管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:myorder:export')")
    @Log(title = "订单管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Myorder myorder)
    {
        List<Myorder> list = myorderService.selectMyorderList(myorder);
        ExcelUtil<Myorder> util = new ExcelUtil<Myorder>(Myorder.class);
        util.exportExcel(response, list, "订单管理数据");
    }

    /**
     * 获取订单管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lytj:myorder:query')")
    @GetMapping(value = "/{orderId}")
    public AjaxResult getInfo(@PathVariable("orderId") String orderId)
    {
        return success(myorderService.selectMyorderByOrderId(orderId));
    }

    /**
     * 新增订单管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:myorder:add')")
    @Log(title = "订单管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Myorder myorder)
    {
        return toAjax(myorderService.insertMyorder(myorder));
    }

    /**
     * 修改订单管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:myorder:edit')")
    @Log(title = "订单管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Myorder myorder)
    {
        return toAjax(myorderService.updateMyorder(myorder));
    }

    /**
     * 删除订单管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:myorder:remove')")
    @Log(title = "订单管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderIds}")
    public AjaxResult remove(@PathVariable String[] orderIds)
    {
        return toAjax(myorderService.deleteMyorderByOrderIds(orderIds));
    }
}
