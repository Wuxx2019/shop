package com.shop.entity;

public class CartInfo {
    private int id;
    private UserInfo user;
    private GoodsInfo goods;
    private int goodsCount;

    /**
     * 购物车信息表
     * id:购物车信息唯一标识
     * user:外键
     * goods:外键
     * goodsCount：购物车中商品数量
     */

    public CartInfo() {
    }

    public CartInfo(int id, UserInfo user, GoodsInfo goods, int goodsCount) {
        this.id = id;
        this.user = user;
        this.goods = goods;
        this.goodsCount = goodsCount;
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

    public GoodsInfo getGoods() {
        return goods;
    }

    public void setGoods(GoodsInfo goods) {
        this.goods = goods;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    @Override
    public String toString() {
        return "CartInfo{" +
                "id=" + id +
                ", user=" + user +
                ", goods=" + goods +
                ", goodsCount=" + goodsCount +
                '}';
    }
}
