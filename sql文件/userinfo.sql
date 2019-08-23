/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : userinfo

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-08-23 11:28:34
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
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

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
INSERT INTO `chatroomlist2` VALUES ('42', '2019-08-22-23-03-35-04.gif', 'tongxinjie123', 'tommy', '2019-08-22 23:03:35', '0', '0');

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

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` smallint(6) NOT NULL,
  `login_name` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `wechat_id` varchar(30) NOT NULL,
  `avatar` varchar(200) NOT NULL,
  `groups` varchar(10) NOT NULL,
  `location` varchar(30) NOT NULL,
  PRIMARY KEY (`id`,`wechat_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '童心洁', '123', 'tongxinjie123', 'me.jpg', 'T', 'China');
INSERT INTO `user` VALUES ('2', 'Tom', '123', 'tommy', 'tom.jpg', 'T', 'USA');
INSERT INTO `user` VALUES ('3', 'Jerry', '111', 'jerry', 'jerry.jpg', 'J', 'China');
INSERT INTO `user` VALUES ('4', 'Angrybird', '111', 'birdy', 'bird.jpg', 'A', 'USA');
INSERT INTO `user` VALUES ('5', 'Buzz', '111', 'buzz', 'buzz.jpg', 'B', 'Japan');
INSERT INTO `user` VALUES ('6', 'Captain', '111', 'steve', 'steve.jpg', 'C', 'Japan');
INSERT INTO `user` VALUES ('7', 'Cinderella', '111', 'ella', 'ella.jpg', 'C', 'China');
INSERT INTO `user` VALUES ('8', 'Daisy', '111', 'daisy', 'daisy.jpg', 'D', 'USA');
INSERT INTO `user` VALUES ('9', 'Donald', '111', 'donald', 'donald.jpg', 'D', 'Japan');
INSERT INTO `user` VALUES ('10', 'Frog', '111', 'travelFrog', 'frog.jpg', 'F', 'China');
INSERT INTO `user` VALUES ('11', 'Hulk', '111', 'hulk_hulk', 'hulk.jpg', 'H', 'USA');
INSERT INTO `user` VALUES ('12', 'Mickey', '111', 'mickey', 'mickey.jpg', 'M', 'China');
INSERT INTO `user` VALUES ('13', 'Minnie', '111', 'minnie', 'minnie.jpg', 'M', 'China');
INSERT INTO `user` VALUES ('14', 'Peppa', '111', 'peppa', 'peppa.jpg', 'P', 'USA');
INSERT INTO `user` VALUES ('15', 'Piggy', '111', 'piggy', 'pig.jpg', 'P', 'France');
INSERT INTO `user` VALUES ('16', 'Piglet', '111', 'piglet', 'piglet.jpg', 'P', 'Japan');
INSERT INTO `user` VALUES ('17', 'Pikachu', '111', 'pikapika', 'pikachu.jpg', 'P', 'France');
INSERT INTO `user` VALUES ('18', 'Shawn', '111', 'shawn', 'shawn.jpg', 'S', 'USA');
INSERT INTO `user` VALUES ('20', 'Ted', '111', 'teddy', 'ted.jpg', 'T', 'France');
INSERT INTO `user` VALUES ('21', 'Tiger', '111', 'tiger', 'tiger.jpg', 'T', 'China');
INSERT INTO `user` VALUES ('22', 'Winnie', '111', 'winnie', 'winnie.jpg', 'W', 'France');
INSERT INTO `user` VALUES ('23', 'Bugs', '111', 'bugsbunny', 'bugs.jpg', 'B', 'France');
INSERT INTO `user` VALUES ('24', 'Speike', '111', 'speike', 'speike.jpg', 'S', 'France');
INSERT INTO `user` VALUES ('25', 'Doggy', '111', 'doggy', 'dog.jpg', 'D', 'China');
INSERT INTO `user` VALUES ('26', 'Snow', '111', 'snowWhite', 'snow.jpg', 'S', 'China');
