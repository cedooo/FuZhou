-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        5.6.23-enterprise-commercial-advanced-log - MySQL Enterprise Server - Advanced Edition (Commercial)
-- 服务器操作系统:                      Win32
-- HeidiSQL 版本:                  9.1.0.4867
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 导出 fuzhoudianyeju 的数据库结构
CREATE DATABASE IF NOT EXISTS `fuzhoudianyeju` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `fuzhoudianyeju`;


-- 导出  表 fuzhoudianyeju.a_cable 结构
CREATE TABLE IF NOT EXISTS `a_cable` (
  `cableId` int(11) NOT NULL AUTO_INCREMENT,
  `cableName` varchar(255) NOT NULL,
  `cableStartId` int(11) DEFAULT NULL,
  `cableEndId` int(11) DEFAULT NULL,
  `isMainRoad` char(10) NOT NULL,
  `cableType` char(10) DEFAULT NULL,
  `cableLength` char(10) DEFAULT NULL,
  `fiberId` int(11) DEFAULT NULL,
  `layingType` varchar(255) DEFAULT NULL,
  `runTime` char(50) DEFAULT NULL,
  `constructionUnitId` int(11) DEFAULT NULL,
  `bizType` char(10) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cableId`),
  UNIQUE KEY `Index_cable` (`cableName`),
  KEY `FK_refer_cable_constructionUnit` (`constructionUnitId`),
  KEY `FK_refer_cable_fiber` (`fiberId`),
  KEY `FK_refer_cable_siteEnd` (`cableEndId`),
  KEY `FK_refer_cable_siteStart` (`cableStartId`),
  CONSTRAINT `FK_refer_cable_constructionUnit` FOREIGN KEY (`constructionUnitId`) REFERENCES `b_constructionunit` (`constructionUnitId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_cable_fiber` FOREIGN KEY (`fiberId`) REFERENCES `b_fiber` (`fiberId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_cable_siteEnd` FOREIGN KEY (`cableEndId`) REFERENCES `a_site` (`siteId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_cable_siteStart` FOREIGN KEY (`cableStartId`) REFERENCES `a_site` (`siteId`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='应用--光缆表';

-- 正在导出表  fuzhoudianyeju.a_cable 的数据：~2 rows (大约)
DELETE FROM `a_cable`;
/*!40000 ALTER TABLE `a_cable` DISABLE KEYS */;
INSERT INTO `a_cable` (`cableId`, `cableName`, `cableStartId`, `cableEndId`, `isMainRoad`, `cableType`, `cableLength`, `fiberId`, `layingType`, `runTime`, `constructionUnitId`, `bizType`, `delFlg`, `descp`) VALUES
	(1, '台江站点1-新建站点2-1', 1, 2, '是', '', '', 1, '', '', 1, '', '启用', ''),
	(2, '台江站点1-晋安A1-1', 1, 3, '否', '', '', 1, '', '', 1, '', '启用', '');
/*!40000 ALTER TABLE `a_cable` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.a_carrier 结构
CREATE TABLE IF NOT EXISTS `a_carrier` (
  `carrierId` int(11) NOT NULL AUTO_INCREMENT,
  `carrierName` varchar(255) NOT NULL,
  `siteId` int(11) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `installationSite` varchar(255) DEFAULT NULL,
  `debugging` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `manufacturersId` int(11) DEFAULT NULL,
  `typeSpecification` varchar(255) DEFAULT NULL,
  `constructionUnitId` int(11) DEFAULT NULL,
  `runTime` varchar(255) DEFAULT NULL,
  `installationLocation` varchar(255) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`carrierId`),
  UNIQUE KEY `Index_carrier` (`carrierName`),
  KEY `FK_refer_carrier_constructionUnit` (`constructionUnitId`),
  KEY `FK_refer_carrier_manufacturers` (`manufacturersId`),
  KEY `FK_refer_carrier_project` (`projectId`),
  KEY `FK_refer_carrier_site` (`siteId`),
  CONSTRAINT `FK_refer_carrier_constructionUnit` FOREIGN KEY (`constructionUnitId`) REFERENCES `b_constructionunit` (`constructionUnitId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_carrier_manufacturers` FOREIGN KEY (`manufacturersId`) REFERENCES `b_manufacturers` (`manufacturersId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_carrier_project` FOREIGN KEY (`projectId`) REFERENCES `b_project` (`projectId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_carrier_site` FOREIGN KEY (`siteId`) REFERENCES `a_site` (`siteId`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='应用--载波表';

-- 正在导出表  fuzhoudianyeju.a_carrier 的数据：~4 rows (大约)
DELETE FROM `a_carrier`;
/*!40000 ALTER TABLE `a_carrier` DISABLE KEYS */;
INSERT INTO `a_carrier` (`carrierId`, `carrierName`, `siteId`, `projectId`, `installationSite`, `debugging`, `ip`, `manufacturersId`, `typeSpecification`, `constructionUnitId`, `runTime`, `installationLocation`, `delFlg`, `descp`) VALUES
	(1, '载波1', 2, 1, '', '', '', 1, '', 1, '', '', '启用', ''),
	(2, '载波2', NULL, 24, '', '', '', 3, '', 1, '', '', '启用', ''),
	(3, '载波3', NULL, 24, '', '', '', 3, '', 1, '', '', '启用', ''),
	(4, '载波4', NULL, 24, '', '', '', 3, '', 1, '', '', '启用', '');
/*!40000 ALTER TABLE `a_carrier` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.a_fibercorenumber 结构
CREATE TABLE IF NOT EXISTS `a_fibercorenumber` (
  `fiberCoreNumberId` int(11) NOT NULL AUTO_INCREMENT,
  `fiberCoreNumberName` varchar(255) NOT NULL,
  `cableId` int(11) DEFAULT NULL,
  `isUsed` char(10) DEFAULT NULL,
  `isJump` char(10) DEFAULT NULL,
  `bizType` char(10) DEFAULT NULL,
  `transceiver` char(10) DEFAULT NULL,
  `startConnections` char(255) DEFAULT NULL,
  `endConnections` char(255) DEFAULT NULL,
  `delFlg` char(10) DEFAULT NULL,
  `descp` char(10) DEFAULT NULL,
  PRIMARY KEY (`fiberCoreNumberId`),
  UNIQUE KEY `Index_fiberCoreNumber` (`fiberCoreNumberName`,`cableId`),
  KEY `FK_refer_fiberCoreNumber_cable` (`cableId`),
  CONSTRAINT `FK_refer_fiberCoreNumber_cable` FOREIGN KEY (`cableId`) REFERENCES `a_cable` (`cableId`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=422 DEFAULT CHARSET=utf8;

-- 正在导出表  fuzhoudianyeju.a_fibercorenumber 的数据：~48 rows (大约)
DELETE FROM `a_fibercorenumber`;
/*!40000 ALTER TABLE `a_fibercorenumber` DISABLE KEYS */;
INSERT INTO `a_fibercorenumber` (`fiberCoreNumberId`, `fiberCoreNumberName`, `cableId`, `isUsed`, `isJump`, `bizType`, `transceiver`, `startConnections`, `endConnections`, `delFlg`, `descp`) VALUES
	(374, '纤芯1', 1, '是', '是', '配电', '', '{"deviceId":"1","deviceType":"二层交换机","deviceName":"站点1-2层交换机"}', '{"deviceId":"1","deviceType":"载波","deviceName":"载波1"}', '启用', ''),
	(375, '纤芯2', 1, '是', '是', '用电', '', '{"deviceId":"1","deviceType":"olt","deviceName":"olt1"}', '{"deviceId":"2","deviceType":"olt","deviceName":"olt2"}', '启用', ''),
	(376, '纤芯3', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(377, '纤芯4', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(378, '纤芯5', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(379, '纤芯6', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(380, '纤芯7', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(381, '纤芯8', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(382, '纤芯9', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(383, '纤芯10', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(384, '纤芯11', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(385, '纤芯12', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(386, '纤芯13', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(387, '纤芯14', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(388, '纤芯15', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(389, '纤芯16', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(390, '纤芯17', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(391, '纤芯18', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(392, '纤芯19', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(393, '纤芯20', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(394, '纤芯21', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(395, '纤芯22', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(396, '纤芯23', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(397, '纤芯24', 1, '', '', '', '', '{}', '{}', '启用', ''),
	(398, '纤芯1', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(399, '纤芯2', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(400, '纤芯3', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(401, '纤芯4', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(402, '纤芯5', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(403, '纤芯6', 2, '是', '否', '用电', '', '{}', '{}', '启用', ''),
	(404, '纤芯7', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(405, '纤芯8', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(406, '纤芯9', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(407, '纤芯10', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(408, '纤芯11', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(409, '纤芯12', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(410, '纤芯13', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(411, '纤芯14', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(412, '纤芯15', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(413, '纤芯16', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(414, '纤芯17', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(415, '纤芯18', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(416, '纤芯19', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(417, '纤芯20', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(418, '纤芯21', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(419, '纤芯22', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(420, '纤芯23', 2, '', '', '', '', '{}', '{}', '启用', ''),
	(421, '纤芯24', 2, '', '', '', '', '{}', '{}', '启用', '');
/*!40000 ALTER TABLE `a_fibercorenumber` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.a_gprs 结构
CREATE TABLE IF NOT EXISTS `a_gprs` (
  `gprsId` int(11) NOT NULL AUTO_INCREMENT,
  `gprsName` varchar(255) NOT NULL,
  `siteId` int(11) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `installationSite` varchar(255) DEFAULT NULL,
  `debugging` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `cardNumber` varchar(255) DEFAULT NULL,
  `operators` varchar(255) DEFAULT NULL,
  `technologyType` varchar(255) DEFAULT NULL,
  `manufacturersId` int(11) DEFAULT NULL,
  `typeSpecification` varchar(255) DEFAULT NULL,
  `constructionUnitId` int(11) DEFAULT NULL,
  `runTime` char(50) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`gprsId`),
  UNIQUE KEY `Index_gprs` (`gprsName`),
  KEY `FK_refer_gprs_constructionUnit` (`constructionUnitId`),
  KEY `FK_refer_gprs_manufacturers` (`manufacturersId`),
  KEY `FK_refer_gprs_project` (`projectId`),
  KEY `FK_refer_grps_site` (`siteId`),
  CONSTRAINT `FK_refer_gprs_constructionUnit` FOREIGN KEY (`constructionUnitId`) REFERENCES `b_constructionunit` (`constructionUnitId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_refer_gprs_manufacturers` FOREIGN KEY (`manufacturersId`) REFERENCES `b_manufacturers` (`manufacturersId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_gprs_project` FOREIGN KEY (`projectId`) REFERENCES `b_project` (`projectId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_refer_grps_site` FOREIGN KEY (`siteId`) REFERENCES `a_site` (`siteId`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='应用--GPRS无线表';

-- 正在导出表  fuzhoudianyeju.a_gprs 的数据：~4 rows (大约)
DELETE FROM `a_gprs`;
/*!40000 ALTER TABLE `a_gprs` DISABLE KEYS */;
INSERT INTO `a_gprs` (`gprsId`, `gprsName`, `siteId`, `projectId`, `installationSite`, `debugging`, `ip`, `cardNumber`, `operators`, `technologyType`, `manufacturersId`, `typeSpecification`, `constructionUnitId`, `runTime`, `delFlg`, `descp`) VALUES
	(1, 'gprs1', 1, 1, '', '', '', '', '', '', 1, '', 1, '2015-03-16', '启用', ''),
	(2, 'gprs2', NULL, NULL, '', '', '', '', '', '', NULL, '', 1, '', '启用', ''),
	(3, 'gprs3', NULL, NULL, '', '', '', '', '', '', NULL, '', 1, '', '启用', ''),
	(4, 'gprs4', NULL, NULL, '', '', '', '', '', '', NULL, '', 1, '', '启用', '');
/*!40000 ALTER TABLE `a_gprs` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.a_olt 结构
CREATE TABLE IF NOT EXISTS `a_olt` (
  `oltId` int(11) NOT NULL AUTO_INCREMENT,
  `oltName` varchar(255) NOT NULL,
  `siteId` int(11) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `installationSite` varchar(255) DEFAULT NULL,
  `manufacturersId` int(11) DEFAULT NULL,
  `typeSpecification` varchar(255) DEFAULT NULL,
  `constructionUnitId` int(11) DEFAULT NULL,
  `runTime` varchar(255) DEFAULT NULL,
  `vlanId` varchar(255) DEFAULT NULL,
  `lookbackLocation` varchar(255) DEFAULT NULL,
  `ospfNumber` varchar(255) DEFAULT NULL,
  `vpnNumber` varchar(255) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oltId`),
  UNIQUE KEY `Index_olt` (`oltName`),
  KEY `FK_refer_olt_constructionUnit` (`constructionUnitId`),
  KEY `FK_refer_olt_manufacturers` (`manufacturersId`),
  KEY `FK_refer_olt_project` (`projectId`),
  KEY `FK_refer_olt_site` (`siteId`),
  CONSTRAINT `FK_refer_olt_constructionUnit` FOREIGN KEY (`constructionUnitId`) REFERENCES `b_constructionunit` (`constructionUnitId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_refer_olt_manufacturers` FOREIGN KEY (`manufacturersId`) REFERENCES `b_manufacturers` (`manufacturersId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_olt_project` FOREIGN KEY (`projectId`) REFERENCES `b_project` (`projectId`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `FK_refer_olt_site` FOREIGN KEY (`siteId`) REFERENCES `a_site` (`siteId`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='应用--OLT表';

-- 正在导出表  fuzhoudianyeju.a_olt 的数据：~4 rows (大约)
DELETE FROM `a_olt`;
/*!40000 ALTER TABLE `a_olt` DISABLE KEYS */;
INSERT INTO `a_olt` (`oltId`, `oltName`, `siteId`, `projectId`, `installationSite`, `manufacturersId`, `typeSpecification`, `constructionUnitId`, `runTime`, `vlanId`, `lookbackLocation`, `ospfNumber`, `vpnNumber`, `delFlg`, `descp`) VALUES
	(1, 'olt1', 1, 1, '', 1, '', 1, '', '', '', '', '', '启用', ''),
	(2, 'olt2', 2, 1, '', 1, '', 1, '', '', '', '', '', '启用', ''),
	(3, 'olt3', NULL, NULL, '', NULL, '', 1, '', '', '', '', '', '启用', ''),
	(4, 'olt4', NULL, NULL, '', NULL, '', 1, '', '', '', '', '', '启用', '');
/*!40000 ALTER TABLE `a_olt` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.a_onu 结构
CREATE TABLE IF NOT EXISTS `a_onu` (
  `onuId` int(11) NOT NULL AUTO_INCREMENT,
  `onuName` varchar(255) NOT NULL,
  `siteId` int(11) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `installationSite` varchar(255) DEFAULT NULL,
  `manufacturersId` int(11) DEFAULT NULL,
  `typeSpecification` varchar(255) DEFAULT NULL,
  `constructionUnitId` int(11) DEFAULT NULL,
  `runTime` varchar(255) DEFAULT NULL,
  `vlanId` varchar(255) DEFAULT NULL,
  `ospfNumber` varchar(255) DEFAULT NULL,
  `vpnNumber` varchar(255) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`onuId`),
  UNIQUE KEY `Index_onu` (`onuName`),
  KEY `FK_refer_onu_constructionUnit` (`constructionUnitId`),
  KEY `FK_refer_onu_manufacturers` (`manufacturersId`),
  KEY `FK_refer_onu_project` (`projectId`),
  KEY `FK_refer_onu_site` (`siteId`),
  CONSTRAINT `FK_refer_onu_constructionUnit` FOREIGN KEY (`constructionUnitId`) REFERENCES `b_constructionunit` (`constructionUnitId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_onu_manufacturers` FOREIGN KEY (`manufacturersId`) REFERENCES `b_manufacturers` (`manufacturersId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_onu_project` FOREIGN KEY (`projectId`) REFERENCES `b_project` (`projectId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_onu_site` FOREIGN KEY (`siteId`) REFERENCES `a_site` (`siteId`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用--ONU表';

-- 正在导出表  fuzhoudianyeju.a_onu 的数据：~0 rows (大约)
DELETE FROM `a_onu`;
/*!40000 ALTER TABLE `a_onu` DISABLE KEYS */;
/*!40000 ALTER TABLE `a_onu` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.a_site 结构
CREATE TABLE IF NOT EXISTS `a_site` (
  `siteId` int(11) NOT NULL AUTO_INCREMENT,
  `siteName` varchar(255) NOT NULL,
  `areaId` int(11) DEFAULT NULL,
  `siteAdress` varchar(255) DEFAULT NULL,
  `connactName` varchar(255) DEFAULT NULL,
  `connactNumber` varchar(255) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`siteId`),
  UNIQUE KEY `Index_site` (`siteName`),
  KEY `FK_refer_area_site` (`areaId`),
  CONSTRAINT `FK_refer_area_site` FOREIGN KEY (`areaId`) REFERENCES `b_area` (`areaId`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='应用--站点表';

-- 正在导出表  fuzhoudianyeju.a_site 的数据：~3 rows (大约)
DELETE FROM `a_site`;
/*!40000 ALTER TABLE `a_site` DISABLE KEYS */;
INSERT INTO `a_site` (`siteId`, `siteName`, `areaId`, `siteAdress`, `connactName`, `connactNumber`, `delFlg`, `descp`) VALUES
	(1, '台江站点1', 1, 'test', 'testss', '12341234231', '启用', ''),
	(2, '台江站点A2', 1, '舒服撒', '撒旦法', '123435345345', '启用', ''),
	(3, '晋安A1', 4, '', '', '', '启用', '');
/*!40000 ALTER TABLE `a_site` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.a_threelayerswitch 结构
CREATE TABLE IF NOT EXISTS `a_threelayerswitch` (
  `threeLayerSwitchId` int(11) NOT NULL AUTO_INCREMENT,
  `threeLayerSwitchName` varchar(255) NOT NULL,
  `siteId` int(11) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `installationSite` varchar(255) DEFAULT NULL,
  `manufacturersId` int(11) DEFAULT NULL,
  `typeSpecification` varchar(255) DEFAULT NULL,
  `constructionUnitId` int(11) DEFAULT NULL,
  `runTime` varchar(255) DEFAULT NULL,
  `portNumber` varchar(255) DEFAULT NULL,
  `flow` varchar(255) DEFAULT NULL,
  `vlanId` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  `vlanDescp` varchar(255) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`threeLayerSwitchId`),
  UNIQUE KEY `Index_threeLlayerSwitch` (`threeLayerSwitchName`),
  KEY `FK_refer_threeLlayerSwitch_constructionUnit` (`constructionUnitId`),
  KEY `FK_refer_threeLlayerSwitch_manufacturers` (`manufacturersId`),
  KEY `FK_refer_threeLlayerSwitch_project` (`projectId`),
  KEY `FK_refer_threeLlayerSwitch_site` (`siteId`),
  CONSTRAINT `FK_refer_threeLlayerSwitch_constructionUnit` FOREIGN KEY (`constructionUnitId`) REFERENCES `b_constructionunit` (`constructionUnitId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_threeLlayerSwitch_manufacturers` FOREIGN KEY (`manufacturersId`) REFERENCES `b_manufacturers` (`manufacturersId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_threeLlayerSwitch_project` FOREIGN KEY (`projectId`) REFERENCES `b_project` (`projectId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_threeLlayerSwitch_site` FOREIGN KEY (`siteId`) REFERENCES `a_site` (`siteId`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='应用--三层交换机表';

-- 正在导出表  fuzhoudianyeju.a_threelayerswitch 的数据：~0 rows (大约)
DELETE FROM `a_threelayerswitch`;
/*!40000 ALTER TABLE `a_threelayerswitch` DISABLE KEYS */;
/*!40000 ALTER TABLE `a_threelayerswitch` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.a_twolayerswitch 结构
CREATE TABLE IF NOT EXISTS `a_twolayerswitch` (
  `twoLayerSwitchId` int(11) NOT NULL AUTO_INCREMENT,
  `twoLayerSwitchName` varchar(255) NOT NULL,
  `siteId` int(11) DEFAULT NULL,
  `projectId` int(11) DEFAULT NULL,
  `installationSite` varchar(255) DEFAULT NULL,
  `subNetwork` varchar(255) DEFAULT NULL,
  `debugging` varchar(255) DEFAULT NULL,
  `switchType` varchar(255) DEFAULT NULL,
  `manufacturersId` int(11) DEFAULT NULL,
  `typeSpecification` varchar(255) DEFAULT NULL,
  `vlanId` varchar(255) DEFAULT NULL,
  `portNumber` varchar(255) DEFAULT NULL,
  `flow` varchar(255) DEFAULT NULL,
  `ownedBusiness` varchar(255) DEFAULT NULL,
  `terminalName` varchar(255) DEFAULT NULL,
  `vlanDescp` varchar(255) DEFAULT NULL,
  `constructionUnitId` int(11) DEFAULT NULL,
  `runTime` char(50) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`twoLayerSwitchId`),
  UNIQUE KEY `Index_twoLayerSwitch` (`twoLayerSwitchName`),
  KEY `FK_refer_twoLayerSwitc_manufacturers` (`manufacturersId`),
  KEY `FK_refer_twoLayerSwitch_constructionUnit` (`constructionUnitId`),
  KEY `FK_refer_twoLayerSwitch_project` (`projectId`),
  KEY `FK_refer_twoLayerSwitch_site` (`siteId`),
  CONSTRAINT `FK_refer_twoLayerSwitc_manufacturers` FOREIGN KEY (`manufacturersId`) REFERENCES `b_manufacturers` (`manufacturersId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_twoLayerSwitch_constructionUnit` FOREIGN KEY (`constructionUnitId`) REFERENCES `b_constructionunit` (`constructionUnitId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_twoLayerSwitch_project` FOREIGN KEY (`projectId`) REFERENCES `b_project` (`projectId`) ON DELETE SET NULL,
  CONSTRAINT `FK_refer_twoLayerSwitch_site` FOREIGN KEY (`siteId`) REFERENCES `a_site` (`siteId`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='应用--二层交换机表';

-- 正在导出表  fuzhoudianyeju.a_twolayerswitch 的数据：~1 rows (大约)
DELETE FROM `a_twolayerswitch`;
/*!40000 ALTER TABLE `a_twolayerswitch` DISABLE KEYS */;
INSERT INTO `a_twolayerswitch` (`twoLayerSwitchId`, `twoLayerSwitchName`, `siteId`, `projectId`, `installationSite`, `subNetwork`, `debugging`, `switchType`, `manufacturersId`, `typeSpecification`, `vlanId`, `portNumber`, `flow`, `ownedBusiness`, `terminalName`, `vlanDescp`, `constructionUnitId`, `runTime`, `delFlg`, `descp`) VALUES
	(1, '站点1-2层交换机', 1, 1, '', '', '', '', 1, '', '', '', '', '', '', '', 1, '2015-03-23', '启用', '');
/*!40000 ALTER TABLE `a_twolayerswitch` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.b_area 结构
CREATE TABLE IF NOT EXISTS `b_area` (
  `areaId` int(11) NOT NULL AUTO_INCREMENT,
  `areaName` varchar(255) NOT NULL,
  `connactName` varchar(255) DEFAULT NULL,
  `connactNumber` varchar(255) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`areaId`),
  UNIQUE KEY `Index_area` (`areaName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='基础--区域表';

-- 正在导出表  fuzhoudianyeju.b_area 的数据：~4 rows (大约)
DELETE FROM `b_area`;
/*!40000 ALTER TABLE `b_area` DISABLE KEYS */;
INSERT INTO `b_area` (`areaId`, `areaName`, `connactName`, `connactNumber`, `delFlg`, `descp`) VALUES
	(1, '台江辖区', '陈东', '12312312312', '启用', ''),
	(2, '仓山辖区', '陈东', '12312312312', '启用', ''),
	(3, '马尾辖区', '', '', '启用', ''),
	(4, '晋安辖区', '', '', '启用', '');
/*!40000 ALTER TABLE `b_area` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.b_constructionunit 结构
CREATE TABLE IF NOT EXISTS `b_constructionunit` (
  `constructionUnitId` int(11) NOT NULL AUTO_INCREMENT,
  `constructionUnitName` varchar(255) NOT NULL,
  `connactName` varchar(255) DEFAULT NULL,
  `connactNumber` varchar(255) DEFAULT NULL,
  `constructionUnitAddress` varchar(255) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`constructionUnitId`),
  UNIQUE KEY `Index_constructionUnit` (`constructionUnitName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='基础--施工单位表';

-- 正在导出表  fuzhoudianyeju.b_constructionunit 的数据：~0 rows (大约)
DELETE FROM `b_constructionunit`;
/*!40000 ALTER TABLE `b_constructionunit` DISABLE KEYS */;
INSERT INTO `b_constructionunit` (`constructionUnitId`, `constructionUnitName`, `connactName`, `connactNumber`, `constructionUnitAddress`, `delFlg`, `descp`) VALUES
	(1, '东华软件', 'qwe', '123123123123', 'qweqw', '启用', '');
/*!40000 ALTER TABLE `b_constructionunit` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.b_fiber 结构
CREATE TABLE IF NOT EXISTS `b_fiber` (
  `fiberId` int(11) NOT NULL AUTO_INCREMENT,
  `fiberName` varchar(255) NOT NULL,
  `fiberCoreNumber` char(10) NOT NULL,
  `isUsed` char(10) DEFAULT NULL,
  `isJump` char(10) DEFAULT NULL,
  `bizType` char(10) DEFAULT NULL,
  `connections` varchar(255) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`fiberId`),
  UNIQUE KEY `Index_fiber` (`fiberName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='基础--光纤表';

-- 正在导出表  fuzhoudianyeju.b_fiber 的数据：~0 rows (大约)
DELETE FROM `b_fiber`;
/*!40000 ALTER TABLE `b_fiber` DISABLE KEYS */;
INSERT INTO `b_fiber` (`fiberId`, `fiberName`, `fiberCoreNumber`, `isUsed`, `isJump`, `bizType`, `connections`, `delFlg`, `descp`) VALUES
	(1, 'test光纤', '24', '是', '否', '配电', '', '启用', '');
/*!40000 ALTER TABLE `b_fiber` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.b_manufacturers 结构
CREATE TABLE IF NOT EXISTS `b_manufacturers` (
  `manufacturersId` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturersName` varchar(255) NOT NULL,
  `connactName` varchar(255) DEFAULT NULL,
  `connactNumber` varchar(255) DEFAULT NULL,
  `manufacturersAddress` varchar(255) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`manufacturersId`),
  UNIQUE KEY `Index_manufacturers` (`manufacturersName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='基础--厂家';

-- 正在导出表  fuzhoudianyeju.b_manufacturers 的数据：~0 rows (大约)
DELETE FROM `b_manufacturers`;
/*!40000 ALTER TABLE `b_manufacturers` DISABLE KEYS */;
INSERT INTO `b_manufacturers` (`manufacturersId`, `manufacturersName`, `connactName`, `connactNumber`, `manufacturersAddress`, `delFlg`, `descp`) VALUES
	(1, 'test厂家', '张三', '12312312312', '四川成都', '启用', '');
/*!40000 ALTER TABLE `b_manufacturers` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.b_project 结构
CREATE TABLE IF NOT EXISTS `b_project` (
  `projectId` int(11) NOT NULL AUTO_INCREMENT,
  `projectName` varchar(255) NOT NULL,
  `projectNumber` varchar(255) DEFAULT NULL,
  `connactName` varchar(255) DEFAULT NULL,
  `connactNumber` varchar(255) DEFAULT NULL,
  `delFlg` char(10) NOT NULL,
  `descp` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`projectId`),
  UNIQUE KEY `Index_project` (`projectName`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='基础--项目表';

-- 正在导出表  fuzhoudianyeju.b_project 的数据：~0 rows (大约)
DELETE FROM `b_project`;
/*!40000 ALTER TABLE `b_project` DISABLE KEYS */;
INSERT INTO `b_project` (`projectId`, `projectName`, `projectNumber`, `connactName`, `connactNumber`, `delFlg`, `descp`) VALUES
	(1, 'test1', '1', '11', '11111111111', '启用', '');
/*!40000 ALTER TABLE `b_project` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.t_schema 结构
CREATE TABLE IF NOT EXISTS `t_schema` (
  `n_schema_id` int(11) NOT NULL AUTO_INCREMENT,
  `vc_schema_name` varchar(64) NOT NULL,
  `dt_schema_add_time` datetime DEFAULT NULL,
  `vc_schema_data` varchar(10240) DEFAULT NULL,
  `vc_schema_args` varchar(255) DEFAULT NULL,
  `dt_schema_del_time` datetime DEFAULT NULL,
  `vc_schema_type` varchar(24) DEFAULT NULL,
  `vc_schema_note` varchar(255) DEFAULT NULL,
  `n_schema_area_id` int(11) DEFAULT NULL,
  `n_schema_site_id` int(11) DEFAULT NULL,
  `vc_is_default` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`n_schema_id`),
  UNIQUE KEY `Index_schema` (`vc_schema_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='视图--展示图';

-- 正在导出表  fuzhoudianyeju.t_schema 的数据：~4 rows (大约)
DELETE FROM `t_schema`;
/*!40000 ALTER TABLE `t_schema` DISABLE KEYS */;
INSERT INTO `t_schema` (`n_schema_id`, `vc_schema_name`, `dt_schema_add_time`, `vc_schema_data`, `vc_schema_args`, `dt_schema_del_time`, `vc_schema_type`, `vc_schema_note`, `n_schema_area_id`, `n_schema_site_id`, `vc_is_default`) VALUES
	(1, '台江辖区新建站点视图', '2015-03-12 14:44:09', '[{"isMainRoad":"是","endId":"2","y":-1,"id":"1","x":-1,"showName":"","startId":"1","imgPath":"","type":"valueObjects::Cable"},{"isMainRoad":"","endId":"","y":133,"id":"2","x":360,"showName":"台江站点A2","startId":"","imgPath":"assets/tower.png","type":"valueObjects::Site"},{"isMainRoad":"","endId":"","y":177,"id":"1","x":207,"showName":"台江站点1","startId":"","imgPath":"assets/tower.png","type":"valueObjects::Site"} ]', '{"viewY":0,"viewX":0}', NULL, NULL, '', 1, NULL, 'Y'),
	(2, '仓山辖区新建站点视图', '2015-03-12 14:55:18', 'null', 'null', NULL, NULL, 'jj', 2, NULL, NULL),
	(3, '马尾辖区新建站点视图', '2015-03-25 10:55:08', 'null', 'null', NULL, NULL, '', 3, NULL, NULL),
	(4, '晋安辖区新建站点视图', '2015-03-25 10:56:17', '[{"isMainRoad":"","endId":"","y":124,"id":"3","x":192,"showName":"晋安A1","startId":"","imgPath":"assets/tower.png","type":"valueObjects::Site"} ]', '{"viewY":0,"viewX":0}', NULL, NULL, '', 4, NULL, NULL);
/*!40000 ALTER TABLE `t_schema` ENABLE KEYS */;


-- 导出  表 fuzhoudianyeju.t_schema_tree_node 结构
CREATE TABLE IF NOT EXISTS `t_schema_tree_node` (
  `n_schema_tree_node_id` int(11) NOT NULL AUTO_INCREMENT,
  `vc_tree_node_name` varchar(128) NOT NULL,
  `vc_tree_node_type` varchar(24) DEFAULT NULL,
  `n_tree_parent_node` int(11) DEFAULT NULL,
  `n_tree_level` int(11) DEFAULT NULL,
  `vc_schema_type_alias` varchar(24) DEFAULT NULL,
  `dt_del_time` datetime DEFAULT NULL,
  PRIMARY KEY (`n_schema_tree_node_id`),
  UNIQUE KEY `Index_tree_node` (`vc_tree_node_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='视图--关系节点';

-- 正在导出表  fuzhoudianyeju.t_schema_tree_node 的数据：~2 rows (大约)
DELETE FROM `t_schema_tree_node`;
/*!40000 ALTER TABLE `t_schema_tree_node` DISABLE KEYS */;
INSERT INTO `t_schema_tree_node` (`n_schema_tree_node_id`, `vc_tree_node_name`, `vc_tree_node_type`, `n_tree_parent_node`, `n_tree_level`, `vc_schema_type_alias`, `dt_del_time`) VALUES
	(2, '关注站点', '1', NULL, 0, 'levelSchema', NULL),
	(3, '自定义视图', '1', NULL, 0, 'customerSchema', '2015-03-11 14:19:43');
/*!40000 ALTER TABLE `t_schema_tree_node` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
