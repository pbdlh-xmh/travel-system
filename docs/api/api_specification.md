# API 接口规范说明文档

## 1. 通用规范

### 1.1 基础说明
- 基础路径: `/api/v1`
- 请求方式: REST风格
- 数据格式: JSON
- 字符编码: UTF-8

### 1.2 请求头规范
```
Content-Type: application/json
Authorization: Bearer {token}  // 需要认证的接口必须携带
```

### 1.3 响应格式
```json
{
    "code": 200,           // 状态码
    "msg": "success",      // 状态描述
    "data": {              // 响应数据
        // 具体数据
    }
}
```

### 1.4 分页参数
```json
{
    "pageNum": 1,         // 页码,从1开始
    "pageSize": 10,       // 每页数量
    "total": 100,         // 总数量
    "list": []           // 数据列表
}
```

### 1.5 状态码说明
| 状态码 | 说明 |
|--------|------|
| 200 | 成功 |
| 400 | 请求参数错误 |
| 401 | 未登录或token失效 |
| 403 | 无权限 |
| 404 | 资源不存在 |
| 500 | 服务器内部错误 |

## 2. 用户认证

### 2.1 用户注册
- **接口**: `/auth/register`
- **方法**: POST
- **参数**:
```json
{
    "username": "string",     // 用户名
    "password": "string",     // 密码
    "email": "string",        // 邮箱
    "phone": "string",        // 手机号(可选)
    "gender": "number",       // 性别(0未知,1男,2女)
    "birthday": "date",       // 生日(可选): YYYY-MM-DD
    "avatarUrl": "string",    // 头像URL(可选)
    "interestTags": "string", // 兴趣标签,逗号分隔(可选)
    "status": 1              // 状态(1正常,0禁用)
}
```
- **响应**:
```json
{
    "code": 200,
    "msg": "注册成功",
    "data": {
        "userId": "number",
        "username": "string",
        "token": "string"     // JWT token
    }
}
```

### 2.2 用户登录
- **接口**: `/auth/login`
- **方法**: POST
- **参数**:
```json
{
    "username": "string",     // 用户名
    "password": "string"      // 密码
}
```
- **响应**:
```json
{
    "code": 200,
    "msg": "登录成功",
    "data": {
        "userId": "number",
        "username": "string",
        "token": "string",    // JWT token
        "lastLoginTime": "datetime"
    }
}
```

## 3. 景点相关

### 3.1 景点列表
- **接口**: `/attractions`
- **方法**: GET
- **参数**:
```json
{
    "pageNum": "number",      // 页码(可选),默认1
    "pageSize": "number",     // 每页数量(可选),默认10
    "keyword": "string",      // 搜索关键词(可选)
    "location": "string",     // 所在地(可选)
    "tags": "string",         // 标签筛选,逗号分隔(可选)
    "minPrice": "number",     // 最低票价(可选)
    "maxPrice": "number",     // 最高票价(可选)
    "status": "number"        // 状态(1正常,0关闭)
}
```
- **响应**:
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        "pageNum": 1,
        "pageSize": 10,
        "total": 100,
        "list": [{
            "attractionId": "number",
            "name": "string",
            "location": "string",
            "description": "string",
            "openTime": "string",
            "ticketPrice": "number",
            "imageUrl": "string",
            "images": "string",        // 逗号分隔的图片URL
            "tags": "string",          // 逗号分隔的标签
            "viewCount": "number",
            "status": "number",
            "createTime": "datetime",
            "updateTime": "datetime"
        }]
    }
}
```

### 3.2 景点详情
- **接口**: `/attractions/{id}`
- **方法**: GET
- **响应**:
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        // 字段同上
    }
}
```

## 4. 旅游线路相关

### 4.1 线路列表
- **接口**: `/routes`
- **方法**: GET
- **参数**: 
```json
{
    "pageNum": "number",      // 页码(可选),默认1
    "pageSize": "number",     // 每页数量(可选),默认10
    "keyword": "string",      // 搜索关键词(可选)
    "departurePlace": "string", // 出发地(可选)
    "destination": "string",  // 目的地(可选)
    "minPrice": "number",     // 最低价格(可选)
    "maxPrice": "number",     // 最高价格(可选)
    "duration": "number",     // 行程天数(可选)
    "status": "number"        // 状态(1正常,0关闭)
}
```
- **响应**:
```json
{
    "code": 200,
    "msg": "success",
    "data": {
        "pageNum": 1,
        "pageSize": 10,
        "total": 100,
        "list": [{
            "routeId": "number",
            "routeName": "string",
            "price": "number",
            "description": "string",
            "duration": "number",
            "departurePlace": "string",
            "destination": "string",
            "imageUrl": "string",
            "images": "string",        // 逗号分隔的图片URL
            "tags": "string",          // 逗号分隔的标签
            "viewCount": "number",
            "bookingsCount": "number",
            "minPrice": "number",
            "maxPrice": "number",
            "inventory": "number",
            "status": "number",
            "createTime": "datetime",
            "updateTime": "datetime"
        }]
    }
}
```

## 5. 订单相关

### 5.1 创建订单
- **接口**: `/orders`
- **方法**: POST
- **参数**:
```json
{
    "routeId": "number",      // 线路ID
    "travelDate": "date",     // 出行日期
    "numPeople": "number",    // 出行人数
    "totalPrice": "number",   // 总价
    "contactName": "string",  // 联系人
    "contactPhone": "string", // 联系电话
    "remarks": "string"       // 备注(可选)
}
```
- **响应**:
```json
{
    "code": 200,
    "msg": "下单成功",
    "data": {
        "orderId": "number",
        "totalPrice": "number",
        "orderStatus": "number"    // 订单状态
    }
}
```

## 6. 文件上传

### 6.1 上传图片
- **接口**: `/upload/image`
- **方法**: POST
- **请求头**:
```
Content-Type: multipart/form-data
```
- **参数**:
```
file: 图片文件
type: 用途类型(avatar-头像,attraction-景点图片,route-线路图片)
```
- **响应**:
```json
{
    "code": 200,
    "msg": "上传成功",
    "data": {
        "url": "string"      // 图片访问路径
    }
}
```

## 7. 注意事项

1. 所有需要认证的接口必须在请求头中携带token
2. 涉及金额的字段单位均为元,精确到分
3. 时间格式统一使用ISO 8601标准
4. 分页接口若不传分页参数则使用默认值
5. 文件上传大小限制为5MB
6. 图片格式支持jpg、jpeg、png、gif
7. 所有列表数据默认按创建时间倒序排序
8. 图片URL和标签字段统一使用逗号分隔的字符串