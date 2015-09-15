/*
Navicat MySQL Data Transfer

Source Server         : LOCAL
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : ustc

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2015-09-10 14:24:03
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_alarm_detail
-- ----------------------------
DROP TABLE IF EXISTS `tb_alarm_detail`;
CREATE TABLE `tb_alarm_detail` (
  `AlarmId` int(11) NOT NULL AUTO_INCREMENT,
  `DevId` int(11) DEFAULT NULL,
  `AlarmLevel` int(11) DEFAULT NULL,
  `AlarmContent` varchar(120) DEFAULT NULL,
  `AlarmLocation` float DEFAULT NULL,
  `AlarmTime` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`AlarmId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_alarm_detail
-- ----------------------------
INSERT INTO `tb_alarm_detail` VALUES ('1', '39', '1', '沪北监控中心 蒙自光纤 发生1级告警 故障点：39.520公里处，损耗值8.56DB', '39.52', '2012-03-30 11:08:10', '1');
INSERT INTO `tb_alarm_detail` VALUES ('2', '39', '3', '沪北监控中心 蒙自光纤 发生3级告警 故障点：39.572公里处，损耗值1.19DB', '39.572', '2012-03-30 13:14:10', '1');
INSERT INTO `tb_alarm_detail` VALUES ('3', '39', '2', '沪北监控中心 蒙自光纤 发生2级告警 故障点：39.498公里处，损耗值3.22DB', '39.498', '2012-03-30 15:22:10', '1');
INSERT INTO `tb_alarm_detail` VALUES ('4', '40', '1', '沪北监控中心 宝山光纤 发生1级告警 故障点：23.045公里处，损耗值8.216DB', '23.045', '2012-04-01 10:42:10', '1');
INSERT INTO `tb_alarm_detail` VALUES ('5', '40', '3', '沪北监控中心 宝山光纤 发生3级告警 故障点：23.108公里处，损耗值1.58DB', '23.108', '2012-04-01 12:28:10', '1');
INSERT INTO `tb_alarm_detail` VALUES ('6', '40', '2', '沪北监控中心 宝山光纤 发生2级告警 故障点：23.078公里处，损耗值3.63DB', '23.078', '2012-04-01 14:42:10', '1');
INSERT INTO `tb_alarm_detail` VALUES ('7', '40', '3', '沪北监控中心 宝山光纤 发生3级告警 故障点：23.089公里处，损耗值1.45DB', '23.089', '2012-04-01 15:33:10', '1');
INSERT INTO `tb_alarm_detail` VALUES ('8', '40', '3', '沪北监控中心 宝山光纤 发生3级告警 故障点：23.117公里处，损耗值1.38DB', '23.117', '2012-04-01 16:48:10', '1');

-- ----------------------------
-- Table structure for tb_fiber_len
-- ----------------------------
DROP TABLE IF EXISTS `tb_fiber_len`;
CREATE TABLE `tb_fiber_len` (
  `ParamId` int(11) NOT NULL AUTO_INCREMENT,
  `DevId` int(11) DEFAULT NULL,
  `FiberLen` float DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`ParamId`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_fiber_len
-- ----------------------------
INSERT INTO `tb_fiber_len` VALUES ('1', '39', '60', '1');
INSERT INTO `tb_fiber_len` VALUES ('2', '40', '45', '1');
