package org.hy.commons.web.example.request.dispatcher;

import static org.junit.Assert.*;

import java.net.URLEncoder;

import org.eclipse.jetty.server.Server;
import org.hy.commons.io.core.IoUtil;
import org.hy.commons.web.example.request.encoding.GetCNDataRequestServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RequestDispatcherServletTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws InterruptedException {
		Server server =JettyUtil.getServer();
		JettyUtil.setAppContextPath(HttpClientUtil.MY_APP);
		JettyUtil.addServlet(DispatcherToServlet_Servlet.class, HttpClientUtil.HELLO);
		JettyUtil.addServlet(TestRequestServlet.class, "/testRequestServlet");
		JettyUtil.startServer();
//		String encode = URLEncoder.encode("中文" ,IoUtil.DEFAULT_CHARSET);
//		String encode = URLEncoder.encode("中文" ,IoUtil.DEFAULT_CHARSET);

		String content = HttpClientUtil.visitUrl(HttpClientUtil.WHOLE_URL);
		Thread.sleep(1000);
		JettyUtil.stopServer();
		System.err.println(content);
	}

	//@Test
	public void testDoPostHttpServletRequestHttpServletResponse() {
		fail("Not yet implemented");
	}

}
