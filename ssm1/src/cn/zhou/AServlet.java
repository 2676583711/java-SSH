package cn.zhou;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AServlet")
public class AServlet extends HttpServlet {

	protected void doPost(javax.servlet.http.HttpServletRequest request,
			javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

		doGet(request, response);

		response.sendRedirect("https://liberalzhou.github.io");

		// get请求
		// curl -X GET http://javacloud.bmob.cn/83e4f8dd10dc0fa3/MyJava
		// post请求
		// curl -X POST \
		// -H "X-Bmob-Application-Id: 05fae7c6dbc64e74fa21d4f70bacd6d1" \
		// -H "X-Bmob-REST-API-Key: 9afced7e6d80dc95b1521363052a0222" \
		// -H "Content-Type: application/json" \
		// -d 'name=MyJava' \
		// http://javacloud.bmob.cn/83e4f8dd10dc0fa3/MyJava

	}

	public int add(int a, int b) {
		int sum = 0;
		sum = a + b;
		return sum;
	}

	protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
			throws javax.servlet.ServletException, IOException {
		// 1.设置编码问题
		response.setContentType("text/html;charset=utf-8");

		// 2.获取参数
		String name = request.getParameter("name");

		// 3.检查数据的合理性

		if (name == null || name.length() == 0) {
			response.getWriter().println("用户名不能为空");
		} else {

			// 4.校验数据
			if (name.equals("zhou")) {
				response.getWriter().println("该用户名:" + name + "已经被注册，请换一个?");
			} else {
				response.getWriter().println("该用户名:" + name + "可以使用.");
			}

		}

	}
}
