package org.hy.commons.web.http;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import org.hy.server.jetty8.JettyUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientUtilTest {
	

	
	@Test
	public void testVisitUrlWithPostMethod() throws InterruptedException {
		JettyUtil.getServer();
		
		JettyUtil.setAppContextPath(JettyUtil.MY_APP);
		JettyUtil.getServletContextHandler().addServlet(HttpClientUtilTestServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();
		
		NameValuePair nameValuePair = new NameValuePair();
		nameValuePair.setName("username");
		nameValuePair.setValue("ttt");
		HttpClientUtil.visitUrlWithPostMethod(JettyUtil.WHOLE_URL, "utf-8", new NameValuePair[]{nameValuePair});
		Thread.sleep(1000);
		JettyUtil.stopServer();
	}
	
	@Test
	public void testVisitUrlWithGetMethod() throws InterruptedException {
		JettyUtil.getServer();
		JettyUtil.setAppContextPath(JettyUtil.MY_APP);
		JettyUtil.getServletContextHandler().addServlet(HttpClientUtilTestServlet.class, JettyUtil.HELLO);
		JettyUtil.startServer();
		
		HttpClientUtil.visitUrlWithGetMethod(JettyUtil.WHOLE_URL+"?username=xxx",  "utf-8");
		Thread.sleep(1000);
		JettyUtil.stopServer();
	}
	
	

}
