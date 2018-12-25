/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/20 17:40:08                          */
/*==============================================================*/


DROP TABLE IF EXISTS storage_access_token;
DROP TABLE IF EXISTS storage_base_data;
DROP TABLE IF EXISTS storage_goods;
DROP TABLE IF EXISTS storage_hot_points;
DROP TABLE IF EXISTS storage_building;
DROP TABLE IF EXISTS storage_user;
DROP view IF EXISTS storage_view_goods;

/*==============================================================*/
/* Table: access_token                                             */
/*==============================================================*/

CREATE TABLE `storage_access_token` (
  `access_token` VARCHAR(3000) NOT NULL
  COLLATE 'utf8_unicode_ci',
  `update_date`  VARCHAR(20)   NOT NULL
  COLLATE 'utf8_unicode_ci'
)
  COLLATE = 'utf8_unicode_ci'
  ENGINE = InnoDB;

/*==============================================================*/
/* Table: base_data                                             */
/*==============================================================*/
CREATE TABLE storage_base_data
(
  id       VARCHAR(20) NOT NULL,
  datatype VARCHAR(20) COMMENT '类型 1-物品类型 2-标签',
  dataname VARCHAR(50) COMMENT 'type或者tag的显示名称',
  comment VARCHAR(100),
  PRIMARY KEY (id)
);

ALTER TABLE storage_base_data
  COMMENT '基础数据表，如物品类型、标签等数据
';

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
CREATE TABLE storage_goods
(
  goodsId    VARCHAR(50) NOT NULL,
  userId     VARCHAR(50) NOT NULL COMMENT '用户id',
  goodName   VARCHAR(40) COMMENT '物品名称',
  owername   VARCHAR(50) COMMENT '所有者名字',
  picture    VARCHAR(100) COMMENT '物品图片',
  hotpointid VARCHAR(50) COMMENT '热点id',
  location   VARCHAR(100) COMMENT '物品收纳位置',
  typeId     VARCHAR(20) COMMENT '物品类型',
  tagId      VARCHAR(20) COMMENT '物品tag',
  buyTime    VARCHAR(20) COMMENT '购买时间',
  price      VARCHAR(20) COMMENT '购买价格',
  modifyTime VARCHAR(20) COMMENT '最近修改时间',
  comment    VARCHAR(100) COMMENT '备注',
  status     VARCHAR(10) COMMENT '物品状态',
  PRIMARY KEY (goodsId)
);

ALTER TABLE storage_goods
  COMMENT '物品表';

/*==============================================================*/
/* Table: hot_points                                            */
/*==============================================================*/
CREATE TABLE storage_hot_points
(
  id           VARCHAR(50) NOT NULL,
  userId       VARCHAR(50) NOT NULL COMMENT '用户id',
  buildingId   VARCHAR(50) NOT NULL COMMENT '建筑物id',
  xstart       VARCHAR(20) COMMENT '热点坐标',
  ystart       VARCHAR(20) COMMENT '热点坐标',
  xend         VARCHAR(20) COMMENT '热点坐标',
  yend         VARCHAR(20) COMMENT '热点坐标',
  hotPointName VARCHAR(50) COMMENT '热点名称',
  comment      VARCHAR(100) COMMENT '热点描述',
  status       VARCHAR(10) COMMENT '状态',
  PRIMARY KEY (id)
);

ALTER TABLE storage_hot_points
  COMMENT '热点（收纳家具）表';

/*==============================================================*/
/* Table: building                                                  */
/*==============================================================*/
CREATE TABLE storage_building
(
  buildingId VARCHAR(50) NOT NULL COMMENT 'id',
  userId VARCHAR(50) NOT NULL COMMENT '用户id',
  buildingName   VARCHAR(50) NOT NULL COMMENT '建筑物名字',
  planPicture VARCHAR(100) NOT NULL COMMENT '平面图url',
  comment  VARCHAR(100) COMMENT '描述',
  status  VARCHAR(10) COMMENT '状态',
  PRIMARY KEY (buildingId)
);

ALTER TABLE storage_building
  COMMENT '建筑物表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
CREATE TABLE storage_user
(
  userId VARCHAR(20) NOT NULL,
  nick   VARCHAR(20) COMMENT '用户名',
  avatar VARCHAR(100) NOT NULL
  COMMENT '密码',
  email  VARCHAR(30) COMMENT '邮箱',
  PRIMARY KEY (userId)
);

ALTER TABLE storage_user
  COMMENT '用户表';


/*==============================================================*/
/* View: goods_info                                                  */
/*==============================================================*/
create view storage_view_goods as
  SELECT
    `g`.`goodsId`       AS `goodsid`,
    `g`.`userId`       AS `userid`,
    `g`.`goodName`      AS `goodname`,
    `g`.`owername`      AS `owername`,
    `g`.`picture`       AS `picture`,
    `g`.`location`      AS `location`,
    `g`.`hotpointid`    AS `hotpointid`,
    `g`.`typeId`        AS `typeid`,
    `g`.`tagId`         AS `tagid`,
    `g`.`buyTime`       AS `buytime`,
    `g`.`price`         AS `price`,
    `g`.`modifyTime`    AS `modifytime`,
    `g`.`comment`       AS `goodscomment`,
    `g`.`status`        AS `goodstatus`,
    `hp`.`buildingId`       AS `buildingid`,
    `hp`.`xstart`       AS `xstart`,
    `hp`.`ystart`       AS `ystart`,
    `hp`.`xend`         AS `xend`,
    `hp`.`yend`         AS `yend`,
    `hp`.`hotPointName` AS `hotPointName`,
    `hp`.`comment`      AS `hotpointcomment`,
    `hp`.`status`       AS `hotpointstatus`,
    `bd`.`datatype`     AS `datatype`,
    `bd`.`dataname`     AS `dataname`,
    `bd`.`comment`     AS `basedatacomment`,
    `sb`.`buildingName`     AS `buildingName`,
    `sb`.`planPicture`     AS `planPicture`,
    `sb`.`comment`     AS `buildingComment`
  FROM (`storage_goods` `g`
    LEFT JOIN `storage_hot_points` `hp` on `g`.`hotpointid` = `hp`.`id`
    JOIN `storage_base_data` `bd`
    LEFT JOIN `storage_building` `sb` on `hp`.`buildingId` = `sb`.`buildingId`)
  WHERE (((`g`.`typeId` = `bd`.`id`) AND (`bd`.`datatype` = '1')) OR
         ((`g`.`tagId` = `bd`.`id`) AND (`bd`.`datatype` = '2')))