package com.shop.entity;

public class GoodsTypeInfo {
    private int id;
    private String goodstype;
    private String mark;
    private int parent_id;

    /**
     * 商品类型信息表
     * id:商品类型信息唯一标识
     * goodstype:商品类型名称
     * mark:类型描述
     * parent_id:父类型id
     */

    public GoodsTypeInfo() {
    }

    public GoodsTypeInfo(int id, String goodstype, String mark, int parent_id) {
        this.id = id;
        this.goodstype = goodstype;
        this.mark = mark;
        this.parent_id = parent_id;
    }
    public GoodsTypeInfo(int id, String goodstype) {
        this.id = id;
        this.goodstype = goodstype;
    }

    public GoodsTypeInfo(String goodstype, String mark, int parent_id) {
        this.goodstype = goodstype;
        this.mark = mark;
        this.parent_id = parent_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGoodstype() {
        return goodstype;
    }

    public void setGoodstype(String goodstype) {
        this.goodstype = goodstype;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    @Override
    public String toString() {
        return "GoodsTypeInfo{" +
                "id=" + id +
                ", goodstype='" + goodstype + '\'' +
                ", mark='" + mark + '\'' +
                ", parent_id=" + parent_id +
                '}';
    }
}
