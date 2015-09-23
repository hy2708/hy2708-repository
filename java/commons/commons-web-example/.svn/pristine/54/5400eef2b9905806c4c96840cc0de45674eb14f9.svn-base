package com.itheima.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionDemo1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		System.out.println(session.getId());//唯一且随机，由服务器分配的。作为一个name为JSESSIONID，value是sessionid，path是当前应用的cookie写给客户端的
		String username = request.getParameter("username");
		session.setAttribute("p", username);
		out.write("放了");
		
		Cookie c = new Cookie("JSESSIONID", session.getId());
		c.setPath(request.getContextPath());
		c.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(c);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
