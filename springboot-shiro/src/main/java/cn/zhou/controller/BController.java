package cn.zhou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.zhou.pojo.User;
import cn.zhou.service.UserService;

@Controller
public class BController {

	@Autowired
	private UserService service;

	@RequestMapping("find")
	@ResponseBody
	public List<User> list() {

		List<User> list = service.find();

		return list;
	}

	@RequestMapping("unauthc")
	public String unauthc() {

		return "unauthc";
	}
}
