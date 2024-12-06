package com.ruoyi.client.domain.vo;

import lombok.Data;

@Data
public class LoginVO {
    /**
     * token
     */
    private String token;

    /**
     * 用户信息
     */
    private UserInfoVO user;
}
