import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "/AServlet")
public class AServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应编码
        response.setContentType("text/html;charset=utf-8");

        //获取请求数据
        String name = request.getParameter("name");
        //检查数据是否有意义
        if (name == null || name.length() == 0) {
            response.getWriter().println("用户名不得为空!!");
        } else {
            //对所获得的数据进行校验
            if (name.equals("zhou")) {
                response.getWriter().println("该用户名:" + name + "已经注册了，请换一个");
            } else {
                response.getWriter().println("该用户名:" + name + "可以使用");
            }

        }


    }
}
