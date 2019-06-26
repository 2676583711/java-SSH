package cn.zhou.service;

import org.springframework.beans.factory.annotation.Autowired;

import cn.zhou.dao.UserDao;
import cn.zhou.exception.AddException;

public class UserService {

	@Autowired
	private UserDao dao;

	public void add(String username, String password) throws AddException {

		boolean u = false;
		boolean p = false;

		if (username == null || username.length() == 0) {
			u = true;
		}

		if (password == null || password.length() == 0) {
			p = true;
		}

		if (u == true && p == true) {
			throw new AddException("用户名不得为空..", "密码不得为空.");
		}

		if (u == true) {
			throw new AddException("用户名不得为空..", "");
		}

		if (p == true) {
			throw new AddException("", "密码不得为空.");
		}

		try {
			dao.add(username, password);
		} catch (Exception e) {
			System.out.println("dao的异常:" + e);
		}

	}
}
