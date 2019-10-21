package com.shop.service;

import com.shop.common.page.Page;
import com.shop.entity.GoodsTypeInfo;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：GoodsTypeService
 * @Description：用户信息操作业务层
 * @Author：wuxingxing
 * @Date：2019/10/14 15:14
 */
public interface GoodsTypeService {

    /**
     * 获取用户列表
     * @param params
     * @return
     */
    List<GoodsTypeInfo> getGoodsTypeList(Map<String, Object> params);

    /**
     * 保存用户
     * @param goodsType 用户信息
     * @return boolean
     */
    boolean saveGoodsTypeInfo(GoodsTypeInfo goodsType);

    /**
     * 根据Id修改用户信息
     * @param goodsType 用户信息
     * @return boolean
     */
    boolean updateGoodsTypeById(GoodsTypeInfo goodsType);

    /**
     * 根据Id删除用户信息
     * @param id 用户信息
     * @return boolean
     */
    boolean deleteGoodsTypeById(GoodsTypeInfo goodsType);

    /**
     * 根据Id查询某个用户
     * @return
     */
    boolean getGoodsTypeById(GoodsTypeInfo goodsType);

    Page<GoodsTypeInfo> queryPageList(Map<String, Object> params);
}