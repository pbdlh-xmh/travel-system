# 数据库设计说明文档

## 1. 用户管理模块

### 1.1 用户表(myuser)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| user_id | bigint unsigned | 是 | 用户ID,自增主键 |
| username | varchar(50) | 是 | 用户名,唯一 |
| password | varchar(100) | 是 | 密码(加密存储) |
| email | varchar(100) | 是 | 邮箱,唯一 |
| phone | varchar(20) | 否 | 手机号 |
| gender | tinyint | 否 | 性别(0未知,1男,2女) |
| birthday | date | 否 | 生日 |
| avatar_url | varchar(255) | 否 | 用户头像路径 |
| interest_tags | varchar(255) | 否 | 用户兴趣标签,逗号分隔 |
| register_time | datetime | 否 | 注册时间,默认当前时间 |
| last_login_time | datetime | 否 | 上次登录时间 |
| status | tinyint | 否 | 状态(1正常,0禁用),默认1 |

### 1.2 管理员表(admin)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| admin_id | bigint unsigned | 是 | 管理员ID,自增主键 |
| username | varchar(50) | 是 | 用户名,唯一 |
| password | varchar(100) | 是 | 密码(加密存储) |
| role | tinyint | 否 | 角色(1超级管理员,2普通管理员),默认1 |
| create_time | datetime | 否 | 创建时间,默认当前时间 |
| last_login_time | datetime | 否 | 上次登录时间 |
| status | tinyint | 否 | 状态(1正常,0禁用),默认1 |

## 2. 景点管理模块

### 2.1 景点表(attraction)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| attraction_id | bigint unsigned | 是 | 景点ID,自增主键 |
| name | varchar(100) | 是 | 景点名称 |
| location | varchar(100) | 否 | 所在地 |
| description | text | 否 | 景点描述 |
| open_time | varchar(50) | 否 | 开放时间 |
| ticket_price | decimal(10,2) | 否 | 门票价格 |
| image_url | varchar(255) | 否 | 景点主图片URL |
| images | text | 否 | 景点多图路径(逗号分隔) |
| tags | varchar(255) | 否 | 景点标签 |
| view_count | int | 否 | 浏览量,默认0 |
| create_time | datetime | 否 | 创建时间,默认当前时间 |
| update_time | datetime | 否 | 更新时间,自动更新 |
| status | tinyint | 否 | 状态(1正常,0关闭),默认1 |

### 2.2 轮播图表(carousel)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| carousel_id | bigint unsigned | 是 | 轮播图ID,自增主键 |
| image_url | varchar(255) | 是 | 轮播图图片URL |
| link_url | varchar(255) | 否 | 轮播图跳转链接 |
| create_time | datetime | 否 | 创建时间,默认当前时间 |
| status | tinyint | 否 | 状态(1有效,0无效),默认1 |

## 3. 线路管理模块

### 3.1 旅游线路表(tour_route)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| route_id | bigint unsigned | 是 | 线路ID,自增主键 |
| route_name | varchar(100) | 是 | 线路名称 |
| price | decimal(10,2) | 是 | 价格 |
| description | text | 否 | 线路描述 |
| duration | int | 否 | 行程天数 |
| departure_place | varchar(100) | 否 | 出发地 |
| destination | varchar(100) | 否 | 目的地 |
| image_url | varchar(255) | 否 | 线路主图片URL |
| images | text | 否 | 线路多图路径(逗号分隔) |
| tags | varchar(255) | 否 | 线路标签 |
| view_count | int | 否 | 浏览量,默认0 |
| favorites_count | int | 否 | 收藏次数,默认0 |
| comments_count | int | 否 | 评论数,默认0 |
| bookings_count | int | 否 | 预定次数,默认0 |
| min_budget | decimal(10,2) | 否 | 最低预算 |
| max_budget | decimal(10,2) | 否 | 最高预算 |
| max_group_size | int | 否 | 最大团体人数 |
| create_time | datetime | 否 | 创建时间,默认当前时间 |
| update_time | datetime | 否 | 更新时间,自动更新 |
| status | tinyint | 否 | 状态(1上架,0下架),默认1 |

### 3.2 线路-景点关联表(route_attraction)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| id | bigint unsigned | 是 | 记录ID,自增主键 |
| route_id | bigint unsigned | 是 | 线路ID,外键 |
| attraction_id | bigint unsigned | 是 | 景点ID,外键 |

## 4. 订单交易模块

### 4.1 订单表(myorder)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| order_id | bigint unsigned | 是 | 订单ID,自增主键 |
| user_id | bigint unsigned | 是 | 用户ID,外键 |
| route_id | bigint unsigned | 是 | 线路ID,外键 |
| order_time | datetime | 否 | 下单时间,默认当前时间 |
| travel_date | date | 是 | 出行日期 |
| num_people | int | 是 | 出行人数 |
| total_price | decimal(10,2) | 是 | 总价 |
| order_status | tinyint | 否 | 订单状态(0待支付,1已支付,2已取消),默认0 |
| contact_name | varchar(50) | 是 | 联系人姓名 |
| contact_phone | varchar(20) | 是 | 联系人电话 |
| remarks | text | 否 | 备注 |
| create_time | datetime | 否 | 创建时间,默认当前时间 |
| update_time | datetime | 否 | 更新时间,自动更新 |

### 4.2 收藏表(favorite)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| favorite_id | bigint unsigned | 是 | 收藏记录ID,自增主键 |
| user_id | bigint unsigned | 是 | 用户ID,外键 |
| route_id | bigint unsigned | 否 | 线路ID,外键 |
| attraction_id | bigint unsigned | 否 | 景点ID,外键 |
| type | tinyint | 是 | 收藏类型(1线路,2景点) |
| favorite_time | datetime | 否 | 收藏时间,默认当前时间 |

### 4.3 评论表(comment)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| comment_id | bigint unsigned | 是 | 评论ID,自增主键 |
| parent_id | bigint unsigned | 否 | 父评论ID,一级评论为NULL |
| item_type | tinyint | 是 | 评论目标类型(1线路,2景点) |
| item_id | bigint unsigned | 是 | 目标ID(线路ID或景点ID) |
| user_id | bigint unsigned | 是 | 用户ID,外键 |
| content | text | 是 | 评论内容 |
| rating | int | 否 | 评分(1-5,仅一级评论需要) |
| create_time | datetime | 否 | 创建时间,默认当前时间 |
| status | tinyint | 否 | 状态(1正常,0删除),默认1 |

## 5. 推荐系统模块

### 5.1 推荐控制表(recommend_control)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| control_id | bigint unsigned | 是 | 控制ID,自增主键 |
| item_id | bigint | 是 | 推荐内容ID |
| item_type | tinyint | 是 | 内容类型(1线路,2景点) |
| priority | int | 否 | 推荐优先级,默认0 |
| start_time | datetime | 否 | 推荐开始时间 |
| end_time | datetime | 否 | 推荐结束时间 |
| create_time | datetime | 否 | 创建时间,默认当前时间 |
| update_time | datetime | 否 | 更新时间,自动更新 |
| status | tinyint | 否 | 状态(1启用,0禁用),默认1 |

### 5.2 推荐规则表(recommend_rule)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| rule_id | bigint unsigned | 是 | 规则ID,自增主键 |
| rule_name | varchar(100) | 是 | 规则名称 |
| weight | decimal(5,2) | 是 | 推荐权重 |
| description | text | 否 | 规则描述 |
| create_time | datetime | 否 | 创建时间,默认当前时间 |
| update_time | datetime | 否 | 更新时间,自动更新 |

### 5.3 推荐效果统计表(recommend_stats)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| stat_id | bigint unsigned | 是 | 统计ID,自增主键 |
| user_id | bigint | 是 | 用户ID |
| item_id | bigint | 是 | 推荐内容ID |
| item_type | tinyint | 是 | 内容类型(1线路,2景点) |
| click_count | int | 是 | 点击次数,默认0 |
| order_conversion | int | 是 | 预订转化次数,默认0 |
| date | date | 是 | 统计日期 |

### 5.4 用户行为表(user_behavior)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| behavior_id | bigint unsigned | 是 | 行为ID,自增主键 |
| user_id | bigint unsigned | 是 | 用户ID |
| behavior_type | varchar(50) | 是 | 行为类型(浏览、收藏、预订等) |
| item_id | bigint unsigned | 是 | 目标内容ID |
| item_type | tinyint | 是 | 目标类型(1线路,2景点) |
| behavior_time | datetime | 是 | 行为时间 |
| additional_info | varchar(255) | 否 | 附加信息(设备、来源等) |

## 6. 系统管理模块

### 6.1 操作日志表(operation_log)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| log_id | bigint unsigned | 是 | 日志ID,自增主键 |
| user_id | bigint unsigned | 否 | 操作用户ID |
| username | varchar(50) | 否 | 操作用户名 |
| operation | varchar(255) | 是 | 操作类型 |
| module | varchar(100) | 否 | 操作模块 |
| description | text | 否 | 操作描述 |
| ip_address | varchar(100) | 否 | 操作IP地址 |
| create_time | datetime | 否 | 操作时间,默认当前时间 |

## 7. 新闻管理模块

### 7.1 新闻表(news)
| 字段名 | 类型 | 必填 | 描述 |
|--------|------|------|------|
| news_id | bigint unsigned | 是 | 新闻ID,自增主键 |
| title | varchar(255) | 是 | 新闻标题 |
| summary | varchar(255) | 否 | 新闻摘要 |
| content | text | 否 | 新闻内容 |
| image_url | varchar(255) | 否 | 新闻配图 |
| create_time | datetime | 否 | 创建时间,默认当前时间 |
| update_time | datetime | 否 | 更新时间,自动更新 |

## 注意事项

1. 所有表主键均使用bigint unsigned类型,并自增
2. 涉及金额的字段统一使用decimal(10,2)类型
3. 时间字段根据需要设置默认值为CURRENT_TIMESTAMP
4. 表之间的关联通过外键约束保证数据一致性
5. 重要字段都建立了相应索引提高查询效率


## 3. 关系模型
### 3.1 主要关系
1. **用户关系**
   - myuser -> myorder：一对多（用户可以有多个订单）
   - myuser -> favorite：一对多（用户可以收藏多个景点/线路）
   - myuser -> comment：一对多（用户可以发表多个评论）
   - myuser -> user_behavior：一对多（记录用户的所有行为）

2. **景点关系**
   - attraction -> tour_route：多对多（通过route_attraction关联表）
   - attraction -> favorite：一对多（景点可以被多个用户收藏）
   - attraction -> comment：一对多（景点可以有多个评论）

3. **线路关系**
   - tour_route -> attraction：多对多（通过route_attraction关联表）
   - tour_route -> myorder：一对多（线路可以被多次预订）
   - tour_route -> favorite：一对多（线路可以被多个用户收藏）
   - tour_route -> comment：一对多（线路可以有多个评论）

### 3.2 关系图
[myuser] -----> [myorder] <----- [tour_route]
| |
| |
+-----> [favorite] <---------------+
| |
| |
+-----> [comment] <----------------+
| |
| |
+-----> [user_behavior] |
|
[attraction] <------------------> [route_attraction]


## 4. 索引设计
### 4.1 主要索引
1. **用户相关**
   - myuser: username唯一索引
   - myuser: email唯一索引
   - admin: username唯一索引

2. **景点相关**
   - attraction: status+view_count组合索引（用于热门景点查询）
   - attraction: tags索引（用于标签筛选）

3. **线路相关**
   - tour_route: status+view_count组合索引
   - tour_route: price索引（用于价格筛选）
   - tour_route: duration索引（用于行程天数筛选）

4. **订单相关**
   - myorder: user_id索引（用于查询用户订单）
   - myorder: route_id索引（用于查询线路订单）
   - myorder: order_status+create_time组合索引（用于订单状态查询）

### 4.2 索引优化
1. **覆盖索引**
sql
-- 用户表覆盖索引
ALTER TABLE myuser ADD INDEX idx_username_status (username, status);
-- 景点表覆盖索引
ALTER TABLE attraction ADD INDEX idx_status_view (status, view_count, name);
-- 线路表覆盖索引
ALTER TABLE tour_route ADD INDEX idx_status_price (status, price, route_name);


2. **复合索引**
sql
-- 订单查询优化
ALTER TABLE myorder ADD INDEX idx_user_status_time (user_id, order_status, create_time);
-- 评论查询优化
ALTER TABLE comment ADD INDEX idx_item_type_id (item_type, item_id, create_time);


## 5. SQL脚本
### 5.1 常用查询
1. **用户相关**
sql
-- 获取用户信息及其统计数据
SELECT u.,
COUNT(DISTINCT o.order_id) as order_count,
COUNT(DISTINCT f.favorite_id) as favorite_count
FROM myuser u
LEFT JOIN myorder o ON u.user_id = o.user_id
LEFT JOIN favorite f ON u.user_id = f.user_id
WHERE u.user_id = ?
GROUP BY u.user_id;
-- 获取用户行为记录
SELECT b.,
CASE b.item_type
WHEN 1 THEN r.route_name
WHEN 2 THEN a.name
END as item_name
FROM user_behavior b
LEFT JOIN tour_route r ON b.item_type = 1 AND b.item_id = r.route_id
LEFT JOIN attraction a ON b.item_type = 2 AND b.item_id = a.attraction_id
WHERE b.user_id = ?
ORDER BY b.behavior_time DESC;
sql
-- 获取热门景点
SELECT a., COUNT(f.favorite_id) as favorite_count
FROM attraction a
LEFT JOIN favorite f ON a.attraction_id = f.attraction_id
WHERE a.status = 1
GROUP BY a.attraction_id
ORDER BY a.view_count DESC, favorite_count DESC
LIMIT 10;
-- 获取线路详情及相关景点
SELECT r.,
GROUP_CONCAT(a.name) as attraction_names
FROM tour_route r
LEFT JOIN route_attraction ra ON r.route_id = ra.route_id
LEFT JOIN attraction a ON ra.attraction_id = a.attraction_id
WHERE r.route_id = ?
GROUP BY r.route_id;
sql
-- 基于ID的分页查询
SELECT FROM tour_route
WHERE status = 1
AND route_id > ?
ORDER BY route_id
LIMIT 20;
-- 复合条件分页查询
SELECT FROM attraction
WHERE status = 1
AND (view_count, attraction_id) > (?, ?)
ORDER BY view_count DESC, attraction_id
LIMIT 20;




提醒：景点详情页和旅游线路详情页的评论区共用一张表评论表

是的,您说得对。我来详细说明一下评论表的设计和使用:
sql
-- 主键索引
PRIMARY KEY (comment_id)
-- 用户评论查询索引
INDEX fk_comment_user (user_id)
-- 父评论关联索引
INDEX fk_comment_parent (parent_id)
-- 评论目标查询索引(用于获取景点或线路的评论列表)
INDEX idx_item_type_id (item_type, item_id, create_time)
sql
-- 用户外键约束
CONSTRAINT fk_comment_user FOREIGN KEY (user_id)
REFERENCES myuser (user_id) ON DELETE CASCADE
-- 父评论外键约束
CONSTRAINT fk_comment_parent FOREIGN KEY (parent_id)
REFERENCES comment (comment_id) ON DELETE CASCADE
sql
-- 1. 获取景点的一级评论列表
SELECT c., u.username, u.avatar_url
FROM comment c
LEFT JOIN myuser u ON c.user_id = u.user_id
WHERE c.item_type = 2
AND c.item_id = ?
AND c.parent_id IS NULL
ORDER BY c.create_time DESC
LIMIT ?, ?;
-- 2. 获取线路的一级评论列表
SELECT c., u.username, u.avatar_url
FROM comment c
LEFT JOIN myuser u ON c.user_id = u.user_id
WHERE c.item_type = 1
AND c.item_id = ?
AND c.parent_id IS NULL
ORDER BY c.create_time DESC
LIMIT ?, ?;
-- 3. 获取评论的回复列表
SELECT c., u.username, u.avatar_url
FROM comment c
LEFT JOIN myuser u ON c.user_id = u.user_id
WHERE c.parent_id = ?
ORDER BY c.create_time ASC;
-- 4. 获取评分统计
SELECT item_id,
COUNT() as total_count,
AVG(rating) as avg_rating,
COUNT(CASE WHEN rating = 5 THEN 1 END) as five_star_count,
COUNT(CASE WHEN rating = 4 THEN 1 END) as four_star_count,
COUNT(CASE WHEN rating = 3 THEN 1 END) as three_star_count,
COUNT(CASE WHEN rating = 2 THEN 1 END) as two_star_count,
COUNT(CASE WHEN rating = 1 THEN 1 END) as one_star_count
FROM comment
WHERE item_type = ?
AND item_id = ?
AND parent_id IS NULL
AND status = 1
GROUP BY item_id;
这样的设计可以满足景点和线路的评论功能需求，支持多级评论，并且便于统计和管理。