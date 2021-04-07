DROP DATABASE IF EXISTS shiro;
CREATE DATABASE shiro DEFAULT CHARACTER SET utf8mb4;
USE shiro;
 
drop table if exists user;
drop table if exists role;
drop table if exists permission;
drop table if exists user_role;
drop table if exists role_permission;
 
create table user (
  id bigint auto_increment,
  name varchar(100),
  password varchar(100),
  constraint pk_users primary key(id)
) charset=utf8 ENGINE=InnoDB;
 
create table role (
  id bigint auto_increment,
  name varchar(100),
  constraint pk_roles primary key(id)
) charset=utf8 ENGINE=InnoDB;
 
create table permission (
  id bigint auto_increment,
  name varchar(100),
  constraint pk_permissions primary key(id)
) charset=utf8 ENGINE=InnoDB;
 
create table user_role (
  uid bigint,
  rid bigint,
  constraint pk_users_roles primary key(uid, rid)
) charset=utf8 ENGINE=InnoDB;
 
create table role_permission (
  rid bigint,
  pid bigint,
  constraint pk_roles_permissions primary key(rid, pid)
) charset=utf8 ENGINE=InnoDB;

INSERT INTO `permission` VALUES (1,'findAllUser');
INSERT INTO `permission` VALUES (2,'findUserById');
INSERT INTO `role` VALUES (1,'admin');
INSERT INTO `role` VALUES (2,'user');
INSERT INTO `role_permission` VALUES (1,1);
INSERT INTO `role_permission` VALUES (1,2);
INSERT INTO `role_permission` VALUES (2,1);
INSERT INTO `user` VALUES (1,'suer1','pwd1');
INSERT INTO `user` VALUES (2,'user2','pwd2');
INSERT INTO `user_role` VALUES (1,1);
INSERT INTO `user_role` VALUES (2,2);
