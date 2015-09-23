package org.hy.commons.web.example.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.cookie.CookieUtil;
import org.hy.server.jetty8.JettyUtil;

public class MaxAgeCookie extends HttpServlet {

	public static void main(String[] args) {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(MaxAgeCookie.class, JettyUtil.HELLO);
		JettyUtil.startServer();
		
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//输出到浏览器
		PrintWriter out = response.getWriter();
		
		//读取cookie
		Cookie[] cookies = request.getCookies();
		CookieUtil.printCookieInfo(cookies);
		
		
		//设置cookie的有效时间，使会话级cookie变成持久化cookie
		
		// * 创建cookie
		Cookie cookie = new Cookie("gf","fengjie");
		//设置有效时间 ，单位是 秒
		/*
		 * 如果不设置有效时间，那么窗口关闭的时候，cookie也会销毁
		 * 也，就是session的周期
		 */
		cookie.setMaxAge(60 * 5);
		// * 通知浏览器 
		response.addCookie(cookie);
		
		
		
		

	}

}
