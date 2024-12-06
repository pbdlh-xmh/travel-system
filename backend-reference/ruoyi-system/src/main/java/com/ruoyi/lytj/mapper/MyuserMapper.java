package com.ruoyi.lytj.mapper;

import java.util.List;
import com.ruoyi.lytj.domain.Myuser;

/**
 * 用户管理Mapper接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface MyuserMapper 
{
    /**
     * 查询用户管理
     * 
     * @param userId 用户管理主键
     * @return 用户管理
     */
    public Myuser selectMyuserByUserId(String userId);

    /**
     * 查询用户管理列表
     * 
     * @param myuser 用户管理
     * @return 用户管理集合
     */
    public List<Myuser> selectMyuserList(Myuser myuser);

    /**
     * 新增用户管理
     * 
     * @param myuser 用户管理
     * @return 结果
     */
    public int insertMyuser(Myuser myuser);

    /**
     * 修改用户管理
     * 
     * @param myuser 用户管理
     * @return 结果
     */
    public int updateMyuser(Myuser myuser);

    /**
     * 删除用户管理
     * 
     * @param userId 用户管理主键
     * @return 结果
     */
    public int deleteMyuserByUserId(String userId);

    /**
     * 批量删除用户管理
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyuserByUserIds(String[] userIds);
}