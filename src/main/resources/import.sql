/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50549
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50549
File Encoding         : 65001

Date: 2017-09-24 17:20:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for city
-- ----------------------------
DROP TABLE IF EXISTS `city`;
CREATE TABLE `city` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL COMMENT '名称',
  `state` varchar(10) DEFAULT NULL COMMENT 'state',
  `country` varchar(20) DEFAULT NULL COMMENT '国家',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_unique` (`name`) COMMENT '名称唯一索引'
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of city
-- ----------------------------
INSERT INTO `city` VALUES ('1', 'aaa', 'a', 'aaaa');
INSERT INTO `city` VALUES ('2', 'string', 'string', 'string');
INSERT INTO `city` VALUES ('10', '111', '1', '1111');
INSERT INTO `city` VALUES ('11', '222', '2', '2222');

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `available` int(255) DEFAULT NULL,
  `name` varchar(100) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `parent_ids` varchar(255) DEFAULT NULL,
  `permission` varchar(200) DEFAULT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `url` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('1', '0', '用户管理', '0', '0/', 'city:view', 'menu', '/city/list');
INSERT INTO `sys_permission` VALUES ('2', '0', '用户添加', '1', '0/1', 'city:add', 'button', '/city/add');
INSERT INTO `sys_permission` VALUES ('3', '0', '用户删除', '1', '0/1', 'city:del', 'button', '/city/userDel');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available` int(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `role` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '0', '管理员', 'admin');
INSERT INTO `sys_role` VALUES ('2', '0', 'VIP会员', 'vip');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `permission_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('3', '1');
INSERT INTO `sys_role_permission` VALUES ('1', '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `uid` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `name` varchar(20) DEFAULT NULL COMMENT '真实姓名',
  `password` varchar(150) NOT NULL COMMENT '密码',
  `salt` varchar(255) DEFAULT NULL COMMENT '密码盐',
  `state` int(255) DEFAULT '0' COMMENT '0:创建未认证,1:正常状态,2:用户被锁定.',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '管理员', 'd3c59d25033dbf980d29554025c23a75', '8d78869f470951332959580424d4bf4f', '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `role_id` bigint(20) NOT NULL,
  `uid` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1');
