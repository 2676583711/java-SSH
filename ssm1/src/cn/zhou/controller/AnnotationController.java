package cn.zhou.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.zhou.exception.UserException;

//使用@Controller这个注解表示这个类是handler处理器
@Controller
public class AnnotationController {

	// 使用@RequestMapping这个注解映射ｕｒｌ访问路径

	@RequestMapping("/AC")
	public ModelAndView login(HttpServletRequest request) throws UserException {

		ModelAndView mav = new ModelAndView();

		mav.setViewName("/index.jsp");
		System.out.println(request.getParameter("name"));

		if (request.getParameter("name") == null) {
			throw new UserException("测试异常<br/>用户名不能为空<br/><a href='#'>点这里重新访问</a>");

		}
		return mav;
	}

	/*
	 * restful风格的ＵＲＬ访问路径
	 */
	@RequestMapping("/restful/{id}")
	public void restful(@PathVariable("id") int abc, HttpServletResponse response) throws IOException {
		response.getWriter().println(abc);

	}

	@RequestMapping("/restful2/{id}")  // @PathVariable这个注解可用来实现ｒｅｓｔｆｕｌ风格的ｕｒｌ访问路径
	public void restful2(@PathVariable int id, HttpServletResponse response) throws IOException {
		response.getWriter().println(id);

	}
}
