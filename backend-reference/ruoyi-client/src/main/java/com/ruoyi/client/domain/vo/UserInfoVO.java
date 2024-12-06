package com.ruoyi.client.domain.vo;

import lombok.Data;

/**
 * 用户信息视图对象
 * 用于前端展示用户基本信息，如：
 * 1. 登录后的用户信息展示
 * 2. 个人中心页面
 * 3. 评论区用户信息
 * 4. 订单联系信息等
 */
@Data
public class UserInfoVO {
    /**
     * 用户ID - 用于获取用户相关数据（订单、收藏等）
     */
    private Long userId;

    /**
     * 用户名 - 用于显示用户名
     */
    private String username;

    /**
     * 邮箱 - 用于显示联系方式
     */
    private String email;

    /**
     * 头像URL - 用于显示用户头像
     */
    private String avatarUrl;

    /**
     * 手机号 - 用于显示联系方式
     */
    private String phone;

    /**
     * 性别 - 用于个性化展示（0未知,1男,2女）
     */
    private Integer gender;
}