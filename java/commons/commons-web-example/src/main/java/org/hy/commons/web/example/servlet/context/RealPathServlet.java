package org.hy.commons.web.example.servlet.context;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.servlet.path.ContextPathServlet;
import org.hy.server.jetty8.JettyUtil;
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
public class RealPathServlet extends HttpServlet {
	

	Logger logger = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP,ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(RealPathServlet.class, JettyUtil.HELLO);
//		JettyUtil.getServletContextHandler().addServlet(GZipHttpServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();

		//HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		
		//Thread.sleep(1000);
		//JettyUtil.stopServer();
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		logger.debug("正在执行RealPathServlet.doGet(args)方法");
		String contextPath = req.getContextPath();
		logger.info("=="+req.getPathInfo());
		logger.info("=="+req.getServletPath());
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
		
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("post");
		
		
	}
	
	

}
