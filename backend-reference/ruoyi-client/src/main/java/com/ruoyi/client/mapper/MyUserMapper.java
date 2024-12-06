package com.ruoyi.client.mapper;

import com.ruoyi.client.domain.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * 客户端用户数据层
 */
@Mapper
public interface MyUserMapper {
    /**
     * 根据用户名查询用户
     */
    MyUser selectByUsername(@Param("username") String username);

    /**
     * 根据邮箱查询用户
     */
    MyUser selectByEmail(@Param("email") String email);

    /**
     * 根据手机号查询用户
     */
    MyUser selectByPhone(@Param("phone") String phone);

    /**
     * 更新登录时间
     */
    int updateLoginTime(@Param("userId") Long userId);
}