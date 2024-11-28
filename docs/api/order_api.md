# 订单模块API文档

## 1. 创建订单

### 1.1 基本信息
- **接口URL**: `/api/v1/orders`
- **请求方式**: POST
- **接口说明**: 创建新的旅游线路订单
- **权限要求**: 需要登录

### 1.2 请求参数
```json
{
    "routeId": 1,                    // 线路ID(关联tour_route表)
    "travelDate": "2024-12-25",      // 出行日期
    "numPeople": 2,                  // 出行人数
    "totalPrice": 2598.00,           // 总价(根据线路价格×人数计算)
    "contactName": "张三",           // 联系人姓名
    "contactPhone": "13800138000",   // 联系人电话
    "remarks": "需要安排导游"        // 备注信息(可选)
}
```

### 1.3 响应结果
```json
{
    "code": 200,
    "msg": "下单成功",
    "data": {
        "orderId": 1,
        "totalPrice": 2598.00,
        "orderStatus": 0             // 订单状态（0待支付，1已支付，2已取消）
    }
}
```

## 2. 获取订单列表

### 2.1 基本信息
- **接口URL**: `/api/v1/orders`
- **请求方式**: GET
- **接口说明**: 获取当前用户的订单列表
- **权限要求**: 需要登录

### 2.2 请求参数
#### Query参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| pageNum | number | 否 | 页码,默认1 | 1 |
| pageSize | number | 否 | 每页数量,默认10 | 10 |
| orderStatus | number | 否 | 订单状态(0待支付,1已支付,2已取消) | 1 |
| startDate | string | 否 | 开始日期 | 2024-11-01 |
| endDate | string | 否 | 结束日期 | 2024-11-30 |

### 2.3 响应结果
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        "pageNum": 1,
        "pageSize": 10,
        "total": 100,
        "list": [{
            "orderId": 1,
            "userId": 1001,           // 用户ID
            "routeId": 1,            // 线路ID
            "routeName": "北京精华三日游", // 关联tour_route表的route_name
            "travelDate": "2024-12-25",
            "numPeople": 2,
            "totalPrice": 2598.00,
            "orderStatus": 0,
            "contactName": "张三",
            "contactPhone": "13800138000",
            "remarks": "需要安排导游",
            "createTime": "2024-11-28 16:52:36",
            "updateTime": "2024-11-28 16:52:36"
        }]
    }
}
```

## 3. 获取订单详情

### 3.1 基本信息
- **接口URL**: `/api/v1/orders/{id}`
- **请求方式**: GET
- **接口说明**: 获取指定订单的详细信息
- **权限要求**: 需要登录且是订单所有者

### 3.2 请求参数
#### Path参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| id | number | 是 | 订单ID | 1 |

### 3.3 响应结果
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        "orderId": 1,
        "userId": 1001,
        "routeId": 1,
        "routeInfo": {               // 关联tour_route表信息
            "routeName": "北京精华三日游",
            "price": 1299.00,
            "duration": 3,
            "departurePlace": "北京",
            "destination": "北京",
            "imageUrl": "/profile/upload/2024/11/28/beijing3days.jpg",
            "description": "游览故宫、长城、天坛等北京精华景点"
        },
        "travelDate": "2024-12-25",
        "numPeople": 2,
        "totalPrice": 2598.00,
        "orderStatus": 0,
        "contactName": "张三",
        "contactPhone": "13800138000",
        "remarks": "需要安排导游",
        "createTime": "2024-11-28 16:52:36",
        "updateTime": "2024-11-28 16:52:36"
    }
}
```

## 4. 更新订单状态

### 4.1 基本信息
- **接口URL**: `/api/v1/orders/{id}/status`
- **请求方式**: PUT
- **接口说明**: 更新订单状态(支付或取消)
- **权限要求**: 需要登录且是订单所有者

### 4.2 请求参数
#### Path参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| id | number | 是 | 订单ID | 1 |

#### Body参数
```json
{
    "orderStatus": 1,           // 订单状态(1已支付,2已取消)
    "remarks": "行程有变"      // 备注信息(可选)
}
```

### 4.3 响应结果
```json
{
    "code": 200,
    "msg": "更新成功"
}
```

## 5. 错误码说明
| 错误码 | 说明 |
|--------|------|
| 200 | 成功 |
| 400 | 请求参数错误 |
| 401 | 未登录或token失效 |
| 403 | 无权限操作此订单 |
| 404 | 订单不存在 |
| 409 | 订单状态冲突 |
| 500 | 服务器内部错误 |

## 6. 注意事项
1. 订单创建时会自动关联当前登录用户的user_id
2. 订单总价必须与线路单价×人数相符
3. 订单状态更新时会自动更新update_time
4. 订单删除时会保留记录,仅更改状态
5. 所有金额字段精确到分
6. 电话号码和联系人信息需要进行加密存储