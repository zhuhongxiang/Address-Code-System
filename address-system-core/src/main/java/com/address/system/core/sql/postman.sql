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

 Date: 06/12/2020 20:20:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for postman
-- ----------------------------
DROP TABLE IF EXISTS `postman`;
CREATE TABLE `postman`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '配送员id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `tel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `passwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  `is_delete` int(0) NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of postman
-- ----------------------------
INSERT INTO `postman` VALUES (1, '邮差1号', '18811331652', 'p001', '123456', '2020-11-05 12:48:27', '2020-11-17 12:48:37', 0);
INSERT INTO `postman` VALUES (2, '邮差2号', '15542338888', 'p002', '123456', '2020-11-11 20:37:19', '2020-11-11 20:37:22', 0);

SET FOREIGN_KEY_CHECKS = 1;
