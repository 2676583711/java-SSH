package cn.zhou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zhou.pojo.User;
import cn.zhou.service.UserService;

@RestController
public class SsmController {

	@Autowired
	private UserService service;

	@RequestMapping("ssm")
	public List<User> userList() {

		List<User> list = service.find();

		return list;
	}

}
