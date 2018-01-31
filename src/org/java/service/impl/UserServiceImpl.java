package org.java.service.impl;

import org.java.dao.UserDao;
import org.java.dao.impl.UserDaoImpl;
import org.java.entity.User;
import org.java.service.UserService;

public class UserServiceImpl implements UserService {
	UserDao userDao = new UserDaoImpl();
	@Override
	public User getByName(String name) {
		
		return userDao.getByName(name);
	}

	@Override
	public boolean getName(String name) {
		User user = userDao.getByName(name);
		if(user == null){
			//表示数据库里不存在，可以注册
			return true;
		}
		return false;
	}

}
