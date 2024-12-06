package com.ruoyi.client.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 客户端控制器基类
 */
public class BaseController {
    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 获取当前登录用户ID
     */
    protected Long getUserId() {
        return SecurityUtils.getUserId();
    }

    /**
     * 返回成功消息
     */
    protected AjaxResult success(String message) {
        return AjaxResult.success(message);
    }

    /**
     * 返回失败消息
     */
    protected AjaxResult error(String message) {
        return AjaxResult.error(message);
    }
}
