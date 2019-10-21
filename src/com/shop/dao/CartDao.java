package com.shop.dao;

import com.shop.entity.CartInfo;
import com.shop.entity.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：CartDao
 * @Description：查询数据库购物车信息接口
 * @Author：wuxingxing
 * @Date：2019/10/14 12:28
 */

public interface CartDao {

    /**
     * 根据用户获取当前用户购物车
     * @param user
     * @return List<CartInfo>
     */
    List<CartInfo> getCartsByUser(UserInfo user);

    /**
     * 根据商品信息获取当前用户购物车
     * @param gid
     * @return CartInfo
     */
    CartInfo getCartByGid(int gid);

    /**
     * 购物车更新
     * @param cart
     * @param num
     * @return boolean
     */
    boolean updateCart(CartInfo cart, int num);

    int getCartPageTotal(Map<String, Object> params);
}
