# 本地开发环境部署指南

## 1. 项目说明
本项目基于RuoYi-Vue进行二次开发，主要实现旅游管理系统的相关功能。

## 2. 环境准备
已有RuoYi-Vue基础环境：
- JDK 1.8
- MySQL 8.0
- Redis
- Node.js
- RuoYi-Vue框架

## 3. 数据库配置

### 3.1 导入数据库
1. 在已有的RuoYi-Vue数据库中执行项目提供的SQL文件：
```sql
-- 执行顺序
1. init.sql        -- 创建业务相关表
2. init_data.sql   -- 插入初始数据
```

### 3.2 修改数据库配置
如果您的RuoYi-Vue数据库配置已经正确，无需修改。如需修改：
1. 打开 `ruoyi-admin/src/main/resources/application-druid.yml`
2. 修改数据库连接信息：
```yaml
url: jdbc:mysql://localhost:3306/ry-vue?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
username: root
password: 123456
```

## 4. 后端服务配置

### 4.1 添加业务模块
1. 在已有RuoYi-Vue项目中添加新的业务模块：
   - 景点管理模块
   - 线路管理模块
   - 订单管理模块
   - 用户管理模块扩展

### 4.2 启动后端服务
1. 使用IDEA打开ruoyi-vue项目
2. 运行 `RuoYiApplication.java`
3. 默认启动端口: 8080

## 5. 前端项目配置

### 5.1 添加前端页面
1. 在RuoYi-Vue前端项目中添加新的页面和组件：
```bash
ruoyi-ui/src/views/travel/  # 新增旅游相关页面
├── attraction/    # 景点管理
├── route/         # 线路管理
├── order/         # 订单管理
└── user/          # 用户管理扩展
```

### 5.2 启动前端服务
1. 进入前端项目目录
```bash
cd ruoyi-ui
```

2. 启动服务
```bash
npm run dev
```

3. 访问地址：http://localhost:80

## 6. 开发说明

### 6.1 目录结构
```
ruoyi-travel/                    # 新增旅游业务模块
├── domain/                      # 实体类
├── mapper/                      # 数据访问层
├── service/                     # 业务逻辑层
└── controller/                  # 控制层
```

### 6.2 权限配置
1. 在菜单管理中添加新模块的菜单
2. 配置相应的权限标识
3. 分配角色权限

## 7. 注意事项

### 7.1 开发规范
- 遵循RuoYi-Vue框架的开发规范
- 参考项目提供的`coding_standards.md`文档
- 使用统一的异常处理机制
- 遵循统一的接口格式

### 7.2 常见问题
1. 如遇到页面访问404
   - 检查菜单配置是否正确
   - 检查权限是否已分配

2. 如遇到接口调用失败
   - 检查请求地址是否正确
   - 检查权限标识是否正确
   - 检查数据库连接是否正常

3. 如遇到页面显示异常
   - 清除浏览器缓存
   - 重新执行npm install
   - 检查Node.js版本是否兼容