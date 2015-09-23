package org.hy.commons.web.example.servlet.io;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.test.AbstractJettyTest;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OneServletTest extends AbstractJettyTest{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testDoGetHttpServletRequestHttpServletResponse() throws Exception {
		startServer(OneServlet.class);
		HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL+"?xx=yy");
	}

	@Test
	public void testDoPostHttpServletRequestHttpServletResponse() throws Exception {
		startServer(OneServlet.class);
		Map<String, String> map = new HashMap<String, String>();
		map.put("xx", "jk");
		HttpClientUtil.visitUrlWithPostMethod(JettyUtil.WHOLE_URL,"utf8");
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
