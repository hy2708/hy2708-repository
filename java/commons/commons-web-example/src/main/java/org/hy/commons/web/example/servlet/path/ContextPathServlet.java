package org.hy.commons.web.example.servlet.path;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.servlet.compression.GZipHttpServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ContextPathServlet extends HttpServlet {

	Logger logger = LoggerFactory.getLogger(getClass());

	
	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP,ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(ContextPathServlet.class, JettyUtil.HELLO);
//		JettyUtil.getServletContextHandler().addServlet(GZipHttpServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();

		//HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		
		//Thread.sleep(1000);
		//JettyUtil.stopServer();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("正在执行a.a(args)方法");
		logger.debug("正在执行ContextPathServlet.doGet(args)方法");				
		String contextPath = req.getContextPath();
		logger.info("【req.getContextPath()】的返回值是【" +contextPath+"】");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
