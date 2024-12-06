package com.ruoyi.lytj.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lytj.mapper.MyuserMapper;
import com.ruoyi.lytj.domain.Myuser;
import com.ruoyi.lytj.service.IMyuserService;

/**
 * 用户管理Service业务层处理
 * 
 * @author xmh
 * @date 2024-11-24
 */
@Service
public class MyuserServiceImpl implements IMyuserService 
{
    @Autowired
    private MyuserMapper myuserMapper;

    /**
     * 查询用户管理
     * 
     * @param userId 用户管理主键
     * @return 用户管理
     */
    @Override
    public Myuser selectMyuserByUserId(String userId)
    {
        return myuserMapper.selectMyuserByUserId(userId);
    }

    /**
     * 查询用户管理列表
     * 
     * @param myuser 用户管理
     * @return 用户管理
     */
    @Override
    public List<Myuser> selectMyuserList(Myuser myuser)
    {
        return myuserMapper.selectMyuserList(myuser);
    }

    /**
     * 新增用户管理
     * 
     * @param myuser 用户管理
     * @return 结果
     */
    @Override
    public int insertMyuser(Myuser myuser)
    {
        return myuserMapper.insertMyuser(myuser);
    }

    /**
     * 修改用户管理
     * 
     * @param myuser 用户管理
     * @return 结果
     */
    @Override
    public int updateMyuser(Myuser myuser)
    {
        return myuserMapper.updateMyuser(myuser);
    }

    /**
     * 批量删除用户管理
     * 
     * @param userIds 需要删除的用户管理主键
     * @return 结果
     */
    @Override
    public int deleteMyuserByUserIds(String[] userIds)
    {
        return myuserMapper.deleteMyuserByUserIds(userIds);
    }

    /**
     * 删除用户管理信息
     * 
     * @param userId 用户管理主键
     * @return 结果
     */
    @Override
    public int deleteMyuserByUserId(String userId)
    {
        return myuserMapper.deleteMyuserByUserId(userId);
    }
}
