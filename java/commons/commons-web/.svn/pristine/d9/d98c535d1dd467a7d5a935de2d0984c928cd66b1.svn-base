package org.hy.commons.web.servlet;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 通过servletcontext获得文件
			* 获得实际路径
				* sc.getRealPath("/1.html");
			* 获得URL
				* URL url = sc.getResource("/1.html"); 
			* 获得流【**】
				* InputStream is = sc.getResourceAsStream("/1.html");
				* WebRoot/page/abc/2.html  -- path:/page/abc/2.html
 */
public class HttpServletUtilTestServlet extends HttpServlet {
	

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		this.getServletContext().setAttribute("admin", "hello");
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Object admin = HttpServletUtil.getAttributeFromContext(this, "admin");
		Boolean flag=false;
		if (!"hello".equals(admin)) {
			flag=true;
		}
		String servletPath =HttpServletUtil.getRequestServletPath(req);
		logger.info("servletPath = {}",servletPath);
		if (!"/hello".equals(servletPath)) {
			flag=true;
		}
		String wholePath =HttpServletUtil.getWholeUrl(req);
		logger.info("wholePathwholePath = {}",wholePath);
		System.out.println("get");
		String contextPath = req.getContextPath();
		System.err.println("=="+req.getPathInfo());
		System.err.println("=="+req.getServletPath());
		//System.err.println("=="+req.getServletContext().get);
		
		logger.info("【req.getContextPath()】的返回值是【" +contextPath+"】");

		
//		ServletContext sc2 = this.getServletConfig().getServletContext();
		ServletContext sc = this.getServletContext();
		
		
		//获得实际路径,要求/开头
//		String path = sc.getRealPath("/1.html");
		String path = sc.getRealPath("/");
		String path2 = sc.getRealPath("");
//		String path = req.getRequestDispatcher("/").toString();  // context root
//		String path = sc.getResource("/").toString(); 
		//C:\java\tomcat\apache-tomcat-6.0.35\webapps\day06
		logger.info("【ServletContext.getRealPath('/')】的返回值是【" +path+"】");
		logger.info("【ServletContext.getRealPath('')】的返回值是【" +path2+"】");
		HttpSession S = req.getSession(true);
		HttpServletUtil.debug(req);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("post");
		
		
	}
	
	

}
