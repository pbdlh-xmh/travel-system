package com.ruoyi.lytj.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户管理对象 myuser
 * 
 * @author xmh
 * @date 2024-11-24
 */
public class Myuser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private String userId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码（加密存储） */
    @Excel(name = "密码", readConverterExp = "加=密存储")
    private String password;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 性别（0未知，1男，2女） */
    @Excel(name = "性别", readConverterExp = "0=未知，1男，2女")
    private Long gender;

    /** 生日 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生日", width = 30, dateFormat = "yyyy-MM-dd")
    private Date birthday;

    /** 用户头像路径 */
    @Excel(name = "用户头像路径")
    private String avatarUrl;

    /** 用户兴趣标签，逗号分隔的标签 */
    @Excel(name = "用户兴趣标签，逗号分隔的标签")
    private String interestTags;

    /** 注册时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date registerTime;

    /** 上次登录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上次登录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastLoginTime;

    /** 状态（1正常，0禁用） */
    @Excel(name = "状态", readConverterExp = "1=正常，0禁用")
    private Long status;

    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setGender(Long gender) 
    {
        this.gender = gender;
    }

    public Long getGender() 
    {
        return gender;
    }
    public void setBirthday(Date birthday) 
    {
        this.birthday = birthday;
    }

    public Date getBirthday() 
    {
        return birthday;
    }
    public void setAvatarUrl(String avatarUrl) 
    {
        this.avatarUrl = avatarUrl;
    }

    public String getAvatarUrl() 
    {
        return avatarUrl;
    }
    public void setInterestTags(String interestTags) 
    {
        this.interestTags = interestTags;
    }

    public String getInterestTags() 
    {
        return interestTags;
    }
    public void setRegisterTime(Date registerTime) 
    {
        this.registerTime = registerTime;
    }

    public Date getRegisterTime() 
    {
        return registerTime;
    }
    public void setLastLoginTime(Date lastLoginTime) 
    {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastLoginTime() 
    {
        return lastLoginTime;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("username", getUsername())
            .append("password", getPassword())
            .append("email", getEmail())
            .append("phone", getPhone())
            .append("gender", getGender())
            .append("birthday", getBirthday())
            .append("avatarUrl", getAvatarUrl())
            .append("interestTags", getInterestTags())
            .append("registerTime", getRegisterTime())
            .append("lastLoginTime", getLastLoginTime())
            .append("status", getStatus())
            .toString();
    }
}
