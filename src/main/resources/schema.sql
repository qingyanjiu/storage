/*==============================================================*/
/* dbms name:      mysql 5.0                                    */
/* created on:     2018/12/20 17:40:08                          */
/*==============================================================*/


drop table if exists storage_access_token;
drop table if exists storage_type;
drop table if exists storage_tag;
drop table if exists storage_goods;
drop table if exists storage_hot_points;
drop table if exists storage_building;
drop table if exists storage_user;
drop view if exists storage_view_goods;

/*==============================================================*/
/* table: access_token                                             */
/*==============================================================*/

create table `storage_access_token` (
  `access_token` varchar(3000) not null
  collate 'utf8_unicode_ci',
  `update_date`  varchar(20)   not null
  collate 'utf8_unicode_ci'
)
  collate = 'utf8_unicode_ci'
  engine = innodb;

/*==============================================================*/
/* table: storage_type                                             */
/*==============================================================*/
create table storage_type
(
  typeid       varchar(50) not null,
  typename varchar(50) comment '类型的显示名称',
  parenttypeid varchar(50) comment '父类型id,如果为空说明是父类型',
  typecomment varchar(100),
  primary key (typeid)
);

alter table storage_type
  comment '物品类型表
';

/*==============================================================*/
/* table: storage_tag                                           */
/*==============================================================*/
create table storage_tag
(
  tagid       varchar(50) not null,
  tagname varchar(50) comment '类型的显示名称',
  tagcomment varchar(100),
  primary key (tagid)
);

alter table storage_type
  comment '物品标签表
';

/*==============================================================*/
/* table: goods                                                 */
/*==============================================================*/
create table storage_goods
(
  goodsid    varchar(50) not null,
  userid     varchar(50) not null comment '用户id',
  goodname   varchar(40) not null comment '物品名称',
  owername   varchar(50) comment '所有者名字',
  picture    varchar(100) comment '物品图片',
  hotpointid varchar(50) comment '热点id',
  location   varchar(100) comment '物品收纳位置',
  typeid     varchar(50) not null comment '物品类型',
  tag      varchar(500) comment '物品tag',
  buytime    varchar(20) comment '购买时间',
  price      varchar(20) comment '购买价格',
  throwtime    varchar(20) comment '丢弃时间',
  modifytime varchar(20) comment '最近修改时间',
  comment    varchar(100) comment '备注',
  status     varchar(10) comment '物品状态',
  primary key (goodsid)
);

alter table storage_goods
  comment '物品表';

/*==============================================================*/
/* table: hot_points                                            */
/*==============================================================*/
create table storage_hot_points
(
  id           varchar(50) not null,
  userid       varchar(50) not null comment '用户id',
  buildingid   varchar(50) not null comment '建筑物id',
  xstart       varchar(20) not null comment '热点坐标',
  ystart       varchar(20) not null comment '热点坐标',
  xend         varchar(20) not null comment '热点坐标',
  yend         varchar(20) not null comment '热点坐标',
  hotpointname varchar(50) not null comment '热点名称',
  comment      varchar(100) comment '热点描述',
  status       varchar(10) comment '状态',
  primary key (id)
);

alter table storage_hot_points
  comment '热点（收纳家具）表';

/*==============================================================*/
/* table: building                                                  */
/*==============================================================*/
create table storage_building
(
  buildingid varchar(50) not null comment 'id',
  userid varchar(50) not null comment '用户id',
  buildingname   varchar(50) not null comment '建筑物名字',
  planpicture varchar(100) not null comment '平面图url',
  comment  varchar(100) comment '描述',
  status  varchar(10) comment '状态',
  primary key (buildingid)
);

alter table storage_building
  comment '建筑物表';

/*==============================================================*/
/* table: user                                                  */
/*==============================================================*/
create table storage_user
(
  userid varchar(50) not null,
  nick   varchar(50) not null comment '用户名',
  avatar varchar(200) not null comment '头像',
  email  varchar(50) comment '邮箱',
  primary key (userid)
);

alter table storage_user
  comment '用户表';


/*==============================================================*/
/* view: goods_info                                                  */
/*==============================================================*/
create view storage_view_goods as
  select
    `g`.`goodsid`       as `goodsid`,
    `g`.`userid`       as `userid`,
    `g`.`goodsname`      as `goodsname`,
    `g`.`owername`      as `owername`,
    `g`.`picture`       as `picture`,
    `g`.`location`      as `location`,
    `g`.`hotpointid`    as `hotpointid`,
    `g`.`typeid`        as `typeid`,
    `g`.`tag`         as `tag`,
    `g`.`buytime`       as `buytime`,
    `g`.`price`         as `price`,
    `g`.`throwtime`    as `throwtime`,
    `g`.`modifytime`    as `modifytime`,
    `g`.`comment`       as `goodscomment`,
    `g`.`status`        as `goodstatus`,
    `hp`.`buildingid`       as `buildingid`,
    `hp`.`xstart`       as `xstart`,
    `hp`.`ystart`       as `ystart`,
    `hp`.`xend`         as `xend`,
    `hp`.`yend`         as `yend`,
    `hp`.`hotpointname` as `hotpointname`,
    `hp`.`comment`      as `hotpointcomment`,
    `hp`.`status`       as `hotpointstatus`,
    `sb`.`buildingname`     as `buildingname`,
    `sb`.`planpicture`     as `planpicture`,
    `sb`.`comment`     as `buildingcomment`,
    `type`.`typename`     as `typename`,
    `type`.`parenttypeid`     as `parenttypeid`,
    `type`.`typecomment`     as `typecomment`
  from `storage_goods` `g`
    left join `storage_hot_points` `hp` on `g`.`hotpointid` = `hp`.`id`
    left join `storage_building` `sb` on `hp`.`buildingid` = `sb`.`buildingid`
    left join `storage_type` `type` on `g`.`typeid` = `type`.`typeid`
  order by `type`.`typename`