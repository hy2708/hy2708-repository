package org.hy.commons.web.example.cookie.remeber;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//验证用户名和密码
//根据用户是否需要记住用户名，来操作userInfo=wzhting
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		//验证用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		//验证步骤：暂略
		out.write("欢迎您："+username);
		//根据用户是否需要记住用户名，来操作userInfo=wzhting
		if(remember==null){
			//删除cookie
			Cookie c = new Cookie("userInfo","");
			c.setPath(request.getContextPath());
			c.setMaxAge(0);
			response.addCookie(c);
		}else{
			//保存cookie
			Cookie c = new Cookie("userInfo",username);//Cookie中value的值不能为中文
			c.setMaxAge(Integer.MAX_VALUE);
			c.setPath(request.getContextPath());
			response.addCookie(c);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
