# Host: localhost  (Version 5.5.54)
# Date: 2018-05-25 17:06:43
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "t_cart"
#

DROP TABLE IF EXISTS `t_cart`;
CREATE TABLE `t_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `jointime` char(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_cart"
#

INSERT INTO `t_cart` VALUES (1,1,3,6,11,'2018-05-25 16:26:00');

#
# Structure for table "t_fav_goods"
#

DROP TABLE IF EXISTS `t_fav_goods`;
CREATE TABLE `t_fav_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) DEFAULT NULL,
  `memberid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "t_fav_goods"
#

INSERT INTO `t_fav_goods` VALUES (1,3,1);

#
# Structure for table "t_goods"
#

DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `num` varchar(255) DEFAULT NULL,
  `memberid` int(11) DEFAULT NULL,
  `createtime` char(19) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `iconpath` varchar(255) DEFAULT NULL,
  `iconpath1` varchar(255) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `limitstock` int(11) DEFAULT NULL,
  `hot` char(1) DEFAULT NULL,
  `newgoods` char(1) DEFAULT NULL,
  `best` char(1) DEFAULT NULL,
  `priceunit` varchar(255) DEFAULT NULL,
  `categoryid` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "t_goods"
#

INSERT INTO `t_goods` VALUES (3,'11',NULL,1,NULL,NULL,11,11,'1f6c9ada-1e23-4c99-b3e0-3d6c659e6cf1.jpg','75969ddf-5a53-4c2d-97c2-578b1d238ae9.jpg',NULL,NULL,NULL,NULL,NULL,NULL,1,'11'),(5,'2',NULL,1,NULL,NULL,2,2,'da995310-737e-4ac6-b1ca-69184fae2b91.jpg','72925342-0e7e-425a-83f8-2704e37740a4.jpg',NULL,NULL,NULL,NULL,NULL,NULL,2,'2'),(6,'44',NULL,1,NULL,NULL,44,44,'fa347037-2ad2-4a9c-9396-c934d92c77aa.jpg','91424c61-b674-4645-bf4c-c436d0d54e25.jpg',NULL,NULL,NULL,NULL,NULL,NULL,3,'4444');

#
# Structure for table "t_goods_category"
#

DROP TABLE IF EXISTS `t_goods_category`;
CREATE TABLE `t_goods_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `orderid` int(11) DEFAULT NULL,
  `createtime` char(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

#
# Data for table "t_goods_category"
#

INSERT INTO `t_goods_category` VALUES (1,'科技','开启智慧未来',1,'2018-05-22 11:42:38'),(2,'设计','创意改变生活',2,NULL),(3,'农业','网络天下肥美',3,NULL),(4,'其他','发现更多惊喜',4,NULL);

#
# Structure for table "t_goods_info"
#

DROP TABLE IF EXISTS `t_goods_info`;
CREATE TABLE `t_goods_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) DEFAULT NULL,
  `buycnt` int(11) DEFAULT NULL,
  `goodcnt` int(11) DEFAULT NULL,
  `favcnt` int(11) DEFAULT NULL,
  `sellcnt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_goods_info"
#

INSERT INTO `t_goods_info` VALUES (1,3,NULL,NULL,1,NULL),(3,5,NULL,NULL,NULL,NULL),(4,6,NULL,NULL,NULL,NULL);

#
# Structure for table "t_goods_tag"
#

DROP TABLE IF EXISTS `t_goods_tag`;
CREATE TABLE `t_goods_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) DEFAULT NULL,
  `tagid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_goods_tag"
#

INSERT INTO `t_goods_tag` VALUES (1,3,5),(4,5,5),(5,5,6),(6,6,5),(7,6,6);

#
# Structure for table "t_member"
#

DROP TABLE IF EXISTS `t_member`;
CREATE TABLE `t_member` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginacct` varchar(255) DEFAULT NULL,
  `memberpswd` char(32) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `loginstatus` char(1) DEFAULT NULL,
  `authstatus` char(1) DEFAULT NULL,
  `sellerstatus` char(1) DEFAULT NULL,
  `lockstatus` char(1) DEFAULT NULL,
  `regtime` char(19) DEFAULT NULL,
  `lastvisittime` char(19) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "t_member"
#

INSERT INTO `t_member` VALUES (1,'zhangsan','01d7f40760960e7bd9443513f22ab9af','ZHANGSAN',NULL,NULL,'1',NULL,NULL,NULL,NULL);

#
# Structure for table "t_order"
#

DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) DEFAULT NULL,
  `ordernum` varchar(255) DEFAULT NULL,
  `status` char(2) DEFAULT NULL COMMENT '待付款，待发货，待收货，待评价，交易成功、退款， 交易关闭',
  `createtime` char(19) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `paytype` char(1) DEFAULT NULL,
  `payprice` int(11) DEFAULT NULL,
  `ispay` char(1) DEFAULT NULL,
  `paytime` char(19) DEFAULT NULL,
  `issend` char(1) DEFAULT NULL,
  `sendtime` char(19) DEFAULT NULL,
  `isreceipt` char(1) DEFAULT NULL,
  `receipttime` char(19) DEFAULT NULL,
  `addressid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_order"
#

INSERT INTO `t_order` VALUES (2,1,NULL,'00','2018-05-25 17:01:52',66,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

#
# Structure for table "t_order_item"
#

DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderid` int(11) DEFAULT NULL,
  `goodsid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "t_order_item"
#

INSERT INTO `t_order_item` VALUES (1,2,3,6,11);

#
# Structure for table "t_seller_info"
#

DROP TABLE IF EXISTS `t_seller_info`;
CREATE TABLE `t_seller_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) DEFAULT NULL,
  `introduce` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `cstel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Data for table "t_seller_info"
#

INSERT INTO `t_seller_info` VALUES (6,1,'55','55','55','55');

#
# Structure for table "t_tag"
#

DROP TABLE IF EXISTS `t_tag`;
CREATE TABLE `t_tag` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

#
# Data for table "t_tag"
#

INSERT INTO `t_tag` VALUES (1,'电商平台商品标签',0,'glyphicon glyphicon-home'),(2,'手机',1,NULL),(3,'数码',1,NULL),(4,'电脑',1,NULL),(5,'超极本',2,NULL),(6,'电源',2,NULL);

#
# Structure for table "t_user"
#

DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loginacct` varchar(255) DEFAULT NULL,
  `userpswd` char(32) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

#
# Data for table "t_user"
#

INSERT INTO `t_user` VALUES (1,'zhangsan','01d7f40760960e7bd9443513f22ab9af','ZHANGSAN'),(2,'lisi','lisi','LISI'),(3,'wangwu','wangwu','WANGWU');
