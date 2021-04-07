DROP DATABASE IF EXISTS shiro;
CREATE DATABASE shiro DEFAULT CHARACTER SET utf8mb4;
USE shiro;
 
drop table if exists user;
drop table if exists role;
drop table if exists permission;
 
create table user (
  id Integer,
  username varchar(255) unique,
  password varchar(255),
  salt varchar(255)
) charset=utf8 ENGINE=InnoDB;
 
create table role (
  username varchar(255),
  roleName varchar(255),
  createTime date
) charset=utf8 ENGINE=InnoDB;
 
create table permission (
  username varchar(255),
  permissionName varchar(255),
  createTime date
) charset=utf8 ENGINE=InnoDB;