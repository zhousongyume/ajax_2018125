package org.java.service;

import org.java.entity.User;

public interface UserService {
	/**
	 * 根据用户名查询用户对象
	 * 
	 * @param name
	 *            用户名
	 * @return 用户对象
	 */
	User getByName(String name);

	/**
	 * 判断用户名是否存在
	 * 
	 * @param name
	 * @return
	 */
	boolean getName(String name);
}
