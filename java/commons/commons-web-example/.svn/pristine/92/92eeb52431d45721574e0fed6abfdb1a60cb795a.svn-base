package org.hy.commons.web.example.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.server.jetty8.JettyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieInfoServlet extends HttpServlet {
	
	private static Logger logger = LoggerFactory
			.getLogger(CookieInfoServlet.class);
	

	public static void main(String[] args) {
		Server server =JettyUtil.getServer();
		
//		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.setAppContextPath("/", ProjectPathUtil.getWebRootPath());
		WebAppContext webAppContext = JettyUtil.getWebAppContext();
		webAppContext.setInitParameter("org.eclipse.jetty.servlet.Default.dirAllowed", "true");


		webAppContext.addVirtualHosts(new String[]{"www.xxx.com"});
		JettyUtil.getWebAppContext().addServlet(CookieInfoServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();
		
		
		//HttpClientUtil.visitUrlWithPostMethod(JettyUtil.WHOLE_URL, "utf8",null);
		//JettyUtil.stopServer();
		
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
		if(cookies != null && cookies.length>0){
			for(Cookie c : cookies){
				System.out.println("cookie domain :" + c.getDomain());
				System.out.println("cookie path :" + c.getPath());
				System.out.println("cookie comment :" + c.getComment());
				
				System.out.println("cookie maxAge :" + c.getMaxAge());
				System.out.println("cookie version :" + c.getVersion());
				System.out.println("cookie name :" + c.getName());
				System.out.println("cookie value:" + c.getValue());
								
			}
		}else{
			System.err.println("不存在cookie");
		}
		
		//创建cookie
		Cookie cookie = new Cookie("myCookie","mycookieServlet");
		
		//将cookie信息通知浏览器
		response.addCookie(cookie);
		
		
		
		

	}

}
