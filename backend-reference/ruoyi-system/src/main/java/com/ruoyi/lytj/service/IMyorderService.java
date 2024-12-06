package com.ruoyi.lytj.service;

import java.util.List;
import com.ruoyi.lytj.domain.Myorder;

/**
 * 订单管理Service接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface IMyorderService 
{
    /**
     * 查询订单管理
     * 
     * @param orderId 订单管理主键
     * @return 订单管理
     */
    public Myorder selectMyorderByOrderId(String orderId);

    /**
     * 查询订单管理列表
     * 
     * @param myorder 订单管理
     * @return 订单管理集合
     */
    public List<Myorder> selectMyorderList(Myorder myorder);

    /**
     * 新增订单管理
     * 
     * @param myorder 订单管理
     * @return 结果
     */
    public int insertMyorder(Myorder myorder);

    /**
     * 修改订单管理
     * 
     * @param myorder 订单管理
     * @return 结果
     */
    public int updateMyorder(Myorder myorder);

    /**
     * 批量删除订单管理
     * 
     * @param orderIds 需要删除的订单管理主键集合
     * @return 结果
     */
    public int deleteMyorderByOrderIds(String[] orderIds);

    /**
     * 删除订单管理信息
     * 
     * @param orderId 订单管理主键
     * @return 结果
     */
    public int deleteMyorderByOrderId(String orderId);
}
