package cn.zhou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnnotationController {

	@RequestMapping("/annotationSearch")
	public ModelAndView search() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/jsp/annotation.jsp");

		return mav;
	}

}
