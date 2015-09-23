package org.hy.commons.web.response.encoding;

import junit.framework.TestCase;

import org.eclipse.jetty.server.Server;
import org.hy.commons.web.example.response.encoding.SendCNServlet;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;

public class SendCNServletTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testT() throws InterruptedException {
		Server server =JettyUtil.getServer();
		JettyUtil.setAppContextPath(HttpClientUtil.MY_APP);
		JettyUtil.addServlet(SendCNServlet.class, HttpClientUtil.HELLO);
		JettyUtil.startServer();
		String content = HttpClientUtil.visitUrl(HttpClientUtil.WHOLE_URL);
		Thread.sleep(1000);
		JettyUtil.stopServer();
		System.out.println(content);
	}

}
