// Copyright (c) 2003-2014, Jodd Team (jodd.org). All Rights Reserved.

package org.hy.commons.net.http;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import jodd.http.HttpBrowser;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;

import org.eclipse.jetty.server.Server;
import org.hy.commons.web.http.HttpClientUtil;
import org.hy.server.jetty8.HelloServerlet;
import org.hy.server.jetty8.JettyUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HttpBrowserTest {
	
	//static TestServer testServer;

	@BeforeClass
	public static void startServer() throws Exception {
		//testServer = new TomcatServer();
		//estServer.start();
	}

	@AfterClass
	public static void stopServer() throws Exception {
		//testServer.stop();
	}
	
	@Before
	public void setUp() {
		Server server =JettyUtil.getServer();
		JettyUtil.setAppContextPath(HttpClientUtil.MY_APP);
		JettyUtil.addServlet(HelloServerlet.class, 
				//"/echo"
				HttpClientUtil.HELLO
				);
		JettyUtil.startServer();
		//String content = HttpClientUtil.visitUrl(HttpClientUtil.WHOLE_URL);
		
		//System.err.println(content);
		
		//EchoServlet.testinit();
	}
	
	@After
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		JettyUtil.stopServer();
	}

	@Test
	public void testBrowser() {
		HttpBrowser httpBrowser = new HttpBrowser();
		
		httpBrowser.sendRequest(
				HttpRequest.get(
						HttpClientUtil.WHOLE_URL//"localhost:8080/echo?id=17"
						)//.bodyText("hello"));
		HttpResponse httpResponse = httpBrowser.getHttpResponse();
		assertNotNull(httpResponse);
		assertEquals("hello", httpResponse.body());
		 
		//String content = HttpClientUtil.visitUrl(HttpClientUtil.WHOLE_URL);
		
		//System.err.println(content);
	}
	
}