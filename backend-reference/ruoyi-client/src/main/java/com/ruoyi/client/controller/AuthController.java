package com.ruoyi.client.controller;

import com.ruoyi.client.domain.dto.LoginDTO;
import com.ruoyi.client.domain.vo.LoginVO;
import com.ruoyi.client.service.IAuthService;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 客户端认证接口
 */
@RestController
@RequestMapping("/client/auth")
public class AuthController extends BaseController {

    @Autowired
    private IAuthService authService;

    /**
     * 登录方法
     */
    @PostMapping("/login")
    public AjaxResult login(@Validated @RequestBody LoginDTO loginDTO) {
        LoginVO loginVO = authService.login(loginDTO);
        return AjaxResult.success(loginVO);
    }

    /**
     * 退出登录
     */
    @PostMapping("/logout")
    public AjaxResult logout() {
        Long userId = getUserId();
        authService.logout(userId);
        return AjaxResult.success();
    }
}
