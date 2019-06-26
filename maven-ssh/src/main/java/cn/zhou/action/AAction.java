package cn.zhou.action;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import cn.zhou.exception.AddException;
import cn.zhou.service.UserService;

public class AAction extends ActionSupport {

	@Autowired
	private UserService service; // 注入service

	public String find() throws Exception {

		HttpServletRequest hsr = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/text;charset=utf-8");

		String name = hsr.getParameter("username");
		String cipher = hsr.getParameter("password");

		response.getWriter().println("name:" + name + "<br/>password:" + cipher);

		return SUCCESS;
	}

	/*
	 * 实现添加操作
	 */
	public String add() throws IOException, ServletException {
		System.out.println("这是maven-struts2整合之后的第一个action");

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType("text/html;charset=utf-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		try {
			service.add(username, password); // 调用service实现实现操作

		} catch (AddException e) {
			request.setAttribute("message1", e.getMessage1());
			request.setAttribute("message2", e.getMessage2());

			request.getRequestDispatcher("/b.jsp").forward(request, response);

		}
		response.getWriter().println("添加成功....");

		return null;

	}

	@Override
	public String execute() throws Exception {

		HttpServletRequest hsr = ServletActionContext.getRequest();

		HttpServletResponse response = ServletActionContext.getResponse();

		response.setContentType("text/html;charset=utf-8");
		response.setContentType("jpg");

		String path = "/home/zhou/图片/gril2.jpg";

		File file = new File(path);

		ServletOutputStream out = response.getOutputStream();

		ImageIO.write(ImageIO.read(file), "jpeg", out);

		out.close();

		return null;
	}
}
