package org.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	private String className = "com.mysql.jdbc.Driver"; 			// 驱动字符串
	private String url = "jdbc:mysql://localhost:3306/userinfo"; 	// 连接字符串
	private String user = "root";
	private String password = "root";
	/* jdbc接口 */
	protected Connection conn; // 连接
	protected PreparedStatement ps; // 预编译声明
	protected ResultSet rs; // 结果集

	/**
	 * 创建连接对象
	 * 
	 * @return
	 */
	public Connection getConnection() {
		try {
			// 加载mysql驱动
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return conn;
	}

	/**
	 * 增删改
	 * 
	 * @param sql
	 * @param params
	 */
	public void update(String sql, Object[] params) {
		conn = this.getConnection(); // 创建连接对象
		try {
			// 创建预编译声明
			ps = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			// 执行sql语句
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭资源
			this.close(conn, ps, rs);
		}
	}

	/**
	 * 增删改
	 * 
	 * @param sql
	 * @param params
	 */
	public ResultSet getResultSet(String sql, Object[] params) {
		conn = this.getConnection(); // 创建连接对象
		try {
			// 创建预编译声明
			ps = conn.prepareStatement(sql);
			if (params != null) {
				for (int i = 0; i < params.length; i++) {
					ps.setObject(i + 1, params[i]);
				}
			}
			// 执行sql语句
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	public void close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
