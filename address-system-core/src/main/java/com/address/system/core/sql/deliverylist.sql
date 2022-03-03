/*
 Navicat Premium Data Transfer

 Source Server         : 本地数据库
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : delivery

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 06/12/2020 20:20:13
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for deliverylist
-- ----------------------------
DROP TABLE IF EXISTS `deliverylist`;
CREATE TABLE `deliverylist`  (
  `id` int(0) NOT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `customer_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `customer_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `postman_account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `postman_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `postman_tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of deliverylist
-- ----------------------------
INSERT INTO `deliverylist` VALUES (1, 1, '顾客1号', '18816549999', '北京市海淀区西土城路10号', 'p001', '邮差1号', '18811331652', 0);
INSERT INTO `deliverylist` VALUES (2, 2, '顾客2号', '16654326666', '北京市海淀区西土城路20号', 'p001', '邮差1号', '18811331652', 0);
INSERT INTO `deliverylist` VALUES (3, 3, '顾客1号', '18816549999', '北京市海淀区西土城路10号', 'p001', '邮差1号', '18811331652', 0);

SET FOREIGN_KEY_CHECKS = 1;
