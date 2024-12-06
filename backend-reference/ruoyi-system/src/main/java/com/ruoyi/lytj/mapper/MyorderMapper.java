package com.ruoyi.lytj.mapper;

import java.util.List;
import com.ruoyi.lytj.domain.Myorder;

/**
 * 订单管理Mapper接口
 * 
 * @author xmh
 * @date 2024-11-24
 */
public interface MyorderMapper 
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
     * 删除订单管理
     * 
     * @param orderId 订单管理主键
     * @return 结果
     */
    public int deleteMyorderByOrderId(String orderId);

    /**
     * 批量删除订单管理
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyorderByOrderIds(String[] orderIds);
}
