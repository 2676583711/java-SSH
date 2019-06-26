package cn.zhou.dao;

import cn.zhou.entity.User;

public class DaoInsert {

	private UserDao userDao;
	private User user;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void insert(String username, String password) {
		user.setUsername(username);
		user.setPassword(password);
		userDao.insert(user);

	}

}
