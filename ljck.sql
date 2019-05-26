/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : ljck

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-12-16 14:52:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for baocun
-- ----------------------------
DROP TABLE IF EXISTS `baocun`;
CREATE TABLE `baocun` (
  `ljnum` char(20) NOT NULL,
  `cknum` char(10) NOT NULL,
  `ljsl` int(11) NOT NULL,
  KEY `baocun_ibfk_1` (`ljnum`),
  KEY `baocun_ibfk_2` (`cknum`),
  CONSTRAINT `baocun_ibfk_1` FOREIGN KEY (`ljnum`) REFERENCES `lingjian` (`ljnum`),
  CONSTRAINT `baocun_ibfk_2` FOREIGN KEY (`cknum`) REFERENCES `cangku` (`cknum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of baocun
-- ----------------------------
INSERT INTO `baocun` VALUES ('1', '1', '100');
INSERT INTO `baocun` VALUES ('2', '1', '100');

-- ----------------------------
-- Table structure for baoguanyuan
-- ----------------------------
DROP TABLE IF EXISTS `baoguanyuan`;
CREATE TABLE `baoguanyuan` (
  `baonum` char(20) NOT NULL,
  `baoname` char(20) NOT NULL,
  `cknum` char(20) DEFAULT NULL,
  PRIMARY KEY (`baonum`),
  KEY `cknum` (`cknum`),
  CONSTRAINT `baoguanyuan_ibfk_1` FOREIGN KEY (`cknum`) REFERENCES `cangku` (`cknum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of baoguanyuan
-- ----------------------------
INSERT INTO `baoguanyuan` VALUES ('1', '张三', '1');
INSERT INTO `baoguanyuan` VALUES ('2', '李四', '2');
INSERT INTO `baoguanyuan` VALUES ('3', '王五', '1');

-- ----------------------------
-- Table structure for cangku
-- ----------------------------
DROP TABLE IF EXISTS `cangku`;
CREATE TABLE `cangku` (
  `cknum` char(10) NOT NULL,
  `ckname` char(10) DEFAULT NULL,
  PRIMARY KEY (`cknum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cangku
-- ----------------------------
INSERT INTO `cangku` VALUES ('1', '主要仓库1');
INSERT INTO `cangku` VALUES ('2', '主要仓库2');
INSERT INTO `cangku` VALUES ('3', '主要仓库3');

-- ----------------------------
-- Table structure for lingjian
-- ----------------------------
DROP TABLE IF EXISTS `lingjian`;
CREATE TABLE `lingjian` (
  `ljnum` char(20) NOT NULL,
  `ljname` char(20) DEFAULT NULL,
  PRIMARY KEY (`ljnum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lingjian
-- ----------------------------
INSERT INTO `lingjian` VALUES ('1', '零件1');
INSERT INTO `lingjian` VALUES ('2', '零件2');
INSERT INTO `lingjian` VALUES ('3', '零件3');
