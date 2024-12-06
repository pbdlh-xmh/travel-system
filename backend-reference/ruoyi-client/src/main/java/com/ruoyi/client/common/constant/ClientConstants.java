package com.ruoyi.client.common.constant;

public class ClientConstants {
    /**
     * 客户端 token
     */
    public static final String CLIENT_TOKEN = "Client-Token";

    /**
     * 登录用户 redis key
     */
    public static final String LOGIN_TOKEN_KEY = "client:token:";

    /**
     * 验证码 redis key
     */
    public static final String CAPTCHA_CODE_KEY = "client:captcha:";

    /**
     * 参数管理 cache key
     */
    public static final String CLIENT_CONFIG_KEY = "client:config:";

    /**
     * 密码最大错误次数
     */
    public static final int PASSWORD_MAX_RETRY_COUNT = 5;

    /**
     * 密码锁定时间，默认1小时
     */
    public static final int PASSWORD_LOCK_TIME = 1;
}
