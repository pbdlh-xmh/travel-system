# 编码规范文档

## 1. 通用规范

### 1.1 命名规范
- **项目命名**: 全小写，多个单词用中划线分隔，如 `travel-system`
- **包名**: 全小写，简单明确，如 `com.ruoyi.travel`
- **类名**: 大驼峰命名，如 `UserController`
- **方法名**: 小驼峰命名，如 `getUserInfo`
- **变量名**: 小驼峰命名，如 `userId`
- **常量名**: 全大写，下划线分隔，如 `MAX_COUNT`
- **数据库表名**: 全小写，下划线分隔，如 `user_info`
- **数据库字段名**: 全小写，下划线分隔，如 `create_time`

### 1.2 注释规范
- **类注释**: 必须包含作者（徐铭昊）、日期（当天）、描述
```java
/**
 * 用户管理Controller
 * 
 * @author 徐铭昊
 * @date 2024-11-28
 */
```
- **方法注释**: 必须说明功能、参数、返回值
```java
/**
 * 获取用户信息
 * 
 * @param userId 用户ID
 * @return 用户信息
 */
```
- **变量注释**: 关键变量必须添加注释说明用途
```java
// 用户最大收藏数量
private static final int MAX_FAVORITE_COUNT = 100;
```

### 1.3 代码格式
- 使用4个空格缩进
- 大括号单独占一行
- 运算符两侧必须有空格
- 每行代码不超过120个字符
- 方法之间空一行
- 逻辑相关的代码块之间空一行

## 2. Java编码规范

### 2.1 异常处理
- 必须使用统一的异常处理机制
- 自定义异常必须继承BaseException
- 禁止直接抛出RuntimeException
- 必须记录详细的异常堆栈信息
```java
try {
    // 业务代码
} catch (Exception e) {
    log.error("操作失败", e);
    throw new ServiceException("操作失败");
}
```

### 2.2 日志规范
- 使用SLF4J + Logback框架
- 必须分级别打印日志(ERROR/WARN/INFO/DEBUG)
- 异常必须记录完整堆栈
- 敏感信息必须脱敏处理
```java
// 正确示例
log.info("用户{}登录成功", username);
log.error("用户{}操作失败", username, e);

// 错误示例
log.info("用户" + username + "登录成功");  // 禁止字符串拼接
```

### 2.3 Controller层规范
- 统一使用 @RestController 注解
- 请求映射路径使用小写字母
- 必须进行参数校验
- 统一返回值格式
```java
@RestController
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/info/{userId}")
    public AjaxResult getInfo(@PathVariable Long userId) {
        // 参数校验
        if (userId == null) {
            return AjaxResult.error("用户ID不能为空");
        }
        // 业务处理
        return AjaxResult.success(userService.getInfo(userId));
    }
}
```

### 2.4 Service层规范
- 方法名必须见名知意
- 必须添加事务注解
- 核心业务必须打印日志
```java
@Service
public class UserServiceImpl implements UserService {
    
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateUser(User user) {
        log.info("开始更新用户信息: {}", user.getUserId());
        // 业务处理
        log.info("用户信息更新成功: {}", user.getUserId());
    }
}
```

### 2.5 DAO层规范
- Mapper接口必须添加@Mapper注解
- SQL语句必须写注释
- 禁止使用select *
- 必须添加分页查询
```java
@Mapper
public interface UserMapper {
    
    /**
     * 根据ID查询用户
     */
    @Select("select user_id, username, email from user where user_id = #{userId}")
    User selectById(Long userId);
}
```

## 3. 前端编码规范

### 3.1 Vue组件规范
- 组件名使用大驼峰命名
- Props必须指定类型和默认值
- 必须添加注释说明组件用途
```vue
<template>
  <div class="user-info">
    <!-- 用户信息展示 -->
  </div>
</template>

<script>
export default {
  name: 'UserInfo',
  props: {
    userId: {
      type: Number,
      required: true
    }
  }
}
</script>
```

### 3.2 CSS规范
- 使用class而不是id
- 类名使用中划线命名
- 必须添加注释说明样式用途
```css
/* 用户信息卡片 */
.user-card {
  margin: 10px;
  padding: 15px;
}

/* 用户头像 */
.user-avatar {
  width: 50px;
  height: 50px;
}
```

## 4. 数据库规范

### 4.1 表设计规范
- 必须包含主键，推荐使用自增ID
- 必须包含创建时间和更新时间
- 必须指定默认值
- 必须添加注释
```sql
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(30) NOT NULL COMMENT '用户名',
  `status` tinyint DEFAULT '1' COMMENT '状态(1正常,0禁用)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) COMMENT='用户表';
```

### 4.2 索引规范
- 主键索引命名: `pk_表名`
- 唯一索引命名: `uk_表名_字段名`
- 普通索引命名: `idx_表名_字段名`
- 联合索引最左原则
```sql
ALTER TABLE `user` ADD INDEX `idx_user_username` (`username`);
```

## 5. 安全规范

### 5.1 接口安全
- 必须进行参数校验
- 必须防止SQL注入
- 必须防止XSS攻击
- 敏感数据必须加密
- 必须有访问权限控制

### 5.2 数据安全
- 密码必须加密存储
- 敏感信息必须脱敏展示
- 用户隐私信息必须加密
- 重要操作必须记录日志

## 6. 版本控制规范

### 6.1 Git规范
- 分支命名: feature/功能名
- 提交信息必须说明改动内容
- 每次提交必须经过代码审查
- 禁止提交敏感配置信息

### 6.2 提交信息格式
```
feat: 添加用户管理功能
fix: 修复用户列表分页bug
docs: 更新API文档
style: 优化代码格式
refactor: 重构用户服务
test: 添加单元测试
```

## 7. 测试规范

### 7.1 单元测试
- 核心业务必须编写单元测试
- 测试覆盖率不低于80%
- 必须包含正向和异常测试用例
```java
@Test
public void testGetUserInfo() {
    // 准备测试数据
    // 执行测试
    // 验证结果
}
```

### 7.2 接口测试
- 必须测试所有请求参数组合
- 必须验证返回值格式
- 必须测试异常情况
- 必须测试性能指标