package org.hy.commons.web.example.filterchain;

import java.util.List;
import java.util.Map;

import javax.servlet.Filter;

import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.hy.commons.web.example.filter.FilterTestServlet;
import org.hy.commons.web.example.filter.FirstFilter;
import org.hy.commons.web.example.filter.SecondFilter;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.commons.web.test.AbstractJettyTest;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.Test;

public class T extends AbstractJettyTest{
	
	@After
	@Override
	public void tearDown() throws Exception {
		// TODO Auto-generated method stub
		super.tearDown();
	}
	@Override
	protected void configureFilters(WebAppContext context,
			List<Class<? extends Filter>> filters,
			List<FilterHolder> filterHolders, Map<Class<Filter>, String> map) {
		filters.add(FirstFilter.class);
		filters.add(SecondFilter.class);
	}
	@Test
	public void test() throws Exception {
		startServer(FilterTestServlet.class);
		HttpClientUtil.visitUrl(JettyUtil.WHOLE_URL);
		Thread.currentThread().sleep(1000);
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
