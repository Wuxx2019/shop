package com.shop.dao;

import com.shop.entity.GoodsInfo;
import com.shop.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：GoodsDao
 * @Description：查询数据库商品信息接口
 * @Author：wuxingxing
 * @Date：2019/10/14 12:28
 */
public interface GoodsDao {

    /**
     * 获取商品列表
     * @param params
     * @return
     */
    List<GoodsInfo> getGoodsList(Map<String, Object> params);

    /**
     * 保存用户
     * @param goods 商品信息
     * @return boolean
     */
    boolean saveGoods(GoodsInfo goods);

    /**
     * 根据Id修改商品信息
     * @param goods 商品信息
     * @return boolean
     */
    boolean updateGoodsById(GoodsInfo goods);

    /**
     * 根据Id删除商品信息
     * @param goods 商品信息
     * @return boolean
     */
    boolean deleteGoodsById(GoodsInfo goods);

    /**
     * 根据Id查找商品信息
     * @param i 商品信息
     * @return boolean
     */
    GoodsInfo getGoodsById(int i);

    /**
     *
     * @param params 查询参数
     * @return boolean
     */
    int getGoodsPageTotal(Map<String, Object> params);
}