package com.shop.dao.impl;

import com.shop.common.BaseDao;
import com.shop.common.ConnectionFactory;
import com.shop.dao.GoodsTypeDao;
import com.shop.entity.GoodsTypeInfo;
import com.shop.entity.UserInfo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName：shop
 * @ClassName：GoodsTypeDaoImpl
 * @Description：查询数据库用户信息接口实现
 * @Author：wuxingxing
 * @Date：2019/10/14 12:29
 */
public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao {

    @Override
    public List<GoodsTypeInfo> getGoodsTypeList(Map<String, Object> params) {
        //创建用户列表
        List<GoodsTypeInfo> goodsTypes=new ArrayList<GoodsTypeInfo>();
        //获取连接
        connection= ConnectionFactory.getConnection();
        //创建基础查询sql
        StringBuffer sql = new StringBuffer();
        sql.append("select ");
        sql.append("id , goodstype, mark,parent_id");
        sql.append("from t_goodstype ");
        //设置查询条件
        commonSqlParams(sql, params);
        //分页查询一定在条件的后边
        commonSqlPage(sql, params);
        try {
            System.out.println("查询的sql语句："+sql);
            preparedStatement=connection.prepareStatement(sql.toString());
            resultSet=preparedStatement.executeQuery();
            //遍历所有的行
            while(resultSet.next()){
                //创建GoodsType对象
                GoodsTypeInfo goodsType = new GoodsTypeInfo();
                //将每一行的数据放入GoodsType对象中
                //id为表格字段名称
                goodsType.setId(resultSet.getInt("id"));
                goodsType.setGoodstype(resultSet.getString("goodstype"));
                goodsType.setMark(resultSet.getString("mark"));
                goodsType.setParent_id(resultSet.getInt("parent_id"));
                //将结果集对象放入结果集列表
                goodsTypes.add(goodsType);
                System.out.println("查询的数量："+goodsTypes.size());
                System.out.println("查询的结果："+goodsTypes.toString());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //关闭所有链接释放资源
            ConnectionFactory.closeAllConnection(connection, preparedStatement, resultSet);
        }
        return goodsTypes;
    }

    @Override
    public boolean saveGoodsType(GoodsTypeInfo goodsType) {
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        //mysql库表ID主键使用的是自增策略，所以这里不对ID进行赋值添加
        sql.append("insert into t_goodstype (goodstype, mark,parent_id) value ");
        sql.append(" (?,?,?) ");
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            //这里在对参数进行赋值时请确认赋值的顺序是否一致（数字1代表sql中第一个？）
            preparedStatement.setObject(1,goodsType.getGoodstype());
            preparedStatement.setObject(2,goodsType.getMark());
            preparedStatement.setObject(3,goodsType.getParent_id());
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
    public boolean updateGoodsTypeById(GoodsTypeInfo goodsType) {
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("update t_goodstype set goodstype = ?,mark = ?,parent_id = ? ");
        sql.append("where id = ?");
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            //这里在对参数进行赋值时请确认赋值的顺序是否一致（数字1代表sql中第一个？）
            preparedStatement.setObject(1,goodsType.getGoodstype());
            preparedStatement.setObject(2,goodsType.getMark());
            preparedStatement.setObject(3,goodsType.getParent_id());
            preparedStatement.setObject(4,goodsType.getId());
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
    public boolean deleteGoodsTypeById(GoodsTypeInfo goodsType) {
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("delete from t_goodstype where id = ?");
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            preparedStatement.setObject(1,goodsType.getId());
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
    public int getGoodsTypePageTotal(Map<String, Object> params) {
        int result = 0;
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("select count(1) value from t_goodstype");
        //设置查询条件
        commonSqlParams(sql, params);
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            resultSet=preparedStatement.executeQuery();
            //遍历所有的行
            while(resultSet.next()){
                //创建GoodsType对象
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
    public boolean getGoodsTypeById(GoodsTypeInfo goodsTypeInfo) {
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("select  goodstype = ?,mark = ?,parent_id = ?  from t_goodstype ");
        sql.append("where id = ?");
        try {
            System.out.println("查询的sql语句：" + sql);
            preparedStatement = connection.prepareStatement(sql.toString());
            resultSet = preparedStatement.executeQuery();
            //遍历所有的行
            while (resultSet.next()) {
                //创建user对象
                GoodsTypeInfo goodsTypeInfo1 = new GoodsTypeInfo();
                //将每一行的数据放入user对象中
                //id为表格字段名称
                goodsTypeInfo1.setId(resultSet.getInt("id"));
                goodsTypeInfo1.setGoodstype(resultSet.getString("goodstype"));
                goodsTypeInfo1.setMark(resultSet.getString("mark"));
                goodsTypeInfo1.setParent_id(resultSet.getInt("parent_id"));
                System.out.println("查询的结果：" + goodsTypeInfo1.toString());
                int ret=preparedStatement.executeUpdate();
                if(ret>0){
                    System.out.println("查询成功！");
                    return true;
                }else
                {
                    System.out.println("查询失败！");
                }
            }
        }catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            ConnectionFactory.closeAllConnection(connection, preparedStatement, resultSet);
        }
        return false;
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
        //可在下面拼接任意查询条件，例如GoodsTypeName;
        // 因为GoodsTypeName是字符类型所以要比对空字符，如果不是字符类型则不需要加此限制条件
        //可在下方拼接排序，分页等字段

    if(params.containsKey("id") && !"".equals(params.get("id"))){
            sql.append(" and id = '").append(params.get("id")).append("'");
        }
   /*         if(params.containsKey("password") && !"".equals(params.get("password"))){
            sql.append(" and password = '").append(params.get("password")).append("'");
        }*/


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

   // sql测试
 /*   public static void main(String[] args) {
        GoodsTypeDao GoodsTypeDao = new GoodsTypeDaoImpl();
//        GoodsTypeInfo GoodsTypeInfo = new GoodsTypeInfo();
//        GoodsTypeInfo.setId(2L);
//        GoodsTypeInfo.setGoodsTypeName("bbbbb");
//        GoodsTypeInfo.setPassword("aaa");
//        GoodsTypeInfo.setRealName("aaa");
//        GoodsTypeInfo.setCardId("aaa");
//        GoodsTypeInfo.setBirthday(new Date());
//        GoodsTypeInfo.setPhone("aaa");
//        GoodsTypeInfo.setGoodsType("aaa");
        Map<String,Object> map=new HashMap<>();
        map.put("GoodsTypeName","admin1");
          List<GoodsTypeInfo> a = GoodsTypeDao.getGoodsTypeList(map);
  //      boolean a = GoodsTypeDao.deleteInfoById(GoodsTypeInfo);
        System.out.println("a="+a.toString());
    }*/

}