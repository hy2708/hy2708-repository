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

public class AddCookieDomainServlet2 extends HttpServlet{

	static String virtualHost = "bbs.xxx.com";
	public static void main(String[] args) {
		Server server =JettyUtil.getServer();
		
		JettyUtil.setAppContextPath("/", ProjectPathUtil.getWebRootPath());
		WebAppContext webAppContext =JettyUtil.getWebAppContext();
		webAppContext.addVirtualHosts(new String[]{virtualHost});
		JettyUtil.getWebAppContext().addServlet(AddCookieDomainServlet2.class, JettyUtil.HELLO);
		
		JettyUtil.startServer();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			System.err.println("myKey is  "+cookie.getValue());
			System.err.println("myKey path is  "+cookie.getPath());
		}
		Cookie cookie = new Cookie("myKey", virtualHost);
		cookie.setMaxAge(60*5);
		cookie.setDomain("xxx.com");
		resp.addCookie(cookie);
		
	}
}
