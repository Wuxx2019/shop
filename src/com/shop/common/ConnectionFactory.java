package com.shop.common;

import java.sql.*;

/**
 * @ProjectName：shop
 * @ClassName：ConnectionFactory
 * @Description：抽象出的连接工厂类，提供连接数据库和关闭连接的相关方法
 * @Author：wuxingxing
 * @Date：2019/10/14 10:44
 */
public class ConnectionFactory {
    /**数据库连接的相关参数*/
    private static final String URL ="jdbc:mysql://49.235.166.42:3306/shop?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER ="shop";
    private static final String PASSWORD ="Shop123+";
    private static final String DRIVER ="com.mysql.jdbc.Driver";

    public static Connection getConnection(){
        Connection conn = null;
        try {
            //加载数据库驱动
            Class.forName(DRIVER);
            //创建连接
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException c) {
            System.out.println("=================================数据库驱动加载异常============================");
            c.getMessage();
        } catch (SQLException s){
            System.out.println("=================================获取连接异常============================");
            s.getMessage();
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param con 连接
     * @param stm 语句块
     * @param rs 结果集
     */
    public static void closeAllConnection(Connection con, Statement stm, ResultSet rs)  {
        try {
            // 释放资源
            if(rs!=null) {
                rs.close(); //关闭结果集
            }
            if(stm!=null) {
                stm.close();//关闭语句块
            }
            if(con!=null) {
                con.close();//关闭连接
            }
        } catch (SQLException e) {
            System.out.println("=================================关闭资源出错============================");
            e.getMessage();
        }

    }
}