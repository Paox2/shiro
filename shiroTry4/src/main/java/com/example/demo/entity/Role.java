package com.example.demo.entity;

import java.util.Date;

public class Role {
    private String username;
    private String roleName;
    private Date createTime;

    public Role(String username, String roleName, Date createTime) {
        this.username = username;
        this.roleName = roleName;
        this.createTime = createTime;
    }

    public Role() {
    }

    public String getUsername() {
        return username;
    }

    public String getRoleName() {
        return roleName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Role{" +
                "username='" + username + '\'' +
                ", roleName='" + roleName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
