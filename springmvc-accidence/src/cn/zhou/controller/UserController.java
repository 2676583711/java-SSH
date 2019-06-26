package cn.zhou.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map map = new HashMap();
		map.put("name", "tom");
		map.put("sex", "woman");
		map.put("age", "120");

		map.put("name", "jim");
		map.put("sex", "man");
		map.put("age", "110");

		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("map", map);

		modelAndView.setViewName("/WEB-INF/jsp/user.jsp");

		return modelAndView;
	}

}
