package com.shop.service.impl;

import com.shop.common.page.Page;
import com.shop.common.page.Query;
import com.shop.dao.GoodsTypeDao;
import com.shop.dao.UserDao;
import com.shop.dao.impl.GoodsTypeDaoImpl;
import com.shop.dao.impl.UserDaoImpl;
import com.shop.entity.GoodsTypeInfo;
import com.shop.entity.UserInfo;
import com.shop.service.GoodsTypeService;
import com.shop.utils.ConstantUtil;
import com.shop.utils.MD5Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：GoodsTypeServiceImpl
 * @Description：用户信息操作业务层实现
 * @Author：wuxingxing
 * @Date：2019/10/14 15:49
 */
public class GoodsTypeServiceImpl implements GoodsTypeService {
    @Override
    public List<GoodsTypeInfo> getGoodsTypeList(Map<String, Object> params) {
        GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImpl();
        return goodsTypeDao.getGoodsTypeList(params);
    }

    @Override
    public boolean saveGoodsTypeInfo(GoodsTypeInfo goodsType) {
        GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImpl();
        return goodsTypeDao.saveGoodsType(goodsType);
    }

    @Override
    public boolean updateGoodsTypeById(GoodsTypeInfo goodsType) {
        GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImpl();
        return goodsTypeDao.updateGoodsTypeById(goodsType);
    }

    @Override
    public boolean deleteGoodsTypeById(GoodsTypeInfo goodsType) {
        GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImpl();
        return goodsTypeDao.deleteGoodsTypeById(goodsType);
    }

    @Override
    public boolean getGoodsTypeById(GoodsTypeInfo goodsType) {
        GoodsTypeDao goodsTypeDao=new GoodsTypeDaoImpl();
        return goodsTypeDao.getGoodsTypeById(goodsType);
    }

    @Override
    public Page<GoodsTypeInfo> queryPageList(Map<String, Object> params) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        Query query = new Query(params);
        List<GoodsTypeInfo> goodsTypeRoleList = getGoodsTypeList(query);
        int total = goodsTypeDao.getGoodsTypePageTotal(params);
        return new Page<GoodsTypeInfo>(total,goodsTypeRoleList);
    }
/**测试*/
//    public static void main(String[] args) {
//        GoodsTypeService GoodsTypeService = new GoodsTypeServiceImpl();
//        System.out.println(GoodsTypeService.login("111", "111"));
//
//    }
}