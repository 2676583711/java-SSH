package cn.zhou.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

public class HttpController implements HttpRequestHandler {

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		Map map = new HashMap();
		map.put("name", "tom");
		map.put("sex", "woman");
		map.put("age", "120");

		map.put("name", "jim");
		map.put("sex", "man");
		map.put("age", "110");

		request.setAttribute("map", map);
		// modelAndView.setViewName("/WEB-INF/jsp/user.jsp");

		// return modelAndView;
		request.getRequestDispatcher("/WEB-INF/jsp/user.jsp").forward(request, response);

	}

}
