package com.shop.entity;

import java.util.Date;

public class OrderInfo {
    private int id;
    private String orderseq;
    private GoodsInfo goods;
    private String goodsName;
    private int goodsNum;
    private double goodsPrice;
    private Date ordertime;
    private UserInfo user;
    private String conname;
    private String address;
    private int orderstate;

    /**
     * 订单信息表
     * id:订单表唯一标识
     * orderseq:订单序列号
     * goods:外键
     * goodsName:订单中的商品名称
     * goodsNum:订单中的商品数量
     * goodsPrice:订单中的商品价格
     * ordertime:下单时间
     * user:外键
     * conname:订单中的收货人名称
     * address:订单中的收获地址
     * orderstate:订单状态  1.表示未支付  2.表示已支付（待发货） 3.已发货（待收货） 4.交易完成（收货）
     */

    public OrderInfo() {
    }

    public OrderInfo(String orderseq, GoodsInfo goods, String goodsName, int goodsNum, double goodsPrice, Date ordertime, UserInfo user, String conname, String address, int orderstate) {
        this.orderseq = orderseq;
        this.goods = goods;
        this.goodsName = goodsName;
        this.goodsNum = goodsNum;
        this.goodsPrice = goodsPrice;
        this.ordertime = ordertime;
        this.user = user;
        this.conname = conname;
        this.address = address;
        this.orderstate = orderstate;
    }

    public OrderInfo(int id, String orderseq, GoodsInfo goods, String goodsName, int goodsNum, double goodsPrice, Date ordertime, UserInfo user, String conname, String address, int orderstate) {
        this.id = id;
        this.orderseq = orderseq;
        this.goods = goods;
        this.goodsName = goodsName;
        this.goodsNum = goodsNum;
        this.goodsPrice = goodsPrice;
        this.ordertime = ordertime;
        this.user = user;
        this.conname = conname;
        this.address = address;
        this.orderstate = orderstate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderseq() {
        return orderseq;
    }

    public void setOrderseq(String orderseq) {
        this.orderseq = orderseq;
    }

    public GoodsInfo getGoods() {
        return goods;
    }

    public void setGoods(GoodsInfo goods) {
        this.goods = goods;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public String getConname() {
        return conname;
    }

    public void setConname(String conname) {
        this.conname = conname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getOrderstate() {
        return orderstate;
    }

    public void setOrderstate(int orderstate) {
        this.orderstate = orderstate;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id=" + id +
                ", orderseq='" + orderseq + '\'' +
                ", goods=" + goods +
                ", goodsName='" + goodsName + '\'' +
                ", goodsNum=" + goodsNum +
                ", goodsPrice=" + goodsPrice +
                ", ordertime=" + ordertime +
                ", user=" + user +
                ", conname='" + conname + '\'' +
                ", address='" + address + '\'' +
                ", orderstate=" + orderstate +
                '}';
    }
}
