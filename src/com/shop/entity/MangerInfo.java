package com.shop.entity;

public class MangerInfo {
    private  int id;
    private  String name;
    private  String password;
    private  int role;

    /**
     * 管理员表
     * id:管理员的唯一标识
     * name:管理员用户名，用于登录
     * password:管理员密码（123456）
     * role:1.超级管理员 2.普通管理员
     */

    public MangerInfo() {
    }

    public MangerInfo(int id, String name, String password, int role) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public MangerInfo(String name, String password, int role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "MangerInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
