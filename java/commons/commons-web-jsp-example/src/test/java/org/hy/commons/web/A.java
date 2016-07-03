package org.hy.commons.web;

import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.hy.commons.web.test.AbstractJettyTest;
import org.junit.After;
import org.junit.Test;

public class A extends AbstractJettyTest{
	@After
	public void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown(10000000);
	}
	
	@Test
	public void name() throws Exception {
		startServer(S.class);
		
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

