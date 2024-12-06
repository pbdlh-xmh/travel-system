package com.ruoyi.client.service;

import com.ruoyi.client.domain.dto.LoginDTO;
import com.ruoyi.client.domain.vo.LoginVO;

/**
 * 客户端认证服务接口
 */
public interface IAuthService {
    /**
     * 用户登录
     *
     * @param loginDTO 登录信息
     * @return 登录响应结果
     */
    LoginVO login(LoginDTO loginDTO);

    /**
     * 退出登录
     *
     * @param userId 用户ID
     */
    void logout(Long userId);
}
