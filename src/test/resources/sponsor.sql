/*
Navicat MySQL Data Transfer

Source Server         : Localhost
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2017-06-23 14:25:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `sponsor`;
CREATE TABLE `sponsor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` int(1) NOT NULL,
  `name` varchar(255) NOT NULL,
  `brief` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `imgUrl` varchar(255) DEFAULT NUll,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `sponsor` VALUES ('1', '0', '谷歌', 'this is brief google', 'this is detail google, detail detail detail detail detail detail detail detail detail','http://ucsdcssa.org/wp-content/uploads/2018/01/unnamed-file.png');
INSERT INTO `sponsor` VALUES ('2', '0', '微软', 'this is brief 微软', 'this is detail 微软, detail detail detail detail detail detail detail detail detail','http://ucsdcssa.org/wp-content/uploads/2018/01/Melody.png');
INSERT INTO `sponsor` VALUES ('3', '0', 'Facebook', 'this is brief Facebook', 'this is detail Facebook, detail detail detail detail detail detail detail detail detail','http://ucsdcssa.org/wp-content/uploads/2018/01/Melody.png');
INSERT INTO `sponsor` VALUES ('4', '1', 'twitter', 'this is brief twitter', 'this is detail twitter, detail detail detail detail detail detail detail detail detail','http://ucsdcssa.org/wp-content/uploads/2018/01/unnamed-file.png');
INSERT INTO `sponsor` VALUES ('5', '1', '腾讯', 'this is brief 腾讯', 'this is detail 腾讯, detail detail detail detail detail detail detail detail detail','http://ucsdcssa.org/wp-content/uploads/2018/01/unnamed-file.png');
INSERT INTO `sponsor` VALUES ('6', '2', '阿里巴巴', 'this is brief 阿里巴巴', 'this is detail 阿里巴巴, detail detail detail detail detail detail detail detail detail','http://ucsdcssa.org/wp-content/uploads/2018/01/Melody.png');
INSERT INTO `sponsor` VALUES ('7', '2', '京东', 'this is brief 京东', 'this is detail 京东, detail detail detail detail detail detail detail detail detail','http://ucsdcssa.org/wp-content/uploads/2018/01/unnamed-file.png');
INSERT INTO `sponsor` VALUES ('8', '2', '百度', 'this is brief 百度', 'this is detail 百度, detail detail detail detail detail detail detail detail detail','http://ucsdcssa.org/wp-content/uploads/2018/01/Melody.png');
INSERT INTO `sponsor` VALUES ('9', '2', '今日头条', 'this is brief 今日头条', 'this is detail 今日头条, detail detail detail detail detail detail detail detail detail','http://ucsdcssa.org/wp-content/uploads/2018/01/Melody.png');
INSERT INTO `sponsor` VALUES ('10', '2', '搜狐', 'this is brief 搜狐', 'this is detail 搜狐, detail detail detail detail detail detail detail detail detail','http://ucsdcssa.org/wp-content/uploads/2018/01/unnamed-file.png');
SET FOREIGN_KEY_CHECKS=1;
