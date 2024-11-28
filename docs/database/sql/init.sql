/*
 Navicat Premium Data Transfer

 Source Server         : local57
 Source Server Type    : MySQL
 Source Server Version : 80402 (8.4.2)
 Source Host           : localhost:3306
 Source Schema         : ry-vue

 Target Server Type    : MySQL
 Target Server Version : 80402 (8.4.2)
 File Encoding         : 65001

 Date: 28/11/2024 16:52:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- 1. 用户相关表
-- ----------------------------

-- 用户表
DROP TABLE IF EXISTS `myuser`;
CREATE TABLE `myuser` (
  `user_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码（加密存储）',
  `email` varchar(100) NOT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `gender` tinyint DEFAULT NULL COMMENT '性别(0未知,1男,2女)',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `avatar_url` varchar(255) DEFAULT NULL COMMENT '用户头像路径',
  `interest_tags` varchar(255) DEFAULT NULL COMMENT '用户兴趣标签，逗号分隔的标签',
  `register_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `status` tinyint DEFAULT '1' COMMENT '状态(1正常,0禁用)',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- 管理员表
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `admin_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(100) NOT NULL COMMENT '密码（加密存储）',
  `role` tinyint DEFAULT '1' COMMENT '角色(1超级管理员,2普通管理员)',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `status` tinyint DEFAULT '1' COMMENT '状态(1正常,0禁用)',
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员表';

-- ----------------------------
-- 2. 景点相关表
-- ----------------------------

-- 景点表
DROP TABLE IF EXISTS `attraction`;
CREATE TABLE `attraction` (
  `attraction_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '景点ID',
  `name` varchar(100) NOT NULL COMMENT '景点名称',
  `location` varchar(100) DEFAULT NULL COMMENT '所在地',
  `description` text COMMENT '景点描述',
  `open_time` varchar(50) DEFAULT NULL COMMENT '开放时间',
  `ticket_price` decimal(10,2) DEFAULT NULL COMMENT '门票价格',
  `image_url` varchar(255) DEFAULT NULL COMMENT '景点主图片URL',
  `images` text COMMENT '景点多图路径（以逗号分隔）',
  `tags` varchar(255) DEFAULT NULL COMMENT '景点标签',
  `view_count` int DEFAULT '0' COMMENT '浏览量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` tinyint DEFAULT '1' COMMENT '状态(1正常,0关闭)',
  PRIMARY KEY (`attraction_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='景点表';

-- 轮播图表
DROP TABLE IF EXISTS `carousel`;
CREATE TABLE `carousel` (
  `carousel_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '轮播图ID',
  `image_url` varchar(255) NOT NULL COMMENT '轮播图图片URL',
  `link_url` varchar(255) DEFAULT NULL COMMENT '轮播图跳转链接',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint DEFAULT '1' COMMENT '状态(1有效,0无效)',
  PRIMARY KEY (`carousel_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='轮播图表';

-- ----------------------------
-- 3. 线路相关表
-- ----------------------------

-- 旅游线路表
DROP TABLE IF EXISTS `tour_route`;
CREATE TABLE `tour_route` (
  `route_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '线路ID',
  `route_name` varchar(100) NOT NULL COMMENT '线路名称',
  `price` decimal(10,2) NOT NULL COMMENT '价格',
  `description` text COMMENT '线路描述',
  `duration` int DEFAULT NULL COMMENT '行程天数',
  `departure_place` varchar(100) DEFAULT NULL COMMENT '出发地',
  `destination` varchar(100) DEFAULT NULL COMMENT '目的地',
  `image_url` varchar(255) DEFAULT NULL COMMENT '线路主图片URL',
  `images` text COMMENT '线路多图路径（以逗号分隔）',
  `tags` varchar(255) DEFAULT NULL COMMENT '线路标签',
  `view_count` int DEFAULT '0' COMMENT '浏览量',
  `favorites_count` int DEFAULT '0' COMMENT '收藏次数',
  `comments_count` int DEFAULT '0' COMMENT '评论数',
  `bookings_count` int DEFAULT '0' COMMENT '预定次数',
  `min_budget` decimal(10,2) DEFAULT NULL COMMENT '最低预算',
  `max_budget` decimal(10,2) DEFAULT NULL COMMENT '最高预算',
  `max_group_size` int DEFAULT NULL COMMENT '最大团体人数',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `status` tinyint DEFAULT '1' COMMENT '状态(1上架,0下架)',
  PRIMARY KEY (`route_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='旅游线路表';

-- ----------------------------
-- 4. 订单相关表
-- ----------------------------

-- 订单表
DROP TABLE IF EXISTS `myorder`;
CREATE TABLE `myorder` (
  `order_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
  `route_id` bigint UNSIGNED NOT NULL COMMENT '线路ID',
  `order_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
  `travel_date` date NOT NULL COMMENT '出行日期',
  `num_people` int NOT NULL COMMENT '出行人数',
  `total_price` decimal(10,2) NOT NULL COMMENT '总价',
  `order_status` tinyint DEFAULT '0' COMMENT '订单状态(0待支付,1已支付,2已取消)',
  `contact_name` varchar(50) NOT NULL COMMENT '联系人姓名',
  `contact_phone` varchar(20) NOT NULL COMMENT '联系人电话',
  `remarks` text COMMENT '备注',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  KEY `route_id` (`route_id`),
  CONSTRAINT `myorder_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `myuser` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `myorder_ibfk_2` FOREIGN KEY (`route_id`) REFERENCES `tour_route` (`route_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- ----------------------------
-- 5. 评论相关表
-- ----------------------------

-- 评论表
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '评论ID',
  `parent_id` bigint UNSIGNED DEFAULT NULL COMMENT '父评论ID,一级评论为NULL',
  `item_type` tinyint NOT NULL COMMENT '评论目标类型(1线路,2景点)',
  `item_id` bigint UNSIGNED NOT NULL COMMENT '目标ID(线路ID或景点ID)',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
  `content` text NOT NULL COMMENT '评论内容',
  `rating` int DEFAULT NULL COMMENT '评分(1-5,仅一级评论需要）',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint DEFAULT '1' COMMENT '状态(1正常,0删除)',
  PRIMARY KEY (`comment_id`),
  KEY `fk_comment_user` (`user_id`),
  KEY `fk_comment_parent` (`parent_id`),
  CONSTRAINT `fk_comment_parent` FOREIGN KEY (`parent_id`) REFERENCES `comment` (`comment_id`) ON DELETE CASCADE,
  CONSTRAINT `fk_comment_user` FOREIGN KEY (`user_id`) REFERENCES `myuser` (`user_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论表（支持线路和景点评论）';

-- ----------------------------
-- 6. 收藏相关表
-- ----------------------------

-- 收藏表
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `favorite_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '收藏记录ID',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
  `route_id` bigint UNSIGNED DEFAULT NULL COMMENT '线路ID',
  `attraction_id` bigint UNSIGNED DEFAULT NULL COMMENT '景点ID',
  `type` tinyint NOT NULL COMMENT '收藏类型(1线路,2景点)',
  `favorite_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '收藏时间',
  PRIMARY KEY (`favorite_id`),
  KEY `user_id` (`user_id`),
  KEY `route_id` (`route_id`),
  KEY `attraction_id` (`attraction_id`),
  CONSTRAINT `favorite_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `myuser` (`user_id`) ON DELETE CASCADE,
  CONSTRAINT `favorite_ibfk_2` FOREIGN KEY (`route_id`) REFERENCES `tour_route` (`route_id`) ON DELETE SET NULL,
  CONSTRAINT `favorite_ibfk_3` FOREIGN KEY (`attraction_id`) REFERENCES `attraction` (`attraction_id`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='收藏表';

-- ----------------------------
-- 7. 用户行为表
-- ----------------------------

-- 用户行为表
DROP TABLE IF EXISTS `user_behavior`;
CREATE TABLE `user_behavior` (
  `behavior_id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '行为ID',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户ID',
  `behavior_type` varchar(50) NOT NULL COMMENT '行为类型（浏览、收藏、预订等）',
  `item_id` bigint UNSIGNED NOT NULL COMMENT '目标内容ID(例如线路或景点的ID)',
  `item_type` tinyint NOT NULL COMMENT '目标类型(1-线路,2-景点）',
  `behavior_time` datetime NOT NULL COMMENT '行为时间',
  `additional_info` varchar(255) DEFAULT NULL COMMENT '附加信息（如设备、来源等）',
  PRIMARY KEY (`behavior_id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_item_id` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='用户行为表，用于记录用户对线路和景点的行为数据';

-- ----------------------------
-- 8. 初始数据
-- ----------------------------

-- 插入管理员账号
INSERT INTO `admin` (`username`, `password`, `role`) VALUES 
('admin', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 1);  -- 密码: admin123

SET FOREIGN_KEY_CHECKS = 1;