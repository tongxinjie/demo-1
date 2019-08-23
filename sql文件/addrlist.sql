/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : userinfo

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-08-23 00:13:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `addrlist`
-- ----------------------------
DROP TABLE IF EXISTS `addrlist`;
CREATE TABLE `addrlist` (
  `id` int(10) NOT NULL,
  `host` varchar(30) NOT NULL,
  `userid` varchar(50) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of addrlist
-- ----------------------------
INSERT INTO `addrlist` VALUES ('1', 'tongxinjie123', 'birdy');
INSERT INTO `addrlist` VALUES ('2', 'tongxinjie123', 'buzz');
INSERT INTO `addrlist` VALUES ('3', 'tongxinjie123', 'steve');
INSERT INTO `addrlist` VALUES ('4', 'tongxinjie123', 'ella');
INSERT INTO `addrlist` VALUES ('5', 'tongxinjie123', 'daisy');
INSERT INTO `addrlist` VALUES ('7', 'tongxinjie123', 'donald');
INSERT INTO `addrlist` VALUES ('8', 'tongxinjie123', 'travelFrog');
INSERT INTO `addrlist` VALUES ('9', 'tongxinjie123', 'hulk_hulk');
INSERT INTO `addrlist` VALUES ('10', 'tongxinjie123', 'jerry');
INSERT INTO `addrlist` VALUES ('11', 'tongxinjie123', 'mickey');
INSERT INTO `addrlist` VALUES ('12', 'tongxinjie123', 'minnie');
INSERT INTO `addrlist` VALUES ('13', 'tongxinjie123', 'peppa');
INSERT INTO `addrlist` VALUES ('14', 'tongxinjie123', 'piggy');
INSERT INTO `addrlist` VALUES ('15', 'tongxinjie123', 'piglet');
INSERT INTO `addrlist` VALUES ('16', 'tongxinjie123', 'pikapika');
INSERT INTO `addrlist` VALUES ('17', 'tongxinjie123', 'shawn');
INSERT INTO `addrlist` VALUES ('18', 'tongxinjie123', 'snowWhite');
INSERT INTO `addrlist` VALUES ('19', 'tongxinjie123', 'teddy');
INSERT INTO `addrlist` VALUES ('20', 'tongxinjie123', 'tiger');
INSERT INTO `addrlist` VALUES ('21', 'tongxinjie123', 'tommy');
INSERT INTO `addrlist` VALUES ('22', 'tongxinjie123', 'winnie');
INSERT INTO `addrlist` VALUES ('24', 'tommy', 'bugsbunny');
INSERT INTO `addrlist` VALUES ('25', 'tommy', 'speike');
INSERT INTO `addrlist` VALUES ('26', 'tommy', 'tongxinjie123');
INSERT INTO `addrlist` VALUES ('27', 'tommy', 'jerry');
INSERT INTO `addrlist` VALUES ('28', 'tommy', 'peppa');
INSERT INTO `addrlist` VALUES ('29', 'tommy', 'shawn');
