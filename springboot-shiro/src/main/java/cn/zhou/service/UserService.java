package cn.zhou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhou.dao.UserDao;
import cn.zhou.pojo.User;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public List<User> find() {
		List<User> list = dao.find();

		System.out.println(list);

		return list;

	}

	public User findByUsername(String username) {

		User list = dao.findByUserName(username);

		System.out.println(list);

		return list;

	}

}
