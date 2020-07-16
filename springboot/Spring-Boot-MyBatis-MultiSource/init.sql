-- mysql-db1
-- 创建表 student
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- 初始数据
insert into student (`name`, `age`, `sex`, `desc`) values ("刘备", 46, 1, "蜀汉开国老大");
insert into student (`name`, `age`, `sex`, `desc`) values ("李清照", 24, 0, "女词人");
insert into student (`name`, `age`, `sex`, `desc`) values ("武则天", 22, 0, "一代女皇");
insert into student (`name`, `age`, `sex`, `desc`) values ("范仲淹", 32, 1, "先天下之忧而忧，后天下之乐而乐");
insert into student (`name`, `age`, `sex`, `desc`) values ("苏秦", 26, 1, "身挂六国相印");

-- mysql-db2
-- 创建表 emperor
CREATE TABLE `emperor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `dynasty` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
insert into emperor (`name`, `dynasty`) values ('刘彻', '汉');
insert into emperor (`name`, `dynasty`) values ('杨广', '隋');
insert into emperor (`name`, `dynasty`) values ('李世民', '唐');
insert into emperor (`name`, `dynasty`) values ('朱厚照', '明');


-- oracle-db3
create table BOOK
(
  id     number not null,
  name   varchar2(200),
  author varchar2(100)
)
tablespace SPB
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column BOOK.name
  is '名称';
comment on column BOOK.author
  is '作者';

alter table BOOK
  add constraint PK_BOOK_ID primary key (ID);

-- Create sequence
create sequence SEQ_BOOK_ID
minvalue 0
maxvalue 99999999999
start with 0
increment by 1
cache 20;

insert into BOOK (ID, NAME, AUTHOR) VALUES (SEQ_BOOK_ID.NEXTVAL, '万万没想到', '万维刚');
insert into BOOK (ID, NAME, AUTHOR) VALUES (SEQ_BOOK_ID.NEXTVAL, '三体', '刘慈欣');
insert into BOOK (ID, NAME, AUTHOR) VALUES (SEQ_BOOK_ID.NEXTVAL, '盲人钟表匠', '理查德·道金斯');
insert into BOOK (ID, NAME, AUTHOR) VALUES (SEQ_BOOK_ID.NEXTVAL, '四夷居中国', '张经纬');