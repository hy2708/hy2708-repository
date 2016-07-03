package org.hy.commons.web.example.listener.session;

import static org.junit.Assert.*;

import java.util.Map;

import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.test.AbstractJettyTest;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HttpSessionAttributeHandlerTest extends AbstractJettyTest{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testAttributeAdded() throws Exception {
		HttpSessionAttributeHandler handler = new HttpSessionAttributeHandler();
		startServer(handler);
		HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
	}

	@Test
	public void testAttributeRemoved() {
		fail("Not yet implemented");
	}

	@Test
	public void testAttributeReplaced() {
		fail("Not yet implemented");
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
