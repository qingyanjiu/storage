
/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2018/12/20 17:40:08                          */
/*==============================================================*/


drop table if exists access_token;
drop table if exists base_data;

drop table if exists goods;

drop table if exists goods_hotpoints_relation;

drop table if exists hot_points;

drop table if exists user;

/*==============================================================*/
/* Table: access_token                                             */
/*==============================================================*/

CREATE TABLE `access_token` (
	`access_token` VARCHAR(3000) NOT NULL COLLATE 'utf8_unicode_ci',
	`update_date` VARCHAR(20) NOT NULL COLLATE 'utf8_unicode_ci'
)
	COLLATE='utf8_unicode_ci'
	ENGINE=InnoDB
;

/*==============================================================*/
/* Table: base_data                                             */
/*==============================================================*/
create table base_data
(
	id                   varchar(20) not null,
	datatype               varchar(20) comment '类型 1-物品类型 2-标签',
	dataname                 varchar(50) comment 'type或者tag的显示名称',
	comments             varchar(100),
	primary key (id)
);

alter table base_data comment '基础数据表，如物品类型、标签等数据
';

/*==============================================================*/
/* Table: goods                                                 */
/*==============================================================*/
create table goods
(
	goodsId              varchar(10) not null,
	goodName                 varchar(40) comment '物品名称',
	picture              varchar(100) comment '物品图片',
	hotpointid             varchar(50) comment '热点id',
	location             varchar(100) comment '物品收纳位置',
	typeId                varchar(20) comment '物品类型',
	tagId                varchar(20) comment '物品tag',
	buyTime              varchar(20) comment '购买时间',
	price                varchar(20) comment '购买价格',
	modifyTime           varchar(20) comment '最近修改时间',
	comment              varchar(100) comment '备注',
	status               varchar(10) comment '物品状态',
	primary key (goodsId)
);

alter table goods comment '物品表';

/*==============================================================*/
/* Table: hot_points                                            */
/*==============================================================*/
create table hot_points
(
	id                   varchar(10) not null,
	xstart               varchar(20) comment '热点坐标',
	ystart               varchar(20) comment '热点坐标',
	xend                 varchar(20) comment '热点坐标',
	yend                 varchar(20) comment '热点坐标',
	hotPointName          varchar(50) comment '热点名称',
	comment              varchar(100) comment '热点描述',
	status               varchar(10) comment '状态',
	primary key (id)
);

alter table hot_points comment '热点（收纳家具）表';

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
	userId                   varchar(20) not null,
	nick             varchar(20) comment '用户名',
	avatar             varchar(20) not null comment '密码',
	email               varchar(10) comment '邮箱',
	primary key (userId)
);

alter table user comment '用户表';
