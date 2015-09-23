package org.hy.commons.web.example.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.cookie.CookieUtil;
import org.hy.commons.web.servlet.HttpServletUtil;
import org.hy.server.jetty8.JettyUtil;

public class DemoSessionServlet extends HttpServlet {

	
	public static void main(String[] args) {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(DemoSessionServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();
		
	}
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		System.err.println("333333");
		Cookie[] cookies = request.getCookies();
		CookieUtil.printCookieInfo(cookies);
		
		HttpServletUtil.setResponseCharset(response, "utf-8");
		//response.setContentType("text/html;charset=UTF-8");
		
		/*
		 * 执行request.getSession()之后
		 * JSESSIONID=DFE75A1E9CCAA1591F900FA3B1AEE9F3 tomcat自动添加cookie，会话级
		 */
		//获得session
		HttpSession session = request.getSession(); //没有创建，有返回
		/*
		 * Request（Servlet）导航到Session的内部实现是:
		 * 1、在浏览器的cookie中，查看JSESSIONID的数值
		 * 2、request，通过getParameter(JSESSIONID)，即 通过url的重写实现
		 * 如果上面的两种方法，查找到了JSESSIONID，那么就可以在服务器端的，内存中，找到对应session
		 * 
		 */
		
		
		System.out.println(session.isNew());
		
		
		//持久化
		Cookie cookie = new Cookie("JSESSIONID",session.getId());
		/*
		 * 设置有效时间
		 * 如何不设置，那么当浏览器关闭的时候，cookie就过期，其中存储的session的ID也就消失了
		 */
		cookie.setMaxAge(60*5);
		cookie.setPath(request.getContextPath());
		//通知浏览器
		response.addCookie(cookie);
		
		
		

	}

}
