package com.shop.dao;

import com.shop.entity.CartInfo;
import com.shop.entity.UserInfo;

import java.util.List;

public interface CartDao {
    public abstract List<CartInfo> getCartsByUser(UserInfo user);

    public abstract CartInfo getCartByGid(int gid);

    public abstract void updateCart(CartInfo cart, int num);
}
