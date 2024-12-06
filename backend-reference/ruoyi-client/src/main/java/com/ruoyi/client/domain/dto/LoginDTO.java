package com.ruoyi.client.domain.dto;

import lombok.Data;
import javax.validation.constraints.NotBlank;

/**
 * 登录请求参数对象
 */
@Data
public class LoginDTO {
    /**
     * 账号（用户名/邮箱/手机号）
     */
    @NotBlank(message = "账号不能为空")
    private String account;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 验证码标识
     */
    private String uuid;
}