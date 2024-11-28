# 景点模块API文档

## 1. 获取景点列表

### 1.1 基本信息
- **接口URL**: `/api/v1/attractions`
- **请求方式**: GET
- **接口说明**: 获取景点列表,支持分页和筛选

### 1.2 请求参数
#### Query参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| pageNum | number | 否 | 页码,默认1 | 1 |
| pageSize | number | 否 | 每页数量,默认10 | 10 |
| keyword | string | 否 | 搜索关键词(匹配名称和描述) | 故宫 |
| location | string | 否 | 所在地筛选 | 北京 |
| tags | string | 否 | 标签筛选(多个用逗号分隔) | 文化,历史 |
| minPrice | number | 否 | 最低票价 | 100 |
| maxPrice | number | 否 | 最高票价 | 200 |
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
            "attractionId": 1,
            "name": "故宫博物院",
            "location": "北京市东城区",
            "description": "故宫博物院是中国明清两代的皇家宫殿...",
            "openTime": "08:30-17:00",
            "ticketPrice": 60.00,
            "imageUrl": "/profile/upload/2024/11/28/gugong.jpg",
            "images": [
                "/profile/upload/2024/11/28/gugong1.jpg",
                "/profile/upload/2024/11/28/gugong2.jpg"
            ],
            "tags": "文化,历史,建筑",
            "viewCount": 1000,
            "status": 1,
            "createTime": "2024-11-28 16:52:36"
        }]
    }
}
```

## 2. 获取景点详情

### 2.1 基本信息
- **接口URL**: `/api/v1/attractions/{id}`
- **请求方式**: GET
- **接口说明**: 获取指定景点的详细信息

### 2.2 请求参数
#### Path参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| id | number | 是 | 景点ID | 1 |

### 2.3 响应结果
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        "attractionId": 1,
        "name": "故宫博物院",
        "location": "北京市东城区景山前街4号",
        "description": "故宫博物院是中国明清两代的皇家宫殿...",
        "openTime": "08:30-17:00",
        "ticketPrice": 60.00,
        "imageUrl": "/profile/upload/2024/11/28/gugong.jpg",
        "images": [
            "/profile/upload/2024/11/28/gugong1.jpg",
            "/profile/upload/2024/11/28/gugong2.jpg"
        ],
        "tags": "文化,历史,建筑",
        "viewCount": 1000,
        "status": 1,
        "createTime": "2024-11-28 16:52:36",
        "updateTime": "2024-11-28 16:52:36"
    }
}
```

## 3. 新增景点

### 3.1 基本信息
- **接口URL**: `/api/v1/attractions`
- **请求方式**: POST
- **接口说明**: 新增景点信息
- **权限要求**: 需要管理员权限

### 3.2 请求参数
```json
{
    "name": "故宫博物院",
    "location": "北京市东城区景山前街4号",
    "description": "故宫博物院是中国明清两代的皇家宫殿...",
    "openTime": "08:30-17:00",
    "ticketPrice": 60.00,
    "imageUrl": "/profile/upload/2024/11/28/gugong.jpg",
    "images": [
        "/profile/upload/2024/11/28/gugong1.jpg",
        "/profile/upload/2024/11/28/gugong2.jpg"
    ],
    "tags": "文化,历史,建筑"
}
```

### 3.3 响应结果
```json
{
    "code": 200,
    "msg": "添加成功",
    "data": {
        "attractionId": 1
    }
}
```

## 4. 更新景点

### 4.1 基本信息
- **接口URL**: `/api/v1/attractions/{id}`
- **请求方式**: PUT
- **接口说明**: 更新景点信息
- **权限要求**: 需要管理员权限

### 4.2 请求参数
#### Path参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| id | number | 是 | 景点ID | 1 |

#### Body参数
```json
{
    "name": "故宫博物院",
    "location": "北京市东城区景山前街4号",
    "description": "故宫博物院是中国明清两代的皇家宫殿...",
    "openTime": "08:30-17:00",
    "ticketPrice": 60.00,
    "imageUrl": "/profile/upload/2024/11/28/gugong.jpg",
    "images": [
        "/profile/upload/2024/11/28/gugong1.jpg",
        "/profile/upload/2024/11/28/gugong2.jpg"
    ],
    "tags": "文化,历史,建筑",
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

## 5. 更新景点状态

### 5.1 基本信息
- **接口URL**: `/api/v1/attractions/{id}/status`
- **请求方式**: PUT
- **接口说明**: 更新景点状态(上架/下架)
- **权限要求**: 需要管理员权限

### 5.2 请求参数
#### Path参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| id | number | 是 | 景点ID | 1 |

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
| 404 | 景点不存在 |
| 500 | 服务器内部错误 |

## 7. 注意事项
1. 新增和更新接口的图片URL需要先调用文件上传接口获取
2. 景点标签使用英文逗号分隔
3. 浏览量字段由系统自动维护
4. 创建时间和更新时间由数据库自动维护
5. 价格字段精确到分
6. 图片数组最多支持10张图片