package org.hy.commons.web.example.filter.dispachertype;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.filter.OneFilter;
import org.hy.commons.web.example.request.dispatcher.DispatcherToServlet_Servlet;
import org.hy.commons.web.filter.FilterUtil;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.servlet.HttpServletUtil;
import org.hy.server.jetty8.JettyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FilterTestServlet_RequestDispacher implements Filter{

	Logger logger = LoggerFactory.getLogger(getClass());
	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addFilter(FilterTestServlet_RequestDispacher.class, "/*", JettyUtil.getDispatcherTypes());
		JettyUtil.getWebAppContext().addServlet(DispatcherToServlet_Servlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();

		String content = HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		Thread.sleep(1000);

		JettyUtil.stopServer();
		System.err.println(content);
	}
	
	

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req =FilterUtil.convertToHttpServletRequest(request);
		req.getContextPath();
		logger.warn("我拦截了，路径为【" +
				req.getContextPath()+
				"】的【before类型】请求");
		chain.doFilter(request, response);
		logger.warn("我拦截了，路径为【" +				
				req.getContextPath()+
				"】的【after类型】请求");
		
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
}
