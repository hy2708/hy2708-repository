package org.hy.commons.web.example.request.ip;

import static org.junit.Assert.*;

import java.util.Map;

import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.test.AbstractJettyTest;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IPServletTest extends AbstractJettyTest{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws Exception {
		startServer(IPServlet.class);
		HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
	}

	@Override
	protected void initServlet(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		
	}

}
