package org.java.dao;

import org.java.entity.User;

public interface UserDao {
	/**
	 * 根据用户名查询用户对象
	 * 
	 * @param name
	 *            用户名
	 * @return 用户对象
	 */
	User getByName(String name);
}
