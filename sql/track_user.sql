/*
Navicat MySQL Data Transfer

Source Server         : 159.226.16.34
Source Server Version : 50173
Source Host           : 159.226.16.34:3306
Source Database       : track

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2019-11-11 17:21:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for track_user
-- ----------------------------
DROP TABLE IF EXISTS `track_user`;
CREATE TABLE `track_user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `userName` varchar(255) NOT NULL COMMENT '用户名(邮箱)',
  `roleId` int(11) DEFAULT NULL COMMENT '角色id',
  `orgparentId` int(11) DEFAULT NULL,
  `orgId` int(11) DEFAULT NULL COMMENT '单位',
  `accessToken` varchar(255) DEFAULT NULL COMMENT '认证令牌',
  `refreshToken` varchar(255) DEFAULT NULL COMMENT '刷新令牌',
  `contacts` varchar(255) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `isDel` int(11) DEFAULT NULL COMMENT '是否删除(0:未删除;1:已删除)',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `createUser` varchar(255) DEFAULT NULL COMMENT '创建者',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateUser` varchar(255) DEFAULT NULL COMMENT '修改者',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of track_user
-- ----------------------------
INSERT INTO `track_user` VALUES ('1', '13146475588@163.com', '1', '1', '51', 'd7e88d133938b50278790a11887df2c4', '737d91956fe85bd5f90966567819193b', '刘星', null, '0', null, null, null, '13146475588@163.com', '2019-11-11 15:06:18');
INSERT INTO `track_user` VALUES ('6', 'cert@cnic.cn', '1', '1', '51', '19539bc35e11df7f7ad035ccf473075e', 'b251bcf838aaa6f898c9cb6f93b7fe01', '安全事件处理邮箱', null, '0', null, null, null, 'cert@cnic.cn', '2019-11-05 14:39:56');
INSERT INTO `track_user` VALUES ('7', 'wangshaojie@cnic.cn', '1', '1', '51', '967fe88f38a853bb875b56941200b4d2', '5b7caeb714d87992bbef88dfa4b16c5d', '王绍节', null, '0', null, null, null, 'wangshaojie@cnic.cn', '2018-01-18 15:10:12');
INSERT INTO `track_user` VALUES ('8', 'jingzhao@cnic.cn', '1', '1', '51', 'ca0c84e0f41be5e57ba480e5417f569a', '8991811a5ff4125975b1905bbd44ad2d', '赵静', null, '0', null, null, null, 'jingzhao@cnic.cn', '2019-11-04 09:26:43');
INSERT INTO `track_user` VALUES ('9', 'songdanjie@cnic.cn', '1', '1', '51', '47a3bfb1bd04d8211a3cb2b60aac0e18', '9c20d36780573a5b63d2086a3dddfd8e', '宋丹劼', null, '0', null, null, null, 'songdanjie@cnic.cn', '2019-01-03 09:32:36');
INSERT INTO `track_user` VALUES ('10', 'songxiaofan@cnic.cn', '1', '1', '51', 'b8ebb2e9fbd584809401226411346830', '0081da97bda847eaaf2cdc6909c5b919', '宋小帆', null, '0', null, null, null, 'songxiaofan@cnic.cn', '2018-06-15 15:08:52');
INSERT INTO `track_user` VALUES ('16', 'yugongcheng@cnic.cn', '1', '1', '51', 'ee64b1c5d0bfaa3f744f295bcbe3a79e', 'b776cba44df9cc3b968303cb0c0600f5', '于公成', null, '0', null, null, null, 'yugongcheng@cnic.cn', '2018-07-18 10:31:36');
INSERT INTO `track_user` VALUES ('17', 'duguanyao@cnic.cn', '1', '1', '51', 'b7e66f7bfd7bb133834dffad9cd07355', '80e95b7fb47cced0f40a5d64b689d478', '杜冠瑶', null, '0', null, null, null, 'duguanyao@cnic.cn', '2019-09-29 10:38:53');
INSERT INTO `track_user` VALUES ('18', 'weijinxia@cnic.cn', '1', '1', '51', '6e77d8b2f7e3ca3a62849112f534a1c3', 'd1b6bd3d0a6dd1d89d4d2d4f9bb652b6', '魏金侠', null, '0', null, null, null, 'weijinxia@cnic.cn', '2019-11-05 15:05:27');
INSERT INTO `track_user` VALUES ('19', 'huangpan@cnic.cn', '1', '1', '51', 'b8ff9e01e25d89c8d0f7995524de6a61', '97a6d3b76e5b427f7e913a225d9c2c48', '黄潘', null, '0', null, 'huangpan@cnic.cn', '2019-06-12 17:28:01', 'huangpan@cnic.cn', '2019-11-04 17:26:40');
INSERT INTO `track_user` VALUES ('20', 'qinyakui@cnic.cn', '1', '1', '51', 'b8b494d90d644c8501e1d22512c06659', '5b6a97cf684716490686fadf130f6521', '秦亚魁', null, '0', null, 'qinyakui@cnic.cn', '2019-06-12 17:28:40', 'qinyakui@cnic.cn', '2019-10-21 16:08:37');
INSERT INTO `track_user` VALUES ('21', 'liaozhen@cnic.cn', '3', '11', '171', '165c1cf6a5a21131637cea7014e85181', '953c21680bae0503e1e396a270e6a43a', '廖振', null, '0', null, 'liaozhen@cnic.cn', '2019-06-19 16:01:14', 'liaozhen@cnic.cn', '2019-11-08 10:48:13');
INSERT INTO `track_user` VALUES ('22', 'wanglingyue@cnic.cn', '3', '11', '298', '67dc9faf54224fc0822e71af1de5f2ec', '462a29ff7a660098acef41fcd398cf2c', '王玲悦', null, '0', null, 'wanglingyue@cnic.cn', '2019-06-20 14:20:56', 'wanglingyue@cnic.cn', '2019-10-15 16:12:16');
INSERT INTO `track_user` VALUES ('23', 'hankuiyu@cnic.cn', '1', '1', '51', 'ad36af0e1381781c630cdaa280bea0d9', 'd6214c0636c4b2834d697292a68a1bc4', '韩奎宇', null, '0', null, 'hankuiyu@cnic.cn', '2019-07-03 15:43:02', 'hankuiyu@cnic.cn', '2019-10-14 18:31:18');
INSERT INTO `track_user` VALUES ('24', 'longchun@cnic.cn', '1', '1', '51', null, null, '龙春', null, '0', null, 'longchun@cnic.cn', '2019-11-04 16:31:02', 'longchun@cnic.cn', '2019-11-04 16:31:06');
INSERT INTO `track_user` VALUES ('25', 'wanwei@cnic.cn', '1', '1', '51', null, null, '万巍', null, '0', null, 'wanwei@cnic.cn', '2019-11-04 16:40:27', 'wanwei@cnic.cn', '2019-11-04 16:40:33');
INSERT INTO `track_user` VALUES ('26', 'yangfan@cnic.cn', '1', '1', '51', null, null, '杨帆', null, '0', null, 'yangfan@cnic.cn', '2019-11-04 16:41:56', 'yangfan@cnic.cn', '2019-11-04 16:42:03');
