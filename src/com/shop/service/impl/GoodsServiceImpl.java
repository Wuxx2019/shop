package com.shop.service.impl;

import com.shop.common.page.Page;
import com.shop.common.page.Query;
import com.shop.dao.GoodsDao;
import com.shop.dao.impl.GoodsDaoImpl;
import com.shop.entity.GoodsInfo;
import com.shop.service.GoodsService;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：GoodsServiceImpl
 * @Description：用户信息操作业务层实现
 * @Author：wuxingxing
 * @Date：2019/10/14 15:49
 */
public class GoodsServiceImpl implements GoodsService {
    @Override
    public List<GoodsInfo> getGoodsList(Map<String, Object> params) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        return goodsDao.getGoodsList(params);
    }

    @Override
    public boolean saveGoods(GoodsInfo goods) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        return goodsDao.saveGoods(goods);
    }

    @Override
    public boolean updateGoodsById(GoodsInfo goods) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        return goodsDao.updateGoodsById(goods);
    }

    @Override
    public boolean deleteGoodsById(GoodsInfo goods) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        return goodsDao.deleteGoodsById(goods);
    }

    @Override
    public boolean getGoodsById(GoodsInfo goods) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        return goodsDao.getGoodsById(goods);
    }

    @Override
    public Page<GoodsInfo> queryPageList(Map<String, Object> params) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        Query query = new Query(params);
        List<GoodsInfo> goodsRoleList = getGoodsList(query);
        int total = goodsDao.getGoodsPageTotal(params);
        return new Page<GoodsInfo>(total,goodsRoleList);
    }

/**测试*/
//    public static void main(String[] args) {
//        GoodsService GoodsService = new GoodsServiceImpl();
//        System.out.println(GoodsService.login("111", "111"));
//
//    }
}