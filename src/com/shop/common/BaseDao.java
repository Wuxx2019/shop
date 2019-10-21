package com.shop.common;


import com.shop.common.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * baseDao 数据库连接
 */
public class BaseDao {
	public Connection connection=null;
	public PreparedStatement preparedStatement = null;
	public ResultSet resultSet= null;

	//设置方法
	public  PreparedStatement setParams(PreparedStatement ps ,Object[] params) {
		if(params!=null){
			for (int i = 0; i < params.length; i++) {
				try {
					ps.setObject(i+1, params[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return ps;
	}


	/**
	 * 通用增，删除，修改方法
	 * @param sql 增，删除，修改sql
	 * @param params 增，删除，修改参数
	 * @return boolean
	 */
	public boolean executeUpdate(String sql,Object[] params) {
			connection= ConnectionFactory.getConnection();
			try {
				preparedStatement=connection.prepareStatement(sql);
				preparedStatement=setParams(preparedStatement, params);
				int ret=preparedStatement.executeUpdate();
				if(ret>0){
					System.out.println("success!");
					return true;
				}else
				{
					System.out.println("fail!");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				ConnectionFactory.closeAllConnection(connection, preparedStatement, resultSet);
			}
			return false;

	}


	/**
	 * 通用查询方法
	 * @param sql 查询sql
	 * @param params 查询参数
	 * @return List<Map<String,Object>>
	 */
	public List<Map<String,Object>> executeQuery(String sql,Object[] params) {
		//获取连接
		connection= ConnectionFactory.getConnection();
		//创建结果集列表
		List<Map<String,Object>> objectList=new ArrayList<Map<String,Object>>();
		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement=setParams(preparedStatement, params);
			resultSet=preparedStatement.executeQuery();
			ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
			//遍历所有的行
			while(resultSet.next()){
				//创建结果集对象
				Map<String,Object> rowMap=new HashMap<String, Object>();
				//遍历所有的行
				for (int i = 0; i < resultSetMetaData.getColumnCount(); i++) {
					//将查询的结果放入结果集对象中
					rowMap.put(resultSetMetaData.getColumnName(i+1), resultSet.getObject(i+1));
				}
				//将结果集对象放入结果集列表
				objectList.add(rowMap);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭所有链接释放资源
			ConnectionFactory.closeAllConnection(connection, preparedStatement, resultSet);
		}
		return objectList;

}


}
