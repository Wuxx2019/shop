package com.shop.entity;

import java.util.Date;

public class UserInfo {
    private int id;
    private String username;
    private String password;
    private String realname;
    private String cardid;
    private Date birthday;
    private String phone;
    private String userInfo;

    /**
     *用户信息表
     * id:用户表的唯一标识
     * username:用户名，唯一的，用于用户登录
     * password:用户密码，用户用户登录,存储到数据库中的密码，需要进行加密（MD5）
     * realname:用户的真实姓名
     * cardid:身份证号
     * birthday:生日
     * phone:个人电话
     * userInfo:个人简介
     */

    public UserInfo() {
    }

    public UserInfo(int id, String username, String password, String realname, String cardid, Date birthday, String phone, String userInfo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.cardid = cardid;
        this.birthday = birthday;
        this.phone = phone;
        this.userInfo = userInfo;
    }

    public UserInfo(int id, String username, String password, String realname) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.realname = realname;
    }

    public UserInfo(String username, String password, String realname, String cardid, Date birthday, String phone, String userInfo) {
        this.username = username;
        this.password = password;
        this.realname = realname;
        this.cardid = cardid;
        this.birthday = birthday;
        this.phone = phone;
        this.userInfo = userInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(String userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realname='" + realname + '\'' +
                ", cardid='" + cardid + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                ", userInfo='" + userInfo + '\'' +
                '}';
    }
}
