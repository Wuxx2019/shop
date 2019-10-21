package com.shop.dao.impl;

import com.shop.dao.CartDao;
import com.shop.entity.CartInfo;
import com.shop.entity.GoodsInfo;
import com.shop.entity.UserInfo;
import com.shop.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    @Override
    public List<CartInfo> getCartsByUser(UserInfo user) {
        List<CartInfo> carts = new ArrayList();
        try {
            Connection conn = JDBCUtil.getConnection();

            String sql = "select * from t_cart where user_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,user.getId());

            ResultSet set = ps.executeQuery();

            while(set.next()){

                int id = set.getInt("id");
                int goodsid = set.getInt("goods_id");
                int num = set.getInt("goods_count");

//                GoodsInfo goods =  new GoodsDaoImpl().getGoodsById(goodsid);
                GoodsInfo goods =  null;
                CartInfo cart = new CartInfo(id,user,goods,num);
                carts.add(cart);

            }
            conn.close();
            return carts;


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public CartInfo getCartByGid(int gid) {
        try {
            Connection conn = JDBCUtil.getConnection();

            String sql = "select * from t_cart where goods_id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1,gid);

            ResultSet set = ps.executeQuery();

            while(set.next()){

                int id = set.getInt("id");
                int num = set.getInt("goods_count");

//                GoodsInfo goods = new GoodsDaoImpl().getGoodsById(gid);
                GoodsInfo goods = null;

                CartInfo cart = new CartInfo();
                cart.setId(id);
                cart.setGoods(goods);
                cart.setGoodsCount(num);

                return cart;
            }
            conn.close();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCart(CartInfo cart, int num) {
        Connection conn = null;
        try{
            conn = JDBCUtil.getConnection();

            String sql = "update t_cart set user_id = ?,goods_id = ?,goods_count = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql); //预加载

            ps.setInt(1,cart.getUser().getId());
            ps.setInt(2,cart.getGoods().getId());
            ps.setInt(3,cart.getGoodsCount()+num);
            ps.setInt(4,cart.getId());
            ps.execute();
        }
        catch (Exception e){
            e.printStackTrace();
        }finally{
            //关闭连接
            JDBCUtil.close(conn);
        }
    }
}
