/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50045
Source Host           : localhost:3306
Source Database       : db_refwait

Target Server Type    : MYSQL
Target Server Version : 50045
File Encoding         : 65001

Date: 2017-12-26 16:23:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rw_admin
-- ----------------------------
DROP TABLE IF EXISTS `rw_admin`;
CREATE TABLE `rw_admin` (
  `id` bigint(11) NOT NULL auto_increment COMMENT '管理员id',
  `name` varchar(32) NOT NULL COMMENT '昵称',
  `account` varchar(16) NOT NULL COMMENT '账号',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `is_super_admin` tinyint(1) unsigned NOT NULL default '0' COMMENT '是否为超级管理员(0:否,1:是)',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of rw_admin
-- ----------------------------

-- ----------------------------
-- Table structure for rw_customer
-- ----------------------------
DROP TABLE IF EXISTS `rw_customer`;
CREATE TABLE `rw_customer` (
  `id` bigint(11) NOT NULL auto_increment COMMENT '顾客id',
  `openid` varchar(32) NOT NULL default '' COMMENT '微信openid',
  `name` varchar(16) default '' COMMENT '顾客姓名',
  `sex` tinyint(1) unsigned default '2' COMMENT '性别(0:男,1:女,2:保密)',
  `mobile_phone` varchar(11) default NULL COMMENT '移动电话',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='顾客表';

-- ----------------------------
-- Records of rw_customer
-- ----------------------------
INSERT INTO `rw_customer` VALUES ('1', 'aaa', '小明', null, null, '2017-12-19 11:37:15', '2017-12-24 16:48:05');
INSERT INTO `rw_customer` VALUES ('3', 'aaa', null, null, null, '2017-12-19 16:52:36', '2017-12-19 16:52:36');
INSERT INTO `rw_customer` VALUES ('4', 'abcabc', null, null, '13333333333', '2017-12-19 17:01:12', '2017-12-19 17:01:12');
INSERT INTO `rw_customer` VALUES ('17', 'abcabc', null, null, '13333333333', '2017-12-24 16:48:05', '2017-12-24 16:48:05');
INSERT INTO `rw_customer` VALUES ('19', 'oyYPs0EGJw3rK0vVXXZ-dWgHxv-s', '哈哈哈', '2', 'unset', '2017-12-24 18:38:57', '2017-12-25 17:35:59');

-- ----------------------------
-- Table structure for rw_evaluate
-- ----------------------------
DROP TABLE IF EXISTS `rw_evaluate`;
CREATE TABLE `rw_evaluate` (
  `id` bigint(11) NOT NULL auto_increment COMMENT '评价id',
  `customer_id` bigint(11) NOT NULL COMMENT '顾客id',
  `merchant_id` bigint(11) NOT NULL COMMENT '商家id',
  `order_id` bigint(11) NOT NULL COMMENT '订单id',
  `level` tinyint(1) unsigned NOT NULL COMMENT '星级(1~5)',
  `is_anonymity` tinyint(1) unsigned NOT NULL default '0' COMMENT '是否匿名(0:否,1:是)',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`),
  KEY `fk_evaluate_order_id` (`order_id`),
  KEY `fk_evaluate_customer_id` (`customer_id`),
  KEY `fk_evaluate_merchant_id` (`merchant_id`),
  CONSTRAINT `fk_evaluate_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `rw_customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_evaluate_merchant_id` FOREIGN KEY (`merchant_id`) REFERENCES `rw_merchant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_evaluate_order_id` FOREIGN KEY (`order_id`) REFERENCES `rw_order` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评价表';

-- ----------------------------
-- Records of rw_evaluate
-- ----------------------------

-- ----------------------------
-- Table structure for rw_feedback
-- ----------------------------
DROP TABLE IF EXISTS `rw_feedback`;
CREATE TABLE `rw_feedback` (
  `id` bigint(11) NOT NULL auto_increment COMMENT '意见反馈id',
  `content` varchar(256) NOT NULL COMMENT '内容',
  `feedbacker_type` tinyint(1) unsigned NOT NULL default '0' COMMENT '反馈者类型(0:顾客,1:商家)',
  `feedbacker_id` bigint(11) NOT NULL COMMENT '反馈者id(顾客/商家id)',
  `is_read` tinyint(1) unsigned NOT NULL default '0' COMMENT '是否已读(0:否,1:是)',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='意见反馈表';

-- ----------------------------
-- Records of rw_feedback
-- ----------------------------
INSERT INTO `rw_feedback` VALUES ('1', '内容', '1', '1', '0', '2017-12-24 17:51:46', '2017-12-24 17:51:46');
INSERT INTO `rw_feedback` VALUES ('2', '哈哈', '0', '18', '0', '2017-12-24 18:23:17', '2017-12-24 18:23:17');
INSERT INTO `rw_feedback` VALUES ('3', 'aa', '0', '18', '0', '2017-12-24 18:34:22', '2017-12-24 18:34:22');
INSERT INTO `rw_feedback` VALUES ('4', '个哈哈', '0', '19', '0', '2017-12-25 15:55:27', '2017-12-25 15:55:27');
INSERT INTO `rw_feedback` VALUES ('5', '哈哈哈', '0', '19', '0', '2017-12-25 17:37:14', '2017-12-25 17:37:14');
INSERT INTO `rw_feedback` VALUES ('6', '', '0', '19', '0', '2017-12-25 17:37:39', '2017-12-25 17:37:39');

-- ----------------------------
-- Table structure for rw_food
-- ----------------------------
DROP TABLE IF EXISTS `rw_food`;
CREATE TABLE `rw_food` (
  `id` bigint(11) NOT NULL auto_increment COMMENT '食物id',
  `merchant_id` bigint(11) NOT NULL COMMENT '商家id',
  `name` varchar(32) NOT NULL COMMENT '名称',
  `price` decimal(6,2) NOT NULL COMMENT '价格',
  `is_exist` tinyint(1) unsigned NOT NULL default '1' COMMENT '是否存在(0:不存在,1:存在)',
  `details` varchar(32) default NULL COMMENT '详情信息',
  `image_url` varchar(128) NOT NULL COMMENT '图片url地址',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`),
  KEY `fk_food_merchant_id` (`merchant_id`),
  CONSTRAINT `fk_food_merchant_id` FOREIGN KEY (`merchant_id`) REFERENCES `rw_merchant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='食物表';

-- ----------------------------
-- Records of rw_food
-- ----------------------------

-- ----------------------------
-- Table structure for rw_merchant
-- ----------------------------
DROP TABLE IF EXISTS `rw_merchant`;
CREATE TABLE `rw_merchant` (
  `id` bigint(11) NOT NULL auto_increment COMMENT '商家id',
  `openid` varchar(32) NOT NULL COMMENT '微信openid',
  `name` varchar(32) NOT NULL default 'unset' COMMENT '商家名称',
  `telephone` varchar(32) default 'unset' COMMENT '固定电话',
  `mobile_phone` varchar(11) NOT NULL default 'unset' COMMENT '手机',
  `address` varchar(128) NOT NULL default 'unset' COMMENT '地址',
  `longitude` decimal(10,5) NOT NULL default '0.00000' COMMENT '经度',
  `latitude` decimal(10,5) NOT NULL default '0.00000' COMMENT '纬度',
  `status` tinyint(1) unsigned NOT NULL default '0' COMMENT '状态(0:休息,1:营业)',
  `notice` varchar(256) default 'unset' COMMENT '商家公告',
  `icon_url` varchar(128) NOT NULL default 'unset' COMMENT '图标url地址',
  `heat_value` int(1) unsigned NOT NULL default '0' COMMENT '热度',
  `is_qualified` tinyint(1) unsigned NOT NULL default '2' COMMENT '是否合格(0:不合格,1:合格,2:审核中)',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='商家表';

-- ----------------------------
-- Records of rw_merchant
-- ----------------------------
INSERT INTO `rw_merchant` VALUES ('1', 'mlxg9349326871', '拿渡麻辣香锅(华发商都店)', '123456789', '123456789', '广东省珠海市香洲区珠海大道8号华发商都1号楼三楼A3043B-A3045号', '113.51000', '22.22000', '0', 'unset', 'http://120.78.182.217/images/1514274868158.jpg', '0', '2', '2017-12-26 15:54:28', '2017-12-26 15:54:28');
INSERT INTO `rw_merchant` VALUES ('2', 'mlxg9349326872', '不夜天柴火烤鱼火锅店', 'unset', '123456789', '广东省珠海市金湾区红旗中珠花园(广安路南)', '113.35000', '22.14000', '0', 'unset', 'http://120.78.182.217/images/1514274903549.jpg', '0', '2', '2017-12-26 15:55:03', '2017-12-26 15:55:03');
INSERT INTO `rw_merchant` VALUES ('3', '9349326873', '雅高西餐厅', 'unset', '123456789', '广东省珠海市金湾区广安路121号附近', '113.35116', '22.13579', '0', 'unset', 'http://120.78.182.217/images/1514275044819.jpg', '0', '2', '2017-12-26 15:57:25', '2017-12-26 15:57:25');
INSERT INTO `rw_merchant` VALUES ('4', 'aaaa9349326874', '沙县小吃', '1234567894', '1234567894', '广东省珠海市斗门区白藤三路西江月六号商铺(湖湘人家旁)', '113.35772', '22.15370', '0', 'unset', 'http://120.78.182.217/images/1514275097303.jpg', '0', '2', '2017-12-26 15:58:17', '2017-12-26 15:58:17');
INSERT INTO `rw_merchant` VALUES ('5', 'aaaa9349326875', '岳阳烧烤', '1234567895', '1234567895', '广东省珠海市金湾区广安路中珠花园3号铺', '113.34804', '22.13623', '0', 'unset', 'http://120.78.182.217/images/1514275209749.jpg', '0', '2', '2017-12-26 16:00:09', '2017-12-26 16:00:09');
INSERT INTO `rw_merchant` VALUES ('6', 'aaaa9349326876', '尖峰煲仔饭', '1234567896', '1234567896', '广东省珠海市斗门区尖峰前路247号附近(武商量贩港澳店斜对面)', '113.30584', '22.19333', '0', 'unset', 'http://120.78.182.217/images/1514275269282.jpg', '0', '2', '2017-12-26 16:01:09', '2017-12-26 16:01:09');
INSERT INTO `rw_merchant` VALUES ('7', 'aaaa9349326877', '炭舍烤鱼(珠海乐世界购物中心店)', '1234567897', '1234567897', '广东省珠海市香洲区明珠北路338号珠海乐世界购物中心内', '113.50924', '22.27519', '0', 'unset', 'http://120.78.182.217/images/1514275337034.jpg', '0', '2', '2017-12-26 16:02:17', '2017-12-26 16:02:17');
INSERT INTO `rw_merchant` VALUES ('8', 'aaaa9349326878', '马得利(吉大店)', '1234567898', '1234567898', '广东省珠海市香洲区吉大景山路222号珠海百货广场首层', '113.57970', '22.25601', '0', 'unset', 'http://120.78.182.217/images/1514275361351.jpg', '0', '2', '2017-12-26 16:02:41', '2017-12-26 16:02:41');

-- ----------------------------
-- Table structure for rw_notice
-- ----------------------------
DROP TABLE IF EXISTS `rw_notice`;
CREATE TABLE `rw_notice` (
  `id` bigint(11) NOT NULL auto_increment COMMENT '公告id',
  `admin_id` bigint(11) NOT NULL COMMENT '管理员id',
  `title` varchar(32) NOT NULL COMMENT '标题',
  `content` varchar(256) NOT NULL COMMENT '内容',
  `is_view` tinyint(1) unsigned NOT NULL default '1' COMMENT '是否可查(0:否,1:是)',
  `image_url` varchar(128) NOT NULL COMMENT '公告图片url地址',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`),
  KEY `fk_notice_admin_id` (`admin_id`),
  CONSTRAINT `fk_notice_admin_id` FOREIGN KEY (`admin_id`) REFERENCES `rw_admin` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告表';

-- ----------------------------
-- Records of rw_notice
-- ----------------------------

-- ----------------------------
-- Table structure for rw_order
-- ----------------------------
DROP TABLE IF EXISTS `rw_order`;
CREATE TABLE `rw_order` (
  `id` bigint(11) NOT NULL auto_increment COMMENT '订单id',
  `customer_id` bigint(11) NOT NULL COMMENT '顾客id',
  `merchant_id` bigint(11) NOT NULL COMMENT '商家id',
  `details` varchar(256) NOT NULL COMMENT '订单详情(食物id1*数量1,食物id2*数量2...)',
  `remark` varchar(32) default NULL COMMENT '备注',
  `status` tinyint(1) unsigned NOT NULL default '0' COMMENT '订单状态(0:未付款,1:未接单,2:配餐中,3:配餐完毕,4:已完成,5:已取消)',
  `discount` decimal(2,1) NOT NULL default '0.0' COMMENT '折扣(0~9.9,0代表不打折)',
  `number_of_people` int(1) unsigned NOT NULL default '1' COMMENT '就餐人数',
  `catering_price` decimal(5,2) default '0.00' COMMENT '配餐费',
  `tables_info` varchar(64) NOT NULL COMMENT '桌位信息(由商家自行描述)',
  `total_price` decimal(6,2) NOT NULL COMMENT '总价',
  `is_evaluation` tinyint(1) unsigned NOT NULL default '0' COMMENT '是否已评价(0:否,1:是)',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL COMMENT '修改时间',
  PRIMARY KEY  (`id`),
  KEY `fk_order_customer_id` (`customer_id`),
  KEY `fk_order_merchant_id` (`merchant_id`),
  CONSTRAINT `fk_order_customer_id` FOREIGN KEY (`customer_id`) REFERENCES `rw_customer` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_order_merchant_id` FOREIGN KEY (`merchant_id`) REFERENCES `rw_merchant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of rw_order
-- ----------------------------
