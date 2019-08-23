/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : userinfo

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-08-23 00:14:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `momentslist`
-- ----------------------------
DROP TABLE IF EXISTS `momentslist`;
CREATE TABLE `momentslist` (
  `id` int(11) NOT NULL,
  `wechatid` varchar(30) NOT NULL,
  `context` varchar(255) NOT NULL,
  `album` varchar(255) NOT NULL,
  `host` varchar(30) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of momentslist
-- ----------------------------
INSERT INTO `momentslist` VALUES ('1', 'doggy', 'I love HotDog!', '', 'tongxinjie123', '2019-07-31 07:39:45');
INSERT INTO `momentslist` VALUES ('2', 'birdy', 'Such a bad weather!', '../../../static/朋友圈/bird.jpg', 'tongxinjie123', '2019-07-31 15:16:52');
INSERT INTO `momentslist` VALUES ('3', 'mickey', 'Let\'s go to the party!', '../../../static/朋友圈/mickey.jpg', 'tongxinjie123', '2019-07-31 15:26:46');
INSERT INTO `momentslist` VALUES ('4', 'winnie', 'Honey~Honey~', '', 'tongxinjie123', '2019-07-30 09:40:13');
INSERT INTO `momentslist` VALUES ('5', 'piggy', 'Have a nice day~', '../../../static/朋友圈/pig.jpg', 'tongxinjie123', '2019-07-31 15:06:57');
INSERT INTO `momentslist` VALUES ('6', 'jerry', 'I love cheeeeeese', '', 'tongxinjie123', '2019-07-31 07:40:26');
INSERT INTO `momentslist` VALUES ('7', 'tommy', 'I am hungry! Where is Jerry?', '', 'tongxinjie123', '2019-07-31 08:40:33');
INSERT INTO `momentslist` VALUES ('8', 'tommy', 'I am hungry! Where is Jerry?', '', 'tommy', '2019-07-31 08:40:33');
INSERT INTO `momentslist` VALUES ('9', 'bugsbunny', 'I like carrots !', '', 'tommy', '2019-08-01 13:23:33');
INSERT INTO `momentslist` VALUES ('10', 'speike', 'Where is my bone ? ', '', 'tommy', '2019-08-01 13:24:11');
