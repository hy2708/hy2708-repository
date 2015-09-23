package org.hy.commons.web.request.method;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.servlet.HttpServletUtil;
import org.hy.server.jetty8.JettyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MethodsInRequestOfServlet2 extends HttpServlet {
	Logger logger = LoggerFactory.getLogger(getClass());
	
	public static void main(String[] args) throws InterruptedException {
		Server server =JettyUtil.getServer();
		JettyUtil.setAppContextPath(HttpClientUtil.MY_APP);
		JettyUtil.addServlet(MethodsInRequestOfServlet2.class, HttpClientUtil.HELLO);
		JettyUtil.startServer();
		String content = HttpClientUtil.visitUrl(HttpClientUtil.WHOLE_URL+"?a=111&b=22");
		
		//System.err.println(content);
		Thread.sleep(1000);
		JettyUtil.stopServer();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpServletUtil.getContextPath(req);
		logger.info("req.getPathInfo()是【" +
				req.getPathInfo()+"】 ");
		logger.info("req.getRequestURI() 是【" +
				req.getRequestURI()+
				"】");
		logger.info("req.getQueryString()是【" +
				req.getQueryString()+
				"】");
		logger.info("req.getServletPath()是【" +
				req.getServletPath()+
				"】");
		Enumeration<String> names = req.getHeaderNames();
		for (Enumeration<String> element=names; names.hasMoreElements();) {
			System.err.println();
			String key = element.nextElement();
			System.err.println(key+req.getHeader(key));
		}
		
		//HttpServletUtil.getServletContext(req, relativePath);
		
	}
	
}
