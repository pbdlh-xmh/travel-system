# 客户端模块开发文档

## 1. 项目结构
```
src/
├── views/client/          # 客户端页面
│   ├── login/            # 登录页面
│   ├── register/         # 注册页面
│   └── home/             # 首页
├── api/client/           # 客户端API
│   └── auth.js           # 认证相关API
├── store/modules/        
│   └── client.js         # 客户端状态管理
├── router/
│   └── client.js         # 客户端路由配置
└── utils/
    ├── clientRequest.js  # 客户端请求工具
    └── clientAuth.js     # 客户端认证工具
```

## 2. 技术栈
- Vue 2.x
- Vue Router
- Vuex
- Element UI
- Axios

## 3. 功能模块
### 3.1 用户认证
- 登录
- 注册
- 登出
- Token 管理

### 3.2 API 请求
- 基础请求封装
- 请求拦截器
- 响应拦截器
- 错误处理

### 3.3 状态管理
- 用户信息
- 登录状态
- 权限控制

## 4. 开发规范
### 4.1 命名规范
- 文件名：kebab-case (如: client-login.vue)
- 组件名：PascalCase (如: ClientLogin)
- 变量名：camelCase (如: userInfo)

### 4.2 目录规范
- 所有客户端相关代码以 client 为前缀或放在 client 目录下
- 保持与原有后台管理系统代码分离

### 4.3 注释规范
- 组件必须包含功能说明注释
- API 方法必须包含参数和返回值说明
- 复杂逻辑必须包含流程说明

## 5. 开发流程
1. 创建基础目录结构
2. 实现登录页面和路由
3. 添加认证相关 API
4. 实现状态管理
5. 完善其他功能页面

## 6. 注意事项
1. 客户端模块与后台管理系统完全分离
2. 使用独立的 Token 存储机制
3. 避免影响原有后台功能
4. 保持代码风格统一 

是的，现在我明白了之前的问题：
路由混淆：我们直接修改了原有的路由和权限配置，导致后台管理系统的登录受到影响
Token 冲突：使用了相同的 Token 存储机制，导致客户端和后台的登录状态互相影响
请求拦截器冲突：使用了同一个 axios 实例，导致请求头和拦截器逻辑混在一起
正确的做法应该是：
1. 路由完全分离：
后台保持原有的 /login 路径
客户端使用 /client/login 路径
分别使用不同的路由守卫
Token 分离：
后台继续使用 Admin-Token
客户端使用 Client-Token
分别使用不同的存储和处理方法
请求实例分离：
后台继续使用原有的 request.js
客户端使用新的 clientRequest.js
分别使用不同的拦截器逻辑


明白，我们会严格遵循以下原则进行开发：
代码隔离原则：
所有客户端代码都放在独立目录
使用 client 前缀命名
不修改任何原有后台代码
配置隔离原则：
状态隔离原则：


开发顺序：
创建基础目录结构
2. 实现登录页面和路由
添加认证相关 API
实现状态管理
5. 完善其他功能页面
关键隔离点：
路由：使用 /client/* 路径
Token：使用 Client-Token
请求：使用独立的 clientRequest.js
状态：使用独立的 store module
命名规范：
文件名：kebab-case
组件名：PascalCase
变量名：camelCase