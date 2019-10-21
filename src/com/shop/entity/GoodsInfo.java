package com.shop.entity;

import java.util.Date;

public class GoodsInfo {
    private int id;
    private String goodsname;
    private double goodsprice;
    private String goodsimageurl;
    private Date goodstime;
    private int goodsstate;
    private String goodsInfo;
    private int num;

    private GoodsTypeInfo goodsType;

    /**
     * 商品信息表
     * id:商品信息唯一标识
     * goodsname:商品名称
     * goodsprice:商品价格
     * goodsimageurl:商品图片路径
     * goodsclass:商品种类
     * goodsstate:商品状态  1.上架，2.下架
     * goodsInfo:商品简介
     * num:商品库存
     * goodsType：商品类型  外键
     */

    public GoodsInfo() {
    }

    public GoodsInfo(int id, String goodsname, double goodsprice, String goodsimageurl, Date goodstime, int goodsstate, String goodsInfo, int num, GoodsTypeInfo goodsType) {
        this.id = id;
        this.goodsname = goodsname;
        this.goodsprice = goodsprice;
        this.goodsimageurl = goodsimageurl;
        this.goodstime = goodstime;
        this.goodsstate = goodsstate;
        this.goodsInfo = goodsInfo;
        this.num = num;
        this.goodsType = goodsType;
    }

    public GoodsInfo(String goodsname, double goodsprice, String goodsimageurl, Date goodstime, int goodsstate, String goodsInfo, int num, GoodsTypeInfo goodsType) {
        this.goodsname = goodsname;
        this.goodsprice = goodsprice;
        this.goodsimageurl = goodsimageurl;
        this.goodstime = goodstime;
        this.goodsstate = goodsstate;
        this.goodsInfo = goodsInfo;
        this.num = num;
        this.goodsType = goodsType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public String getGoodsimageurl() {
        return goodsimageurl;
    }

    public void setGoodsimageurl(String goodsimageurl) {
        this.goodsimageurl = goodsimageurl;
    }

    public Date getGoodstime() {
        return goodstime;
    }

    public void setGoodstime(Date goodstime) {
        this.goodstime = goodstime;
    }

    public int getGoodsstate() {
        return goodsstate;
    }

    public void setGoodsstate(int goodsstate) {
        this.goodsstate = goodsstate;
    }

    public String getGoodsInfo() {
        return goodsInfo;
    }

    public void setGoodsInfo(String goodsInfo) {
        this.goodsInfo = goodsInfo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public GoodsTypeInfo getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(GoodsTypeInfo goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public String toString() {
        return "GoodsInfo{" +
                "id=" + id +
                ", goodsname='" + goodsname + '\'' +
                ", goodsprice=" + goodsprice +
                ", goodsimageurl='" + goodsimageurl + '\'' +
                ", goodstime=" + goodstime +
                ", goodsstate=" + goodsstate +
                ", goodsInfo='" + goodsInfo + '\'' +
                ", num=" + num +
                ", goodsType=" + goodsType +
                '}';
    }
}
