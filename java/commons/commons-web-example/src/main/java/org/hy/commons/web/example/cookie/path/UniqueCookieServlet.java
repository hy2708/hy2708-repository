package org.hy.commons.web.example.cookie.path;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.cookie.CookieUtil;
import org.hy.server.jetty8.JettyUtil;

public class UniqueCookieServlet extends HttpServlet {
	
	
	public static void main(String[] args) {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(UniqueCookieServlet.class, JettyUtil.HELLO);
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
		
		Cookie[] cookies = request.getCookies();
		CookieUtil.printCookieInfo(cookies);
		//添加cookie  /addCookieServlet
		
		// * 创建cookie
		/*
		 * 唯一的定位Cookie，需要的是，domain+path+name，这三个组合起来，
		 * 就是cookie的key，唯一的确定一个cookie。
		 * 然后就可以为cookie赋值
		 */
		Cookie cookie = new Cookie("add111","1111111111111");
		// * 设置有效时间
		/*
		 * 默认值-1,在浏览器中存在。 0：删除文件中的cookie和浏览器中的cookie。
		 */
		cookie.setMaxAge(60*60*24);
		// * 通知浏览器
		response.addCookie(cookie);
		
		

	}

}
