package com.ruoyi.lytj.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单管理对象 myorder
 * 
 * @author xmh
 * @date 2024-11-24
 */
public class Myorder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    @Excel(name = "订单ID")
    private String orderId;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 线路ID */
    @Excel(name = "线路ID")
    private String routeId;

    /** 下单时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下单时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date orderTime;

    /** 出行日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出行日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date travelDate;

    /** 出行人数 */
    @Excel(name = "出行人数")
    private Long numPeople;

    /** 总价 */
    @Excel(name = "总价")
    private BigDecimal totalPrice;

    /** 订单状态（0待支付，1已支付，2已取消） */
    @Excel(name = "订单状态", readConverterExp = "0=待支付，1已支付，2已取消")
    private Long orderStatus;

    /** 联系人姓名 */
    @Excel(name = "联系人姓名")
    private String contactName;

    /** 联系人电话 */
    @Excel(name = "联系人电话")
    private String contactPhone;

    /** 备注 */
    private String remarks;

    public void setOrderId(String orderId) 
    {
        this.orderId = orderId;
    }

    public String getOrderId() 
    {
        return orderId;
    }
    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }
    public void setRouteId(String routeId) 
    {
        this.routeId = routeId;
    }

    public String getRouteId() 
    {
        return routeId;
    }
    public void setOrderTime(Date orderTime) 
    {
        this.orderTime = orderTime;
    }

    public Date getOrderTime() 
    {
        return orderTime;
    }
    public void setTravelDate(Date travelDate) 
    {
        this.travelDate = travelDate;
    }

    public Date getTravelDate() 
    {
        return travelDate;
    }
    public void setNumPeople(Long numPeople) 
    {
        this.numPeople = numPeople;
    }

    public Long getNumPeople() 
    {
        return numPeople;
    }
    public void setTotalPrice(BigDecimal totalPrice) 
    {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalPrice() 
    {
        return totalPrice;
    }
    public void setOrderStatus(Long orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public Long getOrderStatus() 
    {
        return orderStatus;
    }
    public void setContactName(String contactName) 
    {
        this.contactName = contactName;
    }

    public String getContactName() 
    {
        return contactName;
    }
    public void setContactPhone(String contactPhone) 
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() 
    {
        return contactPhone;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("userId", getUserId())
            .append("routeId", getRouteId())
            .append("orderTime", getOrderTime())
            .append("travelDate", getTravelDate())
            .append("numPeople", getNumPeople())
            .append("totalPrice", getTotalPrice())
            .append("orderStatus", getOrderStatus())
            .append("contactName", getContactName())
            .append("contactPhone", getContactPhone())
            .append("remarks", getRemarks())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
