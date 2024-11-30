# 客户端后端开发设计文档 (补充版)

## 1. 模块结构 (补充)
```
ruoyi-client/
├── src/main/java/com/ruoyi/client
│   ├── controller/             
│   │   ├── AuthController.java    # 认证相关接口
│   │   └── BaseController.java    # 基础控制器(错误码、响应封装)
│   ├── service/               
│   │   ├── IAuthService.java
│   │   └── impl/
│   │       └── AuthServiceImpl.java
│   ├── domain/                
│   │   ├── LoginUser.java    
│   │   ├── vo/               # 视图对象
│   │   │   ├── LoginVO.java
│   │   │   └── UserInfoVO.java
│   │   └── dto/              
│   │       ├── LoginDTO.java
│   │       └── RegisterDTO.java
│   ├── common/               # 新增：公共组件
│   │   ├── constant/         # 常量定义
│   │   ├── enums/           # 枚举定义
│   │   └── utils/           # 工具类
│   └── config/              
│       ├── SecurityConfig.java
│       └── RedisConfig.java  # 新增：Redis配置
```

## 2. 接口设计 (补充)
### 2.1 登录接口
- 响应状态码说明:
```json
{
    "200": "操作成功",
    "401": "未授权",
    "500": "系统错误",
    "1001": "用户名或密码错误",
    "1002": "验证码错误",
    "1003": "账号已被锁定"
}
```

### 2.4 退出登录接口 (新增)
- 路径: `/client/auth/logout`
- 方法: POST
- 请求头: Client-Token

### 2.5 修改密码接口 (新增)
- 路径: `/client/auth/updatePwd`
- 方法: PUT
- 请求头: Client-Token
- 请求参数:
```json
{
    "oldPassword": "string",
    "newPassword": "string"
}
```

## 3. 安全设计 (补充)
### 3.4 登录安全
- 密码错误次数限制: 5次/小时
- 同一IP注册频率限制: 3次/天
- 验证码有效期: 2分钟

### 3.5 会话管理
- 单用户多设备登录控制
- Token 自动续期机制
- 异常登录检测

## 5. 缓存设计 (补充)
### 5.2 缓存过期策略
```
# Token缓存
client:token:${userId} -> 30分钟
# 验证码缓存
client:captcha:${uuid} -> 2分钟
# 用户信息缓存
client:user:${userId} -> 12小时
# 密码错误次数
client:pwd:err:${username} -> 1小时
```

## 9. 监控设计 (新增)
### 9.1 性能监控
- 接口响应时间监控
- 并发用户数监控
- Redis连接池监控

### 9.2 安全监控
- 异常登录监控
- 密码错误次数监控
- 接口调用频率监控

## 10. 测试规范 (新增)
### 10.1 单元测试
- Service层测试
- Controller层测试
- 工具类测试

### 10.2 接口测试
```java
@Test
void testLogin() {
    LoginDTO loginDTO = new LoginDTO();
    loginDTO.setUsername("test");
    loginDTO.setPassword("test123");
    // 测试用例
}
```

## 11. 部署说明 (新增)
### 11.1 环境要求
- JDK 17
- Redis 6.0+
- MySQL 8.0+

### 11.2 配置说明
```yaml
# application-client.yml
client:
  # Token配置
  token:
    header: Client-Token
    secret: abcdefghijklmnopqrstuvwxyz
    expireTime: 30
  # 验证码配置
  captcha:
    enabled: true
    type: math
    expireTime: 2
  # 密码配置
  password:
    maxRetryCount: 5
    lockTime: 1
```