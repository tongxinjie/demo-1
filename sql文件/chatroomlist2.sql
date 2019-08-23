/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : userinfo

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-08-23 00:14:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `chatroomlist2`
-- ----------------------------
DROP TABLE IF EXISTS `chatroomlist2`;
CREATE TABLE `chatroomlist2` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `msg` varchar(300) DEFAULT NULL,
  `frommsg` varchar(30) DEFAULT NULL,
  `tomsg` varchar(30) DEFAULT NULL,
  `time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `text` int(11) DEFAULT NULL,
  `unread` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chatroomlist2
-- ----------------------------
INSERT INTO `chatroomlist2` VALUES ('1', 'hi', 'tommy', 'bugsbunny', '2019-08-22 22:06:44', '1', '1');
INSERT INTO `chatroomlist2` VALUES ('2', 'hello', 'tongxinjie123', 'jerry', '2019-08-22 22:07:58', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('3', '很高兴认识你~', 'tongxinjie123', 'jerry', '2019-08-22 22:08:21', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('4', '你好呀', 'tongxinjie123', 'buzz', '2019-08-22 22:08:35', '1', '1');
INSERT INTO `chatroomlist2` VALUES ('5', '2019-08-22-22-13-04-bird.jpg', 'tongxinjie123', 'buzz', '2019-08-22 22:13:04', '0', '1');
INSERT INTO `chatroomlist2` VALUES ('6', '哈哈', 'tongxinjie123', 'buzz', '2019-08-22 22:13:57', '1', '1');
INSERT INTO `chatroomlist2` VALUES ('7', '2019-08-22-22-14-18-pig.jpg', 'tongxinjie123', 'buzz', '2019-08-22 22:14:18', '0', '1');
INSERT INTO `chatroomlist2` VALUES ('8', '啦啦啦', 'tongxinjie123', 'birdy', '2019-08-22 22:16:35', '1', '1');
INSERT INTO `chatroomlist2` VALUES ('9', '晚上6点一起去吃饭吧？', 'tongxinjie123', 'tommy', '2019-08-22 22:19:49', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('10', '好呀', 'tommy', 'tongxinjie123', '2019-08-22 22:20:39', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('11', '通知jerry了么？', 'tommy', 'tongxinjie123', '2019-08-22 22:21:21', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('12', '我问问他', 'tongxinjie123', 'tommy', '2019-08-22 22:21:48', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('13', '好的', 'tommy', 'tongxinjie123', '2019-08-22 22:21:53', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('14', '2019-08-22-22-23-41-crayon.jpg', 'tommy', 'tongxinjie123', '2019-08-22 22:23:41', '0', '0');
INSERT INTO `chatroomlist2` VALUES ('15', '今晚6点有空么？', 'tongxinjie123', 'jerry', '2019-08-22 22:24:10', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('16', '有空呀', 'jerry', 'tongxinjie123', '2019-08-22 22:24:38', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('17', '什么事？', 'jerry', 'tongxinjie123', '2019-08-22 22:24:42', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('18', '我和tom约了一起吃饭，有空的话一起来吧~', 'tongxinjie123', 'jerry', '2019-08-22 22:25:07', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('19', '好的~', 'jerry', 'tongxinjie123', '2019-08-22 22:25:14', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('20', '已经通知jerry了，晚上见~', 'tongxinjie123', 'tommy', '2019-08-22 22:25:41', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('21', 'ok~', 'tommy', 'tongxinjie123', '2019-08-22 22:25:53', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('22', '晚上见~', 'tommy', 'tongxinjie123', '2019-08-22 22:26:26', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('23', '2019-08-22-22-26-47-bo.jpg', 'tommy', 'tongxinjie123', '2019-08-22 22:26:47', '0', '0');
INSERT INTO `chatroomlist2` VALUES ('24', '2019-08-22-22-35-38-01.gif', 'tongxinjie123', 'tommy', '2019-08-22 22:35:38', '0', '0');
INSERT INTO `chatroomlist2` VALUES ('26', '2019-08-22-22-45-15-05.gif', 'jerry', 'tongxinjie123', '2019-08-22 22:45:15', '0', '0');
INSERT INTO `chatroomlist2` VALUES ('29', '2019-08-22-22-50-51-06.gif', 'jerry', 'tongxinjie123', '2019-08-22 22:50:51', '0', '0');
INSERT INTO `chatroomlist2` VALUES ('30', '抱歉', 'jerry', 'tongxinjie123', '2019-08-22 22:55:02', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('31', '今晚临时有事', 'jerry', 'tongxinjie123', '2019-08-22 22:55:24', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('32', '不能和你们吃饭了', 'jerry', 'tongxinjie123', '2019-08-22 22:56:11', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('33', '我们下次再约吧？', 'jerry', 'tongxinjie123', '2019-08-22 22:58:41', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('34', '好的~', 'tongxinjie123', 'jerry', '2019-08-22 22:58:49', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('35', '没关系~', 'tongxinjie123', 'jerry', '2019-08-22 22:58:55', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('36', '2019-08-22-22-59-35-04.gif', 'jerry', 'tongxinjie123', '2019-08-22 22:59:35', '0', '0');
INSERT INTO `chatroomlist2` VALUES ('37', '哈哈', 'tommy', 'tongxinjie123', '2019-08-22 23:01:10', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('38', '哈哈', 'tommy', 'tongxinjie123', '2019-08-22 23:01:19', '1', '0');
INSERT INTO `chatroomlist2` VALUES ('39', '2019-08-22-23-01-25-07.gif', 'tommy', 'tongxinjie123', '2019-08-22 23:01:25', '0', '0');
INSERT INTO `chatroomlist2` VALUES ('40', '2019-08-22-23-03-08-02.gif', 'tongxinjie123', 'tommy', '2019-08-22 23:03:08', '0', '1');
INSERT INTO `chatroomlist2` VALUES ('41', '2019-08-22-23-03-14-05.gif', 'tongxinjie123', 'tommy', '2019-08-22 23:03:14', '0', '1');
INSERT INTO `chatroomlist2` VALUES ('42', '2019-08-22-23-03-35-04.gif', 'tongxinjie123', 'tommy', '2019-08-22 23:03:35', '0', '1');
