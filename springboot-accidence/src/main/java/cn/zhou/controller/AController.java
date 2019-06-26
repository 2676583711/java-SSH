package cn.zhou.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zhou.pojo.User;

@RestController
public class AController {
	/*
	 * 返回json数据
	 */

	@RequestMapping("json")
	public String string() {

		return "hello,world...";
	}

	/*
	 * 返回pojo对象
	 */
	@RequestMapping("pojo")
	public User pojo() {

		User u = new User();
		u.setUsername("username");
		return u;
	}

	/*
	 * 返回list集合
	 */
	@RequestMapping("list")
	public List<User> list() {

		List<User> list = new ArrayList<User>();
		User u = new User();
		u.setUsername("username");

		list.add(u);
		return list;
	}
}
