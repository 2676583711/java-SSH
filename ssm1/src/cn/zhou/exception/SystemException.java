package cn.zhou.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/*
 * 全局的异常处理器
 * 实现接口HandlerExceptionResolver
 * 有且仅有一个，定义多个只会运行一个
 * 
 */

public class SystemException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {

		String message = null;

		// 判断是否是系统所定义的异常
		if (exception instanceof UserException) {
			// message = ((UserException) exception).getMessage();
			message = exception.getMessage();
		} else {
			message = "未知错误.";
		}

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", message);
		modelAndView.setViewName("/error.jsp");
		return modelAndView;
	}

}
