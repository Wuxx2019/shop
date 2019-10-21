package com.shop.service;

import com.shop.common.page.Page;
import com.shop.entity.GoodsInfo;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：GoodsService
 * @Description：商品信息操作业务层
 * @Author：wuxingxing
 * @Date：2019/10/14 15:14
 */
public interface GoodsService {

    /**
     * 获取商品列表
     * @param params
     * @return
     */
    List<GoodsInfo> getGoodsList(Map<String, Object> params);

    /**
     * 保存商品
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
     * 根据Id查询某个商品
     * @return
     */
    boolean getGoodsById(GoodsInfo goods);
    

    /**
     * 获取指定数据
     *
     * @param params 分页查询参数
     * @return 对象列表
     */
    Page<GoodsInfo> queryPageList(Map<String, Object> params);

}