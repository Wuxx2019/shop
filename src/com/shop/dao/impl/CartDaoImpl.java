package com.shop.dao.impl;

import com.shop.common.BaseDao;
import com.shop.common.ConnectionFactory;
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
import java.util.Map;

public class CartDaoImpl extends BaseDao implements CartDao {
    @Override
    public List<CartInfo> getCartsByUser(UserInfo user) {
        List<CartInfo> carts = new ArrayList();
        try {
            Connection conn = JDBCUtil.getConnection();
            String sql = "select * from t_cart where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,user.getId());
            ResultSet set = ps.executeQuery();
            GoodsInfo goodsInfo=new GoodsInfo();
            while(set.next()){
                int id = set.getInt("id");
                int goodsid = set.getInt("goods_id");
                int num = set.getInt("goods_count");
                GoodsInfo goods =  new GoodsDaoImpl().getGoodsById(goodsid);
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
                GoodsInfo goods = new GoodsDaoImpl().getGoodsById(gid);
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
    public int getCartPageTotal(Map<String, Object> params) {
        int result = 0;
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("select count(1) value from t_cart");
        //设置查询条件
        commonSqlParams(sql, params);
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            resultSet=preparedStatement.executeQuery();
            //遍历所有的行
            while(resultSet.next()){
                //创建Goods对象
                result = resultSet.getInt("value");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //关闭所有链接释放资源
            ConnectionFactory.closeAllConnection(connection, preparedStatement, resultSet);
        }
        return result;
    }

    @Override
    public boolean updateCart(CartInfo cart, int num) {
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
            return  true;
        }
        catch (Exception e){
            e.printStackTrace();
        }finally{
            //关闭连接
            JDBCUtil.close(conn);
        }
        return false;
    }

    public StringBuffer commonSqlParams(StringBuffer sql,Map<String, Object> params){
        //如果参数为null 直接返回sql
        if(null == params || params.isEmpty()){
            return sql;
        }
        //开始拼接参数
        sql.append(" where 1=1 ");
        //可在下面拼接任意查询条件，例如GoodsName;
        // 因为GoodsName是字符类型所以要比对空字符，如果不是字符类型则不需要加此限制条件
        //可在下方拼接排序，分页等字段

        if(params.containsKey("goodsname") && !"".equals(params.get("goodsname"))){
            sql.append(" and goodsname = '").append(params.get("goodsname")).append("'");
        }
        if(params.containsKey("goodstype") && !"".equals(params.get("goodstype"))){
            sql.append(" and goodstype = '").append(params.get("goodstype")).append("'");
        }


        return sql;
    }
}
