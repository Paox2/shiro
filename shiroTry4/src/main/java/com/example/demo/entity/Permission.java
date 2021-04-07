package com.example.demo.entity;

import java.util.Date;

public class Permission {

    private String username;
    private String permissionName;
    private Date createTime;

    public Permission(String username, String permissionName, Date createTime) {
        this.username = username;
        this.permissionName = permissionName;
        this.createTime = createTime;
    }

    public Permission() {
    }

    public String getUsername() {
        return username;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "username='" + username + '\'' +
                ", permissionName='" + permissionName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
