package cn.zhou.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.zhou.dao.UserMapper;
import cn.zhou.pojo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper dao;

	@Override
	public List<User> find() {

		List<User> list = dao.find();

		return list;
	}

}
