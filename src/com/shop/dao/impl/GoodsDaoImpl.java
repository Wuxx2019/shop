package com.shop.dao.impl;

import com.shop.common.BaseDao;
import com.shop.common.ConnectionFactory;
import com.shop.dao.GoodsDao;
import com.shop.dao.GoodsTypeDao;
import com.shop.entity.GoodsInfo;
import com.shop.entity.GoodsTypeInfo;

import java.sql.SQLException;
import java.util.*;

/**
 * @ProjectName：shop
 * @ClassName：GoodsDaoImpl
 * @Description：查询数据库用户信息接口实现
 * @Author：wuxingxing
 * @Date：2019/10/14 12:29
 */
public class GoodsDaoImpl extends BaseDao implements GoodsDao {

    @Override
    public List<GoodsInfo> getGoodsList(Map<String, Object> params) {
        //创建用户列表
        List<GoodsInfo> goodss=new ArrayList<GoodsInfo>();
        //获取连接
        connection= ConnectionFactory.getConnection();
        //创建基础查询sql
        StringBuffer sql = new StringBuffer();
        sql.append("select ");
        sql.append("id , goodsname ,goodsprice ,goodsimageurl, goodstime, goodsstate ,goodsInfo,  goodstype, num");
        sql.append(" from t_goods ");
        //设置查询条件
        commonSqlParams(sql, params);
        //分页查询一定在条件的后边
        commonSqlPage(sql, params);
        try {
            GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
            System.out.println("查询的sql语句："+sql);
            preparedStatement=connection.prepareStatement(sql.toString());
            resultSet=preparedStatement.executeQuery();
            //遍历所有的行
            while(resultSet.next()){
                //创建Goods对象
                GoodsInfo goods = new GoodsInfo();
                Map<String,Object> param = new HashMap<String, Object>();
                param.put("id",resultSet.getString("goodstype"));
                //将每一行的数据放入Goods对象中
                //id为表格字段名称
                goods.setId(resultSet.getInt("id"));
                goods.setGoodsname(resultSet.getString("goodsname"));
                goods.setGoodsprice(resultSet.getDouble("goodsprice"));
                goods.setGoodsimageurl(resultSet.getString("goodsimageurl"));
                goods.setGoodstime(resultSet.getDate("goodstime"));
                goods.setGoodsstate(resultSet.getInt("goodsstate"));
                goods.setGoodsInfo(resultSet.getString("GoodsInfo"));
                List<GoodsTypeInfo> goodsTypeInfoList = goodsTypeDao.getGoodsTypeList(param);
                if(goodsTypeInfoList != null && goodsTypeInfoList.size() == 1){
                    goods.setGoodsType(goodsTypeInfoList.get(0));
                }
                goods.setNum(resultSet.getInt("num"));
                //将结果集对象放入结果集列表
                goodss.add(goods);
                System.out.println("查询的数量："+goodss.size());
                System.out.println("查询的结果："+goodss.toString());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //关闭所有链接释放资源
            ConnectionFactory.closeAllConnection(connection, preparedStatement, resultSet);
        }
        return goodss;
    }

    @Override
    public boolean saveGoods(GoodsInfo goods) {
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        //mysql库表ID主键使用的是自增策略，所以这里不对ID进行赋值添加
        sql.append("insert into t_goods (goodsname,goodsprice,goodsimageurl,goodstime,goodsInfo,goodsstate,goodstype,num) value ");
        sql.append(" (?,?,?,?,?,?,?,?) ");
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            //这里在对参数进行赋值时请确认赋值的顺序是否一致（数字1代表sql中第一个？）
            preparedStatement.setObject(1,goods.getGoodsname());
            preparedStatement.setObject(2,goods.getGoodsprice());
            preparedStatement.setObject(3,goods.getGoodsimageurl());
            preparedStatement.setObject(4,goods.getGoodstime());
            preparedStatement.setObject(5,goods.getGoodsstate());
            preparedStatement.setObject(6,goods.getGoodsInfo());
            preparedStatement.setObject(7,goods.getGoodsType());
            preparedStatement.setObject(8,goods.getNum());
            int ret=preparedStatement.executeUpdate();
            if(ret>0){
                System.out.println("保存成功！");
                return true;
            }else
            {
                System.out.println("保存失败！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            ConnectionFactory.closeAllConnection(connection, preparedStatement, resultSet);
        }
        return false;
    }

    @Override
    public boolean updateGoodsById(GoodsInfo goods) {
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("update t_goods set goodsname = ?,goodsprice = ?,goodsimageurl = ?,goodstime = ?,goodsstate = ?, ");
        sql.append("goodsInfo = ?,goodstype = ? , num = ? ");
        sql.append("where id = ?");
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            //这里在对参数进行赋值时请确认赋值的顺序是否一致（数字1代表sql中第一个？）
            preparedStatement.setObject(1,goods.getGoodsname());
            preparedStatement.setObject(2,goods.getGoodsprice());
            preparedStatement.setObject(3,goods.getGoodsimageurl());
            preparedStatement.setObject(4,goods.getGoodstime());
            preparedStatement.setObject(5,goods.getGoodsstate());
            preparedStatement.setObject(6,goods.getGoodsInfo());
            preparedStatement.setObject(7,goods.getGoodsType());
            preparedStatement.setObject(8,goods.getNum());
            preparedStatement.setObject(9,goods.getId());
            int ret=preparedStatement.executeUpdate();
            if(ret>0){
                System.out.println("修改成功！");
                return true;
            }else
            {
                System.out.println("修改失败！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            ConnectionFactory.closeAllConnection(connection, preparedStatement, resultSet);
        }
        return false;
    }

    @Override
    public boolean deleteGoodsById(GoodsInfo goods) {
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("delete from t_goods where id = ?");
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            preparedStatement.setObject(1,goods.getId());
            int ret=preparedStatement.executeUpdate();
            if(ret>0){
                System.out.println("删除成功！");
                return true;
            }else
            {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            ConnectionFactory.closeAllConnection(connection, preparedStatement, resultSet);
        }
        return false;
    }

    @Override
    public int getGoodsPageTotal(Map<String, Object> params) {
        int result = 0;
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("select count(1) value from t_goods");
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

    /**
     *
     * @param sql sql语句
     * @param params 查询条件拼接
     * @return StringBuffer
     */
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
        if(params.containsKey("id") && !"".equals(params.get("id"))){
            sql.append(" and id = '").append(params.get("id")).append("'");
        }


        return sql;
    }


    public StringBuffer commonSqlPage(StringBuffer sql,Map<String, Object> params){
        if(null == params || params.isEmpty()){
            return sql;
        }
        if(params.containsKey("offset") && !"".equals(params.get("offset"))){
            sql.append(" limit ").append(params.get("offset")).append(",").append(params.get("limit"));
        }
        return sql;
    }

    @Override
    public GoodsInfo getGoodsById(int id) {
        try {
            connection= ConnectionFactory.getConnection();
            StringBuffer sql = new StringBuffer();
            sql.append("select * from t_goods where goodsstate = 1 and id = ? ");
            System.out.println("查询的sql语句："+sql);
            preparedStatement=connection.prepareStatement(sql.toString());
            preparedStatement.setObject(1,id);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String goodsname = resultSet.getString("goodsname");
                double goodsprice = resultSet.getDouble("goodsprice");
                String goodsimageurl = resultSet.getString("goodsimageurl");
                Date goodstime = resultSet.getDate("goodsctime");
                int goodsstate = resultSet.getInt("goodsstate");
                String goodsInfo = resultSet.getString("goodsInfo");
                int goodstype = resultSet.getInt("goodstype");
                int num = resultSet.getInt("num");
                //通过查询到的goodstype 查询整个goodstype对象
                GoodsTypeInfo goodsType = new GoodsTypeInfo();
                goodsType.setId(goodstype);
                GoodsInfo goods = new GoodsInfo(id,goodsname,goodsprice,goodsimageurl,goodstime,goodsstate,goodsInfo,num,goodsType);
                return goods;
            }
            ConnectionFactory.closeAllConnection(connection, preparedStatement, resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
// sql测试
 /*   public static void main(String[] args) {
        GoodsDao GoodsDao = new GoodsDaoImpl();
//        GoodsInfo GoodsInfo = new GoodsInfo();
//        GoodsInfo.setId(2L);
//        GoodsInfo.setGoodsName("bbbbb");
//        GoodsInfo.setPassword("aaa");
//        GoodsInfo.setRealName("aaa");
//        GoodsInfo.setCardId("aaa");
//        GoodsInfo.setBirthday(new Date());
//        GoodsInfo.setPhone("aaa");
//        GoodsInfo.setGoods("aaa");
        Map<String,Object> map=new HashMap<>();
        map.put("GoodsName","admin1");
          List<GoodsInfo> a = GoodsDao.getGoodsList(map);
  //      boolean a = GoodsDao.deleteInfoById(GoodsInfo);
        System.out.println("a="+a.toString());
    }*/

