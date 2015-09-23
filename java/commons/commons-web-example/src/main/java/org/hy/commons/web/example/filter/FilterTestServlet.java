package org.hy.commons.web.example.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.request.dispatcher.DispatcherToServlet_Servlet;
import org.hy.commons.web.example.request.dispatcher.TestRequestServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;

public class FilterTestServlet extends HttpServlet {

	public static void main(String[] args) throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP, ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addFilter(OneFilter.class, "/*", JettyUtil.getDispatcherTypes("request"));
		JettyUtil.getWebAppContext().addServlet(FilterTestServlet.class, JettyUtil.HELLO);
//		JettyUtil.getWebAppContext().addServlet(TestRequestServlet.class, "/testRequestServlet");
		JettyUtil.startServer();

		String content = HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		Thread.sleep(1000);

		JettyUtil.stopServer();
		System.err.println(content);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		super.doGet(req, resp);
	}
}
