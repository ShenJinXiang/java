-- 创建表
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL,
  `desc` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

-- 初始数据
insert into student (`name`, `age`, `sex`, `desc`) values ("刘备", 46, 1, "蜀汉开国老大");
insert into student (`name`, `age`, `sex`, `desc`) values ("李清照", 24, 0, "女词人");
insert into student (`name`, `age`, `sex`, `desc`) values ("武则天", 22, 0, "一代女皇");
insert into student (`name`, `age`, `sex`, `desc`) values ("范仲淹", 32, 1, "先天下之忧而忧，后天下之乐而乐");
insert into student (`name`, `age`, `sex`, `desc`) values ("苏秦", 26, 1, "身挂六国相印");