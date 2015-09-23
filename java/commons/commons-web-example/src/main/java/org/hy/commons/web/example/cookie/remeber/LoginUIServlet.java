package org.hy.commons.web.example.cookie.remeber;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//提供登陆的界面
//显示已保存的用户名
public class LoginUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username="";
		String checked = "";
		//显示已保存的用户名
		Cookie cookies[] = request.getCookies();
		for(int i=0;cookies!=null&&i<cookies.length;i++){
			if("userInfo".equals(cookies[i].getName())){
				username = cookies[i].getValue();
				checked="checked='checked'";
				break;
			}
		}
		//提供登陆的界面
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<form action='"+request.getContextPath()+"/servlet/LoginServlet' method='post'>");
		out.write("用户名:<input type='text' name='username' value='"+username+"'/><br/>");
		out.write("密码:<input type='password' name='password'/><br/>");
		out.write("<input type='checkbox' name='remember' "+checked+"/>记住用户名<br/>");
		out.write("<input type='submit' value='登陆'/><br/>");
		out.write("</form>");
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
