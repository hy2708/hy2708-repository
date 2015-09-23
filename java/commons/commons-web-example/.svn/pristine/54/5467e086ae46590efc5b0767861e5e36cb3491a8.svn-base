package org.hy.commons.web.example.cookie;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.lang.date.DateUtil;
import org.hy.commons.web.cookie.CookieUtil;
import org.hy.server.jetty8.JettyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadCookieServlet extends HttpServlet {
	
	private static Logger logger = LoggerFactory
			.getLogger(ReadCookieServlet.class);
	
	
	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(CookieInfoServlet.class, JettyUtil.HELLO+"2");
		JettyUtil.getWebAppContext().addServlet(ReadCookieServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();
		HttpBrowser browser = new HttpBrowser();
		HttpRequest request = HttpRequest.get(JettyUtil.WHOLE_URL);
		browser.sendRequest(request);
		Thread.currentThread().sleep(2000);
		browser.sendRequest(request);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//获得浏览器保存的cookie信息
		
		Cookie[] cookies = request.getCookies();
		Cookie cookie2=null;
		for (Cookie cookie : cookies) {
			if ("lastAccessTime".equalsIgnoreCase(cookie.getName())) {
				cookie2=cookie;
				Long long1 = Long.valueOf(cookie.getValue());
				Date date =DateUtil.getDate(long1);
				String string =DateUtil.format(date,"yyyy-MM-dd hh:mm:ss");
				logger.info("上次的访问时间是【{}】",string);
				break;
			}
		}
		CookieUtil.printCookieInfo(cookies);
		if (null==cookie2) {
			cookie2= new Cookie("lastAccessTime", DateUtil.getCurrentTimeMillis()+"");
		}
		response.addCookie(cookie2);

	}

}
