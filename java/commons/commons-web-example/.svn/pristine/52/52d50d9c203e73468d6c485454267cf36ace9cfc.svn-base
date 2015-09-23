package org.hy.commons.web.example.listener.session;

import static org.junit.Assert.*;

import java.util.EventListener;
import java.util.Map;

import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.test.AbstractJettyTest;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SessionCreationServletTest extends AbstractJettyTest{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testHandleRequest() throws Exception {
		HttpSessionHandler2 handler = new HttpSessionHandler2();
		EventListener[] listener = new EventListener[]{handler};
		startServer(listener, null, SessionCreationServlet.class);
		for (int i = 0; i < 10; i++) {
			HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);			
		}
		HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL+"?methodName=showSessions");			
	}

	@Test
	public void testShowSessions() {
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
