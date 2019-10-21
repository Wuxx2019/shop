package com.shop.entity;

public class AddressInfo {
    private int id;
    private UserInfo user;
    private String address;
    private int postalcode;
    private String conname;
    private String conphone;

    /**
     * 地址表
     * id:地址信息唯一标识
     * user:外键 用户id，当前购地址数据属于哪个用户
     * address:收货详细地址
     * postalcode:邮政编码
     * conname:收货人姓名
     * conphone:收货人电话
     */

    public AddressInfo() {
    }

    public AddressInfo(int id, UserInfo user, String address, int postalcode, String conname, String conphone) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.postalcode = postalcode;
        this.conname = conname;
        this.conphone = conphone;
    }

    public AddressInfo(UserInfo user, String address, int postalcode, String conname, String conphone) {
        this.user = user;
        this.address = address;
        this.postalcode = postalcode;
        this.conname = conname;
        this.conphone = conphone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public String getConname() {
        return conname;
    }

    public void setConname(String conname) {
        this.conname = conname;
    }

    public String getConphone() {
        return conphone;
    }

    public void setConphone(String conphone) {
        this.conphone = conphone;
    }

    @Override
    public String toString() {
        return "AddressInfo{" +
                "id=" + id +
                ", user=" + user +
                ", address='" + address + '\'' +
                ", postalcode=" + postalcode +
                ", conname='" + conname + '\'' +
                ", conphone='" + conphone + '\'' +
                '}';
    }
}
