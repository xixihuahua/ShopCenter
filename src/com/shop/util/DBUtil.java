package com.shop.util;

import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * 数据库连接工具类
 * @author Yp
 * @date 2018-09-04
 */
public class DBUtil{
	private static  ComboPooledDataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource();
	}
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConn(){
		//创建connection对象
		Connection conn = null;
		try {
			conn=dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
