package com.shop.dao.impl;

import com.shop.common.BaseDao;
import com.shop.common.ConnectionFactory;
import com.shop.dao.UserDao;
import com.shop.entity.UserInfo;

import java.sql.SQLException;
import java.util.*;

/**
 * @ProjectName：shop
 * @ClassName：UserDaoImpl
 * @Description：查询数据库用户信息接口实现
 * @Author：wuxingxing
 * @Date：2019/10/14 12:29
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public List<UserInfo> getUserList(Map<String, Object> params) {
        //创建用户列表
        List<UserInfo> Users=new ArrayList<UserInfo>();
        //获取连接
        connection= ConnectionFactory.getConnection();
        //创建基础查询sql
        StringBuffer sql = new StringBuffer();
        sql.append("select ");
        sql.append("id ,username userName ,password ,realname realName, cardid cardId, birthday , phone,userInfo ");
        sql.append("from t_user ");
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
                //创建user对象
                UserInfo user = new UserInfo();
                //将每一行的数据放入user对象中
                //id为表格字段名称
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setCardid(resultSet.getString("cardid"));
                user.setBirthday(resultSet.getDate("birthday"));
                user.setPhone(resultSet.getString("phone"));
                user.setUserInfo(resultSet.getString("userInfo"));
                user.setRealname(resultSet.getString("realname"));
                //将结果集对象放入结果集列表
                Users.add(user);
                System.out.println("查询的数量："+Users.size());
                System.out.println("查询的结果："+Users.toString());
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            //关闭所有链接释放资源
            ConnectionFactory.closeAllConnection(connection, preparedStatement, resultSet);
        }
        return Users;
    }

    @Override
    public boolean saveUser(UserInfo User) {
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        //mysql库表ID主键使用的是自增策略，所以这里不对ID进行赋值添加
        sql.append("insert into t_user (username,password,realname,cardid,birthday,phone,userInfo) value ");
        sql.append(" (?,?,?,?,?,?,?) ");
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            //这里在对参数进行赋值时请确认赋值的顺序是否一致（数字1代表sql中第一个？）
            preparedStatement.setObject(1,User.getUsername());
            preparedStatement.setObject(2,User.getPassword());
            preparedStatement.setObject(3,User.getRealname());
            preparedStatement.setObject(4,User.getCardid());
            preparedStatement.setObject(5,User.getBirthday());
            preparedStatement.setObject(6,User.getPhone());
            preparedStatement.setObject(7,User.getUserInfo());
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
    public boolean updateUserById(UserInfo User) {
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("update t_user set username = ?,password = ?,realname = ?,cardid = ?,birthday = ?, ");
        sql.append("phone = ?,userInfo = ? ");
        sql.append("where id = ?");
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            //这里在对参数进行赋值时请确认赋值的顺序是否一致（数字1代表sql中第一个？）
            preparedStatement.setObject(1,User.getUsername());
            preparedStatement.setObject(2,User.getPassword());
            preparedStatement.setObject(3,User.getRealname());
            preparedStatement.setObject(4,User.getCardid());
            preparedStatement.setObject(5,User.getBirthday());
            preparedStatement.setObject(6,User.getPhone());
            preparedStatement.setObject(7,User.getUserInfo());
            preparedStatement.setObject(8,User.getId());
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
    public boolean deleteUserById(UserInfo user) {
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("delete from t_user where id = ?");
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            preparedStatement.setObject(1,user.getId());
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
    public boolean getUserById(UserInfo user) {
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("select   username = ?,password = ?,realname = ?,cardid = ?,birthday = ?, ");
        sql.append("phone = ?,userInfo = ?  from  t_user ");
        sql.append("where id = ?");
        try {
            System.out.println("查询的sql语句：" + sql);
            preparedStatement = connection.prepareStatement(sql.toString());
            resultSet = preparedStatement.executeQuery();
            //遍历所有的行
            while (resultSet.next()) {
                //创建user对象
                UserInfo userInfo = new UserInfo();
                //将每一行的数据放入user对象中
                //id为表格字段名称
                userInfo.setId(resultSet.getInt("id"));
                userInfo.setUsername(resultSet.getString("username"));
                userInfo.setPassword(resultSet.getString("password"));
                userInfo.setCardid(resultSet.getString("cardid"));
                userInfo.setBirthday(resultSet.getDate("birthday"));
                userInfo.setPhone(resultSet.getString("phone"));
                userInfo.setUserInfo(resultSet.getString("userInfo"));
                userInfo.setRealname(resultSet.getString("realname"));
                System.out.println("查询的结果：" + userInfo.toString());
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

    @Override
    public int getUserPageTotal(Map<String, Object> params) {
        int result = 0;
        connection= ConnectionFactory.getConnection();
        StringBuffer sql = new StringBuffer();
        sql.append("select count(1) value from t_user");
        //设置查询条件
        commonSqlParams(sql, params);
        try {
            preparedStatement=connection.prepareStatement(sql.toString());
            resultSet=preparedStatement.executeQuery();
            //遍历所有的行
            while(resultSet.next()){
                //创建user对象
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
        //可在下面拼接任意查询条件，例如userName;
        // 因为userName是字符类型所以要比对空字符，如果不是字符类型则不需要加此限制条件
        //可在下方拼接排序，分页等字段

        if(params.containsKey("userName") && !"".equals(params.get("userName"))){
            sql.append(" and username = '").append(params.get("userName")).append("'");
        }
        if(params.containsKey("password") && !"".equals(params.get("password"))){
            sql.append(" and password = '").append(params.get("password")).append("'");
        }


        return sql;
    }



    public StringBuffer commonSqlPage(StringBuffer sql, Map<String, Object> params){
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
        UserDao userDao = new UserDaoImpl();
//        UserInfo UserInfo = new UserInfo();
//        UserInfo.setId(2L);
//        UserInfo.setUserName("bbbbb");
//        UserInfo.setPassword("aaa");
//        UserInfo.setRealName("aaa");
//        UserInfo.setCardId("aaa");
//        UserInfo.setBirthday(new Date());
//        UserInfo.setPhone("aaa");
//        UserInfo.setUser("aaa");
        Map<String,Object> map=new HashMap<>();
        map.put("userName","admin1");
          List<UserInfo> a = userDao.getUserList(map);
  //      boolean a = userDao.deleteInfoById(UserInfo);
        System.out.println("a="+a.toString());
    }*/

}