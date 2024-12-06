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
import com.ruoyi.lytj.domain.Myuser;
import com.ruoyi.lytj.service.IMyuserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户管理Controller
 * 
 * @author xmh
 * @date 2024-11-24
 */
@RestController
@RequestMapping("/lytj/myUser")
public class MyuserController extends BaseController
{
    @Autowired
    private IMyuserService myuserService;

    /**
     * 查询用户管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:myUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(Myuser myuser)
    {
        startPage();
        List<Myuser> list = myuserService.selectMyuserList(myuser);
        return getDataTable(list);
    }

    /**
     * 导出用户管理列表
     */
    @PreAuthorize("@ss.hasPermi('lytj:myUser:export')")
    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Myuser myuser)
    {
        List<Myuser> list = myuserService.selectMyuserList(myuser);
        ExcelUtil<Myuser> util = new ExcelUtil<Myuser>(Myuser.class);
        util.exportExcel(response, list, "用户管理数据");
    }

    /**
     * 获取用户管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('lytj:myUser:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") String userId)
    {
        return success(myuserService.selectMyuserByUserId(userId));
    }

    /**
     * 新增用户管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:myUser:add')")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Myuser myuser)
    {
        return toAjax(myuserService.insertMyuser(myuser));
    }

    /**
     * 修改用户管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:myUser:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Myuser myuser)
    {
        return toAjax(myuserService.updateMyuser(myuser));
    }

    /**
     * 删除用户管理
     */
    @PreAuthorize("@ss.hasPermi('lytj:myUser:remove')")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable String[] userIds)
    {
        return toAjax(myuserService.deleteMyuserByUserIds(userIds));
    }
}
