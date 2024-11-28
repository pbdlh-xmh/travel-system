# GitHub代码管理指南

## 1. 仓库设置

### 1.1 创建仓库
1. 登录GitHub,点击右上角"+"，选择"New repository"
2. 填写仓库信息:
   - Repository name: travel-system (建议使用这个名称)
   - Description: 基于RuoYi-Vue的旅游管理系统
   - Visibility: Private (建议私有仓库)
   - Initialize with:
     - ✓ Add a README file
     - ✓ Add .gitignore (选择Java模板)
     - ✓ Choose a license (选择MIT License)

### 1.2 分支策略
建议使用以下分支:
- `main`: 主分支,保存稳定代码
- `develop`: 开发分支,日常开发在此分支进行
- `feature/*`: 功能分支,如`feature/attraction-manage`
- `hotfix/*`: 紧急修复分支

## 2. 本地配置

### 2.1 安装Git
1. 下载Git: https://git-scm.com/downloads
2. 安装Git并配置环境变量

### 2.2 配置Git
```bash
# 配置用户名和邮箱
git config --global user.name "你的GitHub用户名"
git config --global user.email "你的GitHub邮箱"

# 生成SSH密钥
ssh-keygen -t rsa -C "你的GitHub邮箱"

# 添加SSH密钥到GitHub
# 1. 复制密钥内容(通常在 ~/.ssh/id_rsa.pub)
# 2. 在GitHub设置中添加SSH Key
```

## 3. 代码管理流程

### 3.1 克隆项目
```bash
# 克隆项目到本地
git clone git@github.com:你的用户名/travel-system.git

# 进入项目目录
cd travel-system
```

### 3.2 分支操作
```bash
# 查看所有分支
git branch -a

# 创建并切换到开发分支
git checkout -b develop

# 创建功能分支
git checkout -b feature/attraction-manage

# 切换分支
git checkout develop
```

### 3.3 日常开发流程
```bash
# 1. 更新代码
git pull origin develop

# 2. 创建功能分支
git checkout -b feature/your-feature

# 3. 提交代码
git add .
git commit -m "feat: 添加景点管理功能"
git push origin feature/your-feature

# 4. 合并到develop分支
git checkout develop
git merge feature/your-feature
git push origin develop
```

### 3.4 提交规范
提交信息格式:
```
<type>: <description>

[optional body]

[optional footer]
```

type类型:
- feat: 新功能
- fix: 修复bug
- docs: 文档更新
- style: 代码格式调整
- refactor: 重构代码
- test: 测试相关
- chore: 其他修改

示例:
```bash
git commit -m "feat: 添加景点管理CRUD功能"
git commit -m "fix: 修复景点列表分页问题"
git commit -m "docs: 更新README文档"
```

## 4. 版本发布

### 4.1 创建标签
```bash
# 创建标签
git tag -a v1.0.0 -m "第一个正式版本"

# 推送标签
git push origin v1.0.0
```

### 4.2 发布流程
1. 确保develop分支代码稳定
2. 合并develop到main分支
3. 在main分支创建版本标签
4. 推送到远程仓库

## 5. 注意事项

### 5.1 .gitignore配置
```
# IDE
.idea/
*.iml

# 编译输出
target/
dist/

# 依赖
node_modules/

# 日志
logs/
*.log

# 配置文件
application-dev.yml
application-prod.yml

# 其他
.DS_Store
```

### 5.2 安全注意事项
1. 不要提交敏感信息(密码、密钥等)
2. 敏感配置使用环境变量或配置文件
3. 定期更新依赖版本,修复安全漏洞

### 5.3 常见问题
1. 如遇到冲突:
   ```bash
   # 解决冲突后
   git add .
   git commit -m "fix: 解决冲突"
   ```

2. 如需回退版本:
   ```bash
   # 查看提交历史
   git log
   
   # 回退到指定版本
   git reset --hard commit_id
   ```

3. 如需暂存修改:
   ```bash
   # 暂存修改
   git stash
   
   # 恢复修改
   git stash pop
   ```



# 1. 查看当前状态（看看有哪些文件改动）
git status

# 2. 添加所有改动的文件到暂存区
git add .

# 3. 提交改动
git commit -m "feat: 初始化旅游管理系统"

# 4. 推送到GitHub
git push -u origin main