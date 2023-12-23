######  创建用户表  ########
CREATE TABLE `b_user` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`name` VARCHAR(200) NOT NULL COMMENT '账号',
	`byname` VARCHAR(200) NOT NULL COMMENT '用户名',
	`password` VARCHAR(30) NOT NULL COMMENT '密码',
	`sex` INT(1) NOT NULL COMMENT '性别',
	`vip` INT(2) NOT NULL COMMENT '会员等级',
	`avatar` VARCHAR(200) NOT NULL COMMENT '用户头像',
	`balance` FLOAT(100,2) NOT NULL COMMENT '用户余额',
	`expended` FLOAT(100,2) NOT NULL COMMENT '用户充值总数',
	`phone` INT(50) NOT NULL COMMENT '用户手机号',
	`email` VARCHAR(50) NOT NULL COMMENT '用户邮箱',
	`age` INT(10) NOT NULL COMMENT '用户年龄',
	`birth` DATE NOT NULL COMMENT '用户生日',
	`free` FLOAT(100,2) NOT NULL COMMENT '免费货币',
	`level` INT(1) NOT NULL COMMENT '等级',
	`adress` VARCHAR(200) NOT NULL COMMENT '地址',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


######  创建管理员表  ########
CREATE TABLE `b_admin` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`name` VARCHAR(200) NOT NULL COMMENT '账号',
	`byname` VARCHAR(200) NOT NULL COMMENT '用户名',
	`password` VARCHAR(30) NOT NULL COMMENT '密码',
	`phone` INT(50) NOT NULL COMMENT '手机号',
	`email` VARCHAR(50) NOT NULL COMMENT '邮箱',
	`level` INT(1) NOT NULL COMMENT '等级',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


######  创建角色表  ########
CREATE TABLE `b_role` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`name` VARCHAR(200) NOT NULL COMMENT '账号',
	`byname` VARCHAR(200) NOT NULL COMMENT '用户名',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


######  创建书籍表  ########
CREATE TABLE `b_book` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`name` VARCHAR(200) NOT NULL COMMENT '书名',
	`synopsis` TINYTEXT NOT NULL COMMENT '简介',
	`auther_id` VARCHAR(32) NOT NULL COMMENT '作者id',
	`auther_name` VARCHAR(200) NOT NULL COMMENT '作者名',
	`vip` INT(1) NOT NULL COMMENT '会员',
	`status` INT(1) NOT NULL COMMENT '状态',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


######  创建章节表  ########
CREATE TABLE `b_chapter` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`no` INT(20) NOT NULL COMMENT '章节数',
	`name` VARCHAR(200) NOT NULL COMMENT '章节名',
	`text` LONGTEXT NOT NULL COMMENT '章节内容',
	`vip` INT(1) NOT NULL COMMENT '会员',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;



######  创建菜单表  ########
CREATE TABLE `b_menu` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`component` VARCHAR(200) NOT NULL COMMENT 'vue中的组件名',
	`path` VARCHAR(200) NOT NULL COMMENT '浏览器路由名',
	`redirect` VARCHAR(200) NOT NULL COMMENT '重定向路径',
	`name` VARCHAR(200) NOT NULL COMMENT 'vue中的路径',
	`title` VARCHAR(200) NOT NULL COMMENT '对应路由的中文标题',
	`icon` VARCHAR(20) NOT NULL COMMENT '对应图标',
	`parent_id` VARCHAR(32) NOT NULL COMMENT '父菜单',
	`is_left` VARCHAR(1) NOT NULL COMMENT '子菜单',
		PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


######  创建标签表  ########
CREATE TABLE `b_tags` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`name` VARCHAR(200) NOT NULL COMMENT '标签名',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


######  创建角色_菜单表  ########
CREATE TABLE `b_role_menu` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`role_id` VARCHAR(32) NOT NULL COMMENT '角色id',
	`menu_id` VARCHAR(32) NOT NULL COMMENT '菜单id',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


######  创建用户_角色表  ########
CREATE TABLE `b_user_role` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`user_id` VARCHAR(32) NOT NULL COMMENT '用户id',
	`role_id` VARCHAR(32) NOT NULL COMMENT '角色id',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


######  创建用户_书籍表 用于收藏 ########
CREATE TABLE `b_user_book` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`user_id` VARCHAR(32) NOT NULL COMMENT '用户id',
	`book_id` VARCHAR(32) NOT NULL COMMENT '书籍id',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


######  创建用户_章节表 用于历史 ########
CREATE TABLE `b_user_chapter` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`user_id` VARCHAR(32) NOT NULL COMMENT '用户id',
	`chapter_id` VARCHAR(32) NOT NULL COMMENT '章节id',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


######  创建书籍_章节表 ########
CREATE TABLE `b_book_chapter` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`book_id` VARCHAR(32) NOT NULL COMMENT '书籍id',
	`chapter_id` VARCHAR(32) NOT NULL COMMENT '章节id',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;


######  创建书籍_标签表 ########
CREATE TABLE `b_book_tags` (
	`id` VARCHAR(32) NOT NULL COMMENT 'id',
	`create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
	`create_id` VARCHAR(32) NOT NULL COMMENT '创建人id',
	`update_time` DATETIME NOT NULL COMMENT '修改时间',
	`update_id` VARCHAR(32) NOT NULL COMMENT '修改人id',
	`del_flag` INT(1) NOT NULL COMMENT '删除标记',
	`book_id` VARCHAR(32) NOT NULL COMMENT '书籍id',
	`tag_id` VARCHAR(32) NOT NULL COMMENT '标签id',
	PRIMARY KEY(`id`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
