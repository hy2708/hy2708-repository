package org.hy.commons.web.filter.compress;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.hy.commons.web.filter.compress.GzipCompressionFilter;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.test.AbstractJettyTest;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GzipCompressionFilterTest extends AbstractJettyTest{

	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void test() throws Exception {
		startServer(TestCompressionServlet.class);
		HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);

	}
	
	@Override
	protected void configureFilters(WebAppContext context,
			List<Class<? extends Filter>> filters,
			List<FilterHolder> filterHolders, Map<Class<Filter>, String> map) {
		filters.add(GzipCompressionFilter.class);
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
