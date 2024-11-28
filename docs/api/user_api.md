# 用户模块API文档

## 1. 获取用户信息

### 1.1 基本信息
- **接口URL**: `/api/v1/users/info`
- **请求方式**: GET
- **接口说明**: 获取当前登录用户信息
- **权限要求**: 需要登录

### 1.2 响应结果
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        "userId": 1001,
        "username": "zhangsan",
        "email": "zhangsan@example.com",
        "phone": "13800138000",
        "gender": 1,                // 性别(0未知,1男,2女)
        "birthday": "1990-01-01",
        "avatarUrl": "/profile/upload/2024/11/28/avatar.jpg",
        "interestTags": "美食,旅游,文化",  // 兴趣标签(逗号分隔)
        "status": 1,               // 状态(1正常,0禁用)
        "lastLoginTime": "2024-11-28 16:52:36",
        "createTime": "2024-11-28 16:52:36"
    }
}
```

## 2. 更新用户信息

### 2.1 基本信息
- **接口URL**: `/api/v1/users/info`
- **请求方式**: PUT
- **接口说明**: 更新当前登录用户信息
- **权限要求**: 需要登录

### 2.2 请求参数
```json
{
    "email": "zhangsan@example.com",
    "phone": "13800138000",
    "gender": 1,
    "birthday": "1990-01-01",
    "avatarUrl": "/profile/upload/2024/11/28/avatar.jpg",
    "interestTags": "美食,旅游,文化"
}
```

### 2.3 响应结果
```json
{
    "code": 200,
    "msg": "更新成功"
}
```

## 3. 修改密码

### 3.1 基本信息
- **接口URL**: `/api/v1/users/password`
- **请求方式**: PUT
- **接口说明**: 修改当前登录用户密码
- **权限要求**: 需要登录

### 3.2 请求参数
```json
{
    "oldPassword": "string",    // 原密码
    "newPassword": "string"     // 新密码
}
```

### 3.3 响应结果
```json
{
    "code": 200,
    "msg": "修改成功"
}
```

## 4. 用户收藏列表

### 4.1 基本信息
- **接口URL**: `/api/v1/users/favorites`
- **请求方式**: GET
- **接口说明**: 获取当前用户的收藏列表
- **权限要求**: 需要登录

### 4.2 请求参数
#### Query参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| pageNum | number | 否 | 页码,默认1 | 1 |
| pageSize | number | 否 | 每页数量,默认10 | 10 |
| type | number | 否 | 类型(1线路,2景点) | 1 |

### 4.3 响应结果
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        "pageNum": 1,
        "pageSize": 10,
        "total": 100,
        "list": [{
            "favoriteId": 1,
            "userId": 1001,
            "itemId": 1,
            "itemType": 1,           // 1线路,2景点
            "createTime": "2024-11-28 16:52:36",
            "itemInfo": {            // 根据type返回不同的信息结构
                // type=1时返回线路信息
                "routeName": "北京三日游",
                "price": 1299.00,
                "imageUrl": "/profile/upload/2024/11/28/route.jpg"
                // type=2时返回景点信息
                // "name": "故宫",
                // "ticketPrice": 60.00,
                // "imageUrl": "/profile/upload/2024/11/28/spot.jpg"
            }
        }]
    }
}
```

## 5. 添加收藏

### 5.1 基本信息
- **接口URL**: `/api/v1/users/favorites`
- **请求方式**: POST
- **接口说明**: 添加收藏
- **权限要求**: 需要登录

### 5.2 请求参数
```json
{
    "itemId": 1,       // 收藏项ID
    "itemType": 1      // 类型(1线路,2景点)
}
```

### 5.3 响应结果
```json
{
    "code": 200,
    "msg": "收藏成功"
}
```

## 6. 取消收藏

### 6.1 基本信息
- **接口URL**: `/api/v1/users/favorites/{id}`
- **请求方式**: DELETE
- **接口说明**: 取消收藏
- **权限要求**: 需要登录

### 6.2 请求参数
#### Path参数
| 参数名 | 类型 | 必填 | 说明 | 示例 |
|--------|------|------|------|------|
| id | number | 是 | 收藏ID | 1 |

### 6.3 响应结果
```json
{
    "code": 200,
    "msg": "取消成功"
}
```

## 7. 错误码说明
| 错误码 | 说明 |
|--------|------|
| 200 | 成功 |
| 400 | 请求参数错误 |
| 401 | 未登录或token失效 |
| 403 | 无权限 |
| 404 | 资源不存在 |
| 500 | 服务器内部错误 |

## 8. 注意事项
1. 用户头像更新需要先调用文件上传接口
2. 兴趣标签最多支持5个,使用英文逗号分隔
3. 密码必须包含字母和数字,长度8-20位
4. 手机号和邮箱格式需符合规范
5. 用户状态由管理员维护,用户无法自行修改
6. 最后登录时间由系统自动更新
7. 同一用户对同一项目只能收藏一次