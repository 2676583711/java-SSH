package cn.zhou.action;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Servlet implementation class BServlet
 */
public class BServlet extends ActionSupport {
	@Override
	public String execute() throws Exception {

		HttpServletResponse response = ServletActionContext.getResponse();
		response.getWriter().write("这是一个servlet....");
		return "abc";
	}

}
