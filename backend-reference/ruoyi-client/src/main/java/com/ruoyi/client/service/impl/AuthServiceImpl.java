package com.ruoyi.client.service.impl;

import com.ruoyi.client.domain.MyUser;
import com.ruoyi.client.domain.dto.LoginDTO;
import com.ruoyi.client.domain.vo.LoginVO;
import com.ruoyi.client.service.IAuthService;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class AuthServiceImpl implements IAuthService {

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private MyUserMapper myUserMapper;  // 需要创建此Mapper

    @Override
    public LoginVO login(LoginDTO loginDTO) {
        // 1. 验证码校验
        validateCaptcha(loginDTO);

        // 2. 用户认证
        MyUser user = authenticateUser(loginDTO);

        // 3. 生成token
        String token = generateToken(user);

        // 4. 更新登录时间
        updateLoginTime(user.getUserId());

        // 5. 构建返回数据
        return buildLoginVO(user, token);
    }

    /**
     * 用户认证
     */
    private MyUser authenticateUser(LoginDTO loginDTO) {
        String account = loginDTO.getAccount();
        String password = loginDTO.getPassword();

        // 查询用户
        MyUser user = null;
        if (account.contains("@")) {
            // 邮箱登录
            user = myUserMapper.selectByEmail(account);
        } else if (StringUtils.isNumeric(account)) {
            // 手机号登录
            user = myUserMapper.selectByPhone(account);
        } else {
            // 用户名登录
            user = myUserMapper.selectByUsername(account);
        }

        if (user == null) {
            throw new ServiceException("账号不存在");
        }

        // 校验密码
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if (!encoder.matches(password, user.getPassword())) {
            throw new ServiceException("密码错误");
        }

        // 校验状态
        if (user.getStatus() == 0) {
            throw new ServiceException("账号已被禁用");
        }

        return user;
    }

    /**
     * 生成token
     */
    private String generateToken(MyUser user) {
        String token = UUID.randomUUID().toString();
        String tokenKey = "client:token:" + user.getUserId();

        // 保存token到Redis，有效期30分钟
        redisCache.setCacheObject(tokenKey, token, 30, TimeUnit.MINUTES);

        return token;
    }

    /**
     * 更新登录时间
     */
    private void updateLoginTime(Long userId) {
        myUserMapper.updateLoginTime(userId);
    }

    /**
     * 构建登录返回对象
     */
    private LoginVO buildLoginVO(MyUser user, String token) {
        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);

        UserInfoVO userInfo = new UserInfoVO();
        userInfo.setUserId(user.getUserId());
        userInfo.setUsername(user.getUsername());
        userInfo.setEmail(user.getEmail());
        userInfo.setAvatarUrl(user.getAvatarUrl());
        userInfo.setPhone(user.getPhone());
        userInfo.setGender(user.getGender());

        loginVO.setUser(userInfo);

        return loginVO;
    }
}