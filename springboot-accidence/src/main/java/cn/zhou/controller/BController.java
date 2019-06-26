package cn.zhou.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BController {

	/*
	 * 整合mybatis
	 */

	@RequestMapping("mybatis")
	public String first() {

		return "hello,json";
	}

}
