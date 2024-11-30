## 开发

```bash
# 克隆项目
git clone https://gitee.com/y_project/RuoYi-Vue

# 进入项目目录
cd ruoyi-ui

# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装依赖，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npmmirror.com

# 启动服务
npm run dev
```

浏览器访问 http://localhost:80

## 发布

```bash
# 构建测试环境
npm run build:stage

# 构建生产环境
npm run build:prod
```






更清晰的架构：
保持原有后台管理系统完全不变，包括：
登录路径保持 /login
所有后台相关的 API 路径保持原样
后台的 store/router/permission 等配置保持不变
创建完全独立的客户端模块：
src/
├── views/
│   ├── client/           # 客户端相关页面
│   │   ├── login/       # 客户端登录页
│   │   ├── register/    # 客户端注册页
│   │   └── home/        # 客户端首页
│   └── ...              # 原有的后台页面不变
├── api/
│   ├── client/          # 客户端API
│   │   └── auth.js      # 客户端认证API
│   └── ...              # 原有的后台API不变
├── store/
│   ├── modules/
│   │   └── client.js    # 客户端状态管理
│   └── ...              # 原有的后台store不变
└── router/
    ├── client.js        # 客户端路由配置
    └── index.js         # 原有的后台路由不变



后台管理系统 (http://localhost:80)
使用原有的路由配置 (router/index.js)
使用原有的权限控制 (permission.js)
显示管理员登录界面
客户端系统 (http://localhost:8081)
使用独立的路由配置 (router/client.js)
使用独立的权限控制 (permission/client.js)
显示客户端登录界面