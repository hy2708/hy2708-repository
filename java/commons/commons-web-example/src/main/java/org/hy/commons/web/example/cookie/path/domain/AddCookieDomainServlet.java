package org.hy.commons.web.example.cookie.path.domain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.cookie.CookieInfoServlet;
import org.hy.server.jetty8.JettyUtil;

public class AddCookieDomainServlet extends HttpServlet{

	static String virtualHost = "www.xxx.com";
	public static void main(String[] args) {
		Server server =JettyUtil.getServer();
		
//		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.setAppContextPath("/", ProjectPathUtil.getWebRootPath());
		WebAppContext webAppContext = JettyUtil.getWebAppContext();
		webAppContext.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "true");


		webAppContext.addVirtualHosts(new String[]{virtualHost});
		JettyUtil.getWebAppContext().addServlet(AddCookieDomainServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();
		
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			System.err.println("myKey is  "+cookie.getValue());
		}
		Cookie cookie = new Cookie("myKey", virtualHost);
		cookie.setMaxAge(60*5);
		cookie.setDomain("xxx.com");
		cookie.setPath("/");
		resp.addCookie(cookie);
		
	}
}
