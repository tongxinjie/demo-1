/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : userinfo

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2019-08-23 00:14:28
*/

SET FOREIGN_KEY_CHECKS=0;

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
