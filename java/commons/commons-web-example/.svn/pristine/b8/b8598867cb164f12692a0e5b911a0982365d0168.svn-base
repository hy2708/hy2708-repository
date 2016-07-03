package org.hy.commons.web.example.cookie.cn;

import static org.junit.Assert.*;

import org.hy.commons.io.core.ProjectPathUtil;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CnCookieServletTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws InterruptedException {
		JettyUtil.getServer();

		JettyUtil.setAppContextPath(JettyUtil.MY_APP,ProjectPathUtil.getWebRootPath());
		JettyUtil.getWebAppContext().addServlet(CnCookieServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();
		//HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		//HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		Thread.sleep(50000);
		JettyUtil.stopServer();
	}

}
