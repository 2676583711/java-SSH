package cn.zhou.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.HttpRequestHandler;

import cn.zhou.dao.UserDao;
import cn.zhou.entity.User;

public class HttpHandler implements HttpRequestHandler {

	/*
	 * 注册 (non-Javadoc) 这个类实现注册的功能
	 * 
	 * @see
	 * org.springframework.web.HttpRequestHandler#handleRequest(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */

	@Autowired
	private User user;

	public void setUser(User user) {
		this.user = user;
	}

	// 如果使用@Autowired 这个注解就可以不用写ｓｅｔ方法，由ｓｐｒｉｎｇ自动注入

	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 设置响应编码
		response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean u = false;
		boolean p = false;

		if (username == null | username.length() == 0) {
			response.getWriter().println("用户名不能为空.");

			// request.setAttribute("uError", "用户名：" + username + "不能为空.");

		} else {
			List<User> list = userDao.findUserByName(username);
			String name = null;
			for (User ulist : list) {
				name = ulist.getUsername();
			}

			if (username == name | username.equals(name)) {
				response.getWriter().println("该用户名:" + username + "已被使用，请更换用户名<br/><a href='/ssm1/a.jsp'>返回注册</a>");
			} else {

				// response.getWriter().println("该用户名:" + username + "可以使用");
				u = true;

			}
		}

		if (password == null | password.length() == 0) {
			response.getWriter().println("<br/>密码不能为空!");
		} else {
			p = true;

		}

		if (u == true && p == true) {

			// UserDao ud = (UserDao) ac.getBean("mapper1");
			// User ur = new User();
			//
			// ur.setUsername(username);
			// ur.setPassword(password);
			// ud.insert(ur);

			// springmvc注入
			user.setUsername(username);
			user.setPassword(password);
			userDao.insert(user);
			request.setAttribute("username", username);
			response.getWriter().println("<br/>注册成功<br/> <a href='/ssm1/b.jsp'>点击这里去登录</a>");

		}

	}

	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
		System.out.println(ac.getBean("h"));
	}

}
