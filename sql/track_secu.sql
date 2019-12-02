/*
Navicat MySQL Data Transfer

Source Server         : 159.226.16.34
Source Server Version : 50173
Source Host           : 159.226.16.34:3306
Source Database       : track

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2019-11-11 16:12:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for track_secu
-- ----------------------------
DROP TABLE IF EXISTS `track_secu`;
CREATE TABLE `track_secu` (
  `secuId` int(11) NOT NULL AUTO_INCREMENT COMMENT '漏洞id',
  `secuCode` varchar(1000) DEFAULT NULL COMMENT '漏洞编码(CVEID等)',
  `secuName` varchar(1000) NOT NULL COMMENT '漏洞名字',
  `frequency` int(11) DEFAULT NULL COMMENT '使用频率',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `createUser` varchar(255) DEFAULT NULL COMMENT '创建者',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateUser` varchar(255) DEFAULT NULL COMMENT '修改者',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`secuId`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8 COMMENT='漏洞信息表';

-- ----------------------------
-- Records of track_secu
-- ----------------------------
INSERT INTO `track_secu` VALUES ('1', null, '暗链漏洞', '3', null, 'wangshaojie@cnic.cn', '2017-07-13 14:41:30', 'wanglingyue@cnic.cn', '2019-07-31 15:12:16');
INSERT INTO `track_secu` VALUES ('2', null, 'sql注入漏洞', '0', null, '13146475588@163.com', '2017-07-21 14:27:58', 'cert@cnic.cn', '2019-10-18 18:22:02');
INSERT INTO `track_secu` VALUES ('3', null, '网站木马', '1', null, 'wangshaojie@cnic.cn', '2017-07-28 10:05:49', 'wangshaojie@cnic.cn', '2017-07-28 10:17:24');
INSERT INTO `track_secu` VALUES ('4', null, 'SQL 注入漏洞', '37', null, 'cert@cnic.cn', '2017-10-18 09:51:13', '13146475588@163.com', '2019-11-05 15:01:25');
INSERT INTO `track_secu` VALUES ('5', null, '弱口令漏洞', '0', null, 'cert@cnic.cn', '2017-10-18 09:51:29', 'cert@cnic.cn', '2019-11-04 16:54:44');
INSERT INTO `track_secu` VALUES ('6', null, '信息泄露漏洞', '0', null, 'cert@cnic.cn', '2017-10-18 10:01:32', 'cert@cnic.cn', '2019-10-31 18:35:20');
INSERT INTO `track_secu` VALUES ('7', null, '命令执行漏洞', '6', null, 'cert@cnic.cn', '2017-10-18 10:04:32', '13146475588@163.com', '2019-10-09 14:01:20');
INSERT INTO `track_secu` VALUES ('8', null, 'MongoDB 未授权访问漏洞', '0', null, 'cert@cnic.cn', '2017-11-17 10:53:20', 'cert@cnic.cn', '2017-11-17 10:53:20');
INSERT INTO `track_secu` VALUES ('9', null, 'MongoDB 数据库未授权访问漏洞', '0', null, 'cert@cnic.cn', '2017-11-17 10:57:56', 'cert@cnic.cn', '2017-11-17 10:57:56');
INSERT INTO `track_secu` VALUES ('10', null, 'MySQL 弱口令漏洞', '3', null, 'cert@cnic.cn', '2017-11-17 11:01:48', 'cert@cnic.cn', '2017-11-17 11:08:15');
INSERT INTO `track_secu` VALUES ('11', null, 'MySQL 数据库弱口令漏洞', '1', null, 'cert@cnic.cn', '2017-11-17 11:41:58', 'cert@cnic.cn', '2017-11-17 11:43:25');
INSERT INTO `track_secu` VALUES ('12', null, 'Memcached 未授权访问漏洞', '4', null, 'cert@cnic.cn', '2017-11-27 10:52:47', 'cert@cnic.cn', '2017-12-05 12:28:10');
INSERT INTO `track_secu` VALUES ('13', null, '越权访问漏洞', '1', null, 'cert@cnic.cn', '2017-12-04 10:09:30', 'cert@cnic.cn', '2018-07-10 09:36:06');
INSERT INTO `track_secu` VALUES ('14', null, 'Jboss4.x 反序列化命令执行漏洞', '0', null, 'cert@cnic.cn', '2018-01-03 14:37:39', 'cert@cnic.cn', '2018-01-03 14:37:39');
INSERT INTO `track_secu` VALUES ('15', null, '敏感信息泄露漏洞', '7', null, 'cert@cnic.cn', '2018-06-13 16:52:53', 'cert@cnic.cn', '2019-11-05 14:40:29');
INSERT INTO `track_secu` VALUES ('16', null, 'fgdfgdf', null, null, null, null, null, null);
INSERT INTO `track_secu` VALUES ('17', null, '木马后门漏洞', '1', null, 'cert@cnic.cn', '2018-09-13 09:25:53', 'cert@cnic.cn', '2019-07-09 14:57:59');
INSERT INTO `track_secu` VALUES ('18', null, '目录遍历漏洞', '4', null, 'cert@cnic.cn', '2018-09-29 09:23:48', 'cert@cnic.cn', '2019-08-02 21:00:16');
INSERT INTO `track_secu` VALUES ('19', null, '远程控制木马', '0', null, 'cert@cnic.cn', '2018-09-30 16:00:14', 'cert@cnic.cn', '2018-09-30 16:00:14');
INSERT INTO `track_secu` VALUES ('20', null, '弱口令、目录遍历漏洞', '0', null, 'cert@cnic.cn', '2018-10-17 10:39:08', 'cert@cnic.cn', '2018-10-17 10:39:08');
INSERT INTO `track_secu` VALUES ('21', null, '弱口令漏洞、目录遍历漏洞', '1', null, 'cert@cnic.cn', '2018-10-17 10:42:37', '13146475588@163.com', '2019-08-29 14:52:20');
INSERT INTO `track_secu` VALUES ('22', null, '存储型 XSS漏洞', '0', null, 'cert@cnic.cn', '2018-10-18 14:51:35', 'cert@cnic.cn', '2018-12-24 09:06:42');
INSERT INTO `track_secu` VALUES ('23', null, '万能密码登录', '1', null, 'cert@cnic.cn', '2018-10-24 09:49:27', 'cert@cnic.cn', '2018-10-24 09:52:41');
INSERT INTO `track_secu` VALUES ('24', null, '反射型 XSS漏洞', '0', null, 'cert@cnic.cn', '2018-10-24 18:33:48', 'cert@cnic.cn', '2018-10-24 18:33:48');
INSERT INTO `track_secu` VALUES ('25', null, 'SQL注入漏洞、弱口令漏洞', '0', null, 'cert@cnic.cn', '2018-10-25 10:57:23', 'cert@cnic.cn', '2018-10-25 10:57:23');
INSERT INTO `track_secu` VALUES ('26', null, 'Memcached未授权访问漏洞', '0', null, 'cert@cnic.cn', '2018-10-29 14:32:17', 'cert@cnic.cn', '2018-10-29 14:32:17');
INSERT INTO `track_secu` VALUES ('27', null, '未授权访问漏洞', '4', null, 'cert@cnic.cn', '2018-11-12 12:47:21', 'cert@cnic.cn', '2019-11-05 14:41:51');
INSERT INTO `track_secu` VALUES ('28', null, '网页被篡改', '1', null, 'cert@cnic.cn', '2018-11-13 10:18:54', 'cert@cnic.cn', '2019-01-15 17:01:19');
INSERT INTO `track_secu` VALUES ('29', null, '任意文件下载漏洞', '0', null, 'cert@cnic.cn', '2018-11-15 17:34:55', 'cert@cnic.cn', '2019-09-29 10:04:09');
INSERT INTO `track_secu` VALUES ('30', null, 'Struts2-045漏洞', '0', null, 'cert@cnic.cn', '2018-12-12 15:00:49', 'cert@cnic.cn', '2018-12-12 15:00:49');
INSERT INTO `track_secu` VALUES ('31', null, 'jmx-console 未授权访问漏洞', '0', null, 'cert@cnic.cn', '2018-12-28 13:02:13', 'cert@cnic.cn', '2018-12-28 13:02:13');
INSERT INTO `track_secu` VALUES ('32', null, 'XSS漏洞', '1', null, 'cert@cnic.cn', '2019-01-28 15:41:37', 'cert@cnic.cn', '2019-09-26 10:35:00');
INSERT INTO `track_secu` VALUES ('33', null, '被植入暗链', '0', null, 'cert@cnic.cn', '2019-02-19 13:03:55', 'cert@cnic.cn', '2019-02-19 13:17:34');
INSERT INTO `track_secu` VALUES ('34', null, '疑似被黑', '0', null, 'cert@cnic.cn', '2019-02-19 13:17:56', 'cert@cnic.cn', '2019-02-19 13:17:56');
INSERT INTO `track_secu` VALUES ('35', null, '木马僵尸', '0', null, 'cert@cnic.cn', '2019-03-08 13:00:23', 'cert@cnic.cn', '2019-03-08 13:00:23');
INSERT INTO `track_secu` VALUES ('36', null, '恶意挖矿代码', '0', null, 'cert@cnic.cn', '2019-03-19 13:40:59', 'cert@cnic.cn', '2019-03-19 13:56:34');
INSERT INTO `track_secu` VALUES ('37', null, '未授权访问漏洞和弱口令漏洞', '0', null, 'cert@cnic.cn', '2019-04-03 15:02:06', 'cert@cnic.cn', '2019-04-03 15:02:06');
INSERT INTO `track_secu` VALUES ('38', null, '弱口令漏洞和文件上传漏洞', '0', null, 'cert@cnic.cn', '2019-04-03 15:31:54', 'cert@cnic.cn', '2019-04-03 15:31:54');
INSERT INTO `track_secu` VALUES ('39', null, 'url重定向漏洞', '0', null, 'cert@cnic.cn', '2019-04-10 17:16:21', 'cert@cnic.cn', '2019-04-10 17:16:21');
INSERT INTO `track_secu` VALUES ('40', null, '万能密码登陆漏洞', '0', null, 'cert@cnic.cn', '2019-04-15 15:51:37', 'cert@cnic.cn', '2019-04-15 15:51:37');
INSERT INTO `track_secu` VALUES ('41', null, 'WebLogic wls-9-async反序列化远程命令执行', '1', null, 'cert@cnic.cn', '2019-04-22 18:03:44', 'cert@cnic.cn', '2019-04-26 16:27:43');
INSERT INTO `track_secu` VALUES ('42', null, 'Jboss未授权访问漏洞', '0', null, 'cert@cnic.cn', '2019-06-13 16:38:45', 'cert@cnic.cn', '2019-06-13 16:38:45');
INSERT INTO `track_secu` VALUES ('43', null, 'Elasticsearch未授权访问漏洞', '0', null, 'cert@cnic.cn', '2019-06-18 11:25:21', 'cert@cnic.cn', '2019-06-18 11:25:21');
INSERT INTO `track_secu` VALUES ('44', null, 'ckfinder文件上传漏洞', '0', null, 'cert@cnic.cn', '2019-06-26 11:41:01', 'cert@cnic.cn', '2019-06-26 11:41:01');
INSERT INTO `track_secu` VALUES ('45', null, '未授权访问漏洞、任意文件上传漏洞', '32', null, 'cert@cnic.cn', '2019-06-27 15:51:29', '13146475588@163.com', '2019-11-05 15:37:07');
INSERT INTO `track_secu` VALUES ('46', null, '任意文件写入漏洞', '0', null, 'cert@cnic.cn', '2019-06-27 16:40:12', 'cert@cnic.cn', '2019-06-27 16:42:51');
INSERT INTO `track_secu` VALUES ('47', null, '任意密码重置漏洞', '0', null, 'cert@cnic.cn', '2019-07-01 17:38:55', 'cert@cnic.cn', '2019-07-01 17:38:55');
INSERT INTO `track_secu` VALUES ('48', null, '未发现端口', '17', null, '13146475588@163.com', '2019-07-05 17:39:39', '13146475588@163.com', '2019-11-05 14:57:15');
INSERT INTO `track_secu` VALUES ('49', null, '33333', '0', null, 'wanglingyue@cnic.cn', '2019-07-08 14:20:29', 'wanglingyue@cnic.cn', '2019-07-08 14:20:29');
INSERT INTO `track_secu` VALUES ('50', null, '弱口令漏洞、敏感信息泄露漏洞', '1', null, 'cert@cnic.cn', '2019-07-08 15:43:42', 'cert@cnic.cn', '2019-07-08 15:53:56');
INSERT INTO `track_secu` VALUES ('51', null, '飞客蠕虫', '2', null, 'cert@cnic.cn', '2019-07-11 17:45:10', 'cert@cnic.cn', '2019-09-27 20:47:59');
INSERT INTO `track_secu` VALUES ('52', null, 'weblogic补丁绕过漏洞', '0', null, 'cert@cnic.cn', '2019-07-12 17:43:33', 'cert@cnic.cn', '2019-07-12 17:43:33');
INSERT INTO `track_secu` VALUES ('53', null, '远程命令执行漏洞', '2', null, 'cert@cnic.cn', '2019-07-19 16:31:23', 'cert@cnic.cn', '2019-09-26 13:52:20');
INSERT INTO `track_secu` VALUES ('54', null, 'RDP 远程代码执行漏洞', '0', null, 'cert@cnic.cn', '2019-07-25 15:42:17', 'cert@cnic.cn', '2019-07-25 15:42:17');
INSERT INTO `track_secu` VALUES ('55', null, 'MyKings僵尸网络病毒', '0', null, 'cert@cnic.cn', '2019-07-31 13:54:39', 'cert@cnic.cn', '2019-07-31 13:57:00');
INSERT INTO `track_secu` VALUES ('56', null, '越权漏洞', '0', null, 'cert@cnic.cn', '2019-08-02 20:55:51', 'cert@cnic.cn', '2019-08-02 20:55:51');
INSERT INTO `track_secu` VALUES ('57', null, '技术室测试', '0', null, '13146475588@163.com', '2019-08-29 15:09:45', '13146475588@163.com', '2019-08-29 15:09:45');
INSERT INTO `track_secu` VALUES ('58', null, 'SQL 注入漏洞¦未授权访问漏洞、任意文件上传漏洞', '0', null, 'wanglingyue@cnic.cn', '2019-10-09 15:03:40', 'wanglingyue@cnic.cn', '2019-10-09 15:03:40');
INSERT INTO `track_secu` VALUES ('59', null, '未授权访问漏洞、任意文件上传漏洞¦敏感信息泄露漏洞', '0', null, '13146475588@163.com', '2019-10-09 15:38:18', '13146475588@163.com', '2019-10-09 15:38:18');
INSERT INTO `track_secu` VALUES ('60', null, '未授权访问漏洞、任意文件上传漏洞¦未发现端口', null, null, null, null, null, null);
INSERT INTO `track_secu` VALUES ('61', null, 'Elasticsearch 未授权访问漏洞', '0', null, 'cert@cnic.cn', '2019-10-09 17:25:38', 'cert@cnic.cn', '2019-10-09 17:25:38');
INSERT INTO `track_secu` VALUES ('62', null, '存储型XSS漏洞', '0', null, 'cert@cnic.cn', '2019-10-16 17:54:34', 'cert@cnic.cn', '2019-10-16 17:54:34');
INSERT INTO `track_secu` VALUES ('63', null, 'SQL Server数据库被控', '1', null, 'cert@cnic.cn', '2019-10-17 17:35:10', 'cert@cnic.cn', '2019-10-17 17:45:13');
INSERT INTO `track_secu` VALUES ('64', null, '多个漏洞', '0', null, 'cert@cnic.cn', '2019-10-18 18:24:37', 'cert@cnic.cn', '2019-10-18 18:27:44');
INSERT INTO `track_secu` VALUES ('65', null, '漏洞', '1', null, 'cert@cnic.cn', '2019-10-18 18:27:58', 'cert@cnic.cn', '2019-10-18 18:28:56');
INSERT INTO `track_secu` VALUES ('66', null, '任意文件读取漏洞', '1', null, 'cert@cnic.cn', '2019-10-29 09:52:57', 'cert@cnic.cn', '2019-10-30 10:52:55');
INSERT INTO `track_secu` VALUES ('67', null, '文件上传漏洞', '0', null, 'cert@cnic.cn', '2019-10-29 10:14:41', 'cert@cnic.cn', '2019-10-29 10:14:41');
INSERT INTO `track_secu` VALUES ('68', null, 'SSRF漏洞', '0', null, 'cert@cnic.cn', '2019-10-31 18:35:07', 'cert@cnic.cn', '2019-10-31 18:35:07');
