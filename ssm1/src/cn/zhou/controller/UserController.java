package cn.zhou.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.zhou.dao.UserDao;
import cn.zhou.entity.User;

/*
 * 实现Controller接口
 * 
 * 这个类实现，登录验证的功能
 */
public class UserController implements Controller {

	private User user;
	private UserDao userDao;

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public ModelAndView handleRequest(@Validated String user, BindingResult result, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		ModelAndView mav = new ModelAndView();
		mav.addObject("username", username);

		List<User> list = userDao.findUserByName(username); // 使用mybatis查询数据库的数据
		String name = null;
		String cipher = null;

		// 遍历查询所返回的集合
		for (User u : list) {
			name = u.getUsername();
			cipher = u.getPassword();

		}

		System.err.println(name + ":" + cipher);

		// int i = 0;
		boolean up = false;
		boolean down = false;

		if (username == null | username.length() == 0) {
			mav.addObject("uError", "用户名不能为空.");
		} else {

			if (username.equals(name)) {
				// i += 1;
				up = true;
			} else {
				mav.addObject("uError", "用户名或密码错误1");

			}
		}

		if (password == null | password.length() == 0) {
			mav.addObject("pError", "密码不能为空!");
		} else {
			if (password.equals(cipher)) {
				// i += 1;
				down = true;
			} else {
				mav.addObject("pError", "用户名或密码错误２");
			}
		}

		if (up == true && down == true) {
			mav.setViewName("/index.jsp");
			// i = 0;
			return mav;
		}

		mav.setViewName("/b.jsp");
		return mav;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
