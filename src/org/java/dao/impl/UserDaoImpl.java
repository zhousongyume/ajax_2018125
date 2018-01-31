package org.java.dao.impl;

import java.sql.SQLException;

import org.java.dao.BaseDao;
import org.java.dao.UserDao;
import org.java.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	@Override
	public User getByName(String name) {
		User user = null;
		String sql = "SELECT * FROM users WHERE NAME=?";
		Object[] params = {name};
		super.rs = super.getResultSet(sql, params);
		try {
			while(rs.next()){
				user = new User();
				user.setName(rs.getString(1));
				user.setAddress(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			super.close(conn, ps, rs);
		}
		return user;
	}

}
