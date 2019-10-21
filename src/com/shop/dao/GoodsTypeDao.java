package com.shop.dao;

import com.shop.entity.GoodsTypeInfo;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：GoodsTypeDao
 * @Description：查询数据库用户信息接口
 * @Author：wuxingxing
 * @Date：2019/10/14 12:28
 */
public interface GoodsTypeDao {

    /**
     * 获取商品列表
     * @param params
     * @return
     */
    List<GoodsTypeInfo> getGoodsTypeList(Map<String, Object> params);

    /**
     * 保存用户
     * @param goodsType 商品信息
     * @return boolean
     */
    boolean saveGoodsType(GoodsTypeInfo goodsType);

    /**
     * 根据Id修改用户信息
     * @param goodsType 商品信息
     * @return boolean
     */
    boolean updateGoodsTypeById(GoodsTypeInfo goodsType);

    /**
     * 根据Id删除用户信息
     * @param goodsType 商品信息
     * @return boolean
     */
    boolean deleteGoodsTypeById(GoodsTypeInfo goodsType);

    /**
     * 根据Id获得一个商品信息
     * @param goodsType 商品信息
     * @return boolean
     */
    boolean getGoodsTypeById(GoodsTypeInfo goodsType);

    /**
     *
     * @param params 查询参数
     * @return boolean
     */
    int getGoodsTypePageTotal(Map<String, Object> params);
}