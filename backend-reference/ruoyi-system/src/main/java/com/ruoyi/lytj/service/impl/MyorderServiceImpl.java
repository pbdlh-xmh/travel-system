package com.ruoyi.lytj.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.lytj.mapper.MyorderMapper;
import com.ruoyi.lytj.domain.Myorder;
import com.ruoyi.lytj.service.IMyorderService;

/**
 * 订单管理Service业务层处理
 * 
 * @author xmh
 * @date 2024-11-24
 */
@Service
public class MyorderServiceImpl implements IMyorderService 
{
    @Autowired
    private MyorderMapper myorderMapper;

    /**
     * 查询订单管理
     * 
     * @param orderId 订单管理主键
     * @return 订单管理
     */
    @Override
    public Myorder selectMyorderByOrderId(String orderId)
    {
        return myorderMapper.selectMyorderByOrderId(orderId);
    }

    /**
     * 查询订单管理列表
     * 
     * @param myorder 订单管理
     * @return 订单管理
     */
    @Override
    public List<Myorder> selectMyorderList(Myorder myorder)
    {
        return myorderMapper.selectMyorderList(myorder);
    }

    /**
     * 新增订单管理
     * 
     * @param myorder 订单管理
     * @return 结果
     */
    @Override
    public int insertMyorder(Myorder myorder)
    {
        myorder.setCreateTime(DateUtils.getNowDate());
        return myorderMapper.insertMyorder(myorder);
    }

    /**
     * 修改订单管理
     * 
     * @param myorder 订单管理
     * @return 结果
     */
    @Override
    public int updateMyorder(Myorder myorder)
    {
        myorder.setUpdateTime(DateUtils.getNowDate());
        return myorderMapper.updateMyorder(myorder);
    }

    /**
     * 批量删除订单管理
     * 
     * @param orderIds 需要删除的订单管理主键
     * @return 结果
     */
    @Override
    public int deleteMyorderByOrderIds(String[] orderIds)
    {
        return myorderMapper.deleteMyorderByOrderIds(orderIds);
    }

    /**
     * 删除订单管理信息
     * 
     * @param orderId 订单管理主键
     * @return 结果
     */
    @Override
    public int deleteMyorderByOrderId(String orderId)
    {
        return myorderMapper.deleteMyorderByOrderId(orderId);
    }
}
