# 旅游线路API文档

## 1. 获取线路列表

### 1.1 基本信息
- **接口URL**: `/api/v1/routes`
- **请求方式**: GET
- **接口说明**: 获取旅游线路列表,支持分页和筛选

### 1.2 请求参数
#### Query参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| pageNum | number | 否 | 页码,默认1 | 1 |
| pageSize | number | 否 | 每页数量,默认10 | 10 |
| keyword | string | 否 | 搜索关键词(匹配名称和描述) | 北京三日游 |
| departurePlace | string | 否 | 出发地筛选 | 北京 |
| destination | string | 否 | 目的地筛选 | 上海 |
| duration | number | 否 | 行程天数 | 3 |
| minPrice | number | 否 | 最低价格 | 1000 |
| maxPrice | number | 否 | 最高价格 | 3000 |
| status | number | 否 | 状态(1正常,0关闭) | 1 |

### 1.3 响应结果
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        "pageNum": 1,
        "pageSize": 10,
        "total": 100,
        "list": [{
            "routeId": 1,
            "routeName": "北京精华三日游",
            "price": 1299.00,
            "description": "游览故宫、长城、天坛等北京精华景点",
            "duration": 3,
            "departurePlace": "北京",
            "destination": "北京",
            "imageUrl": "/profile/upload/2024/11/28/beijing3days.jpg",
            "images": "/profile/upload/2024/11/28/beijing3days1.jpg,/profile/upload/2024/11/28/beijing3days2.jpg",
            "tags": "文化,美食,精品",
            "viewCount": 500,
            "bookingsCount": 100,
            "favoriteCount": 50,
            "inventory": 30,
            "minPrice": 1299.00,
            "maxPrice": 1599.00,
            "status": 1,
            "createTime": "2024-11-28 16:52:36"
        }]
    }
}
```

## 2. 获取线路详情

### 2.1 基本信息
- **接口URL**: `/api/v1/routes/{id}`
- **请求方式**: GET
- **接口说明**: 获取指定线路的详细信息

### 2.2 请求参数
#### Path参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| id | number | 是 | 线路ID | 1 |

### 2.3 响应结果
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        "routeId": 1,
        "routeName": "北京精华三日游",
        "price": 1299.00,
        "description": "游览故宫、长城、天坛等北京精华景点",
        "duration": 3,
        "departurePlace": "北京",
        "destination": "北京",
        "imageUrl": "/profile/upload/2024/11/28/beijing3days.jpg",
        "images": "/profile/upload/2024/11/28/beijing3days1.jpg,/profile/upload/2024/11/28/beijing3days2.jpg",
        "tags": "文化,美食,精品",
        "viewCount": 500,
        "bookingsCount": 100,
        "favoriteCount": 50,
        "salesCount": 200,
        "inventory": 30,
        "minPrice": 1299.00,
        "maxPrice": 1599.00,
        "status": 1,
        "createTime": "2024-11-28 16:52:36",
        "updateTime": "2024-11-28 16:52:36"
    }
}
```

## 3. 新增线路

### 3.1 基本信息
- **接口URL**: `/api/v1/routes`
- **请求方式**: POST
- **接口说明**: 新增旅游线路
- **权限要求**: 需要管理员权限

### 3.2 请求参数
```json
{
    "routeName": "北京精华三日游",
    "price": 1299.00,
    "description": "游览故宫、长城、天坛等北京精华景点",
    "duration": 3,
    "departurePlace": "北京",
    "destination": "北京",
    "imageUrl": "/profile/upload/2024/11/28/beijing3days.jpg",
    "images": "/profile/upload/2024/11/28/beijing3days1.jpg,/profile/upload/2024/11/28/beijing3days2.jpg",
    "tags": "文化,美食,精品",
    "inventory": 30,
    "minPrice": 1299.00,
    "maxPrice": 1599.00
}
```

### 3.3 响应结果
```json
{
    "code": 200,
    "msg": "添加成功",
    "data": {
        "routeId": 1
    }
}
```

## 4. 更新线路

### 4.1 基本信息
- **接口URL**: `/api/v1/routes/{id}`
- **请求方式**: PUT
- **接口说明**: 更新线路信息
- **权限要求**: 需要管理员权限

### 4.2 请求参数
#### Path参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| id | number | 是 | 线路ID | 1 |

#### Body参数
```json
{
    "routeName": "北京精华三日游",
    "price": 1299.00,
    "description": "游览故宫、长城、天坛等北京精华景点",
    "duration": 3,
    "departurePlace": "北京",
    "destination": "北京",
    "imageUrl": "/profile/upload/2024/11/28/beijing3days.jpg",
    "images": "/profile/upload/2024/11/28/beijing3days1.jpg,/profile/upload/2024/11/28/beijing3days2.jpg",
    "tags": "文化,美食,精品",
    "inventory": 30,
    "minPrice": 1299.00,
    "maxPrice": 1599.00,
    "status": 1
}
```

### 4.3 响应结果
```json
{
    "code": 200,
    "msg": "更新成功"
}
```

## 5. 更新线路状态

### 5.1 基本信息
- **接口URL**: `/api/v1/routes/{id}/status`
- **请求方式**: PUT
- **接口说明**: 更新线路状态(上架/下架)
- **权限要求**: 需要管理员权限

### 5.2 请求参数
#### Path参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| id | number | 是 | 线路ID | 1 |

#### Body参数
```json
{
    "status": 1    // 状态(1正常,0关闭)
}
```

### 5.3 响应结果
```json
{
    "code": 200,
    "msg": "更新成功"
}
```

## 6. 错误码说明
| 错误码 | 说明 |
|--------|------|
| 200 | 成功 |
| 400 | 请求参数错误 |
| 401 | 未登录或token失效 |
| 403 | 无权限 |
| 404 | 线路不存在 |
| 500 | 服务器内部错误 |

## 7. 注意事项
1. 新增和更新接口的图片URL需要先调用文件上传接口获取
2. 线路标签使用英文逗号分隔
3. 浏览量、收藏数、预订数等统计字段由系统自动维护
4. 创建时间和更新时间由数据库自动维护
5. 价格字段精确到分
6. 图片数组最多支持10张图片
7. 库存字段不能小于0