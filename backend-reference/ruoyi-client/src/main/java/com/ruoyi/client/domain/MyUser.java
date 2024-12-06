package com.ruoyi.client.domain;

import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 客户端用户对象
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MyUser extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long userId;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 邮箱 */
    private String email;

    /** 手机号 */
    private String phone;

    /** 性别 (0未知,1男,2女) */
    private Integer gender;

    /** 头像URL */
    private String avatarUrl;

    /** 状态(1正常,0禁用) */
    private Integer status;

    /** 最后登录时间 */
    private Date lastLoginTime;
}