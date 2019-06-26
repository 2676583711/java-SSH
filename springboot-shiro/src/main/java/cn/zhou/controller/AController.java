package cn.zhou.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AController {

	@RequestMapping("login")
	public String login() {

		System.out.println("login....");
		return "login";
	}

	@RequestMapping("manage")
	public String manage(String username, String password, Model model) {

		Subject subject = SecurityUtils.getSubject();

		UsernamePasswordToken token = new UsernamePasswordToken(username, password);

		// token.setUsername(username);
		try {
			subject.login(token);

			System.out.println("manage....");
			System.out.println(username + ":" + password);
			return "/index";

		} catch (UnknownAccountException e) {
			// 这个异常是用户名错误的异常
			model.addAttribute("error", "用户名或密码错误...");
			return "login";
		}

		// return "index";
	}

	@RequestMapping("add")
	public String add() {

		return "add";
	}

	@RequestMapping("update")
	public String update() {

		return "update";
	}

	@RequestMapping("index")
	public String index() {

		return "index";
	}
}
