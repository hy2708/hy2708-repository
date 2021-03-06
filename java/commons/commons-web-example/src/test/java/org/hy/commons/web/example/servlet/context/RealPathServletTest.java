package org.hy.commons.web.example.servlet.context;

import static org.junit.Assert.*;

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.hy.commons.io.core.IoUtil;
import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.example.request.dispatcher.DispatcherToServlet_Servlet;
import org.hy.commons.web.example.request.dispatcher.TestRequestServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RealPathServletTest {

	public static void main(String[] args) {
		Server server =JettyUtil.getServer();
		JettyUtil.setAppContextPath(HttpClientUtil.MY_APP,ProjectPathUtil.getWebRootPath());
		JettyUtil.startServer();
		
	}
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		JettyUtil.stopServer();
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws InterruptedException {
		Server server =JettyUtil.getServer();
		
		
		String webRootResource = ProjectPathUtil.getWebRootPath();
		System.err.println(webRootResource);
		WebAppContext webAppContext = JettyUtil.setAppContextPath(HttpClientUtil.MY_APP,webRootResource);

		JettyUtil.getWebAppContext().addServlet(RealPathServlet.class, HttpClientUtil.HELLO);
//		JettyUtil.addServlet(TestRequestServlet.class, "/testRequestServlet");
		JettyUtil.startServer();
//		String encode = URLEncoder.encode("中文" ,IoUtil.DEFAULT_CHARSET);
//		String encode = URLEncoder.encode("中文" ,IoUtil.DEFAULT_CHARSET);

		String content = HttpClientUtil.visitUrl(HttpClientUtil.WHOLE_URL);
		Thread.sleep(1000);
		JettyUtil.stopServer();
		
	}

	//@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

}
